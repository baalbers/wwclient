package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;

/**
 * Distance Buffer Operator for spatial filter
 * @author Pablo Viciano Negre
 *
 */
public interface SpatialDistanceBufferOperator extends SpatialFilterOperation{

	/**
	 * Set units
	 */
	public void setUnits(String units);
	
	/**
	 * Get units
	 */
	public String getUnit();
}
