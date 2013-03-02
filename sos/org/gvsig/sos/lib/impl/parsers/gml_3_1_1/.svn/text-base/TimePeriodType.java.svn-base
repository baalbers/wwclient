package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TimePeriodType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType beginPosition;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType endPosition;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInterval timeInterval;
  	
	public TimePeriodType(String tagName) {
		super(tagName);
	}
	
  	public void setBeginPosition(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType value){
  		this.beginPosition = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType getBeginPosition(){
  		return beginPosition; 	
  	} 
  	public void setEndPosition(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType value){
  		this.endPosition = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType getEndPosition(){
  		return endPosition; 	
  	} 
  	
  	public String getIndeterminateBegin()
  	{
  		return this.beginPosition.getAttribute();
  	}
  	
  	public String getInderterminateEnd()
  	{
  		return this.endPosition.getAttribute();
  	}
  	
  	  	
	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInterval getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInterval timeInterval) {
		this.timeInterval = timeInterval;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_BEGINPOSITION)==0){
					try{
						beginPosition = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType(nextTagName);
						beginPosition.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_ENDPOSITION)==0){
					try{
						endPosition = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType(nextTagName);
						endPosition.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					 if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEINTERVAL)==0){
							try{
								timeInterval = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimeInterval(nextTagName);
								timeInterval.fromXML(parser);
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
		
