package org.gvsig.tools.util.impl;

import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.util.Callable;

public class CallableException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 786823929903465907L;

	public CallableException(Callable callable, Throwable cause) {
		super(
			"Error '%(error)' calling '%(callable)'.",
			cause,
			"_error_calling_XcallableX",
			serialVersionUID
		);
		setValue("error", cause.getClass().getName());
		setValue("callable", callable.getClass().getName());
	}
}
