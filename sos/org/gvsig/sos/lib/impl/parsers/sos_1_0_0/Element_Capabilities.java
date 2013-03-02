package org.gvsig.sos.lib.impl.parsers.sos_1_0_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Capabilities extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceIdentification ServiceIdentification;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceProvider ServiceProvider;
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_OperationsMetadata OperationsMetadata;
  	private org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Filter_Capabilities Filter_Capabilities;
  	private org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Contents Contents;
  	
	public Element_Capabilities(String tagName) {
		super(tagName);
	}
	
  	public void setServiceIdentification(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceIdentification value){
  		this.ServiceIdentification = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceIdentification getServiceIdentification(){
  		return ServiceIdentification; 	
  	} 
  	public void setServiceProvider(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceProvider value){
  		this.ServiceProvider = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceProvider getServiceProvider(){
  		return ServiceProvider; 	
  	} 
  	public void setOperationsMetadata(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_OperationsMetadata value){
  		this.OperationsMetadata = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_OperationsMetadata getOperationsMetadata(){
  		return OperationsMetadata; 	
  	} 
  	public void setFilter_Capabilities(org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Filter_Capabilities value){
  		this.Filter_Capabilities = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Filter_Capabilities getFilter_Capabilities(){
  		return Filter_Capabilities; 	
  	} 
  	public void setContents(org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Contents value){
  		this.Contents = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Contents getContents(){
  		return Contents; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_SERVICEIDENTIFICATION)==0){
					try{
						ServiceIdentification = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceIdentification(nextTagName);
						ServiceIdentification.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_SERVICEPROVIDER)==0){
					try{
						ServiceProvider = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceProvider(nextTagName);
						ServiceProvider.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_OPERATIONSMETADATA)==0){
					try{
						OperationsMetadata = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_OperationsMetadata(nextTagName);
						OperationsMetadata.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_FILTER_CAPABILITIES)==0){
					try{
						Filter_Capabilities = new org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Filter_Capabilities(nextTagName);
						Filter_Capabilities.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_CONTENTS)==0){
					try{
						Contents = new org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Contents(nextTagName);
						Contents.fromXML(parser);
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
		
