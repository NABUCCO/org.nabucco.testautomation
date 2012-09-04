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

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationSearchMsg;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;
import org.nabucco.testautomation.impl.service.produce.ProduceProxyConfigurationCloneServiceHandler;
import org.nabucco.testautomation.impl.service.produce.clone.TestEngineConfigurationCloneVisitor;

/**
 * ProduceProxyConfigurationCloneServiceHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class ProduceProxyConfigurationCloneServiceHandlerImpl extends ProduceProxyConfigurationCloneServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected ProxyConfigurationMsg produceProxyConfigurationClone(ProxyConfigurationMsg msg) throws ProduceException {
		ProxyConfiguration element = msg.getProxyConfiguration();
    	
    	if (element == null) {
    		throw new ProduceException("No TestEngineConfiguration to clone");
    	}
    	
    	if (element.getId() == null) {
    		element = copy(element);
    	} else {
    		element = clone(element);
    	}
    	
		msg.setProxyConfiguration(element);
        return msg;
    }
    
    private ProxyConfiguration copy(ProxyConfiguration element) throws ProduceException {
    	
    	// Clone
    	TestEngineConfigurationCloneVisitor cloneVisitor = new TestEngineConfigurationCloneVisitor();
    	ProxyConfiguration clonedObject = element.cloneObject();
        try {
			clonedObject.accept(cloneVisitor);
		} catch (VisitorException ex) {
			throw new ProduceException(ex);
		}
        return clonedObject;
    }
    
    private ProxyConfiguration clone(ProxyConfiguration element) throws ProduceException {
    	try {
    		// Load TestConfigElement deep
    		SearchTestEngineConfiguration search = TestautomationComponentLocator.getInstance().getComponent().getSearchTestEngineConfiguration();
    		ServiceRequest<ProxyConfigurationSearchMsg> rq = new ServiceRequest<ProxyConfigurationSearchMsg>(getContext());
    		ProxyConfigurationSearchMsg message = new ProxyConfigurationSearchMsg();
    		message.setId(new Identifier(element.getId()));
			rq.setRequestMessage(message);
			element = search.getProxyConfiguration(rq).getResponseMessage().getProxyConfiguration();
    		
			// Clone
			TestEngineConfigurationCloneVisitor cloneVisitor = new TestEngineConfigurationCloneVisitor();
			ProxyConfiguration clonedObject = element.cloneObject();
            clonedObject.accept(cloneVisitor);
            return clonedObject;
        } catch (VisitorException ex) {
            throw new ProduceException(ex);
        } catch (ServiceException ex) {
        	throw new ProduceException(ex);
		} catch (ConnectionException ex) {
			throw new ProduceException(ex);
		}
    }

}
