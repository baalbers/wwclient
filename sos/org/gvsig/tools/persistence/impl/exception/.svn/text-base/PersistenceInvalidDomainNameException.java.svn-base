package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;

public class PersistenceInvalidDomainNameException extends PersistenceRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3744038950422523595L;
	private final static String MESSAGE_FORMAT = "Invalid domain name '%(name)'.";
	private final static String MESSAGE_KEY = "_PersistenceInvalidDomainNameException";
	private String name;

	public PersistenceInvalidDomainNameException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = name;
	}
	
	public PersistenceInvalidDomainNameException() {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = "(null)";
	}
	
	protected Map values() {
		return Collections.singletonMap("name", this.name);
	}
}
