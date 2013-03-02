package wwclient.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPathConstants;

import org.geotools.data.*;
import org.geotools.data.simple.*;
import org.geotools.data.wfs.*;
import org.opengis.feature.simple.SimpleFeature;

//import wwclient.views.WorldViewPart;
import wwclient.views.WorldWindAWTViewPart;

import com.vividsolutions.jts.geom.Point;

import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.render.airspaces.AirspaceAttributes;
import gov.nasa.worldwind.render.airspaces.BasicAirspaceAttributes;
import gov.nasa.worldwind.render.airspaces.CappedCylinder;


public class WFSParser {
	
//	private RenderableLayer wfsLayer;
//	private AirspaceAttributes attrs;
//	private WorldViewPart worldview;
//	protected final URI serverURI;
//	private final String server;
	
	// needed to update the View to move to the extent of the new layer
//	private double maxX = Double.MIN_VALUE;
//	private double minX = Double.MAX_VALUE;
//	private double maxY = Double.MIN_VALUE;
//	private double minY = Double.MAX_VALUE;
//	private LatLon updateLocation;
	
	public static DataStore getWFSData(String server, WorldWindAWTViewPart worldview) {
//		SimpleFeatureCollection result = null;
		DataStore datastore;
		try {
			Map<String, Serializable> params = new HashMap<String, Serializable>();
			params.put(WFSDataStoreFactory.URL.key, server);
			params.put(WFSDataStoreFactory.TIMEOUT.key, new Integer(60000));
			// holt die Daten in einen DataStore
			datastore = DataStoreFinder.getDataStore(params);
			return datastore;
//			// TODO: Wir wollen erstmal nur die Pegelstände
//			SimpleFeatureSource featureSource = datastore.getFeatureSource("gk:waterlevels");
//			// Ergebnis als Collection sichern
//			result = featureSource.getFeatures();
		} catch(Exception e) {
			new RuntimeException("Unable to get the target collection", e);
			return null;
		}
	}
	
