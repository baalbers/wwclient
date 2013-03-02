package org.gvsig.sos.lib.impl.parsers.sos_1_0_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.Constants;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ObservationOfferingType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	private String id;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description;
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> nameList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType>();
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType srsName;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType boundedBy;
  	private List<java.lang.String> intendedApplicationList = new ArrayList<java.lang.String>();
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType time;
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> procedureList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType>();
  	private List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> observedPropertyList = new ArrayList<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType>();
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> featureOfInterestList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType>();
  	private List<java.lang.String> responseFormatList = new ArrayList<java.lang.String>();
  	private List<java.lang.String> resultModelList = new ArrayList<java.lang.String>();
  	private List<java.lang.String> responseModeList = new ArrayList<java.lang.String>();
  	
	public ObservationOfferingType(String tagName) {
		super(tagName);
	}
	
  	public void setDescription(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType value){
  		this.description = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType getDescription(){
  		return description; 	
  	} 
  	public void setNameList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> value){
  		this.nameList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> getNameList(){
  		return nameList;	
  	}   
  	public void setBoundedBy(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType value){
  		this.boundedBy = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType getBoundedBy(){
  		return boundedBy; 	
  	} 
  	public void setIntendedApplicationList(List<java.lang.String> value){
  		this.intendedApplicationList = value;
  	}
  	public List<java.lang.String> getIntendedApplicationList(){
  		return intendedApplicationList;	
  	}   
  	public void setTime(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType value){
  		this.time = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType getTime(){
  		return time; 	
  	} 
  	public void setProcedureList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> value){
  		this.procedureList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> getProcedureList(){
  		return procedureList;	
  	}   
  	public void setObservedPropertyList(List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> value){
  		this.observedPropertyList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType> getObservedPropertyList(){
  		return observedPropertyList;	
  	}   
  	public void setFeatureOfInterestList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> value){
  		this.featureOfInterestList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType> getFeatureOfInterestList(){
  		return featureOfInterestList;	
  	}   
  	public void setResponseFormatList(List<java.lang.String> value){
  		this.responseFormatList = value;
  	}
  	public List<java.lang.String> getResponseFormatList(){
  		return responseFormatList;	
  	}   
  	public void setResultModelList(List<java.lang.String> value){
  		this.resultModelList = value;
  	}
  	public List<java.lang.String> getResultModelList(){
  		return resultModelList;	
  	}   
  	public void setResponseModeList(List<java.lang.String> value){
  		this.responseModeList = value;
  	}
  	public List<java.lang.String> getResponseModeList(){
  		return responseModeList;	
  	}   
  	
  	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
  	
	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType getSrsName() {
		return srsName;
	}

	public void setSrsName(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType srsName) {
		this.srsName = srsName;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
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
		    
					if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_SRSNAME)==0){
						try{
							srsName = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType(nextTagName);
							srsName.fromXML(parser);
							m_localResult = true;
						}catch(Exception e){
							doLog("Error processing: " + nextTagName, e);
							m_localResult = false;
						}
					} else
			 
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_BOUNDEDBY)==0){
					try{
						boundedBy = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType(nextTagName);
						boundedBy.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_INTENDEDAPPLICATION)==0){
			try{
			    java.lang.String auxIntendedApplication = parser.nextText();
			    getIntendedApplicationList().add(auxIntendedApplication);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
		     
			    if ((nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_TIME)==0) || nextTagName.equals(Constants.SOS_EVENTTIME_EXTRA)){
					try{
						time = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType(nextTagName);
						time.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_PROCEDURE)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType auxProcedure = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType(org.gvsig.sos.lib.impl.parsers.Constants.SOS_PROCEDURE);
					auxProcedure.fromXML(parser);
					 getProcedureList().add(auxProcedure);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_OBSERVEDPROPERTY)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType auxObservedProperty = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType(org.gvsig.sos.lib.impl.parsers.Constants.SOS_OBSERVEDPROPERTY);
					auxObservedProperty.fromXML(parser);
					 getObservedPropertyList().add(auxObservedProperty);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_FEATUREOFINTEREST)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType auxFeatureOfInterest = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType(org.gvsig.sos.lib.impl.parsers.Constants.SOS_FEATUREOFINTEREST);
					auxFeatureOfInterest.fromXML(parser);
					 getFeatureOfInterestList().add(auxFeatureOfInterest);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_RESPONSEFORMAT)==0){
			try{
			    java.lang.String auxResponseFormat = parser.nextText();
			    getResponseFormatList().add(auxResponseFormat);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_RESULTMODEL)==0){
			try{
			    java.lang.String auxResultModel = parser.nextText();
			    getResultModelList().add(auxResultModel);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_RESPONSEMODE)==0){
			try{
			    java.lang.String auxResponseMode = parser.nextText();
			    getResponseModeList().add(auxResponseMode);
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
	
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException {
		super.processAttributes(parser);
		id = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.GML_ID);	
	}
	
		

}
		
