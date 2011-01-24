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
package org.nabucco.testautomation.ui.rcp.multipage.engine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationListMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.ui.rcp.communication.TestautomationComponentServiceDelegateFactory;
import org.nabucco.testautomation.ui.rcp.communication.produce.ProduceTestEngineConfigurationDelegate;
import org.nabucco.testautomation.ui.rcp.communication.search.SearchTestEngineConfigurationDelegate;


public class EngineElementFactory {

	private static TestautomationComponentServiceDelegateFactory serviceDelegateFactory = TestautomationComponentServiceDelegateFactory.getInstance();

	private static Map<Class<?>, Datatype> cache = new HashMap<Class<?>, Datatype>();

	public static Datatype create(Class<?> className) {
		Datatype cachedElement = cache.get(className);
		if (cachedElement != null) {
			return cachedElement.cloneObject();
		}
		Datatype result = null;
		try {
			if (className.equals(TestEngineConfiguration.class)) {
				ProduceTestEngineConfigurationDelegate produceTestEngineConfigurationDelegate = serviceDelegateFactory.getProduceTestEngineConfiguration();
				TestEngineConfigurationMsg response = produceTestEngineConfigurationDelegate.produceTestEngineConfiguration(new EmptyServiceMessage());
				if (response != null) {
					TestEngineConfiguration configuration = response.getTestEngineConfiguration();
					result = configuration;
				}
			} else if (className.equals(ProxyConfiguration.class)) {
				ProduceTestEngineConfigurationDelegate produceTestEngineConfigurationDelegate = serviceDelegateFactory.getProduceTestEngineConfiguration();
				TestEngineConfigurationMsg response = produceTestEngineConfigurationDelegate.produceProxyConfiguration(new EmptyServiceMessage());
				if (response != null) {
					ProxyConfiguration configuration = response.getProxyConfiguration();
					result = configuration;
				}
			} else if (className.equals(ConfigurationProperty.class)) {
				ProduceTestEngineConfigurationDelegate produceTestEngineConfigurationDelegate = serviceDelegateFactory.getProduceTestEngineConfiguration();
				TestEngineConfigurationMsg response = produceTestEngineConfigurationDelegate.produceConfigurationProperty(new EmptyServiceMessage());
				if (response != null) {
					ConfigurationProperty configuration = response.getConfigurationProperty();
					result = configuration;
				}
			}
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		cache.put(className, result.cloneObject());
		return result;
	}

	public static List<ProxyConfiguration> getExistingElements(Class<? extends Datatype> clazz) {
		if (clazz.equals(ProxyConfiguration.class)) {
			try {
				SearchTestEngineConfigurationDelegate searchTestEngineConfigurationDelegate = serviceDelegateFactory.getSearchTestEngineConfiguration();
				ProxyConfigurationListMsg response = searchTestEngineConfigurationDelegate.searchProxyConfiguration(new EmptyServiceMessage());
				if (response != null) {
					List<ProxyConfiguration> proxyConfigurations = response.getProxyConfigurationList();
					return proxyConfigurations;
				}
			} catch (ClientException e) {
				Activator.getDefault().logError(e);
			}
		} 
		return null;
	}
	
	public static Datatype cloneProxyConfiguration(ProxyConfiguration proxyConfiguration) {
		ProduceTestEngineConfigurationDelegate produceTestEngineConfiguration;
		try {
			produceTestEngineConfiguration = serviceDelegateFactory.getProduceTestEngineConfiguration();
			ProxyConfigurationMsg rq = new ProxyConfigurationMsg();
			rq.setProxyConfiguration(proxyConfiguration);
			ProxyConfigurationMsg rs = produceTestEngineConfiguration.produceProxyConfigurationClone(rq);
			return rs.getProxyConfiguration();
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return null;
	}

	public static Datatype cloneConfigurationProperty(ConfigurationProperty configurationProperty) {
		ProduceTestEngineConfigurationDelegate produceTestEngineConfiguration;
		try {
			produceTestEngineConfiguration = serviceDelegateFactory.getProduceTestEngineConfiguration();
			ConfigurationPropertyMsg rq = new ConfigurationPropertyMsg();
			rq.setConfigurationProperty(configurationProperty);
			ConfigurationPropertyMsg rs = produceTestEngineConfiguration.produceConfigurationPropertyClone(rq);
			return rs.getConfigurationProperty();
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return null;
	}

	

}
