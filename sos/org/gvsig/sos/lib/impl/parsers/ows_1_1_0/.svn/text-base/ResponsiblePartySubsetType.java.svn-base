package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ResponsiblePartySubsetType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private java.lang.String IndividualName;
  	private java.lang.String PositionName;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ContactType ContactInfo;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType Role;
  	
	public ResponsiblePartySubsetType(String tagName) {
		super(tagName);
	}
	
  	public void setIndividualName(java.lang.String value){
  		this.IndividualName = value;
  	}
  	public java.lang.String getIndividualName(){
  		return IndividualName; 	
  	} 
  	public void setPositionName(java.lang.String value){
  		this.PositionName = value;
  	}
  	public java.lang.String getPositionName(){
  		return PositionName; 	
  	} 
  	public void setContactInfo(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ContactType value){
  		this.ContactInfo = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ContactType getContactInfo(){
  		return ContactInfo; 	
  	} 
  	public void setRole(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType value){
  		this.Role = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType getRole(){
  		return Role; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_INDIVIDUALNAME)==0){
				try{
				    IndividualName = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_POSITIONNAME)==0){
				try{
				    PositionName = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_CONTACTINFO)==0){
					try{
						ContactInfo = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ContactType(nextTagName);
						ContactInfo.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ROLE)==0){
					try{
						Role = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType(nextTagName);
						Role.fromXML(parser);
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
		
