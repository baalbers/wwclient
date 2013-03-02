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
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;

/**
 * @author jmvivo 2009
 * @author jjdelcerro 2010
 *
 */
public class DelegatedMap extends DelegatedContainer implements Map {

	private Map delegated;

	/**
	 * @param delegated
	 * @param manager
	 * @param context
	 */
	public DelegatedMap(Map delegated,
			PersistenceManagerServices manager, PersistentContextServices context) {
		super(manager, context);
		this.delegated = delegated;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return delegated.containsKey(this.getWrapper(key));
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		return delegated.containsKey(this.getWrapper(value));
	}

	/* (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	public Set entrySet() {
		return new DelegatedSet(delegated.entrySet(), getManager(),
				getContext());
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(Object key) {
		return this.getObject(delegated.get(this.getObject(key)));
	}

	/* (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	public Set keySet() {
		return new DelegatedSet(delegated.keySet(), getManager(), getContext());
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object arg0, Object arg1) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map arg0) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	public Collection values() {
		return new DelegatedCollection(delegated.values(), getManager(),
				getContext());
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean isEmpty() {
		return delegated.isEmpty();
	}

	public Object remove(Object key) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		return delegated.size();
	}

}
