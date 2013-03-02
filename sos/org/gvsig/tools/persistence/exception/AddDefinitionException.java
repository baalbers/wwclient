package org.gvsig.tools.persistence.exception;


public class AddDefinitionException extends PersistenceRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2173459987313661011L;
	private final static String MESSAGE_FORMAT = "Can't add definition to persistence manager.";
	private final static String MESSAGE_KEY = "_AddDefinitionException";

	public AddDefinitionException(Throwable cause) {
		super(MESSAGE_FORMAT, cause, MESSAGE_KEY, serialVersionUID);
	}
	
	protected AddDefinitionException(String message, String key, long code) {
		super(message, key, code);
	}
	
}

