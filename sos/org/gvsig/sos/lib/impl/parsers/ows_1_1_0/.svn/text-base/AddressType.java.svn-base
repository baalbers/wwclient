package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class AddressType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<java.lang.String> DeliveryPointList = new ArrayList<java.lang.String>();
  	private java.lang.String City;
  	private java.lang.String AdministrativeArea;
  	private java.lang.String PostalCode;
  	private java.lang.String Country;
  	private List<java.lang.String> ElectronicMailAddressList = new ArrayList<java.lang.String>();
  	
	public AddressType(String tagName) {
		super(tagName);
	}
	
  	public void setDeliveryPointList(List<java.lang.String> value){
  		this.DeliveryPointList = value;
  	}
  	public List<java.lang.String> getDeliveryPointList(){
  		return DeliveryPointList;	
  	}   
  	public void setCity(java.lang.String value){
  		this.City = value;
  	}
  	public java.lang.String getCity(){
  		return City; 	
  	} 
  	public void setAdministrativeArea(java.lang.String value){
  		this.AdministrativeArea = value;
  	}
  	public java.lang.String getAdministrativeArea(){
  		return AdministrativeArea; 	
  	} 
  	public void setPostalCode(java.lang.String value){
  		this.PostalCode = value;
  	}
  	public java.lang.String getPostalCode(){
  		return PostalCode; 	
  	} 
  	public void setCountry(java.lang.String value){
  		this.Country = value;
  	}
  	public java.lang.String getCountry(){
  		return Country; 	
  	} 
  	public void setElectronicMailAddressList(List<java.lang.String> value){
  		this.ElectronicMailAddressList = value;
  	}
  	public List<java.lang.String> getElectronicMailAddressList(){
  		return ElectronicMailAddressList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_DELIVERYPOINT)==0){
			try{
			    java.lang.String auxDeliveryPoint = parser.nextText();
			    getDeliveryPointList().add(auxDeliveryPoint);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_CITY)==0){
				try{
				    City = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ADMINISTRATIVEAREA)==0){
				try{
				    AdministrativeArea = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_POSTALCODE)==0){
				try{
				    PostalCode = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_COUNTRY)==0){
				try{
				    Country = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ELECTRONICMAILADDRESS)==0){
			try{
			    java.lang.String auxElectronicMailAddress = parser.nextText();
			    getElectronicMailAddressList().add(auxElectronicMailAddress);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		

}
		
