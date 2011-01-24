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
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.impl.service.produce.ProducePropertyCloneServiceHandler;
import org.nabucco.testautomation.impl.service.produce.clone.PropertyCloneVisitor;

/**
 * ProducePropertyServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProducePropertyCloneServiceHandlerImpl extends ProducePropertyCloneServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected PropertyMsg producePropertyClone(PropertyMsg msg)
			throws ProduceException {

		Property orgProperty = msg.getProperty();

		if (orgProperty == null) {
			throw new ProduceException("No Property to clone");
		}
		
		PropertyMsg rs = new PropertyMsg();
		Property clone = orgProperty.cloneObject();
		
		try {
			PropertyCloneVisitor visitor = new PropertyCloneVisitor();
			clone.accept(visitor);
		} catch (VisitorException e) {
			throw new ProduceException("Could not clone Property: " + e.getMessage());
		}
		
		PropertyContainer container = new PropertyContainer();
		container.setDatatypeState(DatatypeState.INITIALIZED);
		container.setProperty(clone);
		rs.setProperty(clone);
		rs.setPropertyContainer(container);
		return rs;
	}

}
