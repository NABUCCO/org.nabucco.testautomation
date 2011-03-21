/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.validation.constraint.element.ConstraintFactory;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.facade.datatype.comparator.PropertySorter;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.message.PropertyListMsg;
import org.nabucco.testautomation.facade.message.PropertySearchMsg;
import org.nabucco.testautomation.impl.service.search.SearchPropertyServiceHandler;


/**
 * SearchPropertyServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchPropertyServiceHandlerImpl extends SearchPropertyServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private static final PropertySorter propertySorter = new PropertySorter();
	
	@Override
	public PropertyListMsg searchProperty(PropertySearchMsg msg)
			throws SearchException {

		StringBuilder queryString = new StringBuilder();
		queryString.append("FROM Property p");

		List<String> filter = new ArrayList<String>();
        
		if (msg.getOwner() != null && msg.getOwner().getValue() != null) {
			filter.add("p.owner = :owner");
		}
		
		if (msg.getPropertyId() != null && msg.getPropertyId().getValue() != null) {
			filter.add("p.id = :id");
		} else {
			if (msg.getPropertyName() != null && msg.getPropertyName().getValue() != null) {
				filter.add("p.name = :name");
			}
			if (msg.getPropertyType() != null) {
				filter.add("p.type = :type");
			}
			if (msg.getUsageType() != null) {
				filter.add("p.usageType = :usageType");
			}
		}
        
        // append filter criteria
        int filterSize = filter.size();
        
        if (filterSize > 0) {
        	queryString.append(" WHERE ");
            int c = 1;
            for (String str : filter) {
            	queryString.append(str);
                
                if (c++ < filterSize) {
                	queryString.append(" AND ");
                }
            }
        }
        queryString.append(" ORDER BY p.name");
			
		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		
		if (msg.getOwner() != null && msg.getOwner().getValue() != null) {
			query.setParameter("owner", msg.getOwner());
		}
		
		if (msg.getPropertyId() != null && msg.getPropertyId().getValue() != null) {
			query.setParameter("id", msg.getPropertyId().getValue());
		} else {
			if (msg.getPropertyName() != null && msg.getPropertyName().getValue() != null) {
				query.setParameter("name", msg.getPropertyName());
			}
			if (msg.getPropertyType() != null) {
				query.setParameter("type", msg.getPropertyType());
			}
			if (msg.getUsageType() != null) {
				query.setParameter("usageType", msg.getUsageType());
			}
		}

		@SuppressWarnings("unchecked")
		List<Property> resultList = query.getResultList();
		PropertyListMsg rs = new PropertyListMsg();

		if (!resultList.isEmpty()) {
			
			for (Property property : resultList) {
				load(property);
			}
			
			this.getEntityManager().clear();
			
			for (Property property : resultList) {
				
				// Check owner and set Editable-Constraint
				if (!property.getOwner().equals(NabuccoInstance.getInstance().getOwner())) {
					try {
						property.addConstraint(ConstraintFactory.getInstance()
								.createEditableConstraint(false), true);
					} catch (VisitorException ex) {
						throw new SearchException(ex);
					}
				}
				propertySorter.sort(property);
			}
			rs.getPropertyList().addAll(resultList);
		}
		return rs;
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
	
}