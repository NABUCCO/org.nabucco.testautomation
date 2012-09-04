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

import java.util.List;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.framework.plugin.base.model.browser.BrowserListElement;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.ui.rcp.list.engine.model.TestEngineConfigurationListViewModel;

/**
 * TestEngineConfigurationListViewBrowserElement
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewBrowserElement extends
        BrowserListElement<TestEngineConfigurationListViewModel> implements
        NabuccoInjectionReciever {

    private TestEngineConfigurationListViewBrowserElementHandler listViewBrowserElementHandler;

    /**
     * Constructs a new TestEngineConfigurationListViewBrowserElement instance.
     *
     * @param datatypeList the List<TestEngineConfiguration>.
     */
    public TestEngineConfigurationListViewBrowserElement(
            final List<TestEngineConfiguration> datatypeList) {
        this(datatypeList.toArray(new TestEngineConfiguration[datatypeList.size()]));
    }

    /**
     * Constructs a new TestEngineConfigurationListViewBrowserElement instance.
     *
     * @param datatypeArray the TestEngineConfiguration[].
     */
    public TestEngineConfigurationListViewBrowserElement(
            final TestEngineConfiguration[] datatypeArray) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(TestEngineConfigurationListViewBrowserElement.class);
        listViewBrowserElementHandler = instance
                .inject(TestEngineConfigurationListViewBrowserElementHandler.class);
        viewModel = new TestEngineConfigurationListViewModel();
        viewModel.setElements(datatypeArray);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        listViewBrowserElementHandler.createChildren(viewModel, this);
    }

    @Override
    public void removeBrowserElement(final BrowserElement element) {
        super.removeBrowserElement(element);
        listViewBrowserElementHandler.removeChild(element, this);
    }
}
