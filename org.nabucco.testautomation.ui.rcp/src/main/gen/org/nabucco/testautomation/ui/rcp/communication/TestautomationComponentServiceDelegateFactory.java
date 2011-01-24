/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.communication;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.facade.component.TestautomationComponent;
import org.nabucco.testautomation.facade.component.TestautomationComponentLocator;
import org.nabucco.testautomation.ui.rcp.communication.maintain.MaintainPropertyDelegate;
import org.nabucco.testautomation.ui.rcp.communication.maintain.MaintainTestEngineConfigurationDelegate;
import org.nabucco.testautomation.ui.rcp.communication.produce.ProducePropertyDelegate;
import org.nabucco.testautomation.ui.rcp.communication.produce.ProduceTestEngineConfigurationDelegate;
import org.nabucco.testautomation.ui.rcp.communication.search.SearchPropertyDelegate;
import org.nabucco.testautomation.ui.rcp.communication.search.SearchTestEngineConfigurationDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>BaseComponent for Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class TestautomationComponentServiceDelegateFactory {

    private static TestautomationComponentServiceDelegateFactory instance = new TestautomationComponentServiceDelegateFactory();

    private TestautomationComponent component;

    private MaintainPropertyDelegate maintainPropertyDelegate;

    private ProducePropertyDelegate producePropertyDelegate;

    private SearchPropertyDelegate searchPropertyDelegate;

    private MaintainTestEngineConfigurationDelegate maintainTestEngineConfigurationDelegate;

    private ProduceTestEngineConfigurationDelegate produceTestEngineConfigurationDelegate;

    private SearchTestEngineConfigurationDelegate searchTestEngineConfigurationDelegate;

    /** Constructs a new TestautomationComponentServiceDelegateFactory instance. */
    private TestautomationComponentServiceDelegateFactory() {
        super();
    }

    /**
     * Getter for the Component.
     *
     * @return the TestautomationComponent.
     * @throws ConnectionException
     */
    private TestautomationComponent getComponent() throws ConnectionException {
        if ((this.component == null)) {
            this.initComponent();
        }
        return this.component;
    }

    /**
     * InitComponent.
     *
     * @throws ConnectionException
     */
    private void initComponent() throws ConnectionException {
        ConnectionSpecification specification = ConnectionSpecification.getCurrentSpecification();
        Connection connection = ConnectionFactory.getInstance().createConnection(specification);
        this.component = TestautomationComponentLocator.getInstance().getComponent(connection);
    }

    /**
     * Getter for the MaintainProperty.
     *
     * @return the MaintainPropertyDelegate.
     * @throws ClientException
     */
    public MaintainPropertyDelegate getMaintainProperty() throws ClientException {
        try {
            if ((this.maintainPropertyDelegate == null)) {
                this.maintainPropertyDelegate = new MaintainPropertyDelegate(this.getComponent()
                        .getMaintainProperty());
            }
            return this.maintainPropertyDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainProperty", e);
        }
    }

    /**
     * Getter for the ProduceProperty.
     *
     * @return the ProducePropertyDelegate.
     * @throws ClientException
     */
    public ProducePropertyDelegate getProduceProperty() throws ClientException {
        try {
            if ((this.producePropertyDelegate == null)) {
                this.producePropertyDelegate = new ProducePropertyDelegate(this.getComponent()
                        .getProduceProperty());
            }
            return this.producePropertyDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceProperty", e);
        }
    }

    /**
     * Getter for the SearchProperty.
     *
     * @return the SearchPropertyDelegate.
     * @throws ClientException
     */
    public SearchPropertyDelegate getSearchProperty() throws ClientException {
        try {
            if ((this.searchPropertyDelegate == null)) {
                this.searchPropertyDelegate = new SearchPropertyDelegate(this.getComponent()
                        .getSearchProperty());
            }
            return this.searchPropertyDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchProperty", e);
        }
    }

    /**
     * Getter for the MaintainTestEngineConfiguration.
     *
     * @return the MaintainTestEngineConfigurationDelegate.
     * @throws ClientException
     */
    public MaintainTestEngineConfigurationDelegate getMaintainTestEngineConfiguration()
            throws ClientException {
        try {
            if ((this.maintainTestEngineConfigurationDelegate == null)) {
                this.maintainTestEngineConfigurationDelegate = new MaintainTestEngineConfigurationDelegate(
                        this.getComponent().getMaintainTestEngineConfiguration());
            }
            return this.maintainTestEngineConfigurationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainTestEngineConfiguration", e);
        }
    }

    /**
     * Getter for the ProduceTestEngineConfiguration.
     *
     * @return the ProduceTestEngineConfigurationDelegate.
     * @throws ClientException
     */
    public ProduceTestEngineConfigurationDelegate getProduceTestEngineConfiguration()
            throws ClientException {
        try {
            if ((this.produceTestEngineConfigurationDelegate == null)) {
                this.produceTestEngineConfigurationDelegate = new ProduceTestEngineConfigurationDelegate(
                        this.getComponent().getProduceTestEngineConfiguration());
            }
            return this.produceTestEngineConfigurationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceTestEngineConfiguration", e);
        }
    }

    /**
     * Getter for the SearchTestEngineConfiguration.
     *
     * @return the SearchTestEngineConfigurationDelegate.
     * @throws ClientException
     */
    public SearchTestEngineConfigurationDelegate getSearchTestEngineConfiguration()
            throws ClientException {
        try {
            if ((this.searchTestEngineConfigurationDelegate == null)) {
                this.searchTestEngineConfigurationDelegate = new SearchTestEngineConfigurationDelegate(
                        this.getComponent().getSearchTestEngineConfiguration());
            }
            return this.searchTestEngineConfigurationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: TestautomationComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchTestEngineConfiguration", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the TestautomationComponentServiceDelegateFactory.
     */
    public static TestautomationComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
