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
package org.nabucco.testautomation.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.impl.service.DynamicCodeSupport;


/**
 * GetTestEngineConfigurationServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class GetTestEngineConfigurationServiceHandlerImpl extends
		GetTestEngineConfigurationServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected TestEngineConfigurationMsg getTestEngineConfiguration(
			TestEngineConfigurationSearchMsg msg) throws SearchException {
		
		if ((msg.getUser() == null || msg.getUser().getId() == null)
				&& (msg.getId() == null || msg.getId().getValue() == null)) {
			throw new SearchException("Mandatory Id is not set");
		}
		
		StringBuilder queryString = new StringBuilder();
		queryString.append("FROM TestEngineConfiguration c ");

		if (msg.getUser() != null && msg.getUser().getId() != null) {
			queryString.append("WHERE c.userRefId = :refId");
		} else {
			queryString.append("WHERE c.id = :id");
		}
		
		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		
		if (msg.getUser() != null && msg.getUser().getId() != null) {
			query.setParameter("refId", msg.getUser().getId());
		} else {
			query.setParameter("id", msg.getId().getValue());
		}
		
		@SuppressWarnings("unchecked")
		List<TestEngineConfiguration> results = (List<TestEngineConfiguration>) query.getResultList();
		TestEngineConfiguration result = null;

		if (results.isEmpty()) {
			throw new SearchException("No TestEngineConfiguration found");
		} else {
			result = results.get(0);
		}
		
		List<ProxyConfiguration> proxyConfigurations = result.getProxyConfigurations();
			
		// Filter ProxyConfigurations for selected Environment
		
		// FIXME must be fixed, when maintenance of TestEngineConfigurations is available
		
//		if (msg.getEnvironmentType() != null) {
//			List<ProxyConfiguration> tmp = new ArrayList<ProxyConfiguration>(proxyConfigurations);
//					
//			for (ProxyConfiguration proxyConfiguration : tmp) {
//				
//				if (proxyConfiguration.getEnvironmentTypeRefId() != null
//						&& !proxyConfiguration.getEnvironmentTypeRefId()
//								.equals(msg.getEnvironmentType().getId())) {
//					proxyConfigurations.remove(proxyConfiguration);
//				}
//			}
//		}
		
		// Filter ProxyConfigurations for selected Release
//		if (msg.getReleaseType() != null) {
//			List<ProxyConfiguration> tmp = new ArrayList<ProxyConfiguration>(proxyConfigurations);
//					
//			for (ProxyConfiguration proxyConfiguration : tmp) {
//				
//				if (proxyConfiguration.getReleaseTypeRefId() != null
//						&& !proxyConfiguration.getReleaseTypeRefId().equals(
//								msg.getReleaseType().getId())) {
//					proxyConfigurations.remove(proxyConfiguration);
//				}
//			}
//		}
		
		List<ProxyConfiguration> disabledProxyConfigurations = new ArrayList<ProxyConfiguration>();
		
		// Resolve ProxyConfigurations
		for (ProxyConfiguration config : proxyConfigurations) {
			
			// Do not load disabled ProxyConfigurations
			if (config.getEnabled() == null || config.getEnabled().getValue() == null || !config.getEnabled().getValue().booleanValue()) {
				disabledProxyConfigurations.add(config);
				continue;
			}
			
			// Load ProxyConfiguration deep
			for (ConfigurationProperty configProp : config.getConfigurationProperties()) {
				configProp.setDatatypeState(DatatypeState.PERSISTENT);
			}
			
			try {
				if (config.getReleaseTypeRefId() != null) {
					Code releaseType = DynamicCodeSupport.getInstance().searchDynamicCode(config.getReleaseTypeRefId(), getContext());
					config.setReleaseType(releaseType);
				}
				if (config.getEnvironmentTypeRefId() != null) {
					Code environmentType = DynamicCodeSupport.getInstance().searchDynamicCode(config.getEnvironmentTypeRefId(), getContext());
					config.setEnvironmentType(environmentType);
				}
			} catch (Exception e) {
				super.getLogger().error("Could not resolve DynamicCodes for ProxyConfiguration [" + config.getId() + "]");
			}
		}
		
		// Detach Entities
		this.getEntityManager().clear();

		// Remove disabled ProxyConfigurations
		for (ProxyConfiguration disabledProxy : disabledProxyConfigurations) {
			proxyConfigurations.remove(disabledProxy);
		}
		NabuccoCollectionAccessor.getInstance().clearAssignments(proxyConfigurations);

		TestEngineConfigurationMsg rs = new TestEngineConfigurationMsg();
		rs.setTestEngineConfiguration(result);
		return rs;
	}
	

}
