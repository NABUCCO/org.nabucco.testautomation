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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.layout.I18NLabelProviderContributor;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.images.TestautomationImageRegistry;


/**
 * EngineMaintenanceMasterDetailLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class EngineMaintenanceMasterDetailLabelProvider implements I18NLabelProviderContributor {

	private static final String ID = "org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.EngineMaintenanceMasterDetailLabelProvider";
	
	private static final String ICON_PROPERTY = "icons/text.png";

	private static EngineMaintenanceMasterDetailLabelProvider instance = new EngineMaintenanceMasterDetailLabelProvider();

	private EngineMaintenanceMasterDetailLabelProvider(){

	}

	public static EngineMaintenanceMasterDetailLabelProvider getInstance(){
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map.Entry<String, Map<String, ? extends Serializable>> getText(final Object element) {
		Map.Entry<String, Map<String, ? extends Serializable>> result = null;
		if (element instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) element;
			result = getText(treeNode.getDatatype());
		}
		return result;
	}

	/**
	 * String representing a special datatype.
	 * 
	 * @param datatype
	 * @return
	 */
	private Map.Entry<String, Map<String, ? extends Serializable>> getText(final Datatype datatype) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Map.Entry<String, Map<String, ? extends Serializable>> result = new AbstractMap.SimpleEntry(
				datatype.toString(), null);

		if (datatype instanceof TestEngineConfiguration) {
			TestEngineConfiguration testEngineConfiguration = (TestEngineConfiguration) datatype;
			if (testEngineConfiguration.getName() != null) {
				result = createEntry(ID + ".TestEngineConfiguration", "name", testEngineConfiguration.getName()
						.getValue());
			} else {
				result = createEntry(ID + ".TestEngineConfiguration", "name", testEngineConfiguration.getClass()
						.getSimpleName());
			}
		} else if (datatype instanceof ProxyConfiguration) {
			ProxyConfiguration proxyConfiguration = (ProxyConfiguration) datatype;
			if (proxyConfiguration.getName() != null) {
				result = createEntry(ID + ".ProxyConfiguration", "name", proxyConfiguration.getName().getValue());
			} else {
				result = createEntry(ID + ".ProxyConfiguration", "name", proxyConfiguration.getClass()
						.getSimpleName());
			}
		} else if (datatype instanceof ConfigurationProperty) {
			ConfigurationProperty configurationProperty = (ConfigurationProperty) datatype;
			if (configurationProperty.getName() != null) {
				result = createEntry(ID + ".ConfigurationProperty", "name", configurationProperty.getName()
						.getValue());
			} else {
				result = createEntry(ID + ".ConfigurationProperty", "name", configurationProperty.getClass()
						.getSimpleName());
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private SimpleEntry<String, Map<String, ? extends Serializable>> createEntry(final String i18n,
			String key, String value) {
		return new AbstractMap.SimpleEntry(i18n, createMap(key, value));
	}

	/**
	 * @param string
	 * @param name
	 * @return
	 */
	private Map<String, ? extends Serializable> createMap(final String key, final String value) {
		Map<String, String> result = new HashMap<String, String>();
		result.put(key, value);
		return result;
	}


	@Override
	public String getImage(Object element) {
		if (element instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) element;
			Datatype datatype = treeNode.getDatatype();
			return getImage(datatype);
		} else if(element instanceof Datatype){
			return getImage((Datatype) element);
		}
		return null;
	}

	private String getImage(Datatype datatype) {
		if (datatype instanceof TestEngineConfiguration) {
			return TestautomationImageRegistry.ICON_ENGINE.getId();
		} else if (datatype instanceof ProxyConfiguration) {
			return TestautomationImageRegistry.ICON_PROXY.getId();
		} else if(datatype instanceof ConfigurationProperty){
			return ICON_PROPERTY;
		}
		return null;
	}

}
