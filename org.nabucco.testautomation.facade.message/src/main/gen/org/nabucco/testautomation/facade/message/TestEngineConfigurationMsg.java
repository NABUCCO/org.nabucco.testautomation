/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "testEngineConfiguration",
            "proxyConfiguration", "configurationProperty" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m1,1;" };

    private TestEngineConfiguration testEngineConfiguration;

    private ProxyConfiguration proxyConfiguration;

    private ConfigurationProperty configurationProperty;

    /** Constructs a new TestEngineConfigurationMsg instance. */
    public TestEngineConfigurationMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<TestEngineConfiguration>(PROPERTY_NAMES[0],
                TestEngineConfiguration.class, PROPERTY_CONSTRAINTS[0],
                this.testEngineConfiguration));
        properties.add(new DatatypeProperty<ProxyConfiguration>(PROPERTY_NAMES[1],
                ProxyConfiguration.class, PROPERTY_CONSTRAINTS[1], this.proxyConfiguration));
        properties.add(new DatatypeProperty<ConfigurationProperty>(PROPERTY_NAMES[2],
                ConfigurationProperty.class, PROPERTY_CONSTRAINTS[2], this.configurationProperty));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestEngineConfigurationMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<testEngineConfiguration>" + this.testEngineConfiguration) + "</testEngineConfiguration>\n"));
        appendable
                .append((("<proxyConfiguration>" + this.proxyConfiguration) + "</proxyConfiguration>\n"));
        appendable
                .append((("<configurationProperty>" + this.configurationProperty) + "</configurationProperty>\n"));
        appendable.append("</TestEngineConfigurationMsg>\n");
        return appendable.toString();
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
}
