package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Time Instant Operator for temporal filters
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalInstantOperator extends AbstractTemporalFilterOperation implements TemporalInstantOperator{

	private String value = null;
	public DefaultTemporalInstantOperator() {
		super(GetObservationsTagNameConstants.TEMPORAL_FILTER_TIMEINSTANT);
	}

	/**
	 * Set time instant
	 */
	public void setTimeInstant(String time)
	{
		this.value = time;
	}
	/**
	 * Get Time Instant
	 */
	public String getTimeInstant()
	{
		return this.value;
	}
	
	 
	public String toXML()throws SOSInternalException
	{
		if(value == null)
			throw new SOSInternalException(this.tagName + ": Needs a time instant");
		String xml = "<" + this.tagName +">\n";
		if(propertyName != null)
		{
			xml += "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
			+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		}
		xml += "<" + GetObservationsTagNameConstants.TEMPORAL_TIMEPOSITION +">";
		xml += this.value;
		xml += "</" + GetObservationsTagNameConstants.TEMPORAL_TIMEPOSITION +">\n";
		xml += "</" + this.tagName +">\n";
		return xml;
	}
	

}
