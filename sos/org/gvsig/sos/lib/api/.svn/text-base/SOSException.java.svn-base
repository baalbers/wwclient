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

import org.gvsig.tools.exception.BaseException;

/**
 * @author <a href="mailto:pupo@uji.es">Luis E. Rodríguez</a>
 * @version $Id$
 *
 */
public class SOSException extends BaseException{
    
	private static final long serialVersionUID = 4490793411471895526L;

    private static final String MESSAGE =
        "An error has been produced in the SOS library";

    private static final String KEY = "_SOSException";

    protected SOSException(Throwable cause)
    {
        super(MESSAGE, cause, KEY, serialVersionUID);
    }
    
    protected SOSException(String message, String key, long code) {
        super(message, key, code);
    }
    
    protected SOSException(String message, Throwable cause,
            String key, long code) {
       super(message, cause, key, code);
    }
}
