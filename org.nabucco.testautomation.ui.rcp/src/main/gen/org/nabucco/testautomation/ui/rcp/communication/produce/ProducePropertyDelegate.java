/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.facade.message.ProducePropertyMsg;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.facade.service.produce.ProduceProperty;

/**
 * ProducePropertyDelegate<p/>Property produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class ProducePropertyDelegate extends ServiceDelegateSupport {

    private ProduceProperty service;

    /**
     * Constructs a new ProducePropertyDelegate instance.
     *
     * @param service the ProduceProperty.
     */
    public ProducePropertyDelegate(ProduceProperty service) {
        super();
        this.service = service;
    }

    /**
     * ProduceProperty.
     *
     * @param rq the ProducePropertyMsg.
     * @return the PropertyMsg.
     * @throws ClientException
     */
    public PropertyMsg produceProperty(ProducePropertyMsg rq) throws ClientException {
        ServiceRequest<ProducePropertyMsg> request = new ServiceRequest<ProducePropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceProperty(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProducePropertyDelegate.class, "Service: ",
                                "ProduceProperty.produceProperty", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceProperty.produceProperty");
    }

    /**
     * ProducePropertyClone.
     *
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws ClientException
     */
    public PropertyMsg producePropertyClone(PropertyMsg rq) throws ClientException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.producePropertyClone(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProducePropertyDelegate.class, "Service: ",
                                "ProduceProperty.producePropertyClone", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceProperty.producePropertyClone");
    }
}
