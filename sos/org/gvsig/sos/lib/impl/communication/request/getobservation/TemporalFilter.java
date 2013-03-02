package org.gvsig.sos.lib.impl.communication.request.getobservation;


import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.TemporalFilterOperation;

/**
 * Generic class for temporal filters
 * 
 * @author Pablo Viciano Negre
 * 
 */
public interface TemporalFilter {
	public static enum TEMPORAL_FILTER_TYPE {
		TM_AFTER, TM_BEFORE, TM_BEGINS, TM_BEGUNBY
		, TM_CONTAINS, TM_DURING, TM_ENDEDBY, TM_ENDS, TM_EQUALS
		, TM_MEETS, TM_METBY, TM_OVERLAPS, TM_OVERLAPPEDBY};
	
	/**
	 * Set the type's filter
	 */
	public void setType(TEMPORAL_FILTER_TYPE type);

	/**
	 * Get the type's filter
	 */
	public TEMPORAL_FILTER_TYPE getTemporalFilterType();

	
	/**
	 * Set the temporal filter operator
	 */
	public void setTemporalFilterOperator(TemporalFilterOperation operation);
	
	/**
	 * Get the temporal filter
	 */
	public TemporalFilterOperation getTemporalFilterOperator();
	
	/**
	 * Set the property name
	 * @param propertyName
	 */	
	public void setPropertyName(String propertyName);
    
	/**
	 * 
	 * @return filter property name
	 */
	public String getPropertyName();
}
