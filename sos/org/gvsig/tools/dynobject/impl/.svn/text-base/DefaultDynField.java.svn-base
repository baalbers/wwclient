package org.gvsig.tools.dynobject.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataType;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dataTypes.DataTypesManager;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectException;
import org.gvsig.tools.dynobject.DynObjectValueItem;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.exception.DynFieldIsNotAContainerException;
import org.gvsig.tools.dynobject.exception.DynFieldRequiredValueException;
import org.gvsig.tools.dynobject.exception.DynFieldValidateException;
import org.gvsig.tools.dynobject.exception.DynObjectValidateException;
import org.gvsig.tools.exception.ListBaseException;

public class DefaultDynField implements DynField {
	private String name;
	private String description;

	private DataType dataType;
	private String subtype;

	private Object defaultValue;

	private int order;
	private boolean hidden;
	private String groupName;
	private DynObjectValueItem[] availableValues;
	private Object minValue;
	private Object maxValue;
	private boolean mandatory;
	private boolean persistent;
	private Class theClass;
	private DynField elementsType;
	private boolean validateElements;
	private boolean isReadOnly;
	private Class theClassOfItems = null;

	public void check() throws ListBaseException {
		ListBaseException exceptions = null;

		if (name == null) {
			exceptions = CheckDynFieldListException.add(exceptions, name,
					"name", name);
		}
		if (exceptions != null) {
			throw exceptions;
		}
	}

	public static class CheckDynFieldListException extends ListBaseException {

		public static class CheckDynFieldException extends DynObjectException {

			/**
			 * 
			 */
			private static final long serialVersionUID = 2486744641818117262L;

			public CheckDynFieldException(String attrname, Object attrvalue) {
				super("Wrong value %(value) for attribute %(name).",
						"Wrong_value_XvalueX_for_attribute_XnameX",
						serialVersionUID);
			}
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CheckDynFieldListException(String name) {
			super("Inconsistent field %(name) definition.",
					"_Inconsistent_field_XnameX_definition", serialVersionUID);
			if (name == null) {
				name = "[unknow]";
			}
			setValue("name", name);
		}

		public static ListBaseException add(ListBaseException exceptions,
				String name, String attrname, Object attrvalue) {
			if (exceptions == null) {
				exceptions = new CheckDynFieldListException(name);
			}
			exceptions.add(new CheckDynFieldException(attrname, attrvalue));
			return exceptions;
		}
	}

	public DefaultDynField(String name) {
		this(name, // field name
				DataTypes.STRING, // data type
				null, // default value
				true, // persistent
				false // mandatory
		);
	}

	private DefaultDynField(String name, int dataType) {
		this(name, // field name
				dataType, // data type
				null, // default value
				true, // persistent
				false // mandatory
		);
	}

	public DefaultDynField(String name, int dataType, Object defaultValue,
			boolean persistent, boolean mandatory) {
		DataTypesManager datamanager = ToolsLocator.getDataTypesManager();

		this.name = name;
		this.dataType = datamanager.get(dataType);
		this.defaultValue = defaultValue;
		this.persistent = persistent;
		this.mandatory = mandatory;
		this.theClass = null;
		this.validateElements = false;
		this.subtype = this.dataType.getSubtype();
		this.groupName = null;
		this.order = 0;
		this.hidden = false;
		this.availableValues = null;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("DynField").append("[").append(this.hashCode())
				.append("]").append("( ").append("name='").append(this.name)
				.append("', ").append("description='").append(this.description)
				.append("', ").append("type='").append(this.dataType.getName())
				.append("', ").append("subType='").append(this.subtype)
				.append("', ").append("mandatory='").append(this.isMandatory())
				.append("', ").append("defaultValue='")
				.append(this.getDefaultValue()).append("', ")
				.append("dataType=[").append(this.dataType).append("], ")
				.append("minValue='").append(this.minValue).append("', ")
				.append("maxValue='").append(this.maxValue).append("', ")
				.append("persistent='").append(this.isPersistent())
				.append(" )");
		return buffer.toString();
	}

	public String getName() {
		return name;
	}

	public DynField setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return (description == null) ? getName() : description;
	}

	public DynField setType(int dataType) {
		DataTypesManager datamanager = ToolsLocator.getDataTypesManager();
		return setType(datamanager.get(dataType));
	}

	public DynField setType(DataType dataType) {
		this.dataType = dataType;
		this.theClass = this.dataType.getDefaultClass();
		this.subtype = this.dataType.getSubtype();
		return this;
	}

	public int getType() {
		return dataType.getType();
	}

	public DataType getDataType() {
		return this.dataType;
	}

