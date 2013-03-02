package org.gvsig.tools.persistence;

import java.util.Iterator;

import org.gvsig.tools.persistence.exception.PersistenceException;

public interface PersistentContext {

	/**
	 * Return an iterator over the states stored in this
	 * context.
	 * 
	 * @return iterator of PersistentState
	 */
	public Iterator iterator();


	/**
	 * Add a error to the list of errors of the context.
	 * 
	 * @param cause
	 */
	public void addError(Throwable cause);
	
	/**
	 * Get all errors collected to the moment in this context.
	 * 
	 * @return a PersistentException with al errors.
	 */
	public PersistenceException getErrors();


}