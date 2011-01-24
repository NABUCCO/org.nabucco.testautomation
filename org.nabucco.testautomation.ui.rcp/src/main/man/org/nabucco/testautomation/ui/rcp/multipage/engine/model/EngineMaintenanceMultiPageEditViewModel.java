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
package org.nabucco.testautomation.ui.rcp.multipage.engine.model;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Menu;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.model.MultiPageEditViewModel;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;


/**
 * EngineMaintenanceMultiPageEditViewModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class EngineMaintenanceMultiPageEditViewModel extends MultiPageEditViewModel implements
        NabuccoInjectionReciever {

    private MasterDetailTreeNode treeStructure;

    private XMLEditorTextPart xmlStructure;

    private EngineMaintenanceMultiPageEditViewModelHandler handler = NabuccoInjector.getInstance(
            EngineMaintenanceMultiPageEditViewModel.class).inject(
            EngineMaintenanceMultiPageEditViewModelHandler.class);

	private TestEngineConfiguration testEngineConfiguration;

    /**
     * @param workflowCondition
     */
    public EngineMaintenanceMultiPageEditViewModel() {
        setTestEngineConfiguration(handler.createDefaultDatatype());
    }

    // <MASTER DETAIL METHODS>
    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode add(MasterDetailTreeNode parent, Datatype newChild) {
        MasterDetailTreeNode result = handler.addChild(parent, newChild);
        updateProperty(getPropertyDatatype(), "", "*");
        return result;
    }

    @Override
    public MasterDetailTreeNode getTreeStructure() {
        return treeStructure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode createNewAndAdd(final MasterDetailTreeNode parent,
            final Datatype newChild) {
        // observers will be already informed in the node is added (which is
        // relevant for view)
        MasterDetailTreeNode result = add(parent, newChild);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(ISelection child) {
        handler.remove(child);
        updateProperty(getPropertyDatatype(), "", "*");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestEngineConfiguration getRoot() {
        return (TestEngineConfiguration) treeStructure.getDatatype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
        return handler.getPossibleChildren(datatype);
    }

    // </MASTER DETAIL METHODS>

    // <XML METHODS>
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean parseXML(String content) {
        return xmlStructure.parseXML(content);
    }

    @Override
    public String getXMLText() {
        return xmlStructure.getXML();
    }

    @Override
    public XMLEditorTextPart getXmlStructure() {
        return xmlStructure;
    }

    // </XML METHODS>

    /**
     * Setter.
     * 
     * @param testScript
     *            value
     */
    public void setTestEngineConfiguration(final TestEngineConfiguration testEngineConfiguration) {
        this.testEngineConfiguration = testEngineConfiguration;
        treeStructure = handler.createMasterDetailRepresentation(this.testEngineConfiguration);
        xmlStructure = handler.createXmlRepresentation(this.testEngineConfiguration);

        updateProperty(getPropertyDatatype(), "", "*");
    }

    /**
     * Getter.
     * 
     * @return value
     */
    public TestEngineConfiguration getTestEngineConfiguration() {
        return this.testEngineConfiguration;
    }

    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put("name", testEngineConfiguration.getName());
        return result;
    }

    @Override
    public ElementPickerParameter getElementPickerParameter(Datatype parentDatatype) {
        return handler.getElementPickerParameter(parentDatatype);
    }

    @Override
    public LabelForDialog getLabelForDialog() {
        return handler.getLabelForDialog();
    }

    @Override
    public Menu getContextMenu(ISelection selection, TreeViewer parent) {
        return this.handler.getContextMenu(selection, parent);
    }

    @Override
    public boolean up(ISelection selection) {
        return handler.up(selection);
    }

    @Override
    public boolean down(ISelection selection) {
        return handler.down(selection);
    }
    
	@Override
	public boolean hasPossibleChildren(Datatype datatype) {
		return handler.hasPossibleChildren(datatype);
	}

}
