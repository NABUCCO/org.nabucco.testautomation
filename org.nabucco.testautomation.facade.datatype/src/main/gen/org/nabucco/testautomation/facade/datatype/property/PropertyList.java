/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyUsageType;

/**
 * PropertyList<p/>CompositeProperty container a list of properties<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public class PropertyList extends PropertyComposite implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "reused", "usageType" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "m0,1;" };

    private Flag reused;

    private PropertyUsageType usageType;

    /** Constructs a new PropertyList instance. */
    public PropertyList() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = PropertyType.LIST;
    }

    /**
     * CloneObject.
     *
     * @param clone the PropertyList.
     */
    protected void cloneObject(PropertyList clone) {
        super.cloneObject(clone);
        clone.setType(this.getType());
        if ((this.getReused() != null)) {
            clone.setReused(this.getReused().cloneObject());
        }
        clone.setUsageType(this.getUsageType());
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[0], Flag.class,
                PROPERTY_CONSTRAINTS[0], this.reused));
        properties.add(new EnumProperty<PropertyUsageType>(PROPERTY_NAMES[1],
                PropertyUsageType.class, PROPERTY_CONSTRAINTS[1], this.usageType));
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
        final PropertyList other = ((PropertyList) obj);
        if ((this.reused == null)) {
            if ((other.reused != null))
                return false;
        } else if ((!this.reused.equals(other.reused)))
            return false;
        if ((this.usageType == null)) {
            if ((other.usageType != null))
                return false;
        } else if ((!this.usageType.equals(other.usageType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.reused == null) ? 0 : this.reused.hashCode()));
        result = ((PRIME * result) + ((this.usageType == null) ? 0 : this.usageType.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PropertyList>\n");
        appendable.append(super.toString());
        appendable.append((("<reused>" + this.reused) + "</reused>\n"));
        appendable.append((("<usageType>" + this.usageType) + "</usageType>\n"));
        appendable.append("</PropertyList>\n");
        return appendable.toString();
    }

    @Override
    public PropertyList cloneObject() {
        PropertyList clone = new PropertyList();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getReused.
     *
     * @return the Flag.
     */
    public Flag getReused() {
        return this.reused;
    }

    /**
     * Missing description at method setReused.
     *
     * @param reused the Flag.
     */
    public void setReused(Flag reused) {
        this.reused = reused;
    }

    /**
     * Missing description at method setReused.
     *
     * @param reused the Boolean.
     */
    public void setReused(Boolean reused) {
        if ((this.reused == null)) {
            this.reused = new Flag();
        }
        this.reused.setValue(reused);
    }

    /**
     * Missing description at method getUsageType.
     *
     * @return the PropertyUsageType.
     */
    public PropertyUsageType getUsageType() {
        return this.usageType;
    }

    /**
     * Missing description at method setUsageType.
     *
     * @param usageType the PropertyUsageType.
     */
    public void setUsageType(PropertyUsageType usageType) {
        this.usageType = usageType;
    }

    /**
     * Missing description at method setUsageType.
     *
     * @param usageType the String.
     */
    public void setUsageType(String usageType) {
        if ((usageType == null)) {
            this.usageType = null;
        } else {
            this.usageType = PropertyUsageType.valueOf(usageType);
        }
    }
}
