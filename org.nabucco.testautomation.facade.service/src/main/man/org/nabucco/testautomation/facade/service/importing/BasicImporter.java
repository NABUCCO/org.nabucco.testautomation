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
package org.nabucco.testautomation.facade.service.importing;

import java.util.List;

import javax.persistence.EntityManager;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.importing.ImportContainer;
import org.nabucco.framework.base.facade.datatype.importing.ImportContext;
import org.nabucco.framework.base.facade.datatype.importing.ImportContextEntry;
import org.nabucco.framework.base.facade.datatype.serialization.DeserializationData;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationException;
import org.nabucco.framework.base.facade.datatype.serialization.xml.XmlSerializer;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;

/**
 * BasicImporter
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public abstract class BasicImporter {

	private EntityManager em;
	
	private PersistenceHelper helper;
	
	private ImportContext importContext;
	
	/**
	 * 
	 * @param em
	 * @param importContext
	 */
	protected BasicImporter(EntityManager em, ImportContext importContext) {
		this.em = em;
		this.helper = new PersistenceHelper(em);
		this.importContext = importContext;
	}
	
	/**
	 * 
	 * @param importContainer
	 * @throws ImportException
	 */
	public void handleImport(ImportContainer importContainer) throws ImportException {
		
            try {
            	// Deserialization
            	List<Datatype> deserialized = deserialize(importContainer);
	
	            // Delete all existing entities of the importing owner
	            this.deleteAll(this.getOwner());
	            
	            // Import all entities
	            this.importContext.getEntries().addAll(this.importAll(deserialized));
	            
        } catch (SerializationException ex) {
            throw new ImportException("Deserialization of ImportData failed !", ex);
        }
	}
	
	/**
	 * 
	 * @param importContainer
	 * @return
	 * @throws SerializationException
	 */
	protected List<Datatype> deserialize(ImportContainer importContainer) throws SerializationException {
		
		XmlSerializer xmlSerializer = new XmlSerializer();
        DeserializationData data = new DeserializationData(importContainer.getContent().getValue());
        data.setResourceData(importContainer.getResourceData().getValue());
        
        List<Datatype> deserialized = xmlSerializer.deserialize(data);
        return deserialized;
	}
	
	/**
	 * 
	 * @param datatypes
	 * @return
	 * @throws ImportException
	 */
	protected abstract List<ImportContextEntry> importAll(List<Datatype> datatypes) throws ImportException;
	
	/**
	 * 
	 * @param owner
	 * @throws ImportException
	 */
	protected abstract void deleteAll(Owner owner) throws ImportException;
	
	/**
	 * 
	 * @return
	 * @throws PersistenceException 
	 */
	protected NabuccoDatatype create(NabuccoDatatype datatype) throws PersistenceException {
		datatype.setDatatypeState(DatatypeState.INITIALIZED);
		datatype.setId((Identifier) null);
		return this.helper.persist(datatype);
	}
	
	/**
	 * 
	 * @return
	 * @throws PersistenceException 
	 */
	protected NabuccoDatatype modify(NabuccoDatatype datatype) throws PersistenceException {
		datatype.setDatatypeState(DatatypeState.MODIFIED);
		return this.helper.persist(datatype);
	}
	
	/**
	 * 
	 * @return
	 * @throws PersistenceException 
	 */
	protected void delete(NabuccoDatatype datatype) throws PersistenceException {
		datatype.setDatatypeState(DatatypeState.DELETED);
		this.helper.persist(datatype);
	}
	
	/**
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	/**
	 * 
	 * @return
	 */
	protected ImportContext getImportContext() {
		return this.importContext;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws ImportException
	 */
	protected ImportContextEntry maintain(NabuccoDatatype entity)
			throws ImportException {

		ImportContextEntry result = new ImportContextEntry();
		result.setOldId(entity.getId());
		result.setTypeName(entity.getClass().getName());

		try {
			entity = create(entity);
		} catch (PersistenceException ex) {
			throw new ImportException("Unable to import "
					+ entity.getClass().getSimpleName(), ex);
		}
		result.setNewId(entity.getId());
		return result;
	}
	
	/**
	 * 
	 * @param oldId
	 * @param className
	 * @return
	 */
	protected Long getNewRefId(Long oldId, String className) {

		for (ImportContextEntry entry : this.importContext.getEntries()) {
			if (entry.getTypeName().getValue().equals(className)
					&& entry.getOldId().getValue().equals(oldId)) {
				return entry.getNewId().getValue();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param datatypes
	 * @return
	 */
	protected Owner getOwner() {
		return this.getImportContext().getOwner();
	}
	
}
