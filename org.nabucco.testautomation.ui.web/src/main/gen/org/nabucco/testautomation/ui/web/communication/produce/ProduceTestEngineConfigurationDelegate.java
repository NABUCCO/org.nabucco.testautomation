/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.security.Subject;
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
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfiguration(EmptyServiceMessage rq)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
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
     * ProduceTestEngineConfiguration.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfiguration(EmptyServiceMessage rq,
            Subject subject) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
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
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceProxyConfiguration(EmptyServiceMessage rq)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
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
     * ProduceProxyConfiguration.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceProxyConfiguration(EmptyServiceMessage rq,
            Subject subject) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
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
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceConfigurationProperty(EmptyServiceMessage rq)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
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
     * ProduceConfigurationProperty.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceConfigurationProperty(EmptyServiceMessage rq,
            Subject subject) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
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
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfigurationClone(
            TestEngineConfigurationMsg rq) throws ProduceException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext());
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
     * ProduceTestEngineConfigurationClone.
     *
     * @param subject the Subject.
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    public TestEngineConfigurationMsg produceTestEngineConfigurationClone(
            TestEngineConfigurationMsg rq, Subject subject) throws ProduceException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext(subject));
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
     * @param rq the ProxyConfigurationMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ProduceException
     */
    public ProxyConfigurationMsg produceProxyConfigurationClone(ProxyConfigurationMsg rq)
            throws ProduceException {
        ServiceRequest<ProxyConfigurationMsg> request = new ServiceRequest<ProxyConfigurationMsg>(
                super.createServiceContext());
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
     * ProduceProxyConfigurationClone.
     *
     * @param subject the Subject.
     * @param rq the ProxyConfigurationMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ProduceException
     */
    public ProxyConfigurationMsg produceProxyConfigurationClone(ProxyConfigurationMsg rq,
            Subject subject) throws ProduceException {
        ServiceRequest<ProxyConfigurationMsg> request = new ServiceRequest<ProxyConfigurationMsg>(
                super.createServiceContext(subject));
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
     * @param rq the ConfigurationPropertyMsg.
     * @return the ConfigurationPropertyMsg.
     * @throws ProduceException
     */
    public ConfigurationPropertyMsg produceConfigurationPropertyClone(ConfigurationPropertyMsg rq)
            throws ProduceException {
        ServiceRequest<ConfigurationPropertyMsg> request = new ServiceRequest<ConfigurationPropertyMsg>(
                super.createServiceContext());
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

    /**
     * ProduceConfigurationPropertyClone.
     *
     * @param subject the Subject.
     * @param rq the ConfigurationPropertyMsg.
     * @return the ConfigurationPropertyMsg.
     * @throws ProduceException
     */
    public ConfigurationPropertyMsg produceConfigurationPropertyClone(ConfigurationPropertyMsg rq,
            Subject subject) throws ProduceException {
        ServiceRequest<ConfigurationPropertyMsg> request = new ServiceRequest<ConfigurationPropertyMsg>(
                super.createServiceContext(subject));
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
