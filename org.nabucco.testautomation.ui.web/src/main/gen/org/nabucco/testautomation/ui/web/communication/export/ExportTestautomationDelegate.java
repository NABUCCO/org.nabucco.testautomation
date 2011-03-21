/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.export;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.exporting.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.service.export.ExportTestautomation;

/**
 * ExportTestautomationDelegate<p/>Export Service for Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-04
 */
public class ExportTestautomationDelegate extends ServiceDelegateSupport {

    private ExportTestautomation service;

    /**
     * Constructs a new ExportTestautomationDelegate instance.
     *
     * @param service the ExportTestautomation.
     */
    public ExportTestautomationDelegate(ExportTestautomation service) {
        super();
        this.service = service;
    }

    /**
     * Export.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the ExportRs.
     * @throws ExportException
     */
    public ExportRs export(EmptyServiceMessage rq, NabuccoSession session) throws ExportException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ExportRs> rs;
        if ((service != null)) {
            rs = service.export(request);
        } else {
            throw new ExportException(
                    "Cannot execute service operation: ExportTestautomation.export");
        }
        return rs.getResponseMessage();
    }
}
