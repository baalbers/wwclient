package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;

public class PersistenceInvalidPropertyNameException extends PersistenceRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1611892488657900L;
	private final static String MESSAGE_FORMAT = "Invalid property name '%(name)'.";
	private final static String MESSAGE_KEY = "_PersistenceInvalidPropertyNameException";
	private String name;

	public PersistenceInvalidPropertyNameException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = name;
	}
	
	public PersistenceInvalidPropertyNameException() {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = "(null)";
	}
	
	protected Map values() {
		return Collections.singletonMap("name", this.name);
	}
}
