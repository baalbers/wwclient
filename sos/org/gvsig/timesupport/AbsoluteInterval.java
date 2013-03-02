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

import org.gvsig.tools.lang.Cloneable;


/**
 * <p>
 * Is defined like an interval between two absolute instants. 
 * </p>
 * <p>
 * A huge part of the documentation of this class has been retrieved
 * from the joda-time library.
 * </p>
 * 
 * @see http://joda-time.sourceforge.net
 * @see https://gvsig.org/web/projects/gvsig-desktop/docs/devel/org-gvsig-sensors/1-0.0/analysis-and-design/detailed-view/time-support/libraries/org-gvsig-timesupport-lib
 * 
 * @author gvSIG team
 * @version $Id$
 */
public interface AbsoluteInterval extends Interval, Cloneable{
    
    /**
     * Gets the start of this time interval, which is inclusive, as an Instant. 
     * @return
     *          the start of the time interval
     */
    public AbsoluteInstant getStart();
    
    /**
     * Gets the end of this time interval, which is exclusive, as an Instant. 
     * @return
     *          the end of the time interval
     */
    public AbsoluteInstant getEnd();
    
    /**
     * Gets the number of fields that this absolute interval supports.
     * @return 
     *          the number of fields supported
     */   
    public int size();

    /**
     * Gets the field type at the specified index.
     * @param index 
     *          the index to retrieve
     * @return 
     *          the field at the specified index
     */
    public AbsoluteIntervalType getFieldType(int index);

    /**
     * Gets the value at the specified index.
     *
     * @param index  
     *          the index to retrieve
     * @return
     *          the value of the field at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public int getValue(int index);

    /**
     * Gets the number of years of this absolute instant. 
     * @return
     *          the number of years
     */
    public int getYears();

    /**
     * Gets the number of months of this absolute instant. 
     * @return
     *          the number of months
     */
    public int getMonths();

    /**
     * Gets the number of days of this absolute instant. 
     * @return
     *          the number of days
     */
    public int getDays();

    /**
     * Gets the number of hours of this absolute instant. 
     * @return
     *          the number of hours
     */
    public int getHours();

    /**
     * Gets the number of minutes of this absolute instant. 
     * @return
     *          the number of minutes
     */
    public int getMinutes();

    /**
     * Gets the number of seconds of this absolute instant. 
     * @return
     *          the number of seconds
     */
    public int getSeconds();
    
    /**
     * Gets the number of millis of this absolute instant. 
     * @return
     *          the number of millis
     */
    public int getMillis(); 
    
    /**
     * Is this time interval after the specified interval. Intervals are inclusive
     * of the start instant and exclusive of the end.
     * @param absoluteInterval
     *          the insterval to compare to, null means now
     * @return
     *          <code>true</code> if this time interval is after the absoluteInterval
     */
    public boolean isAfter(AbsoluteInterval absoluteInterval);
    
    /**
     * Is this time interval before the specified interval. Intervals are inclusive
     * of the start instant and exclusive of the end.
     * @param absoluteInterval
     *          the insterval to compare to, null means now
     * @return
     *          <code>true</code> if this time interval is before the absoluteInterval
     */
    public boolean isBefore(AbsoluteInterval absoluteInterval);
}

