package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TemporalOperatorsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType> TemporalOperatorList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType>();
  	
	public TemporalOperatorsType(String tagName) {
		super(tagName);
	}
	
  	public void setTemporalOperatorList(List<org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType> value){
  		this.TemporalOperatorList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType> getTemporalOperatorList(){
  		return TemporalOperatorList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERATOR)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType auxTemporalOperator = new org.gvsig.sos.lib.impl.parsers.ogc.TemporalOperatorType(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERATOR);
					auxTemporalOperator.fromXML(parser);
					 getTemporalOperatorList().add(auxTemporalOperator);
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
		
