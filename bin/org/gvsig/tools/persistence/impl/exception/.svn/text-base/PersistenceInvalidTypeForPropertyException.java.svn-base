package org.gvsig.tools.persistence.impl.exception;

import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceInvalidTypeForPropertyException extends PersistenceException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -557067450892214489L;
	private final static String MESSAGE_FORMAT = "Invalid type '%(mode)' for property '%(name)'.";
	private final static String MESSAGE_KEY = "_Invalid_type_XmodeX_for_property_XnameX";
	private static final  Logger logger = LoggerFactory.getLogger(PersistenceInvalidTypeForPropertyException.class);


	public PersistenceInvalidTypeForPropertyException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("name", name);
	}

	public PersistenceInvalidTypeForPropertyException(String name, DynStruct definition, DynField field, Object value) {
		super(
				"The type expected for %(definition).%(name) is %(fieldType) and is %(valueType).", 
				"_The_type_expected_for_XdefinitionX.XnameX_is_XfieldTypeX_and_is_XvalueTypeX", 
				serialVersionUID
		);
		setValue("name", name);
		setValue("definition", definition.getName());
		setValue("fieldType", field.getDataType().getName());
		setValue("valueType", value.getClass().getName());
		
		logger.warn("The type expected for {}.{} is {} and is {}.", 
			new String[] {
				definition.getName(),
				field.getName(),
				field.getDataType().getName(),
				value.getClass().getName()
			}
		);
	}
	
	
}
