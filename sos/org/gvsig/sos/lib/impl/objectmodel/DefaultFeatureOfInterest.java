package org.gvsig.sos.lib.impl.objectmodel;

//
//import org.gvsig.fmap.geom.Geometry;
//import org.gvsig.fmap.geom.GeometryLocator;
//import org.gvsig.fmap.geom.exception.CreateGeometryException;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType;
import org.gvsig.tools.locator.LocatorException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class DefaultFeatureOfInterest implements MutableFeatureOfInterest {

	String identifier;
	Coordinates location;
	Geometry gvSigLocation;
	
	public DefaultFeatureOfInterest(PointType position, String identifier){
		if (position!= null){
			location = DefaultSOSProcedure.getCoordinatesFromPosition(position);
		}
	    setIdentifier(identifier);
	}

	public DefaultFeatureOfInterest(Coordinates position, String identifier){
	    location = position;
	    setIdentifier(identifier);
	}

	public DefaultFeatureOfInterest(String identifier){
	    location = null;
	    setIdentifier(identifier);
	}
	
	public Geometry getLocation() {
		try {
			if (gvSigLocation==null && location!= null) {
				Coordinate coord = new Coordinate(location.getY(), location.getX());
				GeometryFactory gf = new GeometryFactory();
				gvSigLocation = gf.createPoint(coord);
//				gvSigLocation = GeometryLocator.getGeometryManager().createPoint(location.getY(), location.getX(), Geometry.SUBTYPES.GEOM2D);
			}
//		} catch (CreateGeometryException e) {
		} catch (LocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gvSigLocation;
	}

	public void setLocation(Geometry location) {
		gvSigLocation = location;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;

	}

	public String getIdentifier() {
		return identifier;
	}

	public void setCoordinates(Coordinates coord) {
		location = coord;
	}
	
	public void setPointLocation(PointType position){
	    location = DefaultSOSProcedure.getCoordinatesFromPosition(position);
	}

}
