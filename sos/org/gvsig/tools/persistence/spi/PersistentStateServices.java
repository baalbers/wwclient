package org.gvsig.tools.persistence.spi;

import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;

public interface PersistentStateServices extends PersistentState {

	public PersistentIdentifier  getId();

	public void setTheClassName(String className);

	public void setFactory(PersistenceFactory factory);
	
	/**
	 * Return the internal value stored in the state associated to the 
	 * name passed as parameter.
	 * 
	 * @param name
	 * @return
	 */
	public Object getValue(String name) ;

	public void setValue(String name, Object value) throws PersistenceException ;
}
