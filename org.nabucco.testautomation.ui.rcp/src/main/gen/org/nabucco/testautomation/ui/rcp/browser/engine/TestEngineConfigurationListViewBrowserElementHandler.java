/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.browser.engine;

import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.ui.rcp.list.engine.model.TestEngineConfigurationListViewModel;

/**
 * TestEngineConfigurationListViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface TestEngineConfigurationListViewBrowserElementHandler extends CommandHandler {

    /**
     * CreateChildren.
     *
     * @param element the TestEngineConfigurationListViewBrowserElement.
     * @param viewModel the TestEngineConfigurationListViewModel.
     */
    void createChildren(final TestEngineConfigurationListViewModel viewModel,
            final TestEngineConfigurationListViewBrowserElement element);

    /**
     * RemoveChild.
     *
     * @param element the TestEngineConfigurationListViewBrowserElement.
     * @param toBeRemoved the BrowserElement.
     */
    void removeChild(final BrowserElement toBeRemoved,
            final TestEngineConfigurationListViewBrowserElement element);
}
