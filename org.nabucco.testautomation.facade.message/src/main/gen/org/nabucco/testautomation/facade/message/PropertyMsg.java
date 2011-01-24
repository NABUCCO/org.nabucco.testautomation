/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "property", "propertyContainer" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;" };

    private Property property;

    private PropertyContainer propertyContainer;

    /** Constructs a new PropertyMsg instance. */
    public PropertyMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Property>(PROPERTY_NAMES[0], Property.class,
                PROPERTY_CONSTRAINTS[0], this.property));
        properties.add(new DatatypeProperty<PropertyContainer>(PROPERTY_NAMES[1],
                PropertyContainer.class, PROPERTY_CONSTRAINTS[1], this.propertyContainer));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PropertyMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<property>" + this.property) + "</property>\n"));
        appendable
                .append((("<propertyContainer>" + this.propertyContainer) + "</propertyContainer>\n"));
        appendable.append("</PropertyMsg>\n");
        return appendable.toString();
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
}
