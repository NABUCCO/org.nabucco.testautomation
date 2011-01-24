/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListViewConfigRemoteReferenceNameComparator
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigRemoteReferenceNameComparator extends
        NabuccoColumComparator<TestEngineConfiguration> {

    /** Constructs a new TestEngineConfigurationListViewConfigRemoteReferenceNameComparator instance. */
    public TestEngineConfigurationListViewConfigRemoteReferenceNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestEngineConfiguration object1, TestEngineConfiguration object2) {
        return this.compareBasetype(object1.getRemoteReferenceName(),
                object2.getRemoteReferenceName());
    }
}
