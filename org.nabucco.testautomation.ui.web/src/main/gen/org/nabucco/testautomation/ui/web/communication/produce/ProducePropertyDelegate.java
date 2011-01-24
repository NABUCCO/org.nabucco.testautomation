/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
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
     * @throws ProduceException
     */
    public PropertyMsg produceProperty(ProducePropertyMsg rq) throws ProduceException {
        ServiceRequest<ProducePropertyMsg> request = new ServiceRequest<ProducePropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            rs = service.produceProperty(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceProperty.produceProperty");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceProperty.
     *
     * @param subject the Subject.
     * @param rq the ProducePropertyMsg.
     * @return the PropertyMsg.
     * @throws ProduceException
     */
    public PropertyMsg produceProperty(ProducePropertyMsg rq, Subject subject)
            throws ProduceException {
        ServiceRequest<ProducePropertyMsg> request = new ServiceRequest<ProducePropertyMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            rs = service.produceProperty(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceProperty.produceProperty");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProducePropertyClone.
     *
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws ProduceException
     */
    public PropertyMsg producePropertyClone(PropertyMsg rq) throws ProduceException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            rs = service.producePropertyClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceProperty.producePropertyClone");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProducePropertyClone.
     *
     * @param subject the Subject.
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws ProduceException
     */
    public PropertyMsg producePropertyClone(PropertyMsg rq, Subject subject)
            throws ProduceException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            rs = service.producePropertyClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceProperty.producePropertyClone");
        }
        return rs.getResponseMessage();
    }
}
