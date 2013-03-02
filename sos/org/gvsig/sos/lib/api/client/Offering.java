package org.gvsig.sos.lib.api.client;

import java.util.List;

//import org.cresques.cts.IProjection;
//import org.gvsig.fmap.geom.primitive.Envelope;
import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.timesupport.Time;

import com.vividsolutions.jts.geom.Envelope;

/**
 * <p> This interface represents an offering. An offering is a group of observations
 * grouped by a certain criteria. The criteria more commonly used are the spatial
 * distribution of the observations or the time when the observations were gathered.
 * </p>
 * <p> The offering provides access to some properties such as the name, the location(an envelope
 * of the positions where the observations where gathered), the time (time period when 
 * the observations where collected), the procedures (sensors) and the observed properties.
 * </p>
 * <p>Besides, the offering offers functionality for accessing to the observations. Use the 
 * getObservations methods for accessing the observations. These methods allow to filter 
 * the observations, using spatial and temporal filters.
 * </p>
 * @author lrodriguez
 *
 */
public interface Offering {
   /**
    * Retrieves the name associated to this offering.	
    * @return The name of the offering.
    */
   public String getName();
   
   /**
    * Retrieves the identifier of this offering.
    * @return The identifier of the offering.
    */
   public String getIdentifier();
    

   /**
    * Returns the location of this offering. Usually an envelope surrounding the observations 
    * locations. 
    * @return
    */
   public Envelope getLocation();

   /**
    * Returns the time period of the observations present in the offering.
    * @return The time period where the observations have been made.
    */
   public Time getTime(); 
   
   /**
    * Gives the list of the procedures involved in this offering.
    * @return The list of procedures.
    */
   public List<Procedure> getProcedures();
   
   /**
    * Gives the observed properties present in this offering. 
    * This functions returns null if the operation getObservation haven not being called first.
    * For obtaining information about the observed properties see the method 
    * getDeclaredObservedProperties. 
    * @return The list of observed properties.
    */
   public List<ObservedProperty> getObservedProperties();

   
   /**
    * Gives the observed properties declared by the capabilities.
    * @return The list of observed properties as advertised in the capabilities.
    */
   public List<DeclaredObservedProperty> getDeclaredObservedProperties();

   
   /**
    * Retrieves a collection of observations according to the filters and parameters specified.
    * @param observedProperties List of observed properties for which data will be retrieved.
    * @param procedures List of procedures (sensors) from which the data have been gathered
    * @param timeForFiltering Instant or time period used to filter the observations.
    * @param spatialFilter Envelop used to filter the observation according to their location.
    * @return A collection of observations filtered using the specified parameters.
    */
   public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties, 
		   List<Procedure> procedures, Time timeForFiltering, 
		   Envelope spatialFilter) throws SOSException;

   /**
    * Retrieves a collection of observations according to the filters and parameters specified.
    * @param observedProperties List of observed properties for which data will be retrieved.
    * @param timeForFiltering Instant or time period used to filter the observations.
    * @param spatialFilter Envelop used to filter the observation according to their location.
    * @return A collection of observations filtered using the specified parameters.
    */
   public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties, 
		   Time  timeForFiltering, 
		   Envelope spatialFilter) throws SOSException;
  
  /**
   * Retrieves a collection of observations according to the filters and parameters specified.
   * @param observedProperties List of observed properties for which data will be retrieved.
   * @param spatialFilter Envelop used to filter the observation according to their location.
   * @return A collection of observations filtered using the specified parameters.
   */
   public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties, 
		   Envelope spatialFilter) throws SOSException;

   /**
    * Retrieves a collection of observations according to the filters and parameters specified.
    * @param observedProperties List of observed properties for which data will be retrieved.
    * @param timeForFiltering Instant or time period used to filter the observations.
    * @return A collection of observations filtered using the specified parameters.
    */
   public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties, 
		   Time timeForFiltering) throws SOSException; 
	
   /**
    * Retrieves a collection of observations according to the filters and parameters specified.
    * @param observedProperties List of observed properties for which data will be retrieved.
    * @return A collection of observations filtered using the specified parameters.
    */
   public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties) throws SOSException; 

   
   /**
    * Retrieves the features of interest available for this Offering. In general should not 
    * be expected to retrieve a valid location, of the features of interest, but an id. So the   
    * @return the list of features of interest.
    */
   public List<FeatureOfInterest> getFeaturesOfInterest();
   
   
   /**
    * Returns the projection of the data contained in this Offering.
    * @return the projection of the data.
    */
//   public IProjection getSRS();
}
