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
package org.nabucco.testautomation.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.service.produce.ProduceTestEngineConfiguration;

/**
 * ProduceTestEngineConfigurationDelegate<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class ProduceTestEngineConfigurationDelegate extends ServiceDelegateSupport {

    private ProduceTestEngineConfiguration service;

    /**
     * Constructs a new ProduceTestEngineConfigurationDelegate instance.
     *
     * @param service the ProduceTestEngineConfiguration.
     */
    public ProduceTestEngineConfigurationDelegate(ProduceTestEngineConfiguration service) {
        super();
        this.service = service;
    }

    /**
     * ProduceTestEngineConfiguration.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfiguration(EmptyServiceMessage rq,
            NabuccoSession session) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.produceTestEngineConfiguration(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceProxyConfiguration.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceProxyConfiguration(EmptyServiceMessage rq,
            NabuccoSession session) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.produceProxyConfiguration(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceProxyConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceConfigurationProperty.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceConfigurationProperty(EmptyServiceMessage rq,
            NabuccoSession session) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.produceConfigurationProperty(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceConfigurationProperty");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceTestEngineConfigurationClone.
     *
     * @param session the NabuccoSession.
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfigurationClone(
            TestEngineConfigurationMsg rq, NabuccoSession session) throws ProduceException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.produceTestEngineConfigurationClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceTestEngineConfigurationClone");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceProxyConfigurationClone.
     *
     * @param session the NabuccoSession.
     * @param rq the ProxyConfigurationMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ProduceException
     */
    public ProxyConfigurationMsg produceProxyConfigurationClone(ProxyConfigurationMsg rq,
            NabuccoSession session) throws ProduceException {
        ServiceRequest<ProxyConfigurationMsg> request = new ServiceRequest<ProxyConfigurationMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.produceProxyConfigurationClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceProxyConfigurationClone");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceConfigurationPropertyClone.
     *
     * @param session the NabuccoSession.
     * @param rq the ConfigurationPropertyMsg.
     * @return the ConfigurationPropertyMsg.
     * @throws ProduceException
     */
    public ConfigurationPropertyMsg produceConfigurationPropertyClone(ConfigurationPropertyMsg rq,
            NabuccoSession session) throws ProduceException {
        ServiceRequest<ConfigurationPropertyMsg> request = new ServiceRequest<ConfigurationPropertyMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ConfigurationPropertyMsg> rs;
        if ((service != null)) {
            rs = service.produceConfigurationPropertyClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestEngineConfiguration.produceConfigurationPropertyClone");
        }
        return rs.getResponseMessage();
    }
}
