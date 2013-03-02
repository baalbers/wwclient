package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_ServiceIdentification extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> TitleList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> AbstractList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType>();
  	org.gvsig.sos.lib.impl.parsers.ows_1_1_0.KeywordsType Keywords;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType ServiceType;
  	private List<java.lang.String> ServiceTypeVersionList = new ArrayList<java.lang.String>();
  	private java.lang.String Fees;
  	private List<java.lang.String> AccessConstraintsList = new ArrayList<java.lang.String>();
  	
	public Element_ServiceIdentification(String tagName) {
		super(tagName);
	}
	
  	public void setTitleList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> value){
  		this.TitleList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> getTitleList(){
  		return TitleList;	
  	}   
  	public void setAbstractList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> value){
  		this.AbstractList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> getAbstractList(){
  		return AbstractList;	
  	}   
  	public void setKeywordsList(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.KeywordsType value){
  		this.Keywords = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.KeywordsType getKeywordsList(){
  		return Keywords;	
  	}   
  	public void setServiceType(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType value){
  		this.ServiceType = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType getServiceType(){
  		return ServiceType; 	
  	} 
  	public void setServiceTypeVersionList(List<java.lang.String> value){
  		this.ServiceTypeVersionList = value;
  	}
  	public List<java.lang.String> getServiceTypeVersionList(){
  		return ServiceTypeVersionList;	
  	}   
  	public void setFees(java.lang.String value){
  		this.Fees = value;
  	}
  	public java.lang.String getFees(){
  		return Fees; 	
  	} 
  	public void setAccessConstraintsList(List<java.lang.String> value){
  		this.AccessConstraintsList = value;
  	}
  	public List<java.lang.String> getAccessConstraintsList(){
  		return AccessConstraintsList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_TITLE)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType auxTitle = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_TITLE);
					auxTitle.fromXML(parser);
					 getTitleList().add(auxTitle);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ABSTRACT)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType auxAbstract = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ABSTRACT);
					auxAbstract.fromXML(parser);
					 getAbstractList().add(auxAbstract);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.toLowerCase().compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_KEYWORDS.toLowerCase())==0){
					try{
					Keywords = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.KeywordsType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_KEYWORDS);
					Keywords.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_SERVICETYPE)==0){
					try{
						ServiceType = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType(nextTagName);
						ServiceType.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_SERVICETYPEVERSION)==0){
			try{
			    java.lang.String auxServiceTypeVersion = parser.nextText();
			    getServiceTypeVersionList().add(auxServiceTypeVersion);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_FEES)==0){
				try{
				    Fees = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
		
		
			  
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_ACCESSCONSTRAINTS)==0){
			try{
			    java.lang.String auxAccessConstraints = parser.nextText();
			    getAccessConstraintsList().add(auxAccessConstraints);
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
		
