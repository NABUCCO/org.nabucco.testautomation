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
package org.nabucco.testautomation.facade.datatype.visitor;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ConfigurationProperty;
import org.nabucco.testautomation.facade.datatype.engine.proxy.ProxyConfiguration;


/**
 * TestEngineConfigurationVisitor
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestEngineConfigurationVisitor extends DatatypeVisitor {

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype instanceof TestEngineConfiguration) {
            this.visit((TestEngineConfiguration) datatype);
        } else if (datatype instanceof ProxyConfiguration) {
            this.visit((ProxyConfiguration) datatype);
        } else if (datatype instanceof ConfigurationProperty) {
            this.visit((ConfigurationProperty) datatype);
        }
        super.visit(datatype);
    }

    /**
     * Visit {@link TestEngineConfiguration} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(TestEngineConfiguration element) throws VisitorException {
    }

    /**
     * Visit {@link ProxyConfiguration} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(ProxyConfiguration element) throws VisitorException {
    }

    /**
     * Visit {@link ConfigurationProperty} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(ConfigurationProperty element) throws VisitorException {
    }
    
}
