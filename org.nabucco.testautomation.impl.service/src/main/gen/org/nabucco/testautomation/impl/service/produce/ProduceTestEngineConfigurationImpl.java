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

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.service.produce.ProduceTestEngineConfiguration;

/**
 * ProduceTestEngineConfigurationImpl<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class ProduceTestEngineConfigurationImpl extends ServiceSupport implements
        ProduceTestEngineConfiguration {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceTestEngineConfiguration";

    private ProduceTestEngineConfigurationServiceHandler produceTestEngineConfigurationServiceHandler;

    private ProduceProxyConfigurationServiceHandler produceProxyConfigurationServiceHandler;

    private ProduceConfigurationPropertyServiceHandler produceConfigurationPropertyServiceHandler;

    private ProduceTestEngineConfigurationCloneServiceHandler produceTestEngineConfigurationCloneServiceHandler;

    private ProduceProxyConfigurationCloneServiceHandler produceProxyConfigurationCloneServiceHandler;

    private ProduceConfigurationPropertyCloneServiceHandler produceConfigurationPropertyCloneServiceHandler;

    /** Constructs a new ProduceTestEngineConfigurationImpl instance. */
    public ProduceTestEngineConfigurationImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceTestEngineConfigurationServiceHandler = injector
                .inject(ProduceTestEngineConfigurationServiceHandler.getId());
        if ((this.produceTestEngineConfigurationServiceHandler != null)) {
            this.produceTestEngineConfigurationServiceHandler.setEntityManager(null);
            this.produceTestEngineConfigurationServiceHandler.setLogger(super.getLogger());
        }
        this.produceProxyConfigurationServiceHandler = injector
                .inject(ProduceProxyConfigurationServiceHandler.getId());
        if ((this.produceProxyConfigurationServiceHandler != null)) {
            this.produceProxyConfigurationServiceHandler.setEntityManager(null);
            this.produceProxyConfigurationServiceHandler.setLogger(super.getLogger());
        }
        this.produceConfigurationPropertyServiceHandler = injector
                .inject(ProduceConfigurationPropertyServiceHandler.getId());
        if ((this.produceConfigurationPropertyServiceHandler != null)) {
            this.produceConfigurationPropertyServiceHandler.setEntityManager(null);
            this.produceConfigurationPropertyServiceHandler.setLogger(super.getLogger());
        }
        this.produceTestEngineConfigurationCloneServiceHandler = injector
                .inject(ProduceTestEngineConfigurationCloneServiceHandler.getId());
        if ((this.produceTestEngineConfigurationCloneServiceHandler != null)) {
            this.produceTestEngineConfigurationCloneServiceHandler.setEntityManager(null);
            this.produceTestEngineConfigurationCloneServiceHandler.setLogger(super.getLogger());
        }
        this.produceProxyConfigurationCloneServiceHandler = injector
                .inject(ProduceProxyConfigurationCloneServiceHandler.getId());
        if ((this.produceProxyConfigurationCloneServiceHandler != null)) {
            this.produceProxyConfigurationCloneServiceHandler.setEntityManager(null);
            this.produceProxyConfigurationCloneServiceHandler.setLogger(super.getLogger());
        }
        this.produceConfigurationPropertyCloneServiceHandler = injector
                .inject(ProduceConfigurationPropertyCloneServiceHandler.getId());
        if ((this.produceConfigurationPropertyCloneServiceHandler != null)) {
            this.produceConfigurationPropertyCloneServiceHandler.setEntityManager(null);
            this.produceConfigurationPropertyCloneServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> produceTestEngineConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceTestEngineConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceTestEngineConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for produceTestEngineConfiguration().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.produceTestEngineConfigurationServiceHandler.init();
        rs = this.produceTestEngineConfigurationServiceHandler.invoke(rq);
        this.produceTestEngineConfigurationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> produceProxyConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceProxyConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceProxyConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for produceProxyConfiguration().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.produceProxyConfigurationServiceHandler.init();
        rs = this.produceProxyConfigurationServiceHandler.invoke(rq);
        this.produceProxyConfigurationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> produceConfigurationProperty(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceConfigurationPropertyServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceConfigurationProperty().");
            throw new InjectionException(
                    "No service implementation configured for produceConfigurationProperty().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.produceConfigurationPropertyServiceHandler.init();
        rs = this.produceConfigurationPropertyServiceHandler.invoke(rq);
        this.produceConfigurationPropertyServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> produceTestEngineConfigurationClone(
            ServiceRequest<TestEngineConfigurationMsg> rq) throws ProduceException {
        if ((this.produceTestEngineConfigurationCloneServiceHandler == null)) {
            super.getLogger()
                    .error("No service implementation configured for produceTestEngineConfigurationClone().");
            throw new InjectionException(
                    "No service implementation configured for produceTestEngineConfigurationClone().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.produceTestEngineConfigurationCloneServiceHandler.init();
        rs = this.produceTestEngineConfigurationCloneServiceHandler.invoke(rq);
        this.produceTestEngineConfigurationCloneServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProxyConfigurationMsg> produceProxyConfigurationClone(
            ServiceRequest<ProxyConfigurationMsg> rq) throws ProduceException {
        if ((this.produceProxyConfigurationCloneServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceProxyConfigurationClone().");
            throw new InjectionException(
                    "No service implementation configured for produceProxyConfigurationClone().");
        }
        ServiceResponse<ProxyConfigurationMsg> rs;
        this.produceProxyConfigurationCloneServiceHandler.init();
        rs = this.produceProxyConfigurationCloneServiceHandler.invoke(rq);
        this.produceProxyConfigurationCloneServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ConfigurationPropertyMsg> produceConfigurationPropertyClone(
            ServiceRequest<ConfigurationPropertyMsg> rq) throws ProduceException {
        if ((this.produceConfigurationPropertyCloneServiceHandler == null)) {
            super.getLogger()
                    .error("No service implementation configured for produceConfigurationPropertyClone().");
            throw new InjectionException(
                    "No service implementation configured for produceConfigurationPropertyClone().");
        }
        ServiceResponse<ConfigurationPropertyMsg> rs;
        this.produceConfigurationPropertyCloneServiceHandler.init();
        rs = this.produceConfigurationPropertyCloneServiceHandler.invoke(rq);
        this.produceConfigurationPropertyCloneServiceHandler.finish();
        return rs;
    }
}
