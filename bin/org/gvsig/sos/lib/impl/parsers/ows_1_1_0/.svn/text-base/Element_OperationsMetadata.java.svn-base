package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_OperationsMetadata extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation> OperationList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> ParameterList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> ConstraintList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType>();
  	
	public Element_OperationsMetadata(String tagName) {
		super(tagName);
	}
	
  	public void setOperationList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation> value){
  		this.OperationList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation> getOperationList(){
  		return OperationList;	
  	}   
  	public void setParameterList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> value){
  		this.ParameterList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> getParameterList(){
  		return ParameterList;	
  	}   
  	public void setConstraintList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> value){
  		this.ConstraintList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType> getConstraintList(){
  		return ConstraintList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_OPERATION)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation auxOperation = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation(org.gvsig.sos.lib.impl.parsers.Constants.OWS_OPERATION);
					auxOperation.fromXML(parser);
					 getOperationList().add(auxOperation);
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
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_CONSTRAINT)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType auxConstraint = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_CONSTRAINT);
					auxConstraint.fromXML(parser);
					 getConstraintList().add(auxConstraint);
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
		
