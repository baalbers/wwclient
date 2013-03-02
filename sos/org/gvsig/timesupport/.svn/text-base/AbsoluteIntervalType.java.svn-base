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
package org.gvsig.timesupport;


/**
 * <p>
 * Identifies a field, such as year or month, in a chronology-neutral way.
 * </p>
 * <p>
 * Instances of this class are singletons and they can be compared using the
 * {@link AbsoluteIntervalType}{@link #getType()} method and the <code>==</code>
 * operator.
 * </p>
 * 
 * @author gvSIG Team
 * @version $Id$
 *
 */
public interface AbsoluteIntervalType {
    public static final int YEARS = 0;
    public static final int MONTHS = 1;
    public static final int WEEKS = 2;
    public static final int DAYS = 3;
    public static final int HOURS = 4;
    public static final int MINUTES = 5;
    public static final int SECONDS = 6;
    public static final int MILLIS = 7;
    
    /**
     * Gets the code of the type, that is one of the constants defined
     * in the {@link AbsoluteIntervalType} class.
     * @return
     *            the type code
     */
    public int getType();
    
    /**
     * Gets a description of the {@link AbsoluteIntervalType}.
     * @return
     *            the name of the type
     */
    public String getName();
}
