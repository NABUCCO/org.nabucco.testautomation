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
package org.nabucco.testautomation.facade.datatype.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.file.TextFileContent;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComponent;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyType;

/**
 * FileProperty<p/>Property containing the content of a File<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public class FileProperty extends PropertyComponent implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m0,1;", "l0,1000000;m0,1;" };

    public static final String FILENAME = "filename";

    public static final String CONTENT = "content";

    private Name filename;

    private TextFileContent content;

    /** Constructs a new FileProperty instance. */
    public FileProperty() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = PropertyType.FILE;
    }

    /**
     * CloneObject.
     *
     * @param clone the FileProperty.
     */
    protected void cloneObject(FileProperty clone) {
        super.cloneObject(clone);
        if ((this.getFilename() != null)) {
            clone.setFilename(this.getFilename().cloneObject());
        }
        if ((this.getContent() != null)) {
            clone.setContent(this.getContent().cloneObject());
        }
        clone.setType(this.getType());
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(PropertyComponent.class)
                .getPropertyMap());
        propertyMap.put(FILENAME, PropertyDescriptorSupport.createBasetype(FILENAME, Name.class, 8,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(CONTENT, PropertyDescriptorSupport.createBasetype(CONTENT,
                TextFileContent.class, 9, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(FileProperty.getPropertyDescriptor(FILENAME),
                this.filename, null));
        properties.add(super.createProperty(FileProperty.getPropertyDescriptor(CONTENT),
                this.content, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(FILENAME) && (property.getType() == Name.class))) {
            this.setFilename(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONTENT) && (property.getType() == TextFileContent.class))) {
            this.setContent(((TextFileContent) property.getInstance()));
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
        final FileProperty other = ((FileProperty) obj);
        if ((this.filename == null)) {
            if ((other.filename != null))
                return false;
        } else if ((!this.filename.equals(other.filename)))
            return false;
        if ((this.content == null)) {
            if ((other.content != null))
                return false;
        } else if ((!this.content.equals(other.content)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.filename == null) ? 0 : this.filename.hashCode()));
        result = ((PRIME * result) + ((this.content == null) ? 0 : this.content.hashCode()));
        return result;
    }

    @Override
    public FileProperty cloneObject() {
        FileProperty clone = new FileProperty();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getFilename.
     *
     * @return the Name.
     */
    public Name getFilename() {
        return this.filename;
    }

    /**
     * Missing description at method setFilename.
     *
     * @param filename the Name.
     */
    public void setFilename(Name filename) {
        this.filename = filename;
    }

    /**
     * Missing description at method setFilename.
     *
     * @param filename the String.
     */
    public void setFilename(String filename) {
        if ((this.filename == null)) {
            if ((filename == null)) {
                return;
            }
            this.filename = new Name();
        }
        this.filename.setValue(filename);
    }

    /**
     * Missing description at method getContent.
     *
     * @return the TextFileContent.
     */
    public TextFileContent getContent() {
        return this.content;
    }

    /**
     * Missing description at method setContent.
     *
     * @param content the TextFileContent.
     */
    public void setContent(TextFileContent content) {
        this.content = content;
    }

    /**
     * Missing description at method setContent.
     *
     * @param content the String.
     */
    public void setContent(String content) {
        if ((this.content == null)) {
            if ((content == null)) {
                return;
            }
            this.content = new TextFileContent();
        }
        this.content.setValue(content);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(FileProperty.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(FileProperty.class).getAllProperties();
    }
}
