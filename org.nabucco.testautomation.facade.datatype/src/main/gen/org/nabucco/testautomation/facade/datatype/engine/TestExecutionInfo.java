/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.engine;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DateTime;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Percentage;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.engine.ExecutionStatusType;

/**
 * TestExecutionInfo<p/>Info-object containg information about a certain test run<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestExecutionInfo extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "jobId", "startTime", "stopTime",
            "percentCompleted", "currentTestScriptId", "currentTestScriptElementId", "testStatus" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m0,1;",
            "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;", "m1,1;" };

    private Identifier jobId;

    private DateTime startTime;

    private DateTime stopTime;

    private Percentage percentCompleted;

    private Identifier currentTestScriptId;

    private Identifier currentTestScriptElementId;

    private ExecutionStatusType testStatus;

    /** Constructs a new TestExecutionInfo instance. */
    public TestExecutionInfo() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestExecutionInfo.
     */
    protected void cloneObject(TestExecutionInfo clone) {
        super.cloneObject(clone);
        if ((this.getJobId() != null)) {
            clone.setJobId(this.getJobId().cloneObject());
        }
        if ((this.getStartTime() != null)) {
            clone.setStartTime(this.getStartTime().cloneObject());
        }
        if ((this.getStopTime() != null)) {
            clone.setStopTime(this.getStopTime().cloneObject());
        }
        if ((this.getPercentCompleted() != null)) {
            clone.setPercentCompleted(this.getPercentCompleted().cloneObject());
        }
        if ((this.getCurrentTestScriptId() != null)) {
            clone.setCurrentTestScriptId(this.getCurrentTestScriptId().cloneObject());
        }
        if ((this.getCurrentTestScriptElementId() != null)) {
            clone.setCurrentTestScriptElementId(this.getCurrentTestScriptElementId().cloneObject());
        }
        clone.setTestStatus(this.getTestStatus());
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[0], Identifier.class,
                PROPERTY_CONSTRAINTS[0], this.jobId));
        properties.add(new BasetypeProperty<DateTime>(PROPERTY_NAMES[1], DateTime.class,
                PROPERTY_CONSTRAINTS[1], this.startTime));
        properties.add(new BasetypeProperty<DateTime>(PROPERTY_NAMES[2], DateTime.class,
                PROPERTY_CONSTRAINTS[2], this.stopTime));
        properties.add(new BasetypeProperty<Percentage>(PROPERTY_NAMES[3], Percentage.class,
                PROPERTY_CONSTRAINTS[3], this.percentCompleted));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[4], Identifier.class,
                PROPERTY_CONSTRAINTS[4], this.currentTestScriptId));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[5], Identifier.class,
                PROPERTY_CONSTRAINTS[5], this.currentTestScriptElementId));
        properties.add(new EnumProperty<ExecutionStatusType>(PROPERTY_NAMES[6],
                ExecutionStatusType.class, PROPERTY_CONSTRAINTS[6], this.testStatus));
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
        final TestExecutionInfo other = ((TestExecutionInfo) obj);
        if ((this.jobId == null)) {
            if ((other.jobId != null))
                return false;
        } else if ((!this.jobId.equals(other.jobId)))
            return false;
        if ((this.startTime == null)) {
            if ((other.startTime != null))
                return false;
        } else if ((!this.startTime.equals(other.startTime)))
            return false;
        if ((this.stopTime == null)) {
            if ((other.stopTime != null))
                return false;
        } else if ((!this.stopTime.equals(other.stopTime)))
            return false;
        if ((this.percentCompleted == null)) {
            if ((other.percentCompleted != null))
                return false;
        } else if ((!this.percentCompleted.equals(other.percentCompleted)))
            return false;
        if ((this.currentTestScriptId == null)) {
            if ((other.currentTestScriptId != null))
                return false;
        } else if ((!this.currentTestScriptId.equals(other.currentTestScriptId)))
            return false;
        if ((this.currentTestScriptElementId == null)) {
            if ((other.currentTestScriptElementId != null))
                return false;
        } else if ((!this.currentTestScriptElementId.equals(other.currentTestScriptElementId)))
            return false;
        if ((this.testStatus == null)) {
            if ((other.testStatus != null))
                return false;
        } else if ((!this.testStatus.equals(other.testStatus)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.jobId == null) ? 0 : this.jobId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.stopTime == null) ? 0 : this.stopTime.hashCode()));
        result = ((PRIME * result) + ((this.percentCompleted == null) ? 0 : this.percentCompleted
                .hashCode()));
        result = ((PRIME * result) + ((this.currentTestScriptId == null) ? 0
                : this.currentTestScriptId.hashCode()));
        result = ((PRIME * result) + ((this.currentTestScriptElementId == null) ? 0
                : this.currentTestScriptElementId.hashCode()));
        result = ((PRIME * result) + ((this.testStatus == null) ? 0 : this.testStatus.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestExecutionInfo>\n");
        appendable.append(super.toString());
        appendable.append((("<jobId>" + this.jobId) + "</jobId>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append((("<stopTime>" + this.stopTime) + "</stopTime>\n"));
        appendable
                .append((("<percentCompleted>" + this.percentCompleted) + "</percentCompleted>\n"));
        appendable
                .append((("<currentTestScriptId>" + this.currentTestScriptId) + "</currentTestScriptId>\n"));
        appendable
                .append((("<currentTestScriptElementId>" + this.currentTestScriptElementId) + "</currentTestScriptElementId>\n"));
        appendable.append((("<testStatus>" + this.testStatus) + "</testStatus>\n"));
        appendable.append("</TestExecutionInfo>\n");
        return appendable.toString();
    }

    @Override
    public TestExecutionInfo cloneObject() {
        TestExecutionInfo clone = new TestExecutionInfo();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getJobId.
     *
     * @return the Identifier.
     */
    public Identifier getJobId() {
        return this.jobId;
    }

    /**
     * Missing description at method setJobId.
     *
     * @param jobId the Identifier.
     */
    public void setJobId(Identifier jobId) {
        this.jobId = jobId;
    }

    /**
     * Missing description at method setJobId.
     *
     * @param jobId the Long.
     */
    public void setJobId(Long jobId) {
        if ((this.jobId == null)) {
            this.jobId = new Identifier();
        }
        this.jobId.setValue(jobId);
    }

    /**
     * Missing description at method getStartTime.
     *
     * @return the DateTime.
     */
    public DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the DateTime.
     */
    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the Long.
     */
    public void setStartTime(Long startTime) {
        if ((this.startTime == null)) {
            this.startTime = new DateTime();
        }
        this.startTime.setValue(startTime);
    }

    /**
     * Missing description at method getStopTime.
     *
     * @return the DateTime.
     */
    public DateTime getStopTime() {
        return this.stopTime;
    }

    /**
     * Missing description at method setStopTime.
     *
     * @param stopTime the DateTime.
     */
    public void setStopTime(DateTime stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * Missing description at method setStopTime.
     *
     * @param stopTime the Long.
     */
    public void setStopTime(Long stopTime) {
        if ((this.stopTime == null)) {
            this.stopTime = new DateTime();
        }
        this.stopTime.setValue(stopTime);
    }

    /**
     * Missing description at method getPercentCompleted.
     *
     * @return the Percentage.
     */
    public Percentage getPercentCompleted() {
        return this.percentCompleted;
    }

    /**
     * Missing description at method setPercentCompleted.
     *
     * @param percentCompleted the Percentage.
     */
    public void setPercentCompleted(Percentage percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    /**
     * Missing description at method setPercentCompleted.
     *
     * @param percentCompleted the Float.
     */
    public void setPercentCompleted(Float percentCompleted) {
        if ((this.percentCompleted == null)) {
            this.percentCompleted = new Percentage();
        }
        this.percentCompleted.setValue(percentCompleted);
    }

    /**
     * Missing description at method getCurrentTestScriptId.
     *
     * @return the Identifier.
     */
    public Identifier getCurrentTestScriptId() {
        return this.currentTestScriptId;
    }

    /**
     * Missing description at method setCurrentTestScriptId.
     *
     * @param currentTestScriptId the Identifier.
     */
    public void setCurrentTestScriptId(Identifier currentTestScriptId) {
        this.currentTestScriptId = currentTestScriptId;
    }

    /**
     * Missing description at method setCurrentTestScriptId.
     *
     * @param currentTestScriptId the Long.
     */
    public void setCurrentTestScriptId(Long currentTestScriptId) {
        if ((this.currentTestScriptId == null)) {
            this.currentTestScriptId = new Identifier();
        }
        this.currentTestScriptId.setValue(currentTestScriptId);
    }

    /**
     * Missing description at method getCurrentTestScriptElementId.
     *
     * @return the Identifier.
     */
    public Identifier getCurrentTestScriptElementId() {
        return this.currentTestScriptElementId;
    }

    /**
     * Missing description at method setCurrentTestScriptElementId.
     *
     * @param currentTestScriptElementId the Identifier.
     */
    public void setCurrentTestScriptElementId(Identifier currentTestScriptElementId) {
        this.currentTestScriptElementId = currentTestScriptElementId;
    }

    /**
     * Missing description at method setCurrentTestScriptElementId.
     *
     * @param currentTestScriptElementId the Long.
     */
    public void setCurrentTestScriptElementId(Long currentTestScriptElementId) {
        if ((this.currentTestScriptElementId == null)) {
            this.currentTestScriptElementId = new Identifier();
        }
        this.currentTestScriptElementId.setValue(currentTestScriptElementId);
    }

    /**
     * Missing description at method getTestStatus.
     *
     * @return the ExecutionStatusType.
     */
    public ExecutionStatusType getTestStatus() {
        return this.testStatus;
    }

    /**
     * Missing description at method setTestStatus.
     *
     * @param testStatus the ExecutionStatusType.
     */
    public void setTestStatus(ExecutionStatusType testStatus) {
        this.testStatus = testStatus;
    }

    /**
     * Missing description at method setTestStatus.
     *
     * @param testStatus the String.
     */
    public void setTestStatus(String testStatus) {
        if ((testStatus == null)) {
            this.testStatus = null;
        } else {
            this.testStatus = ExecutionStatusType.valueOf(testStatus);
        }
    }
}
