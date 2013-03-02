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

package org.gvsig.tools.persistence.spi;


import org.gvsig.tools.persistence.PersistentContext;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;

public interface PersistentContextServices extends PersistentContext {


	public interface ObjectReference {
		
		/**
		 * Return the persistent identifier associated to the
		 * object reference.
		 * 
		 * @return the persistent identifier as PersistentIdentifier. 
		 */
		public PersistentIdentifier getId();
		
		/**
		 * Return the object associated to the object reference.
		 * If the object reference don't has an object associated
		 * then create if from the state, associate to the reference
		 * and return it..
		 * 
		 * @return object.
		 */
		public Object getObject();
		
		/**
		 * Return true if the reference has an object associated.
		 * 
		 * @return
		 */
		public boolean hasObject();
		
		/**
		 * Return the state associated to this object reference.
		 *  
		 * @return the state as a PersistentState.
		 */
		public PersistentState getState();
	}
	
	public void setRootId(PersistentIdentifier id);

	public ObjectReference getRoot() throws PersistenceException;

	/**
	 * Return the object reference associated to the id indicated
	 * as parameter.
	 * 
	 * Can't create a new object reference for the passed object
	 * if it not exists. If not has object reference associated to the
	 * id passed return null.
	 * 
	 * @param id
	 * @return the object reference or null.
	 */
	public ObjectReference get(PersistentIdentifier id);
	
	/**
	 * Return the object reference associated to the object 
	 * passed as parameter.
	 * 
	 * Can't create a new object reference for the passed object
	 * if it not exists. If not has object reference associated to the
	 * id passed return null.
	 *  
	 * @param obj
	 * @return the object reference or null.
	 */
	public ObjectReference get(Object obj);

	
	/**
	 * Return the object reference associated to the state passed as parameter.
	 * If not exists an object reference associated to the state, then a new
	 * object reference is created, registered and returned.
	 * 
	 * Don't modify or update the object in the reference, it can be null.
	 *  
	 * @param state
	 * @return
	 * @throws PersistenceException
	 */
	public ObjectReference get(PersistentState state) throws PersistenceException ;

	/**
	 * Update the object referenced by ref, recreating it with this 
	 * state,
	 * 
	 * @param ref
	 * @throws PersistenceException
	 */
	public void update(ObjectReference ref) throws PersistenceException;


	/**
	 * Add a reference to the object associated to the state.
	 * If reference already exits and obj not is null, it is updated
	 * with obj.
	 * 
	 * If obj is null, the add the object reference with the state
	 * and the object to null.
	 * 
	 * Return the created or updated object reference. 
	 *  
	 * @param state
	 * @param obj
	 * @return the object reference.
	 * @throws PersistenceException
	 */
	public ObjectReference add(PersistentState state, Object obj) throws PersistenceException;
	
	/**
	 * Add a new reference associated to the identifier passed as 
	 * parameter.
	 * If already exists an object reference for this id, return this.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public ObjectReference add(PersistentIdentifier id) throws PersistenceException ;
	
	/**
	 * Clear the instances of references previously recreated
	 *
	 */
	public void clear();

	/**
	 * @deprecated
	 */
	public PersistentState getState(Integer id) throws PersistenceException;

	/**
	 * @deprecated
	 */
	public PersistentState getState(Object obj) throws PersistenceException;

	/**
	 * Return the id associated to the object passed as parameter.
	 * If object is not loaded, all objects in context are loaded.
	 * 
	 * @param obj
	 * @return id of the object.
	 * @throws PersistenceException
	 * @deprecated
	 */
	public PersistentIdentifier getId(Object obj) throws PersistenceException;

	/**
	 * @deprecated
	 */
	public Object getObject(Integer id) throws PersistenceException;

	/**
	 * Get a valid new persistent identifier.
	 * 
	 * @return the identifier
	 */
	public PersistentIdentifier getNewIdentifier();
	
	/**
	 * Create a new identifier based on the string passed as parameter
	 * and return this. 
	 *
	 * Throws a exception if the identifier passed as parameter has
	 * conflict with another identifier.
	 * 
	 * @param id
	 * @return
	 * @throws PersistenceException
	 */
	public PersistentIdentifier getIdentifier(String id) throws PersistenceException;

	/**
	 * Set flag to collect errors. If this flags is true, 
	 * all errors in sets in state, or in saveToState are collected
	 * for throw later.
	 * 
	 * @param collectErrors
	 */
	public void setCollectErrors(boolean collectErrors);

	/**
	 * Get information about if collect errors or launch it
	 * when produce.
	 * 
	 * @return
	 */
	public boolean getCollectErrors();

	/**
	 * Validate al statetes en the context.
	 */
	public void validate(int mode) throws PersistenceValidateExceptions;
}