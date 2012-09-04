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
package org.nabucco.testautomation.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;

/**
 * ProduceTestEngineConfiguration<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface ProduceTestEngineConfiguration extends Service {

    /**
     * Missing description at method produceTestEngineConfiguration.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestEngineConfigurationMsg> produceTestEngineConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceProxyConfiguration.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestEngineConfigurationMsg> produceProxyConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceConfigurationProperty.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestEngineConfigurationMsg> produceConfigurationProperty(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceTestEngineConfigurationClone.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationMsg>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestEngineConfigurationMsg> produceTestEngineConfigurationClone(
            ServiceRequest<TestEngineConfigurationMsg> rq) throws ProduceException;

    /**
     * Missing description at method produceProxyConfigurationClone.
     *
     * @param rq the ServiceRequest<ProxyConfigurationMsg>.
     * @return the ServiceResponse<ProxyConfigurationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProxyConfigurationMsg> produceProxyConfigurationClone(
            ServiceRequest<ProxyConfigurationMsg> rq) throws ProduceException;

    /**
     * Missing description at method produceConfigurationPropertyClone.
     *
     * @param rq the ServiceRequest<ConfigurationPropertyMsg>.
     * @return the ServiceResponse<ConfigurationPropertyMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ConfigurationPropertyMsg> produceConfigurationPropertyClone(
            ServiceRequest<ConfigurationPropertyMsg> rq) throws ProduceException;
}
