/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "configurationProperty" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private ConfigurationProperty configurationProperty;

    /** Constructs a new ConfigurationPropertyMsg instance. */
    public ConfigurationPropertyMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<ConfigurationProperty>(PROPERTY_NAMES[0],
                ConfigurationProperty.class, PROPERTY_CONSTRAINTS[0], this.configurationProperty));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ConfigurationPropertyMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<configurationProperty>" + this.configurationProperty) + "</configurationProperty>\n"));
        appendable.append("</ConfigurationPropertyMsg>\n");
        return appendable.toString();
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
}
