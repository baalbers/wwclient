package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TemporalOperandsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<java.lang.String> TemporalOperandList = new ArrayList<java.lang.String>();
  	
	public TemporalOperandsType(String tagName) {
		super(tagName);
	}
	
  	public void setTemporalOperandList(List<java.lang.String> value){
  		this.TemporalOperandList = value;
  	}
  	public List<java.lang.String> getTemporalOperandList(){
  		return TemporalOperandList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_TEMPORALOPERAND)==0){
			try{
			    java.lang.String auxTemporalOperand = parser.nextText();
			    getTemporalOperandList().add(auxTemporalOperand);
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
	
		
		

}
		
