/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.engine;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "name", "description", "user", "host", "port",
            "remoteReferenceName", "proxyConfigurations" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m0,1;", "m0,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "m0,n;" };

    private Name name;

    private Description description;

    private User user;

    private Long userRefId;

    private Name host;

    private Name port;

    private Name remoteReferenceName;

    private List<ProxyConfiguration> proxyConfigurations;

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
        if ((this.proxyConfigurations instanceof NabuccoList<?>)) {
            clone.proxyConfigurations = ((NabuccoList<ProxyConfiguration>) this.proxyConfigurations)
                    .cloneCollection();
        }
    }

    /**
     * Getter for the ProxyConfigurationsJPA.
     *
     * @return the List<ProxyConfiguration>.
     */
    List<ProxyConfiguration> getProxyConfigurationsJPA() {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoList<ProxyConfiguration>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<ProxyConfiguration>) this.proxyConfigurations).getDelegate();
    }

    /**
     * Setter for the ProxyConfigurationsJPA.
     *
     * @param proxyConfigurations the List<ProxyConfiguration>.
     */
    void setProxyConfigurationsJPA(List<ProxyConfiguration> proxyConfigurations) {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoList<ProxyConfiguration>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<ProxyConfiguration>) this.proxyConfigurations)
                .setDelegate(proxyConfigurations);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[0], Name.class,
                PROPERTY_CONSTRAINTS[0], this.name));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[1], Description.class,
                PROPERTY_CONSTRAINTS[1], this.description));
        properties.add(new DatatypeProperty<User>(PROPERTY_NAMES[2], User.class,
                PROPERTY_CONSTRAINTS[2], this.user));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[3], Name.class,
                PROPERTY_CONSTRAINTS[3], this.host));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[4], Name.class,
                PROPERTY_CONSTRAINTS[4], this.port));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[5], Name.class,
                PROPERTY_CONSTRAINTS[5], this.remoteReferenceName));
        properties.add(new ListProperty<ProxyConfiguration>(PROPERTY_NAMES[6],
                ProxyConfiguration.class, PROPERTY_CONSTRAINTS[6], this.proxyConfigurations));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestEngineConfiguration>\n");
        appendable.append(super.toString());
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<description>" + this.description) + "</description>\n"));
        appendable.append((("<user>" + this.user) + "</user>\n"));
        appendable.append((("<userRefId>" + this.userRefId) + "</userRefId>\n"));
        appendable.append((("<host>" + this.host) + "</host>\n"));
        appendable.append((("<port>" + this.port) + "</port>\n"));
        appendable
                .append((("<remoteReferenceName>" + this.remoteReferenceName) + "</remoteReferenceName>\n"));
        appendable.append("</TestEngineConfiguration>\n");
        return appendable.toString();
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
            this.remoteReferenceName = new Name();
        }
        this.remoteReferenceName.setValue(remoteReferenceName);
    }

    /**
     * Missing description at method getProxyConfigurations.
     *
     * @return the List<ProxyConfiguration>.
     */
    public List<ProxyConfiguration> getProxyConfigurations() {
        if ((this.proxyConfigurations == null)) {
            this.proxyConfigurations = new NabuccoList<ProxyConfiguration>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.proxyConfigurations;
    }
}
