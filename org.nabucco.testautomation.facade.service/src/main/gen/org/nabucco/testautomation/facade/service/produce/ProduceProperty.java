/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.ProducePropertyMsg;
import org.nabucco.testautomation.facade.message.PropertyMsg;

/**
 * ProduceProperty<p/>Property produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface ProduceProperty extends Service {

    /**
     * Missing description at method produceProperty.
     *
     * @param rq the ServiceRequest<ProducePropertyMsg>.
     * @return the ServiceResponse<PropertyMsg>.
     * @throws ProduceException
     */
    ServiceResponse<PropertyMsg> produceProperty(ServiceRequest<ProducePropertyMsg> rq)
            throws ProduceException;

    /**
     * Missing description at method producePropertyClone.
     *
     * @param rq the ServiceRequest<PropertyMsg>.
     * @return the ServiceResponse<PropertyMsg>.
     * @throws ProduceException
     */
    ServiceResponse<PropertyMsg> producePropertyClone(ServiceRequest<PropertyMsg> rq)
            throws ProduceException;
}
