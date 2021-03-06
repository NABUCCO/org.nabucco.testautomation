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
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Order;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * PropertyContainer<p/>Container holding a Property and its order position<p/>
 *
 * @version 1.0
 * @author sschmidt, PRODYNA AG, 2010-10-05
 */
public class PropertyContainer extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m0,1;" };

    public static final String PROPERTY = "property";

    public static final String ORDERINDEX = "orderIndex";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class)
                .getPropertyMap());
        propertyMap.put(PROPERTY, PropertyDescriptorSupport.createDatatype(PROPERTY,
                Property.class, 2, PROPERTY_CONSTRAINTS[0], false,
                PropertyAssociationType.AGGREGATION));
        propertyMap.put(ORDERINDEX, PropertyDescriptorSupport.createBasetype(ORDERINDEX,
                Order.class, 3, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PropertyContainer.getPropertyDescriptor(PROPERTY),
                this.property, null));
        properties.add(super.createProperty(PropertyContainer.getPropertyDescriptor(ORDERINDEX),
                this.orderIndex, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROPERTY) && (property.getType() == Property.class))) {
            this.setProperty(((Property) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ORDERINDEX) && (property.getType() == Order.class))) {
            this.setOrderIndex(((Order) property.getInstance()));
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
            if ((orderIndex == null)) {
                return;
            }
            this.orderIndex = new Order();
        }
        this.orderIndex.setValue(orderIndex);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertyContainer.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertyContainer.class).getAllProperties();
    }
}
