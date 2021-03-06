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
package org.nabucco.testautomation.impl.service.produce;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.impl.service.produce.ProduceConfigurationPropertyServiceHandler;

/**
 * ProduceConfigurationPropertyServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProduceConfigurationPropertyServiceHandlerImpl extends
		ProduceConfigurationPropertyServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected TestEngineConfigurationMsg produceConfigurationProperty(
			EmptyServiceMessage msg) throws ProduceException {

		TestEngineConfigurationMsg rs = new TestEngineConfigurationMsg();
		ConfigurationProperty property = new ConfigurationProperty();
		property.setDatatypeState(DatatypeState.INITIALIZED);
		property.setName("Enter name ...");
		rs.setConfigurationProperty(property);
		return rs;
	}

}
