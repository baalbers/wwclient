package org.gvsig.tools.persistence.xml.exception;

import org.xmlpull.v1.XmlPullParser;

public class PersistenceEndOfDocumentException extends
		PersistenceParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4719650837477195387L;
	private final static String MESSAGE_FORMAT = "Unspected end of document. Last tag '%(tagname)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceEndOfDocumentException";

	public PersistenceEndOfDocumentException(XmlPullParser parser)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
	}
}

