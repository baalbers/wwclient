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
package org.gvsig.tools.visitor;

import org.gvsig.tools.exception.BaseException;

/**
 * {@link Visitable} extension to add the option to start the visit begging from
 * a provided index.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public interface IndexedVisitable extends Visitable {

	/**
	 * Provides each value of this container to the provided {@link Visitor},
	 * beginning from the provided index position.
	 * 
	 * @param visitor
	 *            the visitor to apply to each value.
	 * @param firstValueIndex
	 *            index of first element to be visited by the {@link Visitor}
	 * @exception BaseException
	 *                if there is an error while performing the visit
	 */
	void accept(Visitor visitor, long firstValueIndex) throws BaseException;

}