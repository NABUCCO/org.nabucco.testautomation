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
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.close.AbstractDeleteDatatypeHandler;
import org.nabucco.framework.plugin.base.model.BusinessModel;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.engine.EngineMaintenanceMultiPageEditView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceBusinessModel;

/**
 * MaintainTestEngineConfigurationCommandHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class DeleteTestEngineConfigurationCommandHandlerImpl extends AbstractDeleteDatatypeHandler<EngineMaintenanceMultiPageEditView> implements
		DeleteTestEngineConfigurationCommandHandler {

	@Override
	public void deleteTestEngineConfigurationCommand() {
		run();
	}

	@Override
	public String getId() {
		return EngineMaintenanceMultiPageEditView.ID;
	}

	@Override
	protected boolean preClose(EngineMaintenanceMultiPageEditView view) {

		TestEngineConfiguration testConfigResult = view.getModel().getTestEngineConfiguration();

		testConfigResult.setDatatypeState(DatatypeState.DELETED);

		BusinessModel businessModel = Activator.getDefault().getModel().getBusinessModel(EngineMaintenanceBusinessModel.ID);

		try {
			if (businessModel instanceof EngineMaintenanceBusinessModel) {
				((EngineMaintenanceBusinessModel) businessModel).delete(testConfigResult);
			}
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
			return true;
		}

		return super.preClose(view);
	}

}
