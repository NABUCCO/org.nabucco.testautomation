/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.search.engine.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;

/**
 * TestEngineConfigurationSearchViewModel<p/>Search view for TestEngineConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA6 AG, 2010-06-30
 */
public class TestEngineConfigurationSearchViewModel extends
        NabuccoComponentSearchViewModel<TestEngineConfiguration> implements
        NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.testautomation.ui.search.engine.TestEngineConfigurationSearchViewModel";

    private TestEngineConfiguration config;

    public static final String PROPERTY_CONFIG_NAME = "configName";

    public static final String PROPERTY_CONFIG_HOST = "configHost";

    public static final String PROPERTY_CONFIG_PORT = "configPort";

    public static final String PROPERTY_CONFIG_REMOTEREFERENCENAME = "configRemoteReferenceName";

    public static String TITLE = (ID + "Title");

    /**
     * Constructs a new TestEngineConfigurationSearchViewModel instance.
     *
     * @param viewId the String.
     */
    public TestEngineConfigurationSearchViewModel(String viewId) {
        super();
        correspondingListView = viewId;
        this.config = new TestEngineConfiguration();
    }

    @Override
    public String getSearchModelId() {
        return searchModelId;
    }

    @Override
    public NabuccoComponentSearchParameter getSearchParameter() {
        return this;
    }

    /**
     * Getter for the Config.
     *
     * @return the TestEngineConfiguration.
     */
    public TestEngineConfiguration getConfig() {
        return this.config;
    }

    /**
     * Setter for the ConfigName.
     *
     * @param newName the String.
     */
    public void setConfigName(String newName) {
        if (((config != null) && (config.getName() == null))) {
            Name name = new Name();
            config.setName(name);
        }
        String oldVal = config.getName().getValue();
        config.getName().setValue(newName);
        this.updateProperty(PROPERTY_CONFIG_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && config.getDatatypeState()
                .equals(DatatypeState.PERSISTENT))) {
            config.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the ConfigName.
     *
     * @return the String.
     */
    public String getConfigName() {
        if ((((config == null) || (config.getName() == null)) || (config.getName().getValue() == null))) {
            return "";
        }
        return config.getName().getValue();
    }

    /**
     * Setter for the ConfigHost.
     *
     * @param newHost the String.
     */
    public void setConfigHost(String newHost) {
        if (((config != null) && (config.getHost() == null))) {
            Name host = new Name();
            config.setHost(host);
        }
        String oldVal = config.getHost().getValue();
        config.getHost().setValue(newHost);
        this.updateProperty(PROPERTY_CONFIG_HOST, oldVal, newHost);
        if (((!oldVal.equals(newHost)) && config.getDatatypeState()
                .equals(DatatypeState.PERSISTENT))) {
            config.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the ConfigHost.
     *
     * @return the String.
     */
    public String getConfigHost() {
        if ((((config == null) || (config.getHost() == null)) || (config.getHost().getValue() == null))) {
            return "";
        }
        return config.getHost().getValue();
    }

    /**
     * Setter for the ConfigPort.
     *
     * @param newPort the String.
     */
    public void setConfigPort(String newPort) {
        if (((config != null) && (config.getPort() == null))) {
            Name port = new Name();
            config.setPort(port);
        }
        String oldVal = config.getPort().getValue();
        config.getPort().setValue(newPort);
        this.updateProperty(PROPERTY_CONFIG_PORT, oldVal, newPort);
        if (((!oldVal.equals(newPort)) && config.getDatatypeState()
                .equals(DatatypeState.PERSISTENT))) {
            config.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the ConfigPort.
     *
     * @return the String.
     */
    public String getConfigPort() {
        if ((((config == null) || (config.getPort() == null)) || (config.getPort().getValue() == null))) {
            return "";
        }
        return config.getPort().getValue();
    }

    /**
     * Setter for the ConfigRemoteReferenceName.
     *
     * @param newRemoteReferenceName the String.
     */
    public void setConfigRemoteReferenceName(String newRemoteReferenceName) {
        if (((config != null) && (config.getRemoteReferenceName() == null))) {
            Name remoteReferenceName = new Name();
            config.setRemoteReferenceName(remoteReferenceName);
        }
        String oldVal = config.getRemoteReferenceName().getValue();
        config.getRemoteReferenceName().setValue(newRemoteReferenceName);
        this.updateProperty(PROPERTY_CONFIG_REMOTEREFERENCENAME, oldVal, newRemoteReferenceName);
        if (((!oldVal.equals(newRemoteReferenceName)) && config.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            config.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the ConfigRemoteReferenceName.
     *
     * @return the String.
     */
    public String getConfigRemoteReferenceName() {
        if ((((config == null) || (config.getRemoteReferenceName() == null)) || (config
                .getRemoteReferenceName().getValue() == null))) {
            return "";
        }
        return config.getRemoteReferenceName().getValue();
    }

    @Override
    public String getId() {
        return TestEngineConfigurationSearchViewModel.ID;
    }
}
