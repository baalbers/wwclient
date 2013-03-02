package org.gvsig.sos.lib.impl.objectmodel;

import java.util.List;

//import org.gvsig.fmap.geom.Geometry;
import org.gvsig.sos.lib.api.client.Procedure;

import com.vividsolutions.jts.geom.Geometry;

public interface MutableProcedure extends Procedure {
	/**
	 * Sets the identifiers of the procedures.
	 */
    public void setIdentifiers(List<String> identifiers);

    /**
     * Sets the list of classifiers of the procedures.
     * @param classifiers the list of classifiers of the sensor.
     */
    public void setClassifiers(List<String> classifiers);
    
    /**
     * Sets the list of outputs of the procedure.
     * @param outputs the list of the outputs of the sensor
     */
    public void setOutputs(List<String> outputs);
    
    /**
     * Sets the list of the inputs of the procedure.
     * @param inputs the list of inputs of the sensor.
     */
    public void setInputs(List<String> inputs);
    
    /**
     * Sets the position of the procedure as published in the SensorML document.
     */
    public void setPosition(Geometry position);
    
    /**
     * Retrieves the list of components of the procedures.
     * @return the components of the procedure.
     */
    public void setComponents(List<Procedure> components);

}
