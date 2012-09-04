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
package org.nabucco.testautomation.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m0,1;", "l0,255;m0,1;",
            "l0,255;m0,1;", "l0,255;m0,1;", "l0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String NAME = "name";

    public static final String HOST = "host";

    public static final String PORT = "port";

    public static final String REMOTEREFNAME = "remoteRefName";

    public static final String ID = "id";

    public static final String USER = "user";

    public static final String ENVIRONMENTTYPE = "environmentType";

    public static final String RELEASETYPE = "releaseType";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 0,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(HOST, PropertyDescriptorSupport.createBasetype(HOST, Name.class, 1,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(PORT, PropertyDescriptorSupport.createBasetype(PORT, Name.class, 2,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(REMOTEREFNAME, PropertyDescriptorSupport.createBasetype(REMOTEREFNAME,
                Name.class, 3, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(ID, PropertyDescriptorSupport.createBasetype(ID, Identifier.class, 4,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(USER, PropertyDescriptorSupport.createDatatype(USER, User.class, 5,
                PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(ENVIRONMENTTYPE, PropertyDescriptorSupport.createDatatype(ENVIRONMENTTYPE,
                Code.class, 6, PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(RELEASETYPE, PropertyDescriptorSupport.createDatatype(RELEASETYPE,
                Code.class, 7, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(NAME), this.name));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(HOST), this.host));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(PORT), this.port));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(REMOTEREFNAME),
                this.remoteRefName));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(ID), this.id));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(USER), this.user));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(ENVIRONMENTTYPE),
                this.environmentType));
        properties.add(super.createProperty(
                TestEngineConfigurationSearchMsg.getPropertyDescriptor(RELEASETYPE),
                this.releaseType));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HOST) && (property.getType() == Name.class))) {
            this.setHost(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PORT) && (property.getType() == Name.class))) {
            this.setPort(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REMOTEREFNAME) && (property.getType() == Name.class))) {
            this.setRemoteRefName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ID) && (property.getType() == Identifier.class))) {
            this.setId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USER) && (property.getType() == User.class))) {
            this.setUser(((User) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENVIRONMENTTYPE) && (property.getType() == Code.class))) {
            this.setEnvironmentType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELEASETYPE) && (property.getType() == Code.class))) {
            this.setReleaseType(((Code) property.getInstance()));
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestEngineConfigurationSearchMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestEngineConfigurationSearchMsg.class)
                .getAllProperties();
    }
}
