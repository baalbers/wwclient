package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Represents an Envelope operator of a spatial filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultSpatialEnvelopeOperator extends AbstractGeometryOperator implements SpatialEnvelopeOperator {
	private String upperCorner = null;
	private String lowerCorner = null;
	
	public DefaultSpatialEnvelopeOperator()
	{
		super(GetObservationsTagNameConstants.GML_ENVELOPE);
	}
	
	/**
	 * Set the uppercorner
	 */
	public void setUpperCorner(String upperCorner)
	{
		this.upperCorner = upperCorner;
	}
	/**
	 * Get the upperCorner
	 */
	public String getUpperCorner()
	{
		return this.upperCorner;
	}
	
	/**
	 * Set the lowerCorner
	 */
	public void setLowerCorner(String lowerCorner)
	{
		this.lowerCorner = lowerCorner;
	}
	
	/**
	 * Get the lowerCorner
	 */
	public String getLowerCorner()
	{
		return this.lowerCorner;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(upperCorner == null || lowerCorner == null)
			throw new SOSInternalException("Envelope needs a upper corner and lowerCorner");
		
		String xml = "<" + this.tagName;
		if(this.id != null)
			xml += " " + GetObservationsTagNameConstants.GML_ID + "=\"" + this.id + "\" ";
		if(this.srsName != null)
			xml += " " + GetObservationsTagNameConstants.GML_SRS_NAME_PROPERTY + "=\"" + this.srsName + "\" ";
		xml += ">\n"; 
		xml += "<" + GetObservationsTagNameConstants.GML_LOWERCORNER + ">";
		xml += lowerCorner;
		xml += "</" + GetObservationsTagNameConstants.GML_LOWERCORNER + ">\n";
		
		xml += "<" + GetObservationsTagNameConstants.GML_UPPERCORNER + ">";
		xml += upperCorner;
		xml += "</" + GetObservationsTagNameConstants.GML_UPPERCORNER + ">\n";
		xml += "</" + this.tagName + ">\n";
		return xml;
	}
}
