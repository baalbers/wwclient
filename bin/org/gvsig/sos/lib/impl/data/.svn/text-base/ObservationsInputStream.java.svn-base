package org.gvsig.sos.lib.impl.data;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.gvsig.sos.lib.impl.data.RandomAccessStream.RAInputStream;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservationsInputStream {
	
	private static final Logger logger = LoggerFactory.getLogger(ObservationsInputStream.class);
	
	private RandomAccessStream.RAInputStream input; 
	private CacheIndex cacheIndex;
	private boolean deleteFileOnClose = true;
	private String fileName;
	
	public void advanceIndexPosition() throws IOException{
		input.readIndexPosition(false);
	}
	
	public WriteableIndex readIndex() throws IOException{
        if (cacheIndex==null) {
			long indexPos = input.readIndexPosition(true);
			WriteableIndex index = null;
			input.seek(indexPos);
			index = readIndexObj();
			this.cacheIndex = new CacheIndex(index);
        }
		return cacheIndex.getWritableIndex();
	} 
	
	public ObservationsInputStream(RandomAccessFile fa, CacheIndex index, String fileName) throws IOException{
		this.input = new RAInputStream(fa);
		advanceIndexPosition();
		this.fileName = fileName;
		//modify here to let this class to read the index
		//this.cacheIndex = index;
	}
	
	public Object readObject(int objPos) throws IOException {
        readIndex();
		long position = cacheIndex.getFilePositionForObservation(objPos);
		input.seek(position);
		return readObservation();
	}

	public WriteableObservation readObservation() throws IOException{
		String objStr = input.readString();
		
		String [] fields = objStr.split("\\" + org.gvsig.sos.lib.impl.data.ObservationsOutputStream.fieldSep);
		
		String fOIIdentifier = fields[0]; 
	    Double foiX = Double.parseDouble(fields[1]); 
	    Double foiY = Double.parseDouble(fields[2]); 
	    Double foiZ = Double.parseDouble(fields[3]);  
	    Coordinates fOILocation = new Coordinates();
	    fOILocation.setX(foiX); 
	    fOILocation.setY(foiY);
	    fOILocation.setZ(foiZ);
	    
	    String obsIdentifier = fields[4];
	    String procIdentifier = fields[5];
	    String samplingTime = fields[6];
	    String valueClass = fields[7];
	    Object value = (valueClass.equals(Double.class.getName()))?
	    		Double.parseDouble(fields[8]): fields[8];
	        
	    /* this a  prove of the order in which the obs are encoded
	     * String toWrite = getWritableStr(foi, foiX, foiY, foiZ, obsIdentifier, 
	        		                        procIdentifier, samplingTime, valueClass, valueStr);
	      */
	    WriteableObservation result = new WriteableObservation(samplingTime, value, fOILocation,
	    		fOIIdentifier, obsIdentifier, procIdentifier);
	    return result;
	}

    /* Implementation of the index by writing the sequence of long values,
     * the previous method had problems when the index was too long*/
	public WriteableIndex readIndexObj() throws IOException{

		WriteableIndex index = new WriteableIndex();
		int i = 0;
		try {
           while(true){
	 		   long position = input.readLong();
	 	       index.includePositionAt(i++, position);		
           }			
		}
		catch (EOFException eof){
			//nothing to do used to know when to stop reading the index.
		} 
		return index;
	}

	
	
	public void close(){
		try {
			input.close();
			if (deleteFileOnClose) {
				File f = new File(fileName);
				f.delete();
			}
		} catch (IOException e) {
			logger.info("Error while deleting/cleaning observations cache files.");
		}
	}
}
