package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToInt implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if( ! (value instanceof Integer) ) {
				if( value instanceof Number ) {
                    value = new Integer(((Number) value).intValue());
				} else {
					String s = value.toString().trim().toLowerCase();
					if( s.startsWith("0x")) {
						value = Integer.valueOf(s.substring(2), 16);
					} else {
					    value = Integer.valueOf(s);
					}
				}
			}
			return value;
		} catch(Exception e) {
			throw new CoercionException(e); 
		}
	}

}
