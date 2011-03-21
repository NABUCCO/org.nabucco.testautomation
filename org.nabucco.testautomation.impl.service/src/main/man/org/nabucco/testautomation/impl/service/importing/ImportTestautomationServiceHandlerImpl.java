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
package org.nabucco.testautomation.impl.service.importing;

import org.nabucco.framework.base.facade.datatype.importing.ImportContainer;
import org.nabucco.framework.base.facade.datatype.importing.ImportContext;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.testautomation.facade.service.importing.BasicImporter;


/**
 * ImportTestautomationServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ImportTestautomationServiceHandlerImpl extends
		ImportTestautomationServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected ImportRs importTestautomation(ImportRq msg)
			throws ImportException {
		
		long start = System.currentTimeMillis();
		getLogger().info("Start importing Property ...");
        ImportContext importContext = msg.getImportContext();
        ImportContainer container = msg.getContainer();

        ImportRs result = new ImportRs();
        result.setImportContext(importContext);

        BasicImporter importer = new PropertyImporter(this.getEntityManager(), importContext);
        importer.handleImport(container);
        getLogger().info("Finished importing of Property. Duration: " + (System.currentTimeMillis() - start) + " ms");
        
        return result;
	}
	
}