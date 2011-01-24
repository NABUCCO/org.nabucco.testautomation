/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.engine.proxy;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "name", "subEngineType", "environmentType",
            "releaseType", "configurationProperties" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "m1,1;", "m0,1;", "m0,1;",
            "m0,n;" };

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

    private List<ConfigurationProperty> configurationProperties;

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
        if ((this.configurationProperties instanceof NabuccoList<?>)) {
            clone.configurationProperties = ((NabuccoList<ConfigurationProperty>) this.configurationProperties)
                    .cloneCollection();
        }
    }

    /**
     * Getter for the ConfigurationPropertiesJPA.
     *
     * @return the List<ConfigurationProperty>.
     */
    List<ConfigurationProperty> getConfigurationPropertiesJPA() {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoList<ConfigurationProperty>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<ConfigurationProperty>) this.configurationProperties).getDelegate();
    }

    /**
     * Setter for the ConfigurationPropertiesJPA.
     *
     * @param configurationProperties the List<ConfigurationProperty>.
     */
    void setConfigurationPropertiesJPA(List<ConfigurationProperty> configurationProperties) {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoList<ConfigurationProperty>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<ConfigurationProperty>) this.configurationProperties)
                .setDelegate(configurationProperties);
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
        properties.add(new EnumProperty<SubEngineType>(PROPERTY_NAMES[1], SubEngineType.class,
                PROPERTY_CONSTRAINTS[1], this.subEngineType));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[2], Code.class,
                PROPERTY_CONSTRAINTS[2], this.environmentType));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[3], Code.class,
                PROPERTY_CONSTRAINTS[3], this.releaseType));
        properties
                .add(new ListProperty<ConfigurationProperty>(PROPERTY_NAMES[4],
                        ConfigurationProperty.class, PROPERTY_CONSTRAINTS[4],
                        this.configurationProperties));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProxyConfiguration>\n");
        appendable.append(super.toString());
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<subEngineType>" + this.subEngineType) + "</subEngineType>\n"));
        appendable.append((("<environmentType>" + this.environmentType) + "</environmentType>\n"));
        appendable
                .append((("<environmentTypeRefId>" + this.environmentTypeRefId) + "</environmentTypeRefId>\n"));
        appendable.append((("<releaseType>" + this.releaseType) + "</releaseType>\n"));
        appendable
                .append((("<releaseTypeRefId>" + this.releaseTypeRefId) + "</releaseTypeRefId>\n"));
        appendable.append("</ProxyConfiguration>\n");
        return appendable.toString();
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
     * Missing description at method getConfigurationProperties.
     *
     * @return the List<ConfigurationProperty>.
     */
    public List<ConfigurationProperty> getConfigurationProperties() {
        if ((this.configurationProperties == null)) {
            this.configurationProperties = new NabuccoList<ConfigurationProperty>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.configurationProperties;
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
