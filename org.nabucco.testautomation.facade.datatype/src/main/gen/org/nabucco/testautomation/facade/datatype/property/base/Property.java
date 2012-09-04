/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.base.ExportDatatype;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyReference;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * Property<p/>Abstract superclass for all property types<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public abstract class Property extends ExportDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,255;m0,1;", "l0,255;m0,1;",
            "l0,n;m0,1;" };

    public static final String TYPE = "type";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String REFERENCE = "reference";

    protected PropertyType type;

    private Name name;

    private Description description;

    private PropertyReference reference;

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
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getReference() != null)) {
            clone.setReference(this.getReference().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ExportDatatype.class)
                .getPropertyMap());
        propertyMap.put(TYPE, PropertyDescriptorSupport.createEnumeration(TYPE, PropertyType.class,
                4, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 5,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION,
                Description.class, 6, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(REFERENCE, PropertyDescriptorSupport.createBasetype(REFERENCE,
                PropertyReference.class, 7, PROPERTY_CONSTRAINTS[3], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Property.getPropertyDescriptor(TYPE), this.type, null));
        properties.add(super.createProperty(Property.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(Property.getPropertyDescriptor(DESCRIPTION),
                this.description, null));
        properties.add(super.createProperty(Property.getPropertyDescriptor(REFERENCE),
                this.reference, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(TYPE) && (property.getType() == PropertyType.class))) {
            this.setType(((PropertyType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == Description.class))) {
            this.setDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REFERENCE) && (property.getType() == PropertyReference.class))) {
            this.setReference(((PropertyReference) property.getInstance()));
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
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.reference == null)) {
            if ((other.reference != null))
                return false;
        } else if ((!this.reference.equals(other.reference)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.reference == null) ? 0 : this.reference.hashCode()));
        return result;
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
            if ((name == null)) {
                return;
            }
            this.name = new Name();
        }
        this.name.setValue(name);
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
            if ((description == null)) {
                return;
            }
            this.description = new Description();
        }
        this.description.setValue(description);
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
            if ((reference == null)) {
                return;
            }
            this.reference = new PropertyReference();
        }
        this.reference.setValue(reference);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Property.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Property.class).getAllProperties();
    }
}
