package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Time Period Operator for temporal filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalPeriodOperator extends AbstractTemporalFilterOperation implements TemporalPeriodOperator{

	private AbstractTimeInstantPosition timeType = null;
	private DefaultTemporalDurationOperator duration = null;
	private DefaultTemporalIntervalOperator interval = null;
	public DefaultTemporalPeriodOperator() {
		super(GetObservationsTagNameConstants.TEMPORAL_FILTER_TIMEPERIOD);
	}
	
	/**
	 * Set the type of time (TypeTimeInstant,  TypeTimePeriod or TypeTimePosition) 
	 */
	public void setTypeTime(TimeInstantPosition timeType)
	{
		this.timeType = (AbstractTimeInstantPosition)timeType;
	}
	
	/**
	 * Get the type of time (TypeTimeInstant or TypeTimePeriod)
	 */
	public TimeInstantPosition getTypeTime()
	{
		return this.timeType;
	}
	/**
	 * Set time duration
	 * @param duration
	 */
	public void setTimeDuration(TemporalDurationOperator duration)
	{
		this.duration = (DefaultTemporalDurationOperator)duration;
	}
	/**
	 * Get time duration
	 * @return
	 */
	public TemporalDurationOperator getTimeDuration()
	{
		return this.duration;
	}
	/**
	 * Set time interval
	 * @param interval
	 */
	public void setTimeInterval(TemporalIntervalOperator interval)
	{
		this.interval = (DefaultTemporalIntervalOperator)interval;
	}
	/**
	 * Get time interval
	 * @return
	 */
	public TemporalIntervalOperator getTimeInterval()
	{
		return this.interval;
	}
	
	
	  
	public String toXML() throws SOSInternalException
	{
		if(timeType == null)
			throw new SOSInternalException(this.tagName + " :Needs a begin and end time");
		String xml = "<"+ this.tagName + ">\n";
		if(propertyName != null)
		{
			xml += "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
			+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		}
		if(duration == null && interval == null)
		{
			xml += timeType.toXML();
		}
		else
		{
			if(duration != null)
				xml += duration.toXML();
			else
				xml += interval.toXML();

		}
		xml += "</"+ this.tagName + ">\n";
		return xml;
	}

	

}
