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

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;

/**
 * MaintainTestEngineConfigurationImpl<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class MaintainTestEngineConfigurationImpl extends ServiceSupport implements
        MaintainTestEngineConfiguration {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainTestEngineConfiguration";

    private EntityManager em;

    private MaintainTestEngineConfigurationServiceHandler maintainTestEngineConfigurationServiceHandler;

    /** Constructs a new MaintainTestEngineConfigurationImpl instance. */
    public MaintainTestEngineConfigurationImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.maintainTestEngineConfigurationServiceHandler = injector
                .inject(MaintainTestEngineConfigurationServiceHandler.getId());
        if ((this.maintainTestEngineConfigurationServiceHandler != null)) {
            this.maintainTestEngineConfigurationServiceHandler.setEntityManager(this.em);
            this.maintainTestEngineConfigurationServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestEngineConfigurationMsg> maintainTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationMsg> rq) throws MaintainException {
        if ((this.maintainTestEngineConfigurationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for maintainTestEngineConfiguration().");
            throw new InjectionException(
                    "No service implementation configured for maintainTestEngineConfiguration().");
        }
        ServiceResponse<TestEngineConfigurationMsg> rs;
        this.maintainTestEngineConfigurationServiceHandler.init();
        rs = this.maintainTestEngineConfigurationServiceHandler.invoke(rq);
        this.maintainTestEngineConfigurationServiceHandler.finish();
        return rs;
    }
}
