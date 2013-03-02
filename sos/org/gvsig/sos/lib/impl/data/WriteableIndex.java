package org.gvsig.sos.lib.impl.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class maintains an index that can be written in a file. 
 * The index consists in a list of positions (file positions). The index keeps this
 * positions and is able to persist them in the order they were put in the index. 
 * @author lrodriguez
 */
public class WriteableIndex implements Serializable{
	
	private static final long serialVersionUID = -7730105128957435808L;
	
	/**
	 * A list of positions maintained but not persisted.
	 */
	transient private List<Long> positionsList = new ArrayList<Long>();
   
	/**
	 * the actual list of positions that are persisted.
	 */
	private long [] positions; 
	
	/**
	 * Constructor of an index base on a list of positions.
	 * @param positions
	 */
	public WriteableIndex(List<Long> positions) {
		setPositionByList(positions);
    }

	public WriteableIndex() {

	}
	
	/**
	 * This method writes the index objects. Before writing it dump the positions in 
	 * an array which is only used for persisting the positions. 
	 * @param out output stream 
	 * @throws IOException
	 */
    private void writeObject(ObjectOutputStream out) throws IOException
	{
    	positions = getPositions();
		out.defaultWriteObject(); 
	}
    
    /**
     * This method restores the index to its object representation.
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		// our "pseudo-constructor"
		in.defaultReadObject();
		
		// now we are a "live" object again, so let's run rebuild and start
		positionsList = new ArrayList<Long>();

		for (long pos: positions) {
            positionsList.add(pos);			
		}
		
		positions = null;
	}
	
	/**
	 * Sets the positions of an index from an array.
	 * @param positions an array contaning the positions to include in the index.
	 */
	public void setPositions(long [] positions) {
		for (long pos: positions) {
			positionsList.add(pos);
		}
	}

	/**
	 * Gives an array with the positions kept by this index in the order they are indexed.
	 * @return an array with the positions.
	 */
	public long [] getPositions() {
		long [] positions  = new long [positionsList.size()];
		int i =0;
		for (Long l: positionsList) {
			positions[i++] = l.longValue();
		}
		return positions;
	}
	
	/**
	 * Sets the positions of the index from a list of positions.
	 * @param positions the positions to include in the index.
	 */
	public void setPositionByList(List<Long> positions){
	   this.positionsList.addAll(positions);
	}

	
	/**
	 * Gives the position at the index specified. 
	 * @param index the index of the position to be retrieved.
	 * @return the position at that index.
	 */
	public long obtainPostionAt(int index){
		return this.positionsList.get(index);
	}
	
	/**
	 * Gives the number of positions indexed by this index. 
	 * @return the number of positions contained in the index.
	 */
	public int getCount() {
		return this.positionsList.size();
	}
	
	/**
	 * Includes a new position in this index. The index is only used in case it is needed to 
	 * replace an entry in the current index, otherwise the new position is appended to the index. 
	 * @param index the index 
	 * @param position the position value to be kept buy this index.
	 */
	public void includePositionAt(int index, long position) {
        if (index < getCount()) {
        	this.positionsList.set(index, position);	
        } 
        else {
		  this.positionsList.add(position);
        }
		//print("index: " +  index  +"," + " position: "  + position);
	}
	
	/**
	 * Clears the position list kept in the index. 
	 */
	public void clear(){
		positionsList.clear();
	}
}
