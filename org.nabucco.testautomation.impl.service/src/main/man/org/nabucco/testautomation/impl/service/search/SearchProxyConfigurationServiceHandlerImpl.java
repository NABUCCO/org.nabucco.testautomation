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

import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.ProxyConfigurationListMsg;
import org.nabucco.testautomation.impl.service.search.SearchProxyConfigurationServiceHandler;


public class SearchProxyConfigurationServiceHandlerImpl extends SearchProxyConfigurationServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected ProxyConfigurationListMsg searchProxyConfiguration(EmptyServiceMessage msg) throws SearchException {
		StringBuilder queryString = new StringBuilder();
		queryString.append("select c from ProxyConfiguration c");

		Query query = super.getEntityManager().createQuery(
				queryString.toString());

		@SuppressWarnings("unchecked")
		List<ProxyConfiguration> resultList = query.getResultList();

		for (ProxyConfiguration proxyConfiguration : resultList) {
			for (ConfigurationProperty confProp : proxyConfiguration.getConfigurationProperties()) {
				confProp.setDatatypeState(DatatypeState.PERSISTENT);
			}
			proxyConfiguration.setDatatypeState(DatatypeState.PERSISTENT);
		}

		ProxyConfigurationListMsg rs = new ProxyConfigurationListMsg();
		rs.getProxyConfigurationList().addAll(resultList);
		return rs;
	}

}
