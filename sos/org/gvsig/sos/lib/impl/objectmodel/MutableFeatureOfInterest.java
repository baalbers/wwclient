package org.gvsig.sos.lib.impl.objectmodel;

//import org.gvsig.fmap.geom.Geometry;
import org.gvsig.sos.lib.api.client.FeatureOfInterest;
import org.gvsig.sos.lib.impl.parsers.Coordinates;

import com.vividsolutions.jts.geom.Geometry;

public interface MutableFeatureOfInterest extends FeatureOfInterest{
   /**
	* Sets the geometry representing the feature of interest. 
	* @return the geometry of the feature.
	*/
   public void setLocation(Geometry location);
   
   /**
    * Sets the identifier of the feature.
    * @return the identifier of the feature.
    */
   public void setIdentifier(String identifier);
   
   /**
    * Sets the coordinates to be able to set the location of the feature of interest.
    * @param coord The coordinates of the feature of interest.
    */
   public void setCoordinates(Coordinates coord);
}
