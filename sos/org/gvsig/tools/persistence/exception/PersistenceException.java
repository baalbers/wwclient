package org.gvsig.tools.persistence.exception;

import org.gvsig.tools.exception.ListBaseException;

public class PersistenceException extends ListBaseException {
	private static final long serialVersionUID = -3729654883985281840L;
	private final static String MESSAGE_FORMAT = "Error getting or setting the state of an object.";
	private final static String MESSAGE_KEY = "_error_getting_or_setting_the_state_of_an_object";

	/**
	 * 
	 * @param messageFormat
	 * @deprecated No debe usarse este constructor, si lo necesitas, seguramente tendrias que 
	 *                          crear una excepcion mas concreta que deribe de esta.
	 */
	public PersistenceException(String messageFormat) {
		super(messageFormat, MESSAGE_KEY, serialVersionUID);
	}

	public PersistenceException(Throwable cause) {
		this(MESSAGE_FORMAT, cause);
	}

	public PersistenceException() {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
	}

	protected PersistenceException(String messageFormat, String messageKey, long code) {
		super(messageFormat, messageKey, code);
	}
	
	protected PersistenceException(String messageFormat, Throwable cause, String messageKey, long code) {
		super(messageFormat, cause, messageKey, code);
	}

	public PersistenceException(String messageFormat, Throwable cause) {
		super(messageFormat, cause, MESSAGE_KEY, serialVersionUID);
	}
}
