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
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.message.ProducePropertyMsg;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.facade.service.produce.ProduceProperty;

/**
 * ProducePropertyImpl<p/>Property produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class ProducePropertyImpl extends ServiceSupport implements ProduceProperty {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceProperty";

    private ProducePropertyServiceHandler producePropertyServiceHandler;

    private ProducePropertyCloneServiceHandler producePropertyCloneServiceHandler;

    /** Constructs a new ProducePropertyImpl instance. */
    public ProducePropertyImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.producePropertyServiceHandler = injector.inject(ProducePropertyServiceHandler.getId());
        if ((this.producePropertyServiceHandler != null)) {
            this.producePropertyServiceHandler.setEntityManager(null);
            this.producePropertyServiceHandler.setLogger(super.getLogger());
        }
        this.producePropertyCloneServiceHandler = injector
                .inject(ProducePropertyCloneServiceHandler.getId());
        if ((this.producePropertyCloneServiceHandler != null)) {
            this.producePropertyCloneServiceHandler.setEntityManager(null);
            this.producePropertyCloneServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<PropertyMsg> produceProperty(ServiceRequest<ProducePropertyMsg> rq)
            throws ProduceException {
        if ((this.producePropertyServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProperty().");
            throw new InjectionException(
                    "No service implementation configured for produceProperty().");
        }
        ServiceResponse<PropertyMsg> rs;
        this.producePropertyServiceHandler.init();
        rs = this.producePropertyServiceHandler.invoke(rq);
        this.producePropertyServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PropertyMsg> producePropertyClone(ServiceRequest<PropertyMsg> rq)
            throws ProduceException {
        if ((this.producePropertyCloneServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for producePropertyClone().");
            throw new InjectionException(
                    "No service implementation configured for producePropertyClone().");
        }
        ServiceResponse<PropertyMsg> rs;
        this.producePropertyCloneServiceHandler.init();
        rs = this.producePropertyCloneServiceHandler.invoke(rq);
        this.producePropertyCloneServiceHandler.finish();
        return rs;
    }
}
