/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.ui.rcp.search.engine.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchViewModel;

/**
 * TestEngineConfigurationSearchViewWidgetFactory<p/>Search view for TestEngineConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA6 AG, 2010-06-30
 */
public class TestEngineConfigurationSearchViewWidgetFactory extends WidgetFactory {

    private TestEngineConfigurationSearchViewModel model;

    public static final String LABEL_CONFIGNAME = "config.name";

    public static final String OBSERVE_VALUE_CONFIGNAME = TestEngineConfigurationSearchViewModel.PROPERTY_CONFIG_NAME;

    public static final String LABEL_CONFIGHOST = "config.host";

    public static final String OBSERVE_VALUE_CONFIGHOST = TestEngineConfigurationSearchViewModel.PROPERTY_CONFIG_HOST;

    public static final String LABEL_CONFIGPORT = "config.port";

    public static final String OBSERVE_VALUE_CONFIGPORT = TestEngineConfigurationSearchViewModel.PROPERTY_CONFIG_PORT;

    public static final String LABEL_CONFIGREMOTEREFERENCENAME = "config.remoteReferenceName";

    public static final String OBSERVE_VALUE_CONFIGREMOTEREFERENCENAME = TestEngineConfigurationSearchViewModel.PROPERTY_CONFIG_REMOTEREFERENCENAME;

    /**
     * Constructs a new TestEngineConfigurationSearchViewWidgetFactory instance.
     *
     * @param aModel the TestEngineConfigurationSearchViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public TestEngineConfigurationSearchViewWidgetFactory(
            final NabuccoFormToolkit nabuccoFormToolKit,
            final TestEngineConfigurationSearchViewModel aModel) {
        super(nabuccoFormToolKit);
        model = aModel;
    }

    /**
     * CreateLabelConfigName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelConfigName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CONFIGNAME);
    }

    /**
     * CreateInputFieldConfigName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldConfigName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_CONFIGNAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelConfigHost.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelConfigHost(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CONFIGHOST);
    }

    /**
     * CreateInputFieldConfigHost.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldConfigHost(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_CONFIGHOST);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelConfigPort.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelConfigPort(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CONFIGPORT);
    }

    /**
     * CreateInputFieldConfigPort.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldConfigPort(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_CONFIGPORT);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelConfigRemoteReferenceName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelConfigRemoteReferenceName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CONFIGREMOTEREFERENCENAME);
    }

    /**
     * CreateInputFieldConfigRemoteReferenceName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldConfigRemoteReferenceName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_CONFIGREMOTEREFERENCENAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
