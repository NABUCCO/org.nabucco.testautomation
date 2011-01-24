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
package org.nabucco.testautomation.ui.rcp.multipage.engine.model.clone;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.CloneDatatypeMenuItemCloner;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.ui.rcp.multipage.engine.model.EngineElementFactory;


public class EngineCloner implements CloneDatatypeMenuItemCloner {

	@Override
	public Datatype clone(Datatype datatype) {
		if (datatype instanceof ProxyConfiguration) {
			return EngineElementFactory.cloneProxyConfiguration((ProxyConfiguration) datatype);
		} else {
			Activator.getDefault().logError("No cloning implemented for:" + datatype);
		}
		return null;
	}

}