/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.facade.message.PropertyListMsg;
import org.nabucco.testautomation.facade.message.PropertySearchMsg;

/**
 * SearchProperty<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public interface SearchProperty extends Service {

    /**
     * Missing description at method searchProperty.
     *
     * @param rq the ServiceRequest<PropertySearchMsg>.
     * @return the ServiceResponse<PropertyListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PropertyListMsg> searchProperty(ServiceRequest<PropertySearchMsg> rq)
            throws SearchException;
}
