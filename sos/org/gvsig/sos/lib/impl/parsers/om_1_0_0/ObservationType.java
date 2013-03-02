package org.gvsig.sos.lib.impl.parsers.om_1_0_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ObservationType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description;
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> nameList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType>();
  	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType boundedBy;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeObjectPropertyType samplingTime;
  	private org.gvsig.sos.lib.impl.parsers.om_1_0_0.ProcessPropertyType procedure;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType observedProperty;
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType featureOfInterest;
  	private org.gvsig.sos.lib.impl.parsers.AnyTypeRealization result;
  	
	public ObservationType(String tagName) {
		super(tagName);
	}
	
  	public void setBoundedBy(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType value){
  		this.boundedBy = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType getBoundedBy(){
  		return boundedBy; 	
  	} 
  	public void setSamplingTime(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeObjectPropertyType value){
  		this.samplingTime = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeObjectPropertyType getSamplingTime(){
  		return samplingTime; 	
  	} 
  	public void setProcedure(org.gvsig.sos.lib.impl.parsers.om_1_0_0.ProcessPropertyType value){
  		this.procedure = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.om_1_0_0.ProcessPropertyType getProcedure(){
  		return procedure; 	
  	} 
  	public void setObservedProperty(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType value){
  		this.observedProperty = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType getObservedProperty(){
  		return observedProperty; 	
  	} 
  	public void setFeatureOfInterest(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType value){
  		this.featureOfInterest = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType getFeatureOfInterest(){
  		return featureOfInterest; 	
  	} 
  	public void setResult(org.gvsig.sos.lib.impl.parsers.AnyTypeRealization value){
  		this.result = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.AnyTypeRealization getResult(){
  		return result; 	
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
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_SAMPLINGTIME)==0){
					try{
						samplingTime = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeObjectPropertyType(nextTagName);
						samplingTime.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_PROCEDURE)==0){
					try{
						procedure = new org.gvsig.sos.lib.impl.parsers.om_1_0_0.ProcessPropertyType(nextTagName);
						procedure.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_OBSERVEDPROPERTY)==0){
					try{
						observedProperty = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType(nextTagName);
						observedProperty.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_FEATUREOFINTEREST)==0){
					try{
						featureOfInterest = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType(nextTagName);
						featureOfInterest.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_RESULT)==0){
				try{
					result = new org.gvsig.sos.lib.impl.parsers.AnyTypeRealization(nextTagName);
					result.fromXML(parser);
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
		
