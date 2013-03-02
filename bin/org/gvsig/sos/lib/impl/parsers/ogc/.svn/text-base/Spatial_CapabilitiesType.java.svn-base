package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Spatial_CapabilitiesType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ogc.GeometryOperandsType GeometryOperands;
  	private org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorsType SpatialOperators;
  	
	public Spatial_CapabilitiesType(String tagName) {
		super(tagName);
	}
	
  	public void setGeometryOperands(org.gvsig.sos.lib.impl.parsers.ogc.GeometryOperandsType value){
  		this.GeometryOperands = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.GeometryOperandsType getGeometryOperands(){
  		return GeometryOperands; 	
  	} 
  	public void setSpatialOperators(org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorsType value){
  		this.SpatialOperators = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorsType getSpatialOperators(){
  		return SpatialOperators; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_GEOMETRYOPERANDS)==0){
					try{
						GeometryOperands = new org.gvsig.sos.lib.impl.parsers.ogc.GeometryOperandsType(nextTagName);
						GeometryOperands.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_SPATIALOPERATORS)==0){
					try{
						SpatialOperators = new org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorsType(nextTagName);
						SpatialOperators.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		

}
		
