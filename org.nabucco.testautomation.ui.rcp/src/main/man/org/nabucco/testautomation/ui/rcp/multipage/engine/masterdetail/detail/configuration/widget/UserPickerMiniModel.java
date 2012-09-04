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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.widget;

import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.model.MiniViewModel;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;


/**
 * UserPickerMiniModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class UserPickerMiniModel extends MiniViewModel {

	public static final String PROPERTY_USER = "user";

	public static final String PROPERTY_USER_NAME = "name";
	
	private TestEngineConfiguration testEngineConfiguration;

	/**
	 * Creates a new {@link TestScriptContainerTableMiniModel} instance.
	 * 
	 * @param externalViewModel
	 *            the external view model
	 * @param datatype
	 *            the parent datatype
	 */
	public UserPickerMiniModel(ViewModel externalViewModel, TestEngineConfiguration datatype, String masterBlockId) {
		super(externalViewModel, datatype);

		if (datatype == null) {
			throw new IllegalArgumentException(
					"Cannot create UserPickerMiniModel for TestEngineConfiguration [null].");
		}

		this.testEngineConfiguration = datatype;
		super.setInitialized();
	}
	

	/**
	 * Set the  newValue in the model.
	 * 
	 * @param newValue
	 *            the  newValue to set
	 */
	public void setUser(User newValue) {
		Object oldValue = this.testEngineConfiguration.getUser();
		this.testEngineConfiguration.setUser(newValue);
		super.updateProperty(PROPERTY_USER_NAME, oldValue, newValue);
	}
	
	public User getUser() {
		return this.testEngineConfiguration.getUser();
	}
	
	public String getName(){
		if(this.testEngineConfiguration.getUser() != null && this.testEngineConfiguration.getUser().getUsername() != null){
			return this.testEngineConfiguration.getUser().getUsername().getValue();
		}
		return "";
	}

	public void setName(String name){
		if(this.testEngineConfiguration.getUser() != null && this.testEngineConfiguration.getUser().getUsername() != null){
			this.testEngineConfiguration.getUser().setUsername(name);
		}
	}

}
