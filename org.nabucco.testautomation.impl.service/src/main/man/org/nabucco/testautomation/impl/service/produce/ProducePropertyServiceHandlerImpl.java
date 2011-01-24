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
package org.nabucco.testautomation.impl.service.produce;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.testautomation.facade.datatype.PropertyFactory;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.message.ProducePropertyMsg;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.impl.service.produce.ProducePropertyServiceHandler;

/**
 * ProducePropertyServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProducePropertyServiceHandlerImpl extends ProducePropertyServiceHandler {

	private static final long serialVersionUID = 1L;
	
	public PropertyMsg produceProperty(
			ProducePropertyMsg msg) throws ProduceException {

		if (msg.getPropertyType() == null) {
			throw new ProduceException("No PropertyType defined");
		}
		
		PropertyMsg rs = new PropertyMsg();
		Property property = PropertyFactory.getInstance().produceProperty(msg.getPropertyType());
		
		if (property == null) {
			throw new ProduceException("Unsupported PropertyType requested: " + msg.getPropertyType());
		}
		
		Name name = msg.getName();
		
		if (name != null && name.getValue() != null) {
			property.setName(name);
		}
		
		PropertyContainer container = new PropertyContainer();
		container.setDatatypeState(DatatypeState.INITIALIZED);
		container.setProperty(property);
		rs.setProperty(property);
		rs.setPropertyContainer(container);
		return rs;
	}
	
}
