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

import java.io.Serializable;
import java.util.Map;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.model.browser.DatatypeBrowserElement;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;


/**
 * TestEngineConfigurationEditViewBrowserElement
 *
 * @author Undefined
 */
public class TestEngineConfigurationEditViewBrowserElement extends DatatypeBrowserElement implements
        NabuccoInjectionReciever {

    private EngineMaintenanceMultiPageEditViewModel viewModel;

    private TestEngineConfigurationEditViewBrowserElementHandler browserHandler;

    /**
     * Constructs a new TestEngineConfigurationEditViewBrowserElement instance.
     *
     * @param datatype the TestEngineConfiguration.
     */
    public TestEngineConfigurationEditViewBrowserElement(final TestEngineConfiguration datatype) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(TestEngineConfigurationEditViewBrowserElement.class);
        browserHandler = instance
                .inject(TestEngineConfigurationEditViewBrowserElementHandler.class);
        viewModel = new EngineMaintenanceMultiPageEditViewModel();
        viewModel.setTestEngineConfiguration(datatype);
    }

    @Override
    protected void fillDatatype() {
        viewModel = browserHandler.loadFull(viewModel);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        browserHandler.createChildren(viewModel, this);
    }

    @Override
    public Map<String, Serializable> getValues() {
        return this.viewModel.getValues();
    }

    /**
     * Getter for the ViewModel.
     *
     * @return the TestEngineConfigurationEditViewModel.
     */
    public EngineMaintenanceMultiPageEditViewModel getViewModel() {
        return this.viewModel;
    }

    /**
     * Setter for the ViewModel.
     *
     * @param viewModel the TestEngineConfigurationEditViewModel.
     */
    public void setViewModel(EngineMaintenanceMultiPageEditViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
