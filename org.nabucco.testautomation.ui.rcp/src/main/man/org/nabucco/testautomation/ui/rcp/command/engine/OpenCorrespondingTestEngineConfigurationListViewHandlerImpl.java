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
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.plugin.base.command.AbstractNabuccoOpenCorrespondingListViewHandlerImpl;
import org.nabucco.framework.plugin.base.model.ListViewModel;
import org.nabucco.testautomation.ui.rcp.browser.engine.TestEngineConfigurationListViewBrowserElement;
import org.nabucco.testautomation.ui.rcp.command.engine.OpenCorrespondingTestEngineConfigurationListViewHandler;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListView;


/**
 * OpenCorrespondingTestEngineConfigurationListViewHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class OpenCorrespondingTestEngineConfigurationListViewHandlerImpl
        extends
        AbstractNabuccoOpenCorrespondingListViewHandlerImpl<TestEngineConfigurationListViewBrowserElement, ListViewModel<?>>
        implements OpenCorrespondingTestEngineConfigurationListViewHandler {

    @Override
    public void openCorrespondingTestEngineConfigurationListView() {
        super.run();

    }

    @Override
    protected String getListViewId() {
        return TestEngineConfigurationListView.ID;
    }

}
