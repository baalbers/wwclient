package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class EnvelopeType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String srsName;
	   	private int srsDimension;
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType lowerCorner;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType upperCorner;
  	
	public EnvelopeType(String tagName) {
		super(tagName);
	}
  	public void setSrsName(java.lang.String value){
  		this.srsName = value;
  	}
  	public java.lang.String getSrsName(){
  		return srsName; 	
  	} 
  	public void setSrsDimension(int value){
  		this.srsDimension = value;
  	}
  	public int getSrsDimension(){
  		return srsDimension; 	
  	} 
	
  	public void setLowerCorner(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType value){
  		this.lowerCorner = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType getLowerCorner(){
  		return lowerCorner; 	
  	} 
  	public void setUpperCorner(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType value){
  		this.upperCorner = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType getUpperCorner(){
  		return upperCorner; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_LOWERCORNER)==0){
					try{
						lowerCorner = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType(nextTagName);
						lowerCorner.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_UPPERCORNER)==0){
					try{
						upperCorner = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType(nextTagName);
						upperCorner.fromXML(parser);
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
			    srsName = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.GML_SRSNAME_1);
		
				    java.lang.String auxSrsDimension = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.GML_SRSDIMENSION);
				    if (auxSrsDimension != null)
						srsDimension = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.convertToInt(auxSrsDimension);
			
		
	}

}
		
