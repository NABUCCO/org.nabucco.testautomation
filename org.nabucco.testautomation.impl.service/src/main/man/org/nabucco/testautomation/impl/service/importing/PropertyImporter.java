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
package org.nabucco.testautomation.impl.service.importing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.importing.ImportContext;
import org.nabucco.framework.base.facade.datatype.importing.ImportContextEntry;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.testautomation.facade.datatype.property.PropertyList;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.service.importing.BasicImporter;

/**
 * PropertyImporter
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class PropertyImporter extends BasicImporter {

	private final NabuccoLogger logger = NabuccoLoggingFactory.getInstance()
			.getLogger(PropertyImporter.class);
	
	/**
	 * 
	 * @param em
	 * @param importContext
	 */
	public PropertyImporter(EntityManager em, ImportContext importContext) {
		super(em, importContext);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<ImportContextEntry> importAll(List<Datatype> datatypes)
			throws ImportException {
		
		// Import Properties
		List<ImportContextEntry> importedElements = new ArrayList<ImportContextEntry>();
		List<PropertyContainer> containerList = new ArrayList<PropertyContainer>();
		
		for (Datatype current : datatypes) {
			
			if (current instanceof Property) {
				importedElements.add(super.maintain((NabuccoDatatype) current));
				logger.info("Property '" + ((Property) current).getIdentificationKey().getValue() + "' imported");
			} else if (current instanceof PropertyContainer) {
				containerList.add((PropertyContainer) current);
			}
		}
		
		for (PropertyContainer current : containerList) {
			importedElements.add(super.maintain((NabuccoDatatype) current));
		}
		
		return importedElements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll(Owner owner) throws ImportException {
		
		// Find all PropertyLists
		Query query = this.getEntityManager().createQuery("FROM PropertyList p WHERE p.owner = :owner AND p.usageType IS NOT NULL");
		query.setParameter("owner", owner);
		
		@SuppressWarnings("unchecked")
		List<PropertyList> propertyList = query.getResultList();
		
		for (PropertyList list : propertyList) {
			delete(list);
			logger.info("PropertyList '", list.getIdentificationKey().getValue(), "' deleted");
		}
	}
	
	private void delete(PropertyComposite property) throws ImportException {
		
		for (PropertyContainer container : property.getPropertyList()) {
			delete(container);
		}
		
		try {
			super.delete(property);
		} catch (PersistenceException ex) {
			throw new ImportException(ex);
		}		
	}
	
	private void delete(PropertyContainer entity) throws ImportException {
		
		Property property = entity.getProperty();
		
		try {
			super.delete(entity);
		} catch (PersistenceException ex) {
			throw new ImportException(ex);
		}
		
		if (property instanceof PropertyComposite) {
			delete((PropertyComposite) property);
		} else {
			try {
				super.delete(property);
			} catch (PersistenceException ex) {
				throw new ImportException(ex);
			}
		}
	}

}
