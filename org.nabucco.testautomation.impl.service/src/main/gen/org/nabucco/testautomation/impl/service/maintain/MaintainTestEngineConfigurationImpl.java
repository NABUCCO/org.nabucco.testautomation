/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
