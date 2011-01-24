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

import java.util.Arrays;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.copypaste.CopyPasteHandler;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.EngineMaintenanceMasterDetailTreeNodeCreator;


public class EngineCopyPasteHandler implements CopyPasteHandler {

	private EngineMaintenanceMasterDetailTreeNodeCreator treeNodeCreator;

	public EngineCopyPasteHandler(){
		this.treeNodeCreator = new EngineMaintenanceMasterDetailTreeNodeCreator();
	}

	@Override
	public void paste(MasterDetailTreeNode targetNode,
			Datatype copiedDatatype) {

		Class<? extends Datatype>[] possibleChildren = EngineDataModelManager.getPossibleChildrenTypes(targetNode.getDatatype());
		if(Arrays.asList(possibleChildren).contains(copiedDatatype.getClass())){
			Datatype targetDatatype = targetNode.getDatatype();
			Datatype clone;
			if(targetDatatype instanceof TestEngineConfiguration){
				if(copiedDatatype instanceof ProxyConfiguration){
					ProxyConfiguration copiedProxyConfiguration = (ProxyConfiguration) copiedDatatype;
					copiedProxyConfiguration.setId(null);
					clone = EngineElementFactory.cloneProxyConfiguration(copiedProxyConfiguration);	
					((TestEngineConfiguration) targetDatatype).getProxyConfigurations().add((ProxyConfiguration) clone);
				} else {
					return;
				}
			} else if(targetDatatype instanceof ProxyConfiguration){
				if(copiedDatatype instanceof ConfigurationProperty){
					ConfigurationProperty copiedConfigurationProperty = (ConfigurationProperty) copiedDatatype;
					copiedConfigurationProperty.setId(null);
					clone = EngineElementFactory.cloneConfigurationProperty(copiedConfigurationProperty);	
					((ProxyConfiguration) targetDatatype).getConfigurationProperties().add((ConfigurationProperty) clone);
				} else {
					return;
				}
			} else {
				return;
			}

			// Update target TreeNode
			MasterDetailTreeNode newNode = treeNodeCreator.createNodeTyped(clone, targetNode, null);
			targetNode.getChildren().add(newNode);
			newNode.setViewModel(targetNode.getViewModel());
			// Update target DatatypeState
			if(targetDatatype.getDatatypeState() == DatatypeState.PERSISTENT){
				targetDatatype.setDatatypeState(DatatypeState.MODIFIED);
			}
		}

	}

}
