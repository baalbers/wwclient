package org.gvsig.sos.lib.impl.communication.request.getobservation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;



/**
 * Represents an ObjectID
 * @author Pablo Viciano Negre
 *
 */
public class ObjectID extends AbstractFeatureOfInterestComponents{
	
	List<String> values = new ArrayList<String>();
	public ObjectID() {
		super(GetObservationsTagNameConstants.SOS_OBJECTID
				,GETOBSERVATION_TYPES.OBJECTID);
	}
	/**
	 * Set the list of URI
	 */
	public void setURIS(List<String> uris)
	{
		this.values = uris;
	}
	
	/**
	 * Get the list of URI
	 */
	public List<String> getURIS()
	{
		return this.values;
	}
	
	/**
	 * Add a URI
	 */
	public void addURI(String uri)
	{
		this.values.add(uri);
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(this.values == null || this.values.size()==0)
			throw new SOSInternalException(this.tagName + ": needs an uri");
		Iterator<String> it = this.values.iterator();
		String xml = "";
		while(it.hasNext())
		{
			xml += "<" + this.tagName + ">" + it.next() + "</" + this.tagName + ">\n";
		}
		return xml;
	}
}
