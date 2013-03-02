package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Operation extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP> DCPList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> ParameterList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType>();
  	
	public Element_Operation(String tagName) {
		super(tagName);
	}
  	public void setName(java.lang.String value){
  		this.name = value;
  	}
  	public java.lang.String getName(){
  		return name; 	
  	} 
	
  	public void setDCPList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP> value){
  		this.DCPList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP> getDCPList(){
  		return DCPList;	
  	}   
  	public void setParameterList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> value){
  		this.ParameterList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> getParameterList(){
  		return ParameterList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_DCP)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP auxDCP = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_DCP(org.gvsig.sos.lib.impl.parsers.Constants.OWS_DCP);
					auxDCP.fromXML(parser);
					 getDCPList().add(auxDCP);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_PARAMETER)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType auxParameter = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_PARAMETER);
					auxParameter.fromXML(parser);
					 getParameterList().add(auxParameter);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.OWS_NAME_1);
		
	}

}
		
