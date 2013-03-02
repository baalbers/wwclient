package org.gvsig.sos.lib.impl.communication.request.getobservation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;



/**
 * Represent a  list of Observed Properties
 * @author Pablo Viciano Negre
 *
 */
public class ObservedProperty extends AbstractObservationRequest {

	private List<String> values = new ArrayList<String>();
	public ObservedProperty() {
		super(GetObservationsTagNameConstants.SOS_OBSERVEDPROPERTY_REQUEST
				,GETOBSERVATION_TYPES.OBSERVEDPROPERTY);
	}
	/**
	 * Add a new Observerd Property
	 * @param property
	 */
	public void addObservedProperty(String property)
	{
		if(!values.contains(property))
			values.add(property);
	}
	
	/**
	 * Add a list of Observed properties
	 * @param properties
	 */
	public void addObservedProperties(List<String> properties)
	{
		for(int i = 0; i < properties.size(); i++)
		{
			if(!values.contains(properties.get(i)))
				values.add(properties.get(i));
		}
	}
	
	/**
	 * Get the list of Observed Properties
	 * @return
	 */
	public List<String> getObservedProperties()
	{
		return values;
	}
	
	/**
	 * Set the list of ObservedProperties
	 * @param properties
	 */
	public void setObservedProperties(List<String> properties)
	{
		values = properties;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(values.size()== 0)
			throw new SOSInternalException(this.tagName + " :Needs minimum a ObservedProperty");
		Iterator<String> it = values.iterator();
		String xml = "";
		while(it.hasNext())
		{
			xml += "<" + this.tagName + ">"+ it.next() +"</"+this.tagName + ">";
		}
		return xml;
	}
}
