package org.gvsig.sos.lib.impl.communication.request.getobservation;


import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.SpatialFilterOperation;
/**
 * Represents a spatial filter
 * @author Pablo Viciano Negre
 *
 */
public interface SpatialFilter extends FeatureOfInterestComponents{
    public static enum SPATIAL_FILTER_TYPE {BBOX, CONTAINS, CROSSES, DISJOINT
        , EQUALS, INTERSECTS, OVERLAPS, TOUCHES, WITHIN, BEYOND, DWITHIN};
        
	/**
	 * Set the property name
	 * @param property
	 */
	public void setPropertyName(String property);
	
	/**
	 * Get the property name
	 */
	public String getPropertyName();
	
	/**
	 * Set the type of spatial filter
	 */
	public void setType(SPATIAL_FILTER_TYPE type);
	
	/**
	 * Set the type of spatial filter
	 */
	public SPATIAL_FILTER_TYPE getSpatialFilterType();

	
	/**
	 * Set spatial operator needs
	 */
	public void setSpatialFilterOperator(SpatialFilterOperation operation);
	
	/**
	 * Get spatial operator
	 */
	public SpatialFilterOperation getSpatialFilterOperator();

}
