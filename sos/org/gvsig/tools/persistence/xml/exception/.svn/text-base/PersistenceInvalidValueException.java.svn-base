package org.gvsig.tools.persistence.xml.exception;

import org.xmlpull.v1.XmlPullParser;

public class PersistenceInvalidValueException extends
		PersistenceParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8696696614119583094L;
	private final static String MESSAGE_FORMAT = "Invalid value %(type)  '%(value)' in tag '%(tagname)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceInvalidValueException";

	public PersistenceInvalidValueException(XmlPullParser parser, String type, String value)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("type", type);
		this.setValue("value", value);
	}

	public PersistenceInvalidValueException(XmlPullParser parser, String type, String value, Throwable cause)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.initCause(cause);
		this.setValue("type", type);
		this.setValue("value", value);
	}
}
