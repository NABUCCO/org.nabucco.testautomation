/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.export;

import org.nabucco.framework.base.facade.exception.exporting.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ExportTestautomation<p/>Export Service for Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-04
 */
public interface ExportTestautomation extends Service {

    /**
     * Missing description at method export.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ExportRs>.
     * @throws ExportException
     */
    ServiceResponse<ExportRs> export(ServiceRequest<EmptyServiceMessage> rq) throws ExportException;
}
