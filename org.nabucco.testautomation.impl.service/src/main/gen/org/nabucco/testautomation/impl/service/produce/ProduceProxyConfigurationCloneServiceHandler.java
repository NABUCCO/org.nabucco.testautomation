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
import org.nabucco.testautomation.facade.message.ProxyConfigurationMsg;

/**
 * ProduceProxyConfigurationCloneServiceHandler<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public abstract class ProduceProxyConfigurationCloneServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.impl.service.produce.ProduceProxyConfigurationCloneServiceHandler";

    /** Constructs a new ProduceProxyConfigurationCloneServiceHandler instance. */
    public ProduceProxyConfigurationCloneServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<ProxyConfigurationMsg>.
     * @return the ServiceResponse<ProxyConfigurationMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<ProxyConfigurationMsg> invoke(ServiceRequest<ProxyConfigurationMsg> rq)
            throws ProduceException {
        ServiceResponse<ProxyConfigurationMsg> rs;
        ProxyConfigurationMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceProxyConfigurationClone(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<ProxyConfigurationMsg>(rq.getContext());
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
            throw new ProduceException(e.getMessage());
        }
    }

    /**
     * Missing description at method produceProxyConfigurationClone.
     *
     * @param msg the ProxyConfigurationMsg.
     * @return the ProxyConfigurationMsg.
     * @throws ProduceException
     */
    protected abstract ProxyConfigurationMsg produceProxyConfigurationClone(
            ProxyConfigurationMsg msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}