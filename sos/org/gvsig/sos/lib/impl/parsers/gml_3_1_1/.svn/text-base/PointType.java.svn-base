package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class PointType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType pos;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CoordinatesType coordinates;
  	
	public PointType(String tagName) {
		super(tagName);
	}
	
  	public void setCoordinates(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CoordinatesType value){
  		this.coordinates = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CoordinatesType getCoordinates(){
  		return coordinates; 	
  	} 
  	
  	
  	
	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType getPos() {
		return pos;
	}

	public void setPos(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType pos) {
		this.pos = pos;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_COORDINATES)==0){
					try{
						coordinates = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CoordinatesType(nextTagName);
						coordinates.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else  if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_POS)==0){
					try{
						pos = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType(nextTagName);
						pos.fromXML(parser);
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
		
