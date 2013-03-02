package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


;

public class TimeInterval extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {

	private java.lang.Double value;
	private String unit;
	
	protected TimeInterval(String tagName) {
		super(tagName);
	}
	
	
	public java.lang.Double getValue() {
		return value;
	}



	public void setValue(java.lang.Double value) {
		this.value = value;
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
		   setValue(Double.parseDouble(tmpLocalStringValue));
		}catch(Exception e){
		  doLog("Error processing: " + tmpLocalStringValue, e);
	    }
	
	}

	

	 
	protected void processAttributes(XmlPullParser parser)
			throws IllegalConvertionException {
		super.processAttributes(parser);
		setUnit(getAttributeValue(parser, "unit"));	
	}


	 
	protected boolean processTag(String nextTagName, XmlPullParser parser,
			boolean ignore) throws IOException, XmlPullParserException,
			IllegalConvertionException {
		return false;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}

}
