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
package org.nabucco.testautomation.impl.service.produce.clone;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Version;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;
import org.nabucco.testautomation.facade.datatype.property.base.Property;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyContainer;
import org.nabucco.testautomation.facade.datatype.visitor.TestEngineConfigurationVisitor;

/**
 * TestEngineConfigurationCloneVisitor
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestEngineConfigurationCloneVisitor extends TestEngineConfigurationVisitor{

	@Override
	public void visit(Datatype datatype) throws VisitorException {
		super.visit(datatype);
	}

	@Override
	protected void visit(TestEngineConfiguration element) throws VisitorException {
		resetDatatype(element);
		super.visit(element);
	}

	protected void visit(ConfigurationProperty testScript) throws VisitorException {
		resetDatatype(testScript);
		super.visit(testScript);
	}

	@Override
	protected void visit(ProxyConfiguration element) throws VisitorException {
		resetDatatype(element);
		super.visit(element);
	}

	protected void visit(Property property) throws VisitorException {
		resetDatatype(property);
		super.visit(property);
	}

	protected void visit(PropertyContainer property) throws VisitorException {
		resetDatatype(property);
		super.visit(property);
	}



	private void resetDatatype(NabuccoDatatype datatype) {
		datatype.setDatatypeState(DatatypeState.INITIALIZED);
        datatype.setVersion((Version) null);
        datatype.setId((Identifier) null);
	}

}
