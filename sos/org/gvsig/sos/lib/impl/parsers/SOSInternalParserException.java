package org.gvsig.sos.lib.impl.parsers;

/**
 * Exception class that is used in the parsers of different types of SOS documents(i.e. Capabilities, SensorML, and O&M)
 * @author lrodriguez
 *
 */
public class SOSInternalParserException extends Exception {
	
	public static final String INVALID_TAG_FOUND = "InvalidTag";
	
	// SOS exception code
	private String sosCode;
	// locator attribute, indicates (when applicable) exactly where is the problem  
    private String locator;
    
    // Message used in non server-side exceptions
	protected String nonProtocolMessagePrefix = "Non-OWS Exception";
	
	/**
	 * Constructor for encapsulating other exceptions
	 * @param cause
	 */
	public SOSInternalParserException(Throwable cause) {		
		super(cause.getMessage());
		initCause(cause);
	}	
	
	/**
	 * Constructor for creating a server-side exception
	 * @param sosCode: exception code
	 * @param locator
	 * @param message
	 */
	public SOSInternalParserException(String sosCode, String locator, String message) {		
		super(message);
		this.sosCode = sosCode;
		this.locator = locator;
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
		String result;
		
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
