package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToLong implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if( ! (value instanceof Long) ) {
				if( value instanceof Number ) {
					value = new Long(((Number)value).longValue());
				} else {
					String s = value.toString().trim().toLowerCase();
					if( s.startsWith("0x")) {
						value = Long.valueOf(s.substring(2), 16);
					} else {
					    value = Long.valueOf(s);
					}
				}
			}
			return value;
		} catch(Exception e) {
			throw new CoercionException(e); 
		}
	}

}
