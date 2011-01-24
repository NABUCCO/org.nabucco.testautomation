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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.testautomation.facade.component.TestautomationComponent;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.facade.datatype.engine.SubEngineType;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.produce.ProduceTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;


public class TestEngineConfigurationTest extends RuntimeTestSupport {

	private MaintainTestEngineConfiguration maintainConfig;

	private SearchTestEngineConfiguration searchConfig;

	private ProduceTestEngineConfiguration produceConfig;

	@Before
	public void setUp() throws Exception {
		TestautomationComponent component = super
				.getComponent(TestautomationComponentLocator.getInstance());
		maintainConfig = component.getMaintainTestEngineConfiguration();
		searchConfig = component.getSearchTestEngineConfiguration();
		produceConfig = component.getProduceTestEngineConfiguration();
	}

	@Test
	public void testCreateTestEngineConfiguration() throws Exception {

		String desc = "config for localhost";
		String host = "localhost";
		String port = "1099";
		String name = "LocalhostConfiguration";
		String refName = "TestEngine";

		TestEngineConfiguration config = createTestEngineConfiguration();
		config.setDescription(desc);
		config.setHost(host);
		config.setName(name);
		config.setPort(port);
		config.setRemoteReferenceName(refName);

		Code dev = new Code();
		dev.setId(1L);
		dev.setName("DEV");
		
		Code test = new Code();
		test.setId(2L);
		test.setName("TEST");
		
		Code rel1 = new Code();
		rel1.setId(3L);
		rel1.setName("Release 1");
		
		Code rel2 = new Code();
		rel2.setId(4L);
		rel2.setName("Release 2");
		
		// Add ProxyConfigurations
		ProxyConfiguration c1 = createProxyConfiguration();
		c1.setSubEngineType(SubEngineType.SWING);
		c1.setEnvironmentType(dev);
		c1.setReleaseType(rel1);
		ConfigurationProperty p1 = createConfigurationProperty();
		c1.getConfigurationProperties().add(p1);
		p1.setName("P1");
		p1.setValue("SWING DEV Release 1");
		
		ProxyConfiguration c2 = createProxyConfiguration();
		c2.setSubEngineType(SubEngineType.WEB);
		c2.setEnvironmentType(dev);
		c2.setReleaseType(rel1);
		ConfigurationProperty p2 = createConfigurationProperty();
		c2.getConfigurationProperties().add(p2);
		p2.setName("P2");
		p2.setValue("WEB DEV Release 1");
		
		ProxyConfiguration c3 = createProxyConfiguration();
		c3.setSubEngineType(SubEngineType.SWING);
		c3.setEnvironmentType(dev);
		c3.setReleaseType(rel2);
		ConfigurationProperty p3 = createConfigurationProperty();
		c3.getConfigurationProperties().add(p3);
		p3.setName("P3");
		p3.setValue("SWING DEV Release 2");
		
		ProxyConfiguration c4 = createProxyConfiguration();
		c4.setSubEngineType(SubEngineType.WEB);
		c4.setEnvironmentType(test);
		c4.setReleaseType(rel1);
		ConfigurationProperty p4 = createConfigurationProperty();
		c4.getConfigurationProperties().add(p4);
		p4.setName("P4");
		p4.setValue("WEB TEST Release 1");
		
		config.getProxyConfigurations().add(c1);
		config.getProxyConfigurations().add(c2);
		config.getProxyConfigurations().add(c3);
		config.getProxyConfigurations().add(c4);
		
		ServiceRequest<TestEngineConfigurationMsg> rq = new ServiceRequest<TestEngineConfigurationMsg>(
				getServiceContext());
		TestEngineConfigurationMsg msg = new TestEngineConfigurationMsg();
		rq.setRequestMessage(msg);
		msg.setTestEngineConfiguration(config);
		ServiceResponse<TestEngineConfigurationMsg> rs = maintainConfig
				.maintainTestEngineConfiguration(rq);
		config = rs.getResponseMessage().getTestEngineConfiguration();

		Long id = config.getId();
		assertNotNull("Id is null", id);
		assertEquals(desc, config.getDescription().getValue());
		assertEquals(host, config.getHost().getValue());
		assertEquals(port, config.getPort().getValue());
		assertEquals(name, config.getName().getValue());
		assertEquals(refName, config.getRemoteReferenceName().getValue());
		assertTrue(config.getProxyConfigurations().size() == 4);
		assertTrue(config.getProxyConfigurations().get(0).getSubEngineType() == SubEngineType.SWING);
		assertTrue(config.getProxyConfigurations().get(0).getConfigurationProperties().size() == 1);
		assertTrue(config.getProxyConfigurations().get(1).getSubEngineType() == SubEngineType.WEB);
		assertTrue(config.getProxyConfigurations().get(1).getConfigurationProperties().size() == 1);

		ServiceRequest<TestEngineConfigurationSearchMsg> searchRQ = new ServiceRequest<TestEngineConfigurationSearchMsg>(
				getServiceContext());
		TestEngineConfigurationSearchMsg searchMsg = new TestEngineConfigurationSearchMsg();
		Identifier ident = new Identifier();
		ident.setValue(id);
		searchMsg.setId(ident);
		searchRQ.setRequestMessage(searchMsg);
		ServiceResponse<TestEngineConfigurationMsg> searchRS = searchConfig
				.getTestEngineConfiguration(searchRQ);

		config = searchRS.getResponseMessage().getTestEngineConfiguration();
		assertFalse(config == null);
		id = config.getId();
		assertNotNull("Id is null", id);
		assertEquals(searchMsg.getId().getValue(), config.getId());
		assertEquals(desc, config.getDescription().getValue());
		assertEquals(host, config.getHost().getValue());
		assertEquals(port, config.getPort().getValue());
		assertEquals(name, config.getName().getValue());
		assertEquals(refName, config.getRemoteReferenceName().getValue());
		assertTrue(config.getProxyConfigurations().size() == 4);
		assertTrue(config.getProxyConfigurations().get(0).getSubEngineType() == SubEngineType.SWING);
		assertTrue(config.getProxyConfigurations().get(0).getConfigurationProperties().size() == 2);
		assertTrue(config.getProxyConfigurations().get(1).getSubEngineType() == SubEngineType.WEB);
		assertTrue(config.getProxyConfigurations().get(1).getConfigurationProperties().size() == 2);
	}

