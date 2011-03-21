/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.facade.datatype.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DateTime;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Percentage;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.engine.ExecutionStatusType;

/**
 * TestExecutionInfo<p/>Info-object containg information about a certain test run<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-25
 */
public class TestExecutionInfo extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m0,1;",
            "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;", "m1,1;" };

    public static final String JOBID = "jobId";

    public static final String STARTTIME = "startTime";

    public static final String STOPTIME = "stopTime";

    public static final String PERCENTCOMPLETED = "percentCompleted";

    public static final String CURRENTTESTSCRIPTID = "currentTestScriptId";

    public static final String CURRENTTESTSCRIPTELEMENTID = "currentTestScriptElementId";

    public static final String TESTSTATUS = "testStatus";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class)
                .getPropertyMap());
        propertyMap.put(JOBID, PropertyDescriptorSupport.createBasetype(JOBID, Identifier.class, 2,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(STARTTIME, PropertyDescriptorSupport.createBasetype(STARTTIME,
                DateTime.class, 3, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(STOPTIME, PropertyDescriptorSupport.createBasetype(STOPTIME,
                DateTime.class, 4, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(PERCENTCOMPLETED, PropertyDescriptorSupport.createBasetype(
                PERCENTCOMPLETED, Percentage.class, 5, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(CURRENTTESTSCRIPTID, PropertyDescriptorSupport.createBasetype(
                CURRENTTESTSCRIPTID, Identifier.class, 6, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(CURRENTTESTSCRIPTELEMENTID, PropertyDescriptorSupport.createBasetype(
                CURRENTTESTSCRIPTELEMENTID, Identifier.class, 7, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(TESTSTATUS, PropertyDescriptorSupport.createEnumeration(TESTSTATUS,
                ExecutionStatusType.class, 8, PROPERTY_CONSTRAINTS[6], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestExecutionInfo.getPropertyDescriptor(JOBID),
                this.jobId, null));
        properties.add(super.createProperty(TestExecutionInfo.getPropertyDescriptor(STARTTIME),
                this.startTime, null));
        properties.add(super.createProperty(TestExecutionInfo.getPropertyDescriptor(STOPTIME),
                this.stopTime, null));
        properties.add(super.createProperty(
                TestExecutionInfo.getPropertyDescriptor(PERCENTCOMPLETED), this.percentCompleted,
                null));
        properties.add(super.createProperty(
                TestExecutionInfo.getPropertyDescriptor(CURRENTTESTSCRIPTID),
                this.currentTestScriptId, null));
        properties.add(super.createProperty(
                TestExecutionInfo.getPropertyDescriptor(CURRENTTESTSCRIPTELEMENTID),
                this.currentTestScriptElementId, null));
        properties.add(super.createProperty(TestExecutionInfo.getPropertyDescriptor(TESTSTATUS),
                this.testStatus, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(JOBID) && (property.getType() == Identifier.class))) {
            this.setJobId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STARTTIME) && (property.getType() == DateTime.class))) {
            this.setStartTime(((DateTime) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STOPTIME) && (property.getType() == DateTime.class))) {
            this.setStopTime(((DateTime) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PERCENTCOMPLETED) && (property.getType() == Percentage.class))) {
            this.setPercentCompleted(((Percentage) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CURRENTTESTSCRIPTID) && (property.getType() == Identifier.class))) {
            this.setCurrentTestScriptId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CURRENTTESTSCRIPTELEMENTID) && (property.getType() == Identifier.class))) {
            this.setCurrentTestScriptElementId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTSTATUS) && (property.getType() == ExecutionStatusType.class))) {
            this.setTestStatus(((ExecutionStatusType) property.getInstance()));
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
            if ((jobId == null)) {
                return;
            }
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
            if ((startTime == null)) {
                return;
            }
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
            if ((stopTime == null)) {
                return;
            }
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
            if ((percentCompleted == null)) {
                return;
            }
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
            if ((currentTestScriptId == null)) {
                return;
            }
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
            if ((currentTestScriptElementId == null)) {
                return;
            }
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestExecutionInfo.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestExecutionInfo.class).getAllProperties();
    }
}
