/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
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
     * @throws SearchException
     */
    public TestEngineConfigurationListMsg searchTestEngineConfiguration(
            TestEngineConfigurationSearchMsg rq) throws SearchException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationListMsg> rs;
        if ((service != null)) {
            rs = service.searchTestEngineConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.searchTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchTestEngineConfiguration.
     *
     * @param subject the Subject.
     * @param rq the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationListMsg.
     * @throws SearchException
     */
    public TestEngineConfigurationListMsg searchTestEngineConfiguration(
            TestEngineConfigurationSearchMsg rq, Subject subject) throws SearchException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationListMsg> rs;
        if ((service != null)) {
            rs = service.searchTestEngineConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.searchTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the TestEngineConfiguration.
     *
     * @param rq the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws SearchException
     */
    public TestEngineConfigurationMsg getTestEngineConfiguration(TestEngineConfigurationSearchMsg rq)
            throws SearchException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.getTestEngineConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.getTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the TestEngineConfiguration.
     *
     * @param subject the Subject.
     * @param rq the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws SearchException
     */
    public TestEngineConfigurationMsg getTestEngineConfiguration(
            TestEngineConfigurationSearchMsg rq, Subject subject) throws SearchException {
        ServiceRequest<TestEngineConfigurationSearchMsg> request = new ServiceRequest<TestEngineConfigurationSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.getTestEngineConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.getTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchProxyConfiguration.
     *
     * @param rq the EmptyServiceMessage.
     * @return the ProxyConfigurationListMsg.
     * @throws SearchException
     */
    public ProxyConfigurationListMsg searchProxyConfiguration(EmptyServiceMessage rq)
            throws SearchException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationListMsg> rs;
        if ((service != null)) {
            rs = service.searchProxyConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.searchProxyConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchProxyConfiguration.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the ProxyConfigurationListMsg.
     * @throws SearchException
     */
    public ProxyConfigurationListMsg searchProxyConfiguration(EmptyServiceMessage rq,
            Subject subject) throws SearchException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationListMsg> rs;
        if ((service != null)) {
            rs = service.searchProxyConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.searchProxyConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the ProxyConfiguration.
     *
     * @param rq the ProxyConfigurationSearchMsg.
     * @return the ProxyConfigurationMsg.
     * @throws SearchException
     */
    public ProxyConfigurationMsg getProxyConfiguration(ProxyConfigurationSearchMsg rq)
            throws SearchException {
        ServiceRequest<ProxyConfigurationSearchMsg> request = new ServiceRequest<ProxyConfigurationSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.getProxyConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.getProxyConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the ProxyConfiguration.
     *
     * @param subject the Subject.
     * @param rq the ProxyConfigurationSearchMsg.
     * @return the ProxyConfigurationMsg.
     * @throws SearchException
     */
    public ProxyConfigurationMsg getProxyConfiguration(ProxyConfigurationSearchMsg rq,
            Subject subject) throws SearchException {
        ServiceRequest<ProxyConfigurationSearchMsg> request = new ServiceRequest<ProxyConfigurationSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<ProxyConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.getProxyConfiguration(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestEngineConfiguration.getProxyConfiguration");
        }
        return rs.getResponseMessage();
    }
}