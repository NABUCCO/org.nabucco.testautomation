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
package org.nabucco.testautomation.facade.datatype.comparator;
/*
 * Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved. Created 30.09.2010
 */


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;


/**
 * PropertySorter
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class PropertySorter implements
		Comparator<PropertyContainer> {

	public void sort(Property property) {
		
		if (property instanceof PropertyComposite) {
			PropertyComposite propertyComposite = (PropertyComposite) property;
			List<PropertyContainer> propertyList = propertyComposite.getPropertyList();
			Collections.sort(propertyList, this);
		
			for (PropertyContainer propertyContainer : propertyList) {
				this.sort(propertyContainer.getProperty());
			}
		}
	}
	
	@Override
	public int compare(PropertyContainer o1,
			PropertyContainer o2) {

		if (o1 != null && o2 != null && o1.getOrderIndex() != null
				&& o2.getOrderIndex() != null) {
			int order1 = o1.getOrderIndex().getValue();
			int order2 = o2.getOrderIndex().getValue();

			return order1 - order2;
		}
		return 0;
	}

}
