package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TimePositionType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	//private DateTime value;
	private String value;
  	private String attribute = null;
  	
	public TimePositionType(String tagName) {
		super(tagName);
	}
	
  	public void setValue(String value){
  		this.value = value;
  	}
  	public String getValue(){
  		return value; 	
  	} 
  	
  	public String getAttribute()
  	{
  		return this.attribute;
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
			    		
					value = tmpLocalStringValue;//new DateTime(tmpLocalStringValue);				
		}catch(Exception e){
			doLog("Error processing: " + tmpLocalStringValue, e);
	    }
	
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags)
			throws IOException, XmlPullParserException {
		return true;
	}
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException {
		super.processAttributes(parser);
		attribute = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.GML_TIMEINDETERMINATEVALUE);//"indeterminatePosition");
	}
		

}
		
