package org.gvsig.tools.persistence.impl.exception;

import java.util.Collections;
import java.util.Map;

import org.gvsig.tools.persistence.exception.PersistenceException;

public class PersistenceIDNotLoadedException extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1173336779528392650L;
	private final static String MESSAGE_FORMAT = "The '%(id)' isn't declared and try to get it.";
	private final static String MESSAGE_KEY = "_PersistenceIDNotLoadedException";
	private Integer id;

	public PersistenceIDNotLoadedException(Integer id) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.id = id;
	}


    protected Map values() {
        return Collections
                .singletonMap("id", id.toString());
    }
}
