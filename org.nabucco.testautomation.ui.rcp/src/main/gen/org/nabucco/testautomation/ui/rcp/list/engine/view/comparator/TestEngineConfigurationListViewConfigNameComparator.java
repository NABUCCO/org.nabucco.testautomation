/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewConfigNameComparator
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigNameComparator extends
        NabuccoColumComparator<TestEngineConfiguration> {

    /** Constructs a new TestEngineConfigurationListViewConfigNameComparator instance. */
    public TestEngineConfigurationListViewConfigNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestEngineConfiguration object1, TestEngineConfiguration object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
