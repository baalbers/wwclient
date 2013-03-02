package org.gvsig.tools.persistence.exception;

import java.util.HashMap;
import java.util.Map;

public class FieldNotDeclaredException extends PersistenceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2004462745021928700L;
	private final static String MESSAGE_FORMAT = "Field '%(field) not declared for class %(class)'.";
	private final static String MESSAGE_KEY = "_PersistenceClassNotRegistered";
	private String fieldName;
	private String theClass;

	public FieldNotDeclaredException(String fieldName, Class theClass) {
		this(fieldName, theClass.getName());
	}

	public FieldNotDeclaredException(String fieldName, String theClass){
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.theClass = theClass;
		this.fieldName = fieldName;
	}

   protected Map values() {
	   Map values = new HashMap();
	   values.put("class", this.theClass);
	   values.put("field", this.fieldName);
	   return values;
	}
}
