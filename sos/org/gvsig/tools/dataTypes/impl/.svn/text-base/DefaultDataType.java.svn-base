package org.gvsig.tools.dataTypes.impl;

import java.text.MessageFormat;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataType;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDataType implements DataType {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultDataTypesManager.class);
	
	private Coercion coercion;
	private Class defaultClass;
	private String subtype;
	private int type;
	private String name;
	
	DefaultDataType(int type, String subtype, String name, Class defaultClass, Coercion coercion) {

		if( name == null ) {
			LOG.trace("Can't register null type name for type {}.", new Object[] { Integer.toHexString(type).toUpperCase()});
			throw new IllegalArgumentException();
		}
		this.type = type;
		this.subtype = subtype;
		this.name = name;
		this.defaultClass  = defaultClass;
		this.coercion = coercion;
	}
	
	public Object coerce(Object value) throws CoercionException {
		// http://en.wikipedia.org/wiki/Type_conversion#Implicit_type_conversion

		if( this.coercion != null ) {
			return this.coercion.coerce(value);
		}
		if( defaultClass == null ) {
			return value; // �?
		}
		if( defaultClass.isInstance(value) ) {
			return value;
		}
		throw new CoercionException();
	}

	public Coercion getCoercion() {
		return this.coercion;
	}

	public Class getDefaultClass() {
		return this.defaultClass;
	}

	public String getSubtype() {
		return this.subtype;
	}

	public int getType() {
		return this.type;
	}

	public String getName() {
		return this.name;
	}

	public boolean isContainer() {
		return (type & DataTypes.CONTAINER) == DataTypes.CONTAINER;
	}

	public boolean isObject() {
		return (type & DataTypes.OBJECT) == DataTypes.OBJECT;
	}

	public boolean isDynObject() {
		return type == DataTypes.DYNOBJECT;
	}

	public void setCoercion(Coercion coercion) {
		this.coercion = coercion;
		LOG.trace("Add coercion operation for data type {}.", new Object[] { name });
	}

	public void addCoercion(Coercion coercion) {
		LinkedCoercions coercions = null;
		if (this.coercion instanceof LinkedCoercions) {
			coercions = (LinkedCoercions) this.coercion;
		} else {
			coercions = new LinkedCoercions();
			coercions.add(this.coercion);
			this.coercion = coercions;
		}
		coercions.add(coercion);
		LOG.trace("Add coercion operation for data type {}.", new Object[] { name });
	}

	public String toString() {
		return MessageFormat.format(
				"type=0x{0};subtype={1};name={2};class={3};coercion={4}", 
				new Object[] {
					Integer.toHexString(type).toUpperCase(),
					subtype,
					name,
					defaultClass==null? null:defaultClass.getName(),
					coercion==null? null:coercion.getClass().getName()
				}
		);
	}

	public boolean isNumeric() {
		if( type == DataTypes.DOUBLE ||
			type == DataTypes.FLOAT ||
		    type == DataTypes.INT ||
			type == DataTypes.LONG){
			return true;
		}
		return false;
	}

	public class LinkedCoercions implements Coercion {
		
		public class LinkedCoercion {
			Coercion coercion;
			LinkedCoercion theNext;
			
			LinkedCoercion(Coercion coercion, LinkedCoercion next) {
				this.theNext = next; 
				this.coercion = coercion;
			}
			
			public Object coerce(Object value) throws CoercionException {
				return this.coercion.coerce(value);
			}
			
			public boolean is(Coercion coercion) {
				return coercion.getClass().getName().equals(this.coercion.getClass().getName());
			}
			
			public boolean hasNext() {
				return this.theNext != null;
			}
			
			public LinkedCoercion next() {
				return this.theNext;
			}
		}
		
		LinkedCoercion head = null;
		
		public LinkedCoercions() {
			super();
		}
		
		public void add(Coercion coercion) {
			if( !this.contains(coercion)) {
				head = new LinkedCoercion(coercion, head);
			}
		}

		public boolean contains(Coercion coercion) {
			LinkedCoercion x = head;
			while( x!=null ) {
				if( x.is(coercion)) {
					return true;
				}
				x = x.next();
			}
			return false;
		}
		
		public Object coerce(Object value) throws CoercionException {
			LinkedCoercion x = head;
			while( x!=null ) {
				try {
					return x.coerce(value);
				} catch (CoercionException e) {
					x = x.next();
					if( x==null ) {
						throw e;
					}
				}
			}
			throw new CoercionException();
		}

	}

	
}
