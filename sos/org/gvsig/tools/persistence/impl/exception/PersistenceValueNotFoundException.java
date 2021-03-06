package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceValueNotFoundException extends PersistenceException {
	private static final long serialVersionUID = -8365980563346330001L;
	private final static String MESSAGE_FORMAT = "Value '%(name)' not found in persistent state.";
	private final static String MESSAGE_KEY = "_PersistenceValueNotFoundException";
	private String propertyName;

	public PersistenceValueNotFoundException(String propertyName) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.propertyName = propertyName;
	}

	public PersistenceValueNotFoundException(String propertyName, Throwable cause) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.propertyName = propertyName;
	}

    protected Map values() {
        return Collections
                .singletonMap("name", propertyName);
    }
}
