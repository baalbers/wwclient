package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class RangeType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType MinimumValue;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType MaximumValue;
  	
	public RangeType(String tagName) {
		super(tagName);
	}
	
  	public void setMinimumValue(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType value){
  		this.MinimumValue = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType getMinimumValue(){
  		return MinimumValue; 	
  	} 
  	public void setMaximumValue(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType value){
  		this.MaximumValue = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType getMaximumValue(){
  		return MaximumValue; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_MINIMUMVALUE)==0){
					try{
						MinimumValue = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType(nextTagName);
						MinimumValue.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_MAXIMUMVALUE)==0){
					try{
						MaximumValue = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType(nextTagName);
						MaximumValue.fromXML(parser);
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
		
