/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.facade.message.ProxyConfigurationListMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;
import org.nabucco.testautomation.facade.message.ProxyConfigurationSearchMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;

/**
 * SearchTestEngineConfigurationDelegate<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class SearchTestEngineConfigurationDelegate extends ServiceDelegateSupport {

    private SearchTestEngineConfiguration service;

    /**
     * Constructs a new SearchTestEngineConfigurationDelegate instance.
     *
     * @param service the SearchTestEngineConfiguration.
     */
    public SearchTestEngineConfigurationDelegate(SearchTestEngineConfiguration service) {
        super();
        this.service = service;
    }

    /**
     * SearchTestEngineConfiguration.
     *
     * @param rq the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationListMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationListMsg searchTestEngineConfiguration(
            TestEngineConfigurationSearchMsg rq) throws ClientException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchTestEngineConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "SearchTestEngineConfiguration.searchTestEngineConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestEngineConfiguration.searchTestEngineConfiguration");
    }

    /**
     * Getter for the TestEngineConfiguration.
     *
     * @param rq the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ClientException
     */
    public TestEngineConfigurationMsg getTestEngineConfiguration(TestEngineConfigurationSearchMsg rq)
            throws ClientException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getTestEngineConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "SearchTestEngineConfiguration.getTestEngineConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestEngineConfiguration.getTestEngineConfiguration");
    }

    /**
     * SearchProxyConfiguration.
     *
     * @param rq the EmptyServiceMessage.
     * @return the ProxyConfigurationListMsg.
     * @throws ClientException
     */
    public ProxyConfigurationListMsg searchProxyConfiguration(EmptyServiceMessage rq)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchProxyConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestEngineConfigurationDelegate.class,
                                "Service: ",
                                "SearchTestEngineConfiguration.searchProxyConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestEngineConfiguration.searchProxyConfiguration");
    }

    /**
     * Getter for the ProxyConfiguration.
     *
     * @param rq the ProxyConfigurationSearchMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ClientException
     */
    public ProxyConfigurationMsg getProxyConfiguration(ProxyConfigurationSearchMsg rq)
            throws ClientException {
        ServiceRequest<ProxyConfigurationSearchMsg> request = new ServiceRequest<ProxyConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getProxyConfiguration(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestEngineConfigurationDelegate.class,
                                "Service: ", "SearchTestEngineConfiguration.getProxyConfiguration",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestEngineConfiguration.getProxyConfiguration");
    }
}
