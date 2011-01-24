/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * TestEngineConfigurationSearchMsg<p/>Message for searching Properties<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-19
 */
public class TestEngineConfigurationSearchMsg extends ServiceMessageSupport implements
        ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "name", "host", "port", "remoteRefName", "id",
            "user", "environmentType", "releaseType" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;", "l0,n;m0,1;",
            "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    private Name name;

    private Name host;

    private Name port;

    private Name remoteRefName;

    private Identifier id;

    private User user;

    private Code environmentType;

    private Code releaseType;

    /** Constructs a new TestEngineConfigurationSearchMsg instance. */
    public TestEngineConfigurationSearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[0], Name.class,
                PROPERTY_CONSTRAINTS[0], this.name));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.host));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[2], Name.class,
                PROPERTY_CONSTRAINTS[2], this.port));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[3], Name.class,
                PROPERTY_CONSTRAINTS[3], this.remoteRefName));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[4], Identifier.class,
                PROPERTY_CONSTRAINTS[4], this.id));
        properties.add(new DatatypeProperty<User>(PROPERTY_NAMES[5], User.class,
                PROPERTY_CONSTRAINTS[5], this.user));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[6], Code.class,
                PROPERTY_CONSTRAINTS[6], this.environmentType));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[7], Code.class,
                PROPERTY_CONSTRAINTS[7], this.releaseType));
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
        final TestEngineConfigurationSearchMsg other = ((TestEngineConfigurationSearchMsg) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
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
        if ((this.remoteRefName == null)) {
            if ((other.remoteRefName != null))
                return false;
        } else if ((!this.remoteRefName.equals(other.remoteRefName)))
            return false;
        if ((this.id == null)) {
            if ((other.id != null))
                return false;
        } else if ((!this.id.equals(other.id)))
            return false;
        if ((this.user == null)) {
            if ((other.user != null))
                return false;
        } else if ((!this.user.equals(other.user)))
            return false;
        if ((this.environmentType == null)) {
            if ((other.environmentType != null))
                return false;
        } else if ((!this.environmentType.equals(other.environmentType)))
            return false;
        if ((this.releaseType == null)) {
            if ((other.releaseType != null))
                return false;
        } else if ((!this.releaseType.equals(other.releaseType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.host == null) ? 0 : this.host.hashCode()));
        result = ((PRIME * result) + ((this.port == null) ? 0 : this.port.hashCode()));
        result = ((PRIME * result) + ((this.remoteRefName == null) ? 0 : this.remoteRefName
                .hashCode()));
        result = ((PRIME * result) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((PRIME * result) + ((this.user == null) ? 0 : this.user.hashCode()));
        result = ((PRIME * result) + ((this.environmentType == null) ? 0 : this.environmentType
                .hashCode()));
        result = ((PRIME * result) + ((this.releaseType == null) ? 0 : this.releaseType.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestEngineConfigurationSearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<host>" + this.host) + "</host>\n"));
        appendable.append((("<port>" + this.port) + "</port>\n"));
        appendable.append((("<remoteRefName>" + this.remoteRefName) + "</remoteRefName>\n"));
        appendable.append((("<id>" + this.id) + "</id>\n"));
        appendable.append((("<user>" + this.user) + "</user>\n"));
        appendable.append((("<environmentType>" + this.environmentType) + "</environmentType>\n"));
        appendable.append((("<releaseType>" + this.releaseType) + "</releaseType>\n"));
        appendable.append("</TestEngineConfigurationSearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
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
     * Missing description at method getRemoteRefName.
     *
     * @return the Name.
     */
    public Name getRemoteRefName() {
        return this.remoteRefName;
    }

    /**
     * Missing description at method setRemoteRefName.
     *
     * @param remoteRefName the Name.
     */
    public void setRemoteRefName(Name remoteRefName) {
        this.remoteRefName = remoteRefName;
    }

    /**
     * Missing description at method getId.
     *
     * @return the Identifier.
     */
    public Identifier getId() {
        return this.id;
    }

    /**
     * Missing description at method setId.
     *
     * @param id the Identifier.
     */
    public void setId(Identifier id) {
        this.id = id;
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
     * Missing description at method setUser.
     *
     * @param user the User.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Missing description at method getEnvironmentType.
     *
     * @return the Code.
     */
    public Code getEnvironmentType() {
        return this.environmentType;
    }

    /**
     * Missing description at method setEnvironmentType.
     *
     * @param environmentType the Code.
     */
    public void setEnvironmentType(Code environmentType) {
        this.environmentType = environmentType;
    }

    /**
     * Missing description at method getReleaseType.
     *
     * @return the Code.
     */
    public Code getReleaseType() {
        return this.releaseType;
    }

    /**
     * Missing description at method setReleaseType.
     *
     * @param releaseType the Code.
     */
    public void setReleaseType(Code releaseType) {
        this.releaseType = releaseType;
    }
}
