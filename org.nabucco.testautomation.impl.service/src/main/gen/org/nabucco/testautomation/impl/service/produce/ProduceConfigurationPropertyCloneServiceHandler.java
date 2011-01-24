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
import org.nabucco.testautomation.facade.message.ConfigurationPropertyMsg;

/**
 * ProduceConfigurationPropertyCloneServiceHandler<p/>TestEngineConfiguration produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public abstract class ProduceConfigurationPropertyCloneServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.impl.service.produce.ProduceConfigurationPropertyCloneServiceHandler";

    /** Constructs a new ProduceConfigurationPropertyCloneServiceHandler instance. */
    public ProduceConfigurationPropertyCloneServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<ConfigurationPropertyMsg>.
     * @return the ServiceResponse<ConfigurationPropertyMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<ConfigurationPropertyMsg> invoke(
            ServiceRequest<ConfigurationPropertyMsg> rq) throws ProduceException {
        ServiceResponse<ConfigurationPropertyMsg> rs;
        ConfigurationPropertyMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceConfigurationPropertyClone(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<ConfigurationPropertyMsg>(rq.getContext());
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
     * Missing description at method produceConfigurationPropertyClone.
     *
     * @param msg the ConfigurationPropertyMsg.
     * @return the ConfigurationPropertyMsg.
     * @throws ProduceException
     */
    protected abstract ConfigurationPropertyMsg produceConfigurationPropertyClone(
            ConfigurationPropertyMsg msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
