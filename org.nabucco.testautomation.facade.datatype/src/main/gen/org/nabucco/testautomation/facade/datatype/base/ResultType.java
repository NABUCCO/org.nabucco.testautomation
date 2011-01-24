/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.base;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * ResultType<p/>Enumeration for all possible result types.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-07
 */
public enum ResultType implements Enumeration {
    /** The TestStep passed with no errors. */
    PASSED("P"),
    /** The TestStep failed due to the failure of at least one TestScript. */
    FAILED("F"),
    /** The TestStep was skipped. */
    SKIPPED("S"), ;

    private String id;

    /**
     * Constructs a new ResultType instance.
     *
     * @param id the String.
     */
    ResultType(String id) {
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
