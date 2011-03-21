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
package org.nabucco.testautomation.ui.rcp.base.property;

import java.text.SimpleDateFormat;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.framework.base.facade.datatype.file.TextFileContent;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.facade.datatype.base.BooleanValue;
import org.nabucco.testautomation.facade.datatype.base.DateValue;
import org.nabucco.testautomation.facade.datatype.base.DoubleValue;
import org.nabucco.testautomation.facade.datatype.base.IntegerValue;
import org.nabucco.testautomation.facade.datatype.base.LongValue;
import org.nabucco.testautomation.facade.datatype.base.SqlValue;
import org.nabucco.testautomation.facade.datatype.base.StringValue;
import org.nabucco.testautomation.facade.datatype.base.XPathValue;
import org.nabucco.testautomation.facade.datatype.base.XmlValue;
import org.nabucco.testautomation.facade.datatype.property.BooleanProperty;
import org.nabucco.testautomation.facade.datatype.property.DateProperty;
import org.nabucco.testautomation.facade.datatype.property.DoubleProperty;
import org.nabucco.testautomation.facade.datatype.property.FileProperty;
import org.nabucco.testautomation.facade.datatype.property.IntegerProperty;
import org.nabucco.testautomation.facade.datatype.property.LongProperty;
import org.nabucco.testautomation.facade.datatype.property.SqlProperty;
import org.nabucco.testautomation.facade.datatype.property.StringProperty;
import org.nabucco.testautomation.facade.datatype.property.XPathProperty;
import org.nabucco.testautomation.facade.datatype.property.XmlProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.ui.rcp.base.property.editor.BooleanEditor;
import org.nabucco.testautomation.ui.rcp.base.property.editor.DateEditor;
import org.nabucco.testautomation.ui.rcp.base.property.editor.NumberEditor;
import org.nabucco.testautomation.ui.rcp.base.property.editor.TextEditor;
import org.nabucco.testautomation.ui.rcp.images.TestautomationImageRegistry;


