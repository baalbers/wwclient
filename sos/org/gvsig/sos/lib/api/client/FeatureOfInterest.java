package org.gvsig.sos.lib.api.client;

import com.vividsolutions.jts.geom.Geometry;

//import org.gvsig.fmap.geom.Geometry;

/**
 * This interface allows accessing the functionality related with a feature of interest. 
 * A feature of interest can be (but is not restricted to) a certain location 
 * where some the measures are performed. The identifier is used to label the feature.
 * @author lrodriguez
 *
 */
public interface FeatureOfInterest {
   /**
	* Returns the geometry representing the feature of interest. 
	* @return the geometry of the feature.
	*/
   public Geometry getLocation();
   
   /**
    * Returns the identifier of the feature.
    * @return the identifier of the feature.
    */
   public String getIdentifier();
   
}
