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
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;

/**
 * TestEngineConfiguration<p/>Wrapper containing the configuration for the TestEngine-connection<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestEngineConfiguration extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m1,1;", "l0,255;m0,1;", "m0,1;",
            "l0,255;m1,1;", "l0,255;m1,1;", "l0,255;m1,1;", "m0,n;" };

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String USER = "user";

    public static final String HOST = "host";

    public static final String PORT = "port";

    public static final String REMOTEREFERENCENAME = "remoteReferenceName";

    public static final String PROXYCONFIGURATIONS = "proxyConfigurations";

    private Name name;

    private Description description;

    private User user;

    private Long userRefId;

    private Name host;

    private Name port;

    private Name remoteReferenceName;

    private NabuccoList<ProxyConfiguration> proxyConfigurations;

    /** Constructs a new TestEngineConfiguration instance. */
    public TestEngineConfiguration() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestEngineConfiguration.
     */
    protected void cloneObject(TestEngineConfiguration clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getUser() != null)) {
            clone.setUser(this.getUser().cloneObject());
        }
        if ((this.getUserRefId() != null)) {
            clone.setUserRefId(this.getUserRefId());
        }
        if ((this.getHost() != null)) {
            clone.setHost(this.getHost().cloneObject());
        }
        if ((this.getPort() != null)) {
            clone.setPort(this.getPort().cloneObject());
        }
        if ((this.getRemoteReferenceName() != null)) {
            clone.setRemoteReferenceName(this.getRemoteReferenceName().cloneObject());
        }
        if ((this.proxyConfigurations != null)) {
            clone.proxyConfigurations = this.proxyConfigurations.cloneCollection();
        }
    }

    /**
     * Getter for the ProxyConfigurationsJPA.
     *
     * @return the List<ProxyConfiguration>.
     */
    List<ProxyConfiguration> getProxyConfigurationsJPA() {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoListImpl<ProxyConfiguration>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProxyConfiguration>) this.proxyConfigurations).getDelegate();
    }

    /**
     * Setter for the ProxyConfigurationsJPA.
     *
     * @param proxyConfigurations the List<ProxyConfiguration>.
     */
    void setProxyConfigurationsJPA(List<ProxyConfiguration> proxyConfigurations) {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoListImpl<ProxyConfiguration>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProxyConfiguration>) this.proxyConfigurations)
                .setDelegate(proxyConfigurations);
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
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 2,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION,
                Description.class, 3, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(USER, PropertyDescriptorSupport.createDatatype(USER, User.class, 4,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(HOST, PropertyDescriptorSupport.createBasetype(HOST, Name.class, 5,
                PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(PORT, PropertyDescriptorSupport.createBasetype(PORT, Name.class, 6,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(REMOTEREFERENCENAME, PropertyDescriptorSupport.createBasetype(
                REMOTEREFERENCENAME, Name.class, 7, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(PROXYCONFIGURATIONS, PropertyDescriptorSupport.createCollection(
                PROXYCONFIGURATIONS, ProxyConfiguration.class, 8, PROPERTY_CONSTRAINTS[6], false,
                PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestEngineConfiguration.getPropertyDescriptor(NAME),
                this.name, null));
        properties
                .add(super.createProperty(
                        TestEngineConfiguration.getPropertyDescriptor(DESCRIPTION),
                        this.description, null));
        properties.add(super.createProperty(TestEngineConfiguration.getPropertyDescriptor(USER),
                this.user, this.userRefId));
        properties.add(super.createProperty(TestEngineConfiguration.getPropertyDescriptor(HOST),
                this.host, null));
        properties.add(super.createProperty(TestEngineConfiguration.getPropertyDescriptor(PORT),
                this.port, null));
        properties.add(super.createProperty(
                TestEngineConfiguration.getPropertyDescriptor(REMOTEREFERENCENAME),
                this.remoteReferenceName, null));
        properties.add(super.createProperty(
                TestEngineConfiguration.getPropertyDescriptor(PROXYCONFIGURATIONS),
                this.proxyConfigurations, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == Description.class))) {
            this.setDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USER) && (property.getType() == User.class))) {
            this.setUser(((User) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HOST) && (property.getType() == Name.class))) {
            this.setHost(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PORT) && (property.getType() == Name.class))) {
            this.setPort(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REMOTEREFERENCENAME) && (property.getType() == Name.class))) {
            this.setRemoteReferenceName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROXYCONFIGURATIONS) && (property.getType() == ProxyConfiguration.class))) {
            this.proxyConfigurations = ((NabuccoList<ProxyConfiguration>) property.getInstance());
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
        final TestEngineConfiguration other = ((TestEngineConfiguration) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.user == null)) {
            if ((other.user != null))
                return false;
        } else if ((!this.user.equals(other.user)))
            return false;
        if ((this.userRefId == null)) {
            if ((other.userRefId != null))
                return false;
        } else if ((!this.userRefId.equals(other.userRefId)))
            return false;
        if ((this.host == null)) {
            if ((other.host != null))
                return false;
        } else if ((!this.host.equals(other.host)))
            return false;
        if ((this.port == null)) {
            if ((other.port != null))
                return false;
        } else if ((!this.port.equals(other.port)))
            return false;
        if ((this.remoteReferenceName == null)) {
            if ((other.remoteReferenceName != null))
                return false;
        } else if ((!this.remoteReferenceName.equals(other.remoteReferenceName)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.user == null) ? 0 : this.user.hashCode()));
        result = ((PRIME * result) + ((this.userRefId == null) ? 0 : this.userRefId.hashCode()));
        result = ((PRIME * result) + ((this.host == null) ? 0 : this.host.hashCode()));
        result = ((PRIME * result) + ((this.port == null) ? 0 : this.port.hashCode()));
        result = ((PRIME * result) + ((this.remoteReferenceName == null) ? 0
                : this.remoteReferenceName.hashCode()));
        return result;
    }

    @Override
    public TestEngineConfiguration cloneObject() {
        TestEngineConfiguration clone = new TestEngineConfiguration();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getName.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the String.
     */
    public void setName(String name) {
        if ((this.name == null)) {
            if ((name == null)) {
                return;
            }
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Missing description at method getDescription.
     *
     * @return the Description.
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the Description.
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the String.
     */
    public void setDescription(String description) {
        if ((this.description == null)) {
            if ((description == null)) {
                return;
            }
            this.description = new Description();
        }
        this.description.setValue(description);
    }

    /**
     * Missing description at method setUser.
     *
     * @param user the User.
     */
    public void setUser(User user) {
        this.user = user;
        if ((user != null)) {
            this.setUserRefId(user.getId());
        } else {
            this.setUserRefId(null);
        }
    }

    /**
     * Missing description at method getUser.
     *
     * @return the User.
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Getter for the UserRefId.
     *
     * @return the Long.
     */
    public Long getUserRefId() {
        return this.userRefId;
    }

    /**
     * Setter for the UserRefId.
     *
     * @param userRefId the Long.
     */
    public void setUserRefId(Long userRefId) {
        this.userRefId = userRefId;
    }

    /**
     * Missing description at method getHost.
     *
     * @return the Name.
     */
    public Name getHost() {
        return this.host;
    }

    /**
     * Missing description at method setHost.
     *
     * @param host the Name.
     */
    public void setHost(Name host) {
        this.host = host;
    }

    /**
     * Missing description at method setHost.
     *
     * @param host the String.
     */
    public void setHost(String host) {
        if ((this.host == null)) {
            if ((host == null)) {
                return;
            }
            this.host = new Name();
        }
        this.host.setValue(host);
    }

    /**
     * Missing description at method getPort.
     *
     * @return the Name.
     */
    public Name getPort() {
        return this.port;
    }

    /**
     * Missing description at method setPort.
     *
     * @param port the Name.
     */
    public void setPort(Name port) {
        this.port = port;
    }

    /**
     * Missing description at method setPort.
     *
     * @param port the String.
     */
    public void setPort(String port) {
        if ((this.port == null)) {
            if ((port == null)) {
                return;
            }
            this.port = new Name();
        }
        this.port.setValue(port);
    }

    /**
     * Missing description at method getRemoteReferenceName.
     *
     * @return the Name.
     */
    public Name getRemoteReferenceName() {
        return this.remoteReferenceName;
    }

    /**
     * Missing description at method setRemoteReferenceName.
     *
     * @param remoteReferenceName the Name.
     */
    public void setRemoteReferenceName(Name remoteReferenceName) {
        this.remoteReferenceName = remoteReferenceName;
    }

    /**
     * Missing description at method setRemoteReferenceName.
     *
     * @param remoteReferenceName the String.
     */
    public void setRemoteReferenceName(String remoteReferenceName) {
        if ((this.remoteReferenceName == null)) {
            if ((remoteReferenceName == null)) {
                return;
            }
            this.remoteReferenceName = new Name();
        }
        this.remoteReferenceName.setValue(remoteReferenceName);
    }

    /**
     * Missing description at method getProxyConfigurations.
     *
     * @return the NabuccoList<ProxyConfiguration>.
     */
    public NabuccoList<ProxyConfiguration> getProxyConfigurations() {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoListImpl<ProxyConfiguration>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.proxyConfigurations;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestEngineConfiguration.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestEngineConfiguration.class)
                .getAllProperties();
    }
}
