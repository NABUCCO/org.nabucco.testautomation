/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.search.engine.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;
import org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchViewModel;

/**
 * TestEngineConfigurationSearchView<p/>Search view for TestEngineConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA6 AG, 2010-06-30
 */
public class TestEngineConfigurationSearchView extends
        AbstractNabuccoSearchView<TestEngineConfigurationSearchViewModel> implements
        NabuccoSearchView {

    private TestEngineConfigurationSearchViewModel model;

    public static final String ID = "org.nabucco.testautomation.ui.search.engine.TestEngineConfigurationSearchView";

    /** Constructs a new TestEngineConfigurationSearchView instance. */
    public TestEngineConfigurationSearchView() {
        super();
        model = new TestEngineConfigurationSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public TestEngineConfigurationSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return TestEngineConfigurationSearchView.ID;
    }
}
