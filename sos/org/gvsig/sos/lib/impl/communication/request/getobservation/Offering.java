package org.gvsig.sos.lib.impl.communication.request.getobservation;





import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;

/**
 * Represent a offering
 * @author Pablo Viciano Negre
 *
 */
public class Offering extends AbstractObservationRequest{

	private String value = null;
	public Offering() {
		super(GetObservationsTagNameConstants.SOS_OFFERING_REQUEST
				,GETOBSERVATION_TYPES.OFFERING);
	}
	/**
	 * Sets the URI value of offering
	 * @param URI
	 */
	public void setValue(String URI)
	{
		value = URI;
	}
	
	 
	public String toXML()throws SOSInternalException
	{
		if(value == null)
			throw new SOSInternalException(this.tagName +" Offering needs a uri");
		String xml = "<"+ this.tagName + ">" + value +"</" + this.tagName + ">";
		return xml;
	}
}
