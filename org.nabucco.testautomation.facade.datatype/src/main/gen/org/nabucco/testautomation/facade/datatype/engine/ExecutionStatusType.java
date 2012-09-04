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
package org.nabucco.testautomation.facade.datatype.engine;

import java.util.Collections;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.Enumeration;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.visitor.Visitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;

/**
 * ExecutionStatusType<p/>Enumeration for all possible SubEngine types.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public enum ExecutionStatusType implements Enumeration {
    /** The TestRunnerJob is initialized and ready for execution. */
    INITIALIZED("IN"),
    /** The TestRunnerJob is started by the ExecutionService and is still running. */
    RUNNING("RU"),
    /** The Job has finished the execution. */
    FINISHED("FI"),
    /** The Job has been rejected and was not executed. */
    REJECTED("RE"),
    /** The Job is paused and waiting for resume. */
    PAUSED("PA"),
    /** The Job was interrupted. */
    INTERRUPTED("IR"), ;

    private String id;

    /**
     * Constructs a new ExecutionStatusType instance.
     *
     * @param id the String.
     */
    ExecutionStatusType(String id) {
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

    @Override
    public void accept(Visitor visitor) throws VisitorException {
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        return Collections.emptyList();
    }
}
