package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;

public class PersistenceDomainNotRegisterdException extends PersistenceRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2135913805542798476L;
	private final static String MESSAGE_FORMAT = "Domain name '%(name)' not registered.";
	private final static String MESSAGE_KEY = "PersistenceDomainNotRegisterdException";
	private String name;

	public PersistenceDomainNotRegisterdException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = name;
	}
	
	public PersistenceDomainNotRegisterdException() {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.name = "(null)";
	}
	
	protected Map values() {
		return Collections.singletonMap("name", this.name);
	}
}
