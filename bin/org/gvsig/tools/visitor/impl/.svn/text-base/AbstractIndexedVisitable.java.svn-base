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
package org.gvsig.tools.visitor.impl;

import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.visitor.IndexedVisitable;
import org.gvsig.tools.visitor.VisitCanceledException;
import org.gvsig.tools.visitor.Visitable;
import org.gvsig.tools.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base implementation for {@link Visitable} classes.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public abstract class AbstractIndexedVisitable extends AbstractVisitable
		implements IndexedVisitable {

	private static final Logger LOG =
			LoggerFactory.getLogger(AbstractIndexedVisitable.class);

	public final void accept(Visitor visitor, long firstValueIndex)
			throws BaseException {
		try {
			doAccept(visitor, firstValueIndex);
		} catch (VisitCanceledException ex) {
			// The visit has been cancelled by the visitor, so we finish here.
			LOG.debug(
					"The visit, beggining on position {}, has been cancelled by the visitor: {}",
					new Long(firstValueIndex), visitor);
		}
	}

	protected void doAccept(Visitor visitor) throws VisitCanceledException,
			BaseException {
		doAccept(visitor, 0);
	}

	/**
	 * Provides each value of this container to the provided {@link Visitor}.
	 * The {@link VisitCanceledException} will be managed by the parent
	 * {@link AbstractIndexedVisitable} class, so simply throw it.
	 */
	protected abstract void doAccept(Visitor visitor, long firstValueIndex)
			throws VisitCanceledException, BaseException;

}