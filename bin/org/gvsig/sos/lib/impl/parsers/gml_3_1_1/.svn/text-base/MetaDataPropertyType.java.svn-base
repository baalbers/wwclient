package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class MetaDataPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	
	public MetaDataPropertyType(String tagName) {
		super(tagName);
	}
	
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
		try{
			IgnoredTag tag = new IgnoredTag(nextTagName);
			tag.fromXML(parser);
			m_localResult = true;
		}catch(Exception e){
			doLog("Error processing: " + nextTagName, e);
			m_localResult = false;
		}		
		
		
		
		return m_localResult;
	}	
	
		
		

}
		
