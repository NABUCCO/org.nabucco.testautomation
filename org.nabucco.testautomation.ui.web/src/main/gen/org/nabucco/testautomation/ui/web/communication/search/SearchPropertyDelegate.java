/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
