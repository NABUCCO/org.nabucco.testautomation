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

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.message.ProxyConfigurationListMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationSearchMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;

/**
 * SearchTestEngineConfigurationImpl<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class SearchTestEngineConfigurationImpl extends ServiceSupport implements
        SearchTestEngineConfiguration {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchTestEngineConfiguration";

    private EntityManager em;

    private SearchTestEngineConfigurationServiceHandler searchTestEngineConfigurationServiceHandler;

    private GetTestEngineConfigurationServiceHandler getTestEngineConfigurationServiceHandler;

    private SearchProxyConfigurationServiceHandler searchProxyConfigurationServiceHandler;

    private GetProxyConfigurationServiceHandler getProxyConfigurationServiceHandler;

    /** Constructs a new SearchTestEngineConfigurationImpl instance. */
    public SearchTestEngineConfigurationImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchTestEngineConfigurationServiceHandler = injector
                .inject(SearchTestEngineConfigurationServiceHandler.getId());
        if ((this.searchTestEngineConfigurationServiceHandler != null)) {
            this.searchTestEngineConfigurationServiceHandler.setEntityManager(this.em);
            this.searchTestEngineConfigurationServiceHandler.setLogger(super.getLogger());
        }
        this.getTestEngineConfigurationServiceHandler = injector
                .inject(GetTestEngineConfigurationServiceHandler.getId());
        if ((this.getTestEngineConfigurationServiceHandler != null)) {
            this.getTestEngineConfigurationServiceHandler.setEntityManager(this.em);
            this.getTestEngineConfigurationServiceHandler.setLogger(super.getLogger());
        }
        this.searchProxyConfigurationServiceHandler = injector
                .inject(SearchProxyConfigurationServiceHandler.getId());
        if ((this.searchProxyConfigurationServiceHandler != null)) {
            this.searchProxyConfigurationServiceHandler.setEntityManager(this.em);
            this.searchProxyConfigurationServiceHandler.setLogger(super.getLogger());
        }
        this.getProxyConfigurationServiceHandler = injector
                .inject(GetProxyConfigurationServiceHandler.getId());
        if ((this.getProxyConfigurationServiceHandler != null)) {
            this.getProxyConfigurationServiceHandler.setEntityManager(this.em);
            this.getProxyConfigurationServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestEngineConfigurationListMsg> searchTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationSearchMsg> rq) throws SearchException {
        if ((this.searchTestEngineConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchTestEngineConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for searchTestEngineConfiguration().");
        }
        ServiceResponse<TestEngineConfigurationListMsg> rs;
        this.searchTestEngineConfigurationServiceHandler.init();
        rs = this.searchTestEngineConfigurationServiceHandler.invoke(rq);
        this.searchTestEngineConfigurationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> getTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationSearchMsg> rq) throws SearchException {
        if ((this.getTestEngineConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for getTestEngineConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for getTestEngineConfiguration().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.getTestEngineConfigurationServiceHandler.init();
        rs = this.getTestEngineConfigurationServiceHandler.invoke(rq);
        this.getTestEngineConfigurationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProxyConfigurationListMsg> searchProxyConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws SearchException {
        if ((this.searchProxyConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchProxyConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for searchProxyConfiguration().");
        }
        ServiceResponse<ProxyConfigurationListMsg> rs;
        this.searchProxyConfigurationServiceHandler.init();
        rs = this.searchProxyConfigurationServiceHandler.invoke(rq);
        this.searchProxyConfigurationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProxyConfigurationMsg> getProxyConfiguration(
            ServiceRequest<ProxyConfigurationSearchMsg> rq) throws SearchException {
        if ((this.getProxyConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for getProxyConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for getProxyConfiguration().");
        }
        ServiceResponse<ProxyConfigurationMsg> rs;
        this.getProxyConfigurationServiceHandler.init();
        rs = this.getProxyConfigurationServiceHandler.invoke(rq);
        this.getProxyConfigurationServiceHandler.finish();
        return rs;
    }
}
