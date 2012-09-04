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
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationSearchMsg;
import org.nabucco.testautomation.impl.service.search.GetProxyConfigurationServiceHandler;


public class GetProxyConfigurationServiceHandlerImpl extends GetProxyConfigurationServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected ProxyConfigurationMsg getProxyConfiguration(ProxyConfigurationSearchMsg msg) throws SearchException {

		if (msg.getId() == null || msg.getId().getValue() == null) {
			throw new SearchException("Mandatory Identifier is null");
		}

		String queryString = "select c from ProxyConfiguration c where c.id = :id";
		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		query.setParameter("id", msg.getId().getValue());
		ProxyConfiguration result = (ProxyConfiguration) query.getSingleResult();

		if (result == null) {
			throw new SearchException("ProxyConfiguration with id '" + msg.getId().getValue() + "' not found");
		}

		List<ConfigurationProperty> configurationProperties = result.getConfigurationProperties();


		// Resolve ConfigurationProperties
		for (ConfigurationProperty configProp : configurationProperties) {
			configProp.setDatatypeState(DatatypeState.PERSISTENT);
		}

		ProxyConfigurationMsg rs = new ProxyConfigurationMsg();
		rs.setProxyConfiguration(result);
		return rs;
	}

}
