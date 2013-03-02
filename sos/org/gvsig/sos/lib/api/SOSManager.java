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
package org.gvsig.sos.lib.api;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

import org.gvsig.sos.lib.api.client.SOSClient;

/**
 * Register and Instance all SOS Client classes
 * @author <a href="mailto:csanchez@prodevelop.es">Carlos Sánchez Periñan</a>
 * @version $Id$
 *
 */
public interface SOSManager {
   
    /**
     * Register SOSClient class
     * @param clazz
     */
    public void registerSOSClient(@SuppressWarnings("rawtypes") Class clazz);
    
    /**
     * Create a SOSClient instance with a host
     * @param host
     * @return
     * @throws ConnectException
     * @throws IOException
     * @throws SOSException
     */
    public SOSClient createSOSClient(URL host, File cacheFolder) throws SOSException;
}
