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
package org.nabucco.testautomation.impl.service;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.context.ServiceMessageContext;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;

public class DynamicCodeSupport {

	private static DynamicCodeSupport instance;

	private ResolveDynamicCode resolveDynamicCode;

	private DynamicCodeSupport() throws ConnectionException, ServiceException {
		DynamicCodeComponentLocator dynamicCodeComponentLocator = DynamicCodeComponentLocator.getInstance();
		DynamicCodeComponent dynamicCodeComponent = dynamicCodeComponentLocator.getComponent();
		this.resolveDynamicCode = dynamicCodeComponent.getResolveDynamicCode();
	}

	public static synchronized DynamicCodeSupport getInstance() throws ServiceException, ConnectionException {

		if (instance == null) {
			instance = new DynamicCodeSupport();
		}
		return instance;
	}

	public DynamicCodeCode searchDynamicCode(Long id, ServiceMessageContext ctx) throws ResolveException {

		DynamicCodeCode codeToResolve = new DynamicCodeCode();
		codeToResolve.setId(id);

		DynamicCodeCodeResolveRq rqMsg = new DynamicCodeCodeResolveRq();
		rqMsg.setCode(codeToResolve);

		ServiceRequest<DynamicCodeCodeResolveRq> rq = new ServiceRequest<DynamicCodeCodeResolveRq>(ctx);
		rq.setRequestMessage(rqMsg);
		ServiceResponse<DynamicCodeCodeResolveRs> rs = this.resolveDynamicCode.resolveDynamicCodeCode(rq);
		DynamicCodeCode rv = rs.getResponseMessage().getCode();
		return rv;
	}
}
