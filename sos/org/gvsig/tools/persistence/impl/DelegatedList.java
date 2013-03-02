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
package org.gvsig.tools.persistence.impl;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;

/**
 * @author jmvivo 2009
 * @author jjdelcerro 2010
 * 
 */
public class DelegatedList extends DelegatedCollection implements List {

	private List delegated;

	public DelegatedList(List delegated,
			PersistenceManagerServices manager, PersistentContextServices context) {
		super(delegated, manager, context);
		this.delegated = delegated;
	}

	/* (non-Javadoc)
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int arg0, Object arg1) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int arg0, Collection arg1) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.List#get(int)
	 */
	public Object get(int index) {
		return this.getObject(delegated.get(index));
	}

	/* (non-Javadoc)
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return delegated.indexOf(this.getWrapper(o));
	}

	/* (non-Javadoc)
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return delegated.lastIndexOf(this.getWrapper(o));
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	public ListIterator listIterator() {
		return  this.getWrappedIterator(delegated.listIterator());
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator listIterator(int index) {
		return this.getWrappedIterator(delegated.listIterator(index));
	}

	/* (non-Javadoc)
	 * @see java.util.List#remove(int)
	 */
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public Object set(int arg0, Object arg1) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.List#subList(int, int)
	 */
	public List subList(int fromIndex, int toIndex) {
		return new DelegatedList(this.delegated.subList(fromIndex, toIndex),
				getManager(), getContext());
	}

}
