package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TimeGeometricPrimitivePropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType _timePeriod;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInstantType _timeInstant;
  	
	public TimeGeometricPrimitivePropertyType(String tagName) {
		super(tagName);
	}
	
  	public void setTimePeriod(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType value){
  		this._timePeriod = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType getTimePeriod(){
  		return _timePeriod; 	
  	} 
  	
 	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInstantType getTimeInstant() {
		return _timeInstant;
	}

	public void setTimeInstant(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInstantType _timeInstant) {
		this._timeInstant = _timeInstant;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEPERIOD)==0){
							try{
								_timePeriod = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType(nextTagName);
								_timePeriod.fromXML(parser);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else 
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEINSTANT)==0){
								try{
									_timeInstant = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInstantType(nextTagName);
									_timeInstant.fromXML(parser);
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
		
