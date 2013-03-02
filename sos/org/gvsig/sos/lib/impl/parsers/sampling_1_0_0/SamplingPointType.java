package org.gvsig.sos.lib.impl.parsers.sampling_1_0_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;



public class SamplingPointType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType name;
	private java.lang.String gmlId;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType sampledFeature;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType position;
  	
	public SamplingPointType(String tagName) {
		super(tagName);
	}
	
  	public void setName(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType value){
  		this.name = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType getName(){
  		return name; 	
  	} 
  	public void setSampledFeature(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType value){
  		this.sampledFeature = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType getSampledFeature(){
  		return sampledFeature; 	
  	} 
  	public void setPosition(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType value){
  		this.position = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType getPosition(){
  		return position; 	
  	} 
  	
  	
  	
	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType getDescription() {
		return description;
	}

	public void setDescription(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description) {
		this.description = description;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException {
		boolean m_localResult = false;
		
		 if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_DESCRIPTION)==0){
				try{
					description = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType(nextTagName);
					description.fromXML(parser);
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
			
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_NAME)==0){
					try{
						name = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType(nextTagName);
						name.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SMP_SAMPLEDFEATURE)==0){
					try{
						sampledFeature = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType(nextTagName);
						sampledFeature.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_POINT)==0){
					try{
						position = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType(nextTagName);
						position.fromXML(parser);
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
	
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		 super.processAttributes(parser); 
			    gmlId = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.GML_ID);
		
	}

	public void setGMLId(java.lang.String gmlId) {
		this.gmlId = gmlId;
	}

	public java.lang.String getGMLId() {
		return gmlId;
	}	
		

}
		
