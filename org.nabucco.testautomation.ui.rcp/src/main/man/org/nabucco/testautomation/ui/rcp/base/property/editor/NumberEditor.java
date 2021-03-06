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

import java.math.BigDecimal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.testautomation.facade.datatype.property.DoubleProperty;
import org.nabucco.testautomation.facade.datatype.property.IntegerProperty;
import org.nabucco.testautomation.facade.datatype.property.LongProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * NumberEditor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class NumberEditor {

	private Composite parent;
	
	private TreeEditor editor;
	
	private int column;
	
	public NumberEditor(Composite parent, TreeEditor editor, int column) {
		this.parent = parent;
		this.editor = editor;
		this.column = column;
	}
	
	public void edit(TreeItem item) {
		
		Text textEditor = new Text(parent, SWT.NONE);
        final String orgValue = item.getText(this.column);
		textEditor.setText(orgValue);
        textEditor.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				
				Text text = (Text) editor.getEditor();
				final String enteredValue = text.getText();
				editor.getItem().setText(column, enteredValue);
				Property prop = (Property) editor.getItem()
						.getData();
				
				if (prop != null) {
					BigDecimal number;
					
					try {
						number = new BigDecimal(enteredValue);
					} catch (NumberFormatException e) {
						editor.getItem().setText(column, orgValue);
						return;
					}
					
					switch (prop.getType()) {
					case INTEGER:
						((IntegerProperty) prop).setValue(number.intValue());
	                	break;
	                case DOUBLE:
	                	((DoubleProperty) prop).setValue(number.doubleValue());
	                	break;
	                case LONG:
	                	((LongProperty) prop).setValue(number.longValue());
	                	break;
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
			}
			
		});
        
        textEditor.selectAll();
        textEditor.setFocus();
        editor.setEditor(textEditor, item);
	}
	
}
