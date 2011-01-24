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
package org.nabucco.testautomation.ui.rcp.model.property;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.testautomation.facade.datatype.property.PropertyList;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;


/**
 * DataModelManager
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class DataModelManager {


	public static void normalizeOrderIndicies(PropertyList propertyList, boolean recursively){
		List<PropertyContainer> propertyContainerList = propertyList.getPropertyList();
		for(int i = 0; i < propertyContainerList.size(); i ++){
			PropertyContainer propertyContainer = propertyContainerList.get(i);
			if(propertyContainer.getOrderIndex().getValue() != i){
				propertyContainer.setOrderIndex(i);
				if(propertyContainer.getDatatypeState() == DatatypeState.PERSISTENT){
					propertyContainer.setDatatypeState(DatatypeState.MODIFIED);
				}
			}
		}
		if(recursively){
			for (PropertyContainer propertyContainer : propertyContainerList) {
				Property property = propertyContainer.getProperty();
				if(property instanceof PropertyList){
					normalizeOrderIndicies((PropertyList) property, true);
				}
			}
		}
	}


}
