package org.gvsig.tools.dataTypes.impl.coercion;

import java.io.File;
import java.net.URI;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;


public class CoerceToFile implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		if( ! (value instanceof File) ) {
			if( value instanceof String ) {
				value = new File((String) value);
			} else if( value instanceof URI ) {
				value = new File((URI) value);
			} else {
				throw new CoercionException();
			}
		}
		return value;
	}

}
