package org.gvsig.sos.lib.impl.exceptions;

import org.gvsig.sos.lib.api.SOSParserException;

public class OMParserException extends SOSParserException {

	private static String MESSAGE = "Error while parsing OM document.";
	private static String KEY = "_Error_Pasing_OM";
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3443097051050928885L;

	public OMParserException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}
}
