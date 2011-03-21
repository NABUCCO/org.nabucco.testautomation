/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.impl.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.framework.common.authorization.facade.component.AuthorizationComponent;
import org.nabucco.testautomation.facade.component.TestautomationComponent;
import org.nabucco.testautomation.facade.service.export.ExportTestautomation;
import org.nabucco.testautomation.facade.service.importing.ImportTestautomation;
import org.nabucco.testautomation.facade.service.maintain.MaintainProperty;
import org.nabucco.testautomation.facade.service.maintain.MaintainTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.produce.ProduceProperty;
import org.nabucco.testautomation.facade.service.produce.ProduceTestEngineConfiguration;
import org.nabucco.testautomation.facade.service.search.SearchProperty;
import org.nabucco.testautomation.facade.service.search.SearchTestEngineConfiguration;

/**
 * TestautomationComponentImpl<p/>BaseComponent for Testautomation<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class TestautomationComponentImpl extends ComponentSupport implements
        TestautomationComponent {

    private static final long serialVersionUID = 1L;

    private ComponentRelationService componentRelationService;

    private AuthorizationComponent authorizationComponent;

    private MaintainProperty maintainProperty;

    private ProduceProperty produceProperty;

    private SearchProperty searchProperty;

    private MaintainTestEngineConfiguration maintainTestEngineConfiguration;

    private ProduceTestEngineConfiguration produceTestEngineConfiguration;

    private SearchTestEngineConfiguration searchTestEngineConfiguration;

    private ExportTestautomation exportTestautomation;

    private ImportTestautomation importTestautomation;

    /** Constructs a new TestautomationComponentImpl instance. */
    public TestautomationComponentImpl() {
        super();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.componentRelationService;
    }

    /**
     * Getter for the AuthorizationComponent.
     *
     * @return the AuthorizationComponent.
     */
    public AuthorizationComponent getAuthorizationComponent() {
        return this.authorizationComponent;
    }

    /**
     * Getter for the MaintainProperty.
     *
     * @return the MaintainProperty.
     */
    public MaintainProperty getMaintainProperty() {
        return this.maintainProperty;
    }

    /**
     * Getter for the ProduceProperty.
     *
     * @return the ProduceProperty.
     */
    public ProduceProperty getProduceProperty() {
        return this.produceProperty;
    }

    /**
     * Getter for the SearchProperty.
     *
     * @return the SearchProperty.
     */
    public SearchProperty getSearchProperty() {
        return this.searchProperty;
    }

    /**
     * Getter for the MaintainTestEngineConfiguration.
     *
     * @return the MaintainTestEngineConfiguration.
     */
    public MaintainTestEngineConfiguration getMaintainTestEngineConfiguration() {
        return this.maintainTestEngineConfiguration;
    }

    /**
     * Getter for the ProduceTestEngineConfiguration.
     *
     * @return the ProduceTestEngineConfiguration.
     */
    public ProduceTestEngineConfiguration getProduceTestEngineConfiguration() {
        return this.produceTestEngineConfiguration;
    }

    /**
     * Getter for the SearchTestEngineConfiguration.
     *
     * @return the SearchTestEngineConfiguration.
     */
    public SearchTestEngineConfiguration getSearchTestEngineConfiguration() {
        return this.searchTestEngineConfiguration;
    }

    /**
     * Getter for the ExportTestautomation.
     *
     * @return the ExportTestautomation.
     */
    public ExportTestautomation getExportTestautomation() {
        return this.exportTestautomation;
    }

    /**
     * Getter for the ImportTestautomation.
     *
     * @return the ImportTestautomation.
     */
    public ImportTestautomation getImportTestautomation() {
        return this.importTestautomation;
    }
}
