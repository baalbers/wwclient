package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class AnyScalarPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity Quantity;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time Time;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Boolean Boolean;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text Text;
  	
	public AnyScalarPropertyType(String tagName) {
		super(tagName);
	}
  	public void setName(java.lang.String value){
  		this.name = value;
  	}
  	public java.lang.String getName(){
  		return name; 	
  	} 
	
  	public void setQuantity(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity value){
  		this.Quantity = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity getQuantity(){
  		return Quantity; 	
  	} 
  	public void setTime(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time value){
  		this.Time = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time getTime(){
  		return Time; 	
  	} 
  	public void setBoolean(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Boolean value){
  		this.Boolean = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Boolean getBoolean(){
  		return Boolean; 	
  	} 
  	
	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text getText() {
		return Text;
	}
	public void setText(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text text) {
		Text = text;
	}
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_QUANTITY)==0){
					try{
						Quantity = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity(nextTagName);
						Quantity.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_TIME)==0){
					try{
						Time = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time(nextTagName);
						Time.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_BOOLEAN)==0){
					try{
						Boolean = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Boolean(nextTagName);
						Boolean.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					 if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_TEXT)==0){
							try{
								Text = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text(nextTagName);
								Text.fromXML(parser);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SWE_NAME_1_2);
		
	}

}
		
