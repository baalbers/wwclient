package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;

/**
 * Binary operator for comparison filter
 * @author Pablo Viciano Negre
 *
 */
public interface ComparisonBinaryOperator extends ComparisonOperator{
	
	/**
	 * Set value
	 */
	public void setValue(String value);
	
	/**
	 * Get Value
	 */
	public String getValue();
	
}
