/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewConfigHostComparator
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigHostComparator extends
        NabuccoColumComparator<TestEngineConfiguration> {

    /** Constructs a new TestEngineConfigurationListViewConfigHostComparator instance. */
    public TestEngineConfigurationListViewConfigHostComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestEngineConfiguration object1, TestEngineConfiguration object2) {
        return this.compareBasetype(object1.getHost(), object2.getHost());
    }
}
