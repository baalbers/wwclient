package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynStruct;

public class DynObjectFieldSubtypeRequiredValueException extends
		DynFieldValidateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813629748228774775L;
	private final static String MESSAGE_FORMAT = "Field '%(field)': DynObject field in '%(definitionName)' needs to have its subtype set to '%(definitionFullName)'";
	private final static String MESSAGE_KEY = "_Field_XfieldX_Value_required.";

	public DynObjectFieldSubtypeRequiredValueException(
			DynStruct parentDefinition, DynField field, Object value) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("definitionFullName", parentDefinition.getFullName());
		setValue("definitionName", parentDefinition.getName());
		setValue("field", field.getName());
		setValue(value);
	}

	private void setValue(Object value) {
		try {
			if (value instanceof DynObject) {
				setValue("value", ((DynObject) value).getDynClass().getName());
				return;
			} else if (value instanceof DynClass) {
				setValue("value", ((DynClass) value).getName());
				return;
			} else if (value instanceof DynStruct) {
				setValue("value", ((DynStruct) value).getName());
				return;
			}
			if (value == null) {
				setValue("value", "null");
			} else {
				setValue("value", value.toString());
			}
		} catch (Exception e) {
			setValue("value", "(unknow)");
		}
	}

	public DynField getDynField() {
		return (DynField) this.values().get("field");
	}

	public DynField getDefinition() {
		return (DynField) this.values().get("definitionFullName");
	}

	public String getDynFieldName() {
		return this.getDynField().getName();
	}

	public Object getValueOfException() {
		return this.values().get("value");
	}
}