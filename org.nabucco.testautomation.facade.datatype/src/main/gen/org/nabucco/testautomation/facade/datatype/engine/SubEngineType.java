/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.engine;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * SubEngineType<p/>Enumeration for all possible SubEngine types.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-07
 */
public enum SubEngineType implements Enumeration {
    /** SubEngineType for a web client. */
    WEB("WE"),
    /** SubEngineType for a swing client. */
    SWING("SW"),
    /** SubEngineType for a RCP client. */
    RCP("RC"),
    /** SubEngineType for processes. */
    PROCESS("PR"),
    /** SubEngineType for a database. */
    DB("DB"),
    /** SubEngineType for a webservice client. */
    WS("WS"),
    /** SubEngineType for a JMS instance. */
    JMS("JM"),
    /** SubEngineType for a Host server. */
    HOST("HO"), ;

    private String id;

    /**
     * Constructs a new SubEngineType instance.
     *
     * @param id the String.
     */
    SubEngineType(String id) {
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
