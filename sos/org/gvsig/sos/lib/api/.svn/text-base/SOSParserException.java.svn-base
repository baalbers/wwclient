package org.gvsig.sos.lib.api;

/**
 * This exception class will encapsulate the exceptions related with the parsing 
 * of the documents obtained from a SOS server. The cause of this exception will 
 * contain the actual exception occurred while parsing the SOS response documents 
 * level.
 * @author <a href="mailto:pupo@uji.es"> Luis E. Rodríguez </a>
 */
public class SOSParserException extends SOSException {

	private static final long serialVersionUID = 2146436281640865551L;

	private static String MESSAGE = 
		"An error occurred while trying to parse a response document.";
	
	private static String KEY = "_SOS_Parser_Exception"; 

	protected SOSParserException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}
	
	protected SOSParserException(String message, Throwable cause,
			String key, long code) {
		super(message, cause, key, code);
	}

}
