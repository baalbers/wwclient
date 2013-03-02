package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class DirectPositionType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	private String srsName;
  	private List<Double> valueList = new ArrayList<Double>();
  	
	public DirectPositionType(String tagName) {
		super(tagName);
	}
	
  	public void setValueList(List<Double> value){
  		this.valueList = value;
  	}
  	public List<Double> getValueList(){
  		return valueList;	
  	}  
  	
  	
  	
	
	public String getSrsName() {
		return srsName;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
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
			java.lang.String auxStringValue = tmpLocalStringValue;
			setValueList(org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.
				  convertToDoubleList(auxStringValue));
			
		}catch(Exception e){
			doLog("Error processing: " + tmpLocalStringValue, e);
	    }
	
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags)
			throws IOException, XmlPullParserException {
		return true;
	}

	 
	protected void processAttributes(XmlPullParser parser)
			throws IllegalConvertionException {
		super.processAttributes(parser);
		srsName = getAttributeValue(parser, "srsName");
	}
	
	
		
		

}
		