	public static void getFeature(String typeName, DataStore ds) {
		try {
			TimeSeriesLayer layer = new TimeSeriesLayer();
	 		layer.setValue("isTimelineLayer", true);
	 		
	 		layer.setName("TEST");
	 		
			SimpleFeatureSource featureSource = ds.getFeatureSource(typeName);
			SimpleFeatureCollection result = featureSource.getFeatures();
			SimpleFeatureIterator iterator = result.features();
			while( iterator.hasNext() ) {
				SimpleFeature feature = iterator.next();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
//	/**
//	 * Gets all Features from a WFS (right now only "gk:waterlevels" as typeName)
//	 */
//	public Layer getWFSData() {
//		System.out.println("getWFSData is called");
//		// enthält später alle features des wfs
//		SimpleFeatureCollection result = null;
////		String wfsGetCap = this.serverURI.toString();
//		// Anfrage an WFS stellen
//		try {
//			Map<String, Serializable> params = new HashMap<String, Serializable>();
//			params.put(WFSDataStoreFactory.URL.key, this.server);
//			params.put(WFSDataStoreFactory.TIMEOUT.key, new Integer(60000));
//			// holt die Daten in einen DataStore
//			DataStore datastore = DataStoreFinder.getDataStore(params);
//			// TODO: Wir wollen erstmal nur die Pegelstände
//			SimpleFeatureSource featureSource = datastore.getFeatureSource("gk:waterlevels");
//			// Ergebnis als Collection sichern
//			result = featureSource.getFeatures();
//		} catch(Exception e) {
//			new RuntimeException("Unable to get the target collection", e);
//			return null;
//		}
//		//System.out.println(result.size());
//		// alle Daten extrahieren
//		SimpleFeatureIterator iterator = result.features();
//		try {
//			while( iterator.hasNext() ){
//				SimpleFeature feature = iterator.next();
//				// TODO: irgendetwas mit den Daten anstellen
//				System.out.println( feature.getAttributes() );
//				addFeatureToWFSLayer(feature);
//			}
//		} catch(Exception e) {
//			System.out.println("Iterator Fehler: "+e);
//			return null;
//		} finally {
//			iterator.close();
//		}
//		// TODO: nur hinzufügen, wenn auch featuers gefunden wurden
//		worldview.insertBeforePlacenames(this.wfsLayer);
//		Position p = new Position(updateLocation, 0);
//		worldview.moveToLocation(p);
//		//ApplicationTemplate.insertBeforePlacenames(this.wwd, this.wfsLayer);
//		
//		return this.wfsLayer;
//	}
	
	
//	public WFSParser(String server, WorldViewPart worldview) throws URISyntaxException {
////		this.serverURI = new URI(server.trim());
//		this.server = server;
//	     // Einen neuen Layer erstellen
//        this.wfsLayer = new RenderableLayer();
//// 		this.wfsLayer.setName(this.serverURI.getHost());
//        this.wfsLayer.setName(this.server);
// 		this.wfsLayer.setValue("isTimelineLayer", true);
//        // um Speicher zu sparen, wird nur einmal ShapeAttributes gesetzt
////        this.attrs = new BasicAirspaceAttributes();
//        
////        this.attrs.setEnableLighting(true);
//        //attrs.setOutlineMaterial(Material.BLACK);
////        this.attrs.setOutlineWidth(2d);
////        this.attrs.setDrawInterior(true);
////        this.attrs.setDrawOutline(false);
//        
//        this.worldview = worldview;
//	}
	
//    /**
//     * Creates and adds a Cylinder from feature data to the layer
//     * @param feature
//     */
//	protected void addFeatureToWFSLayer(SimpleFeature feature) {
//		
//		Point p = (Point) feature.getAttribute("the_geom");
//		if(p.getX() > maxX) {
//			maxX = p.getX();
//		} else if (p.getX() < minX) {
//			minX = p.getX();
//		}
//		if(p.getY() > maxY) {
//			maxY = p.getY();
//		} else if (p.getY() < minY) {
//			minY = p.getY();
//		}
//		updateLocation = LatLon.fromDegrees(maxX, maxY);
//		LatLon latlon = LatLon.fromDegrees(p.getX(),p.getY());
//		
//        Double value = (Double) feature.getAttribute("value");
//        String station = (String) feature.getAttribute("station");
//        String trend = (String) feature.getAttribute("trend");
//        String unit = (String) feature.getAttribute("unit");
//        String tooltip = "<p>"+station+"</p><p>"+value+" "+unit+"</p><p>"+trend+"</p><p>";
//        if (value <= 0) value = 1.0;	// so we have no problem with vertical radius
//        
//		// Cylinder
//        CappedCylinder cylinder = new CappedCylinder(latlon, 2500);
//        cylinder.setAltitudes(0, 10*value);
//		
//		AirspaceAttributes attributes = new BasicAirspaceAttributes();
//		attributes.setMaterial(getColorFromTrend(trend));
//		attributes.setOpacity(0.5);
//        cylinder.setAttributes(attributes);
//
//        cylinder.setValue(AVKey.DISPLAY_NAME, tooltip);
//        // add cylinder to layer
//        this.wfsLayer.addRenderable(cylinder);
//     
//	}
	
//	public void getXMLData() throws Exception {
//        InputStream in = getClass().getResourceAsStream( "wfs1.xml");
//        GMLConfiguration gml = new GMLConfiguration();
//        StreamingParser parser = new StreamingParser( gml, in, SimpleFeature.class );
//	
//	
//        int nfeatures = 0;
//        SimpleFeature f = null;
//        while( ( f = (SimpleFeature) parser.parse() ) != null ) {
//            nfeatures++;
//            addFeatureToWFSLayer(f);
//        }
//        System.out.println(nfeatures);
//        if (nfeatures > 0) worldview.insertBeforePlacenames(this.wfsLayer);
//	}
	
//	/**
//	 * trend: Tendenz der aktuellen Messreihe. Mögliche Werte: increasing, decreasing, unchanging, unknown.
//	 * @param trend
//	 * @return
//	 */
//	private Material getColorFromTrend(String trend) {
//		if(trend.equals("increasing")) {
//			return Material.RED;
//		} else if (trend.equals("decreasing")) {
//			return Material.YELLOW;
//		} else if (trend.equals("unchanging")) {
//			return Material.GREEN;
//		} else if (trend.equals("unknown")) {
//			return Material.WHITE;
//		} else {
//			return Material.BLACK;
//		}
//	}
	

}
