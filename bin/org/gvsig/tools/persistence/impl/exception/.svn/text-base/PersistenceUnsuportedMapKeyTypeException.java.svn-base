package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceException;


public class PersistenceUnsuportedMapKeyTypeException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = -319405442042912022L;
	private final static String MESSAGE_FORMAT = "The type '%(classname)' is not supported as key for Map.";
	private final static String MESSAGE_KEY = "_PersistenceUnsuportedMapKeyTypeException";
	private String classname;
	private Map values = null;


	public PersistenceUnsuportedMapKeyTypeException(Class theType) {
		this(theType.getName());
	}

	public PersistenceUnsuportedMapKeyTypeException(String theType) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.classname = theType;
	}


    protected Map values() {
    	if (values == null) {
			values = new HashMap();
			values.put("classname", classname);
			values = Collections.unmodifiableMap(values);
		}
		return values;
    }
}
