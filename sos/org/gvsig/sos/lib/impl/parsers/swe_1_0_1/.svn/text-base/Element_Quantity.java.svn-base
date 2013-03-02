package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Quantity extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType> metaDataPropertyList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType>();
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType uom;
  	private Double value;
  	private String definition;

  	
	public Element_Quantity(String tagName) {
		super(tagName);
	}
	
  	public void setMetaDataPropertyList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType> value){
  		this.metaDataPropertyList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType> getMetaDataPropertyList(){
  		return metaDataPropertyList;	
  	}   
  	public void setUom(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType value){
  		this.uom = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType getUom(){
  		return uom; 	
  	} 
  	public void setValue(Double value){
  		this.value = value;
  	}
  	public Double getValue(){
  		return value; 	
  	} 
  	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_METADATAPROPERTY)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType auxMetaDataProperty = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.MetaDataPropertyType(org.gvsig.sos.lib.impl.parsers.Constants.GML_METADATAPROPERTY);
					auxMetaDataProperty.fromXML(parser);
					 getMetaDataPropertyList().add(auxMetaDataProperty);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_UOM)==0){
					try{
						uom = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType(nextTagName);
						uom.fromXML(parser);
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
			} else 
		
		     
		
		
			  
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
	 
	protected void processAttributes(XmlPullParser parser)
			throws IllegalConvertionException {
		super.processAttributes(parser);
		definition = getAttributeValue(parser, "definition");
	}
		

}
		
