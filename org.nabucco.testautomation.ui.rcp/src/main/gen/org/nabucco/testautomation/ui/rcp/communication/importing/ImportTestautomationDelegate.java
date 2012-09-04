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
package org.nabucco.testautomation.ui.rcp.communication.importing;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the ImportRq.
     * @return the ImportRs.
     * @throws ClientException
     */
    public ImportRs importTestautomation(ImportRq rq) throws ClientException {
        ServiceRequest<ImportRq> request = new ServiceRequest<ImportRq>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ImportRs> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.importTestautomation(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ImportTestautomationDelegate.class, "Service: ",
                                "ImportTestautomation.importTestautomation", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ImportTestautomation.importTestautomation");
    }
}
