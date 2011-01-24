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
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationListMsg<p/>Message containing a list of TestEngineConfigurations<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestEngineConfigurationListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "configurationList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<TestEngineConfiguration> configurationList;

    /** Constructs a new TestEngineConfigurationListMsg instance. */
    public TestEngineConfigurationListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<TestEngineConfiguration>(PROPERTY_NAMES[0],
                TestEngineConfiguration.class, PROPERTY_CONSTRAINTS[0], this.configurationList));
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
        final TestEngineConfigurationListMsg other = ((TestEngineConfigurationListMsg) obj);
        if ((this.configurationList == null)) {
            if ((other.configurationList != null))
                return false;
        } else if ((!this.configurationList.equals(other.configurationList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.configurationList == null) ? 0 : this.configurationList
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestEngineConfigurationListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<configurationList>" + this.configurationList) + "</configurationList>\n"));
        appendable.append("</TestEngineConfigurationListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getConfigurationList.
     *
     * @return the List<TestEngineConfiguration>.
     */
    public List<TestEngineConfiguration> getConfigurationList() {
        if ((this.configurationList == null)) {
            this.configurationList = new ArrayList<TestEngineConfiguration>();
        }
        return this.configurationList;
    }
}
