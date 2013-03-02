package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class SpatialOperatorsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType> SpatialOperatorList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType>();
  	
	public SpatialOperatorsType(String tagName) {
		super(tagName);
	}
	
  	public void setSpatialOperatorList(List<org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType> value){
  		this.SpatialOperatorList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType> getSpatialOperatorList(){
  		return SpatialOperatorList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_SPATIALOPERATOR)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType auxSpatialOperator = new org.gvsig.sos.lib.impl.parsers.ogc.SpatialOperatorType(org.gvsig.sos.lib.impl.parsers.Constants.OGC_SPATIALOPERATOR);
					auxSpatialOperator.fromXML(parser);
					 getSpatialOperatorList().add(auxSpatialOperator);
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
		
