/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
