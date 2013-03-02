package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Temporal_CapabilitiesType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType TemporalOperands;
  	private org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorsType TemporalOperators;
  	
	public Temporal_CapabilitiesType(String tagName) {
		super(tagName);
	}
	
  	public void setTemporalOperands(org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType value){
  		this.TemporalOperands = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType getTemporalOperands(){
  		return TemporalOperands; 	
  	} 
  	public void setTemporalOperators(org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorsType value){
  		this.TemporalOperators = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorsType getTemporalOperators(){
  		return TemporalOperators; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERANDS)==0){
					try{
						TemporalOperands = new org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperandsType(nextTagName);
						TemporalOperands.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERATORS)==0){
					try{
						TemporalOperators = new org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorsType(nextTagName);
						TemporalOperators.fromXML(parser);
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
		
