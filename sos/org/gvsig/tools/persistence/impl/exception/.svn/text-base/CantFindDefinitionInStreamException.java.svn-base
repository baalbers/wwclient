package org.gvsig.tools.persistence.impl.exception;

import org.gvsig.tools.persistence.exception.AddDefinitionException;

public class CantFindDefinitionInStreamException extends AddDefinitionException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214010138683901294L;

	public CantFindDefinitionInStreamException(String name) {
		super(
			"Can't find definition %(name)s in stream.", 
			"_cant_find_definition_XnameX_in_stream", 
			serialVersionUID
		);
		setValue("name",name);
	}

	public CantFindDefinitionInStreamException(String name, String found) {
		super(
				"Can't find definition %(name)s in stream, found %(found)s.", 
				"_cant_find_definition_XnameX_in_stream_found_XfoundX", 
				serialVersionUID
			);
		setValue("name",name);
		setValue("found",found);
	}
}
