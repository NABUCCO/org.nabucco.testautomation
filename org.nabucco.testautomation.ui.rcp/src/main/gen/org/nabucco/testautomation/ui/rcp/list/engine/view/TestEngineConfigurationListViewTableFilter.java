/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view;

import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableFilter;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewTableFilter<p/>Search view for TestEngineConfigurations<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-30
 */
public class TestEngineConfigurationListViewTableFilter extends NabuccoTableFilter {

    /** Constructs a new TestEngineConfigurationListViewTableFilter instance. */
    public TestEngineConfigurationListViewTableFilter() {
        super();
    }

    @Override
    public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
        boolean result = false;
        if (((null == searchFilter.getFilter()) || (0 == searchFilter.getFilter().length()))) {
            result = true;
        } else if ((element instanceof TestEngineConfiguration)) {
            TestEngineConfiguration datatype = ((TestEngineConfiguration) element);
            result = (result || this.contains(datatype.getName(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getDescription(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getHost(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getPort(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getRemoteReferenceName(),
                    searchFilter.getFilter()));
        }
        return result;
    }
}
