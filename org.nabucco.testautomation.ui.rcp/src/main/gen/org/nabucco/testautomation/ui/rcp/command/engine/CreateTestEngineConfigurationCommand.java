/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateTestEngineConfigurationCommand<p/>This command is for creating a TestEngineConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-29
 */
public class CreateTestEngineConfigurationCommand implements NabuccoCommand {

    private CreateTestEngineConfigurationCommandHandler createTestEngineConfigurationCommandHandler = NabuccoInjector
            .getInstance(CreateTestEngineConfigurationCommand.class).inject(
                    CreateTestEngineConfigurationCommandHandler.class);

    public static final String ID = "org.nabucco.testautomation.ui.command.engine.CreateTestEngineConfigurationCommand";

    /** Constructs a new CreateTestEngineConfigurationCommand instance. */
    public CreateTestEngineConfigurationCommand() {
        super();
    }

    @Override
    public void run() {
        createTestEngineConfigurationCommandHandler.createTestEngineConfigurationCommand();
    }

    @Override
    public String getId() {
        return CreateTestEngineConfigurationCommand.ID;
    }
}
