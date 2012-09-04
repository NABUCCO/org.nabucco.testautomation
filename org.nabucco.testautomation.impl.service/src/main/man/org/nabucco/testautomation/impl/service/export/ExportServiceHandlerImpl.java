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
package org.nabucco.testautomation.impl.service.export;

import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.exporting.ExportContainer;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationException;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationResult;
import org.nabucco.framework.base.facade.datatype.serialization.xml.XmlSerializer;
import org.nabucco.framework.base.facade.exception.exporting.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;

/**
 * ExportServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ExportServiceHandlerImpl extends ExportServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected ExportRs export(EmptyServiceMessage msg)
			throws ExportException {
		
		ExportRs response = new ExportRs();
		response.setContainer(new ExportContainer());
		XmlSerializer xmlSerializer = new XmlSerializer();
		
		long start = System.currentTimeMillis();
		getLogger().info("Loading Properties ...");

		Query query = this.getEntityManager().createQuery("FROM Property p WHERE p.owner = :owner");
		query.setParameter("owner", NabuccoInstance.getInstance().getOwner());
		
		@SuppressWarnings("unchecked")
		List<Property> resultList = query.getResultList();
		
		for (Property property : resultList) {
			load(property);
		}
		getLogger().info(resultList.size() + " Properties loaded. Duration: " + (System.currentTimeMillis() - start) + " ms");
		
		try {
			start = System.currentTimeMillis();
			getLogger().info("Start serializing Testautomation ...");
			SerializationResult serializationResult = xmlSerializer.serialize(resultList, XmlSerializer.DEFAULT_INDENT, true);
			response.getContainer().setResult(serializationResult.getContent());
			response.getContainer().setResourceData(serializationResult.getResourceContainer().toByteArray());
			getLogger().info("Serializing of Testautomation finished. Duration: " + (System.currentTimeMillis() - start) + " ms");
		} catch (SerializationException ex) {
			throw new ExportException("Fatal error during serialization of Testautomation", ex);
		}

        return response;
	}
	
	private void load(Property property) {
		
		if (property instanceof PropertyComposite) {
			PropertyComposite propertyComposite = (PropertyComposite) property;
			List<PropertyContainer> propertyList = propertyComposite.getPropertyList();
			
			for (PropertyContainer child : propertyList) {
				load(child.getProperty());
			}
		}
	}

}
