package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class IoComponentPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity Quantity;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType AbstractDataArray;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_ObservableProperty ObservableProperty;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text Text;
  	
	public IoComponentPropertyType(String tagName) {
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
  	public void setAbstractDataArray(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType value){
  		this.AbstractDataArray = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType getAbstractDataArray(){
  		return AbstractDataArray; 	
  	} 
  	public void setObservableProperty(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_ObservableProperty value){
  		this.ObservableProperty = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_ObservableProperty getObservableProperty(){
  		return ObservableProperty; 	
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
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ABSTRACTDATAARRAY)==0){
					try{
						AbstractDataArray = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType(nextTagName);
						AbstractDataArray.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_DATAARRAY)==0){
							try{
								AbstractDataArray = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType(nextTagName);
								AbstractDataArray.fromXML(parser);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else 
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_OBSERVABLEPROPERTY)==0){
					try{
						ObservableProperty = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_ObservableProperty(nextTagName);
						ObservableProperty.fromXML(parser);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SML_NAME_1);
		
	}

}
		
