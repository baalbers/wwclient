package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TimeInstantType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType timePosition;
  	
	public TimeInstantType(String tagName) {
		super(tagName);
	}
	
  	public void setTimePosition(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType value){
  		this.timePosition = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType getTimePosition(){
  		return timePosition; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;				     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEPOSITION)==0){
					try{
						timePosition = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType(nextTagName);
						timePosition.fromXML(parser);
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
		
