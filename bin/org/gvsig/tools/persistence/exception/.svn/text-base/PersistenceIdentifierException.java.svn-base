package org.gvsig.tools.persistence.exception;

import java.util.Collections;
import java.util.Map;

public class PersistenceIdentifierException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471132922648901248L;
	private final static String MESSAGE_FORMAT = "Invalid persistence identifier %(id)'.";
	private final static String MESSAGE_KEY = "_PersistenceIdentifierException";

	private Object id;

	public PersistenceIdentifierException(Object id){
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.id = id;
	}

	public Object getId() {
		return this.id;
	}

   protected Map values() {
		return Collections.singletonMap("id", id.toString());
	}
}
