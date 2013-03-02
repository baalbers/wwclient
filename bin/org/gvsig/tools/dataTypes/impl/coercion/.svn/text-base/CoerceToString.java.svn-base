package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToString implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if( !(value instanceof String )) {
				value = value.toString();
			}
			return value;
		} catch (Exception e) {
			throw new CoercionException(e);
		}

	}

}
