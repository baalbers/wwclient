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
* 2009 {}  {{Task}}
*/
package org.gvsig.tools.service;

import org.gvsig.tools.dynobject.DynObject;

/**
 * Creates parameters for services and services themselves.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public interface Manager {

	/**
	 * Creates a new object to contain service parameters values.
	 * 
	 * @param serviceName
	 *            the name of the service whose parameters have to be created
	 * @return an empty parameters container
	 * @throws ServiceException
	 *             if there is not any service registered with the given name
	 */
	DynObject createServiceParameters(String serviceName)
			throws ServiceException;

	/**
	 * Creates a new {@link Service} based on the given parameters.
	 * 
	 * @param parameters
	 *            of the {@link Service} to create
	 * @return the new created {@link Service}
	 * @throws ServiceException
	 *             if there is an error creating the Service, or the parameters
	 *             are not valid
	 */
	Service getService(DynObject parameters) throws ServiceException;
}