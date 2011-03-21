/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainProperty;

/**
 * MaintainPropertyDelegate<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class MaintainPropertyDelegate extends ServiceDelegateSupport {

    private MaintainProperty service;

    /**
     * Constructs a new MaintainPropertyDelegate instance.
     *
     * @param service the MaintainProperty.
     */
    public MaintainPropertyDelegate(MaintainProperty service) {
        super();
        this.service = service;
    }

    /**
     * MaintainProperty.
     *
     * @param session the NabuccoSession.
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws MaintainException
     */
    public PropertyMsg maintainProperty(PropertyMsg rq, NabuccoSession session)
            throws MaintainException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            rs = service.maintainProperty(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainProperty.maintainProperty");
        }
        return rs.getResponseMessage();
    }
}
