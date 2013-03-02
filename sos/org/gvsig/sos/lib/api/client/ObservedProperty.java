/**
 * 
 */
package org.gvsig.sos.lib.api.client;

/**
 * This interface provides access to the information of an observed property. 
 * Examples of observed properties are Temperature, humidity, water level, etc.
 * @author lrodriguez
 *
 */
public interface ObservedProperty extends DeclaredObservedProperty {
	/**
     * Gives the measurement units of the observed property.
     */
   public String getMeasurementUnit();
}
