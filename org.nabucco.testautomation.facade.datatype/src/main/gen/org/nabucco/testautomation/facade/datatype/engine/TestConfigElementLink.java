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
import org.nabucco.framework.base.facade.datatype.DatatypeSupport;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * TestConfigElementLink<p/>A Link containing information about a TestConfigElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-15
 */
public class TestConfigElementLink extends DatatypeSupport implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;", "l0,n;m0,1;",
            "l0,255;m0,1;" };

    public static final String ELEMENTID = "elementId";

    public static final String ELEMENTKEY = "elementKey";

    public static final String ELEMENTNAME = "elementName";

    private Identifier elementId;

    private Key elementKey;

    private Name elementName;

    /** Constructs a new TestConfigElementLink instance. */
    public TestConfigElementLink() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestConfigElementLink.
     */
    protected void cloneObject(TestConfigElementLink clone) {
        super.cloneObject(clone);
        if ((this.getElementId() != null)) {
            clone.setElementId(this.getElementId().cloneObject());
        }
        if ((this.getElementKey() != null)) {
            clone.setElementKey(this.getElementKey().cloneObject());
        }
        if ((this.getElementName() != null)) {
            clone.setElementName(this.getElementName().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(ELEMENTID, PropertyDescriptorSupport.createBasetype(ELEMENTID,
                Identifier.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ELEMENTKEY, PropertyDescriptorSupport.createBasetype(ELEMENTKEY, Key.class,
                1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ELEMENTNAME, PropertyDescriptorSupport.createBasetype(ELEMENTNAME,
                Name.class, 2, PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestConfigElementLink.getPropertyDescriptor(ELEMENTID),
                this.elementId, null));
        properties.add(super.createProperty(
                TestConfigElementLink.getPropertyDescriptor(ELEMENTKEY), this.elementKey, null));
        properties.add(super.createProperty(
                TestConfigElementLink.getPropertyDescriptor(ELEMENTNAME), this.elementName, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ELEMENTID) && (property.getType() == Identifier.class))) {
            this.setElementId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ELEMENTKEY) && (property.getType() == Key.class))) {
            this.setElementKey(((Key) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ELEMENTNAME) && (property.getType() == Name.class))) {
            this.setElementName(((Name) property.getInstance()));
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
        final TestConfigElementLink other = ((TestConfigElementLink) obj);
        if ((this.elementId == null)) {
            if ((other.elementId != null))
                return false;
        } else if ((!this.elementId.equals(other.elementId)))
            return false;
        if ((this.elementKey == null)) {
            if ((other.elementKey != null))
                return false;
        } else if ((!this.elementKey.equals(other.elementKey)))
            return false;
        if ((this.elementName == null)) {
            if ((other.elementName != null))
                return false;
        } else if ((!this.elementName.equals(other.elementName)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.elementId == null) ? 0 : this.elementId.hashCode()));
        result = ((PRIME * result) + ((this.elementKey == null) ? 0 : this.elementKey.hashCode()));
        result = ((PRIME * result) + ((this.elementName == null) ? 0 : this.elementName.hashCode()));
        return result;
    }

    @Override
    public TestConfigElementLink cloneObject() {
        TestConfigElementLink clone = new TestConfigElementLink();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getElementId.
     *
     * @return the Identifier.
     */
    public Identifier getElementId() {
        return this.elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Identifier.
     */
    public void setElementId(Identifier elementId) {
        this.elementId = elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Long.
     */
    public void setElementId(Long elementId) {
        if ((this.elementId == null)) {
            if ((elementId == null)) {
                return;
            }
            this.elementId = new Identifier();
        }
        this.elementId.setValue(elementId);
    }

    /**
     * Missing description at method getElementKey.
     *
     * @return the Key.
     */
    public Key getElementKey() {
        return this.elementKey;
    }

    /**
     * Missing description at method setElementKey.
     *
     * @param elementKey the Key.
     */
    public void setElementKey(Key elementKey) {
        this.elementKey = elementKey;
    }

    /**
     * Missing description at method setElementKey.
     *
     * @param elementKey the String.
     */
    public void setElementKey(String elementKey) {
        if ((this.elementKey == null)) {
            if ((elementKey == null)) {
                return;
            }
            this.elementKey = new Key();
        }
        this.elementKey.setValue(elementKey);
    }

    /**
     * Missing description at method getElementName.
     *
     * @return the Name.
     */
    public Name getElementName() {
        return this.elementName;
    }

    /**
     * Missing description at method setElementName.
     *
     * @param elementName the Name.
     */
    public void setElementName(Name elementName) {
        this.elementName = elementName;
    }

    /**
     * Missing description at method setElementName.
     *
     * @param elementName the String.
     */
    public void setElementName(String elementName) {
        if ((this.elementName == null)) {
            if ((elementName == null)) {
                return;
            }
            this.elementName = new Name();
        }
        this.elementName.setValue(elementName);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestConfigElementLink.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestConfigElementLink.class).getAllProperties();
    }
}
