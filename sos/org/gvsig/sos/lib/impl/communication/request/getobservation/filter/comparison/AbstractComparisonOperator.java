package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;

import org.gvsig.sos.lib.impl.communication.request.getobservation.AbstractObservationRequest;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;

/**
 * Abstract class for comparison operators classes
 * @author pviciano
 *
 */
public abstract class AbstractComparisonOperator extends AbstractObservationRequest{

	protected String propertyName = null;
	protected AbstractComparisonOperator(String tagName) {
		super(tagName, GETOBSERVATION_TYPES.COMPARISONFILTEROPERATOR);
	}

	 /** Set PropertyName
	 */
	public void setPropertyName (String property)
	{
		this.propertyName = property;
	}
	
	/**
	 * Get PropertyName
	 */
	public String getPropertyName()
	{
		return this.propertyName;
	}
}
