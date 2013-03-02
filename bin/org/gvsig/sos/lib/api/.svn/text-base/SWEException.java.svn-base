package org.gvsig.sos.lib.api;


/**
 * This exception class will encapsulate the exceptions thrown by the SOS server.
 * This could include exceptions related internal problems of the SOS server, often notified 
 * as Exception Reports documents. 
 * @author <a href="mailto:pupo@uji.es"> Luis E. Rodríguez </a>
 */

public class SWEException extends SOSException {

	private static String MESSAGE = 
		"An error occurred in the SOS server.";
	
	private static String KEY = "_SOS_SWE_Exception"; 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5079281083798025114L;

	protected SWEException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}

	protected SWEException(String message, Throwable cause, String key,
			long code) {
		super(message, cause, key, code);
	}
}
