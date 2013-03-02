package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_validTime extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType TimePeriod;
  	
	public Element_validTime(String tagName) {
		super(tagName);
	}
	
  	public void setTimePeriod(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType value){
  		this.TimePeriod = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType getTimePeriod(){
  		return TimePeriod; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEPERIOD)==0){
					try{
						TimePeriod = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType(nextTagName);
						TimePeriod.fromXML(parser);
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
		
