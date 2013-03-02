package org.gvsig.tools.util;

import java.util.List;

/**
 * 
 * This is a utility class for call a list of callables.
 * 
 * It can collect exceptions and continue to call the next 
 * callable in the list. 
 * 
 * @author gvSIG Team - jjdelcerro
 *
 */
public interface Caller {

	/**
	 * Get if the Caller can collect exceptions or
	 * exit in the first exception produced.
	 * 
	 * @return boolean that indicate that collect exceptions.
	 */
	public boolean getCollectExceptions();
	
	/**
	 * Set in the caller the behabior of collect al exceptions
	 * and continue calling the next callable in the list of our
	 * callables.
	 * 
	 * @param collectExceptions
	 */
	public void setCollectExceptions(boolean collectExceptions);
	
	/**
	 * Add a callable to the list of callables of the caller.
	 * @param callable
	 */
	public void add(Callable callable);
	
	/**
	 * Return the list of collected exceptions or null.
	 * 
	 * @return list of exceptions
	 */
	public List getExceptions();

	/**
	 * Call all callables in the list of callables of the caller.
	 * 
	 * @return true if no exceptions produced
	 */
	public boolean call();

}
