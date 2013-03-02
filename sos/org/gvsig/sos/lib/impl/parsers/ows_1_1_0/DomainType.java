package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class DomainType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AllowedValues AllowedValues;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AnyValue AnyValue;
  	
	public DomainType(String tagName) {
		super(tagName);
	}
  	public void setName(java.lang.String value){
  		this.name = value;
  	}
  	public java.lang.String getName(){
  		return name; 	
  	} 
	
  	public void setAllowedValues(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AllowedValues value){
  		this.AllowedValues = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AllowedValues getAllowedValues(){
  		return AllowedValues; 	
  	} 
  	public void setAnyValue(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AnyValue value){
  		this.AnyValue = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AnyValue getAnyValue(){
  		return AnyValue; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ALLOWEDVALUES)==0){
					try{
						AllowedValues = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AllowedValues(nextTagName);
						AllowedValues.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
					
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ANYVALUE)==0){
					try{
						AnyValue = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AnyValue(nextTagName);
						AnyValue.fromXML(parser);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.OWS_NAME);
		
	}

}
		
