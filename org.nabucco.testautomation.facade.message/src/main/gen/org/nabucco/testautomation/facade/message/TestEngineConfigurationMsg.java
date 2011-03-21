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
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;

/**
 * TestEngineConfigurationMsg<p/>Message for persisting a TestEngineConfiguration<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestEngineConfigurationMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m1,1;" };

    public static final String TESTENGINECONFIGURATION = "testEngineConfiguration";

    public static final String PROXYCONFIGURATION = "proxyConfiguration";

    public static final String CONFIGURATIONPROPERTY = "configurationProperty";

    private TestEngineConfiguration testEngineConfiguration;

    private ProxyConfiguration proxyConfiguration;

    private ConfigurationProperty configurationProperty;

    /** Constructs a new TestEngineConfigurationMsg instance. */
    public TestEngineConfigurationMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(TESTENGINECONFIGURATION, PropertyDescriptorSupport.createDatatype(
                TESTENGINECONFIGURATION, TestEngineConfiguration.class, 0, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROXYCONFIGURATION, PropertyDescriptorSupport.createDatatype(
                PROXYCONFIGURATION, ProxyConfiguration.class, 1, PROPERTY_CONSTRAINTS[1], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(CONFIGURATIONPROPERTY, PropertyDescriptorSupport.createDatatype(
                CONFIGURATIONPROPERTY, ConfigurationProperty.class, 2, PROPERTY_CONSTRAINTS[2],
                false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                TestEngineConfigurationMsg.getPropertyDescriptor(TESTENGINECONFIGURATION),
                this.testEngineConfiguration));
        properties.add(super.createProperty(
                TestEngineConfigurationMsg.getPropertyDescriptor(PROXYCONFIGURATION),
                this.proxyConfiguration));
        properties.add(super.createProperty(
                TestEngineConfigurationMsg.getPropertyDescriptor(CONFIGURATIONPROPERTY),
                this.configurationProperty));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(TESTENGINECONFIGURATION) && (property.getType() == TestEngineConfiguration.class))) {
            this.setTestEngineConfiguration(((TestEngineConfiguration) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROXYCONFIGURATION) && (property.getType() == ProxyConfiguration.class))) {
            this.setProxyConfiguration(((ProxyConfiguration) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONFIGURATIONPROPERTY) && (property.getType() == ConfigurationProperty.class))) {
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
        final TestEngineConfigurationMsg other = ((TestEngineConfigurationMsg) obj);
        if ((this.testEngineConfiguration == null)) {
            if ((other.testEngineConfiguration != null))
                return false;
        } else if ((!this.testEngineConfiguration.equals(other.testEngineConfiguration)))
            return false;
        if ((this.proxyConfiguration == null)) {
            if ((other.proxyConfiguration != null))
                return false;
        } else if ((!this.proxyConfiguration.equals(other.proxyConfiguration)))
            return false;
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
        result = ((PRIME * result) + ((this.testEngineConfiguration == null) ? 0
                : this.testEngineConfiguration.hashCode()));
        result = ((PRIME * result) + ((this.proxyConfiguration == null) ? 0
                : this.proxyConfiguration.hashCode()));
        result = ((PRIME * result) + ((this.configurationProperty == null) ? 0
                : this.configurationProperty.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getTestEngineConfiguration.
     *
     * @return the TestEngineConfiguration.
     */
    public TestEngineConfiguration getTestEngineConfiguration() {
        return this.testEngineConfiguration;
    }

    /**
     * Missing description at method setTestEngineConfiguration.
     *
     * @param testEngineConfiguration the TestEngineConfiguration.
     */
    public void setTestEngineConfiguration(TestEngineConfiguration testEngineConfiguration) {
        this.testEngineConfiguration = testEngineConfiguration;
    }

    /**
     * Missing description at method getProxyConfiguration.
     *
     * @return the ProxyConfiguration.
     */
    public ProxyConfiguration getProxyConfiguration() {
        return this.proxyConfiguration;
    }

    /**
     * Missing description at method setProxyConfiguration.
     *
     * @param proxyConfiguration the ProxyConfiguration.
     */
    public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
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
        return PropertyCache.getInstance().retrieve(TestEngineConfigurationMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestEngineConfigurationMsg.class)
                .getAllProperties();
    }
}
