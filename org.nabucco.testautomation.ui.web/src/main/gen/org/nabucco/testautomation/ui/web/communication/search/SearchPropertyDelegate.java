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
package org.nabucco.testautomation.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.facade.message.PropertyListMsg;
import org.nabucco.testautomation.facade.message.PropertySearchMsg;
import org.nabucco.testautomation.facade.service.search.SearchProperty;

/**
 * SearchPropertyDelegate<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class SearchPropertyDelegate extends ServiceDelegateSupport {

    private SearchProperty service;

    /**
     * Constructs a new SearchPropertyDelegate instance.
     *
     * @param service the SearchProperty.
     */
    public SearchPropertyDelegate(SearchProperty service) {
        super();
        this.service = service;
    }

    /**
     * SearchProperty.
     *
     * @param session the NabuccoSession.
     * @param rq the PropertySearchMsg.
     * @return the PropertyListMsg.
     * @throws SearchException
     */
    public PropertyListMsg searchProperty(PropertySearchMsg rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<PropertySearchMsg> request = new ServiceRequest<PropertySearchMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<PropertyListMsg> rs;
        if ((service != null)) {
            rs = service.searchProperty(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchProperty.searchProperty");
        }
        return rs.getResponseMessage();
    }
}
