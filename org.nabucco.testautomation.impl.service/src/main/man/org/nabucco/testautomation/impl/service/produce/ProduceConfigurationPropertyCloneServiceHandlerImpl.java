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

import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;
import org.nabucco.testautomation.impl.service.produce.ProduceConfigurationPropertyCloneServiceHandler;
import org.nabucco.testautomation.impl.service.produce.clone.TestEngineConfigurationCloneVisitor;

/**
 * ProduceConfigurationPropertyCloneServiceHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class ProduceConfigurationPropertyCloneServiceHandlerImpl extends ProduceConfigurationPropertyCloneServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected ConfigurationPropertyMsg produceConfigurationPropertyClone(ConfigurationPropertyMsg msg) throws ProduceException {
		ConfigurationProperty element = msg.getConfigurationProperty();
    	
    	if (element == null) {
    		throw new ProduceException("No TestEngineConfiguration to clone");
    	}
    	
    	if (element.getId() == null) {
    		element = copy(element);
    	} else {
    		element = clone(element);
    	}
    	
		msg.setConfigurationProperty(element);
        return msg;
    }
    
    private ConfigurationProperty copy(ConfigurationProperty element) throws ProduceException {
    	
    	// Clone
    	TestEngineConfigurationCloneVisitor cloneVisitor = new TestEngineConfigurationCloneVisitor();
    	ConfigurationProperty clonedObject = element.cloneObject();
        try {
			clonedObject.accept(cloneVisitor);
		} catch (VisitorException ex) {
			throw new ProduceException(ex);
		}
        return clonedObject;
    }
    
    private ConfigurationProperty clone(ConfigurationProperty element) throws ProduceException {
    	throw new ProduceException("Cloning of ConfigurationProperty is not implemented");
    }

}
