/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.base;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Basetype;
import org.nabucco.framework.base.facade.datatype.NDouble;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.SimpleProperty;

/**
 * DoubleValue<p/>Basic datatype for long values<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-06
 */
public class DoubleValue extends NDouble implements Basetype {

    private static final long serialVersionUID = 1L;

    private static final String PROPERTY_NAME = "value";

    private static final String PROPERTY_CONSTRAINTS = "l0,n;";

    /** Constructs a new DoubleValue instance. */
    public DoubleValue() {
        super();
    }

    /**
     * Constructs a new DoubleValue instance.
     *
     * @param value the Double.
     */
    public DoubleValue(Double value) {
        super(value);
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new SimpleProperty<Double>(PROPERTY_NAME, Double.class,
                PROPERTY_CONSTRAINTS, super.getValue()));
        return properties;
    }

    @Override
    public DoubleValue cloneObject() {
        DoubleValue clone = new DoubleValue();
        super.cloneObject(clone);
        return clone;
    }
}
