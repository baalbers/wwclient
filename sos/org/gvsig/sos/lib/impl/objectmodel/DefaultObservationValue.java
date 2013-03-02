package org.gvsig.sos.lib.impl.objectmodel;

import org.gvsig.sos.lib.api.client.FeatureOfInterest;
import org.gvsig.sos.lib.api.client.ObservationValue;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.timesupport.Time;

public class DefaultObservationValue implements ObservationValue {

	private Object value;
	private Time time;
	private long oid;
	
	private FeatureOfInterest featureOfInterest;
	private ObservedProperty observedProperty;
    private Procedure procedure;
	
	public DefaultObservationValue(Object value, Time time, FeatureOfInterest featureOfInterest,
									ObservedProperty observedProperty, Procedure procedure){
        this.featureOfInterest = featureOfInterest;
        this.time = time;
        this.observedProperty = observedProperty;
        this.value = value;
        this.procedure = procedure;
	} 
	
	public Object getValue() {
		return value;
	}

	public Time getSamplingTime() {
		return time;
	}

	public FeatureOfInterest getFeatureOfInterest() {
		return featureOfInterest;
	}

	public ObservedProperty getObservedProperty() {
		return observedProperty;
	}

	public Procedure getProcedure() {
       return procedure;
	}

	public Object getOid() {
		return new Long(oid);
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

}
