
package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;


/**
 * Abstract class for spatial filter operators classes
 * @author pviciano
 *
 */
public interface SpatialFilterOperation{
	
	/**
	 * Set the property name
	 */
	public void setPropertyName(String property);
	
	/**
	 * Get the property name
	 */
	public String getPropertyName();
}
