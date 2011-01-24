/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;

/**
 * ProxyConfigurationMsg<p/>Message for transporting a ProxyConfiguration<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-12-27
 */
public class ProxyConfigurationMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "proxyConfiguration" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private ProxyConfiguration proxyConfiguration;

    /** Constructs a new ProxyConfigurationMsg instance. */
    public ProxyConfigurationMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<ProxyConfiguration>(PROPERTY_NAMES[0],
                ProxyConfiguration.class, PROPERTY_CONSTRAINTS[0], this.proxyConfiguration));
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
        final ProxyConfigurationMsg other = ((ProxyConfigurationMsg) obj);
        if ((this.proxyConfiguration == null)) {
            if ((other.proxyConfiguration != null))
                return false;
        } else if ((!this.proxyConfiguration.equals(other.proxyConfiguration)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.proxyConfiguration == null) ? 0
                : this.proxyConfiguration.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProxyConfigurationMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<proxyConfiguration>" + this.proxyConfiguration) + "</proxyConfiguration>\n"));
        appendable.append("</ProxyConfigurationMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
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
}
