/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.file.TextFileContent;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "content" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,1000000;m1,1;" };

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
        if ((this.getContent() != null)) {
            clone.setContent(this.getContent().cloneObject());
        }
        clone.setType(this.getType());
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<TextFileContent>(PROPERTY_NAMES[0],
                TextFileContent.class, PROPERTY_CONSTRAINTS[0], this.content));
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
        final FileProperty other = ((FileProperty) obj);
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
        result = ((PRIME * result) + ((this.content == null) ? 0 : this.content.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<FileProperty>\n");
        appendable.append(super.toString());
        appendable.append((("<content>" + this.content) + "</content>\n"));
        appendable.append("</FileProperty>\n");
        return appendable.toString();
    }

    @Override
    public FileProperty cloneObject() {
        FileProperty clone = new FileProperty();
        this.cloneObject(clone);
        return clone;
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
            this.content = new TextFileContent();
        }
        this.content.setValue(content);
    }
}
