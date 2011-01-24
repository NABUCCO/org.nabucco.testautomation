/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @throws ClientException
     */
    public TestEngineConfigurationMsg produceTestEngineConfiguration(EmptyServiceMessage rq)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceTestEngineConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "ProduceTestEngineConfiguration.produceTestEngineConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceTestEngineConfiguration");
    }

    /**
     * ProduceProxyConfiguration.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationMsg produceProxyConfiguration(EmptyServiceMessage rq)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceProxyConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "ProduceTestEngineConfiguration.produceProxyConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceProxyConfiguration");
    }

    /**
     * ProduceConfigurationProperty.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TestEngineConfigurationMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationMsg produceConfigurationProperty(EmptyServiceMessage rq)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceConfigurationProperty(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "ProduceTestEngineConfiguration.produceConfigurationProperty",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceConfigurationProperty");
    }

    /**
     * ProduceTestEngineConfigurationClone.
     *
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationMsg produceTestEngineConfigurationClone(
            TestEngineConfigurationMsg rq) throws ClientException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceTestEngineConfigurationClone(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator
                        .getDefault()
                        .logDebug(
                                new NabuccoLogMessage(
                                        ProduceTestEngineConfigurationDelegate.class,
                                        "Service: ",
                                        "ProduceTestEngineConfiguration.produceTestEngineConfigurationClone",
                                        " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceTestEngineConfigurationClone");
    }

    /**
     * ProduceProxyConfigurationClone.
     *
     * @param rq the ProxyConfigurationMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ClientException
     */
    public ProxyConfigurationMsg produceProxyConfigurationClone(ProxyConfigurationMsg rq)
            throws ClientException {
        ServiceRequest<ProxyConfigurationMsg> request = new ServiceRequest<ProxyConfigurationMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceProxyConfigurationClone(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "ProduceTestEngineConfiguration.produceProxyConfigurationClone",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceProxyConfigurationClone");
    }

    /**
     * ProduceConfigurationPropertyClone.
     *
     * @param rq the ConfigurationPropertyMsg.
     * @return the ConfigurationPropertyMsg.
     * @throws ClientException
     */
    public ConfigurationPropertyMsg produceConfigurationPropertyClone(ConfigurationPropertyMsg rq)
            throws ClientException {
        ServiceRequest<ConfigurationPropertyMsg> request = new ServiceRequest<ConfigurationPropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ConfigurationPropertyMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceConfigurationPropertyClone(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "ProduceTestEngineConfiguration.produceConfigurationPropertyClone",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestEngineConfiguration.produceConfigurationPropertyClone");
    }
}
