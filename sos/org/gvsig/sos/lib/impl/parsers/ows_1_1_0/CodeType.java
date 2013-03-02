package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class CodeType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String codeSpace;
	
  	private java.lang.String value;
  	
	public CodeType(String tagName) {
		super(tagName);
	}
  	public void setCodeSpace(java.lang.String value){
  		this.codeSpace = value;
  	}
  	public java.lang.String getCodeSpace(){
  		return codeSpace; 	
  	} 
	
  	public void setValue(java.lang.String value){
  		this.value = value;
  	}
  	public java.lang.String getValue(){
  		return value; 	
  	} 
  	
	
	 
	public void fromXML(XmlPullParser parser) throws XmlPullParserException, IOException, 
						IllegalConvertionException {
		processAttributes(parser);
		// Read next tag
	    processValue(parser);		
	}

	protected void processValue(XmlPullParser parser) throws XmlPullParserException, 
												IOException, IllegalConvertionException{
	 String tmpLocalStringValue = parser.nextText();
	  try{
			    setValue(tmpLocalStringValue);
		}catch(Exception e){
			doLog("Error processing: " + tmpLocalStringValue, e);
	    }
	
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags)
			throws IOException, XmlPullParserException {
		return true;
	}
		
		
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		 super.processAttributes(parser); 
			    codeSpace = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.OWS_CODESPACE);
		
	}

}
		
