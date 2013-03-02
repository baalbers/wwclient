package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TemporalOperatorType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType TemporalOperands;
  	
	public TemporalOperatorType(String tagName) {
		super(tagName);
	}
  	public void setName(java.lang.String value){
  		this.name = value;
  	}
  	public java.lang.String getName(){
  		return name; 	
  	} 
	
  	public void setTemporalOperands(org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType value){
  		this.TemporalOperands = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType getTemporalOperands(){
  		return TemporalOperands; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERANDS)==0){
					try{
						TemporalOperands = new org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType(nextTagName);
						TemporalOperands.fromXML(parser);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.OGC_NAME);
		
	}

}
		
