/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * MaintainTestEngineConfigurationCommand<p/>This command is for saving/updating/removing a TestEngineConfiguration<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-06-29
 */
public class MaintainTestEngineConfigurationCommand implements NabuccoCommand {

    private MaintainTestEngineConfigurationCommandHandler maintainTestEngineConfigurationCommandHandler = NabuccoInjector
            .getInstance(MaintainTestEngineConfigurationCommand.class).inject(
                    MaintainTestEngineConfigurationCommandHandler.class);

    public static final String ID = "org.nabucco.testautomation.ui.command.engine.MaintainTestEngineConfigurationCommand";

    /** Constructs a new MaintainTestEngineConfigurationCommand instance. */
    public MaintainTestEngineConfigurationCommand() {
        super();
    }

    @Override
    public void run() {
        maintainTestEngineConfigurationCommandHandler.maintainTestEngineConfigurationCommand();
    }

    @Override
    public String getId() {
        return MaintainTestEngineConfigurationCommand.ID;
    }
}