	@Test
	public void testSearchTestEngineConfiguration() throws Exception {

		ServiceRequest<TestEngineConfigurationSearchMsg> searchRQ = new ServiceRequest<TestEngineConfigurationSearchMsg>(
				getServiceContext());
		TestEngineConfigurationSearchMsg searchMsg = new TestEngineConfigurationSearchMsg();
		Name host = new Name();
		host.setValue("localhost");
		searchMsg.setHost(host);
		searchRQ.setRequestMessage(searchMsg);
		ServiceResponse<TestEngineConfigurationListMsg> searchRS = searchConfig
				.searchTestEngineConfiguration(searchRQ);
		assertFalse(searchRS.getResponseMessage().getConfigurationList()
				.isEmpty());
	}
	
	@Test
	public void testGetTestEngineConfiguration() throws Exception {

		Code dev = new Code();
		dev.setId(1L);
		dev.setName("DEV");
		
		Code test = new Code();
		test.setId(2L);
		test.setName("TEST");
		
		Code rel1 = new Code();
		rel1.setId(3L);
		rel1.setName("Release 1");
		
		Code rel2 = new Code();
		rel2.setId(4L);
		rel2.setName("Release 2");
		
		ServiceRequest<TestEngineConfigurationSearchMsg> searchRQ = new ServiceRequest<TestEngineConfigurationSearchMsg>(
				getServiceContext());
		TestEngineConfigurationSearchMsg searchMsg = new TestEngineConfigurationSearchMsg();
		searchMsg.setId(new Identifier(2L));
		searchMsg.setEnvironmentType(dev);
		searchMsg.setReleaseType(rel1);		
		
		searchRQ.setRequestMessage(searchMsg);
		ServiceResponse<TestEngineConfigurationMsg> searchRS = searchConfig
				.getTestEngineConfiguration(searchRQ);
		TestEngineConfiguration config = searchRS.getResponseMessage().getTestEngineConfiguration();
		assertNotNull(config);
	}

	private TestEngineConfiguration createTestEngineConfiguration()
			throws ProduceException {
		ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(
				getServiceContext());
		rq.setRequestMessage(new EmptyServiceMessage());
		ServiceResponse<TestEngineConfigurationMsg> rs = produceConfig
				.produceTestEngineConfiguration(rq);
		TestEngineConfigurationMsg msg = rs.getResponseMessage();
		return msg.getTestEngineConfiguration();
	}

	private ProxyConfiguration createProxyConfiguration()
			throws ProduceException {
		ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(
				getServiceContext());
		rq.setRequestMessage(new EmptyServiceMessage());
		ServiceResponse<TestEngineConfigurationMsg> rs = produceConfig
				.produceProxyConfiguration(rq);
		TestEngineConfigurationMsg msg = rs.getResponseMessage();
		return msg.getProxyConfiguration();
	}

	private ConfigurationProperty createConfigurationProperty()
			throws ProduceException {
		ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(
				getServiceContext());
		rq.setRequestMessage(new EmptyServiceMessage());
		ServiceResponse<TestEngineConfigurationMsg> rs = produceConfig
				.produceConfigurationProperty(rq);
		TestEngineConfigurationMsg msg = rs.getResponseMessage();
		return msg.getConfigurationProperty();
	}

}
