package org.gvsig.tools.persistence.impl.exception;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceInvalidValidateModeException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = -9045679785762388324L;
	private final static String MESSAGE_FORMAT = "Invalid validation mode '%(mode)'.";
	private final static String MESSAGE_KEY = "_Invalid_validation_mode_XmodeX";

	public PersistenceInvalidValidateModeException(int mode) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("mode", new Integer(mode));
	}
}
