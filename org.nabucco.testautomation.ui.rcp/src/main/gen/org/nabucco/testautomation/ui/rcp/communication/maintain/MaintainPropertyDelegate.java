/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws ClientException
     */
    public PropertyMsg maintainProperty(PropertyMsg rq) throws ClientException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainProperty(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainPropertyDelegate.class, "Service: ",
                                "MaintainProperty.maintainProperty", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainProperty.maintainProperty");
    }
}
