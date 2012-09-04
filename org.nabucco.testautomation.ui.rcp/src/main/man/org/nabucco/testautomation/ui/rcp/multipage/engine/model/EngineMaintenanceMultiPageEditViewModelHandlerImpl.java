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
package org.nabucco.testautomation.ui.rcp.multipage.engine.model;

import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Menu;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableSorter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.framework.plugin.base.component.multipage.xml.DatatypeXMLEditorTextPartCreator;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerDefaultContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;


/**
 * EngineMaintenanceMultiPageEditViewModelHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class EngineMaintenanceMultiPageEditViewModelHandlerImpl implements
        EngineMaintenanceMultiPageEditViewModelHandler {

    public static final String ID = "org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModelHandlerImpl";

    @Override
    public Menu getContextMenu(ISelection selection, TreeViewer treeViewer) {
        return EngineDataModelManager.getContextMenu(selection, treeViewer, this);
    }

    /**
     * Return whether possible children are available.
     */
    @Override
    public boolean hasPossibleChildren(Datatype datatype) {
        return EngineDataModelManager.hasPossibleChildren(datatype);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
        return EngineDataModelManager.getPossibleChildren(datatype);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode addChild(final MasterDetailTreeNode parent, final Datatype newChild) {
        MasterDetailTreeNode result = null;
        Datatype parentDatatype = parent.getDatatype();

        if (newChild instanceof ProxyConfiguration) {
        	ProxyConfiguration newProxyConfiguration = (ProxyConfiguration) newChild;
            if (parentDatatype instanceof TestEngineConfiguration) {
            	TestEngineConfiguration parentTestEngineConfiguration = (TestEngineConfiguration) parentDatatype;
                result = addChildToTree(parent, newProxyConfiguration);
                parentTestEngineConfiguration.getProxyConfigurations().add(newProxyConfiguration);
            }
        } else if (newChild instanceof ConfigurationProperty) {
        	ConfigurationProperty newConfigurationProperty = (ConfigurationProperty) newChild;
            if (parentDatatype instanceof ProxyConfiguration) {
            	ProxyConfiguration parentProxyConfiguration = (ProxyConfiguration) parentDatatype;
                result = addChildToTree(parent, newConfigurationProperty);
                parentProxyConfiguration.getConfigurationProperties().add(newConfigurationProperty);
            }
        }
        if (result == null) {
            Activator.getDefault().logError(
                    new NabuccoLogMessage(
                            EngineMaintenanceMultiPageEditViewModelHandlerImpl.class,
                            "FAILED to add new child!"));
        }
        return result;
    }

    private MasterDetailTreeNode addChildToTree(final MasterDetailTreeNode parent,
            final Datatype newChild) {
        MasterDetailTreeNode result = MasterDetailTreeNodeCreatorForAllDatatypes.getInstance()
                .create(newChild, parent);
            parent.getChildren().add(result);
        Datatype datatype = parent.getDatatype();
        if (datatype.getDatatypeState() == DatatypeState.PERSISTENT) {
            datatype.setDatatypeState(DatatypeState.MODIFIED);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(ISelection child) {
        StructuredSelection ssel = (StructuredSelection) child;
        MasterDetailTreeNode nodeToRemove = (MasterDetailTreeNode) ssel.getFirstElement();
        Datatype datatypeToRemove = nodeToRemove.getDatatype();
        MasterDetailTreeNode parentNode = nodeToRemove.getParent();
        Datatype parentDatatype = parentNode.getDatatype();
        boolean removedFromBusinessModel = false;
        if (parentDatatype instanceof TestEngineConfiguration) {
        	TestEngineConfiguration parentTestEngineConfiguration = (TestEngineConfiguration) parentDatatype;
            if (datatypeToRemove instanceof ProxyConfiguration) {
                removedFromBusinessModel = parentTestEngineConfiguration.getProxyConfigurations().remove(datatypeToRemove);
            }
        } else if (parentDatatype instanceof ProxyConfiguration) {
        	ProxyConfiguration parentProxyConfiguration = (ProxyConfiguration) parentDatatype;
            if (datatypeToRemove instanceof ConfigurationProperty) {
                removedFromBusinessModel = parentProxyConfiguration.getConfigurationProperties().remove(datatypeToRemove);
            }
        }
        
        if (removedFromBusinessModel) {
            if (datatypeToRemove.getDatatypeState() == DatatypeState.PERSISTENT || datatypeToRemove.getDatatypeState() == DatatypeState.MODIFIED) {
                datatypeToRemove.setDatatypeState(DatatypeState.DELETED);
            }
            if (parentDatatype.getDatatypeState() == DatatypeState.PERSISTENT) {
                parentDatatype.setDatatypeState(DatatypeState.MODIFIED);
            }
            if (!parentNode.getChildren().remove(nodeToRemove)){
                Activator.getDefault().logError(
                        new NabuccoLogMessage(
                                EngineMaintenanceMultiPageEditViewModelHandlerImpl.class,
                                "FAILED to remove datatype from tree!"));
            }
        } else {
            Activator.getDefault().logError(
                    new NabuccoLogMessage(
                            EngineMaintenanceMultiPageEditViewModelHandlerImpl.class,
                            "FAILED to remove datatype from business model!"));
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode createMasterDetailRepresentation(Datatype datatype) {
        return MasterDetailTreeNodeCreatorForAllDatatypes.getInstance().create(datatype, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public XMLEditorTextPart createXmlRepresentation(Datatype datatype) {
        return DatatypeXMLEditorTextPartCreator.getInstance().create(datatype, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Datatype create(Class<?> className) {
        return EngineElementFactory.create(className);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestEngineConfiguration createDefaultDatatype() {
        return new TestEngineConfiguration() ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddDialogLabelProvider getAddDialogLabelProvider() {
        return new EngineMaintenanceMasterDetailAddDialogLabelProvider();
    }

    @Override
    public ElementPickerParameter getElementPickerParameter(Datatype parentDatatype) {
        NabuccoTableColumnInfo[] tableColumnInfo = createColumnInfo();
        NabuccoTableSorter tableSorter = null;
        ILabelProvider inputFieldLabelProvider = null;
        ElementPickerContentProvider contentProvider = new ElementPickerDefaultContentProvider(
                getPossibleChildren(parentDatatype));
        ElementPickerParameter result = new ElementPickerParameter(tableSorter,
                inputFieldLabelProvider, contentProvider, tableColumnInfo);
        return result;
    }

    private NabuccoTableColumnInfo[] createColumnInfo() {
        NabuccoTableColumnInfo[] result = new NabuccoTableColumnInfo[] { new NabuccoTableColumnInfo(
                ID + ".title",
                ID + ".tooltip",
                200, new EngineMaintenanceMasterDetailAddDialogLabelProvider()) };
        return result;
    }

    @Override
    public LabelForDialog getLabelForDialog() {
        LabelForDialog result = new LabelForDialog(
        		ID + ".title",
        		ID + ".message",
        		ID + ".shellTitle",
        		ID + ".messageTable",
        		ID + ".messageCombo",
        		ID + ".pathLabel");
        return result;
    }

    @Override
    public boolean up(ISelection selection) {
        return false;
    }

    @Override
    public boolean down(ISelection selection) {
        return false;
    }

}
