/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.impl.service.produce;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;

/**
 * ProduceTestEngineConfigurationCloneServiceHandler<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public abstract class ProduceTestEngineConfigurationCloneServiceHandler extends
        ServiceHandlerSupport implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.impl.service.produce.ProduceTestEngineConfigurationCloneServiceHandler";

    /** Constructs a new ProduceTestEngineConfigurationCloneServiceHandler instance. */
    public ProduceTestEngineConfigurationCloneServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationMsg>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<TestEngineConfigurationMsg> invoke(
            ServiceRequest<TestEngineConfigurationMsg> rq) throws ProduceException {
        ServiceResponse<TestEngineConfigurationMsg> rs;
        TestEngineConfigurationMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceTestEngineConfigurationClone(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<TestEngineConfigurationMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProduceException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProduceException wrappedException = new ProduceException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProduceException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method produceTestEngineConfigurationClone.
     *
     * @param msg the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws ProduceException
     */
    protected abstract TestEngineConfigurationMsg produceTestEngineConfigurationClone(
            TestEngineConfigurationMsg msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
