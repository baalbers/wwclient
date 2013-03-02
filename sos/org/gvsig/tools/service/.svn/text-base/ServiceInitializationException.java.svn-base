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
 * Exception thrown when there is an error while initializing a service.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public class ServiceInitializationException extends ServiceException {

	private static final long serialVersionUID = -2239943565331174126L;
	private static final String KEY = "_ServiceInitializationException";
	private static final String MESSAGE =
			"Error initializing service with parameters: %(serviceParameters)";

	/**
	 * Creates a new {@link ServiceInitializationException} with the parameters
	 * of the service being initialized.
	 * 
	 * @param serviceParameters
	 *            of the service being initialized
	 * @param cause
	 *            original cause of the exception
	 */
	public ServiceInitializationException(DynObject serviceParameters,
			Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
		setValue("serviceParameters", serviceParameters);
	}

}