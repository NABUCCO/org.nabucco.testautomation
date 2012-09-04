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
package org.nabucco.testautomation.facade.datatype;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.testautomation.facade.datatype.property.BooleanProperty;
import org.nabucco.testautomation.facade.datatype.property.DateProperty;
import org.nabucco.testautomation.facade.datatype.property.DoubleProperty;
import org.nabucco.testautomation.facade.datatype.property.FileProperty;
import org.nabucco.testautomation.facade.datatype.property.IntegerProperty;
import org.nabucco.testautomation.facade.datatype.property.LongProperty;
import org.nabucco.testautomation.facade.datatype.property.PropertyList;
import org.nabucco.testautomation.facade.datatype.property.SqlProperty;
import org.nabucco.testautomation.facade.datatype.property.StringProperty;
import org.nabucco.testautomation.facade.datatype.property.XPathProperty;
import org.nabucco.testautomation.facade.datatype.property.XmlProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;


/**
 * PropertyFactory
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class PropertyFactory {

	private static PropertyFactory instance;

	private static final String DEFAULT_NAME = "Property ...";
	
	private PropertyFactory() {}
	
	public static synchronized PropertyFactory getInstance() {
		
		if (instance == null) {
			instance = new PropertyFactory();
		}
		return instance;
	}
	
	public Property produceProperty(PropertyType type) {
		
		if (type == null) {
			return null;
		}
		
		Property property = null;
		
		switch(type) {
		case BOOLEAN:
			property = new BooleanProperty();
			break;
		case DATE:
			property = new DateProperty();
			break;
		case DOUBLE:
			property = new DoubleProperty();
			break;
		case INTEGER:
			property = new IntegerProperty();
			break;
		case LIST:
			PropertyList propertyList = new PropertyList();
			propertyList.setReused(Boolean.FALSE);
			property = propertyList;
			break;
		case LONG:
			property = new LongProperty();
			break;
		case STRING:
			property = new StringProperty();
			break;
		case XML:
			property = new XmlProperty();
			break;
		case XPATH:
			property = new XPathProperty();
			break;
		case FILE:
			property = new FileProperty();
			break;
		case SQL:
			property = new SqlProperty();
			break;
		default:
			return null;
		}
		
		property.setDatatypeState(DatatypeState.INITIALIZED);
		property.setName(DEFAULT_NAME);
		property.setOwner(NabuccoInstance.getInstance().getOwner());
		property.setIdentificationKey(new Key());
		return property;
	}
	
}
