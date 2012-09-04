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
