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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableSorter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.CloneDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.NewDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.RemoveDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.EngineMaintenanceMasterDetailLabelProvider;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.clone.EngineCloneContentProvider;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.clone.EngineCloneDialogTableFilter;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.clone.EngineCloneNameColumnDialogLabelProvider;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.clone.EngineCloner;


public class EngineDataModelManager {

	private static final String CLONE_ELEMENT = ".Clone";
    private static final String NEW_ELEMENT = ".NewElement";
	private static final String REMOVE = ".Remove";

    public static boolean hasPossibleChildren(Datatype datatype) {
        if (datatype instanceof TestEngineConfiguration) {
            return getPossibleChildrenTypes((TestEngineConfiguration) datatype).length > 0;
        } else if (datatype instanceof ProxyConfiguration) {
            return getPossibleChildrenTypes((ProxyConfiguration) datatype).length > 0;
        } else if (datatype instanceof ConfigurationProperty) {
            return false;
        } else {
            Activator.getDefault().logError(
                    "Error. No children-mapping for type '"
                            + datatype.getClass() + "' in "
                            + EngineDataModelManager.class.getCanonicalName() + " found.");
            return false;
        }
    }
    

    @SuppressWarnings("unchecked")
	public static Class<? extends Datatype>[] getPossibleChildrenTypes(Datatype datatype) {
		Class<? extends Datatype>[] result;
		
		// Determine allowed types
        if (datatype instanceof TestEngineConfiguration) {
        	result = getPossibleChildrenTypes((TestEngineConfiguration) datatype);
        } else if (datatype instanceof ProxyConfiguration) {
        	result = getPossibleChildrenTypes((ProxyConfiguration) datatype);
        } else if (datatype instanceof ConfigurationProperty) {
        	result = new Class[] {};
        } else {
            Activator.getDefault().logError(
                    "Error. No children-mapping for type '"
                            + datatype.getClass() + "' in "
                            + EngineDataModelManager.class.getCanonicalName() + " found.");
            result = new Class[] {};
        }
		return result;
	}

    public static Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
        HashMap<String, Datatype[]> result = new HashMap<String, Datatype[]>();

        // Determine allowed types
        Class<? extends Datatype>[] possibleChildrenTypes = getPossibleChildrenTypes(datatype);

