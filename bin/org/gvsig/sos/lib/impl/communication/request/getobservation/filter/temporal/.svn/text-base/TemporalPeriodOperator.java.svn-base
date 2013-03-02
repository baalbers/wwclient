package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;

/**
 * Time Period Operator for temporal filter
 * @author Pablo Viciano Negre
 *
 */
public interface TemporalPeriodOperator extends TemporalFilterOperation{

	
	/**
	 * Set the type of time (TypeTimeInstant,  TypeTimePeriod or TypeTimePosition) 
	 */
	public void setTypeTime(TimeInstantPosition timeType);
	
	/**
	 * Get the type of time (TypeTimeInstant or TypeTimePeriod)
	 */
	public TimeInstantPosition getTypeTime();
	
	/**
	 * Set time duration
	 * @param duration
	 */
	public void setTimeDuration(TemporalDurationOperator duration);
	
	/**
	 * Get time duration
	 * @return
	 */
	public TemporalDurationOperator getTimeDuration();
	
	/**
	 * Set time interval
	 * @param interval
	 */
	public void setTimeInterval(TemporalIntervalOperator interval);
	
	/**
	 * Get time interval
	 * @return
	 */
	public TemporalIntervalOperator getTimeInterval();
}
