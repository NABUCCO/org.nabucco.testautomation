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
package org.nabucco.testautomation.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.testautomation.facade.component.TestautomationComponent;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.facade.datatype.property.BooleanProperty;
import org.nabucco.testautomation.facade.datatype.property.DateProperty;
import org.nabucco.testautomation.facade.datatype.property.DoubleProperty;
import org.nabucco.testautomation.facade.datatype.property.IntegerProperty;
import org.nabucco.testautomation.facade.datatype.property.LongProperty;
import org.nabucco.testautomation.facade.datatype.property.PropertyList;
import org.nabucco.testautomation.facade.datatype.property.StringProperty;
import org.nabucco.testautomation.facade.datatype.property.XmlProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;
import org.nabucco.testautomation.facade.message.ProducePropertyMsg;
import org.nabucco.testautomation.facade.message.PropertyListMsg;
import org.nabucco.testautomation.facade.message.PropertyMsg;
import org.nabucco.testautomation.facade.message.PropertySearchMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainProperty;
import org.nabucco.testautomation.facade.service.produce.ProduceProperty;
import org.nabucco.testautomation.facade.service.search.SearchProperty;


public class PropertyTest extends RuntimeTestSupport {

	private MaintainProperty maintainProperty;
	
	private SearchProperty searchProperty;
	
	private ProduceProperty produceProperty;

	@Before
	public void setUp() throws Exception {
		TestautomationComponent component = super.getComponent(TestautomationComponentLocator.getInstance());
		maintainProperty = component.getMaintainProperty();
		searchProperty = component.getSearchProperty();
		produceProperty = component.getProduceProperty();
	}

