/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,255;m0,1;", "l0,n;m0,1;" };

    public static final String PROPERTYTYPE = "propertyType";

    public static final String NAME = "name";

    public static final String VALUE = "value";

    private PropertyType propertyType;

    private Name name;

    private Value value;

    /** Constructs a new ProducePropertyMsg instance. */
    public ProducePropertyMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROPERTYTYPE, PropertyDescriptorSupport.createEnumeration(PROPERTYTYPE,
                PropertyType.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 1,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(VALUE, PropertyDescriptorSupport.createBasetype(VALUE, Value.class, 2,
                PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProducePropertyMsg.getPropertyDescriptor(PROPERTYTYPE),
                this.propertyType));
        properties.add(super.createProperty(ProducePropertyMsg.getPropertyDescriptor(NAME),
                this.name));
        properties.add(super.createProperty(ProducePropertyMsg.getPropertyDescriptor(VALUE),
                this.value));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROPERTYTYPE) && (property.getType() == PropertyType.class))) {
            this.setPropertyType(((PropertyType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(VALUE) && (property.getType() == Value.class))) {
            this.setValue(((Value) property.getInstance()));
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProducePropertyMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProducePropertyMsg.class).getAllProperties();
    }
}
