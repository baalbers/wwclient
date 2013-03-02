package org.gvsig.sos.lib.api;

/**
 * This exception class will encapsulate the exceptions related with the internal 
 * operation of the SOS Library. The cause of this exception will 
 * contain the actual exception occurred while performing a certain operation 
 * in the library.
 * @author <a href="mailto:pupo@uji.es"> Luis E. Rodríguez </a>
 */
public class SOSOperationException extends SOSException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -519405843274722370L;

	private static String MESSAGE = 
		"An error in the operation of the SOS library.";
	
	private static String KEY = "_SOS_SWE_Exception"; 
	/**
	 * 
	 */
	protected SOSOperationException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}

	protected SOSOperationException(String message, Throwable cause,
			String key, long code) {
		super(message, cause, key, code);
	}
}
