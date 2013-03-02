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


/**
 *
 */
package org.gvsig.tools.persistence.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;

/**
 * @author jmvivo
 *
 */
public class DelegatedCollection extends DelegatedContainer implements
		Collection {

	private Collection delegated;

	public DelegatedCollection(Collection delegated,
			PersistenceManagerServices manager, PersistentContextServices context) {
		super(manager, context);
		this.delegated = delegated;
	}

	public boolean add(Object arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean contains(Object o) {
		return delegated.contains(getWrapper(o));
	}

	public boolean containsAll(Collection arg0) {
		Iterator iter = arg0.iterator();
		while (iter.hasNext()) {
			if (!this.contains(iter.next())) {
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		return delegated.isEmpty();
	}

	public Iterator iterator() {
		return this.getWrappedIterator(delegated.iterator());
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}


	public Object[] toArray() {
		Object[] r = new Object[size()];
		Iterator iter = iterator();
		int i = 0;
		while (iter.hasNext()) {
			r[i] = iter.next();
			i++;
		}
		return r;
	}

	public Object[] toArray(Object[] a) {
    	int size = size();
		if (a.length < size) {
			a = (Object[]) java.lang.reflect.Array.newInstance(a.getClass()
					.getComponentType(), size);
		}
		Iterator iter = iterator();
		int i = 0;
		while (iter.hasNext()) {
			a[i] = iter.next();
			i++;
		}

		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	public int size() {
		return delegated.size();
	}

	protected ListIterator getWrappedIterator(Iterator iterator) {
		class DelegatedIterator implements ListIterator {

			private Iterator delegated;
			private ListIterator delegatedListIterator;

			public DelegatedIterator(Iterator deletaged) {
				this.delegated = deletaged;
				if (deletaged instanceof ListIterator) {
					this.delegatedListIterator = (ListIterator) deletaged;
				}
			}

			public boolean hasNext() {
				return delegated.hasNext();
			}

			public Object next() {
				return getObject(delegated.next());
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public void add(Object arg0) {
				throw new UnsupportedOperationException();

			}

			public boolean hasPrevious() {
				if (delegatedListIterator == null) {
					throw new UnsupportedOperationException();
				}
				return delegatedListIterator.hasPrevious();
			}

			public int nextIndex() {
				if (delegatedListIterator == null) {
					throw new UnsupportedOperationException();
				}
				return delegatedListIterator.nextIndex();
			}

			public Object previous() {
				if (delegatedListIterator == null) {
					throw new UnsupportedOperationException();
				}
				return getObject(delegatedListIterator.previous());
			}

			public int previousIndex() {
				if (delegatedListIterator == null) {
					throw new UnsupportedOperationException();
				}
				return delegatedListIterator.previousIndex();
			}

			public void set(Object arg0) {
				throw new UnsupportedOperationException();
			}
		}
		return new DelegatedIterator(iterator);
	}

	
}