        // Produce elements
        Set<Datatype> children = new HashSet<Datatype>();
        for (Class<? extends Datatype> clazz : possibleChildrenTypes) {
            children.add(EngineElementFactory.create(clazz));
        }
        Datatype[] possibleChildrenInstances = children.toArray(new Datatype[0]);
        result.put(NEW_ELEMENT, possibleChildrenInstances);
        return result;
    }

    public static Menu getContextMenu(ISelection selection, TreeViewer treeViewer,
            EngineMaintenanceMultiPageEditViewModelHandlerImpl modelHandler) {
        Menu result = new Menu(treeViewer.getTree());
        TreeSelection treeSelection = (TreeSelection) selection;
        Object firstElement = treeSelection.getFirstElement();
        if (firstElement instanceof MasterDetailTreeNode) {
            MasterDetailTreeNode treeNode = (MasterDetailTreeNode) firstElement;
            Datatype datatype = treeNode.getDatatype();

            // Menu 'new'
            Menu newElementMenu = createMenu(result,
                    EngineMaintenanceMultiPageEditViewModelHandlerImpl.ID + NEW_ELEMENT, "icons/add.png");
            if (datatype instanceof TestEngineConfiguration) {
                Class<? extends Datatype>[] possibleChildrenTypes = getPossibleChildrenTypes((TestEngineConfiguration) datatype);
                
                addMenuItemsNew(newElementMenu, possibleChildrenTypes, treeNode, treeViewer,
                        modelHandler);
                
                // Menu 'clone'
                Menu cloneElementMenu = createMenu(result, EngineMaintenanceMultiPageEditViewModelHandlerImpl.ID + CLONE_ELEMENT, "icons/copy.png");
                
                addMenuItemsClone(cloneElementMenu, possibleChildrenTypes, treeNode, treeViewer,
                        modelHandler);
                
            } else if (datatype instanceof ProxyConfiguration) {
                Class<? extends Datatype>[] possibleChildrenTypes = getPossibleChildrenTypes((ProxyConfiguration) datatype);
                addMenuItemsNew(newElementMenu, possibleChildrenTypes, treeNode, treeViewer,
                        modelHandler);
            } else if (datatype instanceof ConfigurationProperty) {
            } else {
                Activator.getDefault().logError(
                        "Error. No children-mapping for type '"
                                + datatype.getClass() + "' in "
                                + EngineDataModelManager.class.getCanonicalName() + " found.");
            }
            if (newElementMenu.getItemCount() == 0) {
                newElementMenu.getParentItem().setEnabled(false);
            }
            // If not root case
            if (treeNode.getParent() != null) {
            	// Separator
            	new MenuItem(result, SWT.SEPARATOR);
            	
            	// Remove
            	Image image = ImageProvider.createImage("icons/delete.png");
            	new RemoveDatatypeMenuItem(result, treeNode, modelHandler, treeViewer, EngineMaintenanceMultiPageEditViewModelHandlerImpl.ID + REMOVE, null, image);
            }
        }
        return result;
    }

    private static Menu createMenu(final Menu parentMenu, final String label, String imagePath) {
        MenuItem newElementMenuIten = new MenuItem(parentMenu, SWT.CASCADE);
		newElementMenuIten.setImage(ImageProvider.createImage(imagePath));
        newElementMenuIten.setText(I18N.i18n(label));
        Menu newElementMenu = new Menu(parentMenu);
        newElementMenuIten.setMenu(newElementMenu);
        return newElementMenu;
    }

    private static void addMenuItemsNew(final Menu parentMenu,
            Class<? extends Datatype>[] possibleChildrenTypes, MasterDetailTreeNode treeNode,
            TreeViewer treeViewer, EngineMaintenanceMultiPageEditViewModelHandlerImpl modelHandler) {
        // Produce elements
        for (Class<? extends Datatype> clazz : possibleChildrenTypes) {

            // create menu entries for each allowed class
        	Datatype datatype = EngineElementFactory.create(clazz);
			String imagePath = EngineMaintenanceMasterDetailLabelProvider.getInstance().getImage(datatype);
			Image image = ImageProvider.createImage(imagePath);
        	
            new NewDatatypeMenuItem(parentMenu, treeNode, modelHandler,
                    datatype, treeViewer,
                    EngineMaintenanceMultiPageEditViewModelHandlerImpl.ID
                            + "." + clazz.getSimpleName(), null, image);
        }
    }
    
    private static void addMenuItemsClone(final Menu parentMenu,
            Class<? extends Datatype>[] possibleChildrenTypes, MasterDetailTreeNode treeNode,
            TreeViewer treeViewer, EngineMaintenanceMultiPageEditViewModelHandlerImpl modelHandler) {
        // Produce elements
        for (Class<? extends Datatype> clazz : possibleChildrenTypes) {

            // create menu entries for each allowed class
        	Datatype datatype = EngineElementFactory.create(clazz);
			String imagePath = EngineMaintenanceMasterDetailLabelProvider.getInstance().getImage(datatype);
			Image image = ImageProvider.createImage(imagePath);
        	
			HashMap<String, String> variableTextMap = new HashMap<String, String>();
			variableTextMap.put("name", clazz.getSimpleName());
			
			EngineCloneContentProvider contentProvider = new EngineCloneContentProvider(clazz);
			ILabelProvider inputFieldLabelProvider = null;
			
			NabuccoTableColumnInfo[] tableColumnInfo = new NabuccoTableColumnInfo[] {
					new NabuccoTableColumnInfo(
							"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.selectclone.dialog.column.name.name",
							"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.selectclone.dialog.column.name.tooltip", 150, SWT.LEFT, SWT.LEFT,
							new EngineCloneNameColumnDialogLabelProvider())
			};
			
			NabuccoTableSorter tableSorter = null;
			EngineCloneDialogTableFilter tableFilter = new EngineCloneDialogTableFilter();
			ElementPickerParameter elementPickerParameter = new ElementPickerParameter(tableSorter, tableFilter, inputFieldLabelProvider, contentProvider, tableColumnInfo);
			
			LabelForDialog labelForDialog = new LabelForDialog("org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.title",
					"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.message",
					"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.shellTitle",
					"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.messageTable",
					"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.messageCombo",
			"org.nabucco.testautomation.config.ui.rcp.multipage.config.maintainance.model.pathLabel");
			
            // Clone
			new CloneDatatypeMenuItem(parentMenu, treeNode, modelHandler, treeViewer, EngineMaintenanceMultiPageEditViewModelHandlerImpl.ID + "." + clazz.getSimpleName(),
					elementPickerParameter, labelForDialog,
					variableTextMap, image, new EngineCloner());
        }
    }
    

    @SuppressWarnings("unchecked")
    private static Class<? extends Datatype>[] getPossibleChildrenTypes(TestEngineConfiguration datatype) {
        return new Class[] { ProxyConfiguration.class};
    }
    
    @SuppressWarnings("unchecked")
    private static Class<? extends Datatype>[] getPossibleChildrenTypes(ProxyConfiguration datatype) {
        return new Class[] { ConfigurationProperty.class};
    }

    


}
