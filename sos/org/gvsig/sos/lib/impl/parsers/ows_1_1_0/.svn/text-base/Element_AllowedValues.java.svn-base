package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_AllowedValues extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType> ValueList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType> RangeList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType>();
  	
	public Element_AllowedValues(String tagName) {
		super(tagName);
	}
	
  	public void setValueList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType> value){
  		this.ValueList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType> getValueList(){
  		return ValueList;	
  	}   
  	public void setRangeList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType> value){
  		this.RangeList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType> getRangeList(){
  		return RangeList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_VALUE)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType auxValue = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_VALUE);
					auxValue.fromXML(parser);
					 getValueList().add(auxValue);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_RANGE)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType auxRange = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RangeType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_RANGE);
					auxRange.fromXML(parser);
					 getRangeList().add(auxRange);
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
		
