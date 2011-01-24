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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ui.forms.DetailsPart;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlockLayouter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.detail.TestautomationDetailPageView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.EngineMaintenanceMultiPageEditView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.TestEngineConfigurationDetailPageView;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineMaintenanceMultiPageEditViewModel;


/**
 * EngineMaintenanceMasterDetailBlock
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class EngineMaintenanceMasterDetailBlock extends
        MasterDetailBlock<EngineMaintenanceMultiPageEditViewModel> implements
        Layoutable<EngineMaintenanceMultiPageEditViewModel> {

    public static String ID = "org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.EngineMaintenanceMasterDetailBlock";

    public EngineMaintenanceMasterDetailBlock(EngineMaintenanceMultiPageEditViewModel model,
            NabuccoMessageManager messageManager, EngineMaintenanceMultiPageEditView view) {
        super(messageManager, view, model);
    }

    @Override
    protected void registerPages(DetailsPart arg0) {
    	Map<Class<? extends Datatype>, Set<String>> typeToInvisiblePropertiesMap = this.getTypeToInvisiblePropertiesMap();
    	
    	Set<String> readOnlyProperties = new HashSet<String>();
    	Set<String> invisibleProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
    	
        detailsPart.registerPage(TestEngineConfiguration.class, new TestEngineConfigurationDetailPageView(this, getManagedForm(),
                getManagedFormViewPart(), nabuccoMessageManager, ID, ID + ".TestEngineConfiguration",
                invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(TestEngineConfiguration.class, invisibleProperties);
        
        detailsPart.registerPage(ProxyConfiguration.class, new TestautomationDetailPageView<EngineMaintenanceMultiPageEditViewModel>(this, getManagedForm(),
                getManagedFormViewPart(), nabuccoMessageManager, ID, ID + ".ProxyConfiguration",
                invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(ProxyConfiguration.class, invisibleProperties);
        
        detailsPart.registerPage(ConfigurationProperty.class, new TestautomationDetailPageView<EngineMaintenanceMultiPageEditViewModel>(this, getManagedForm(),
                getManagedFormViewPart(), nabuccoMessageManager, ID, ID + ".ConfigurationProperty",
                invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(ConfigurationProperty.class, invisibleProperties);

    }

    /**
     * {@inheritDoc}
     * 
     * @return
     */
    protected MasterDetailBlockLayouter<EngineMaintenanceMultiPageEditViewModel> getLayouter() {
        return new EngineMaintenanceMasterDetailBlockLayouter();
    }

}
