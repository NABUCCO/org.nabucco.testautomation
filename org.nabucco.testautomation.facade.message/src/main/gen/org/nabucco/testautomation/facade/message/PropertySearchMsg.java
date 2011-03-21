/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "l3,12;m0,1;", "l0,255;m0,1;",
            "l0,n;m0,1;", "l0,255;m0,1;", "m0,1;", "m0,1;" };

    public static final String OWNER = "owner";

    public static final String PROPERTYNAME = "propertyName";

    public static final String PROPERTYID = "propertyId";

    public static final String PROPERTYDESCRIPTION = "propertyDescription";

    public static final String PROPERTYTYPE = "propertyType";

    public static final String USAGETYPE = "usageType";

    private Owner owner;

    private Name propertyName;

    private Identifier propertyId;

    private Description propertyDescription;

    private PropertyType propertyType;

    private PropertyUsageType usageType;

    /** Constructs a new PropertySearchMsg instance. */
    public PropertySearchMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(OWNER, PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 0,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(PROPERTYNAME, PropertyDescriptorSupport.createBasetype(PROPERTYNAME,
                Name.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(PROPERTYID, PropertyDescriptorSupport.createBasetype(PROPERTYID,
                Identifier.class, 2, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(PROPERTYDESCRIPTION, PropertyDescriptorSupport.createBasetype(
                PROPERTYDESCRIPTION, Description.class, 3, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(PROPERTYTYPE, PropertyDescriptorSupport.createEnumeration(PROPERTYTYPE,
                PropertyType.class, 4, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(USAGETYPE, PropertyDescriptorSupport.createEnumeration(USAGETYPE,
                PropertyUsageType.class, 5, PROPERTY_CONSTRAINTS[5], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PropertySearchMsg.getPropertyDescriptor(OWNER),
                this.owner));
        properties.add(super.createProperty(PropertySearchMsg.getPropertyDescriptor(PROPERTYNAME),
                this.propertyName));
        properties.add(super.createProperty(PropertySearchMsg.getPropertyDescriptor(PROPERTYID),
                this.propertyId));
        properties.add(super.createProperty(
                PropertySearchMsg.getPropertyDescriptor(PROPERTYDESCRIPTION),
                this.propertyDescription));
        properties.add(super.createProperty(PropertySearchMsg.getPropertyDescriptor(PROPERTYTYPE),
                this.propertyType));
        properties.add(super.createProperty(PropertySearchMsg.getPropertyDescriptor(USAGETYPE),
                this.usageType));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(OWNER) && (property.getType() == Owner.class))) {
            this.setOwner(((Owner) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYNAME) && (property.getType() == Name.class))) {
            this.setPropertyName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYID) && (property.getType() == Identifier.class))) {
            this.setPropertyId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYDESCRIPTION) && (property.getType() == Description.class))) {
            this.setPropertyDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYTYPE) && (property.getType() == PropertyType.class))) {
            this.setPropertyType(((PropertyType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USAGETYPE) && (property.getType() == PropertyUsageType.class))) {
            this.setUsageType(((PropertyUsageType) property.getInstance()));
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
        final PropertySearchMsg other = ((PropertySearchMsg) obj);
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
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
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
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
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getOwner.
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Missing description at method setOwner.
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertySearchMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertySearchMsg.class).getAllProperties();
    }
}
