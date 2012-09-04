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
package org.nabucco.testautomation.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.ProxyConfigurationListMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationSearchMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;

/**
 * SearchTestEngineConfiguration<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface SearchTestEngineConfiguration extends Service {

    /**
     * Missing description at method searchTestEngineConfiguration.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationSearchMsg>.
     * @return the ServiceResponse<TestEngineConfigurationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<TestEngineConfigurationListMsg> searchTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationSearchMsg> rq) throws SearchException;

    /**
     * Missing description at method getTestEngineConfiguration.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationSearchMsg>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws SearchException
     */
    ServiceResponse<TestEngineConfigurationMsg> getTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationSearchMsg> rq) throws SearchException;

    /**
     * Missing description at method searchProxyConfiguration.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProxyConfigurationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProxyConfigurationListMsg> searchProxyConfiguration(
            ServiceRequest<EmptyServiceMessage> rq) throws SearchException;

    /**
     * Missing description at method getProxyConfiguration.
     *
     * @param rq the ServiceRequest<ProxyConfigurationSearchMsg>.
     * @return the ServiceResponse<ProxyConfigurationMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProxyConfigurationMsg> getProxyConfiguration(
            ServiceRequest<ProxyConfigurationSearchMsg> rq) throws SearchException;
}
