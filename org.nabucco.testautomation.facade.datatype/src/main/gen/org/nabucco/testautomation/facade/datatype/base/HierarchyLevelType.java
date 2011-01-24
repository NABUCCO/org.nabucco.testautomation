/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.base;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * HierarchyLevelType<p/>Enumeration for all possible hierarchy levels.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-08
 */
public enum HierarchyLevelType implements Enumeration {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"), ;

    private String id;

    /**
     * Constructs a new HierarchyLevelType instance.
     *
     * @param id the String.
     */
    HierarchyLevelType(String id) {
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
