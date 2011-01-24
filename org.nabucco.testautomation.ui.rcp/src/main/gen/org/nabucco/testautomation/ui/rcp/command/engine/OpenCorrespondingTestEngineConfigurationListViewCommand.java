/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.command.engine;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingTestEngineConfigurationListViewCommand<p/>open list view for TestEngineConfiguration<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-07-01
 */
public class OpenCorrespondingTestEngineConfigurationListViewCommand implements NabuccoCommand {

    private OpenCorrespondingTestEngineConfigurationListViewHandler openCorrespondingTestEngineConfigurationListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingTestEngineConfigurationListViewCommand.class).inject(
                    OpenCorrespondingTestEngineConfigurationListViewHandler.class);

    public static final String ID = "org.nabucco.testautomation.ui.command.engine.OpenCorrespondingTestEngineConfigurationListViewCommand";

    /** Constructs a new OpenCorrespondingTestEngineConfigurationListViewCommand instance. */
    public OpenCorrespondingTestEngineConfigurationListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openCorrespondingTestEngineConfigurationListViewHandler
                .openCorrespondingTestEngineConfigurationListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingTestEngineConfigurationListViewCommand.ID;
    }
}
