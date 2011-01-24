/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewConfigDescriptionLabelProvider
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigDescriptionLabelProvider implements
        ILabelProvider {

    /** Constructs a new TestEngineConfigurationListViewConfigDescriptionLabelProvider instance. */
    public TestEngineConfigurationListViewConfigDescriptionLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof TestEngineConfiguration)) {
            TestEngineConfiguration config = ((TestEngineConfiguration) arg0);
            result = ((config.getDescription() != null) ? config.getDescription().toString() : "");
        }
        return result;
    }

    @Override
    public void addListener(ILabelProviderListener arg0) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object arg0, String arg1) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener arg0) {
    }
}
