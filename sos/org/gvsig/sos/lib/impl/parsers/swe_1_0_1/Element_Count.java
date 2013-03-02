package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Count extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private Integer value;
  	
	public Element_Count(String tagName) {
		super(tagName);
	}
	
  	public void setValue(Integer value){
  		this.value = value;
  	}
  	public Integer getValue(){
  		return value; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_VALUE)==0){
				try{
					    java.lang.String auxValue = parser.nextText();
						value = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.convertToInteger(auxValue);
				
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
		
