package org.gvsig.sos.lib.impl.data;

/**
 * Class representing the index of a cache object. It acts as a wrapper of a 
 * WriteableIndex class customized for including persisted observations values 
 * in the index. 
 * It maintains an index (WriteableIndex) that can be written at the end of the file.
 * @author lrodriguez
 *
 */
public class CacheIndex {

	/**
	 * the writeable index maintained by this cache index. 
	 */
	WriteableIndex index;

	public CacheIndex(WriteableIndex index) {
		this.index = index;
	}

	public CacheIndex() {
		this.index = new WriteableIndex();
	}

	/**
	 * gives the position of an observation given its (zero based) order.
	 * @param observationOrder the order in which the observation was written 
	 * @return the position of the observation.
	 */
	public long getFilePositionForObservation(int observationIndex) {
	   return index.obtainPostionAt(index.getCount()- observationIndex -1);
	}

	/**
	 * This method includes a new position in the index and verifies the object 
	 * persisted is an actual WriteableObservation.
	 * @param obj the object written. 
	 * @param position the position in the file the object has been written at.
	 */
	public void objectWritten(WriteableObservation obj, long position) {
		// add it to the writable index
		index.includePositionAt(index.getCount(), position);
	}

	/**
	 * Gives the writeable index where the position have been written.
	 * @return the writeable index.
	 */
	public WriteableIndex getWritableIndex() {
		return index;
	}
	
	/**
	 * Gives the number of positions indexed in this index.
	 * @return number of positions.
	 */
	public int getCount(){
		return index.getCount();
	}
}
