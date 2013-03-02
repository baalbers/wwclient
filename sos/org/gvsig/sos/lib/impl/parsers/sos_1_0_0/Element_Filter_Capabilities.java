package org.gvsig.sos.lib.impl.parsers.sos_1_0_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Filter_Capabilities extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ogc.Spatial_CapabilitiesType Spatial_Capabilities;
  	private org.gvsig.sos.lib.impl.parsers.ogc.Temporal_CapabilitiesType Temporal_Capabilities;
  	private org.gvsig.sos.lib.impl.parsers.ogc.Scalar_CapabilitiesType Scalar_Capabilities;
  	private org.gvsig.sos.lib.impl.parsers.ogc.Id_CapabilitiesType Id_Capabilities;
  	
	public Element_Filter_Capabilities(String tagName) {
		super(tagName);
	}
	
  	public void setSpatial_Capabilities(org.gvsig.sos.lib.impl.parsers.ogc.Spatial_CapabilitiesType value){
  		this.Spatial_Capabilities = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.Spatial_CapabilitiesType getSpatial_Capabilities(){
  		return Spatial_Capabilities; 	
  	} 
  	public void setTemporal_Capabilities(org.gvsig.sos.lib.impl.parsers.ogc.Temporal_CapabilitiesType value){
  		this.Temporal_Capabilities = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.Temporal_CapabilitiesType getTemporal_Capabilities(){
  		return Temporal_Capabilities; 	
  	} 
  	public void setScalar_Capabilities(org.gvsig.sos.lib.impl.parsers.ogc.Scalar_CapabilitiesType value){
  		this.Scalar_Capabilities = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.Scalar_CapabilitiesType getScalar_Capabilities(){
  		return Scalar_Capabilities; 	
  	} 
  	public void setId_Capabilities(org.gvsig.sos.lib.impl.parsers.ogc.Id_CapabilitiesType value){
  		this.Id_Capabilities = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.Id_CapabilitiesType getId_Capabilities(){
  		return Id_Capabilities; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_SPATIAL_CAPABILITIES)==0){
					try{
						Spatial_Capabilities = new org.gvsig.sos.lib.impl.parsers.ogc.Spatial_CapabilitiesType(nextTagName);
						Spatial_Capabilities.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORAL_CAPABILITIES)==0){
					try{
						Temporal_Capabilities = new org.gvsig.sos.lib.impl.parsers.ogc.Temporal_CapabilitiesType(nextTagName);
						Temporal_Capabilities.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_SCALAR_CAPABILITIES)==0){
					try{
						Scalar_Capabilities = new org.gvsig.sos.lib.impl.parsers.ogc.Scalar_CapabilitiesType(nextTagName);
						Scalar_Capabilities.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_ID_CAPABILITIES)==0){
					try{
						Id_Capabilities = new org.gvsig.sos.lib.impl.parsers.ogc.Id_CapabilitiesType(nextTagName);
						Id_Capabilities.fromXML(parser);
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
		
