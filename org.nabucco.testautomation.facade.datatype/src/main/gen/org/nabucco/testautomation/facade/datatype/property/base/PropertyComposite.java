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
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;

/**
 * PropertyComposite<p/>Abstract superclass for all PropertyComposite types<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public abstract class PropertyComposite extends Property implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    public static final String PROPERTYLIST = "propertyList";

    private NabuccoList<PropertyContainer> propertyList;

    /** Constructs a new PropertyComposite instance. */
    public PropertyComposite() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PropertyComposite.
     */
    protected void cloneObject(PropertyComposite clone) {
        super.cloneObject(clone);
        if ((this.propertyList != null)) {
            clone.propertyList = this.propertyList.cloneCollection();
        }
    }

    /**
     * Getter for the PropertyListJPA.
     *
     * @return the List<PropertyContainer>.
     */
    List<PropertyContainer> getPropertyListJPA() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<PropertyContainer>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<PropertyContainer>) this.propertyList).getDelegate();
    }

    /**
     * Setter for the PropertyListJPA.
     *
     * @param propertyList the List<PropertyContainer>.
     */
    void setPropertyListJPA(List<PropertyContainer> propertyList) {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<PropertyContainer>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<PropertyContainer>) this.propertyList).setDelegate(propertyList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Property.class).getPropertyMap());
        propertyMap.put(PROPERTYLIST, PropertyDescriptorSupport.createCollection(PROPERTYLIST,
                PropertyContainer.class, 8, PROPERTY_CONSTRAINTS[0], false,
                PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PropertyComposite.getPropertyDescriptor(PROPERTYLIST),
                this.propertyList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROPERTYLIST) && (property.getType() == PropertyContainer.class))) {
            this.propertyList = ((NabuccoList<PropertyContainer>) property.getInstance());
            return true;
        }
        return false;
    }

    @Override
    public abstract PropertyComposite cloneObject();

    /**
     * Missing description at method getPropertyList.
     *
     * @return the NabuccoList<PropertyContainer>.
     */
    public NabuccoList<PropertyContainer> getPropertyList() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<PropertyContainer>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.propertyList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertyComposite.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertyComposite.class).getAllProperties();
    }
}
