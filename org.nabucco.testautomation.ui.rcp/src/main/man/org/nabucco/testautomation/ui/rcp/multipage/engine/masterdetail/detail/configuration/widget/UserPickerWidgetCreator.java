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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.widget;

import java.lang.reflect.Method;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableLabelProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableSorter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.AbstractBaseTypeWidgetCreator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.component.newpicker.composite.element.ElementPickerComposite;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.table.TablePickerDialog;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.table.TablePickerDialogLabel;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.table.TablePickerDialogParameter;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * UserPickerWidgetCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class UserPickerWidgetCreator extends AbstractBaseTypeWidgetCreator<User> {

	private static final String ID = "org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.widget.UserPickerWidgetCreator";

	private static final String DIALOG_TITLE = ID + ".dialogTitle";

	private static final String SHELL_TITLE = ID + ".shellTitle";

	private static final String DIALOG_MESSAGE = ID + ".dialogMessage";

	private static final String TABLE_TITLE = ID + ".tableTitle";
	
	private Composite parent;
	private GridData data;
	private ViewModel externalViewModel;
	private String masterBlockId;

	private TestEngineConfiguration testEngineConfiguration;


	/**
	 * Creates a new {@link UserPickerWidgetCreator} instance.
	 * 
	 * @param nft
	 *            the form toolkit
	 */
	public UserPickerWidgetCreator(Composite parent, BaseTypeWidgetFactory widgetFactory, GridData data, NabuccoFormToolkit nft, ViewModel externalViewModel,
			String masterBlockId, User user, TestEngineConfiguration testEngineConfiguration) {
		super(nft);
		this.parent = parent;
		this.data = data;
		this.externalViewModel = externalViewModel;
		this.masterBlockId = masterBlockId;
		this.testEngineConfiguration = testEngineConfiguration;
	}

	public Control createWidgets() {

		Control result;

		UserPickerMiniModel model = new UserPickerMiniModel(externalViewModel, testEngineConfiguration, masterBlockId);

		BaseTypeWidgetFactory widgetFactory = new BaseTypeWidgetFactory(super.getFormToolkit());

		// Layout Metadata-Picker and Label
		Label label = widgetFactory.createLabel(parent, masterBlockId + "." + UserPickerMiniModel.PROPERTY_USER);
		label.setToolTipText(label.getText());
		label.setLayoutData(data);
		result = this.layoutPicker(model);

		return result;
	}


	/**
	 * Layout the script table.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param model
	 * 
	 * @return the layouted table
	 */
	private Control layoutPicker(UserPickerMiniModel model) {

		ElementPickerComposite<TablePickerDialog> picker = this.createPicker(parent, model);

		DataBindingContext bindingContext = new DataBindingContext();
		IObservableValue uiElement = SWTObservables.observeText(picker.getTextField(), SWT.Modify);
		IObservableValue modelElement = BeansObservables.observeValue(model, UserPickerMiniModel.PROPERTY_USER_NAME);

		bindingContext.bindValue(uiElement, modelElement, null, null);

		return picker;
	}

	/**
	 * Creates the picker composite.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param model
	 *            the mini model
	 * 
	 * @return the layouted composite
	 */
	private ElementPickerComposite<TablePickerDialog> createPicker(Composite parent, UserPickerMiniModel model) {
		TablePickerDialogParameter parameter = getTablePickerDialogParameter();
		TablePickerDialog dialog = new TablePickerDialog(parent.getShell(), parameter);
		dialog.addSelectionListener(UserPickerDialogListener.ID, new UserPickerDialogListener(model));
		return new ElementPickerComposite<TablePickerDialog>(parent, SWT.NONE, dialog, false);
	}
	
	private TablePickerDialogParameter getTablePickerDialogParameter() {
		TablePickerDialogLabel label = new TablePickerDialogLabel(SHELL_TITLE, DIALOG_TITLE, DIALOG_MESSAGE , TABLE_TITLE);
		
		UserPickerDialogContentProvider contentProvider = new UserPickerDialogContentProvider();
		NabuccoTableSorter tableSorter = null;
		UserPickerDialogLabelProvider userPickerDialogLabelProvider = new UserPickerDialogLabelProvider();
		
		
		UserPickerTableFilter filter = new UserPickerTableFilter();
		
		ILabelProvider[] columnLabelProviders = new ILabelProvider[]{userPickerDialogLabelProvider};
		NabuccoTableLabelProvider nabuccoTableLabelProvider = new NabuccoTableLabelProvider(columnLabelProviders);
		filter.setLabelProvider(nabuccoTableLabelProvider);
		
		NabuccoTableColumnInfo[] tableColumnInfo = createColumnInfo();
		
		NabuccoTableParameter tableParameter = new NabuccoTableParameter(tableSorter, filter, contentProvider, tableColumnInfo);
		TablePickerDialogParameter result = new TablePickerDialogParameter(label, tableParameter);
		result.setLabelProvider(userPickerDialogLabelProvider);
		result.setInput(tableParameter);
		return result;
	}

	private NabuccoTableColumnInfo[] createColumnInfo() {
		NabuccoTableColumnInfo[] result = new NabuccoTableColumnInfo[] { new NabuccoTableColumnInfo(
				ID + ".nameColumnTitle",
				ID + ".nameColumnTooltip", 200, SWT.LEFT, SWT.LEFT,
				new UserPickerDialogLabelProvider()) };
		return result;
	}
	


	@Override
	protected Control createWidget(Composite parent, User specialized, Method method, Object object, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager, String propertyName) {
		throw new UnsupportedOperationException();
	}

}
