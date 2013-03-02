package org.gvsig.sos.lib.impl.parsers.om_1_0_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ObservationPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String href;
	
  	private org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType Observation;
  	
	public ObservationPropertyType(String tagName) {
		super(tagName);
	}
  	public void setHref(java.lang.String value){
  		this.href = value;
  	}
  	public java.lang.String getHref(){
  		return href; 	
  	} 
	
  	public void setObservation(org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType value){
  		this.Observation = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType getObservation(){
  		return Observation; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_OBSERVATION)==0){
					try{
						Observation = new org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType(nextTagName);
						Observation.fromXML(parser);
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
			    href = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.XLINK_HREF);
		
	}

}
		
