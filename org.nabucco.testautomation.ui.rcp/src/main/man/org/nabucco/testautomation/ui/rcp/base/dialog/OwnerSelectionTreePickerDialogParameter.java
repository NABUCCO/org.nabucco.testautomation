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

import org.nabucco.framework.plugin.base.component.newpicker.dialog.tree.TreePickerDialogContentProvider;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.tree.TreePickerDialogLabel;
import org.nabucco.framework.plugin.base.component.newpicker.dialog.tree.TreePickerDialogParameter;

/**
 * OwnerSelectionTreePickerDialogParameter
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class OwnerSelectionTreePickerDialogParameter extends TreePickerDialogParameter {

	private OwnerSelectionTreePickerDialogContentProvider<?> contentProvider;

	public OwnerSelectionTreePickerDialogParameter(TreePickerDialogLabel label, Object input) {
        super(label, input);
    }

	
	/**
     * Getter for the contentProvider.
     * 
     * @return Returns the contentProvider.
     */
	@Override
    public OwnerSelectionTreePickerDialogContentProvider<?> getContentProvider() {
        return this.contentProvider;
    }

    /**
     * Setter for the contentProvider.
     * 
     * @param contentProvider
     *            The contentProvider to set.
     */
    @Override
    public void setContentProvider(TreePickerDialogContentProvider<?> contentProvider) {
        this.contentProvider = (OwnerSelectionTreePickerDialogContentProvider<?>) contentProvider;
    }


    
	
}
