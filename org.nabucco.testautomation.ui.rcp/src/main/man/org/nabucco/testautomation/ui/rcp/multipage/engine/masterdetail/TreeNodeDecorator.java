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

import java.util.Map;

import org.eclipse.jface.viewers.IDecoration;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.images.TestautomationImageRegistry;

/**
 * TreeNodeDecorator
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class TreeNodeDecorator {

	public static void decorateNode(MasterDetailTreeNode node, ProxyConfiguration proxyConfiguration) {
		
		// Disabled ProxyConfigurations should be decorated
		if (proxyConfiguration != null) {
			Map<Integer, String> decorations = node.getDecorations();
			
			if (proxyConfiguration.getEnabled() == null || proxyConfiguration.getEnabled().getValue() == null
					|| !proxyConfiguration.getEnabled().getValue().booleanValue()) {
				if (!decorations.containsKey(IDecoration.TOP_LEFT)) {
					decorations.put(IDecoration.TOP_LEFT, TestautomationImageRegistry.ICON_PROXY_DISABLED.getId());
				}
			} else {
				if (decorations.containsKey(IDecoration.TOP_LEFT)) {
					decorations.remove(IDecoration.TOP_LEFT);
				}
			}
		}
	}

}
