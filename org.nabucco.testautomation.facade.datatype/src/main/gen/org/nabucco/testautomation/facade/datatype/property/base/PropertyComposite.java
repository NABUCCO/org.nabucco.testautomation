/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;

/**
 * PropertyComposite<p/>Abstract superclass for all PropertyComposite types<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-01
 */
public abstract class PropertyComposite extends Property implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "propertyList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<PropertyContainer> propertyList;

    /** Constructs a new PropertyComposite instance. */
    public PropertyComposite() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PropertyComposite.
     */
    protected void cloneObject(PropertyComposite clone) {
        super.cloneObject(clone);
        if ((this.propertyList instanceof NabuccoList<?>)) {
            clone.propertyList = ((NabuccoList<PropertyContainer>) this.propertyList)
                    .cloneCollection();
        }
    }

    /**
     * Getter for the PropertyListJPA.
     *
     * @return the List<PropertyContainer>.
     */
    List<PropertyContainer> getPropertyListJPA() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoList<PropertyContainer>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<PropertyContainer>) this.propertyList).getDelegate();
    }

    /**
     * Setter for the PropertyListJPA.
     *
     * @param propertyList the List<PropertyContainer>.
     */
    void setPropertyListJPA(List<PropertyContainer> propertyList) {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoList<PropertyContainer>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<PropertyContainer>) this.propertyList).setDelegate(propertyList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<PropertyContainer>(PROPERTY_NAMES[0],
                PropertyContainer.class, PROPERTY_CONSTRAINTS[0], this.propertyList));
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append(super.toString());
        return appendable.toString();
    }

    @Override
    public abstract PropertyComposite cloneObject();

    /**
     * Missing description at method getPropertyList.
     *
     * @return the List<PropertyContainer>.
     */
    public List<PropertyContainer> getPropertyList() {
        if ((this.propertyList == null)) {
            this.propertyList = new NabuccoList<PropertyContainer>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.propertyList;
    }
}
