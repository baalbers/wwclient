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
package org.gvsig.timesupport;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dataTypes.DataTypesManager;
import org.gvsig.tools.library.AbstractLibrary;
import org.gvsig.tools.library.LibraryException;
import org.gvsig.tools.locator.ReferenceNotRegisteredException;

/**
 * Library for API initialization and configuration.
 * 
 * @author gvSIG team
 * @version $Id$
 */
public class TimeSupportLibrary extends AbstractLibrary {

    @Override
    protected void doInitialize() throws LibraryException {
        // Do nothing
    }

    @Override
    protected void doPostInitialize() throws LibraryException {
        // Validate there is any implementation registered.
        TimeSupportManager manager = TimeSupportLocator.getManager();
        if (manager == null) {
            throw new ReferenceNotRegisteredException(
                TimeSupportLocator.MANAGER_NAME, TimeSupportLocator
                    .getInstance());
        }       
       
    }

}
