/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ExportDatatype<p/>BaseType containing export information<p/>
 *
 * @version 1.0
 * @author sschmidt, PRODYNA AG, 2011-02-21
 */
public class ExportDatatype extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l3,12;m1,1;", "l0,16;m1,1;" };

    public static final String OWNER = "owner";

    public static final String IDENTIFICATIONKEY = "identificationKey";

    protected Owner owner;

    protected Key identificationKey;

    /** Constructs a new ExportDatatype instance. */
    public ExportDatatype() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ExportDatatype.
     */
    protected void cloneObject(ExportDatatype clone) {
        super.cloneObject(clone);
        if ((this.getOwner() != null)) {
            clone.setOwner(this.getOwner().cloneObject());
        }
        if ((this.getIdentificationKey() != null)) {
            clone.setIdentificationKey(this.getIdentificationKey().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class)
                .getPropertyMap());
        propertyMap.put(OWNER, PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 2,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(IDENTIFICATIONKEY, PropertyDescriptorSupport.createBasetype(
                IDENTIFICATIONKEY, Key.class, 3, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ExportDatatype.getPropertyDescriptor(OWNER),
                this.owner, null));
        properties.add(super.createProperty(
                ExportDatatype.getPropertyDescriptor(IDENTIFICATIONKEY), this.identificationKey,
                null));
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
        } else if ((property.getName().equals(IDENTIFICATIONKEY) && (property.getType() == Key.class))) {
            this.setIdentificationKey(((Key) property.getInstance()));
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
        final ExportDatatype other = ((ExportDatatype) obj);
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
        if ((this.identificationKey == null)) {
            if ((other.identificationKey != null))
                return false;
        } else if ((!this.identificationKey.equals(other.identificationKey)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.identificationKey == null) ? 0 : this.identificationKey
                .hashCode()));
        return result;
    }

    @Override
    public ExportDatatype cloneObject() {
        ExportDatatype clone = new ExportDatatype();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method setOwner.
     *
     * @param owner the String.
     */
    public void setOwner(String owner) {
        if ((this.owner == null)) {
            if ((owner == null)) {
                return;
            }
            this.owner = new Owner();
        }
        this.owner.setValue(owner);
    }

    /**
     * Missing description at method getIdentificationKey.
     *
     * @return the Key.
     */
    public Key getIdentificationKey() {
        return this.identificationKey;
    }

    /**
     * Missing description at method setIdentificationKey.
     *
     * @param identificationKey the Key.
     */
    public void setIdentificationKey(Key identificationKey) {
        this.identificationKey = identificationKey;
    }

    /**
     * Missing description at method setIdentificationKey.
     *
     * @param identificationKey the String.
     */
    public void setIdentificationKey(String identificationKey) {
        if ((this.identificationKey == null)) {
            if ((identificationKey == null)) {
                return;
            }
            this.identificationKey = new Key();
        }
        this.identificationKey.setValue(identificationKey);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ExportDatatype.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ExportDatatype.class).getAllProperties();
    }
}
