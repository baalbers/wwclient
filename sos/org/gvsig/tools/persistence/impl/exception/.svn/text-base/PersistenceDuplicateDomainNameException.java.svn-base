package org.gvsig.tools.persistence.impl.exception;

import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;

public class PersistenceDuplicateDomainNameException extends PersistenceRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5091214092364791497L;
	private final static String MESSAGE_FORMAT = "Duplicate domain name '%(name)', previous url '%(oldurl)', new url '%(newurl)'.";
	private final static String MESSAGE_KEY = "_PersistenceDuplicateDomainNameException";
	
	public PersistenceDuplicateDomainNameException(String name, String oldurl, String newurl) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("name", name);
		this.setValue("oldurl", oldurl);
		this.setValue("newurl", newurl);
	}
	
}
