package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToByte implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if( ! (value instanceof Byte) ) {
				if( value instanceof Number ) {
                    value = new Byte(((Number) value).byteValue());
				} else {
					String s = value.toString().trim().toLowerCase();
					if( s.startsWith("0x")) {
						value = Byte.valueOf(s.substring(2), 16);
					} else {
					    value = Byte.valueOf(value.toString());
					}
				}
			}
			return value;
		} catch (Exception e) {
			throw new CoercionException(e);
		}

	}

}
