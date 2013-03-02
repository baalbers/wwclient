package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class IgnoredTag extends XMLInstanceTag{
	
	

	public IgnoredTag(String tagName) {
		super(tagName);
	}

	@Override
	public void fromXML(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		skipSubTree(parser);
	}

	public void skipSubTree(XmlPullParser parser) throws XmlPullParserException, IOException {
        
		//((KXmlParser)parser).skipSubTree();
		int level = 1;
        while (level > 0) {
            int eventType = parser.next();
            if (eventType == XmlPullParser.END_TAG) {
                --level;
            }
            else if (eventType == XmlPullParser.START_TAG) {
                ++level;
            }
        }
    }
	
	
	@Override
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignore)
			throws IOException, XmlPullParserException {
		return false;
	}

	

}
