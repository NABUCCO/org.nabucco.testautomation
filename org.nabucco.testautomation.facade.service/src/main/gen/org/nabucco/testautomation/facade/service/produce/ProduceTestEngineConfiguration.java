/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
