/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Order;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * PropertyContainer<p/>Container holding a Property and its order position<p/>
 *
 * @version 1.0
 * @author sschmidt, PRODYNA AG, 2010-10-05
 */
public class PropertyContainer extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "property", "orderIndex" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m0,1;" };

    private Property property;

    private Order orderIndex;

    /** Constructs a new PropertyContainer instance. */
    public PropertyContainer() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PropertyContainer.
     */
    protected void cloneObject(PropertyContainer clone) {
        super.cloneObject(clone);
        if ((this.getProperty() != null)) {
            clone.setProperty(this.getProperty().cloneObject());
        }
        if ((this.getOrderIndex() != null)) {
            clone.setOrderIndex(this.getOrderIndex().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Property>(PROPERTY_NAMES[0], Property.class,
                PROPERTY_CONSTRAINTS[0], this.property));
        properties.add(new BasetypeProperty<Order>(PROPERTY_NAMES[1], Order.class,
                PROPERTY_CONSTRAINTS[1], this.orderIndex));
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
        final PropertyContainer other = ((PropertyContainer) obj);
        if ((this.property == null)) {
            if ((other.property != null))
                return false;
        } else if ((!this.property.equals(other.property)))
            return false;
        if ((this.orderIndex == null)) {
            if ((other.orderIndex != null))
                return false;
        } else if ((!this.orderIndex.equals(other.orderIndex)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.property == null) ? 0 : this.property.hashCode()));
        result = ((PRIME * result) + ((this.orderIndex == null) ? 0 : this.orderIndex.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PropertyContainer>\n");
        appendable.append(super.toString());
        appendable.append((("<property>" + this.property) + "</property>\n"));
        appendable.append((("<orderIndex>" + this.orderIndex) + "</orderIndex>\n"));
        appendable.append("</PropertyContainer>\n");
        return appendable.toString();
    }

    @Override
    public PropertyContainer cloneObject() {
        PropertyContainer clone = new PropertyContainer();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method getProperty.
     *
     * @return the Property.
     */
    public Property getProperty() {
        return this.property;
    }

    /**
     * Missing description at method getOrderIndex.
     *
     * @return the Order.
     */
    public Order getOrderIndex() {
        return this.orderIndex;
    }

    /**
     * Missing description at method setOrderIndex.
     *
     * @param orderIndex the Order.
     */
    public void setOrderIndex(Order orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * Missing description at method setOrderIndex.
     *
     * @param orderIndex the Integer.
     */
    public void setOrderIndex(Integer orderIndex) {
        if ((this.orderIndex == null)) {
            this.orderIndex = new Order();
        }
        this.orderIndex.setValue(orderIndex);
    }
}
