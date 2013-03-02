package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Scalar_CapabilitiesType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ogc.Element_LogicalOperators LogicalOperators;
  	private org.gvsig.sos.lib.impl.parsers.ogc.ComparisonOperatorsType ComparisonOperators;
  	
	public Scalar_CapabilitiesType(String tagName) {
		super(tagName);
	}
	
  	public void setLogicalOperators(org.gvsig.sos.lib.impl.parsers.ogc.Element_LogicalOperators value){
  		this.LogicalOperators = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.Element_LogicalOperators getLogicalOperators(){
  		return LogicalOperators; 	
  	} 
  	public void setComparisonOperators(org.gvsig.sos.lib.impl.parsers.ogc.ComparisonOperatorsType value){
  		this.ComparisonOperators = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ogc.ComparisonOperatorsType getComparisonOperators(){
  		return ComparisonOperators; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_LOGICALOPERATORS)==0){
					try{
						LogicalOperators = new org.gvsig.sos.lib.impl.parsers.ogc.Element_LogicalOperators(nextTagName);
						LogicalOperators.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_COMPARISONOPERATORS)==0){
					try{
						ComparisonOperators = new org.gvsig.sos.lib.impl.parsers.ogc.ComparisonOperatorsType(nextTagName);
						ComparisonOperators.fromXML(parser);
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
		
