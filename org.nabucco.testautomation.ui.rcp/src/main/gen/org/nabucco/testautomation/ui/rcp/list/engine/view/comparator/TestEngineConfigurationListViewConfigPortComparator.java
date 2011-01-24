/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewConfigPortComparator
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigPortComparator extends
        NabuccoColumComparator<TestEngineConfiguration> {

    /** Constructs a new TestEngineConfigurationListViewConfigPortComparator instance. */
    public TestEngineConfigurationListViewConfigPortComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestEngineConfiguration object1, TestEngineConfiguration object2) {
        return this.compareBasetype(object1.getPort(), object2.getPort());
    }
}
