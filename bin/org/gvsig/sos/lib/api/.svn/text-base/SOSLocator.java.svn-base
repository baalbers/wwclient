package org.gvsig.sos.lib.api;
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

import org.gvsig.tools.locator.AbstractLocator;
import org.gvsig.tools.locator.Locator;
import org.gvsig.tools.locator.LocatorException;

/**
 * @author <a href="mailto:csanchez@prodevelop.es">Carlos Sánchez Periñan</a>
 * @version $Id$
 *
 */
public class SOSLocator extends AbstractLocator{

    private static SOSLocator _instance = new SOSLocator();
    private static final String LOCATOR_NAME = "SOS_LOCATOR";
    
    public static final String SOS_MANAGER = "SOS_MANAGER";
    private static final String SOS_DESCRIPTION = "Client for SOS Service";
    public static SOSLocator getInstance()
    {
        return _instance;
    }
    
    public String getLocatorName() {
        return LOCATOR_NAME;
    }
    
    /**
     * Registers the Class {@link SOSManager} .
     *
     * @param clazz
     *            
     */
    @SuppressWarnings(value = { "rawtypes" })
    public static void registerSOSManager(Class clazz) {
        if(!SOSManager.class.isAssignableFrom(clazz))
        {
            throw new IllegalArgumentException(clazz.getName()
                    + " must implements the SwingDalTimeManager interface");
        }
            
            getInstance().register(SOS_MANAGER, 
                SOS_DESCRIPTION,
                    clazz);
    }
    
    /**
     * Return a reference to {@link SOSManager}.
     *
     * @return a reference to SOSRemoteClientManager
     * @throws LocatorException
     *             if there is no access to the class or the class cannot be
     *             instantiated
     * @see Locator#get(String)
     */
    public static SOSManager getSOSManager() throws LocatorException {
        return (SOSManager) getInstance().get(SOS_MANAGER);
    }

}
