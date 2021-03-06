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
package org.nabucco.testautomation.facade.component;

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.common.authorization.facade.component.AuthorizationComponent;
import org.nabucco.testautomation.facade.service.export.ExportTestautomation;
import org.nabucco.testautomation.facade.service.importing.ImportTestautomation;
import org.nabucco.testautomation.facade.service.maintain.MaintainProperty;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.produce.ProduceProperty;
import org.nabucco.testautomation.facade.service.produce.ProduceTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.search.SearchProperty;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;

/**
 * TestautomationComponent<p/>BaseComponent for Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface TestautomationComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.testautomation";

    /**
     * Getter for the AuthorizationComponent.
     *
     * @return the AuthorizationComponent.
     * @throws ServiceException
     */
    AuthorizationComponent getAuthorizationComponent() throws ServiceException;

    /**
     * Getter for the MaintainProperty.
     *
     * @return the MaintainProperty.
     * @throws ServiceException
     */
    MaintainProperty getMaintainProperty() throws ServiceException;

    /**
     * Getter for the ProduceProperty.
     *
     * @return the ProduceProperty.
     * @throws ServiceException
     */
    ProduceProperty getProduceProperty() throws ServiceException;

    /**
     * Getter for the SearchProperty.
     *
     * @return the SearchProperty.
     * @throws ServiceException
     */
    SearchProperty getSearchProperty() throws ServiceException;

    /**
     * Getter for the MaintainTestEngineConfiguration.
     *
     * @return the MaintainTestEngineConfiguration.
     * @throws ServiceException
     */
    MaintainTestEngineConfiguration getMaintainTestEngineConfiguration() throws ServiceException;

    /**
     * Getter for the ProduceTestEngineConfiguration.
     *
     * @return the ProduceTestEngineConfiguration.
     * @throws ServiceException
     */
    ProduceTestEngineConfiguration getProduceTestEngineConfiguration() throws ServiceException;

    /**
     * Getter for the SearchTestEngineConfiguration.
     *
     * @return the SearchTestEngineConfiguration.
     * @throws ServiceException
     */
    SearchTestEngineConfiguration getSearchTestEngineConfiguration() throws ServiceException;

    /**
     * Getter for the ExportTestautomation.
     *
     * @return the ExportTestautomation.
     * @throws ServiceException
     */
    ExportTestautomation getExportTestautomation() throws ServiceException;

    /**
     * Getter for the ImportTestautomation.
     *
     * @return the ImportTestautomation.
     * @throws ServiceException
     */
    ImportTestautomation getImportTestautomation() throws ServiceException;
}
