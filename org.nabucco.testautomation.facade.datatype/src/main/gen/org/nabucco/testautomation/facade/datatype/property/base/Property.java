/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyReference;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * Property<p/>Abstract superclass for all property types<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public abstract class Property extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "type", "name", "reference", "description" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m0,1;", "l0,n;m0,1;",
            "l0,n;m0,1;" };

    protected PropertyType type;

    private Name name;

    private PropertyReference reference;

    private Description description;

    /** Constructs a new Property instance. */
    public Property() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the Property.
     */
    protected void cloneObject(Property clone) {
        super.cloneObject(clone);
        clone.setType(this.getType());
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getReference() != null)) {
            clone.setReference(this.getReference().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<PropertyType>(PROPERTY_NAMES[0], PropertyType.class,
                PROPERTY_CONSTRAINTS[0], this.type));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.name));
        properties.add(new BasetypeProperty<PropertyReference>(PROPERTY_NAMES[2],
                PropertyReference.class, PROPERTY_CONSTRAINTS[2], this.reference));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[3], Description.class,
                PROPERTY_CONSTRAINTS[3], this.description));
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
        final Property other = ((Property) obj);
        if ((this.type == null)) {
            if ((other.type != null))
                return false;
        } else if ((!this.type.equals(other.type)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.reference == null)) {
            if ((other.reference != null))
                return false;
        } else if ((!this.reference.equals(other.reference)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.reference == null) ? 0 : this.reference.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<Property>\n");
        appendable.append(super.toString());
        appendable.append((("<type>" + this.type) + "</type>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<reference>" + this.reference) + "</reference>\n"));
        appendable.append((("<description>" + this.description) + "</description>\n"));
        appendable.append("</Property>\n");
        return appendable.toString();
    }

    @Override
    public abstract Property cloneObject();

    /**
     * Missing description at method getType.
     *
     * @return the PropertyType.
     */
    public PropertyType getType() {
        return this.type;
    }

    /**
     * Missing description at method setType.
     *
     * @param type the PropertyType.
     */
    public void setType(PropertyType type) {
        this.type = type;
    }

    /**
     * Missing description at method setType.
     *
     * @param type the String.
     */
    public void setType(String type) {
        if ((type == null)) {
            this.type = null;
        } else {
            this.type = PropertyType.valueOf(type);
        }
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
     * Missing description at method setName.
     *
     * @param name the String.
     */
    public void setName(String name) {
        if ((this.name == null)) {
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Missing description at method getReference.
     *
     * @return the PropertyReference.
     */
    public PropertyReference getReference() {
        return this.reference;
    }

    /**
     * Missing description at method setReference.
     *
     * @param reference the PropertyReference.
     */
    public void setReference(PropertyReference reference) {
        this.reference = reference;
    }

    /**
     * Missing description at method setReference.
     *
     * @param reference the String.
     */
    public void setReference(String reference) {
        if ((this.reference == null)) {
            this.reference = new PropertyReference();
        }
        this.reference.setValue(reference);
    }

    /**
     * Missing description at method getDescription.
     *
     * @return the Description.
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the Description.
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the String.
     */
    public void setDescription(String description) {
        if ((this.description == null)) {
            this.description = new Description();
        }
        this.description.setValue(description);
    }
}
