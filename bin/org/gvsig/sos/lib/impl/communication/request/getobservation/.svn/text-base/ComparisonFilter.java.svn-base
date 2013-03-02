package org.gvsig.sos.lib.impl.communication.request.getobservation;

import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonOperator;

/**
 * Represent a comparison filter
 * @author Pablo Viciano Negre
 *
 */
public interface ComparisonFilter{
	public static enum COMPARISON_FILTER_TYPE {EQUALTO,GREATERTHAN
		,GREATERTHANOREQUALTO,LESSTHAN,LESSTHANOREQUALTO,NOTEQUALTO
		,BETWEEN,LIKE,NULL};
		
	/**
	 * Set type comparison filter
	 */
	public void setType(COMPARISON_FILTER_TYPE type);
	
	
	/**
	 * Get the type of the comparison filter
	 */
	
	public COMPARISON_FILTER_TYPE  getComparisonFilterType();
	
	/**
	 * Set the property name
	 * @param property
	 */
	public void setPropertyName(String property);
	
	/**
	 * Get the property name
	 * @return
	 */
	public String getPropertyName();
	
	/**
	 * Adds Comparison operator   
	 */
	public void setComparisonOperator(ComparisonOperator operation);
	
	public ComparisonOperator getComparisonOperator();
	
	
}
