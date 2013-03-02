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
package org.gvsig.tools.persistence.exception;


/**
 * @author jmvivo
 *
 */
public class PersistenceClassNotRegistered extends PersistenceException {


	/**
	 *
	 */
	private static final long serialVersionUID = -5117203477405844983L;
	private final static String MESSAGE_FORMAT = "Class not registered in manager '%(class)'.";
	private final static String MESSAGE_KEY = "_PersistenceClassNotRegistered";

	public PersistenceClassNotRegistered(Class theClass) {
		this(theClass.getName());
	}

	public PersistenceClassNotRegistered(String theClass){
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("class", theClass);
	}

}
