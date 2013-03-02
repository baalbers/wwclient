package org.gvsig.sos.lib.impl.communication.request.getobservation;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;


/**
 * An abstract class for the getobservation requests classes
 * @author Pablo Viciano Negre
 *
 */
public abstract class AbstractObservationRequest {
	GETOBSERVATION_TYPES type;
	protected String tagName;
	protected AbstractObservationRequest(String tagName, GETOBSERVATION_TYPES type) {
		this.tagName = tagName;
		this.type = type;
	}
	
	public GETOBSERVATION_TYPES getType()
	{
		return type;
	}
	

	public String getTagName()
	{
		return this.tagName;
	}
	
	
	public abstract String toXML() throws SOSInternalException;

}
