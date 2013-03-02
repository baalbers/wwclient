package org.gvsig.sos.lib.api.client;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

//import org.gvsig.fmap.geom.Geometry;

/**
 * This interface allows accessing the information related with a procedure.
 * @author lrodriguez
 *
 */
public interface Procedure {
	
	
	/**
	 * Gives the Id of the procedure as advertised in the
	 * Capabilities and is the one that should be used in the 
	 * GetObservation operation. 
	 * @return
	 */
	public String getId();
	
	/**
	 * Retrieves the identifiers of the procedures.
	 * @return the list of identifiers.
	 */
    public List<String> getIdentifiers();

    /**
     * Returns the list of classifiers of the procedures.
     * @return the list of classifiers.
     */
    public List<String> getClassifiers();
    
    /**
     * Gives the list of outputs of the procedure.
     * @return a list containing the information of the outputs.
     */
    public List<String> getOutputs();
    
    /**
     * Gives the list of the inputs of the procedure.
     * @return a list containing the information of the 
     */
    public List<String> getInputs();
    
    /**
     * Gives the position of the procedure as published in the SensorML document.
     * @return the position of the procedure.
     */
    public Geometry getPosition();
    
    /**
     * Retrieves the list of components of the procedures.
     * @return the components of the procedure.
     */
    public List<Procedure> getComponents();
    
    
    /**
     * Retrieves the observed properties handled by this procedure.
     * @return
     */
    public List<ObservedProperty> getObservedProperties();
}
