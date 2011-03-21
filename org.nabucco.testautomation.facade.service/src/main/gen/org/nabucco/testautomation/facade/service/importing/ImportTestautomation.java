/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.importing;

import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ImportTestautomation<p/>Service to import Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public interface ImportTestautomation extends Service {

    /**
     * Missing description at method importTestautomation.
     *
     * @param rq the ServiceRequest<ImportRq>.
     * @return the ServiceResponse<ImportRs>.
     * @throws ImportException
     */
    ServiceResponse<ImportRs> importTestautomation(ServiceRequest<ImportRq> rq)
            throws ImportException;
}
