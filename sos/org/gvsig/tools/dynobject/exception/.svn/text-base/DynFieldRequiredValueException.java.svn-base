package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynStruct;

public class DynFieldRequiredValueException extends DynFieldValidateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813629748228774775L;
    private final static String MESSAGE_FORMAT =
        "Field '%(fieldText)': Value required.";
    private final static String MESSAGE_KEY =
        "_Field_XfieldTextX_Value_required";

	public DynFieldRequiredValueException(DynField field, Object value) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);

        setValue("field", field.getName());
        setValue("fieldText", translate(field.getName()));
		setValue(value);
	}

    private String translate(String name) {
        return ToolsLocator.getI18nManager().getTranslation(name);
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

	public String getDynFieldName() {
		return this.getDynField().getName();
	}

	public Object getValueOfException() {
		return this.values().get("value");
	}

}
