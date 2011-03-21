/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.impl.service.importing;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.service.importing.ImportTestautomation;

/**
 * ImportTestautomationImpl<p/>Service to import Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public class ImportTestautomationImpl extends ServiceSupport implements ImportTestautomation {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ImportTestautomation";

    private EntityManager entityManager;

    private ImportTestautomationServiceHandler importTestautomationServiceHandler;

    /** Constructs a new ImportTestautomationImpl instance. */
    public ImportTestautomationImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.importTestautomationServiceHandler = injector
                .inject(ImportTestautomationServiceHandler.getId());
        if ((this.importTestautomationServiceHandler != null)) {
            this.importTestautomationServiceHandler.setEntityManager(this.entityManager);
            this.importTestautomationServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<ImportRs> importTestautomation(ServiceRequest<ImportRq> rq)
            throws ImportException {
        if ((this.importTestautomationServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for importTestautomation().");
            throw new InjectionException(
                    "No service implementation configured for importTestautomation().");
        }
        ServiceResponse<ImportRs> rs;
        this.importTestautomationServiceHandler.init();
        rs = this.importTestautomationServiceHandler.invoke(rq);
        this.importTestautomationServiceHandler.finish();
        return rs;
    }
}
