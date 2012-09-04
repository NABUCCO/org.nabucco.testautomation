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
