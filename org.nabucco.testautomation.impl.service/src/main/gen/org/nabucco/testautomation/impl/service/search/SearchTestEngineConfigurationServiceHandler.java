/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.impl.service.search;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;

/**
 * SearchTestEngineConfigurationServiceHandler<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public abstract class SearchTestEngineConfigurationServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.impl.service.search.SearchTestEngineConfigurationServiceHandler";

    /** Constructs a new SearchTestEngineConfigurationServiceHandler instance. */
    public SearchTestEngineConfigurationServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationSearchMsg>.
     * @return the ServiceResponse<TestEngineConfigurationListMsg>.
     * @throws SearchException
     */
    protected ServiceResponse<TestEngineConfigurationListMsg> invoke(
            ServiceRequest<TestEngineConfigurationSearchMsg> rq) throws SearchException {
        ServiceResponse<TestEngineConfigurationListMsg> rs;
        TestEngineConfigurationListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.searchTestEngineConfiguration(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<TestEngineConfigurationListMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (SearchException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            SearchException wrappedException = new SearchException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new SearchException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method searchTestEngineConfiguration.
     *
     * @param msg the TestEngineConfigurationSearchMsg.
     * @return the TestEngineConfigurationListMsg.
     * @throws SearchException
     */
    protected abstract TestEngineConfigurationListMsg searchTestEngineConfiguration(
            TestEngineConfigurationSearchMsg msg) throws SearchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
