/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;

/**
 * MaintainTestEngineConfiguration<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface MaintainTestEngineConfiguration extends Service {

    /**
     * Missing description at method maintainTestEngineConfiguration.
     *
     * @param rq the ServiceRequest<TestEngineConfigurationMsg>.
     * @return the ServiceResponse<TestEngineConfigurationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<TestEngineConfigurationMsg> maintainTestEngineConfiguration(
            ServiceRequest<TestEngineConfigurationMsg> rq) throws MaintainException;
}
