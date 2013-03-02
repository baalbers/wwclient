package org.gvsig.sos.lib.impl.data;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ObservationsOutputStream {

	CacheIndex index;
    RandomAccessStream.RAOutputStream randomAccessStream;
		
	public ObservationsOutputStream(RandomAccessFile fa, CacheIndex index) throws IOException {
		randomAccessStream = new RandomAccessStream.RAOutputStream(fa);
		this.index = index;
	}

	public void writeObject(WriteableObservation obj) throws IOException {
	     long pointer = randomAccessStream.getFilePointer();	
    	   writeWritableObs(obj);
	       index.objectWritten(obj, pointer);
	}

	public void writeObject(WriteableIndex obj) throws IOException {
		randomAccessStream.writeFilePointer();
		writeIndex(obj);
	}

	private void writeIndex(WriteableIndex obj) throws IOException {
		for(Long pos: obj.getPositions()) {
			randomAccessStream.writeLong(pos);
		}
	}

	
	public static final String fieldSep = "$";
	
	private void writeWritableObs(WriteableObservation obs) throws IOException{
        String foi = obs.fOIIdentifier; 
        String foiX = Double.toString(obs.fOILocation.getX()); 
        String foiY = Double.toString(obs.fOILocation.getY()); 
        String foiZ = Double.toString(obs.fOILocation.getZ()); 

        String obsIdentifier = obs.observedPropertyIdentifier;
        String procIdentifier = obs.procedureIdentifier;
        String samplingTime = obs.samplingTime;
        String valueClass = obs.value.getClass().getCanonicalName();
        String valueStr = (obs.value instanceof Double)? Double.toString((Double)obs.value): obs.value.toString();
        
        String toWrite = getWritableStr(foi, foiX, foiY, foiZ, obsIdentifier, 
        		                        procIdentifier, samplingTime, valueClass, valueStr);
        randomAccessStream.writeString(toWrite);
	}

	private String getWritableStr(Object... objects){
        String sep = "";
		StringBuffer result = new StringBuffer();
		
        for (Object o: objects) {
        	result.append(sep).append(o.toString());
        	sep = fieldSep;
        }
        return result.toString();
	}

	public void close() throws IOException {
	  writeObject(index.getWritableIndex());	
	  randomAccessStream.close();
	}

	/*public void writeObject(String samplingTime, Object value,
			Coordinates fOILocation, String fOIIdentifier,
			String observedPropertyIdentifier, String procedureIdentifier) {
		
		
	}*/
	
	}
