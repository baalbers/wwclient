package org.gvsig.tools.persistence.xml.exception;

import org.xmlpull.v1.XmlPullParser;

public class PersistenceMissingTagException extends
		PersistenceParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5095000630798148245L;
	private final static String MESSAGE_FORMAT = "Missing tag '%(name)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceMissingTagException";

	public PersistenceMissingTagException(XmlPullParser parser, String name)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("name", name);
	}
}
