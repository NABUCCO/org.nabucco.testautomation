/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
import org.nabucco.testautomation.facade.datatype.base.DateValue;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComponent;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * DateProperty<p/>Property containing a java.util.Date as value<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public class DateProperty extends PropertyComponent implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;" };

    public static final String VALUE = "value";

    private DateValue value;

    /** Constructs a new DateProperty instance. */
    public DateProperty() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = PropertyType.DATE;
    }

    /**
     * CloneObject.
     *
     * @param clone the DateProperty.
     */
    protected void cloneObject(DateProperty clone) {
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
        propertyMap.put(VALUE, PropertyDescriptorSupport.createBasetype(VALUE, DateValue.class, 8,
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
        properties.add(super.createProperty(DateProperty.getPropertyDescriptor(VALUE), this.value,
                null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(VALUE) && (property.getType() == DateValue.class))) {
            this.setValue(((DateValue) property.getInstance()));
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
        final DateProperty other = ((DateProperty) obj);
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
    public DateProperty cloneObject() {
        DateProperty clone = new DateProperty();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getValue.
     *
     * @return the DateValue.
     */
    public DateValue getValue() {
        return this.value;
    }

    /**
     * Missing description at method setValue.
     *
     * @param value the DateValue.
     */
    public void setValue(DateValue value) {
        this.value = value;
    }

    /**
     * Missing description at method setValue.
     *
     * @param value the java.util.Date.
     */
    public void setValue(java.util.Date value) {
        if ((this.value == null)) {
            if ((value == null)) {
                return;
            }
            this.value = new DateValue();
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
        return PropertyCache.getInstance().retrieve(DateProperty.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DateProperty.class).getAllProperties();
    }
}
