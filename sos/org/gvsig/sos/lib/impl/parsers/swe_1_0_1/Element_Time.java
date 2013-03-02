package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Time extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType uom;
  	private String definition;
	
  	
	public Element_Time(String tagName) {
		super(tagName);
	}
	public void setUom(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType value){
  		this.uom = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType getUom(){
  		return uom; 	
  	} 
  	
  	
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_UOM)==0){
			try{
				uom = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.UomPropertyType(nextTagName);
				uom.fromXML(parser);
				m_localResult = true;
			}catch(Exception e){
				doLog("Error processing: " + nextTagName, e);
				m_localResult = false;
			}
		}
				
		
		return m_localResult;
	}
	 
	protected void processAttributes(XmlPullParser parser)
			throws IllegalConvertionException {
		super.processAttributes(parser);
		definition = getAttributeValue(parser, "definition");
	}	
	
	
		
		

}
		
