/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration;

import java.util.Set;

import org.eclipse.ui.forms.IManagedForm;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.view.ManagedFormViewPart;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.ui.rcp.multipage.detail.TestautomationDetailPageView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;

/**
 * TestScriptDetailPageView
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestEngineConfigurationDetailPageView extends TestautomationDetailPageView<EngineMaintenanceMultiPageEditViewModel> {

    /**
     * Creates a new {@link TestEngineConfigurationDetailPageView} instance.
     * 
     * @param block
     *            the master detail block
     * @param managedForm
     *            the managed form
     * @param parentView
     *            the parent view
     * @param messageManager
     *            the message manager
     * @param masterId
     *            id of the master block
     * @param title
     *            the detail view title
     * @param invisibleProperties
     *            properties that are not visible
     * @param readOnlyProperties
     *            properties that are read-only
     */
    public TestEngineConfigurationDetailPageView(MasterDetailBlock<EngineMaintenanceMultiPageEditViewModel> block, IManagedForm managedForm,
            ManagedFormViewPart<EngineMaintenanceMultiPageEditViewModel> parentView, NabuccoMessageManager messageManager, String masterId,
            String title, Set<String> invisibleProperties, Set<String> readOnlyProperties) {
        super(block, managedForm, parentView, messageManager, masterId, title, invisibleProperties,
                readOnlyProperties);
    }

    @Override
    protected GeneralDetailPageViewLayouter getLayouter(String detailTitle) {
        return new TestEngineConfigurationDetailPageViewLayouter(detailTitle);
    }

}
