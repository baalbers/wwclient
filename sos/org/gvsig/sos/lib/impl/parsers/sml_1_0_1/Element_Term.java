package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Term extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String definition;
	   	private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType codeSpace;
	
  	private java.lang.String value;
  	
	public Element_Term(String tagName) {
		super(tagName);
	}
  	public void setDefinition(java.lang.String value){
  		this.definition = value;
  	}
  	public java.lang.String getDefinition(){
  		return definition; 	
  	} 
	
  	public void setValue(java.lang.String value){
  		this.value = value;
  	}
  	public java.lang.String getValue(){
  		return value; 	
  	} 
  	
  	
	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType getCodeSpace() {
		return codeSpace;
	}
	public void setCodeSpace(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType codeSpace) {
		this.codeSpace = codeSpace;
	}
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_VALUE)==0){
				try{
				    value = parser.nextText();
					m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			} else 
		
		     
				   
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_CODESPACE)==0){
						try{
						codeSpace = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType(org.gvsig.sos.lib.impl.parsers.Constants.SML_CODESPACE);
						codeSpace.fromXML(parser);
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
	
		
		
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		 super.processAttributes(parser); 
			    definition = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SML_DEFINITION);
		
	}

}
		
