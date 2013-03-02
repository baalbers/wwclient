package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class DataArrayType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_elementCount elementCount;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType elementType;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.BlockEncodingPropertyType encoding;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataValuePropertyType values;
  	
	public DataArrayType(String tagName) {
		super(tagName);
	}
	
  	public void setElementCount(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_elementCount value){
  		this.elementCount = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_elementCount getElementCount(){
  		return elementCount; 	
  	} 
  	public void setElementType(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType value){
  		this.elementType = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType getElementType(){
  		return elementType; 	
  	} 
  	public void setEncoding(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.BlockEncodingPropertyType value){
  		this.encoding = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.BlockEncodingPropertyType getEncoding(){
  		return encoding; 	
  	} 
  	public void setValues(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataValuePropertyType value){
  		this.values = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataValuePropertyType getValues(){
  		return values; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ELEMENTCOUNT)==0){
					try{
						elementCount = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_elementCount(nextTagName);
						elementCount.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ELEMENTTYPE)==0){
					try{
						elementType = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType(nextTagName);
						elementType.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ENCODING)==0){
					try{
						encoding = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.BlockEncodingPropertyType(nextTagName);
						encoding.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_VALUES)==0){
					try{
						values = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataValuePropertyType(nextTagName);
						values.fromXML(parser);
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
		
