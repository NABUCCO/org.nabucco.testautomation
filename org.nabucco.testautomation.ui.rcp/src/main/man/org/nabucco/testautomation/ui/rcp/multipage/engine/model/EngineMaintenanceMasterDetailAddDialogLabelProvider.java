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

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;


public class EngineMaintenanceMasterDetailAddDialogLabelProvider extends AddDialogLabelProvider {

    @Override
    public String getText(Object obj) {
        String result = null;
        if (obj instanceof TestEngineConfiguration) {
        	TestEngineConfiguration element = (TestEngineConfiguration) obj;
            DatatypeState datatypeState = element.getDatatypeState();
            if (datatypeState != DatatypeState.INITIALIZED) {
                result = element.getName().getValue();
            } else {
                result = I18N.i18n(element.getClass().getCanonicalName());
            }
        } else if (obj instanceof ProxyConfiguration) {
        	ProxyConfiguration element = (ProxyConfiguration) obj;
            DatatypeState datatypeState = element.getDatatypeState();
            if (datatypeState != DatatypeState.INITIALIZED) {
                if(element.getName() != null){
                	result = element.getName().getValue();
                }
            } else {
                result = I18N.i18n(element.getClass().getCanonicalName());
            }
        }else  if (obj instanceof ConfigurationProperty) {
        	ConfigurationProperty element = (ConfigurationProperty) obj;
            DatatypeState datatypeState = element.getDatatypeState();
            if (datatypeState != DatatypeState.INITIALIZED) {
                result = element.getName().getValue();
            } else {
                result = I18N.i18n(element.getClass().getCanonicalName());
            }
        } 
        if (result == null) {
            result = I18N.i18n(obj.getClass().getCanonicalName());
        }
        return result;
    }

}
