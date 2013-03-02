package org.gvsig.sos.lib.impl.objectmodel;

import org.gvsig.sos.lib.api.client.ObservedProperty;

public interface MutableObservedProperty extends  ObservedProperty{
    /**
     * Sets the identifier of the observed property.
     * @param identifier
     */
	public void setIdentifier(String identifier);
	

	/**
	 * Sets the measurement unit to the observed property.
	 * @param measurementUnit
	 */
	public void setMeasurementUnit(String measurementUnit);
}
