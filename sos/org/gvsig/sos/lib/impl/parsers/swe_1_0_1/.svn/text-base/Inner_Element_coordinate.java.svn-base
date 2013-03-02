package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Inner_Element_coordinate extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity Quantity;

	private double value;
  	
	public Inner_Element_coordinate(String tagName) {
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
  	
  	public void setValue(Double value){
  		this.value = value;
  	}
  	
  	public Double getValue(){
  		return value; 	
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
				
					if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_VALUE)==0){
						try{
							    java.lang.String auxValue = parser.nextText();
								value = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.convertToDouble(auxValue);
						
							m_localResult = true;
						}catch(Exception e){
							doLog("Error processing: " + nextTagName, e);
							m_localResult = false;
						}
					} 
					else 
		
			  
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		 super.processAttributes(parser); 
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SWE_NAME);
		
	}

}
		
