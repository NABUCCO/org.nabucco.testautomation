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
package org.nabucco.testautomation.impl.service.search;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.facade.message.PropertyListMsg;
import org.nabucco.testautomation.facade.message.PropertySearchMsg;
import org.nabucco.testautomation.facade.service.search.SearchProperty;

/**
 * SearchPropertyImpl<p/>Property search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class SearchPropertyImpl extends ServiceSupport implements SearchProperty {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchProperty";

    private EntityManager em;

    private SearchPropertyServiceHandler searchPropertyServiceHandler;

    /** Constructs a new SearchPropertyImpl instance. */
    public SearchPropertyImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchPropertyServiceHandler = injector.inject(SearchPropertyServiceHandler.getId());
        if ((this.searchPropertyServiceHandler != null)) {
            this.searchPropertyServiceHandler.setEntityManager(this.em);
            this.searchPropertyServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<PropertyListMsg> searchProperty(ServiceRequest<PropertySearchMsg> rq)
            throws SearchException {
        if ((this.searchPropertyServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProperty().");
            throw new InjectionException(
                    "No service implementation configured for searchProperty().");
        }
        ServiceResponse<PropertyListMsg> rs;
        this.searchPropertyServiceHandler.init();
        rs = this.searchPropertyServiceHandler.invoke(rq);
        this.searchPropertyServiceHandler.finish();
        return rs;
    }
}
