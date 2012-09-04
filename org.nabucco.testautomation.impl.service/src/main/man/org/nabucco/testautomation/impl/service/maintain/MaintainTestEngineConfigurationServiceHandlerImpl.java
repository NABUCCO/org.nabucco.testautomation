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
package org.nabucco.testautomation.impl.service.maintain;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceExceptionMapper;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.framework.common.authorization.facade.datatype.AuthorizationUser;
import org.nabucco.framework.common.authorization.facade.message.AuthorizationUserListMsg;
import org.nabucco.framework.common.authorization.facade.message.search.AuthorizationSearchMsg;
import org.nabucco.framework.common.authorization.facade.service.search.SearchAuthorization;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.datatype.visitor.TestEngineConfigurationModificationVisitor;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.impl.service.maintain.MaintainTestEngineConfigurationServiceHandler;


/**
 * MaintainTestEngineConfigurationServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainTestEngineConfigurationServiceHandlerImpl extends
		MaintainTestEngineConfigurationServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private PersistenceHelper persistenceHelper;
	
	private SearchAuthorization searchAuthorization;

	@Override
	protected TestEngineConfigurationMsg maintainTestEngineConfiguration(
			TestEngineConfigurationMsg msg) throws MaintainException {

		TestEngineConfiguration testEngineConfiguration = msg
				.getTestEngineConfiguration();

		
		try {
			// init PersitenceHelper
			this.persistenceHelper = new PersistenceHelper(
					super.getEntityManager());

			if (testEngineConfiguration.getDatatypeState() == DatatypeState.PERSISTENT) {
				DatatypeVisitor visitor = new TestEngineConfigurationModificationVisitor(
						testEngineConfiguration);
				testEngineConfiguration.accept(visitor);
			}
			
			switch (testEngineConfiguration.getDatatypeState()) {

			case CONSTRUCTED:
				throw new MaintainException(
						"TestConfiguration is not initialized.");
			case INITIALIZED:
				testEngineConfiguration = this.create(testEngineConfiguration);
				break;
			case MODIFIED:
				testEngineConfiguration = this.update(testEngineConfiguration);
				break;
			case DELETED:
				this.delete(testEngineConfiguration);
				testEngineConfiguration = null;
				break;
			case TRANSIENT:
				break;
			case PERSISTENT:
				break;
			default:
				throw new MaintainException("Datatype state '"
						+ testEngineConfiguration.getDatatypeState()
						+ "' is not valid for TestEngineConfiguration.");
			}
		} catch (MaintainException ex) {
        	throw ex;
        } catch (Exception ex) {
			throw new MaintainException("Error maintaining TestEngineConfiguration",
					PersistenceExceptionMapper.resolve(ex,
							TestEngineConfiguration.class.getName(),
							testEngineConfiguration.getId()));
		}
		
		this.persistenceHelper.flush();
		this.persistenceHelper = null;

		if (testEngineConfiguration != null) {
			try {
				load(testEngineConfiguration);
			} catch (SearchException ex) {
				throw new MaintainException(
						"Could not resolve AuthorizationUser: "
								+ ex.getMessage());
			}
		}
		
		msg.setTestEngineConfiguration(testEngineConfiguration);
		return msg;
	}
	
	private void load(TestEngineConfiguration entity) throws SearchException {
		
		// Load AuthorizationUser
		if (entity.getUserRefId() != null) {
			entity.setUser(findUser(entity.getUserRefId()));			
		}
		
		for (ProxyConfiguration proxyConfig : entity.getProxyConfigurations()) {
			
			for (ConfigurationProperty prop : proxyConfig.getConfigurationProperties()) {
				prop.setDatatypeState(DatatypeState.PERSISTENT);
			}
			proxyConfig.setDatatypeState(DatatypeState.PERSISTENT);
		}
		entity.setDatatypeState(DatatypeState.PERSISTENT);
	}

	private TestEngineConfiguration create(TestEngineConfiguration entity)
			throws PersistenceException {
		
		List<ProxyConfiguration> proxies = entity.getProxyConfigurations();
		
		for (int i = 0; i < proxies.size(); i++) {
			ProxyConfiguration proxy = create(proxies.get(i));
			proxies.set(i, proxy);
		}
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private ProxyConfiguration create(ProxyConfiguration proxyConfig) throws PersistenceException {
		
		List<ConfigurationProperty> props = proxyConfig.getConfigurationProperties();
		
		for (int i = 0; i < props.size(); i++) {
			ConfigurationProperty configProp = create(props.get(i));
			props.set(i, configProp);
		}
		
		proxyConfig = this.persistenceHelper.persist(proxyConfig);
		return proxyConfig;
	}
	
	private ConfigurationProperty create(ConfigurationProperty property) throws PersistenceException {
	
		property = this.persistenceHelper.persist(property);
		return property;
	}

	private TestEngineConfiguration update(TestEngineConfiguration entity)
			throws PersistenceException {

		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"TestEngineConfiguration is not persistent.");
		}
		
		List<ProxyConfiguration> proxyConfigurations = entity
				.getProxyConfigurations();
		List<ProxyConfiguration> deletedProxyConfigurations = NabuccoCollectionAccessor
				.getInstance().getUnassignedList(
						entity.getProxyConfigurations());

		for (int i = 0; i < proxyConfigurations.size(); i++) {
			ProxyConfiguration proxyConfig = update(proxyConfigurations.get(i));
			proxyConfigurations.set(i, proxyConfig);
		}
		
		for (ProxyConfiguration proxyConfiguration : deletedProxyConfigurations) {
			if (proxyConfiguration.getDatatypeState() == DatatypeState.DELETED) {
				delete(proxyConfiguration);
			}
		}
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private ProxyConfiguration update(ProxyConfiguration entity) throws PersistenceException {
		
		List<ConfigurationProperty> configurationProperties = entity.getConfigurationProperties();
		List<ConfigurationProperty> deletedProperties = NabuccoCollectionAccessor.getInstance().getUnassignedList(entity.getConfigurationProperties());
		
		for (int i = 0; i < configurationProperties.size(); i++) {
			ConfigurationProperty configProp = update(configurationProperties.get(i));
			configurationProperties.set(i, configProp);
		}
		
		for (ConfigurationProperty configurationProperty : deletedProperties) {
			if (configurationProperty.getDatatypeState() == DatatypeState.DELETED) {
				delete(configurationProperty);
			}
		}
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private ConfigurationProperty update(ConfigurationProperty entity) throws PersistenceException {
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private void delete(TestEngineConfiguration entity)
			throws PersistenceException {
		
		List<ProxyConfiguration> proxyConfigurations = entity.getProxyConfigurations();
		
		for (ProxyConfiguration proxyConfiguration : proxyConfigurations) {
			delete(proxyConfiguration);
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(entity);
	}
	
	private void delete(ProxyConfiguration entity) 
			throws PersistenceException {
		
		List<ConfigurationProperty> configurationProperties = entity.getConfigurationProperties();
		
		for (ConfigurationProperty configurationProperty : configurationProperties) {
			delete(configurationProperty);
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(entity);
	}

	private void delete(ConfigurationProperty entity) 
			throws PersistenceException {
		
		entity.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(entity);
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
