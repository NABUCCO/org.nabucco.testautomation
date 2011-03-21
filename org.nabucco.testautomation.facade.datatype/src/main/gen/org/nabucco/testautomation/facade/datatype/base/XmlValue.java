/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Basetype;
import org.nabucco.framework.base.facade.datatype.NText;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * XmlValue<p/>Basic datatype for xml values<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-06
 */
public class XmlValue extends NText implements Basetype {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "value";

    private static final String PROPERTY_CONSTRAINTS = "l0,n;";

    /** Constructs a new XmlValue instance. */
    public XmlValue() {
        super();
    }

    /**
     * Constructs a new XmlValue instance.
     *
     * @param value the String.
     */
    public XmlValue(String value) {
        super(value);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROPERTY_NAME, PropertyDescriptorSupport.createSimpletype(PROPERTY_NAME,
                String.class, PROPERTY_CONSTRAINTS));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(XmlValue.getPropertyDescriptor(PROPERTY_NAME).createProperty(this,
                this.getValue(), null));
        return properties;
    }

    @Override
    public XmlValue cloneObject() {
        XmlValue clone = new XmlValue();
        super.cloneObject(clone);
        return clone;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(XmlValue.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(XmlValue.class).getAllProperties();
    }
}
