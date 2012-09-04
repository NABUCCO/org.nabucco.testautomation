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
package org.nabucco.testautomation.ui.rcp.communication.export;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the EmptyServiceMessage.
     * @return the ExportRs.
     * @throws ClientException
     */
    public ExportRs export(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ExportRs> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.export(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ExportTestautomationDelegate.class, "Service: ",
                                "ExportTestautomation.export", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: ExportTestautomation.export");
    }
}
