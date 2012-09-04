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
package org.nabucco.testautomation.facade.component;

import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for TestautomationComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class TestautomationComponentLocator extends
        ComponentLocatorSupport<TestautomationComponent> implements
        ComponentLocator<TestautomationComponent> {

    private static final String JNDI_NAME = ((((ComponentLocator.COMPONENTS + "/") + TestautomationComponent.COMPONENT_NAME) + "/") + "org.nabucco.testautomation.facade.component.TestautomationComponent");

    private static TestautomationComponentLocator instance;

    /**
     * Constructs a new TestautomationComponentLocator instance.
     *
     * @param component the Class<TestautomationComponent>.
     * @param jndiName the String.
     */
    private TestautomationComponentLocator(String jndiName, Class<TestautomationComponent> component) {
        super(jndiName, component);
    }

    /**
     * Getter for the Instance.
     *
     * @return the TestautomationComponentLocator.
     */
    public static TestautomationComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new TestautomationComponentLocator(JNDI_NAME, TestautomationComponent.class);
        }
        return instance;
    }
}
