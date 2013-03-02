/* gvSIG. Geographic Information System of the Valencian Government
 *
 * Copyright (C) 2007-2008 Infrastructures and Transports Department
 * of the Valencian Government (CIT)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 */

/*
 * AUTHORS (In addition to CIT):
 * 2008 {DiSiD Technologies}   {Create a base Locator implementation}
 */
package org.gvsig.tools;

import org.gvsig.tools.dataTypes.impl.DefaultDataTypesManager;
import org.gvsig.tools.dispose.impl.DefaultDisposableManager;
import org.gvsig.tools.dynobject.impl.DefaultDynObjectManager;
import org.gvsig.tools.i18n.impl.DummyI18nManager;
import org.gvsig.tools.library.AbstractLibrary;
import org.gvsig.tools.library.LibraryException;
import org.gvsig.tools.operations.impl.DefaultOperationManager;
import org.gvsig.tools.packageutils.impl.DefaultPackageManager;
import org.gvsig.tools.task.impl.DefaultTaskStatusManager;

/**
 * Tools library initialization.
 * 
 * @author 2010- Joaquin José del Cerro - gvSIG team
 * @author 2010- César Ordiñana - gvSIG team
 * 
 * @version $Id$
 */
public class ToolsLibrary extends AbstractLibrary {

	public void doRegistration() {
		super.doRegistration();
		registerAsAPI(ToolsLibrary.class);
	}
	
	protected void doInitialize() throws LibraryException {
		ToolsLocator
				.registerDefaultOperationManager(DefaultOperationManager.class);
		ToolsLocator.registerDefaultTaskStatusManager(DefaultTaskStatusManager.class);
		ToolsLocator.registerDynObjectManager(DefaultDynObjectManager.class);
		ToolsLocator.registerDisposableManager(DefaultDisposableManager.class);
		ToolsLocator.registerDefaultDataTypesManager(DefaultDataTypesManager.class);
		ToolsLocator.registerDefaultI18nManager(DummyI18nManager.class);
		ToolsLocator.registerDefaultPackageManager(DefaultPackageManager.class);
	}

	protected void doPostInitialize() throws LibraryException {
		// Nothing to do
	}
}