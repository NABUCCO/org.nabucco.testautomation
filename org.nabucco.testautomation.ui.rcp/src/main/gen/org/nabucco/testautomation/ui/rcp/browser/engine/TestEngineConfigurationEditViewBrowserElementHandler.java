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
package org.nabucco.testautomation.ui.rcp.browser.engine;

import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;


/**
 * TestEngineConfigurationEditViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface TestEngineConfigurationEditViewBrowserElementHandler extends CommandHandler {

    /**
     * LoadFull.
     *
     * @param testEngineConfiguration the TestEngineConfigurationEditViewModel.
     * @return the TestEngineConfigurationEditViewModel.
     */
	EngineMaintenanceMultiPageEditViewModel loadFull(
            final EngineMaintenanceMultiPageEditViewModel testEngineConfiguration);

    /**
     * CreateChildren.
     *
     * @param element the TestEngineConfigurationEditViewBrowserElement.
     * @param viewModel the TestEngineConfigurationEditViewModel.
     */
    void createChildren(final EngineMaintenanceMultiPageEditViewModel viewModel,
            final TestEngineConfigurationEditViewBrowserElement element);
}
