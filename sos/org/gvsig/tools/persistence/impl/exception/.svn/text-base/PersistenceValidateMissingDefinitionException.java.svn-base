package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceValidateMissingDefinitionException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8706224174909319498L;
	private final static String MESSAGE_FORMAT = "Missing definition for class '%(className)'.";
	private final static String MESSAGE_KEY = "_PersistenceValidateMissingDefinitionException";
	private String className;

	public PersistenceValidateMissingDefinitionException(String className) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.className = className;
	}

	public PersistenceValidateMissingDefinitionException(Class theClass) {
		this(theClass.getName());
	}

    protected Map values() {
        return Collections
                .singletonMap("className", className);
    }
}
