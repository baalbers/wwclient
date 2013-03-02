package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;



import org.gvsig.sos.lib.impl.communication.request.getobservation.AbstractObservationRequest;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;


/**
 * Represent an operator for temporal filters
 * @author Pablo Viciano Negre
 *
 */
public abstract class AbstractTemporalFilterOperation extends AbstractObservationRequest implements TemporalFilterOperation{
	protected String propertyName;
	protected AbstractTemporalFilterOperation(String tagName) {
		super(tagName, GETOBSERVATION_TYPES.TEMPORALFILTEROPERATOR);
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
 