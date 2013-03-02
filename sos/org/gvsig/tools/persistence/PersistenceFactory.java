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
package org.gvsig.tools.persistence;

import java.util.List;

import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceException;

/**
 * <p>
 * Interface for factories of objects that no implements {@link Persistent} and
 * must be supported by {@link PersistenceManager}.
 * </p>
 *
 * <p>
 * This can be used when the objects to persist can't be created by empty
 * constructor.
 *</p>
 *
 * @author jmvivo
 */
public interface PersistenceFactory {

//	/**
//	 * <p>
//	 * Create a instance of <code>classToUse</code> from <code>state</code>
//	 * data.
//	 * </p>
//	 * <p>
//	 * <b>Note:</b>If possible, this method should only create the object 
//	 * instance and set the object properties in the
//	 * {@link #loadFromState(PersistentState, Object)} method, as it will
//	 * be called afterwards.
//	 * </p>
//	 *
//	 *
//	 * @param state
//	 * @param classToUse
//	 * @return new instante of <code>classToUse</code>
//	 * @deprecated use instead {@link #createFromState(PersistentState)} 
//	 */
//	public Object createFromState(PersistentState state, Class classToUse)
//	throws PersistenceException;

	/**
	 * Create an instance of the object represented by the state.
	 * 
	 * This method can't call {@link #loadFromState(PersistentState, Object)} only create 
	 * the object. 
	 * 
	 * @param state
	 * @return the object
	 */
	public Object createFromState(PersistentState state)	throws PersistenceException;

	
	/**
	 * Load a instance of <code>classToUse</code> from <code>state</code> data.
	 *
	 * @param state
	 * @param object
	 */
	public void loadFromState(PersistentState state, Object object)
			throws PersistenceException;

	/**
	 * Fill <code>state</code> with data to persist of <code>obj</code>.
	 * 
	 * @param state
	 * @param obj
	 * @throws PersistenceException
	 */
	public void saveToState(PersistentState state, Object obj)
			throws PersistenceException;

	/**
	 * Informs if <code>object</code> is managed by this factory.
	 *
	 * @param object
	 * @return true if the object is managed by the factory.
	 */
	public boolean manages(Object object);

	/**
	 * Informs if <code>theClass</code> is managed by this factory.
	 *
	 * @param class to check.
	 * @return true if the class is managed by the factory.
	 */
	public boolean manages(Class theClass);

	/**
	 * Informs if this factory can recreate the object represented by
	 * <code>state</code>.
	 *
	 * @param object
	 * @return
	 */
	public boolean manages(PersistentState state);

	/**
	 * Return a List of the definition managed by this factory where the key is
	 * <code>className</code> and value is <code>definition</code>
	 *
	 * @return Map<String, DynStruct>
	 */
	public List getDefinitions();
		
	/**
	 * Returns the associated definition to the java class name
	 * @param className of a java Class
	 * @return the related definition or null if not managed by this factory
	 */
	public DynStruct getDefinition(String className);
	
	/**
	 * Returns the domain name of the objects persisted by this factory.
	 * @return the domain name
	 */
	public String getDomainName();
	
	/**
	 * Returns the domain URL to use for the schema.
	 * @return the domain URL
	 */
	public String getDomainURL();
	
	/**
	 * Return the list of classes or interfaces managed by this
	 * factory. 
	 * Can return null if factory not use it.
	 * 
	 * @return List of interfaces the factory manage
	 */
	public List getManagedClasses();
	
	/**
	 * Return the class or interface the factory asociate to
	 * the object.
	 * Can return null if factory not asociate an interface to
	 * the object.
	 * 
	 * @param object
	 * @return interface the factory manage asociated to the object.
	 */
	public Class getManagedClass(Object object);
	
	/**
	 * Return the name class or interface the factory asociate to
	 * the object.
	 * Can return null if factory not asociate an interface to
	 * the object.
	 * 
	 * @param object
	 * @return interface the factory manage asociated to the object.
	 */
	public String getManagedClassName(Object object);

	/**
	 * Return the class or interface the factory asociate to
	 * the object.
	 * Can return null if factory not asociate an interface to
	 * the object.
	 * 
	 * @param state
	 * @return interface or class  the factory manage asociated to the state.
	 */
	public Class getManagedClass(PersistentState state);

	/**
	 * Return the class or interface the factory asociate to
	 * the java class name.
	 * Can return null if factory not asociate an interface to
	 * that name.
	 * 
	 * @param name
	 * @return interface or class the factory manage asociated to the name.
	 */
	public Class getManagedClass(String name);
	
}
