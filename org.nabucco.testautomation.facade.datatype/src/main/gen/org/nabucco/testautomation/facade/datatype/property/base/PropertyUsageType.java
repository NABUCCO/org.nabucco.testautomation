/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * PropertyUsageType<p/>Enumeration indicating the type of usage of a PropertyList.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-01
 */
public enum PropertyUsageType implements Enumeration {
    /** The PropertyList is used by a {@link TestConfigElement}. */
    TEST_CONFIG_ELEMENT_PARAM("C"),
    /** The PropertyList is used by a {@link TestScriptElement}. */
    TEST_SCRIPT_ELEMENT_PARAM("S"),
    /** The PropertyList is used by a {@link Metadata}. */
    METADTA_PARAM("M"), ;

    private String id;

    /**
     * Constructs a new PropertyUsageType instance.
     *
     * @param id the String.
     */
    PropertyUsageType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getOrdinal() {
        return this.ordinal();
    }

    @Override
    public Enumeration cloneObject() {
        return this;
    }
}
