package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class CodeType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private java.lang.String value;
  	
	public CodeType(String tagName) {
		super(tagName);
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
		
		

}
		
