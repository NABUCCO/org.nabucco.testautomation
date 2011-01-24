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
package org.nabucco.testautomation.ui.rcp.search.engine.model;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchModel;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationListMsg;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationSearchMsg;
import org.nabucco.testautomation.ui.rcp.browser.engine.TestEngineConfigurationListViewBrowserElement;
import org.nabucco.testautomation.ui.rcp.communication.TestautomationComponentServiceDelegateFactory;
import org.nabucco.testautomation.ui.rcp.communication.search.SearchTestEngineConfigurationDelegate;
import org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchViewModel;


/**
 * TestEngineConfigurationSearchBusinessModel
 * 
 * @author Steffen Schmidt, PRODYNA AG
 * 
 */
public class TestEngineConfigurationSearchBusinessModel implements
		NabuccoComponentSearchModel {

	public static final String ID = "org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchBusinessModel";

	/**
	 * {@inheritDoc}
	 */ 
	@Override
	public TestEngineConfigurationListViewBrowserElement search(
			NabuccoComponentSearchParameter searchViewModel) {
		TestEngineConfigurationListViewBrowserElement result = null;
		if (searchViewModel instanceof TestEngineConfigurationSearchViewModel) {
			TestEngineConfigurationSearchViewModel configSearchViewModel = (TestEngineConfigurationSearchViewModel) searchViewModel;
			TestEngineConfigurationSearchMsg rq = createTestEngineConfigurationSearchMsg(configSearchViewModel);
			result = new TestEngineConfigurationListViewBrowserElement(search(rq).toArray(new TestEngineConfiguration[0]));
		}
		return result;
	}

	private List<TestEngineConfiguration> search(final TestEngineConfigurationSearchMsg rq) {
		List<TestEngineConfiguration> result = null;
		try {
			SearchTestEngineConfigurationDelegate searchDelegate = TestautomationComponentServiceDelegateFactory
					.getInstance().getSearchTestEngineConfiguration();
			TestEngineConfigurationListMsg response = searchDelegate.searchTestEngineConfiguration(rq);
			result = response.getConfigurationList();
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return result;
	}



	private TestEngineConfigurationSearchMsg createTestEngineConfigurationSearchMsg(
			TestEngineConfigurationSearchViewModel searchViewModel) {
		TestEngineConfigurationSearchMsg result = new TestEngineConfigurationSearchMsg();

		result.setName(getNameFromModel(searchViewModel));
		result.setHost(getHostFromModel(searchViewModel));
		result.setPort(getPortFromModel(searchViewModel));
		result.setRemoteRefName(getRemoteRefNameFromModel(searchViewModel));

		return result;
	}


	private Name getNameFromModel(
			TestEngineConfigurationSearchViewModel searchViewModel) {
		Name result = new Name();
		String name = searchViewModel.getConfigName();

		result.setValue( (name == null || name.length() == 0) ? null : name);
		return result;
	}
	
	private Name getHostFromModel(
			TestEngineConfigurationSearchViewModel searchViewModel) {
		Name result = new Name();
		String name = searchViewModel.getConfigHost();

		result.setValue( (name == null || name.length() == 0) ? null : name);
		return result;
	}
	
	private Name getPortFromModel(
			TestEngineConfigurationSearchViewModel searchViewModel) {
		Name result = new Name();
		String name = searchViewModel.getConfigPort();

		result.setValue( (name == null || name.length() == 0) ? null : name);
		return result;
	}
	
	private Name getRemoteRefNameFromModel(
			TestEngineConfigurationSearchViewModel searchViewModel) {
		Name result = new Name();
		String name = searchViewModel.getConfigRemoteReferenceName();

		result.setValue( (name == null || name.length() == 0) ? null : name);
		return result;
	}
	
}
