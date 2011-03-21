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
package org.nabucco.testautomation.facade.datatype.visitor;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.facade.datatype.property.base.PropertyComposite;


/**
 * ModificationVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public final class PropertyModificationVisitor extends DatatypeVisitor {

    private final PropertyComposite property;

    /**
     * Creates a new {@link PropertyModificationVisitor} instance.
     * 
     * @param property
     *            the PropertyComposite to check for modification
     */
    public PropertyModificationVisitor(PropertyComposite property) {
        this.property = property;
    }

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype.getDatatypeState() == DatatypeState.INITIALIZED
                || datatype.getDatatypeState() == DatatypeState.MODIFIED
                || datatype.getDatatypeState() == DatatypeState.DELETED) {
        	this.property.setDatatypeState(DatatypeState.MODIFIED);
        } else {
            super.visit(datatype);
        }
    }
}