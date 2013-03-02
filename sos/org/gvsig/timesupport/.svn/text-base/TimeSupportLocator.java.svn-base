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

import org.gvsig.tools.locator.BaseLocator;
import org.gvsig.tools.locator.Locator;
import org.gvsig.tools.locator.LocatorException;

/**
 * This locator is the entry point for the TimeSupport library, providing
 * access to all TimeSupport services through the {@link TimeSupportManager}
 * .
 * 
 * @author gvSIG team
 * @version $Id$
 */
public class TimeSupportLocator extends BaseLocator {

    /**
     * TimeSupport manager name.
     */
    public static final String MANAGER_NAME = "TimeSupport.manager";

    /**
     * TimeSupport manager description.
     */
    public static final String MANAGER_DESCRIPTION = "TimeSupport Manager";

    private static final String LOCATOR_NAME = "TimeSupport.locator";

    /**
     * Unique instance.
     */
    private static final TimeSupportLocator INSTANCE =
        new TimeSupportLocator();

    /**
     * Return the singleton instance.
     * 
     * @return the singleton instance
     */
    public static TimeSupportLocator getInstance() {
        return INSTANCE;
    }

    /**
     * Return the Locator's name.
     * 
     * @return a String with the Locator's name
     */
    public final String getLocatorName() {
        return LOCATOR_NAME;
    }

    /**
     * Return a reference to the TimeSupportManager.
     * 
     * @return a reference to the TimeSupportManager
     * @throws LocatorException
     *             if there is no access to the class or the class cannot be
     *             instantiated
     * @see Locator#get(String)
     */
    public static TimeSupportManager getManager() throws LocatorException {
        return (TimeSupportManager) getInstance().get(MANAGER_NAME);
    }

    /**
     * Registers the Class implementing the TimeSupportManager interface.
     * 
     * @param clazz
     *            implementing the TimeSupportManager interface
     */
    public static void registerManager(
        Class<? extends TimeSupportManager> clazz) {
        getInstance().register(MANAGER_NAME, MANAGER_DESCRIPTION, clazz);
    }

}
