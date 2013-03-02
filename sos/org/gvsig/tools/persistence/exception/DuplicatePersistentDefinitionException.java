package org.gvsig.tools.persistence.exception;


public class DuplicatePersistentDefinitionException extends AddDefinitionException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1602874498275832708L;
	private final static String MESSAGE_FORMAT = "Duplicated name (%(name)s) in definition for persistence.";
	private final static String MESSAGE_KEY = "_DuplicatePersistentDefinitionException";

	public DuplicatePersistentDefinitionException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("name",name);
	}
	
}

