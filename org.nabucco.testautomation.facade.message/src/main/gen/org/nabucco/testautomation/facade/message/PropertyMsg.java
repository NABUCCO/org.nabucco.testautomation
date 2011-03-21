/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;

/**
 * PropertyMsg<p/>Message for persisting a Property<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class PropertyMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;" };

    public static final String PROPERTY = "property";

    public static final String PROPERTYCONTAINER = "propertyContainer";

    private Property property;

    private PropertyContainer propertyContainer;

    /** Constructs a new PropertyMsg instance. */
    public PropertyMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROPERTY, PropertyDescriptorSupport.createDatatype(PROPERTY,
                Property.class, 0, PROPERTY_CONSTRAINTS[0], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROPERTYCONTAINER, PropertyDescriptorSupport.createDatatype(
                PROPERTYCONTAINER, PropertyContainer.class, 1, PROPERTY_CONSTRAINTS[1], false,
                PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PropertyMsg.getPropertyDescriptor(PROPERTY),
                this.property));
        properties.add(super.createProperty(PropertyMsg.getPropertyDescriptor(PROPERTYCONTAINER),
                this.propertyContainer));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROPERTY) && (property.getType() == Property.class))) {
            this.setProperty(((Property) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYCONTAINER) && (property.getType() == PropertyContainer.class))) {
            this.setPropertyContainer(((PropertyContainer) property.getInstance()));
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
        final PropertyMsg other = ((PropertyMsg) obj);
        if ((this.property == null)) {
            if ((other.property != null))
                return false;
        } else if ((!this.property.equals(other.property)))
            return false;
        if ((this.propertyContainer == null)) {
            if ((other.propertyContainer != null))
                return false;
        } else if ((!this.propertyContainer.equals(other.propertyContainer)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.property == null) ? 0 : this.property.hashCode()));
        result = ((PRIME * result) + ((this.propertyContainer == null) ? 0 : this.propertyContainer
                .hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProperty.
     *
     * @return the Property.
     */
    public Property getProperty() {
        return this.property;
    }

    /**
     * Missing description at method setProperty.
     *
     * @param property the Property.
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Missing description at method getPropertyContainer.
     *
     * @return the PropertyContainer.
     */
    public PropertyContainer getPropertyContainer() {
        return this.propertyContainer;
    }

    /**
     * Missing description at method setPropertyContainer.
     *
     * @param propertyContainer the PropertyContainer.
     */
    public void setPropertyContainer(PropertyContainer propertyContainer) {
        this.propertyContainer = propertyContainer;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertyMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertyMsg.class).getAllProperties();
    }
}
