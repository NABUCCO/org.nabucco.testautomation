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
package org.nabucco.testautomation.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.common.authorization.facade.datatype.AuthorizationUser;
import org.nabucco.framework.common.authorization.facade.message.AuthorizationUserListMsg;
import org.nabucco.framework.common.authorization.facade.message.search.AuthorizationSearchMsg;
import org.nabucco.framework.common.authorization.facade.service.search.SearchAuthorization;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.impl.service.search.SearchTestEngineConfigurationServiceHandler;


/**
 * SearchTestEngineConfigurationServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchTestEngineConfigurationServiceHandlerImpl extends
		SearchTestEngineConfigurationServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private SearchAuthorization searchAuthorization;
	
	@Override
	protected TestEngineConfigurationListMsg searchTestEngineConfiguration(
			TestEngineConfigurationSearchMsg msg) throws SearchException {
		
		StringBuilder queryString = new StringBuilder();
		queryString.append("select c from TestEngineConfiguration c");

		List<String> filter = new ArrayList<String>();
		boolean idSet = msg.getId() != null && msg.getId().getValue() != null;
		boolean nameSet = msg.getName() != null && msg.getName().getValue() != null;
		boolean hostSet = msg.getHost() != null && msg.getHost().getValue() != null;
        boolean portSet = msg.getPort() != null && msg.getPort().getValue() != null;
        boolean remoteRefNameSet = msg.getRemoteRefName() != null && msg.getRemoteRefName().getValue() != null;
        
		if (idSet) {
			filter.add("c.id = :id");
		} 
		if (nameSet) {
			filter.add("c.name LIKE '" + msg.getName().getValue() + "%'");
		}
		if (hostSet) {
			filter.add("c.host LIKE '" + msg.getHost().getValue() + "%'");
		}
		if (portSet) {
			filter.add("c.port = :port");
		}
		if (remoteRefNameSet) {
			filter.add("c.remoteReferenceName LIKE '" + msg.getRemoteRefName().getValue() + "%'");
		}
        
        // append filter criteria
        int filterSize = filter.size();
        
        if (filterSize > 0) {
        	queryString.append(" WHERE ");
            int c = 1;
            for (String str : filter) {
            	queryString.append(str);
                
                if (c++ < filterSize) {
                	queryString.append(" AND ");
                }
            }
        }		
			
		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		
		if (idSet) {
			query.setParameter("id", msg.getId().getValue());
		} 
		if (portSet) {
			query.setParameter("port", msg.getPort());
		}

		@SuppressWarnings("unchecked")
		List<TestEngineConfiguration> resultList = query.getResultList();

		for (TestEngineConfiguration testEngineConfiguration : resultList) {
			
			// Load AuthorizationUser
			if (testEngineConfiguration.getUserRefId() != null) {
				testEngineConfiguration.setUser(findUser(testEngineConfiguration.getUserRefId()));			
			}
			
			for (ProxyConfiguration config : testEngineConfiguration.getProxyConfigurations()) {
				for (ConfigurationProperty confProp : config.getConfigurationProperties()) {
					confProp.setDatatypeState(DatatypeState.PERSISTENT);
				}
				config.setDatatypeState(DatatypeState.PERSISTENT);
			}
			testEngineConfiguration.setDatatypeState(DatatypeState.PERSISTENT);
		}

		TestEngineConfigurationListMsg rs = new TestEngineConfigurationListMsg();
		rs.getConfigurationList().addAll(resultList);
		return rs;
	}
	
	private User findUser(Long id) throws SearchException {
		
		if (this.searchAuthorization == null) {
			try {
				this.searchAuthorization = TestautomationComponentLocator
						.getInstance().getComponent()
						.getAuthorizationComponent().getSearchAuthorization();
			} catch (Exception ex) {
				throw new SearchException("Could not resolve AuthorizationUser", ex);
			}
		}
		
		ServiceRequest<AuthorizationSearchMsg> rq = new ServiceRequest<AuthorizationSearchMsg>(getContext());
		rq.setRequestMessage(new AuthorizationSearchMsg());
		AuthorizationUserListMsg rs = this.searchAuthorization.searchAuthorizationUser(rq).getResponseMessage();
		
		for (AuthorizationUser user : rs.getAuthorizationUserList()) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}
