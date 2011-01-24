/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * PropertyListMsg<p/>Message containing a list of Properties<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class PropertyListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "propertyList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<Property> propertyList;

    /** Constructs a new PropertyListMsg instance. */
    public PropertyListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<Property>(PROPERTY_NAMES[0], Property.class,
                PROPERTY_CONSTRAINTS[0], this.propertyList));
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
        final PropertyListMsg other = ((PropertyListMsg) obj);
        if ((this.propertyList == null)) {
            if ((other.propertyList != null))
                return false;
        } else if ((!this.propertyList.equals(other.propertyList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.propertyList == null) ? 0 : this.propertyList
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PropertyListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<propertyList>" + this.propertyList) + "</propertyList>\n"));
        appendable.append("</PropertyListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getPropertyList.
     *
     * @return the List<Property>.
     */
    public List<Property> getPropertyList() {
        if ((this.propertyList == null)) {
            this.propertyList = new ArrayList<Property>();
        }
        return this.propertyList;
    }
}
