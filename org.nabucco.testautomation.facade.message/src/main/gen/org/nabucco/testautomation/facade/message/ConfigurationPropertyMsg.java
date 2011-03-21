/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;

/**
 * ConfigurationPropertyMsg<p/>Message for transporting a ConfigurationProperty<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-12-27
 */
public class ConfigurationPropertyMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String CONFIGURATIONPROPERTY = "configurationProperty";

    private ConfigurationProperty configurationProperty;

    /** Constructs a new ConfigurationPropertyMsg instance. */
    public ConfigurationPropertyMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(CONFIGURATIONPROPERTY, PropertyDescriptorSupport.createDatatype(
                CONFIGURATIONPROPERTY, ConfigurationProperty.class, 0, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                ConfigurationPropertyMsg.getPropertyDescriptor(CONFIGURATIONPROPERTY),
                this.configurationProperty));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CONFIGURATIONPROPERTY) && (property.getType() == ConfigurationProperty.class))) {
            this.setConfigurationProperty(((ConfigurationProperty) property.getInstance()));
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
        final ConfigurationPropertyMsg other = ((ConfigurationPropertyMsg) obj);
        if ((this.configurationProperty == null)) {
            if ((other.configurationProperty != null))
                return false;
        } else if ((!this.configurationProperty.equals(other.configurationProperty)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.configurationProperty == null) ? 0
                : this.configurationProperty.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getConfigurationProperty.
     *
     * @return the ConfigurationProperty.
     */
    public ConfigurationProperty getConfigurationProperty() {
        return this.configurationProperty;
    }

    /**
     * Missing description at method setConfigurationProperty.
     *
     * @param configurationProperty the ConfigurationProperty.
     */
    public void setConfigurationProperty(ConfigurationProperty configurationProperty) {
        this.configurationProperty = configurationProperty;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ConfigurationPropertyMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ConfigurationPropertyMsg.class)
                .getAllProperties();
    }
}
