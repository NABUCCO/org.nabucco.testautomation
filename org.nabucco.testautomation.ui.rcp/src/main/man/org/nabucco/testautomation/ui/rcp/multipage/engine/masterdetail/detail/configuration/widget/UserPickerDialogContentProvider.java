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
package org.nabucco.testautomation.ui.rcp.multipage.engine.masterdetail.detail.configuration.widget;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.authorization.facade.datatype.AuthorizationUser;
import org.nabucco.framework.common.authorization.facade.message.AuthorizationUserListMsg;
import org.nabucco.framework.common.authorization.facade.message.search.AuthorizationSearchMsg;
import org.nabucco.framework.common.authorization.ui.rcp.communication.AuthorizationComponentServiceDelegateFactory;
import org.nabucco.framework.plugin.base.Activator;



/**
 * UserPickerDialogContentProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class UserPickerDialogContentProvider implements IStructuredContentProvider {

	private User[] users;
	
	@Override
	public void dispose() {
		// Cannot dispose table in dialog!
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // Cannot change table in dialog!
    }

	@Override
	public Object[] getElements(Object arg0) {
		if(users == null){
			List<AuthorizationUser> authorizationUserList;
			try {
				AuthorizationSearchMsg rq = new AuthorizationSearchMsg();
				AuthorizationUserListMsg rs = AuthorizationComponentServiceDelegateFactory.getInstance().getSearchAuthorization().searchAuthorizationUser(rq);
				authorizationUserList = rs.getAuthorizationUserList();
				users = authorizationUserList.toArray(new User[0]);
			} catch (ClientException e) {
				Activator.getDefault().logError(e);
				authorizationUserList = new ArrayList<AuthorizationUser>();
			}
		}
		return users;
	}

}
