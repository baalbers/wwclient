package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ComponentType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> identificationList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification>();
  	private org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_inputs inputs;
  	private org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_outputs outputs;
  	
	public ComponentType(String tagName) {
		super(tagName);
	}
	
  	public void setIdentificationList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> value){
  		this.identificationList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification> getIdentificationList(){
  		return identificationList;	
  	}   
  	public void setInputs(org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_inputs value){
  		this.inputs = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_inputs getInputs(){
  		return inputs; 	
  	} 
  	public void setOutputs(org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_outputs value){
  		this.outputs = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_outputs getOutputs(){
  		return outputs; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_IDENTIFICATION)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification auxIdentification = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification(org.gvsig.sos.lib.impl.parsers.Constants.SML_IDENTIFICATION);
					auxIdentification.fromXML(parser);
					 getIdentificationList().add(auxIdentification);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_INPUTS)==0){
					try{
						inputs = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_inputs(nextTagName);
						inputs.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_OUTPUTS)==0){
					try{
						outputs = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_outputs(nextTagName);
						outputs.fromXML(parser);
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
		
