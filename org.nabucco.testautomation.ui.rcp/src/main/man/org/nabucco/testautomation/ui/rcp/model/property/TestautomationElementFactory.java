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
package org.nabucco.testautomation.ui.rcp.model.property;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.ui.rcp.communication.TestautomationComponentServiceDelegateFactory;
import org.nabucco.testautomation.ui.rcp.communication.produce.ProducePropertyDelegate;


public class TestautomationElementFactory {

	
	public static PropertyContainer clone(Property property){
        TestautomationComponentServiceDelegateFactory testautomationComponentServiceDelegateFactory = TestautomationComponentServiceDelegateFactory.getInstance();
        ProducePropertyDelegate produceProperty;
		try {
			produceProperty = testautomationComponentServiceDelegateFactory.getProduceProperty();
        PropertyMsg rq = new PropertyMsg();
        rq.setProperty(property);
        PropertyMsg rs = produceProperty.producePropertyClone(rq);
        return rs.getPropertyContainer();
		} catch (ClientException e) {
			 Activator.getDefault().logError(e);
		}
		return null;
    }
	
}
