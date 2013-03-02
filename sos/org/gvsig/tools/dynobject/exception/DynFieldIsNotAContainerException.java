package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.dynobject.DynObjectRuntimeException;

public class DynFieldIsNotAContainerException extends DynObjectRuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1538491031568651876L;

	private static final String KEY = "_Container_type_is_required_for_type_of_field_XnameX";

    private static final String MESSAGE = "Container type (array, list, map or set) is requiered for type of field '%(name).";

    public DynFieldIsNotAContainerException(String dynFieldName) {
        super(MESSAGE, KEY, serialVersionUID);
        this.setValue("name", dynFieldName);
    }


}
