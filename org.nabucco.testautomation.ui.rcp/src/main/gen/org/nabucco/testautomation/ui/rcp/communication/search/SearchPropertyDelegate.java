/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the PropertySearchMsg.
     * @return the PropertyListMsg.
     * @throws ClientException
     */
    public PropertyListMsg searchProperty(PropertySearchMsg rq) throws ClientException {
        ServiceRequest<PropertySearchMsg> request = new ServiceRequest<PropertySearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PropertyListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchProperty(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchPropertyDelegate.class, "Service: ",
                                "SearchProperty.searchProperty", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProperty.searchProperty");
    }
}
