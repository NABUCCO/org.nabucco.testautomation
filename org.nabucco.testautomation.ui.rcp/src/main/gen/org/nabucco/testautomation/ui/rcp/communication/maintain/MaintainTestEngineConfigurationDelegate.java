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
package org.nabucco.testautomation.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;

/**
 * MaintainTestEngineConfigurationDelegate<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class MaintainTestEngineConfigurationDelegate extends ServiceDelegateSupport {

    private MaintainTestEngineConfiguration service;

    /**
     * Constructs a new MaintainTestEngineConfigurationDelegate instance.
     *
     * @param service the MaintainTestEngineConfiguration.
     */
    public MaintainTestEngineConfigurationDelegate(MaintainTestEngineConfiguration service) {
        super();
        this.service = service;
    }

    /**
     * MaintainTestEngineConfiguration.
     *
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationMsg maintainTestEngineConfiguration(TestEngineConfigurationMsg rq)
            throws ClientException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainTestEngineConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "MaintainTestEngineConfiguration.maintainTestEngineConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainTestEngineConfiguration.maintainTestEngineConfiguration");
    }
}
