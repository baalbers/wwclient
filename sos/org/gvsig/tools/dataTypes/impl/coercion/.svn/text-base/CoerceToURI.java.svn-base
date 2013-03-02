package org.gvsig.tools.dataTypes.impl.coercion;

import java.net.URI;
import java.net.URISyntaxException;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;


public class CoerceToURI implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		if( ! (value instanceof URI) ) {
			if( value instanceof String ) {
				try {
					value = new URI((String) value);
				} catch (URISyntaxException e) {
					throw new CoercionException(e);
				}
			} else {
				throw new CoercionException();
			}
		}
		return value;
	}

}
