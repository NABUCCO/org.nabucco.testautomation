/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
