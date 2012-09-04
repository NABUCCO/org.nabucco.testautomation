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
package org.nabucco.testautomation.facade.datatype.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
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

/**
 * ContextSnapshot<p/>A Snapshot of the TestContext<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-03
 */
public class ContextSnapshot extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;", "m0,n;" };

    public static final String PROPERTYLIST = "propertyList";

    public static final String CURRENTTESTCONFIGELEMENTLIST = "currentTestConfigElementList";

    private NabuccoList<Property> propertyList;

    private NabuccoList<TestConfigElementLink> currentTestConfigElementList;

    /** Constructs a new ContextSnapshot instance. */
    public ContextSnapshot() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ContextSnapshot.
     */
    protected void cloneObject(ContextSnapshot clone) {
        super.cloneObject(clone);
        if ((this.propertyList != null)) {
            clone.propertyList = this.propertyList.cloneCollection();
        }
        if ((this.currentTestConfigElementList != null)) {
            clone.currentTestConfigElementList = this.currentTestConfigElementList
                    .cloneCollection();
        }
    }

    /**
     * Getter for the PropertyListJPA.
     *
     * @return the List<Property>.
     */
    List<Property> getPropertyListJPA() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<Property>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<Property>) this.propertyList).getDelegate();
    }

    /**
     * Setter for the PropertyListJPA.
     *
     * @param propertyList the List<Property>.
     */
    void setPropertyListJPA(List<Property> propertyList) {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<Property>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<Property>) this.propertyList).setDelegate(propertyList);
    }

    /**
     * Getter for the CurrentTestConfigElementListJPA.
     *
     * @return the List<TestConfigElementLink>.
     */
    List<TestConfigElementLink> getCurrentTestConfigElementListJPA() {
        if ((this.currentTestConfigElementList == null)) {
            this.currentTestConfigElementList = new NabuccoListImpl<TestConfigElementLink>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<TestConfigElementLink>) this.currentTestConfigElementList)
                .getDelegate();
    }

    /**
     * Setter for the CurrentTestConfigElementListJPA.
     *
     * @param currentTestConfigElementList the List<TestConfigElementLink>.
     */
    void setCurrentTestConfigElementListJPA(List<TestConfigElementLink> currentTestConfigElementList) {
        if ((this.currentTestConfigElementList == null)) {
            this.currentTestConfigElementList = new NabuccoListImpl<TestConfigElementLink>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<TestConfigElementLink>) this.currentTestConfigElementList)
                .setDelegate(currentTestConfigElementList);
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
        propertyMap.put(PROPERTYLIST, PropertyDescriptorSupport.createCollection(PROPERTYLIST,
                Property.class, 2, PROPERTY_CONSTRAINTS[0], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(CURRENTTESTCONFIGELEMENTLIST, PropertyDescriptorSupport.createCollection(
                CURRENTTESTCONFIGELEMENTLIST, TestConfigElementLink.class, 3,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ContextSnapshot.getPropertyDescriptor(PROPERTYLIST),
                this.propertyList, null));
        properties.add(super.createProperty(
                ContextSnapshot.getPropertyDescriptor(CURRENTTESTCONFIGELEMENTLIST),
                this.currentTestConfigElementList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROPERTYLIST) && (property.getType() == Property.class))) {
            this.propertyList = ((NabuccoList<Property>) property.getInstance());
            return true;
        } else if ((property.getName().equals(CURRENTTESTCONFIGELEMENTLIST) && (property.getType() == TestConfigElementLink.class))) {
            this.currentTestConfigElementList = ((NabuccoList<TestConfigElementLink>) property
                    .getInstance());
            return true;
        }
        return false;
    }

    @Override
    public ContextSnapshot cloneObject() {
        ContextSnapshot clone = new ContextSnapshot();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getPropertyList.
     *
     * @return the NabuccoList<Property>.
     */
    public NabuccoList<Property> getPropertyList() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoListImpl<Property>(NabuccoCollectionState.INITIALIZED);
        }
        return this.propertyList;
    }

    /**
     * Missing description at method getCurrentTestConfigElementList.
     *
     * @return the NabuccoList<TestConfigElementLink>.
     */
    public NabuccoList<TestConfigElementLink> getCurrentTestConfigElementList() {
        if ((this.currentTestConfigElementList == null)) {
            this.currentTestConfigElementList = new NabuccoListImpl<TestConfigElementLink>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.currentTestConfigElementList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ContextSnapshot.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ContextSnapshot.class).getAllProperties();
    }
}
