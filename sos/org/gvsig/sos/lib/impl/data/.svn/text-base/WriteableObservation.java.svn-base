package org.gvsig.sos.lib.impl.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.gvsig.sos.lib.impl.parsers.Coordinates;

class WriteableObservation implements Serializable{

	private static final long serialVersionUID = -2192619334337791180L;

	//Observation Value
	Object value;

	//feature of interest location.
	Coordinates fOILocation;
	//feature of interest identifier.
	String fOIIdentifier;
    		
	//Observed property identifier.
	String observedPropertyIdentifier;
	
	//procedure id
	String procedureIdentifier; 
	
	//sampling Time
	String samplingTime;
	
	public WriteableObservation(String samplingTime, Object value, Coordinates fOILocation, 
			String fOIIdentifier, String observedPropertyIdentifier, String procedureIdentifier) {
		this.value = value;
		this.fOIIdentifier = fOIIdentifier;
		this.fOILocation = fOILocation;
		this.observedPropertyIdentifier = observedPropertyIdentifier;
		this.procedureIdentifier = procedureIdentifier;
		this.samplingTime = samplingTime;
	}
	
    private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.defaultWriteObject(); 
	}
	    
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.defaultReadObject();
	}
}

