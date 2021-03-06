/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.impl.service.maintain;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceExceptionMapper;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.testautomation.facade.datatype.comparator.PropertySorter;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComponent;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.datatype.visitor.PropertyModificationVisitor;
import org.nabucco.testautomation.facade.message.PropertyMsg;


/**
 * MaintainPropertyServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainPropertyServiceHandlerImpl extends MaintainPropertyServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private static final String PREFIX = "PROP-";
	
	private static final PropertySorter propertySorter = new PropertySorter();
	
	private PersistenceHelper helper;

	@Override
	public PropertyMsg maintainProperty(PropertyMsg msg)
			throws MaintainException {
		Property property = msg.getProperty();
		property = maintain(property);
		msg.setProperty(property);
		return msg;
	}
	
	private Property maintain(Property property) throws MaintainException {
		
		try {
			// init PersistenceHelper
			this.helper = new PersistenceHelper(super.getEntityManager());
			
			// Check Property for modification
			if (property.getDatatypeState() == DatatypeState.PERSISTENT
					&& property instanceof PropertyComposite) {
	            DatatypeVisitor visitor = new PropertyModificationVisitor(
	            		(PropertyComposite) property);
	            property.accept(visitor);
	        }
			
            switch (property.getDatatypeState()) {

            case CONSTRUCTED:
                throw new MaintainException("Property is not initialized.");
            case INITIALIZED:
                property = this.create(property);
                break;
            case MODIFIED:
            	property = this.update(property);
                break;
            case DELETED:
            	this.delete(property);
            	property = null;
                break;
            case TRANSIENT:
                break;
            case PERSISTENT:
                break;
            default:
                throw new MaintainException("Datatype state '"
                        + property.getDatatypeState()
                        + "' is not valid for Property.");
            }
        } catch (MaintainException ex) {
        	throw ex;
        } catch (Exception ex) {
			throw new MaintainException("Error maintaining Property",
					PersistenceExceptionMapper.resolve(ex,
							Property.class.getName(),
							property.getId()));
        }
        
        this.helper.flush();
        this.helper = null;
        
        if (property != null) {
        	load(property);
        	
        	// Detach Entities
        	this.getEntityManager().clear();
        	
        	// Sort
        	propertySorter.sort(property);
        }
        return property;
	}
	
	private void load(Property property) {
		
		if (property instanceof PropertyComposite) {
			PropertyComposite propertyComposite = (PropertyComposite) property;
			List<PropertyContainer> propertyList = propertyComposite.getPropertyList();
			
			for (PropertyContainer child : propertyList) {
				child.setDatatypeState(DatatypeState.PERSISTENT);
				load(child.getProperty());
			}
		}
		property.setDatatypeState(DatatypeState.PERSISTENT);
	}
	
	protected Property create(Property entity)
			throws PersistenceException {
		
		if (entity instanceof PropertyComponent) {
			entity = this.helper.persist(entity);
		} else if (entity instanceof PropertyComposite) {
			entity = createChildren((PropertyComposite) entity);
		}
		
		// Generate PropertyKey
		entity.setIdentificationKey(PREFIX + entity.getId());
		entity.setDatatypeState(DatatypeState.MODIFIED);
		entity = this.helper.persist(entity);
		return entity;
	}
	
	private Property createChildren(PropertyComposite property) throws PersistenceException {
		
		List<PropertyContainer> children = property.getPropertyList();
		
		for (int i = 0; i < children.size(); i++) {
			PropertyContainer childContainer = children.get(i);
			Property prop = childContainer.getProperty();
			
			switch (prop.getDatatypeState()) {
			case INITIALIZED:
				prop = this.create(prop);
				break;
			case MODIFIED:
				prop = this.update(prop);
				break;
			}
			childContainer.setProperty(prop);
			childContainer = this.helper.persist(childContainer);
			children.set(i, childContainer);
		}
		
		this.helper.persist(property);
		return property;
	}

	protected Property update(Property entity) throws PersistenceException {
		
		if (entity instanceof PropertyComponent) {
			entity = this.helper.persist(entity);
		} else if (entity instanceof PropertyComposite) {
			entity = updateChildren((PropertyComposite) entity);
		}
		return entity;
	}
	
	private Property updateChildren(PropertyComposite property) throws PersistenceException {
		
		List<PropertyContainer> children = property.getPropertyList();
		List<PropertyContainer> removedChildren = NabuccoCollectionAccessor.getInstance().getUnassignedList(children);
		
		for (int i = 0; i < children.size(); i++) {
			PropertyContainer child = children.get(i);
			Property childProp = child.getProperty();
			
			switch (childProp.getDatatypeState()) {
			case INITIALIZED:
				childProp = this.create(childProp);
				break;
			case MODIFIED:
				childProp = this.update(childProp);
				break;
			case PERSISTENT:
				if (childProp instanceof PropertyComposite) {
					childProp = updateChildren((PropertyComposite) childProp);
				}
				break;
			}
			child.setProperty(childProp);
			child = this.helper.persist(child);
			children.set(i, child);
		}
		
		for (PropertyContainer propertyContainer : removedChildren) {
			
			// Do not delete TestScriptElementContainer that were moved by Drag&Drop
			if (propertyContainer.getDatatypeState() != DatatypeState.DELETED) {
				continue;
			}
			this.helper.persist(propertyContainer);
			delete(propertyContainer.getProperty());
		}
		
		this.helper.persist(property);
		return property;
	}
	
	protected void delete(Property entity)
		throws PersistenceException {

		if (entity instanceof PropertyComponent) {
			entity.setDatatypeState(DatatypeState.DELETED);
			this.helper.persist(entity);
		} else if (entity instanceof PropertyComposite) {
			delete((PropertyComposite) entity);
		}
	}
	
	protected void delete(PropertyComposite entity)
		throws PersistenceException {
	
		List<PropertyContainer> children = entity.getPropertyList();
		
		for (PropertyContainer propertyContainer : children) {
			propertyContainer.setDatatypeState(DatatypeState.DELETED);
			this.helper.persist(propertyContainer);
			delete(propertyContainer.getProperty());
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		this.helper.persist(entity);		
	}
	
}
