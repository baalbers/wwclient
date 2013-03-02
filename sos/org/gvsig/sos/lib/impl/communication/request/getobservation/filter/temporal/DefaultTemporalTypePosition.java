package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Time Type Position for Time Duration
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalTypePosition extends AbstractTimeInstantPosition implements TemporalTypePosition{

	public DefaultTemporalTypePosition() {
		super(null);
	}
	/**
	 * Set begin
	 * @param begin
	 */
	public void setBegin(String begin)
	{
		this.begin = begin;
	}
	/**
	 * Get begin 
	 * @return
	 */
	public String getBegin()
	{
		return begin;
	}
	/**
	 * Set end 
	 * @param end
	 */
	public void setEnd(String end)
	{
		this.end = end;
	}
	/**
	 * Get end 
	 * @return
	 */
	public String getEnd()
	{
		return end;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(begin == null || end == null)
			throw new SOSInternalException("Needs begin and end");
		String xml = "<"+GetObservationsTagNameConstants.TEMPORAL_BEGINPOSITION+">"
		+ begin +"</"+GetObservationsTagNameConstants.TEMPORAL_BEGINPOSITION+">\n";
		
		xml += "<"+GetObservationsTagNameConstants.TEMPORAL_ENDPOSITION+">"
		+ end +"</"+GetObservationsTagNameConstants.TEMPORAL_ENDPOSITION+">\n";
		
		return xml;
	}
	

}
