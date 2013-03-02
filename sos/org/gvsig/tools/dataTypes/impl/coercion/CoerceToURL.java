package org.gvsig.tools.dataTypes.impl.coercion;

import java.net.MalformedURLException;
import java.net.URL;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;


public class CoerceToURL implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		if( ! (value instanceof URL) ) {
			if( value instanceof String ) {
				try {
					value = new URL((String) value);
				} catch (MalformedURLException e) {
					throw new CoercionException(e);
				}
			} else {
				throw new CoercionException();
			}
		}
		return value;
	}

}
