package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;


/**
 * Abstract class for comparison operators classes
 * @author pviciano
 *
 */
public interface ComparisonOperator{

	 /** Set PropertyName
	 */
	public void setPropertyName (String property);
	
	/**
	 * Get PropertyName
	 */
	public String getPropertyName();
}
