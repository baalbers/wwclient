package org.gvsig.sos.lib.impl.exceptions;

import org.gvsig.sos.lib.api.SOSCommException;

public class ProtocolHandlerException extends SOSCommException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6985828155514945473L;
	private static String MESSAGE = "Error occurred while retrieving the observations.";
    private static String KEY = "_Protocol_HandlerOperation";
	
    public ProtocolHandlerException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}

}
