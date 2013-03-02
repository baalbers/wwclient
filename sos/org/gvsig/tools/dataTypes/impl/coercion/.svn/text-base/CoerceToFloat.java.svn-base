package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToFloat implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if (!(value instanceof Float)) {
				if (value instanceof Number) {
                    value = new Float(((Number) value).floatValue());
				} else {
					String s = value.toString().trim().toLowerCase();
					if( s.startsWith("0x")) {
						value = new Float(Long.parseLong(s.substring(2), 16));
					} else {
					    value = Float.valueOf(s);
					}
				}
			}
			return value;
		} catch (Exception e) {
			throw new CoercionException(e);
		}

	}

}
