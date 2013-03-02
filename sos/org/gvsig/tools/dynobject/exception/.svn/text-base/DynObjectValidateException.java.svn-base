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
* 2009 IVER T.I   {{Task}}
*/

/**
 *
 */
package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.exception.ListBaseException;

/**
 * @author jmvivo
 *
 */
public class DynObjectValidateException extends ListBaseException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3935895993135692900L;
	private final static String MESSAGE_FORMAT = "Errors found validating '%(name)'.";
	private final static String MESSAGE_KEY = "_DynObjectValidateException";

	public DynObjectValidateException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("name", name);
	}
	

}
