package wwclient.utils;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.xpath.XPathConstants;


import org.geotools.gml3.GMLConfiguration;
import org.geotools.xml.StreamingParser;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Point;

import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.airspaces.AirspaceAttributes;
import gov.nasa.worldwind.render.airspaces.BasicAirspaceAttributes;
import gov.nasa.worldwind.render.airspaces.CappedCylinder;
//import wwclient.views.WorldViewPart;
import wwclient.views.WorldWindAWTViewPart;

public class XMLParser {
	
	/**
     * Creates and adds a Cylinder from feature data to the layer
     * @param feature
     */
	private static void addFeatureToLayer(SimpleFeature feature, TimeSeriesLayer layer) {
      
		Point p = (Point) feature.getAttribute("the_geom");
		LatLon latlon = LatLon.fromDegrees(p.getX(),p.getY());
		
        Double value = (Double) feature.getAttribute("value");
        String station = (String) feature.getAttribute("station");
        String trend = (String) feature.getAttribute("trend");
        String unit = (String) feature.getAttribute("unit");
        String tooltip = "<p>"+station+"</p><p>"+value+" "+unit+"</p><p>"+trend+"</p><p>";
        if (value <= 0) value = 1.0;	// so we have no problem with vertical radius
        
		// Cylinder
        CappedCylinder cylinder = new CappedCylinder(latlon, 2500);
        cylinder.setAltitudes(0, 10*value);
		
		AirspaceAttributes attributes = new BasicAirspaceAttributes();
		attributes.setMaterial(getColorFromTrend(trend));
		attributes.setOpacity(0.5);
        cylinder.setAttributes(attributes);

        cylinder.setValue(AVKey.DISPLAY_NAME, tooltip);
        // add cylinder to layer
        layer.addRenderable(cylinder);
	}
	
	/**
	 * 
	 * @throws Exception when Parsing failed
	 */
	public static TimeSeriesLayer getXMLData(String filePath, WorldWindAWTViewPart worldview) throws Exception {
	    // Einen neuen Layer erstellen
		TimeSeriesLayer layer = new TimeSeriesLayer();
 		layer.setValue("isTimelineLayer", true);
 		String timeStamp = parseTimeStamp(filePath);
 		layer.setName(timeStamp);
       
		// Get the xml file and start parsing
        InputStream in = new FileInputStream( filePath );
        GMLConfiguration gml = new GMLConfiguration();
        StreamingParser parser = new StreamingParser( gml, in, SimpleFeature.class );
        System.out.println( parser.toString() );
        // for each found feature in xml file
        int nfeatures = 0;
        SimpleFeature f = null;
        while( ( f = (SimpleFeature) parser.parse() ) != null ) {
            nfeatures++;
            // add this feature as a cylinder to the layer
            addFeatureToLayer(f, layer);
        }
        
        // when we found features add the new layer to the WorldView
        if (nfeatures > 0) worldview.insertBeforePlacenames(layer);
        return layer;
	}
	
	/**
	 * trend: Tendenz der aktuellen Messreihe. Mšgliche Werte: increasing, decreasing, unchanging, unknown.
	 * @param trend
	 * @return
	 */
	private static Material getColorFromTrend(String trend) {
		if(trend.equals("increasing")) {
			return Material.RED;
		} else if (trend.equals("decreasing")) {
			return Material.YELLOW;
		} else if (trend.equals("unchanging")) {
			return Material.GREEN;
		} else if (trend.equals("unknown")) {
			return Material.WHITE;
		} else {
			return Material.BLACK;
		}
	}
	
	/**
	 * 
	 * @param path
	 * @return The WFS timeStamp as a String
	 */
	private static String parseTimeStamp(String path) {
		XPathReader reader = new XPathReader(path);
		String expression = "/*/@timeStamp";
//		System.out.println(reader.read(expression,
//	      XPathConstants.STRING));
		return (String) reader.read(expression, XPathConstants.STRING);
	}
}
