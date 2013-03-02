package org.gvsig.tools.dynobject.impl;

import java.util.Map;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dynobject.DelegatedDynObject;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynMethod;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectRuntimeException;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.exception.DynFieldNotFoundException;
import org.gvsig.tools.dynobject.exception.DynMethodException;
import org.gvsig.tools.dynobject.exception.DynMethodNotSupportedException;
import org.gvsig.tools.dynobject.impl.DefaultDynClass.FieldAndIndex;

public class DefaultDynObject implements DelegatedDynObject {

	protected DefaultDynClass dynClass;
	protected Map values;
	protected DynObject[] delegateds;

	public DefaultDynObject(DynStruct dynClass) {
		this.dynClass = (DefaultDynClass) dynClass;
		this.delegateds = null;
		this.values = this.dynClass.createValues(null);
	}

	public void implement(DynClass dynClass) {
		this.dynClass = (DefaultDynClass) ((DefaultDynObjectManager) ((DefaultDynClass) dynClass)
				.getManager()).get(new DynClass[] { this.dynClass, dynClass });
		this.values = this.dynClass.createValues(this.values);
	}

	public Object getDynValue(String name) throws DynFieldNotFoundException {
		boolean defined = false;
		Object defaultValue = null;
		name = name.toLowerCase();
		FieldAndIndex fieldAndIndex = dynClass.getDynFieldAndIndex(name);
		if (fieldAndIndex != null) {
			if (values.containsKey(name)) {
				return values.get(name);
			}
			defined = true;
			defaultValue = fieldAndIndex.getDynField().getDefaultValue();
		}
		if (delegateds != null) {
			for (int i = 0; i < delegateds.length; i++) {
				DynObject dynObj = delegateds[i];
				try {
					if (dynObj.hasDynValue(name)) {
						return dynObj.getDynValue(name);
					} else {
						defined = true;
						defaultValue = dynObj.getDynValue(name);
					}
				} catch (DynFieldNotFoundException ex) {
					;
				}
			}
		}
		if (defined) {
			return defaultValue;
		}
		throw new DynFieldNotFoundException(name, dynClass.getName());
	}

	public void setDynValue(String name, Object value)
			throws DynFieldNotFoundException {
		name = name.toLowerCase();
		
		if (this.dynClass.getDynField(name)==null) {
			throw new DynFieldNotFoundException(name, this.getDynClass()
					.getName());
		}

		try {
			values.put(name, this.dynClass.getDynField(name).coerce(value));
		} catch (CoercionException e) {
			throw new CoerceValueException(this.dynClass, name, value, e);
		}
	}

	public class CoerceValueException extends DynObjectRuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8974502669097158348L;

		public CoerceValueException(DynStruct dynStruct, String fieldName,
				Object value, Throwable cause) {
			super(
					"Can't convert value %(value) for field %(field) of class %(class).",
					cause,
					"Cant_convert_value_XvalueX_for_field_XfieldX_of_class_XclassX",
					serialVersionUID);
			setValue("field", fieldName);
			setValue("class", dynStruct.getFullName());
			try {
				setValue("value", value.toString());
			} catch (Exception e1) {
				setValue("value", "???");
			}
		}

	}

	public boolean instanceOf(DynClass dynClass) {
		return dynClass.isInstance(this);
	}

	public DynClass getDynClass() {
		return this.dynClass;
	}

	public boolean hasDynValue(String name) throws DynFieldNotFoundException {
		boolean defined = false;
		name = name.toLowerCase();
		
		int index = dynClass.getFieldIndex(name);
		if (index >= 0) {
			if (this.values.containsKey(name)) {
				return true;
			}

			defined = true;
		}
		if (delegateds != null) {
			for (int i = 0; i < delegateds.length; i++) {
				DynObject dynObj = delegateds[i];
				try {
					if (dynObj.hasDynValue(name)) {
						return true;
					} else {
						defined = true;
					}
				} catch (DynFieldNotFoundException ex) {
					;
				}
			}
		}
		if (defined) {
			return false;
		}
		throw new DynFieldNotFoundException(name, dynClass.getName());
	}

	public void delegate(DynObject dynObjects) {
		if (delegateds == null) {
			this.delegateds = new DynObject[1];
			this.delegateds[0] = dynObjects;
			return;
		}
		DynObject[] newValues = new DynObject[this.delegateds.length + 1];
		System.arraycopy(delegateds, 0, newValues, 0, delegateds.length);
		newValues[delegateds.length] = dynObjects;
		this.delegateds = newValues;
	}

	public Object invokeDynMethod(String name, DynObject context)
			throws DynMethodException {
		throw new IllegalArgumentException("self required");
	}

	public Object invokeDynMethod(int code, DynObject context) throws DynMethodException {
		throw new IllegalArgumentException("self required");
	}

	public Object invokeDynMethod(Object self, String methodName,
			DynObject context)throws DynMethodException {
		DynMethod method = this.dynClass.getDynMethod(methodName);
		if (method == null) {
			if (delegateds != null) {
				for (int i = 0; i < delegateds.length; i++) {
					try {
						return delegateds[i].invokeDynMethod(methodName,
								context);
					} catch (DynMethodNotSupportedException e) {
						// continue next delegated
					}
				}

			}
			throw new DynMethodNotSupportedException(methodName, self
					.getClass().getName());

		}
		return method.invoke(self, context);
	}

	public Object invokeDynMethod(Object self, int methodCode, DynObject context) throws DynMethodException {
		DynMethod method = this.dynClass.getDynMethod(methodCode);
		if (method == null) {
			if (delegateds != null) {
				for (int i = 0; i < delegateds.length; i++) {
					try {
						return delegateds[i].invokeDynMethod(methodCode,
								context);
					} catch (DynMethodNotSupportedException e) {
						// continue next delegated
					}
				}
				throw new DynMethodNotSupportedException(methodCode, self
						.getClass().getName());

			} else {
				throw new DynMethodNotSupportedException(methodCode, self
						.getClass().getName());
			}
		}
		return this.dynClass.manager.invokeDynMethod(self, methodCode, context);
	}

	public void clear() {
		DynField[] fields = getDynClass().getDeclaredDynFields();

		for (int i = 0; i < fields.length; i++) {
			this.setDynValue(fields[i].getName(), fields[i].getDefaultValue());
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		DynClass dynClass = getDynClass();
		buffer.append("DynClass name: ").append(dynClass.getName()).append(
";  Fields: ");

		DynField[] fields = dynClass.getDeclaredDynFields();

		if (fields==null||fields.length==0){
			buffer.append("(none)");
		}else{
			buffer.append("[");			
			for (int i = 0; i < fields.length; i++) {
				if (i != 0) {
					buffer.append(", ");
				}
				buffer.append(fields[i].getName()).append(" = ")
		            .append(getDynValue(fields[i].getName()));
		    }
			buffer.append("]");
		}
		return buffer.toString();
	}

    public boolean hasEmptyValues() {
        return this.values.isEmpty();
    }
}
