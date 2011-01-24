/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
