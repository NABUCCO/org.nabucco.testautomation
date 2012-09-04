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
package org.nabucco.testautomation.ui.rcp.base.dialog;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.tree.TreeFilter;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.tree.TreePickerDialog;

/**
 * OwnerSelectionTreePickerDialog
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class OwnerSelectionTreePickerDialog extends TreePickerDialog {

    public static final String ID = "org.nabucco.testautomation.ui.rcp.base.dialog.OwnerSelectionTreePickerDialog";

    private static final String OWNER = ".owner";

    public OwnerSelectionTreePickerDialog(Shell parentShell,
            OwnerSelectionTreePickerDialogParameter parameter) {
        super(parentShell, parameter);
    }

    @Override
    protected void createViewer(Composite parent) {
        Composite frame = new Composite(parent, SWT.NONE);
        frame.setLayout(new GridLayout(2, false));

        final OwnerSelectionTreePickerDialogParameter parameter = (OwnerSelectionTreePickerDialogParameter) super
                .getParameter();

        // Owner
        Label ownerLabel = new Label(frame, SWT.READ_ONLY);
        ownerLabel.setText(I18N.i18n(ID + OWNER));

        final Combo ownerDropDownBox = super.getToolkit().createDropdown(frame);
        GridData ownerLabelGridData = new GridData();
        ownerDropDownBox.setLayoutData(ownerLabelGridData);

        ownerDropDownBox.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                parameter.getContentProvider().setSelectedOwner(
                        ownerDropDownBox.getItem(ownerDropDownBox.getSelectionIndex()));
                treeViewer.refresh();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent arg0) {
                // do nothing

            }
        });

        String[] owners = parameter.getContentProvider().getOwners();
        ownerDropDownBox.setItems(owners);

        int defaultSelection = getDefaultSelection();
        if (defaultSelection < owners.length) {
            ownerDropDownBox.select(defaultSelection);
            parameter.getContentProvider().setSelectedOwner(owners[defaultSelection]);
        }

        // Placeholder
        Composite placeHolder = new Composite(frame, SWT.NONE);
        placeHolder.setLayout(new GridLayout());
        GridData placeHolderGridData = new GridData();
        placeHolderGridData.minimumHeight = 15;

        // Filter
        FormData filterArea = new FormData();
        filterArea.left = new FormAttachment(0, 0);
        filterArea.right = new FormAttachment(100, 0);
        filterArea.top = new FormAttachment(frame, 0, SWT.BOTTOM);
        filterArea.bottom = new FormAttachment(frame, 20, SWT.BOTTOM);

        Text filterInputText = super.getToolkit().createTextInput(parent);
        filterInputText.setLayoutData(filterArea);

        final TreeFilter filter = new TreeFilter();
        filterInputText.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent event) {
                Object source = event.getSource();
                Text filterInput = (Text) source;
                filter.setFilter(filterInput.getText());
                treeViewer.refresh();

                if (!filterInput.getText().isEmpty()) {
                    treeViewer.expandAll();
                }
            }
        });

        // Tree
        FormData treeArea = new FormData();
        treeArea.left = new FormAttachment(0, 0);
        treeArea.right = new FormAttachment(100, 0);
        treeArea.top = new FormAttachment(filterInputText, 10, SWT.BOTTOM);
        treeArea.bottom = new FormAttachment(100, 0);

        DecoratingLabelProvider labelProvider = new DecoratingLabelProvider(
                parameter.getLabelProvider(), parameter.getLabelDecorator());

        Tree tree;
        if (this.treeStyle != SWT.NONE) {
            tree = super.getToolkit().createTree(parent, treeArea, this.treeStyle);
        } else {
            tree = super.getToolkit().createTree(parent, treeArea);
        }

        this.treeViewer = new TreeViewer(tree);
        treeViewer.setContentProvider(parameter.getContentProvider());
        treeViewer.setLabelProvider(labelProvider);
        treeViewer.setInput(parameter.getInput());
        treeViewer.setFilters(new ViewerFilter[] { filter });
        treeViewer.addSelectionChangedListener(this);
        treeViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                TreeSelection selection = (TreeSelection) event.getSelection();
                treeViewer.expandToLevel(selection.getFirstElement(), TreeViewer.ALL_LEVELS);
            }
        });
        filter.setLabelProvider(labelProvider);
        filter.setContentProvider(parameter.getContentProvider());
        treeViewer.expandToLevel(initalExpandLevel);
    }

    /**
     * Get the default selection index. The index that is selected when the widget is created.
     * Overwrite this method for other behaviours.
     * 
     * @return the default selection index.
     */
    protected int getDefaultSelection() {
        return 0;
    }

}
