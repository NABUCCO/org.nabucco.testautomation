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
package org.nabucco.testautomation.ui.rcp.images;

/**
 * Global Registry of all component images.
 * <p>
 * Used to register / create component images with
 * {@link org.nabucco.framework.plugin.base.layout.ImageProvider}.
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public enum TestautomationImageRegistry {

	ICON_DETAILS_DIALOG("icons/testautomation/detailsdialog.png", "/icons/detailsdialog.png"),

	ICON_ENGINE("icons/testautomation/engine.png", "/icons/engine.png"),
	
	ICON_PROXY("icons/testautomation/proxy.png", "/icons/proxy.png"),

	ICON_PROXY_DISABLED("icons/testautomation/disabled.png", "/icons/disabled.png"),
	
	ICON_PROPERTY("icons/text.png", "icons/text.png"),

	ICON_PROPERTY_LIST("icons/browser_list.png", "icons/browser_list.png"),

	ICON_PROPERTY_STRING("icons/text.png", "icons/text.png"),

	ICON_PROPERTY_NUMERIC("icons/calculator.png", "icons/calculator.png"),

	ICON_PROPERTY_XML("icons/xml.png", "icons/xml.png"),
	
	ICON_PROPERTY_XPATH("icons/xpath.png", "icons/xpath.png"),
	
	ICON_PROPERTY_DATE("icons/calendar.png", "icons/calendar.png"),

	ICON_PROPERTY_FILE("icons/file.png", "icons/file.png"),
	
	ICON_PROPERTY_BOOLEAN("icons/boolean.png", "icons/boolean.png"),
	
	ICON_PROPERTY_SQL("icons/sql.png", "icons/sql.png");
	
	/**
	 * The unique symbolic name of the image used to identify the image in the
	 * <code>ImageProvider</code>.
	 */
	private String id;

	/**
	 * The physical path of the image within the component JAR.
	 */
	private String resourcePath;

	private TestautomationImageRegistry(String id, String resourcePath) {
		this.id = id;
		this.resourcePath = resourcePath;
	}

	/**
	 * Gets the unique symbolic name of the image used to identify the image in
	 * the <code>ImageProvider</code>.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the physical path of the image within the component JAR.
	 * 
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}
}
