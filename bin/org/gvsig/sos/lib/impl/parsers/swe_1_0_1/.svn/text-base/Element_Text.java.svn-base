package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.Constants;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


public class Element_Text extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
  	private String value;
  	private String definition;
	
  	public Element_Text(String tagName) {
		super(tagName);
	}
  	
  	
  	
  	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getDefinition() {
		return definition;
	}



	public void setDefinition(String definition) {
		this.definition = definition;
	}



	 
	protected boolean processTag(String nextTagName, XmlPullParser parser,
			boolean ignore) throws IOException, XmlPullParserException,
			IllegalConvertionException {
		
		boolean m_localResult = false;

		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_VALUE)==0){
			try{
					value = parser.nextText();
			
				m_localResult = true;
			}catch(Exception e){
				doLog("Error processing: " + nextTagName, e);
				m_localResult = false;
			}
		}  else 
			
			if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_METADATAPROPERTY)==0){
				try{
						IgnoredTag tag = new IgnoredTag(org.gvsig.sos.lib.impl.parsers.Constants.GML_METADATAPROPERTY);
						tag.fromXML(parser);
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
		definition = getAttributeValue(parser, Constants.SML_DEFINITION);
	}
	
	

}
