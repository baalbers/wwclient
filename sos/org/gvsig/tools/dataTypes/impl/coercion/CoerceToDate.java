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
import java.util.Date;

/**
 * Coerces a value to a {@link Date}. If the value is not a {@link Date}, it
 * will use the {@link Object#toString()} method to convert the
 * resulting {@link String} to a Date object using the current locale default
 * formatter for Date through the {@link DateFormat#getDateInstance(int)} method
 * and the {@link DateFormat#SHORT} style.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public class CoerceToDate extends AbstractCoerceToDate {

    protected DateFormat createFormatter() {
        return DateFormat.getDateInstance(DateFormat.SHORT);
    }

    protected String getDateType() {
        return "Date";
    }

}
