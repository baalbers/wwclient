package org.gvsig.sos.lib.impl.communication.request.getobservation;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;



/**
 * Represent a object ResponseFormat 
 * 
 * @author Pablo Viciano Negre
 * 
 */
public class ResponseFormat extends AbstractObservationRequest {

	private String value = "text/xml;subtype=\"om/1.0.0\"";

	public ResponseFormat() {
		super(GetObservationsTagNameConstants.SOS_RESPONSEFORMAT_REQUEST,
				GETOBSERVATION_TYPES.RESPONSEFORMAT);
	}

	/**
	 * Set the response format
	 */
	public void setResponseFormat(String format) {
		value = format;
	}

	/**
	 * Get the response format
	 */
	public String getResponseFormat() {
		return value;
	}

	 
	public String toXML() throws SOSInternalException {
		if(value == null)
			throw new SOSInternalException(this.tagName + ": Needs a value");
		String xml = "<" + this.tagName + ">" + this.value + "</"
				+ this.tagName + ">";
		return xml;
	}
}