	@Test
	public void testStringProperty() throws Exception {

		String name = "PropertyName.String";
		String value = "My string value";

		StringProperty property = (StringProperty) produceProperty(PropertyType.STRING);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (StringProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (StringProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (StringProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testBooleanProperty() throws Exception {

		String name = "PropertyName.Boolean";
		Boolean value = Boolean.TRUE;

		BooleanProperty property = (BooleanProperty) produceProperty(PropertyType.BOOLEAN);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (BooleanProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (BooleanProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (BooleanProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testDateProperty() throws Exception {

		String name = "PropertyName.Date";
		Date value = new Date();

		DateProperty property = (DateProperty) produceProperty(PropertyType.DATE);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (DateProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (DateProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (DateProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testDoubleProperty() throws Exception {

		String name = "PropertyName.Double";
		Double value = 123.99D;

		DoubleProperty property = (DoubleProperty) produceProperty(PropertyType.DOUBLE);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (DoubleProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (DoubleProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (DoubleProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testIntegerProperty() throws Exception {

		String name = "PropertyName.Integer";
		Integer value = 12345;

		IntegerProperty property = (IntegerProperty) produceProperty(PropertyType.INTEGER);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (IntegerProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (IntegerProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (IntegerProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testLongProperty() throws Exception {

		String name = "PropertyName.Long";
		Long value = 4711L;

		LongProperty property = (LongProperty) produceProperty(PropertyType.LONG);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (LongProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (LongProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (LongProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testXmlProperty() throws Exception {

		String name = "PropertyName.XML";
		String value = "<xml><test>my test xml</test></xml>";

		XmlProperty property = (XmlProperty) produceProperty(PropertyType.XML);
		property.setName(name);
		property.setValue(value);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(property);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		property = (XmlProperty) rsMsg.getProperty();

		assertNotNull("Property is null", property);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (XmlProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, property.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		property = (XmlProperty) resultList.get(0);
		assertNotNull("Id is null", property.getId());
		assertNotNull("Name is null", property.getName());
		assertNotNull("Value is null", property.getValue());
		assertEquals(name, property.getName().getValue());
		assertEquals(value, property.getValue().getValue());
		
		property.setDatatypeState(DatatypeState.DELETED);
		rq.getRequestMessage().setProperty(property);
		maintainProperty.maintainProperty(rq);
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(property.getId(), null));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testPropertyList() throws Exception {

		String name = "PropertyName.List";
		
		PropertyList propertyList = (PropertyList) produceProperty(PropertyType.LIST);
		propertyList.setName(name);
		propertyList.setDescription("My PropertyList");

		StringProperty prop1 = (StringProperty) produceProperty(PropertyType.STRING);
		prop1.setName("ListProperty 1");
		prop1.setValue("PropertyList-Test 1");
		IntegerProperty prop2 = (IntegerProperty) produceProperty(PropertyType.INTEGER);
		prop2.setName("ListProperty 2");
		prop2.setValue(4711);
		BooleanProperty prop3 = (BooleanProperty) produceProperty(PropertyType.BOOLEAN);
		prop3.setName("ListProperty 3");
		prop3.setValue(Boolean.TRUE);
		
		PropertyList subList = (PropertyList) produceProperty(PropertyType.LIST);
		StringProperty subProp1 = (StringProperty) produceProperty(PropertyType.STRING);
		subProp1.setName("SubListProperty 1");
		subProp1.setValue("SubPropertyList-Test 1");
		StringProperty subProp2 = (StringProperty) produceProperty(PropertyType.STRING);
		subProp2.setName("SubListProperty 2");
		subProp2.setValue("SubPropertyList-Test 2");
		add(subProp1,subList);
		add(subProp2,subList);
		
		add(prop1,propertyList);
		add(prop2,propertyList);
		add(prop3,propertyList);
		add(subList,propertyList);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(propertyList);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		propertyList = (PropertyList) rsMsg.getProperty();

		assertNotNull("PropertyList is null", propertyList);
		assertNotNull("Id is null", propertyList.getId());
		assertNotNull("Name is null", propertyList.getName());
		assertTrue("Size is not 4", propertyList.getPropertyList().size() == 4);
		assertEquals(name, propertyList.getName().getValue());
		
		ServiceResponse<PropertyListMsg> searchRs = searchProperty.searchProperty(createSearchPropertyRequest(propertyList.getId(), null));
		List<Property> resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1", resultList.size() == 1);
		propertyList = (PropertyList) resultList.get(0);
		assertNotNull("PropertyList is null", propertyList);
		assertNotNull("Id is null", propertyList.getId());
		assertNotNull("Name is null", propertyList.getName());
		assertTrue("Size is not 4", propertyList.getPropertyList().size() == 4);
		assertEquals(name, propertyList.getName().getValue());
		
		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(null, propertyList.getName().getValue()));
		resultList = searchRs.getResponseMessage().getPropertyList();
		
		assertTrue("ResultList.size != 1 but " + resultList.size(), resultList.size() == 1);
		propertyList = (PropertyList) resultList.get(0);
		assertNotNull("PropertyList is null", propertyList);
		assertNotNull("Id is null", propertyList.getId());
		assertNotNull("Name is null", propertyList.getName());
		assertTrue("Size is not 4", propertyList.getPropertyList().size() == 4);
		assertEquals(name, propertyList.getName().getValue());
		
//		propertyList.setDatatypeState(DatatypeState.DELETED);
//		for (Property property : propertyList.getChildren()) {
//			property.setDatatypeState(DatatypeState.DELETED);
//		}
//		rq.getRequestMessage().setProperty(propertyList);
//		maintainProperty.maintainProperty(rq);
//		
//		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(propertyList.getId(), null));
//		resultList = searchRs.getResponseMessage().getPropertyList();
//		assertTrue("ResultList.size != 0", resultList.size() == 0);
//		
//		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(prop1.getId(), null));
//		resultList = searchRs.getResponseMessage().getPropertyList();
//		assertTrue("ResultList.size != 0", resultList.size() == 0);
//		
//		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(prop2.getId(), null));
//		resultList = searchRs.getResponseMessage().getPropertyList();
//		assertTrue("ResultList.size != 0", resultList.size() == 0);
//
//		searchRs = searchProperty.searchProperty(createSearchPropertyRequest(prop3.getId(), null));
//		resultList = searchRs.getResponseMessage().getPropertyList();
//		assertTrue("ResultList.size != 0", resultList.size() == 0);
	}
	
	@Test
	public void testUpdateProperty() throws Exception {
		
		String name = "PropertyName.List";
		
		PropertyList propertyList = (PropertyList) produceProperty(PropertyType.LIST);
		propertyList.setName(name);
		propertyList.setDescription("My PropertyList");

		StringProperty prop1 = (StringProperty) produceProperty(PropertyType.STRING);
		prop1.setName("ListProperty 1");
		prop1.setValue("PropertyList-Test 1");
		IntegerProperty prop2 = (IntegerProperty) produceProperty(PropertyType.INTEGER);
		prop2.setName("ListProperty 2");
		prop2.setValue(4711);
		BooleanProperty prop3 = (BooleanProperty) produceProperty(PropertyType.BOOLEAN);
		prop3.setName("ListProperty 3");
		prop3.setValue(Boolean.TRUE);
		add(prop1,propertyList);
		add(prop2,propertyList);
		add(prop3,propertyList);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(propertyList);
		ServiceResponse<PropertyMsg> rs = maintainProperty.maintainProperty(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		propertyList = (PropertyList) rsMsg.getProperty();
		assertEquals(3, propertyList.getPropertyList().size());
		
		// update PropertyList
		propertyList.getPropertyList().remove(0);
		propertyList.getPropertyList().remove(0);
		
		propertyList.setDatatypeState(DatatypeState.MODIFIED);
		rq = createPropertyRequest(propertyList);
		
		rs = maintainProperty.maintainProperty(rq);
		rsMsg = rs.getResponseMessage();
		propertyList = (PropertyList) rsMsg.getProperty();
		assertEquals(1, propertyList.getPropertyList().size());
	}
	
	@Test
	public void testClonePropertyList() throws Exception {

		String name = "PropertyName.List";
		
		PropertyList propertyList = (PropertyList) produceProperty(PropertyType.LIST);
		propertyList.setName(name);
		propertyList.setDescription("My PropertyList");
		propertyList.setId(1L);
		propertyList.setVersion(4711L);

		StringProperty prop1 = (StringProperty) produceProperty(PropertyType.STRING);
		prop1.setName("ListProperty 1");
		prop1.setValue("PropertyList-Test 1");
		prop1.setId(2L);
		prop1.setVersion(4711L);
		IntegerProperty prop2 = (IntegerProperty) produceProperty(PropertyType.INTEGER);
		prop2.setName("ListProperty 2");
		prop2.setValue(4711);
		prop2.setId(3L);
		prop2.setVersion(4711L);
		BooleanProperty prop3 = (BooleanProperty) produceProperty(PropertyType.BOOLEAN);
		prop3.setName("ListProperty 3");
		prop3.setValue(Boolean.TRUE);
		prop3.setId(4L);
		prop3.setVersion(4711L);
		
		PropertyList subList = (PropertyList) produceProperty(PropertyType.LIST);
		subList.setName("SubList 1");
		subList.setId(5L);
		subList.setVersion(4711L);
		
		StringProperty subProp1 = (StringProperty) produceProperty(PropertyType.STRING);
		subProp1.setName("SubListProperty 1");
		subProp1.setValue("SubPropertyList-Test 1");
		subProp1.setId(6L);
		subProp1.setVersion(4711L);
		StringProperty subProp2 = (StringProperty) produceProperty(PropertyType.STRING);
		subProp2.setName("SubListProperty 2");
		subProp2.setValue("SubPropertyList-Test 2");
		subProp2.setId(7L);
		subProp2.setVersion(4711L);
		add(subProp1,subList);
		add(subProp2,subList);
		
		add(prop1,propertyList);
		add(prop2,propertyList);
		add(prop3,propertyList);
		add(subList,propertyList);

		ServiceRequest<PropertyMsg> rq = createPropertyRequest(propertyList);
		ServiceResponse<PropertyMsg> rs = produceProperty.producePropertyClone(rq);
		PropertyMsg rsMsg = rs.getResponseMessage();
		PropertyList propertyListClone= (PropertyList) rsMsg.getProperty();

		assertNotNull("PropertyList is null", propertyListClone);
		assertNull("Id is not null", propertyListClone.getId());
		assertNull("Version is not null", propertyListClone.getVersion());
		assertNotNull("Name is null", propertyListClone.getName());
		assertTrue("Size is not 4", propertyListClone.getPropertyList().size() == 4);
		assertEquals(name, propertyListClone.getName().getValue());
		
	}
	
	private void add(Property prop, PropertyComposite to) {
		PropertyContainer c = new PropertyContainer();
		c.setDatatypeState(DatatypeState.INITIALIZED);
		c.setOrderIndex(to.getPropertyList().size());
		c.setProperty(prop);
		to.getPropertyList().add(c);
	}
	
	private Property produceProperty(PropertyType type) throws Exception {

		ServiceRequest<ProducePropertyMsg> rq = new ServiceRequest<ProducePropertyMsg>(
				getServiceContext());
		ProducePropertyMsg msg = new ProducePropertyMsg();
		msg.setPropertyType(type);
		rq.setRequestMessage(msg);
		ServiceResponse<PropertyMsg> rs = produceProperty.produceProperty(rq);
		return rs.getResponseMessage().getProperty();
	}

	private ServiceRequest<PropertyMsg> createPropertyRequest(Property property) {
		
		ServiceRequest<PropertyMsg> rq = new ServiceRequest<PropertyMsg>(
				getServiceContext());
		PropertyMsg msg = new PropertyMsg();
		msg.setProperty(property);
		rq.setRequestMessage(msg);
		return rq;
	}
	
	private ServiceRequest<PropertySearchMsg> createSearchPropertyRequest(Long id, String name) {
		
		ServiceRequest<PropertySearchMsg> rq = new ServiceRequest<PropertySearchMsg>(getServiceContext());
		PropertySearchMsg msg = new PropertySearchMsg();
		
		if (id != null) {
			Identifier identifier = new Identifier();
			identifier.setValue(id);
			msg.setPropertyId(identifier);
		}
		if (name != null) {
			Name propertyName = new Name();
			propertyName.setValue(name);
			msg.setPropertyName(propertyName);
		}
		rq.setRequestMessage(msg);
		return rq;
	}
	
}
