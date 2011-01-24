/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.base.Value;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * ProducePropertyMsg<p/>Message for producing a Property of a certain PropertyType<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-20
 */
public class ProducePropertyMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "propertyType", "name", "value" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m0,1;", "l0,n;m0,1;" };

    private PropertyType propertyType;

    private Name name;

    private Value value;

    /** Constructs a new ProducePropertyMsg instance. */
    public ProducePropertyMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<PropertyType>(PROPERTY_NAMES[0], PropertyType.class,
                PROPERTY_CONSTRAINTS[0], this.propertyType));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.name));
        properties.add(new BasetypeProperty<Value>(PROPERTY_NAMES[2], Value.class,
                PROPERTY_CONSTRAINTS[2], this.value));
        return properties;
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
        final ProducePropertyMsg other = ((ProducePropertyMsg) obj);
        if ((this.propertyType == null)) {
            if ((other.propertyType != null))
                return false;
        } else if ((!this.propertyType.equals(other.propertyType)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
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
        result = ((PRIME * result) + ((this.propertyType == null) ? 0 : this.propertyType
                .hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.value == null) ? 0 : this.value.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProducePropertyMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<propertyType>" + this.propertyType) + "</propertyType>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<value>" + this.value) + "</value>\n"));
        appendable.append("</ProducePropertyMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getPropertyType.
     *
     * @return the PropertyType.
     */
    public PropertyType getPropertyType() {
        return this.propertyType;
    }

    /**
     * Missing description at method setPropertyType.
     *
     * @param propertyType the PropertyType.
     */
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Missing description at method getName.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Missing description at method getValue.
     *
     * @return the Value.
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Missing description at method setValue.
     *
     * @param value the Value.
     */
    public void setValue(Value value) {
        this.value = value;
    }
}
