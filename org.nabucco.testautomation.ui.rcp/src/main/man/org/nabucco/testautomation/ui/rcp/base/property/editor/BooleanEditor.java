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
package org.nabucco.testautomation.ui.rcp.base.property.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.testautomation.facade.datatype.base.BooleanValue;
import org.nabucco.testautomation.facade.datatype.property.BooleanProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * BooleanEditor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class BooleanEditor {

	private Composite parent;
	
	private TreeEditor editor;
	
	private int column;
	
	public BooleanEditor(Composite parent, TreeEditor editor, int column) {
		this.parent = parent;
		this.editor = editor;
		this.column = column;
	}
	
	public void edit(TreeItem item) {
    	
		Property prop = (Property) item.getData();
		Button booleanEditor = new Button(parent, SWT.CHECK);
    	
		if (prop == null || prop.getType() != PropertyType.BOOLEAN) {
			return;
		}
		
		BooleanValue value = ((BooleanProperty) prop).getValue();
		item.setText(this.column, "");
		
    	if (value != null && value.getValue() != null && value.getValue().booleanValue()) {
    		booleanEditor.setSelection(true);
    	} else {
    		booleanEditor.setSelection(false);
    	}
    	booleanEditor.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				
				Button checkbox = (Button) editor.getEditor();
				BooleanProperty prop = (BooleanProperty) editor.getItem()
					.getData();
				
				if (prop == null) {
					return;
				} else if (checkbox.getSelection()) {
					prop.setValue(Boolean.TRUE);
				} else {
					prop.setValue(Boolean.FALSE);
				}
				editor.getItem().setText(column, prop.getValue().getValue().toString());
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
			}
			
		});
    	
        booleanEditor.setFocus();
        editor.setEditor(booleanEditor, item);
	}
	
}
