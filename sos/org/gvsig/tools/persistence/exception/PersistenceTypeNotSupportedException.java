package org.gvsig.tools.persistence.exception;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;



public class PersistenceTypeNotSupportedException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = -4330166940284544121L;
	private final static String MESSAGE_FORMAT = "Can't persist '%(className)' values of attribute '%(attributeName)'.";
	private final static String MESSAGE_KEY = "_PersistenceTypeNotSupportedException";

	public static final String UNKNOW_ATTRIBUTE = "_unknow_";
	private String className;
	private String attributeName;
	private Map values;

	public PersistenceTypeNotSupportedException(Class theClass) {
		this(theClass.getName());
	}
	public PersistenceTypeNotSupportedException(String className) {
		this(className, UNKNOW_ATTRIBUTE);
	}

	public PersistenceTypeNotSupportedException(Class theClass,
			String attributeName) {
		this(theClass.getName(), attributeName);
	}

	public PersistenceTypeNotSupportedException(String className,
			String attributeName) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.className = className;
		if( attributeName == null ) {
			this.attributeName = UNKNOW_ATTRIBUTE;
		}else {
			this.attributeName = attributeName;
		}
	}

	public void setAttributeName(String attributeName) {
		if (UNKNOW_ATTRIBUTE.equals(this.attributeName)) {
			this.attributeName = attributeName;
			this.values = null;
		}
	}

    protected Map values() {
    	if (values == null) {
			Map values = new TreeMap();
			values.put("className", className);
			values.put("attributeName", attributeName);
			this.values = Collections.unmodifiableMap(values);
		}
		return values;
    }
}
