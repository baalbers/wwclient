/* gvSIG. Geographic Information System of the Valencian Government
 *
 * Copyright (C) 2007-2008 Infrastructures and Transports Department
 * of the Valencian Government (CIT)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 */
package org.gvsig.tools.dataTypes.impl.coercion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;

/**
 * Abstract implementation for Date coercion classes. If the value is not a
 * {@link Date}, it will use the {@link Object#toString()} method to convert the
 * resulting {@link String} to a Date object.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public abstract class AbstractCoerceToDate implements Coercion {

    public Object coerce(Object value) throws CoercionException {
        if (!(value instanceof Date)) {
            DateFormat dateFormatter = createFormatter();
            String valueStr = value.toString();
            try {
                Date d = dateFormatter.parse(valueStr);
                if (d == null) {
                    throwCoercionException(dateFormatter, valueStr, null);
                }
                return d;
            } catch (ParseException e) {
                throwCoercionException(dateFormatter, valueStr, e);
            }
        }
        return value;
    }

    private void throwCoercionException(DateFormat format, String valueStr,
        ParseException e) throws CoercionException {
        String formatDesc =
            format instanceof SimpleDateFormat ? ((SimpleDateFormat) format)
                .toLocalizedPattern() : format.toString();
        throw new CoercionException("The value to coerce (\"" + valueStr
            + "\") has an invalid " + getDateType()
            + " String format. The expected one is: " + formatDesc, e);
    }

    /**
     * Returns the {@link DateFormat} to apply when the value to coerce is not
     * of Date type and it will be parsed as String.
     * 
     * @return the {@link DateFormat} to apply to parse the value to coerce as
     *         {@link String}
     */
    protected abstract DateFormat createFormatter();

    /**
     * Returns the name of the Date type being coerced. Ex: Date, DateTime,
     * Time. Only used for description when an error is produced when coercing
     * the value.
     * 
     * @return the name of the Date type being coerced
     */
    protected abstract String getDateType();

}
