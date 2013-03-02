package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_identification extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_IdentifierList IdentifierList;
  	
	public Element_identification(String tagName) {
		super(tagName);
	}
	
  	public void setIdentifierList(org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_IdentifierList value){
  		this.IdentifierList = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_IdentifierList getIdentifierList(){
  		return IdentifierList; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_IDENTIFIERLIST)==0){
					try{
						IdentifierList = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_IdentifierList(nextTagName);
						IdentifierList.fromXML(parser);
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
		
