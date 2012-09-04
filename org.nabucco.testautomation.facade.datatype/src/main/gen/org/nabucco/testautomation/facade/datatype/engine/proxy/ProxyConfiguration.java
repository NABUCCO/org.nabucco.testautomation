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
package org.nabucco.testautomation.facade.datatype.engine.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.engine.SubEngineType;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;

/**
 * ProxyConfiguration<p/>Wrapper containing the configuration for a TestEngine-Proxy<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-09-10
 */
public class ProxyConfiguration extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m1,1;", "m1,1;", "m0,1;",
            "m0,1;", "l0,n;m1,1;", "m0,n;" };

    public static final String NAME = "name";

    public static final String SUBENGINETYPE = "subEngineType";

    public static final String ENVIRONMENTTYPE = "environmentType";

    public static final String RELEASETYPE = "releaseType";

    public static final String ENABLED = "enabled";

    public static final String CONFIGURATIONPROPERTIES = "configurationProperties";

    private Name name;

    private SubEngineType subEngineType;

    /** Environment of the TestConfiguration */
    private Code environmentType;

    private Long environmentTypeRefId;

    private static final String ENVIRONMENTTYPE_CODEPATH = "nabucco.testautomation.environment";

    /** Release of the TestConfiguration */
    private Code releaseType;

    private Long releaseTypeRefId;

    private static final String RELEASETYPE_CODEPATH = "nabucco.testautomation.release";

    private Flag enabled;

    private NabuccoList<ConfigurationProperty> configurationProperties;

    /** Constructs a new ProxyConfiguration instance. */
    public ProxyConfiguration() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProxyConfiguration.
     */
    protected void cloneObject(ProxyConfiguration clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        clone.setSubEngineType(this.getSubEngineType());
        if ((this.getEnvironmentType() != null)) {
            clone.setEnvironmentType(this.getEnvironmentType().cloneObject());
        }
        if ((this.getEnvironmentTypeRefId() != null)) {
            clone.setEnvironmentTypeRefId(this.getEnvironmentTypeRefId());
        }
        if ((this.getReleaseType() != null)) {
            clone.setReleaseType(this.getReleaseType().cloneObject());
        }
        if ((this.getReleaseTypeRefId() != null)) {
            clone.setReleaseTypeRefId(this.getReleaseTypeRefId());
        }
        if ((this.getEnabled() != null)) {
            clone.setEnabled(this.getEnabled().cloneObject());
        }
        if ((this.configurationProperties != null)) {
            clone.configurationProperties = this.configurationProperties.cloneCollection();
        }
    }

    /**
     * Getter for the ConfigurationPropertiesJPA.
     *
     * @return the List<ConfigurationProperty>.
     */
    List<ConfigurationProperty> getConfigurationPropertiesJPA() {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoListImpl<ConfigurationProperty>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ConfigurationProperty>) this.configurationProperties)
                .getDelegate();
    }

    /**
     * Setter for the ConfigurationPropertiesJPA.
     *
     * @param configurationProperties the List<ConfigurationProperty>.
     */
    void setConfigurationPropertiesJPA(List<ConfigurationProperty> configurationProperties) {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoListImpl<ConfigurationProperty>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ConfigurationProperty>) this.configurationProperties)
                .setDelegate(configurationProperties);
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
        propertyMap.put(SUBENGINETYPE, PropertyDescriptorSupport.createEnumeration(SUBENGINETYPE,
                SubEngineType.class, 3, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ENVIRONMENTTYPE, PropertyDescriptorSupport.createDatatype(ENVIRONMENTTYPE,
                Code.class, 4, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(RELEASETYPE, PropertyDescriptorSupport.createDatatype(RELEASETYPE,
                Code.class, 5, PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(ENABLED, PropertyDescriptorSupport.createBasetype(ENABLED, Flag.class, 6,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(CONFIGURATIONPROPERTIES, PropertyDescriptorSupport.createCollection(
                CONFIGURATIONPROPERTIES, ConfigurationProperty.class, 7, PROPERTY_CONSTRAINTS[5],
                false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProxyConfiguration.getPropertyDescriptor(NAME),
                this.name, null));
        properties.add(super.createProperty(
                ProxyConfiguration.getPropertyDescriptor(SUBENGINETYPE), this.subEngineType, null));
        properties.add(super.createProperty(
                ProxyConfiguration.getPropertyDescriptor(ENVIRONMENTTYPE), this.environmentType,
                this.environmentTypeRefId));
        properties.add(super.createProperty(ProxyConfiguration.getPropertyDescriptor(RELEASETYPE),
                this.releaseType, this.releaseTypeRefId));
        properties.add(super.createProperty(ProxyConfiguration.getPropertyDescriptor(ENABLED),
                this.enabled, null));
        properties.add(super.createProperty(
                ProxyConfiguration.getPropertyDescriptor(CONFIGURATIONPROPERTIES),
                this.configurationProperties, null));
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
        } else if ((property.getName().equals(SUBENGINETYPE) && (property.getType() == SubEngineType.class))) {
            this.setSubEngineType(((SubEngineType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENVIRONMENTTYPE) && (property.getType() == Code.class))) {
            this.setEnvironmentType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELEASETYPE) && (property.getType() == Code.class))) {
            this.setReleaseType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENABLED) && (property.getType() == Flag.class))) {
            this.setEnabled(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONFIGURATIONPROPERTIES) && (property.getType() == ConfigurationProperty.class))) {
            this.configurationProperties = ((NabuccoList<ConfigurationProperty>) property
                    .getInstance());
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
        final ProxyConfiguration other = ((ProxyConfiguration) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.subEngineType == null)) {
            if ((other.subEngineType != null))
                return false;
        } else if ((!this.subEngineType.equals(other.subEngineType)))
            return false;
        if ((this.environmentType == null)) {
            if ((other.environmentType != null))
                return false;
        } else if ((!this.environmentType.equals(other.environmentType)))
            return false;
        if ((this.environmentTypeRefId == null)) {
            if ((other.environmentTypeRefId != null))
                return false;
        } else if ((!this.environmentTypeRefId.equals(other.environmentTypeRefId)))
            return false;
        if ((this.releaseType == null)) {
            if ((other.releaseType != null))
                return false;
        } else if ((!this.releaseType.equals(other.releaseType)))
            return false;
        if ((this.releaseTypeRefId == null)) {
            if ((other.releaseTypeRefId != null))
                return false;
        } else if ((!this.releaseTypeRefId.equals(other.releaseTypeRefId)))
            return false;
        if ((this.enabled == null)) {
            if ((other.enabled != null))
                return false;
        } else if ((!this.enabled.equals(other.enabled)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.subEngineType == null) ? 0 : this.subEngineType
                .hashCode()));
        result = ((PRIME * result) + ((this.environmentType == null) ? 0 : this.environmentType
                .hashCode()));
        result = ((PRIME * result) + ((this.environmentTypeRefId == null) ? 0
                : this.environmentTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.releaseType == null) ? 0 : this.releaseType.hashCode()));
        result = ((PRIME * result) + ((this.releaseTypeRefId == null) ? 0 : this.releaseTypeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.enabled == null) ? 0 : this.enabled.hashCode()));
        return result;
    }

    @Override
    public ProxyConfiguration cloneObject() {
        ProxyConfiguration clone = new ProxyConfiguration();
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
     * Missing description at method getSubEngineType.
     *
     * @return the SubEngineType.
     */
    public SubEngineType getSubEngineType() {
        return this.subEngineType;
    }

    /**
     * Missing description at method setSubEngineType.
     *
     * @param subEngineType the SubEngineType.
     */
    public void setSubEngineType(SubEngineType subEngineType) {
        this.subEngineType = subEngineType;
    }

    /**
     * Missing description at method setSubEngineType.
     *
     * @param subEngineType the String.
     */
    public void setSubEngineType(String subEngineType) {
        if ((subEngineType == null)) {
            this.subEngineType = null;
        } else {
            this.subEngineType = SubEngineType.valueOf(subEngineType);
        }
    }

    /**
     * Environment of the TestConfiguration
     *
     * @param environmentType the Code.
     */
    public void setEnvironmentType(Code environmentType) {
        this.environmentType = environmentType;
        if ((environmentType != null)) {
            this.setEnvironmentTypeRefId(environmentType.getId());
        } else {
            this.setEnvironmentTypeRefId(null);
        }
    }

    /**
     * Environment of the TestConfiguration
     *
     * @return the Code.
     */
    public Code getEnvironmentType() {
        return this.environmentType;
    }

    /**
     * Getter for the EnvironmentTypeRefId.
     *
     * @return the Long.
     */
    public Long getEnvironmentTypeRefId() {
        return this.environmentTypeRefId;
    }

    /**
     * Setter for the EnvironmentTypeRefId.
     *
     * @param environmentTypeRefId the Long.
     */
    public void setEnvironmentTypeRefId(Long environmentTypeRefId) {
        this.environmentTypeRefId = environmentTypeRefId;
    }

    /**
     * Release of the TestConfiguration
     *
     * @param releaseType the Code.
     */
    public void setReleaseType(Code releaseType) {
        this.releaseType = releaseType;
        if ((releaseType != null)) {
            this.setReleaseTypeRefId(releaseType.getId());
        } else {
            this.setReleaseTypeRefId(null);
        }
    }

    /**
     * Release of the TestConfiguration
     *
     * @return the Code.
     */
    public Code getReleaseType() {
        return this.releaseType;
    }

    /**
     * Getter for the ReleaseTypeRefId.
     *
     * @return the Long.
     */
    public Long getReleaseTypeRefId() {
        return this.releaseTypeRefId;
    }

    /**
     * Setter for the ReleaseTypeRefId.
     *
     * @param releaseTypeRefId the Long.
     */
    public void setReleaseTypeRefId(Long releaseTypeRefId) {
        this.releaseTypeRefId = releaseTypeRefId;
    }

    /**
     * Missing description at method getEnabled.
     *
     * @return the Flag.
     */
    public Flag getEnabled() {
        return this.enabled;
    }

    /**
     * Missing description at method setEnabled.
     *
     * @param enabled the Flag.
     */
    public void setEnabled(Flag enabled) {
        this.enabled = enabled;
    }

    /**
     * Missing description at method setEnabled.
     *
     * @param enabled the Boolean.
     */
    public void setEnabled(Boolean enabled) {
        if ((this.enabled == null)) {
            if ((enabled == null)) {
                return;
            }
            this.enabled = new Flag();
        }
        this.enabled.setValue(enabled);
    }

    /**
     * Missing description at method getConfigurationProperties.
     *
     * @return the NabuccoList<ConfigurationProperty>.
     */
    public NabuccoList<ConfigurationProperty> getConfigurationProperties() {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoListImpl<ConfigurationProperty>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.configurationProperties;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProxyConfiguration.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProxyConfiguration.class).getAllProperties();
    }

    /**
     * Getter for the EnvironmentTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getEnvironmentTypeCodePath() {
        return new CodePath(ENVIRONMENTTYPE_CODEPATH);
    }

    /**
     * Getter for the ReleaseTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getReleaseTypeCodePath() {
        return new CodePath(RELEASETYPE_CODEPATH);
    }
}
