package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;

import org.gvsig.sos.lib.impl.communication.request.getobservation.AbstractObservationRequest;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;

/**
 * Abstract class for spatial filter operators classes
 * @author pviciano
 *
 */
public abstract class AbstractSpatialFilterOperation extends AbstractObservationRequest implements SpatialFilterOperation{
	protected String propertyName = null;
	protected AbstractSpatialFilterOperation(String tagName) {
		super(tagName,GETOBSERVATION_TYPES.SPATIALFILTEROPERATOR);
	}
	
	/**
	 * Set the property name
	 */
	public void setPropertyName(String property)
	{
		this.propertyName = property;
	}
	
	/**
	 * Get the property name
	 */
	public String getPropertyName()
	{
		return propertyName;
	}

}
