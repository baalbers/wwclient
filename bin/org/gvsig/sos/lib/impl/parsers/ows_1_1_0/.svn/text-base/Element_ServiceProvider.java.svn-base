package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_ServiceProvider extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private java.lang.String ProviderName;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType ProviderSite;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ResponsiblePartySubsetType ServiceContact;
  	
	public Element_ServiceProvider(String tagName) {
		super(tagName);
	}
	
  	public void setProviderName(java.lang.String value){
  		this.ProviderName = value;
  	}
  	public java.lang.String getProviderName(){
  		return ProviderName; 	
  	} 
  	public void setProviderSite(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType value){
  		this.ProviderSite = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType getProviderSite(){
  		return ProviderSite; 	
  	} 
  	public void setServiceContact(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ResponsiblePartySubsetType value){
  		this.ServiceContact = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ResponsiblePartySubsetType getServiceContact(){
  		return ServiceContact; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_PROVIDERNAME)==0){
				try{
				    ProviderName = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_PROVIDERSITE)==0){
					try{
						ProviderSite = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.OnlineResourceType(nextTagName);
						ProviderSite.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_SERVICECONTACT)==0){
					try{
						ServiceContact = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ResponsiblePartySubsetType(nextTagName);
						ServiceContact.fromXML(parser);
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
		
