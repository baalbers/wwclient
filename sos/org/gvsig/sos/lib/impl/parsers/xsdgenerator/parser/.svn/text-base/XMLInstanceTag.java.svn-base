package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * <p> This class represents a any tag that can be included in a capabilities server response.
 * It implements the XML serializable interface </p>  
 * 
 * @author Alain Tamayo Fong (alain_tamayo@yahoo.com)
 */
public abstract class XMLInstanceTag implements XMLSerializable{
	// Name of tag
	protected String tagName; 
	public static boolean verbose = false;
	
	public static List<Map<String, String>> allNamespaces = new ArrayList<Map<String, String>>();
	
	/**
	 * Class constructor
	 * @param tagName
	 */
	protected XMLInstanceTag(String tagName) {
		super();
		this.tagName = tagName;
	}
	
	/**
	 *  Print message in teh console if an unknown tag is found
	 * @param unknownTagName
	 */
	protected void printUnprocessedTagMessage(String unknownTagName){
		if (verbose)
			doLog(String.format(XMLSerializable.SOS_UNPROCESSED_TAG_MESSAGE, unknownTagName) + " in " + tagName);
	}
	
	/**
	 * Default implementation of fromXML method. Default behavior is to skip any other tag inside the current one 
	 * without processing them. For each unprocessed tag a message is send to the console. 
	 * @throws IllegalConvertionException 
	 */
	public void fromXML(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalConvertionException{
		int currentTag;
		boolean end = false;
		//boolean namespacesAdded = false;
		
		//System.out.println(tagName);
		// Precondition check: Initial tag required to be the current tag type
		
		processAttributes(parser);
				
		// Read next tag		
		currentTag = parser.nextTag();
		
		while (!end) 
		{
			switch(currentTag)
			{
			case XmlPullParser.START_TAG:
				String nextTagName = NameResolver.getParserNextTag(parser);
				//System.out.println("Processing: " + nextTagName );
				// Unknown tag, print corresponding message	
				if (!processTag(nextTagName,parser, false))
					printUnprocessedTagMessage(nextTagName);
				
				NameResolver.cleanLastNamespaceList();
				break;
			case XmlPullParser.END_TAG:
				// If closing tag finish processing 
				end = processEnd(parser);
					
				break;
			case XmlPullParser.TEXT:                   
				break;
			}
			if (!end){
				// Move to next tag
				currentTag = parser.next();
			}
		}  
	}
	
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		//Empty Implementation
	}

	protected boolean processEnd(XmlPullParser parser) {
		String name = NameResolver.getFullName(parser.getName());
		//System.out.println("Closing: " + name + " in " + tagName);
		return (name.compareTo(tagName) == 0);
	}

	protected abstract boolean processTag(String nextTagName, XmlPullParser parser, boolean ignore) throws IOException, XmlPullParserException, IllegalConvertionException;

	/**
	 * Build a String with the XML representation of the object state 
	 */
	public String toXML() {
		// TODO: Not implemented yet
		return null;
	}

	/**
	 * Get attribute value from the current tag
	 * @param parser
	 * @param attributeName
	 * @return
	 * 
	 */
	protected String getAttributeValue(XmlPullParser parser, String attributeName) {
		String longAttrName = Utilities.getResolvedAttrName(attributeName);//NameResolver.getFullNameForAttr(attributeName);
		
		String value = null;
		for (int i=0 ; i<parser.getAttributeCount() ; i++){
			String attrName = parser.getAttributeName(i);
			if (!attrName.startsWith("xmlns:") && !attrName.startsWith("xsi:") && !attrName.equals("xmlns")){
                if (longAttrName.equals(NameResolver.getFullNameForAttr(attrName))){
                	value = parser.getAttributeValue(i);
                	break;
                }
           }
		}	
		return value;
	}
	
	protected void doLog(String message, Throwable th){
		
	}
	
	protected void doLog(String message){
		
	}

}
