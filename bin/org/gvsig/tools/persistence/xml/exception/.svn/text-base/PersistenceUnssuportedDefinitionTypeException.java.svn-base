package org.gvsig.tools.persistence.xml.exception;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;

public class PersistenceUnssuportedDefinitionTypeException extends
		PersistenceRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7720851981749985511L;
	private final static String MESSAGE_FORMAT = "Can't generate xml schema, unssuported type %(type) in field '%(field)' of '%(definition)' for class '%(classname)'.";
	private final static String MESSAGE_KEY = "_Cant_generate_xml_schema_unssuported_type_XtypeX_in_field_XfieldX_of_X(definitionX_for_class_XclassnameX";

	public PersistenceUnssuportedDefinitionTypeException(String classname, DynStruct definition, DynField field)  {
		super( MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.setValue("type", ToolsLocator.getDataTypesManager().getTypeName(field.getType()));
		this.setValue("field", field.getName());
		this.setValue("definition", definition.getName());
		this.setValue("classname", classname);
	}
}
