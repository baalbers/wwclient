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
 * Chronology provides access to the individual date time fields for a
 * chronological calendar system.
 * </p> 
 *  <p>
 * Various chronologies are supported by subclasses including ISO
 * and GregorianJulian. To construct a Chronology you should use the
 * factory methods on the {@link TimeSupportManager}.
 * <p>
 * The provided chronology implementations are:
 * <ul>
 * <li>ISO - Based on the ISO8601 standard and suitable for use after about 1600
 * <li>GJ - Historically accurate calendar with Julian followed by Gregorian
 * <li>Gregorian - The Gregorian calendar system used for all time (proleptic)
 * <li>Julian - The Julian calendar system used for all time (proleptic)
 * <li>Buddhist - The Buddhist calendar system which is an offset in years from GJ
 * <li>Coptic - The Coptic calendar system which defines 30 day months
 * <li>Ethiopic - The Ethiopic calendar system which defines 30 day months
 * </ul>
 * </p>
 * <p>
 * Instances of this class are singletons and they can be compared using the
 * {@link Chronology}{@link #getType()} method and the <code>==</code>
 * operator.
 * </p>
 * <p>
 * A huge part of the documentation of this class has been retrieved
 * from the joda-time library.
 * </p>
 * 
 * @see http://joda-time.sourceforge.net
 * @see https://gvsig.org/web/projects/gvsig-desktop/docs/devel/org-gvsig-sensors/1-0.0/analysis-and-design/detailed-view/time-support/libraries/org-gvsig-timesupport-lib
 * 
 * @author gvSIG Team
 * @version $Id$
 *
 */
public interface Chronology {
    public static final int BUDDHIST = 1;
    public static final int COPTIC = 2;
    public static final int GJ = 3;
    public static final int GREGORIAN = 4;
    public static final int ISO = 5;
    public static final int JULIAN = 6;

    /**
     * Gets the code of the type, that is one of the constants defined
     * in the {@link Chronology} class.
     * @return
     *            the type code
     */
    public int getType();    
    
    /**
     * Returns an instance of this Chronology that operates in the UTC time
     * zone. Chronologies that do not operate in a time zone or are already
     * UTC must return themself.
     * @return 
     *          a version of this chronology that ignores time zones
     */
    public Chronology withUTC();
}
