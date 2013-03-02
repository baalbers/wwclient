package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * TimeInstant Type for TimePeriod
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalTypeInstant extends AbstractTimeInstantPosition implements TemporalTypeInstant{

	public DefaultTemporalTypeInstant() {
		super(null);
	}
	/**
	 * Set begin position 
	 * @param beginPosition
	 */
	public void setBeginPosition(String beginPosition)
	{
		begin = beginPosition;
	}
	/**
	 * Get begin position
	 * @return
	 */
	public String getBeginPosition()
	{
		return begin;
	}
	/**
	 * Set end position
	 * @param endPosition
	 */
	public void setEndPosition(String endPosition)
	{
		end = endPosition;
	}
	/**
	 * Get end position
	 * @return
	 */
	public String getEndPosition()
	{
		return end;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(begin == null || end == null)
			throw new SOSInternalException("Needs begin and end");
		String xml = "<"+GetObservationsTagNameConstants.TEMPORAL_BEGIN+">"
		+ begin +"</"+GetObservationsTagNameConstants.TEMPORAL_BEGIN+">\n";
		
		xml += "<"+GetObservationsTagNameConstants.TEMPORAL_END+">"
		+ begin +"</"+GetObservationsTagNameConstants.TEMPORAL_END+">\n";
		
		return xml;		
	}
	
	

}
