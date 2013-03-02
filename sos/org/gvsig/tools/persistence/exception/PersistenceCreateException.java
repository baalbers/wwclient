package org.gvsig.tools.persistence.exception;

import java.lang.reflect.Constructor;

public class PersistenceCreateException extends PersistenceRuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1173336779528392650L;
	private final static String MESSAGE_FORMAT1 = "Can't create new instance of '%(class)'.";
	private final static String MESSAGE_FORMAT2 = "Can't create new instance of '%(class)', need a public contructor without arguments.";
	private final static String MESSAGE_KEY = "_PersistenceCreateException";

	public PersistenceCreateException(Class theClass, Throwable cause) {
		super(MESSAGE_FORMAT1, cause, MESSAGE_KEY, serialVersionUID);
		if( theClass == null ) {
			this.setValue("class", "UNKNOW");
		} else {
			this.setValue("class", theClass.getName());
			if( cause instanceof InstantiationException ) {
				boolean needEmptyConstructor = true;
				Constructor[] constructors = theClass.getConstructors();
				for( int  i=0; i<constructors.length; i++ ) {
					Constructor constructor = constructors[i];
					Class[] parameters = constructor.getParameterTypes();
					if( parameters.length == 0) {
						needEmptyConstructor = false;
					}
				}
				if( needEmptyConstructor ) {
					this.setFormatString(MESSAGE_FORMAT2);
				}
			}
		}
	}

	public PersistenceCreateException(String theClass, Throwable cause) {
		super(MESSAGE_FORMAT1, cause, MESSAGE_KEY, serialVersionUID);
		if( theClass == null ) {
			this.setValue("class", "UNKNOW");
		} else {
			this.setValue("class", theClass);
		}
	}
	
}
