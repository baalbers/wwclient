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
 * Exception thrown when a visit of a {@link Visitor} is cancelled.
 * <p>
 * This exception must be catched by a {@link Visitable} when is processing a
 * {@link Visitor} and cancel the process.
 * </p>
 * <p>
 * A {@link Visitor} must throw this exception if it wants to cancel a visit in
 * progress.
 * </p>
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public class VisitCanceledException extends BaseException {

	private static final long serialVersionUID = 7551988965463140258L;

	private static final String KEY = "_VisitCanceledException";

	private static final String DEFAULT_MESSAGE = "Visit canceled";

	/**
	 * Creates a new {@link VisitCanceledException}.
	 */
	public VisitCanceledException() {
		super(DEFAULT_MESSAGE, KEY, serialVersionUID);
	}

	/**
	 * Creates a new {@link VisitCanceledException} with a cause.
	 * 
	 * @param cause
	 *            of the exception
	 */
	public VisitCanceledException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause, KEY, serialVersionUID);
	}

}