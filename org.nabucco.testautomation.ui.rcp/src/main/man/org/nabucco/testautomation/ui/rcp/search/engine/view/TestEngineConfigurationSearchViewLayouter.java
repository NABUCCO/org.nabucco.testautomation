/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.ui.rcp.search.engine.view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.ui.rcp.search.engine.model.TestEngineConfigurationSearchViewModel;
import org.nabucco.testautomation.ui.rcp.search.engine.view.TestEngineConfigurationSearchViewWidgetFactory;


/**
 * Layouter for TestScript Search View.
 * 
 * @author Stefan Huettenrauch, PRODYNA AG
 * 
 */
public class TestEngineConfigurationSearchViewLayouter implements
		NabuccoLayouter {

	private final static String MESSAGE_OWNER_ID = "org.nabucco.testautomation.ui.search.engine.view.TestEngineConfigurationSearchViewLayouter";
	private final static String CONFIG_TEXT = "TestEngineConfiguration";

	private NabuccoMessageManager messageManager;

	@Override
	public Composite layout(Composite parent,
			NabuccoMessageManager messageManager, ViewModel model) {
		if (model instanceof TestEngineConfigurationSearchViewModel) {
			return layout(parent, messageManager,
					(TestEngineConfigurationSearchViewModel) model);
		}
		return null;
	}

	@Override
	public Composite layout(Composite parent,
			NabuccoMessageManager messageManager, ViewModel model,
			Layoutable view) {
		return layout(parent, messageManager, model);
	}

	private Composite layout(final Composite parent,
			final NabuccoMessageManager aMessageManager,
			final TestEngineConfigurationSearchViewModel aModel) {

		NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);
		TestEngineConfigurationSearchViewWidgetFactory widgetFactory = new TestEngineConfigurationSearchViewWidgetFactory(
				ntk, aModel);
		messageManager = aMessageManager;

		// define paint listener
		parent.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				messageManager.showMessages(MESSAGE_OWNER_ID);
			}
		});

		// build a section to host the other controls
		Section section = ntk.createSection(parent, CONFIG_TEXT,
				new RowLayout());
		Composite child = ntk.createComposite(section, new GridLayout(2, true));
		section.setClient(child);

		// ui elements pair-wise: label + input field or combo
		widgetFactory.createLabelConfigName(child);
		widgetFactory.createInputFieldConfigName(child);
		widgetFactory.createLabelConfigHost(child);
		widgetFactory.createInputFieldConfigHost(child);
		widgetFactory.createLabelConfigPort(child);
		widgetFactory.createInputFieldConfigPort(child);
		widgetFactory.createLabelConfigRemoteReferenceName(child);
		widgetFactory.createInputFieldConfigRemoteReferenceName(child);

		return null;
	}

}
