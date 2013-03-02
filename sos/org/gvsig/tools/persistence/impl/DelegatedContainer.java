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

package org.gvsig.tools.persistence.impl;

import java.util.Map.Entry;

import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices.ObjectReference;


public class DelegatedContainer {

	private PersistentContextServices context;
	private PersistenceManagerServices manager;

	public DelegatedContainer(PersistenceManagerServices manager,
			PersistentContextServices context) {
		this.manager = manager;
		this.context = context;
	}

	protected PersistenceManagerServices getManager() {
		return this.manager;
	}

	protected PersistentContextServices getContext() {
		return this.context;
	}

	private class WrappedEntry implements Entry {

		private Entry entry;

		public WrappedEntry(Entry entry) {
			this.entry = entry;
		}

		public Object getKey() {
			return getObject(entry.getKey());
		}

		public Object getValue() {
			return getObject(entry.getValue());
		}

		public Object setValue(Object arg0) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Get the object associated to the object reference passed as
	 * parameter.
	 * 
	 * If the object passed as parameter is not a object reference,
	 * the it is returned as is.
	 * 
	 * @param  object 
	 * @return object references by the parameter or it self.
	 */
	protected Object getObject(Object wrapper) {
		if (wrapper instanceof ObjectReference) {
			ObjectReference ref = (ObjectReference) wrapper;
			return ref.getObject();
		} else if (wrapper instanceof Entry) {
			return new WrappedEntry((Entry) wrapper);
		}
		return wrapper;
	}

	/**
	 * Get a object reference associated to the object
	 * passed as parameter. If the object don't have a
	 * object-reference associated, then the object it self
	 * is returned.
	 * 
	 * @param obj
	 * @return
	 */
	protected Object getWrapper(Object obj) {
		ObjectReference ref = context.get(obj);
		if( ref == null ) {
			// The object don't exists in context,
			// return the object it self.
			return obj;
		}
		return ref;
	}


}
