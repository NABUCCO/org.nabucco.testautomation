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
package org.nabucco.testautomation.ui.rcp.multipage.detail;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.documentation.Documentation;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.detail.DynamicCodeEnabledGeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.ui.rcp.multipage.detail.textarea.TextAreaCombinationWidgetCreator;


public class TestautomationDetailPageViewLayouter extends DynamicCodeEnabledGeneralDetailPageViewLayouter {

	public TestautomationDetailPageViewLayouter(String detailTitle) {
		super(detailTitle);
	}

	@Override
	protected Control layoutElement(Composite parent,
			BaseTypeWidgetFactory widgetFactory, Datatype datatype,
			String masterBlockId, Object property, String propertyName,
			GridData data, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {

		 if (property == null) {
		        String firstChar = propertyName.substring(0, 1).toUpperCase();
		        String lastPart = propertyName.substring(1);
	            property = this.initializeBasetype(datatype, firstChar, lastPart);
	        }
		
		if(property instanceof Documentation){
			return this.layoutDocumentation(parent, widgetFactory, datatype,
					masterBlockId, (Documentation) property, propertyName, data, readOnly,
					externalViewModel, messageManager);
		}

		return super.layoutElement(parent, widgetFactory, datatype,
				masterBlockId, property, propertyName, data, readOnly,
				externalViewModel, messageManager);
	}

	
	
	private Control layoutDocumentation(Composite parent,
			BaseTypeWidgetFactory widgetFactory, Datatype datatype,
			String masterBlockId, Documentation documentation, String propertyName,
			GridData data, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {
		
		NabuccoFormToolkit nft = widgetFactory.getNabuccoFormToolKit();
		TextAreaCombinationWidgetCreator widgetCreator = new TextAreaCombinationWidgetCreator(nft);
		Control newWidget = widgetCreator.createWidget(parent, data, datatype, documentation, externalViewModel, widgetFactory, masterBlockId, readOnly);
		
		if (newWidget == null) {
			Activator.getDefault().logError(
					"Cannot create FileProperty Widget [null].");
			newWidget = nft.createRealLabel(parent, "INVALID");
		} else {
				super.setDataForWidget(data, newWidget);
		}
		return null;
	}


}
