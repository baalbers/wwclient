package org.gvsig.tools.persistence.xml.exception;

import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;
import org.xmlpull.v1.XmlPullParser;

public class PersistenceParserException extends PersistenceRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6351418857699967957L;
	private final static String MESSAGE_FORMAT = "Error parsing state. Last tag '%(tagname)', line %(line) column %(column).";
	private final static String MESSAGE_KEY = "_PersistenceParserException";
	
	protected  PersistenceParserException(XmlPullParser parser, String format, String key, long code) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		if( parser == null ) {
			this.setValue("tagname", "(unknow)");
			this.setValue("line", "(unknow)");
			this.setValue("column", "(unknow)");
		} else {
			if( parser.getName() == null ) {
				this.setValue("tagname", "(unknow)");				
			} else {
				this.setValue("tagname", parser.getName());
			}
			this.setValue("line", new Integer(parser.getLineNumber()));
			this.setValue("column", new Integer( parser.getColumnNumber()));
		}
	}
	
	public PersistenceParserException(XmlPullParser parser, Throwable cause) {
		this(parser, MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.initCause(cause);
	}
	
}
