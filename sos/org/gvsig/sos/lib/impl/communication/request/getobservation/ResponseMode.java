package org.gvsig.sos.lib.impl.communication.request.getobservation;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;


/**
 * Represents Response Mode
 * @author Pablo Viciano Negre
 *
 */
public class ResponseMode extends AbstractObservationRequest{
	public static enum RESPONSEMODETYPE {INLINE,OUTOFBAND,ATTACHED,RESULTTEMPLATE};
	private String value = null;
	private RESPONSEMODETYPE mode = null;
	public ResponseMode() {
		super(GetObservationsTagNameConstants.SOS_RESPONSEMODE_REQUEST
				,GETOBSERVATION_TYPES.RESPONSEMODE);
	}
	
	/**
	 * Set the ResponseMode
	 */
	public void setResponseMode(RESPONSEMODETYPE mode)
	{
		this.mode = mode;
		switch(mode)
		{
		case INLINE:
			value = "inline";
			break;
		case OUTOFBAND:
			value = "out-of-band";
			break;
		case ATTACHED:
			value = "attached";
			break;
		case RESULTTEMPLATE:
			value = "resultTemplate";
			break;
		}
	}
	
	/**
	 * Get the ResponseMode
	 */
	public RESPONSEMODETYPE getResponseMode()
	{
		return mode;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(value == null || mode == null)
			throw new SOSInternalException(this.tagName + ": Needs a ResponseMode");
		String xml = "<" + this.tagName + ">" + value + "</"+this.tagName + ">";
		return xml;
	}

}
