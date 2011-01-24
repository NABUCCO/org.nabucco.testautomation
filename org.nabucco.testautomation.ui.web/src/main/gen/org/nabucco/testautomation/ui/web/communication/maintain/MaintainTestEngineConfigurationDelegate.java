/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;

/**
 * MaintainTestEngineConfigurationDelegate<p/>Property maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class MaintainTestEngineConfigurationDelegate extends ServiceDelegateSupport {

    private MaintainTestEngineConfiguration service;

    /**
     * Constructs a new MaintainTestEngineConfigurationDelegate instance.
     *
     * @param service the MaintainTestEngineConfiguration.
     */
    public MaintainTestEngineConfigurationDelegate(MaintainTestEngineConfiguration service) {
        super();
        this.service = service;
    }

    /**
     * MaintainTestEngineConfiguration.
     *
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws MaintainException
     */
    public TestEngineConfigurationMsg maintainTestEngineConfiguration(TestEngineConfigurationMsg rq)
            throws MaintainException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.maintainTestEngineConfiguration(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainTestEngineConfiguration.maintainTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }

    /**
     * MaintainTestEngineConfiguration.
     *
     * @param subject the Subject.
     * @param rq the TestEngineConfigurationMsg.
     * @return the TestEngineConfigurationMsg.
     * @throws MaintainException
     */
    public TestEngineConfigurationMsg maintainTestEngineConfiguration(
            TestEngineConfigurationMsg rq, Subject subject) throws MaintainException {
        ServiceRequest<TestEngineConfigurationMsg> request = new ServiceRequest<TestEngineConfigurationMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TestEngineConfigurationMsg> rs;
        if ((service != null)) {
            rs = service.maintainTestEngineConfiguration(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainTestEngineConfiguration.maintainTestEngineConfiguration");
        }
        return rs.getResponseMessage();
    }
}
