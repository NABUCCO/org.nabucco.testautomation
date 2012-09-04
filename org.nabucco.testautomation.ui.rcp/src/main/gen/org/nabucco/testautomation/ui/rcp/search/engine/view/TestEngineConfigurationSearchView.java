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
package org.nabucco.testautomation.ui.rcp.search.engine.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;
import org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchViewModel;

/**
 * TestEngineConfigurationSearchView<p/>Search view for TestEngineConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA6 AG, 2010-06-30
 */
public class TestEngineConfigurationSearchView extends
        AbstractNabuccoSearchView<TestEngineConfigurationSearchViewModel> implements
        NabuccoSearchView {

    private TestEngineConfigurationSearchViewModel model;

    public static final String ID = "org.nabucco.testautomation.ui.search.engine.TestEngineConfigurationSearchView";

    /** Constructs a new TestEngineConfigurationSearchView instance. */
    public TestEngineConfigurationSearchView() {
        super();
        model = new TestEngineConfigurationSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public TestEngineConfigurationSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return TestEngineConfigurationSearchView.ID;
    }
}
