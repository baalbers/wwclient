package org.gvsig.tools.dynobject.exception;


public class DynMethodNotSupportedException extends DynMethodException {

	/**
	 *
	 */
	private static final long serialVersionUID = -5061673498469446308L;
	private final static String MESSAGE_FORMAT = "Method not suported";
	private final static String MESSAGE_FORMAT_CODE = "Method not suported (code=%(code)) for class %(className)";
	private final static String MESSAGE_FORMAT_NAME = "Method not suported (name=%(name)) for class %(className)";
	private final static String MESSAGE_KEY = "_Method_not_suported";
	private final static String MESSAGE_KEY_CODE = "_Method_of_code_XcodeX_not_suported_for_class_XclassNameX";
	private final static String MESSAGE_KEY_NAME = "_Method_of_name_XnameX_not_suported_for_class_XclassNameX";

	public DynMethodNotSupportedException() {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
	}

	public DynMethodNotSupportedException(int code, String className) {
		super(MESSAGE_FORMAT_CODE, MESSAGE_KEY_CODE, serialVersionUID);
		setValue("code", "" + code);
		setValue("className", className);
	}

	public DynMethodNotSupportedException(String name, String className) {
		super(MESSAGE_FORMAT_NAME, MESSAGE_KEY_NAME, serialVersionUID);
		setValue("name", name);
		setValue("className", className);
	}

}
