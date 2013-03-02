package org.gvsig.sos.lib.impl.communication.exceptions;

/**
 * Class for representing the exceptions that might arise while accessing SOS services.
 * @author lrodriguez
 *
 */
public class SOSInternalException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5859666125098091748L;
	// SOS exception code
	private String sosCode;
	// locator attribute, indicates (when applicable) exactly where is the problem  
    private String locator;
    // Message used in non server-side exceptions
	protected String nonProtocolMessagePrefix = "Non-OWS Exception";
	
	// Valid exception codes according with OWS 1.1.0 specification
	public static final String VERSION_NEGOTIATION_FAILED = "VersionNegotiationFailed";
	public static final String MISSING_PARAMETER_VALUE = "MISSING_PARAMETER_VALUE";
	public static final String INVALID_PARAMETER_VALUE = "InvalidParameterValue";
	public static final String INVALID_UPDATE_SEQUENCE = "InvalidUpdateSequence";
	public static final String NO_APPLICABLE_CODE = "NoApplicableCode";
	
	public static final String GETOBSERVATION_REQUEST_CREATE_FAILED = "getObservation_request_create_failed";
	
	public static final String MALFORMED_EXCEPTION_REPORT_FILE = "MalformedExceptionREportFile";
	public static final String MALFORMED_EXCEPTION_REPORT_MESSAGE = "Error processing exception report file from the server";
	
	public static final String INVALID_TAG_FOUND = "InvalidTag";
	
	/**
	 * Constructor for encapsulating other exceptions
	 * @param cause
	 */
	public SOSInternalException(Throwable cause) {		
		super(cause.getMessage());
		initCause(cause);
	}	
	
	/**
	 * Constructor for creating a server-side exception
	 * @param sosCode: exception code
	 * @param locator
	 * @param message
	 */
	public SOSInternalException(String sosCode, String locator, String message) {		
		super(message);
		this.sosCode = sosCode;
		this.locator = locator;
	}	
	
	public SOSInternalException(String message) {		
		super(message);
		this.sosCode = GETOBSERVATION_REQUEST_CREATE_FAILED;
		this.locator = "";
	}
	
	/**
	 * Get exception code 
	 * @return: Exception code if server-side exception, null otherwise 
	 */
	public String getSosCode() {
		return sosCode;
	}
	
	/**
	 * Get exception message
	 */
	 
	public String getMessage() {
		String result = "";
		if (sosCode != null)
		  result = String.format("%s(%s): %s", sosCode, locator, super.getMessage());
		else 
		  result = String.format("%s: %s", nonProtocolMessagePrefix, super.getMessage());
		
		return result;
	}

	/**
	 * Get locator attribute
	 * @return
	 */
	public String getLocator() {
		return locator;
	}

}
