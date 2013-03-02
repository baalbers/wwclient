package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceReferenceIDConflitException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = -66522803444999281L;
	private final static String MESSAGE_FORMAT = "The '%(id)' is allready declared and try to set with another one.";
	private final static String MESSAGE_KEY = "_PersistenceReferenceIDConflitException";
	private String id;

	public PersistenceReferenceIDConflitException(String id) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.id = id;
	}


    protected Map values() {
        return Collections
                .singletonMap("id", id);
    }
}