	public DynField setSubtype(String subtype) {
		this.subtype = subtype;
		if (subtype != null && this.dataType.getType() == DataTypes.LIST
				&& this.elementsType != null
				&& this.elementsType.getType() == DataTypes.DYNOBJECT) {
			if (ToolsLocator.getDynObjectManager().get(subtype) == null) {
				throw new IllegalArgumentException("DynClass '" + subtype
						+ "' does not exist.");
			}
			this.elementsType.setSubtype(subtype);
		} else if (subtype != null
				&& this.dataType.getType() == DataTypes.DYNOBJECT) {
			if (ToolsLocator.getDynObjectManager().get(subtype) == null) {
				throw new IllegalArgumentException("DynClass '" + subtype
						+ "' does not exist.");
			}
		}
		return this;
	}

	public String getSubtype() {
		return subtype;
	}

	public DynField setDefaultDynValue(Object defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public DynField setAvailableValues(DynObjectValueItem[] availableValues) {
		// If type is a list then the available values should be at the elements
		// type, not here.
		if (this.getType() == DataTypes.LIST) {
			if (this.getElementsType() != null) {
				this.getElementsType().setAvailableValues(availableValues);
				return this;
			}
		}
		if (availableValues == null || availableValues.length == 0) {
			this.availableValues = null;
		} else {
			this.availableValues = availableValues;
		}
		return this;
	}

	public DynField setAvailableValues(List availableValues) {
		// If type is a list then the available values should be at the elements
		// type, not here.
		if (this.getType() == DataTypes.LIST) {
			if (this.getElementsType() != null) {
				this.getElementsType().setAvailableValues(availableValues);
				return this;
			}
		}
		if (availableValues == null) {
			this.availableValues = null;
		} else if (availableValues.isEmpty()) {
			this.availableValues = null;
		} else {
			this.availableValues = (DynObjectValueItem[]) availableValues
					.toArray(new DynObjectValueItem[availableValues.size()]);
		}
		return this;
	}

	public DynObjectValueItem[] getAvailableValues() {
		return availableValues;
	}

	public DynField setMinValue(Object minValue) {
		try {
			this.minValue = this.coerce(minValue);
		} catch (CoercionException e) {
			IllegalArgumentException ex = new IllegalArgumentException(e.getLocalizedMessage());
			ex.initCause(e);
			throw ex;
		}
		return this;
	}

	public Object getMinValue() {
		return minValue;
	}

	public DynField setMaxValue(Object maxValue) {
		try {
			this.maxValue = this.coerce(maxValue);
		} catch (CoercionException e) {
			IllegalArgumentException ex = new IllegalArgumentException(e.getLocalizedMessage());
			ex.initCause(e);
			throw ex;
		}
		return this;
	}

	public Object getMaxValue() {
		return maxValue;
	}

	public boolean isMandatory() {
		return this.mandatory;
	}

	public boolean isPersistent() {
		return this.persistent;
	}

	public DynField setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
		return this;
	}

	public DynField setPersistent(boolean persistent) {
		this.persistent = persistent;
		return this;
	}

	public DynField setTheTypeOfAvailableValues(int type) {
		return this; // FIXME: this method is @deprecated
	}