/**
 * PropertyViewer
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class PropertyViewer {

	private static final String EMPTY_STRING = "";

	private static final String ID = "org.nabucco.testautomation.ui.rcp.base.property.PropertyViewer";
	
	private final int VALUE_COLUMN = 2;
	
	private Tree tree;
	
	private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	
	private boolean editable = false;
	
	/**
	 * @param parent
	 */
	public PropertyViewer(Composite parent) {
		this.tree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		init();
	}

	/**
	 * @param parent
	 * @param style
	 */
	public PropertyViewer(Composite parent, int style) {
		this.tree = new Tree(parent, style);
		init();
	}

	/**
	 * @param parent
	 */
	public PropertyViewer(Composite parent, boolean editable) {
		this.tree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		this.editable = editable;
		init();
	}
	
	/**
	 * @param parent
	 * @param style
	 */
	public PropertyViewer(Composite parent, int style, boolean editable) {
		this.tree = new Tree(parent, style);
		this.editable = editable;
		init();
	}
	
	public void addProperty(Property property) {
		this.addPropertyToTree(tree, property);		
	}

	public void addProperties(List<Property> properties) {
		
		for (Property property : properties) {
			this.addPropertyToTree(tree, property);		
		}
	}

	public void setDatePattern(String pattern) {
		this.df = new SimpleDateFormat(pattern);
	}
	
	public void setBackground(Color color) {
		tree.setBackground(color);
	}

	public void setBackgroundImage(Image image) {
		tree.setBackgroundImage(image);
	}

	public void setBackgroundMode(int mode) {
		tree.setBackgroundMode(mode);
	}

	public void setEnabled(boolean enabled) {
		tree.setEnabled(enabled);
	}

	public void setForeground(Color color) {
		tree.setForeground(color);
	}

	public void setHeaderVisible(boolean visible) {
		tree.setHeaderVisible(visible);
	}

	public void setLayout(Layout layout) {
		tree.setLayout(layout);
	}

	public void setLayoutData(Object layoutData) {
		tree.setLayoutData(layoutData);
	}

	public void setLinesVisible(boolean show) {
		tree.setLinesVisible(show);
	}

	public void setToolTipText(String string) {
		tree.setToolTipText(string);
	}

	protected void addPropertyToTree(Tree parent, Property prop) {
		
		TreeItem item = new TreeItem(parent, SWT.NONE);
		item.setData(prop);
	    item.setText(0, prop.getName().getValue());
	    item.setText(1, prop.getType().toString());
	    item.setText(2, getValue(prop));
		item.setImage(ImageProvider.createImage(getImage(prop)));
	    
	    if (prop instanceof PropertyComposite) {
	    	for (PropertyContainer c : ((PropertyComposite) prop).getPropertyList()) {
	    		addPropertyToTree(item, c.getProperty());
	    	}
	    }
	    item.setExpanded(true);
	}
	
	protected void addPropertyToTree(TreeItem parent, Property prop) {
		
		TreeItem item = new TreeItem(parent, SWT.NONE);
		item.setData(prop);
	    item.setText(0, prop.getName().getValue());
	    item.setText(1, prop.getType().toString());
	    item.setText(2, getValue(prop));
		item.setImage(ImageProvider.createImage(getImage(prop)));
	    
	    if (prop instanceof PropertyComposite) {
	    	for (PropertyContainer c : ((PropertyComposite) prop).getPropertyList()) {
	    		addPropertyToTree(item, c.getProperty());
	    	}
	    }
	    item.setExpanded(true);
	}
	
	protected String getValue(Property property) {
		
		String stringValue = EMPTY_STRING;
		
		switch (property.getType()) {
        case BOOLEAN: {
            BooleanValue value = ((BooleanProperty) property).getValue();
            
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue().toString();
            break;
        }
        case DATE: {
            DateValue value = ((DateProperty) property).getValue();
            
            if (value == null) {
            	return stringValue;
            }
            stringValue = df.format(value.getValue());
            break;
        }
        case DOUBLE: {
            DoubleValue value = ((DoubleProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue().toString();
            break;
        }
        case INTEGER: {
            IntegerValue value = ((IntegerProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue().toString();
            break;
        }
        case LONG: {
        	LongValue value = ((LongProperty) property).getValue();

        	if (value == null) {
            	return stringValue;
            }
        	stringValue = value.getValue().toString();
        	break;
        }
        case STRING: {
            StringValue value = ((StringProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue();
            break;
        }
        case XML: {
            XmlValue value = ((XmlProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue();
            break;
        }
        case XPATH: {
            XPathValue value = ((XPathProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue();
            break;
        }
        case FILE: {
            TextFileContent content = ((FileProperty) property).getContent();
			
            if (content == null) {
            	return stringValue;
            }
            stringValue = content.getValue();
            break;
        } 
        case SQL: {
            SqlValue value = ((SqlProperty) property).getValue();
			
            if (value == null) {
            	return stringValue;
            }
            stringValue = value.getValue();  
            break;
        }
        default:
        	stringValue = EMPTY_STRING;
        	break;
		}
		
		if (stringValue == null) {
			stringValue = EMPTY_STRING;
		}
		return stringValue;
	}

	protected String getImage(Property property) {
		
		switch (property.getType()) {
		case LIST:
			return TestautomationImageRegistry.ICON_PROPERTY_LIST.getId();
		case STRING:
			return TestautomationImageRegistry.ICON_PROPERTY_STRING.getId();
		case INTEGER:
		case LONG:
		case DOUBLE:
			return TestautomationImageRegistry.ICON_PROPERTY_NUMERIC.getId();
		case XML:
			return TestautomationImageRegistry.ICON_PROPERTY_XML.getId();
		case DATE:
			return TestautomationImageRegistry.ICON_PROPERTY_DATE.getId();
		case BOOLEAN:
			return TestautomationImageRegistry.ICON_PROPERTY_BOOLEAN.getId();
		case FILE:
			return TestautomationImageRegistry.ICON_PROPERTY_FILE.getId();
		default:
			return TestautomationImageRegistry.ICON_PROPERTY.getId();
		}
	}
	
	private void init() {
		
	    TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
	    column1.setText(I18N.i18n(ID + ".name"));
	    column1.setWidth(250);
	    TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
	    column2.setText(I18N.i18n(ID + ".type"));
	    column2.setWidth(75);
	    TreeColumn column3 = new TreeColumn(tree, SWT.LEFT);
	    column3.setText(I18N.i18n(ID + ".value"));
	    column3.setWidth(250);
	    
	    if (this.editable) {
		    final TreeEditor editor = new TreeEditor(tree);
		    editor.setColumn(VALUE_COLUMN);
		    editor.horizontalAlignment = SWT.LEFT;
	        editor.grabHorizontal = true;
	        editor.minimumWidth = 50;
	
	        this.tree.addSelectionListener(new SelectionAdapter() {
	        	
	            public void widgetSelected(SelectionEvent e) {
	                    
	            	// Clean up any previous editor control
	                Control oldEditor = editor.getEditor();
	                
	                if (oldEditor != null) {
	                	oldEditor.dispose();
	                }
	
	                // Identify the selected row
	                TreeItem item = (TreeItem) e.item;
	                Property prop = (Property) item.getData();
	                
	                if (item == null || prop == null) {
	                	return;
	                }
	
	                // Get the right editor for the selected Property
	                switch (prop.getType()) {
	                case SQL:
	                case STRING:
	                case XML:
	                case XPATH:
	                case FILE: {
	                	TextEditor textEditor = new TextEditor(tree, editor, VALUE_COLUMN);
	                	textEditor.edit(item);
	                	break;
	                }
	                case BOOLEAN: {
	                	BooleanEditor boolEditor = new BooleanEditor(tree, editor, VALUE_COLUMN);
	                	boolEditor.edit(item);
	                	break;
	                }
	                case INTEGER:
	                case LONG:
	                case DOUBLE: {
	                	NumberEditor numberEditor = new NumberEditor(tree, editor, VALUE_COLUMN);
	                	numberEditor.edit(item);
	                	break;
	                }
	                case DATE: {
	                	DateEditor dateEditor = new DateEditor(tree, editor, VALUE_COLUMN, df);
	                	dateEditor.edit(item);
	                	break;
	                }
	                }
	                
	            }
	        });
	    }
	}
	
}
