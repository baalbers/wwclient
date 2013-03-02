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
package org.gvsig.tools.visitor;

import org.gvsig.tools.exception.BaseException;

/**
 * Exception thrown when a {@link Visitor} is provided with an object not
 * supported.
 * 
 * @author 2009- Jorge Piera Llodrá (jorge.piera@iver.es)
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public class NotSupportedOperationException extends BaseException{

	private static final long serialVersionUID = -2240464016042818342L;

	private static final String KEY = "geometries_reader_not_exists";
	private static final String MESSAGE =
			"The visitor %(visitor) doesn't implements any "
					+ "operation for the object %(object)";

	/**
	 * Creates a new {@link NotSupportedOperationException}.
	 * 
	 * @param visitor
	 *            the visitor which not supports the object
	 * @param object
	 *            the visited unsupported object
	 */
	public NotSupportedOperationException(Visitor visitor, Object object){
		super(MESSAGE, KEY, serialVersionUID);
		setValue("visitor", visitor);
		setValue("object", object);
	}

}