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

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.testautomation.facade.datatype.property.DateProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;


/**
 * DateEditor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class DateEditor {

	private Composite parent;
	
	private TreeEditor editor;
	
	private int column;
	
	private SimpleDateFormat df;
	
	public DateEditor(Composite parent, TreeEditor editor, int column, SimpleDateFormat dateFormat) {
		this.parent = parent;
		this.editor = editor;
		this.column = column;
		this.df = dateFormat;
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
				
				if (prop != null && df != null) {
					
					switch (prop.getType()) {
					case DATE:
						try {
							((DateProperty) prop).setValue(df.parse(enteredValue));
						} catch (ParseException e) {
							editor.getItem().setText(column, orgValue);
						}
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
