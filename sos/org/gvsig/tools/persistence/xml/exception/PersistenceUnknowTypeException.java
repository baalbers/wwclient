package org.gvsig.tools.persistence.xml.exception;

import org.xmlpull.v1.XmlPullParser;

public class PersistenceUnknowTypeException extends
		PersistenceParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5611626021519090001L;
	/**
	 * 
	 */
	private final static String MESSAGE_FORMAT =  "Unknow type '%(type)' in tag '%(tagname)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceUnknowTypeException";

	public PersistenceUnknowTypeException(XmlPullParser parser, String type)  {
		super(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("type", type);
	}
}
