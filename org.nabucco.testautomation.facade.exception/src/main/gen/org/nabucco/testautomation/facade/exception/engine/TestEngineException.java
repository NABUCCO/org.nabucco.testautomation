/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.exception.engine;

import java.util.HashMap;
import java.util.Map;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * TestEngineException<p/>Exception-wrapper for exceptions thrown by the TestEngine<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestEngineException extends ServiceException {

    private static final long serialVersionUID = 1L;

    private Map<String, String> parameterMap = new HashMap<String, String>();

    /** Constructs a new TestEngineException instance. */
    public TestEngineException() {
        super();
    }

    /**
     * Constructs a new TestEngineException instance.
     *
     * @param throwable the Throwable.
     * @param message the String.
     */
    public TestEngineException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new TestEngineException instance.
     *
     * @param message the String.
     */
    public TestEngineException(String message) {
        super(message);
    }

    /**
     * Constructs a new TestEngineException instance.
     *
     * @param throwable the Throwable.
     */
    public TestEngineException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Getter for the Parameters.
     *
     * @return the Map<String, String>.
     */
    public Map<String, String> getParameters() {
        return new HashMap<String, String>(this.parameterMap);
    }
}
