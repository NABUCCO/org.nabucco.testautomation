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
package org.nabucco.testautomation.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
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
     * @param session the NabuccoSession.
     * @param rq the ProducePropertyMsg.
     * @return the PropertyMsg.
     * @throws ProduceException
     */
    public PropertyMsg produceProperty(ProducePropertyMsg rq, NabuccoSession session)
            throws ProduceException {
        ServiceRequest<ProducePropertyMsg> request = new ServiceRequest<ProducePropertyMsg>(
                super.createServiceContext(session));
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
     * @param session the NabuccoSession.
     * @param rq the PropertyMsg.
     * @return the PropertyMsg.
     * @throws ProduceException
     */
    public PropertyMsg producePropertyClone(PropertyMsg rq, NabuccoSession session)
            throws ProduceException {
        ServiceRequest<PropertyMsg> request = new ServiceRequest<PropertyMsg>(
                super.createServiceContext(session));
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
