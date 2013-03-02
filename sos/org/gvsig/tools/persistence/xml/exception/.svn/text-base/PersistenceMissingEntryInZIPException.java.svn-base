package org.gvsig.tools.persistence.xml.exception;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceMissingEntryInZIPException extends
		PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -250292376190219948L;
	private final static String MESSAGE_FORMAT = "Missing entry '%(name) in zip file.";
	private final static String MESSAGE_KEY = "_PersistenceMissingEntryInZIPException";

	public PersistenceMissingEntryInZIPException(String name)  {
		super( MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("name", name);
	}

}
