package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ContactType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.TelephoneType Phone;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.AddressType Address;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType OnlineResource;
  	private java.lang.String HoursOfService;
  	private java.lang.String ContactInstructions;
  	
	public ContactType(String tagName) {
		super(tagName);
	}
	
  	public void setPhone(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.TelephoneType value){
  		this.Phone = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.TelephoneType getPhone(){
  		return Phone; 	
  	} 
  	public void setAddress(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.AddressType value){
  		this.Address = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.AddressType getAddress(){
  		return Address; 	
  	} 
  	public void setOnlineResource(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType value){
  		this.OnlineResource = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType getOnlineResource(){
  		return OnlineResource; 	
  	} 
  	public void setHoursOfService(java.lang.String value){
  		this.HoursOfService = value;
  	}
  	public java.lang.String getHoursOfService(){
  		return HoursOfService; 	
  	} 
  	public void setContactInstructions(java.lang.String value){
  		this.ContactInstructions = value;
  	}
  	public java.lang.String getContactInstructions(){
  		return ContactInstructions; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_PHONE)==0){
					try{
						Phone = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.TelephoneType(nextTagName);
						Phone.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ADDRESS)==0){
					try{
						Address = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.AddressType(nextTagName);
						Address.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ONLINERESOURCE)==0){
					try{
						OnlineResource = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType(nextTagName);
						OnlineResource.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_HOURSOFSERVICE)==0){
				try{
				    HoursOfService = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_CONTACTINSTRUCTIONS)==0){
				try{
				    ContactInstructions = parser.nextText();
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
		
