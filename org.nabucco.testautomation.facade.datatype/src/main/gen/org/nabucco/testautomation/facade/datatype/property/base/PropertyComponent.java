/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.testautomation.facade.datatype.property.base.Property;

/**
 * PropertyComponent<p/>Abstract superclass for all leafs<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public abstract class PropertyComponent extends Property implements Datatype {

    private static final long serialVersionUID = 1L;

    /** Constructs a new PropertyComponent instance. */
    public PropertyComponent() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PropertyComponent.
     */
    protected void cloneObject(PropertyComponent clone) {
        super.cloneObject(clone);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Property.class).getPropertyMap());
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        return properties;
    }

    @Override
    public abstract PropertyComponent cloneObject();

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PropertyComponent.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PropertyComponent.class).getAllProperties();
    }
}
