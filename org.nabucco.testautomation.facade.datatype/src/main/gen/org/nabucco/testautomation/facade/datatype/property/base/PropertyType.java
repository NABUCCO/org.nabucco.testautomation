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
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.Collections;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.Enumeration;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.visitor.Visitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;

/**
 * PropertyType<p/>Enumeration for possible property types.<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public enum PropertyType implements Enumeration {
    /** A Property containing a value of type {@link Boolean}. */
    BOOLEAN("BO"),
    /** Property containing a value of type {@link String}. */
    STRING("ST"),
    /** Property containing a value of type {@link Date}. */
    DATE("DT"),
    /** A Property containing a value of type {@link Long}. */
    LONG("LO"),
    /** A Property containing a value of type {@link Integer}. */
    INTEGER("IN"),
    /** A Property containing properties stored in a {@link Map}. */
    MAP("MP"),
    /** A Property containing a value of type string containing xml. */
    XML("XM"),
    /** A Property containing a value of type string containg a xpath-expression. */
    XPATH("XP"),
    /** A Property containing properties stored in a {@link List}. */
    LIST("LI"),
    /** A Property containing a value of type {@link Double}. */
    DOUBLE("DO"),
    /** A Property containing the content of a file. */
    FILE("TF"),
    /** A Property containing a value of type string containing sql. */
    SQL("SQ"), ;

    private String id;

    /**
     * Constructs a new PropertyType instance.
     *
     * @param id the String.
     */
    PropertyType(String id) {
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
