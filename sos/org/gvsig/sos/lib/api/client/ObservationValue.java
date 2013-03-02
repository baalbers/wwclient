package org.gvsig.sos.lib.api.client;

import org.gvsig.timesupport.Time;

/**
 * An observation value is the result of a measurement of a given property
 * (observed property) at a given time instant (or period), using given procedure 
 * (possibly a sensor) for a certain feature (feature of interest). 
 * @author lrodriguez
 */
public interface ObservationValue {
	
	/**
	 * Gives the value of the observation.
	 * @return the value of the observation.
	 */
    public Object getValue();
    
    /**
     * Gives the time where the observation was made.
     * @return the time of the observation
     */
    public Time getSamplingTime();
    
    /**
     * Returns the feature of interest related to the observation.
     * @return the feature of interest
     */
    public FeatureOfInterest  getFeatureOfInterest();
    
    /**
     * Gives the observed property the value refers to.
     * @return
     */
    public ObservedProperty getObservedProperty();
    
    /**
     * Gives the procedure used to obtain the observation.
     * @return the procedure used.
     */
    public Procedure getProcedure();

    
    public Object getOid();
}
