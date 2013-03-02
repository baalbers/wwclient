package org.gvsig.tools.dynobject.exception;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynStruct;

public class DynFieldValidateException extends DynMethodException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5033443492130842514L;
	private final static String MESSAGE_FORMAT = "Field '%(field)': Invalid value '%(value)'.";
	private final static String MESSAGE_KEY = "_Field_XfieldX_Invalid_value_XvalueX";

	protected DynFieldValidateException(String messagefmt, String key, long code) {
		super(messagefmt, key, code);
	}

	public DynFieldValidateException(Object value, DynField field,
			Throwable cause) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		if (cause != null) {
			this.initCause(cause);
		}

		setValue("field", field.getName());
		setValue(value);
		if (field.getAvailableValues() != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(ToolsLocator.getDataTypesManager().getTypeName(
					field.getType()));
			buffer.append(" ( ");
			for (int i = 0; i < field.getAvailableValues().length; i++) {
				buffer.append(field.getAvailableValues()[i].getValue()
						.toString());
				buffer.append(", ");
			}
			buffer.append(")");
			setValue("fieldtype", buffer.toString());
		} else if (field.getMaxValue() != null && field.getMinValue() != null) {
			setValue("fieldtype", ToolsLocator.getDataTypesManager()
					.getTypeName(field.getType())
					+ "  (  "
					+ field.getMinValue().toString()
					+ " <= x <=  "
					+ field.getMaxValue().toString() + ")");

		} else {
			setValue("fieldtype", ToolsLocator.getDataTypesManager()
					.getTypeName(field.getType()));
		}
		if (value == null) {
			setValue("valuetype", "null");
		} else {
			setValue("valuetype", value.getClass().getName());
		}
	}

	private void setValue(Object value) {
		try {
			if (value instanceof DynObject) {
				// setValue("value", getDynObjectValueText((DynObject) value));
				setValue("value",
						getDynClassValueText(((DynObject) value).getDynClass()));
				return;
			} else if (value instanceof DynClass) {
				setValue("value", getDynClassValueText((DynStruct) value));
				return;
			} else if (value instanceof DynStruct) {
				setValue("value", getDynClassValueText((DynStruct) value));
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

	private String getDynClassValueText(DynStruct definition) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(definition.getName()).append("\n  ");
		buffer.append("Mandatory values are: ");
		DynField[] fields = definition.getDynFields();
		if (fields == null || fields.length == 0) {
			buffer.append("(none)\n");
			return buffer.toString();
		}
		
		DynField field;
		String DEL = ",  ";
		StringBuffer items = new StringBuffer();
		
		buffer.append("[");
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			if (field.isMandatory()) {
				items.append(field.getName());
				items.append(DEL);
			}
		}
		buffer.append(items);
		buffer.append("]");
		
		return buffer.toString();
	}

	private String getDynObjectValueText(DynObject dynObject) {
		String space = "  ";
		StringBuffer buffer = new StringBuffer();
		buffer.append(dynObject.getDynClass().getName()).append("\n");
		DynField[] fields = dynObject.getDynClass().getDynFields();
		if (fields == null || fields.length == 0) {
			return buffer.toString();
		}

		DynField field;
		buffer.append("(\n");
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			Object value = null;
			try {
				value = dynObject.getDynValue(field.getName());
				field.validate(value);
			} catch (DynFieldValidateException ex) {
				if (value instanceof DynObject) {
					buffer.append(space).append(
							getDynObjectValueText((DynObject) value));
				} else {
					buffer.append(space).append(ex.getLocalizedMessageStack());
				}
			} catch (DynFieldNotFoundException ex2) {
				if (value instanceof DynObject) {
					buffer.append(space).append(
							getDynObjectValueText((DynObject) value));
				} else {
					buffer.append(space).append(ex2.getLocalizedMessageStack());
				}
			}
		}
		buffer.append(")");
		return buffer.toString();
	}

	public DynFieldValidateException(Object value, DynField field) {
		this(value, field, null);
	}
}
