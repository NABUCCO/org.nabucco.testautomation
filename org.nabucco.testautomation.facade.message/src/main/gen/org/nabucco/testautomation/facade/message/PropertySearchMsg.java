/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyUsageType;

/**
 * PropertySearchMsg<p/>Message for searching Properties<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class PropertySearchMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "propertyName", "propertyId",
            "propertyDescription", "propertyType", "usageType" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "m1,1;", "m1,1;" };

    private Name propertyName;

    private Identifier propertyId;

    private Description propertyDescription;

    private PropertyType propertyType;

    private PropertyUsageType usageType;

    /** Constructs a new PropertySearchMsg instance. */
    public PropertySearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[0], Name.class,
                PROPERTY_CONSTRAINTS[0], this.propertyName));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[1], Identifier.class,
                PROPERTY_CONSTRAINTS[1], this.propertyId));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[2], Description.class,
                PROPERTY_CONSTRAINTS[2], this.propertyDescription));
        properties.add(new EnumProperty<PropertyType>(PROPERTY_NAMES[3], PropertyType.class,
                PROPERTY_CONSTRAINTS[3], this.propertyType));
        properties.add(new EnumProperty<PropertyUsageType>(PROPERTY_NAMES[4],
                PropertyUsageType.class, PROPERTY_CONSTRAINTS[4], this.usageType));
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
        final PropertySearchMsg other = ((PropertySearchMsg) obj);
        if ((this.propertyName == null)) {
            if ((other.propertyName != null))
                return false;
        } else if ((!this.propertyName.equals(other.propertyName)))
            return false;
        if ((this.propertyId == null)) {
            if ((other.propertyId != null))
                return false;
        } else if ((!this.propertyId.equals(other.propertyId)))
            return false;
        if ((this.propertyDescription == null)) {
            if ((other.propertyDescription != null))
                return false;
        } else if ((!this.propertyDescription.equals(other.propertyDescription)))
            return false;
        if ((this.propertyType == null)) {
            if ((other.propertyType != null))
                return false;
        } else if ((!this.propertyType.equals(other.propertyType)))
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
        result = ((PRIME * result) + ((this.propertyName == null) ? 0 : this.propertyName
                .hashCode()));
        result = ((PRIME * result) + ((this.propertyId == null) ? 0 : this.propertyId.hashCode()));
        result = ((PRIME * result) + ((this.propertyDescription == null) ? 0
                : this.propertyDescription.hashCode()));
        result = ((PRIME * result) + ((this.propertyType == null) ? 0 : this.propertyType
                .hashCode()));
        result = ((PRIME * result) + ((this.usageType == null) ? 0 : this.usageType.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PropertySearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<propertyName>" + this.propertyName) + "</propertyName>\n"));
        appendable.append((("<propertyId>" + this.propertyId) + "</propertyId>\n"));
        appendable
                .append((("<propertyDescription>" + this.propertyDescription) + "</propertyDescription>\n"));
        appendable.append((("<propertyType>" + this.propertyType) + "</propertyType>\n"));
        appendable.append((("<usageType>" + this.usageType) + "</usageType>\n"));
        appendable.append("</PropertySearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getPropertyName.
     *
     * @return the Name.
     */
    public Name getPropertyName() {
        return this.propertyName;
    }

    /**
     * Missing description at method setPropertyName.
     *
     * @param propertyName the Name.
     */
    public void setPropertyName(Name propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Missing description at method getPropertyId.
     *
     * @return the Identifier.
     */
    public Identifier getPropertyId() {
        return this.propertyId;
    }

    /**
     * Missing description at method setPropertyId.
     *
     * @param propertyId the Identifier.
     */
    public void setPropertyId(Identifier propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * Missing description at method getPropertyDescription.
     *
     * @return the Description.
     */
    public Description getPropertyDescription() {
        return this.propertyDescription;
    }

    /**
     * Missing description at method setPropertyDescription.
     *
     * @param propertyDescription the Description.
     */
    public void setPropertyDescription(Description propertyDescription) {
        this.propertyDescription = propertyDescription;
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
}
