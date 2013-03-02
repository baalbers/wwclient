package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class CompositePhenomenonType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> nameList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType>();
  	private List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> componentList = new ArrayList<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType>();
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description;
  	
	public CompositePhenomenonType(String tagName) {
		super(tagName);
	}
	
  	public void setNameList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> value){
  		this.nameList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> getNameList(){
  		return nameList;	
  	}   
  	public void setComponentList(List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> value){
  		this.componentList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> getComponentList(){
  		return componentList;	
  	}   
  	
  	public void setDescription(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType value){
  		this.description = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType getDescription(){
  		return description; 	
  	} 
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_NAME)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType auxName = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType(org.gvsig.sos.lib.impl.parsers.Constants.GML_NAME);
					auxName.fromXML(parser);
					 getNameList().add(auxName);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_COMPONENT)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType auxComponent = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType(org.gvsig.sos.lib.impl.parsers.Constants.SWE_COMPONENT);
					auxComponent.fromXML(parser);
					 getComponentList().add(auxComponent);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
					 if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_DESCRIPTION)==0){
							try{
								description = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType(nextTagName);
								description.fromXML(parser);
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
		
