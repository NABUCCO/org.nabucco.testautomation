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
package org.nabucco.testautomation.facade.datatype.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.base.LongValue;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComponent;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * LongProperty<p/>Property containing a String as value<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public class LongProperty extends PropertyComponent implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;" };

    public static final String VALUE = "value";

    private LongValue value;

    /** Constructs a new LongProperty instance. */
    public LongProperty() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = PropertyType.LONG;
    }

    /**
     * CloneObject.
     *
     * @param clone the LongProperty.
     */
    protected void cloneObject(LongProperty clone) {
        super.cloneObject(clone);
        if ((this.getValue() != null)) {
            clone.setValue(this.getValue().cloneObject());
        }
        clone.setType(this.getType());
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(PropertyComponent.class)
                .getPropertyMap());
        propertyMap.put(VALUE, PropertyDescriptorSupport.createBasetype(VALUE, LongValue.class, 8,
                PROPERTY_CONSTRAINTS[0], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(LongProperty.getPropertyDescriptor(VALUE), this.value,
                null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(VALUE) && (property.getType() == LongValue.class))) {
            this.setValue(((LongValue) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final LongProperty other = ((LongProperty) obj);
        if ((this.value == null)) {
            if ((other.value != null))
                return false;
        } else if ((!this.value.equals(other.value)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.value == null) ? 0 : this.value.hashCode()));
        return result;
    }

    @Override
    public LongProperty cloneObject() {
        LongProperty clone = new LongProperty();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getValue.
     *
     * @return the LongValue.
     */
    public LongValue getValue() {
        return this.value;
    }

    /**
     * Missing description at method setValue.
     *
     * @param value the LongValue.
     */
    public void setValue(LongValue value) {
        this.value = value;
    }

    /**
     * Missing description at method setValue.
     *
     * @param value the Long.
     */
    public void setValue(Long value) {
        if ((this.value == null)) {
            if ((value == null)) {
                return;
            }
            this.value = new LongValue();
        }
        this.value.setValue(value);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(LongProperty.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(LongProperty.class).getAllProperties();
    }
}
