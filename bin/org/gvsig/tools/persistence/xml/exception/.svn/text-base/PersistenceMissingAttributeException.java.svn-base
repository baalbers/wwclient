package org.gvsig.tools.persistence.xml.exception;

import org.xmlpull.v1.XmlPullParser;

public class PersistenceMissingAttributeException extends
		PersistenceParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -250292376190219948L;
	private final static String MESSAGE_FORMAT = "Missing attribute '%(attrname)' in tag '%(tagname)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceMissingAttributeException";

	public PersistenceMissingAttributeException(XmlPullParser parser, String attrname)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("attrname", attrname);
	}
}
