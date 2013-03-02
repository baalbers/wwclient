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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;
import org.gvsig.tools.persistence.impl.exception.ObjectNotFoundException;
import org.gvsig.tools.persistence.impl.exception.PersistenceIDNotLoadedException;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentIdentifier;
import org.gvsig.tools.persistence.spi.PersistentStateServices;

public class DefaultPersistentContext implements PersistentContextServices {
	private static int IdentifiersCounter = 1; 

	private Map idToReference;
	private Map objToReference;
	private PersistentIdentifier rootId;
	private PersistenceManager manager;
	private boolean collectErrors;
	private PersistenceException errors;
	private boolean validated;

	public DefaultPersistentContext(PersistenceManager manager) {
		this.manager = manager;
		this.collectErrors = false;
		this.errors = null;
		this.validated = false;

		// Use LinkedHashMap for predictable order when save to a file
		this.idToReference = new LinkedHashMap(); 
		this.objToReference = new LinkedHashMap();
	}

	private class DefaultPersistentIdentifier implements PersistentIdentifier, Comparable {
		private String value;
		
		DefaultPersistentIdentifier(String value) {
			this.value = value;
		}
		
//		String getValue() {
//			return value;
//		}

		public boolean equals(Object obj) {
			if (!(obj instanceof DefaultPersistentIdentifier)) {
				return false;
			}
			return value == ((DefaultPersistentIdentifier) obj).value;
		}

		public boolean hasValue(Object value) {
			return this.value.equals(value);
		}
		
		public int hashCode() {
			return value.hashCode();
		}
		
		public String toString() {
			return value;
		}

		public int compareTo(Object obj) {
			if (!(obj instanceof DefaultPersistentIdentifier)) {
				return -1;
			}
			return value.compareTo( ((DefaultPersistentIdentifier) obj).value) ;
		}
	}
	
	private class ContextValue implements ObjectReference, Comparable {
		private Object obj;
		private PersistentState state;
		private PersistentIdentifier id;

		ContextValue(PersistentIdentifier id, PersistentState state) {
			this.id = id;
			this.state = state;
			this.obj = null;
		}
		
//		public void update() throws PersistenceException {
//			if( this.obj == null ) {
//				updateObjectInReference(this);
//			}
//		}

		public boolean hasObject() {
			return this.obj != null;
		}
		
//		public boolean hasState() {
//			return this.state != null;
//		}
		
		public Object getObject() {
			if( this.obj == null ) {
				try {
					updateObjectInReference(this);
				} catch (PersistenceException e) {
					throw new PersistenceRuntimeException(e);
				}
			}
			return this.obj;
		}
		
		public PersistentState getState() {
			return this.state;
		}
		
		public PersistentIdentifier getId() {
			return this.id;
		}

		protected void update(Object object) {
			this.obj = object;
		}
		
		public boolean equals(Object obj) {
			if (!(obj instanceof ContextValue)) {
				return false;
			}
			return id.equals(((ContextValue) obj).id);
		}

		public int hashCode() {
			return id.hashCode();
		}
		
		public String toString() {
			String idStr = id == null ? "null" : id.toString();
			return getClass().getName().concat(": id = ").concat(idStr);
		}

		public int compareTo(Object arg0) {
			if (!(obj instanceof ContextValue)) {
				return -1;
			}
			return ((DefaultPersistentIdentifier)id).compareTo(((ContextValue) obj).id);
		}

	}

	public PersistentIdentifier getNewIdentifier() {
		return new DefaultPersistentIdentifier(String.valueOf( IdentifiersCounter++));
	}
	
	public PersistentIdentifier getIdentifier(String id) throws PersistenceException {
		Iterator it = this.idToReference.values().iterator();
		while( it.hasNext() ) {
			ContextValue value = (ContextValue) it.next();
			if( ((DefaultPersistentIdentifier)(value.getId())).hasValue(id) ) {
				return value.getId();
			}
		}
		return new DefaultPersistentIdentifier(id);
	}
	
	public ObjectReference add(PersistentIdentifier id) throws PersistenceException  {
		this.validated = false;
		ContextValue value = (ContextValue) idToReference.get(id);
		if (value == null ) {
			value = new ContextValue(id, null);
			idToReference.put(value.getId(), value);
		}
		return value;
	}
	
	public ObjectReference add(PersistentState state, Object obj) throws PersistenceException  {
		this.validated = false;
		PersistentIdentifier id = ((PersistentStateServices)state).getId();
		ContextValue value = (ContextValue) idToReference.get(id);
		if (value == null ) {
			value = new ContextValue( id, state);
			idToReference.put(value.getId(), value);
		}
		if( value.getState() == null ) {
			value.state = state;
		}
		if( obj != null ) {
			value.update(obj);
			objToReference.put(obj,value);
		}
		return value;
	}
	
