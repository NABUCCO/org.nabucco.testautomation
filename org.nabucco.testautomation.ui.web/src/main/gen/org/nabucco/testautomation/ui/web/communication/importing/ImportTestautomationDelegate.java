/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.importing;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.service.importing.ImportTestautomation;

/**
 * ImportTestautomationDelegate<p/>Service to import Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public class ImportTestautomationDelegate extends ServiceDelegateSupport {

    private ImportTestautomation service;

    /**
     * Constructs a new ImportTestautomationDelegate instance.
     *
     * @param service the ImportTestautomation.
     */
    public ImportTestautomationDelegate(ImportTestautomation service) {
        super();
        this.service = service;
    }

    /**
     * ImportTestautomation.
     *
     * @param session the NabuccoSession.
     * @param rq the ImportRq.
     * @return the ImportRs.
     * @throws ImportException
     */
    public ImportRs importTestautomation(ImportRq rq, NabuccoSession session)
            throws ImportException {
        ServiceRequest<ImportRq> request = new ServiceRequest<ImportRq>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ImportRs> rs;
        if ((service != null)) {
            rs = service.importTestautomation(request);
        } else {
            throw new ImportException(
                    "Cannot execute service operation: ImportTestautomation.importTestautomation");
        }
        return rs.getResponseMessage();
    }
}
