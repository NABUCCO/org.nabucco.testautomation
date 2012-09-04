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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorImpl;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;


/**
 * EngineMaintenanceMasterDetailTreeNodeCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class EngineMaintenanceMasterDetailTreeNodeCreator extends
        MasterDetailTreeNodeCreatorImpl<Datatype> {

    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode createNodeTyped(final Datatype datatype,
            final MasterDetailTreeNode parent,
            final MasterDetailTreeNodeCreatorForAllDatatypes builder) {
        
    	MasterDetailTreeNode result = new MasterDetailTreeNode(datatype, parent);

        if (datatype instanceof TestEngineConfiguration) {
        	TestEngineConfiguration testEngineConfiguration = (TestEngineConfiguration) datatype;
            
        	for (ProxyConfiguration proxyConfiguration : testEngineConfiguration.getProxyConfigurations()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(proxyConfiguration, result);
                result.getChildren().add(child);
            }
        } else if(datatype instanceof ProxyConfiguration) {
        	ProxyConfiguration proxyConfiguration = (ProxyConfiguration) datatype;
            
        	for (ConfigurationProperty configurationProperty : proxyConfiguration.getConfigurationProperties()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(configurationProperty, result);
                result.getChildren().add(child);
            }
            
            // Add Decorator
            TreeNodeDecorator.decorateNode(result, proxyConfiguration);
        }
        
        return result;
    }

}
