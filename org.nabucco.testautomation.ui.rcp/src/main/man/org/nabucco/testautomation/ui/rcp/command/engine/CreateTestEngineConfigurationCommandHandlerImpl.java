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
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.plugin.base.command.AbstractOpenViewHandler;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.ui.rcp.command.engine.CreateTestEngineConfigurationCommandHandler;
import org.nabucco.testautomation.ui.rcp.multipage.engine.EngineMaintenanceMultiPageEditView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineElementFactory;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;


/**
 * CreateTestEngineConfigurationCommandHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class CreateTestEngineConfigurationCommandHandlerImpl extends AbstractOpenViewHandler<EngineMaintenanceMultiPageEditView> implements CreateTestEngineConfigurationCommandHandler {

	@Override
	public void createTestEngineConfigurationCommand() {
		super.openView(EngineMaintenanceMultiPageEditView.ID);
	}

	@Override
	protected void preOpen(EngineMaintenanceMultiPageEditView view) {
		TestEngineConfiguration testEngineConfiguration = (TestEngineConfiguration) EngineElementFactory.create(TestEngineConfiguration.class);
		EngineMaintenanceMultiPageEditViewModel model = getView(EngineMaintenanceMultiPageEditView.ID).getModel();
		model.setTestEngineConfiguration(testEngineConfiguration);
		super.preOpen(view);
	}



}
