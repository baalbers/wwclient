package org.gvsig.sos.lib.api.client;

import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.tools.dispose.Disposable;

/**
 * Interface for accessing a set of observation values through different 
 * iterators.
 * @author lrodriguez
 *
 */
public interface ObservationSet extends Disposable {

	/**
	 * Gives the element count in the observations set.
	 * @return the element count.
	 */
	public long getCount();
	
	/**
	 * Gives an iterator for iterating on the whole set of observations.
	 * @return the iterator
	 */
    public Iterator<ObservationValue> iterator();

	/**
	 * Gives an iterator for iterating on the observations 
	 * starting by a given index.
	 * @param index the index (0 based) for setting the initial 
	 * 		  position of the iteration.
	 * @return  the iterator
	 */

    public Iterator<ObservationValue> iterator(long index);
    
    /**
     * Gets a value given its oid (a reference id).
     * @return the observation value.
     */
    public ObservationValue getObservationValueById(Object oid) throws SOSException;
    
    
    /**
     * Gives the resources to be registered and handled by gvSig resources manager. 
     * In the current implementation only the cache files created are registered.
     * @return a list of resources (File objects)
     */
	public List<Object> getResources();
}
