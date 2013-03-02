package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_SensorML extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String version;
	
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> identificationList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification>();
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification> classificationList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification>();
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member> memberList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member>();
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities> capabilitiesList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities>();

  	
	public Element_SensorML(String tagName) {
		super(tagName);
	}
  	public void setVersion(java.lang.String value){
  		this.version = value;
  	}
  	public java.lang.String getVersion(){
  		return version; 	
  	} 
	
  	public void setIdentificationList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> value){
  		this.identificationList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> getIdentificationList(){
  		return identificationList;	
  	}   
  	public void setClassificationList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification> value){
  		this.classificationList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification> getClassificationList(){
  		return classificationList;	
  	}   
  	public void setMemberList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member> value){
  		this.memberList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member> getMemberList(){
  		return memberList;	
  	}   
	public void setCapabilitiesList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities> value){
  		this.capabilitiesList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities> getCapabilitiesList(){
  		return capabilitiesList;	
  	} 
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_IDENTIFICATION)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification auxIdentification = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification(org.gvsig.sos.lib.impl.parsers.Constants.SML_IDENTIFICATION);
					auxIdentification.fromXML(parser);
					 getIdentificationList().add(auxIdentification);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_CLASSIFICATION)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification auxClassification = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification(org.gvsig.sos.lib.impl.parsers.Constants.SML_CLASSIFICATION);
					auxClassification.fromXML(parser);
					 getClassificationList().add(auxClassification);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_MEMBER)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member auxMember = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member(org.gvsig.sos.lib.impl.parsers.Constants.SML_MEMBER);
					auxMember.fromXML(parser);
					 getMemberList().add(auxMember);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
					 if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_CAPABILITIES)==0){
							try{
							org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities auxCapabilities = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_capabilities(org.gvsig.sos.lib.impl.parsers.Constants.SML_CAPABILITIES);
							auxCapabilities.fromXML(parser);
							 getCapabilitiesList().add(auxCapabilities);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else
							//WARNING: Ignoring characteristics here
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_CHARACTERISTICS)==0){
								try{
									IgnoredTag tag = new IgnoredTag(nextTagName);
									tag.fromXML(parser);
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
			    version = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SML_VERSION);
		
	}

}
		
