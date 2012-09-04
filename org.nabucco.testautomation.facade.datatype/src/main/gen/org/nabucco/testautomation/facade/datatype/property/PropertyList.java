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
package org.nabucco.testautomation.facade.datatype.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "m0,1;" };

    public static final String REUSED = "reused";

    public static final String USAGETYPE = "usageType";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(PropertyComposite.class)
                .getPropertyMap());
        propertyMap.put(REUSED, PropertyDescriptorSupport.createBasetype(REUSED, Flag.class, 9,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(USAGETYPE, PropertyDescriptorSupport.createEnumeration(USAGETYPE,
                PropertyUsageType.class, 10, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PropertyList.getPropertyDescriptor(REUSED),
                this.reused, null));
        properties.add(super.createProperty(PropertyList.getPropertyDescriptor(USAGETYPE),
                this.usageType, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(REUSED) && (property.getType() == Flag.class))) {
            this.setReused(((Flag) property.getInstance()));
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
            if ((reused == null)) {
                return;
            }
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertyList.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertyList.class).getAllProperties();
    }
}
