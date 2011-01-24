/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.property.base;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Basetype;
import org.nabucco.framework.base.facade.datatype.NString;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.SimpleProperty;

/**
 * PropertyReference<p/>Datatype to reference a Property in the TestContext<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-07
 */
public class PropertyReference extends NString implements Basetype {

    private static final long serialVersionUID = 1L;

    private static final String PROPERTY_NAME = "value";

    private static final String PROPERTY_CONSTRAINTS = "l0,n;";

    /** Constructs a new PropertyReference instance. */
    public PropertyReference() {
        super();
    }

    /**
     * Constructs a new PropertyReference instance.
     *
     * @param value the String.
     */
    public PropertyReference(String value) {
        super(value);
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new SimpleProperty<String>(PROPERTY_NAME, String.class,
                PROPERTY_CONSTRAINTS, super.getValue()));
        return properties;
    }

    @Override
    public PropertyReference cloneObject() {
        PropertyReference clone = new PropertyReference();
        super.cloneObject(clone);
        return clone;
    }
}
