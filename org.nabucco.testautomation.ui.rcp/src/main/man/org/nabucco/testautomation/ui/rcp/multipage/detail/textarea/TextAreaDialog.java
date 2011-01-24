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
package org.nabucco.testautomation.ui.rcp.multipage.detail.textarea;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.model.NTextMiniModel;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.ui.rcp.images.TestautomationImageRegistry;


/**
 * TextAreaDialog
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TextAreaDialog extends TitleAreaDialog{

	private static final String ID = "org.nabucco.testautomation.ui.rcp.multipage.detail.textarea.TextAreaDialog";
	
	protected Display display;

	protected ScrolledComposite scrolledComposite;

	protected int style;

	protected boolean readOnly;

	private Text textarea;

	private NTextMiniModel model;

	/**
	 * Creates a new {@link TextAreaDialog} instance.
	 */
	public TextAreaDialog(Shell shell, NTextMiniModel model, boolean readOnly) {
		super(shell);
		super.setShellStyle(getShellStyle() | SWT.RESIZE);
		this.readOnly = readOnly;
		this.model = model;
		display = Activator.getDefault().getWorkbench().getDisplay();
		shell.setLayout(new GridLayout(1, false));
	}


	@Override
	public void create() {
		super.create();
		setTitle(I18N.i18n(ID + "." + "title"));
		setMessage(I18N.i18n(ID + "." + "message"));
		setDefaultImage(ImageProvider.createImage(TestautomationImageRegistry.ICON_DETAILS_DIALOG.getId()));
	}



	@Override
	protected Control createDialogArea(Composite parent) {
		// Create new composite as container
		final Composite area = new Composite(parent, SWT.NULL);
		area.setLayout(new GridLayout());
		GridData layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = SWT.FILL;
		layoutData.verticalAlignment = SWT.FILL;
		layoutData.widthHint = 700;
		layoutData.heightHint = 500;
		area.setLayoutData(layoutData);
		NabuccoFormToolkit formToolkit = new NabuccoFormToolkit(area);
		this.textarea = formToolkit.createTextarea(area, readOnly);
		this.textarea.setLayoutData(layoutData);
		textarea.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		this.textarea.setText(model.getValue());
		return area;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// Create Open button
		Button okButton = createButton(parent, 9999, I18N.i18n(ID + "." + "ok"), true);
		// Add a SelectionListener
		okButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				model.setValue(textarea.getText());
				// Close dialog
				close();
			}
		});
	
		// Create Cancel button
		Button cancelButton = createButton(parent, CANCEL, I18N.i18n(ID + "." + "cancel"), false);
		// Add a SelectionListener
		cancelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setReturnCode(CANCEL);
				close();
			}
		});
	}













}
