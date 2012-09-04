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

    @Override
    public void accept(Visitor visitor) throws VisitorException {
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        return Collections.emptyList();
    }
}
