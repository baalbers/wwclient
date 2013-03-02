package org.gvsig.sos.lib.api;

/**
 * This exception class will be chained to the exceptions related 
 * with communication problems (i.e time out exceptions, connection reset etc.). The 
 * cause of this exception will contain actual exception occurred at 
 * the communication level.
 *    
 * @author <a href="mailto:pupo@uji.es"> Luis E. Rodríguez </a>
 */
public class SOSCommException extends SOSException {

	private static String MESSAGE = 
		"An error occurred while trying to communicate with the SOS server.";
	
	private static String KEY = "_SOS_Communication_Exception"; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4676717738790095919L;

	protected SOSCommException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}

	protected SOSCommException(String message, Throwable cause, String key, long code) {
	    super(message, cause, key, code);
    }
	
	
}
