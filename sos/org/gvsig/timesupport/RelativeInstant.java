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

import java.util.Date;

import org.gvsig.tools.lang.Cloneable;

/**
 * <p>
 * A relative instant is defined like an instant in the datetime continuum 
 * specified as a number of milliseconds from 1970-01-01T00:00Z. This definition 
 * of milliseconds is consistent with that of the JDK in Date or Calendar.
 * </p>
 * <p>It contains also a Chronology which determines how the millisecond 
 * instant value is converted into the date time fields. The default Chronology 
 * can be set using the {@link TimeSupportManager} class. (e.g: 1st January 2010)
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
public interface RelativeInstant extends Instant, Cloneable{
  
    /**
     * Get the date time as a <code>java.util.Date</code>.
     * <p>
     * The <code>Date</code> object created has exactly the same millisecond
     * instant as this object.
     * </p>
     *
     * @return 
     *          a Date initialised with this relative instant
     */
    public Date toDate();
    
    /**
     * Compares this object with the specified object for ascending
     * millisecond instant order. This ordering is inconsistent with
     * equals, as it ignores the Chronology.
     *
     * @param instant
     *          a readable instant to check against
     * @return 
     *          negative value if this is less, 0 if equal, or positive 
     *          value if greater
     */
    public int compareTo(Instant instant);
             
    /**
     * Gets the milliseconds of the datetime instant from the Java epoch
     * of 1970-01-01T00:00:00Z.
     * 
     * @return 
     *          the number of milliseconds since 1970-01-01T00:00:00Z
     */
    public long toMillis();    
    
    /**
     * Get the year field value.
     * 
     * @return 
     *          the year
     */
    public int getYear();

    /**
     * Get the month of year field value.
     * 
     * @return 
     *          the month of year
     */
    public int getMonthOfYear();
 
    /**
     * Get the day of month field value.
     * 
     * @return 
     *          the day of month
     */
    public int getDayOfMonth();

    /**
     * Get the hour of day field value.
     * 
     * @return 
     *          the hour of month
     */
    public int getHourOfDay();

    /**
     * Get the minute of day field value.
     * 
     * @return 
     *          the minute of day
     */
    public int getMinuteOfDay();

    /**
     * Get the minute of hour field value.
     * 
     * @return 
     *          the minute of hour
     */
    public int getMinuteOfHour();   

    /**
     * Get the second of day field value.
     * 
     * @return 
     *          the second of day
     */
    public int getSecondOfDay();

    /**
     * Get the second of minute field value.
     * 
     * @return 
     *          the second of minute
     */
    public int getSecondOfMinute();

    /**
     * Get the millis of second field value.
     * 
     * @return 
     *          the millis of second
     */
    public int getMillisOfSecond();
    
    /**
     * Get an editable copy used to edit other instance of
     * a relative instant. The new copy is initialized with
     * the values of this intant.
     *    
     * @return
     *          a copy to edit the instant 
     */
    public EditableRelativeInstant getEditableCopy();
    
    /**
     * Output the instant using the specified format pattern.
     *
     * @param 
     *          pattern  the pattern specification, null means 
     *          use <code>toString</code>
     */
    public String toString(String pattern);   
}

