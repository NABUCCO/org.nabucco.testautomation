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
package org.nabucco.testautomation.ui.rcp.multipage.detail;

import java.util.Set;

import org.eclipse.ui.forms.IManagedForm;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.detail.DynamicCodeEnabledGeneralDetailPageView;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.component.multipage.model.MultiPageEditViewModel;
import org.nabucco.framework.plugin.base.view.ManagedFormViewPart;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

public class TestautomationDetailPageView<M extends MultiPageEditViewModel> extends DynamicCodeEnabledGeneralDetailPageView<M> {


	public TestautomationDetailPageView(MasterDetailBlock<M> block,
			IManagedForm managedForm, ManagedFormViewPart<M> parentView,
			NabuccoMessageManager nabuccoMessageManager,
			String idOfMasterBlock, String detailTitle,
			Set<String> invisibleProperties, Set<String> readOnlyProperties) {
		super(block, managedForm, parentView, nabuccoMessageManager, idOfMasterBlock,
				detailTitle, invisibleProperties, readOnlyProperties);
	}

	@Override
	protected GeneralDetailPageViewLayouter getLayouter(String detailTitle) {
		return new TestautomationDetailPageViewLayouter(detailTitle);
	}

}
