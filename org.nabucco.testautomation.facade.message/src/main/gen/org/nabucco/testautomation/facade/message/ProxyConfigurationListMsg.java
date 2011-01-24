/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;

/**
 * ProxyConfigurationListMsg<p/>Message containing a list of ProxyConfigurations<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-12-27
 */
public class ProxyConfigurationListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "proxyConfigurationList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<ProxyConfiguration> proxyConfigurationList;

    /** Constructs a new ProxyConfigurationListMsg instance. */
    public ProxyConfigurationListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<ProxyConfiguration>(PROPERTY_NAMES[0],
                ProxyConfiguration.class, PROPERTY_CONSTRAINTS[0], this.proxyConfigurationList));
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
        final ProxyConfigurationListMsg other = ((ProxyConfigurationListMsg) obj);
        if ((this.proxyConfigurationList == null)) {
            if ((other.proxyConfigurationList != null))
                return false;
        } else if ((!this.proxyConfigurationList.equals(other.proxyConfigurationList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.proxyConfigurationList == null) ? 0
                : this.proxyConfigurationList.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProxyConfigurationListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<proxyConfigurationList>" + this.proxyConfigurationList) + "</proxyConfigurationList>\n"));
        appendable.append("</ProxyConfigurationListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProxyConfigurationList.
     *
     * @return the List<ProxyConfiguration>.
     */
    public List<ProxyConfiguration> getProxyConfigurationList() {
        if ((this.proxyConfigurationList == null)) {
            this.proxyConfigurationList = new ArrayList<ProxyConfiguration>();
        }
        return this.proxyConfigurationList;
    }
}
