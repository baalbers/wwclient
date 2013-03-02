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
 * Interface for objects which are able to visit a {@link Visitable} object.
 * 
 * @author 2008-2009 José Manuel Vivó
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public interface Visitor {

	/**
	 * Visits one of the objects provided by a {@link Visitable}.
	 * 
	 * @param obj
	 *            the object to perform the action with
	 * @throws VisitCanceledException
	 *             thrown if the visit ha to be cancelled by the
	 *             {@link Visitable}
	 * @throws BaseException
	 *             if there is an error performing the visit
	 */
	public void visit(Object obj) throws VisitCanceledException, BaseException;
}