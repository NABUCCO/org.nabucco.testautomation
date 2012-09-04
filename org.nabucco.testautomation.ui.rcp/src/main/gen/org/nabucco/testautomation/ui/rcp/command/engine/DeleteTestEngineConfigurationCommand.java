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

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * DeleteTestEngineConfigurationCommand<p/>This command is for deleting a TestEngineConfiguration from database<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2011-01-13
 */
public class DeleteTestEngineConfigurationCommand implements NabuccoCommand {

    private DeleteTestEngineConfigurationCommandHandler deleteTestEngineConfigurationCommandHandler = NabuccoInjector
            .getInstance(DeleteTestEngineConfigurationCommand.class).inject(
                    DeleteTestEngineConfigurationCommandHandler.class);

    public static final String ID = "org.nabucco.testautomation.ui.command.engine.DeleteTestEngineConfigurationCommand";

    /** Constructs a new DeleteTestEngineConfigurationCommand instance. */
    public DeleteTestEngineConfigurationCommand() {
        super();
    }

    @Override
    public void run() {
        deleteTestEngineConfigurationCommandHandler.deleteTestEngineConfigurationCommand();
    }

    @Override
    public String getId() {
        return DeleteTestEngineConfigurationCommand.ID;
    }
}
