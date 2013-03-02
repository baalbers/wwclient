package org.gvsig.tools.dataTypes;

import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public interface DataType {

	public boolean isObject() ;
	
	public boolean isDynObject();

	public boolean isContainer() ;
	
	public boolean isNumeric();
	
	public String getName() ;
	
	public int getType() ;

	public Class getDefaultClass() ;

	public String getSubtype() ;

	public Coercion getCoercion() ;
	
	public void setCoercion(Coercion coercion) ;
	
	public void addCoercion(Coercion coercion) ;
	
	public Object coerce(Object value) throws CoercionException;

}
