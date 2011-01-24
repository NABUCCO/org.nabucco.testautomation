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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.widget;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.plugin.base.layout.ImageProvider;


/**
 * UserPickerDialogLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class UserPickerDialogLabelProvider implements ILabelProvider {

	private static final String ICON_USER = "icons/person.png";

	@Override
	public void dispose() {
	}

	@Override
	public void addListener(ILabelProviderListener arg0) {
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof User) {
			return ImageProvider.createImage(ICON_USER);
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof User) {
			User user = (User) element;
			if (user.getUsername() != null) {
				return user.getUsername().getValue();
			}
		}
		return null;
	}

}
