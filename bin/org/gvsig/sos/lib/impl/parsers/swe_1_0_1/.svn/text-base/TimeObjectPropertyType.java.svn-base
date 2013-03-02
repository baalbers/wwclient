package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TimeObjectPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private XMLInstanceTag _TimeObject;
  	
	public TimeObjectPropertyType(String tagName) {
		super(tagName);
	}
	
  	public void set_TimeObject(XMLInstanceTag value){
  		this._TimeObject = value;
  	}
  	public XMLInstanceTag get_TimeObject(){
  		return _TimeObject; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			  if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEPERIOD)==0){
							try{
								_TimeObject = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType(nextTagName);
								_TimeObject.fromXML(parser);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else 
							if (nextTagName.toLowerCase().compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEINSTANT.toLowerCase())==0){
							try{
								_TimeObject = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInstantType(nextTagName);
								_TimeObject.fromXML(parser);
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
		
