package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Time Duration Operator for Temporal Filters
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalDurationOperator extends AbstractTemporalFilterOperation implements TemporalDurationOperator{

	private String duration = null;
	
	public DefaultTemporalDurationOperator() {
		super(GetObservationsTagNameConstants.TEMPORAL_DURATION);
	}

	/**
	 * Set time duration
	 */
	public void setTimeDuration(String time)
	{
		duration = time;
	}
	
	/**
	 * Get time duration
	 */
	public String getTimeDuration()
	{
		return duration;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(duration == null)
			throw new SOSInternalException(this.tagName + " :Needs a duration");
		String xml = "<" + this.tagName + ">";
		/*if(propertyName != null)
		{
			xml += "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
			+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		}*/
		xml += duration;
		xml += "</" + this.tagName + ">\n";
		return xml;
	}
	
	

}
