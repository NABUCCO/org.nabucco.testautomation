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

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.command.NabuccoAbstractSaveCommandHandlerImpl;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.ui.rcp.command.engine.MaintainTestEngineConfigurationCommandHandler;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceBusinessModel;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;


/**
 * MaintainTestEngineConfigurationCommandHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class MaintainTestEngineConfigurationCommandHandlerImpl extends
		NabuccoAbstractSaveCommandHandlerImpl<EngineMaintenanceBusinessModel, EngineMaintenanceMultiPageEditViewModel> implements
		MaintainTestEngineConfigurationCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void maintainTestEngineConfigurationCommand() {
		run();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBusinessModelId() {
		return EngineMaintenanceBusinessModel.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveModel(EngineMaintenanceMultiPageEditViewModel viewModel, EngineMaintenanceBusinessModel businessModel) throws ClientException {
		TestEngineConfigurationMsg response = businessModel.save(viewModel.getTestEngineConfiguration());
		viewModel.setTestEngineConfiguration(response.getTestEngineConfiguration());
	}

}