	public ObjectReference get(PersistentState state) throws PersistenceException {
		PersistentIdentifier id = ((PersistentStateServices)state).getId();
		ContextValue ref = (ContextValue) idToReference.get(id);
		if (ref == null ) {
			ref = new ContextValue(id, state);
			idToReference.put(id, ref);
		}
		return ref;
	}

	public ObjectReference get(PersistentIdentifier id) {
		ContextValue value = (ContextValue) idToReference.get(id);
		return value;
	}
	
	public ObjectReference get(Object obj) {
		return (ContextValue) objToReference.get(obj);
	}
	
	private void updateObjectInReference(ContextValue ref) throws PersistenceException {
		/*
		 * Note: this method is used by the inner class Reference.
		 */
		PersistentStateServices state = (PersistentStateServices) ref.getState();
		PersistenceFactory factory = manager.getFactories().get(state);

		// This can be done in two step to avoid cyclic references
		state.setFactory(factory);
		ref.update( factory.createFromState(state) );
		factory.loadFromState(state, ref.getObject());
		
		objToReference.put(ref.getObject(), ref);
	}
	
	public void update(ObjectReference ref) throws PersistenceException {
		this.validated = false;
		this.updateObjectInReference((ContextValue) ref);
	}

	private void updateAll() throws PersistenceException {
		Iterator it = idToReference.entrySet().iterator();
		while ( it.hasNext() ) {
			ContextValue ref = (ContextValue) ((Entry) it.next()).getValue();
			this.update(ref);
		}
	}

	public void clear() {
		this.validated = false;
		Iterator it = idToReference.entrySet().iterator();
		while ( it.hasNext() ) {
			ContextValue ref = (ContextValue) ((Entry) it.next()).getValue();
			ref.update(null);
		}
	}

	public Iterator iterator() {
		final class StatesIterator implements Iterator {
			private Iterator referenceIterator;

			StatesIterator(Map idToReference) {
				this.referenceIterator = idToReference.entrySet().iterator();
			}
			
//			StatesIterator(Map idToReference) {
//				List values = new ArrayList(); 
//				values.addAll(idToReference.values());
//				Collections.sort(values);
//				this.referenceIterator = values.iterator();
//			}
			
			public boolean hasNext() {
				return referenceIterator.hasNext();
			}
			public Object next() {
				ContextValue ref = (ContextValue) ((Entry) referenceIterator.next()).getValue();
//				ContextValue ref = (ContextValue) referenceIterator.next();
				return ref.getState();
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		return new StatesIterator(idToReference);
	}

	public PersistentState getState(Integer id)
			throws PersistenceException {
		ContextValue ref = (ContextValue) this.get(id);
		if (ref == null) {
			throw new PersistenceIDNotLoadedException(id);
		}
		return ref.getState();
	}

	public PersistentState getState(Object obj)
			throws PersistenceException {
		ContextValue ref = (ContextValue) this.get(obj);
		if (ref == null) {
			return null;
		}
		return ref.getState();
	}

	public Object getObject(Integer id) throws PersistenceException {
		ContextValue ref = (ContextValue) this.get(id);
		if (ref == null) {
			throw new PersistenceIDNotLoadedException(id);
		}
		return ref.getObject();
	}

	public PersistentIdentifier getId(Object obj) throws PersistenceException {
		ContextValue ref = (ContextValue) this.get(obj);
		if( ref != null ) {
			return ref.getId();
		}
		this.updateAll();
		ref = (ContextValue) this.get(obj);
		if (ref == null) {
			throw new ObjectNotFoundException();
		}
		return ref.getId();		
	}


	public void setRootId(PersistentIdentifier id) {
		this.rootId = id;
	}

	public ObjectReference getRoot() throws PersistenceException {
		ObjectReference root = this.get(this.rootId); 
		return  root;
	}

	public void setCollectErrors(boolean collectErrors) {
		this.collectErrors = collectErrors;
	}

	public boolean getCollectErrors() {
		return this.collectErrors;
	}

	public void addError(Throwable cause) {
		if( this.errors == null ) {
			this.errors = new PersistenceException();
		}
		this.errors.add(cause);
	}

	public PersistenceException getErrors() {
		return this.errors;
	}

	public void validate(int mode) throws PersistenceValidateExceptions {
		if( this.validated ) {
			return;
		}
		List exceptions = new ArrayList();

		Iterator it = this.iterator();
		while( it.hasNext() ) {
			PersistentState astate = (PersistentState) it.next();
			try {
				this.manager.validate(astate,mode);
			} catch(Exception e) {
				exceptions.add(e);
			}
		}

		this.validated=true;
		if (exceptions.size() > 0) {
			throw  new PersistenceValidateExceptions(exceptions);
		}		
	}
}
