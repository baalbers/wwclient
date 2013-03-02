package org.gvsig.sos.lib.impl.communication.request.getobservation;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;




/**
 * Represent a list of procedures
 * 
 * @author Pablo Viciano Negre
 * 
 */
public class Procedure extends AbstractObservationRequest {
	List<String> values = new ArrayList<String>();

	public Procedure() {
		super(GetObservationsTagNameConstants.SOS_PROCEDURE_REQUEST,
				GETOBSERVATION_TYPES.PROCEDURE);
	}

	/**
	 * Adds a procedure
	 */
	public void addProcedure(String procedure) {
		if(!values.contains(procedure))
			values.add(procedure);
	}

	/**
	 * Add a list of procedures 
	 * @param procedures
	 */
	public void addProcedures(List<String> procedures)
	{
		for(int i = 0; i < procedures.size(); i++)
		{
			if(!values.contains(procedures.get(i)))
				values.add(procedures.get(i));
		}
	}
	
	/**
	 * Get the list of procedures
	 */
	public List<String> getProcedures() {
		return values;
	}

	/**
	 * Set the list of procedures
	 */
	public void setProcedures(List<String> procedures) {
		values = procedures;
	}

	 
	public String toXML() throws SOSInternalException
	{
		String xml = "";
		if(values.size() > 0)
		{
			Iterator<String> it = values.iterator();
			
			while(it.hasNext())
			{
			xml+= "<"+this.tagName+">"+ it.next() + "</"+this.tagName+">";
			}
			return xml;
		}
		return xml;
	}
}
