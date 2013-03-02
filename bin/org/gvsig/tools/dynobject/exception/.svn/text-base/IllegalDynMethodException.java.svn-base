package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.dynobject.DynClass;

public class IllegalDynMethodException extends DynMethodException {

	/**
	 *
	 */
	private static final long serialVersionUID = 2958323225403802109L;
	private final static String MESSAGE_FORMAT = "Method %(name) not found in class %(badclass).";
	private final static String MESSAGE_KEY = "_Method_XnameX_not_found_in_class_XbadclassX";

	public IllegalDynMethodException(String name, Class badClass) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("name", name);
		setValue("badclass", badClass.getName());
	}

	public IllegalDynMethodException(String name, DynClass badDynClass) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("name", name);
		setValue("badclass", badDynClass.getName());
	}
}
