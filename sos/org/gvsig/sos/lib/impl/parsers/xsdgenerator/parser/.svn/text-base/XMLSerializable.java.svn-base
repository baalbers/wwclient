package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * This interface should be implemented by objects whose state should be converted to and from 
 * XML to its internal representation
 * 
 * @author Alain Tamayo Fong (alain_tamayo@yahoo.com)
 */
public interface XMLSerializable {
	
	// Message to show when a not processed tag is found
    public static final String SOS_UNPROCESSED_TAG_MESSAGE = "Unprocessed Tag (%s) found"; 
	
    /**
	 * Builds String in XML format containing the state of the object 
	 */
	public String toXML();
	
	/**
	 * Builds object state from XML file 
	 * @param parser
	 * 
	 * NOTE: It assumes that parser is already positioned in the specific tag 
	 * @throws IllegalConvertionException 
	 */
	public void fromXML(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalConvertionException;
}
