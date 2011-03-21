/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    public static final String PROXYCONFIGURATIONLIST = "proxyConfigurationList";

    private NabuccoList<ProxyConfiguration> proxyConfigurationList;

    /** Constructs a new ProxyConfigurationListMsg instance. */
    public ProxyConfigurationListMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROXYCONFIGURATIONLIST, PropertyDescriptorSupport.createCollection(
                PROXYCONFIGURATIONLIST, ProxyConfiguration.class, 0, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                ProxyConfigurationListMsg.getPropertyDescriptor(PROXYCONFIGURATIONLIST),
                this.proxyConfigurationList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROXYCONFIGURATIONLIST) && (property.getType() == ProxyConfiguration.class))) {
            this.proxyConfigurationList = ((NabuccoList<ProxyConfiguration>) property.getInstance());
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
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProxyConfigurationList.
     *
     * @return the NabuccoList<ProxyConfiguration>.
     */
    public NabuccoList<ProxyConfiguration> getProxyConfigurationList() {
        if ((this.proxyConfigurationList == null)) {
            this.proxyConfigurationList = new NabuccoListImpl<ProxyConfiguration>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.proxyConfigurationList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProxyConfigurationListMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProxyConfigurationListMsg.class)
                .getAllProperties();
    }
}