	public int getTheTypeOfAvailableValues() {
		return 1; // FIXME: this method is @deprecated
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof DynField) {
			// FIXME: No esta claro que esto sea correcto.
			return name.equals(((DynField) obj).getName());
		}
		return false;
	}

	public Class getClassOfValue() {
		return theClass;
	}

	public DynField setValidateElements(boolean validate) {
		if (!this.dataType.isContainer()) {
			throw new DynFieldIsNotAContainerException(this.name);
		}
		this.validateElements = validate;
		return this;
	}

	public boolean getValidateElements() {
		return this.validateElements;
	}

	public DynField setClassOfValue(Class theClass)
			throws DynFieldIsNotAContainerException {
		this.theClass = theClass;
		return this;
	}

	public DynField setElementsType(int type)
			throws DynFieldIsNotAContainerException {
		if (!isContainer()) {
			throw new DynFieldIsNotAContainerException(this.name);
		}
		this.elementsType = new DefaultDynField(this.name + "-"
				+ this.dataType.getName() + "-item", type);
		return this;
	}

	public DynField setElementsType(DynStruct type)
			throws DynFieldIsNotAContainerException {
		// Getter allows null values
		if (type != null) {
			this.setElementsType(DataTypes.DYNOBJECT).getElementsType()
					.setSubtype(type.getFullName());
		}
		return this;
	}

	public boolean isContainer() {
		return this.dataType.isContainer();
	}

	public DynField getElementsType() {
		return this.elementsType;
	}

	public void validate(Object value) throws DynFieldValidateException {
		Comparable v;
		if (value == null) {
			if (this.mandatory) {
				throw new DynFieldRequiredValueException(this, value);
			}
			return;
		}

		switch (this.dataType.getType()) {
		case DataTypes.BOOLEAN:
			if (!(value instanceof Boolean)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.DOUBLE:
			if (!(value instanceof Double)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.FLOAT:
			if (!(value instanceof Float)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.INT:
			if (!(value instanceof Integer)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.LONG:
			if (!(value instanceof Long)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.STRING:
			if (!(value instanceof String)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.DATE:
			if (!(value instanceof Date)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.LIST:
			if (!(value instanceof List)) {
				throw new DynFieldValidateException(value, this);
			}
			if (this.validateElements && this.elementsType != null) {
				Iterator it = ((List) value).iterator();
				while (it.hasNext()) {
					this.elementsType.validate(it.next());
				}
			}
			break;

		case DataTypes.MAP:
			if (!(value instanceof Map)) {
				throw new DynFieldValidateException(value, this);
			}
			break;
		case DataTypes.FILE:
			if (!(value instanceof File)) {
				throw new DynFieldValidateException(value, this);
			}
			break;
		case DataTypes.FOLDER:
			if (!(value instanceof File)) {
				throw new DynFieldValidateException(value, this);
			}
			break;
		case DataTypes.URI:
			if (!(value instanceof URI)) {
				throw new DynFieldValidateException(value, this);
			}
			break;
		case DataTypes.URL:
			if (!(value instanceof URL)) {
				throw new DynFieldValidateException(value, this);
			}
			break;
		case DataTypes.SET:
			if (!(value instanceof Set)) {
				throw new DynFieldValidateException(value, this);
			}
			break;

		case DataTypes.DYNOBJECT:
			if (!(value instanceof DynObject)) {
				throw new DynFieldValidateException(value, this);
			}
			DynClass dynClass = ToolsLocator.getDynObjectManager().get(
					this.getSubtype());
			if (dynClass == null || !dynClass.isInstance((DynObject) value)) {
				throw new DynFieldValidateException(value, this);
			}
			try {
				dynClass.validate((DynObject) value);
			} catch (DynObjectValidateException e) {
				throw new DynFieldValidateException(value, this, e);
			}
			break;

		case DataTypes.ARRAY:
			// TODO: falta verificar que es un array del tipo que toca.
			break;

		default:
			if (this.dataType.isObject()) {
				if (this.theClass != null) {
					if (!this.theClass.isInstance(value)) {
						throw new DynFieldValidateException(value, this);
					}
				}
			} else {
				throw new DynFieldValidateException(value, this);
			}
		}

		if (this.getAvailableValues() != null) {
			if (!(value instanceof Comparable)) {
				throw new DynFieldValidateException(value, this);
			}
			v = (Comparable) value;
			boolean ok = false;
			for (int i = 0; i < this.availableValues.length; i++) {
				if (v.compareTo(this.availableValues[i].getValue()) == 0) {
					ok = true;
					break;
				}
			}
			if (!ok) {
				throw new DynFieldValidateException(value, this);
			}
		} else if (this.getMaxValue() != null && this.getMinValue() != null) {
			if (!(value instanceof Comparable)) {
				throw new DynFieldValidateException(value, this);
			}
			v = (Comparable) value;
			if (v.compareTo(this.minValue) < 0
					|| v.compareTo(this.maxValue) > 0) {
				throw new DynFieldValidateException(value, this);
			}
		}
		//
		// This shouldn't be necessary since any assignment passes through the
		// coerce function anyway
		//
		// //if all the above is correct, then we should check that coercing is
		// possible
		// try {
		// coerce(value);
		// } catch (CoercionException e) {
		// throw new DynFieldValidateException(value, this);
		// }

	}

	public Object coerce(Object value) throws CoercionException {
		if (value == null) {
			return value; // O debe devolver this.defaultValue
		}
		return this.dataType.coerce(value);
	}

	public String getGroup() {
		return this.groupName;
	}

	public DynField setGroup(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public int getOder() {
		return this.order;
	}

	public DynField setOrder(int order) {
		this.order = order;
		return this;
	}

	public boolean isHidden() {
		return this.hidden;
	}

	public DynField setHidden(boolean hidden) {
		this.hidden = hidden;
		return this;
	}

	public boolean isReadOnly() {
		return this.isReadOnly;
	}

	public DynField setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
		return this;
	}

	public Class getClassOfItems() {
		return this.theClassOfItems;
	}

	public DynField setDefaultFieldValue(Object defaultValue) {
		try {
			this.defaultValue = this.coerce(defaultValue);
		} catch (CoercionException e) {
			IllegalArgumentException ex = new IllegalArgumentException(e.getLocalizedMessage());
			ex.initCause(e);
			throw ex;
		}
		return this;
	}

	public DynField setClassOfItems(Class theClass)
			throws DynFieldIsNotAContainerException {
		// Getter allows null values
		if (theClass == null) {
			return this;
		}
		if (!this.dataType.isContainer()) {
			throw new DynFieldIsNotAContainerException(this.name);
		}
		this.theClassOfItems = theClass;
		return this;
	}

}