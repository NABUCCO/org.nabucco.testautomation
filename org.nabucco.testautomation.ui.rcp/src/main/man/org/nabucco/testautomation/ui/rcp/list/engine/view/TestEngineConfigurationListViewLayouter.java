/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.ui.rcp.list.engine.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoAbstractListLayouter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultListContentProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableViewer;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.ui.rcp.list.engine.model.TestEngineConfigurationListViewModel;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigDescriptionComparator;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigDescriptionLabelProvider;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigHostComparator;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigHostLabelProvider;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigNameComparator;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigNameLabelProvider;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigPortComparator;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigPortLabelProvider;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigRemoteReferenceNameComparator;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewConfigRemoteReferenceNameLabelProvider;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewTableFilter;
import org.nabucco.testautomation.ui.rcp.list.engine.view.TestEngineConfigurationListViewWidgetFactory;


/**
 * @author Steffen Schmidt, PRODYNA AG
 * 
 */
public class TestEngineConfigurationListViewLayouter extends
		NabuccoAbstractListLayouter<TestEngineConfigurationListViewModel> {

	/**
	 * Layouts the table
	 **/
	@Override
	public NabuccoTableViewer layout(final Composite parent,
			final NabuccoMessageManager messageManager,
			final TestEngineConfigurationListViewModel model, final Layoutable<TestEngineConfigurationListViewModel> view) {

		NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

		TestEngineConfigurationListViewWidgetFactory widgetFactory = new TestEngineConfigurationListViewWidgetFactory(
				ntk);

		NabuccoTableParameter parameter = new NabuccoTableParameter(
				new NabuccoDefaultTableSorter<TestEngineConfiguration>(
						createComparators()),
				new TestEngineConfigurationListViewTableFilter(),
				new NabuccoDefaultListContentProvider(model),
				createTableColumnInfo(), getDoubleClickCommand(view
						.getManagedFormViewPart()));

		return widgetFactory.createTable(parent, parameter, model);
	}

	private List<Comparator<TestEngineConfiguration>> createComparators() {
		List<Comparator<TestEngineConfiguration>> comparators = new ArrayList<Comparator<TestEngineConfiguration>>();
		comparators
				.add(new TestEngineConfigurationListViewConfigNameComparator());
		comparators
				.add(new TestEngineConfigurationListViewConfigDescriptionComparator());
		comparators
				.add(new TestEngineConfigurationListViewConfigHostComparator());
		comparators
				.add(new TestEngineConfigurationListViewConfigPortComparator());
		comparators
				.add(new TestEngineConfigurationListViewConfigRemoteReferenceNameComparator());
		return comparators;
	}

	/**
	 * Creates needed tables.
	 * 
	 * @return table columns
	 */
	private NabuccoTableColumnInfo[] createTableColumnInfo() {
		NabuccoTableColumnInfo[] result = {
				new NabuccoTableColumnInfo(
						"Name",
						"This is a TestEngineConfiguration name.",
						200,
						SWT.CENTER,
						SWT.CENTER,
						new TestEngineConfigurationListViewConfigNameLabelProvider()),
				new NabuccoTableColumnInfo(
						"Description",
						"This is a TestEngineConfiguration description",
						300,
						SWT.LEFT,
						SWT.LEFT,
						new TestEngineConfigurationListViewConfigDescriptionLabelProvider()),
				new NabuccoTableColumnInfo(
						"Host",
						"This is a TestEngineConfiguration Host",
						100,
						SWT.LEFT,
						SWT.LEFT,
						new TestEngineConfigurationListViewConfigHostLabelProvider()),
				new NabuccoTableColumnInfo(
						"Port",
						"This is a TestEngineConfiguration Port",
						100,
						SWT.LEFT,
						SWT.LEFT,
						new TestEngineConfigurationListViewConfigPortLabelProvider()),
				new NabuccoTableColumnInfo(
						"RemoteReferenceName",
						"This is a TestEngineConfiguration RemoteReferenceName",
						100,
						SWT.LEFT,
						SWT.LEFT,
						new TestEngineConfigurationListViewConfigRemoteReferenceNameLabelProvider()) };

		return result;
	}

}
