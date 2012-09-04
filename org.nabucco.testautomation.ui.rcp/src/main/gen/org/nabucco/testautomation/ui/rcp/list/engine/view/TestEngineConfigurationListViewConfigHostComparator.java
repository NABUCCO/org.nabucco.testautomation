/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.ui.rcp.list.engine.view;

import java.util.Comparator;

import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;


/**
 * TestEngineConfigurationListViewConfigHostComparator
 *
 * @author Undefined
 */
public class TestEngineConfigurationListViewConfigHostComparator implements
        Comparator<TestEngineConfiguration> {
    /** Constructs a new TestEngineConfigurationListViewConfigHostComparator instance. */
    public TestEngineConfigurationListViewConfigHostComparator() {
        super();
    }

    @Override
    public int compare(TestEngineConfiguration object1, TestEngineConfiguration object2) {
        return object1.getHost().compareTo(object2.getHost());
    }
}
