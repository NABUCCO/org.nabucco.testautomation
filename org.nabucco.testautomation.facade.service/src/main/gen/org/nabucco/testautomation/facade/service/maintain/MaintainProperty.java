/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.PropertyMsg;

/**
 * MaintainProperty<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface MaintainProperty extends Service {

    /**
     * Missing description at method maintainProperty.
     *
     * @param rq the ServiceRequest<PropertyMsg>.
     * @return the ServiceResponse<PropertyMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PropertyMsg> maintainProperty(ServiceRequest<PropertyMsg> rq)
            throws MaintainException;
}
