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
import org.nabucco.framework.base.facade.datatype.file.TextFileContent;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.detail.DynamicCodeEnabledGeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.facade.datatype.base.ErrorMessage;
import org.nabucco.testautomation.facade.datatype.base.SqlValue;
import org.nabucco.testautomation.facade.datatype.base.XmlValue;
import org.nabucco.testautomation.ui.rcp.base.text.TextAreaCombinationWidgetCreator;

/**
 * TestautomationDetailPageViewLayouter
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestautomationDetailPageViewLayouter extends DynamicCodeEnabledGeneralDetailPageViewLayouter {

	public TestautomationDetailPageViewLayouter(String detailTitle) {
		super(detailTitle);
	}

	@Override
	protected Control layoutElement(Composite parent,
			BaseTypeWidgetFactory widgetFactory, Datatype datatype,
			String masterBlockId, NabuccoProperty property, 
			GridData data, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {

		String propertyName = property.getName();
		String firstChar = propertyName.substring(0, 1).toUpperCase();
		String lastPart = propertyName.substring(1);
		Object instance = property.getInstance();
		
		if (instance == null) {
			property = property.createProperty(this.initializeBasetype(datatype, firstChar, lastPart));
		}
		
		instance = property.getInstance();
		if (instance instanceof Documentation
				|| instance instanceof XmlValue
				|| instance instanceof SqlValue
				|| instance instanceof ErrorMessage
				|| instance instanceof LogTrace
				|| instance instanceof TextFileContent) {
			return this.layoutLongText(parent, widgetFactory, datatype,
					masterBlockId, property, data, readOnly,
					externalViewModel, messageManager);
		}

		return super.layoutElement(parent, widgetFactory, datatype,
				masterBlockId, property, data, readOnly,
				externalViewModel, messageManager);
	}

	private Control layoutLongText(Composite parent,
			BaseTypeWidgetFactory widgetFactory, Datatype datatype,
			String masterBlockId, NabuccoProperty property,
			GridData data, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {
		
		readOnly = !property.getConstraints().isEditable() || readOnly;
		
		NabuccoFormToolkit nft = widgetFactory.getNabuccoFormToolKit();
		TextAreaCombinationWidgetCreator widgetCreator = new TextAreaCombinationWidgetCreator(nft);
		Control newWidget = widgetCreator.createWidget(parent, data, datatype, property, externalViewModel, widgetFactory, masterBlockId, readOnly);
		
		if (newWidget == null) {
			Activator.getDefault().logError(
					"Cannot create Widget for " + property.getType().getSimpleName());
			newWidget = nft.createRealLabel(parent, "INVALID");
		} else {
			super.setDataForWidget(data, newWidget);
		}
		return null;
	}

}
