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
package org.nabucco.testautomation.ui.rcp.base.property.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.testautomation.facade.datatype.property.FileProperty;
import org.nabucco.testautomation.facade.datatype.property.SqlProperty;
import org.nabucco.testautomation.facade.datatype.property.StringProperty;
import org.nabucco.testautomation.facade.datatype.property.XPathProperty;
import org.nabucco.testautomation.facade.datatype.property.XmlProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * TextEditor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class TextEditor {

	private Composite parent;
	
	private TreeEditor editor;
	
	private int column;
	
	public TextEditor(Composite parent, TreeEditor editor, int column) {
		this.parent = parent;
		this.editor = editor;
		this.column = column;
	}
	
	public void edit(TreeItem item) {
		
		Text textEditor = new Text(parent, SWT.NONE);
        textEditor.setText(item.getText(this.column));
        textEditor.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				
				Text text = (Text) editor.getEditor();
				editor.getItem().setText(column, text.getText());
				Property prop = (Property) editor.getItem()
						.getData();
				
				if (prop != null) {
					String enteredValue = text.getText();
					
					switch (prop.getType()) {
					case SQL:
						((SqlProperty) prop).setValue(enteredValue);
	                	break;
	                case STRING:
	                	((StringProperty) prop).setValue(enteredValue);
	                	break;
	                case XML:
	                	((XmlProperty) prop).setValue(enteredValue);
	                	break;
	                case XPATH:
	                	((XPathProperty) prop).setValue(enteredValue);
	                	break;
	                case FILE:
	                	((FileProperty) prop).setContent(enteredValue);
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
