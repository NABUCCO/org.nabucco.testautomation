/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;

/**
 * ConfigurationPropertyListMsg<p/>Message containing a list of ConfigurationProperties<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-12-27
 */
public class ConfigurationPropertyListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "configurationPropertyList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<ConfigurationProperty> configurationPropertyList;

    /** Constructs a new ConfigurationPropertyListMsg instance. */
    public ConfigurationPropertyListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<ConfigurationProperty>(PROPERTY_NAMES[0],
                ConfigurationProperty.class, PROPERTY_CONSTRAINTS[0],
                this.configurationPropertyList));
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
        final ConfigurationPropertyListMsg other = ((ConfigurationPropertyListMsg) obj);
        if ((this.configurationPropertyList == null)) {
            if ((other.configurationPropertyList != null))
                return false;
        } else if ((!this.configurationPropertyList.equals(other.configurationPropertyList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.configurationPropertyList == null) ? 0
                : this.configurationPropertyList.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ConfigurationPropertyListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<configurationPropertyList>" + this.configurationPropertyList) + "</configurationPropertyList>\n"));
        appendable.append("</ConfigurationPropertyListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getConfigurationPropertyList.
     *
     * @return the List<ConfigurationProperty>.
     */
    public List<ConfigurationProperty> getConfigurationPropertyList() {
        if ((this.configurationPropertyList == null)) {
            this.configurationPropertyList = new ArrayList<ConfigurationProperty>();
        }
        return this.configurationPropertyList;
    }
}
