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
package org.nabucco.testautomation.ui.rcp.base.text;

import java.lang.reflect.Method;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NText;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.model.NTextMiniModel;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.AbstractBaseTypeWidgetCreator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.listener.validation.DatatypeModifyListener;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.ui.rcp.images.TestautomationImageRegistry;


/**
 * TextAreaCombinationWidgetCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TextAreaCombinationWidgetCreator extends
		AbstractBaseTypeWidgetCreator<Name> {

	private GridData data;
	
	private BaseTypeWidgetFactory widgetFactory;
	
	private Composite parent;
	
	private String masterBlockId;
	
	private ViewModel externalViewModel;
	
	private NabuccoProperty property;
	
	private boolean readOnly;
	
	private NText text;
	
	/**
	 * Creates a new {@link TextAreaCombinationWidgetCreator} instance.
	 * 
	 * @param nft
	 *            the nabucco form toolkit
	 */
	public TextAreaCombinationWidgetCreator(NabuccoFormToolkit nft) {
		super(nft);
	}

	/**
	 * 
	 * @param data 
	 * @param externalViewModel
	 * @param data
	 * @param masterBlockId
	 * @param readOnly 
	 * @param widgetFactory2
	 */
	public Control createWidget(Composite parent, GridData data, Datatype datatype, NabuccoProperty property, ViewModel externalViewModel,
			BaseTypeWidgetFactory widgetFactory, String masterBlockId, boolean readOnly) {

		Control result = null;
		
		this.parent = parent;
		this.data = data;
		this.property = property;
		this.masterBlockId = masterBlockId;
		this.externalViewModel = externalViewModel;
		this.widgetFactory = widgetFactory;
		this.readOnly = readOnly;
		this.text = (NText) property.getInstance();
		
		NTextMiniModel model = new NTextMiniModel(text, externalViewModel, datatype);
		result = this.layoutDocumentationComposite(model);
		return result;
	}

	private Control layoutDocumentationComposite(NTextMiniModel model) {
		
		NabuccoFormToolkit formToolkit = super.getFormToolkit();
		
		// Create Label
		Label label = widgetFactory.createLabel(parent, masterBlockId + "." + property.getName());
		label.setToolTipText(label.getText());
		label.setLayoutData(data);

		// Create Composite for Documentation
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 1;
		Composite composite = formToolkit.createComposite(parent, layout);

		// Create TextInput
		Text documentationTextArea = formToolkit.createTextarea(composite, readOnly);
		documentationTextArea.setText(text.getValue());
		GridData areaLayoutData = new GridData();
		areaLayoutData.grabExcessHorizontalSpace = true;
		areaLayoutData.grabExcessVerticalSpace = false;;
		areaLayoutData.minimumHeight = 120;
		areaLayoutData.minimumWidth = 120;
		areaLayoutData.heightHint = 120;
		areaLayoutData.horizontalAlignment = SWT.FILL;
		documentationTextArea.setLayoutData(areaLayoutData);

		DataBindingContext bindingContext = new DataBindingContext();
		IObservableValue uiElement = SWTObservables.observeText(documentationTextArea, SWT.Modify);
		IObservableValue modelElement = BeansObservables.observeValue(model, NTextMiniModel.PROPERTY_VALUE);
		documentationTextArea.addModifyListener(new DatatypeModifyListener(this.externalViewModel));
		bindingContext.bindValue(uiElement, modelElement, null, null);
		
		// Create Button
		Button button = formToolkit.createFlatButton(composite, ImageProvider.createImage(TestautomationImageRegistry.ICON_DETAILS_DIALOG.getId()));
		GridData buttonLayoutData = new GridData();
		buttonLayoutData.verticalAlignment = SWT.TOP;
		buttonLayoutData.grabExcessHorizontalSpace = false;
		buttonLayoutData.grabExcessVerticalSpace = false;
		buttonLayoutData.heightHint = 20;
		buttonLayoutData.widthHint = 20;
		
		button.setLayoutData(buttonLayoutData);
		button.setBackground(null);
		button.addSelectionListener(new OpenDialogListener(model, externalViewModel, readOnly));

		return composite;
	}

	@Override
	protected Control createWidget(Composite parent, Name specialized,
			Method method, Object object, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager, String propertyName) {
		throw new UnsupportedOperationException();
	}
	
}
