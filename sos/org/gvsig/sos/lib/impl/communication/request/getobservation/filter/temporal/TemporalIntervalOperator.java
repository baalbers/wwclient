package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;

/**
 * Time Interval Operator for temporal filters
 * @author Pablo Viciano Negre
 *
 */
public interface TemporalIntervalOperator extends TemporalFilterOperation{
	
	/**
	 * Set unit 
	 */
	public void setUnit(String unit);
	
	/**
	 * Get unit
	 */
	public String getUnit();
	
	/**
	 * Set radix
	 */
	public void setRadix(String radix);
	
	/**
	 * Get radix
	 */
	public String getRadix();
	
	/**
	 * Set factor
	 */
	public void setFactor(String factor);
	
	/**
	 * Get factor
	 */
	public String getFactor();

	/**
	 * Set a value time
	 */
	public void setTime(String time);
	
	/**
	 * Get a value time
	 */
	public String getTime();
}
