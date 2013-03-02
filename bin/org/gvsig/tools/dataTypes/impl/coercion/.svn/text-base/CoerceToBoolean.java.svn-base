package org.gvsig.tools.dataTypes.impl.coercion;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

public class CoerceToBoolean implements Coercion {

	public Object coerce(Object value) throws CoercionException {
		try {
			if (!(value instanceof Boolean)) {
				if (value instanceof Number) {
					if (((Number) value).intValue() == 1) {
						value = Boolean.TRUE;
					} else {
						value = Boolean.FALSE;
					}
				} else {
					value = Boolean.valueOf(value.toString());
				}
			}
			return value;
		} catch (Exception e) {
			throw new CoercionException(e);
		}

	}

}
