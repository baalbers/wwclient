package org.gvsig.sos.lib.impl.parsers.om_1_0_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;



/**
 * Class for keeping the information retrieved through a GetObservation operation.
 * @author lrodriguez
 *
 */
public class ObservationCollectionType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.StringOrRefType description;
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType> nameList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CodeType>();
  	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.BoundingShapeType boundedBy;
  	private List<org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType> memberList = new ArrayList<org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType>();
  	
	public ObservationCollectionType(String tagName) {
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
  	public void setMemberList(List<org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType> value){
  		this.memberList = value;
  	}
  	
  	/**
  	 * Gives access to the members of retrieved. The members contain the observations
  	 * resulting from the GetObservation request.
  	 * @return
  	 */
  	public List<org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType> getMemberList(){
  		return memberList;	
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
				
					
		
		
			  
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OM_MEMBER)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType auxMember = new org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType(org.gvsig.sos.lib.impl.parsers.Constants.OM_MEMBER);
					auxMember.fromXML(parser);
					 getMemberList().add(auxMember);
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
		
