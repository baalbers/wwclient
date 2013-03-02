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
 * The {@link RelativeInstant} ins inmutable, but sometimes is necessary to
 * edit it. This class is an editable copy of a realtive instant that
 * cab be edited.
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
public interface EditableRelativeInstant extends RelativeInstant{
    
    /**
     * Set the time from fields. The date part of this object will be unaffected.
     *
     * @param hour
     *          the hour
     * @param minuteOfHour
     *          the minute of the hour
     * @param secondOfMinute
     *          the second of the minute
     * @param millisOfSecond
     *          the millisecond of the second
     * @throws IllegalArgumentException if the value is invalid
     * 
     */
    public void setTime(final int hour, final int minuteOfHour, final int secondOfMinute, final int millisOfSecond);

    /**
     * Set the date from fields. The time part of this object will be unaffected.
     *
     * @param year
     *          the year
     * @param monthOfYear
     *          the month of the year
     * @param dayOfMonth
     *          the day of the month
     * @throws IllegalArgumentException if the value is invalid
     */
    public void setDate(final int year, final int monthOfYear, final int dayOfMonth);
    
    /**
     * Add a number of years to the date.
     *
     * @param years  the years to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addYears(final int years);
    
    /**
     * Add a number of days to the date.
     *
     * @param days
     *          the days to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addDays(final int days);
           
    /**
     * Add a number of hours to the date.
     *
     * @param hours  
     *          the hours to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addHours(final int hours);
    
    /**
     * Add a number of minutes to the date.
     *
     * @param minutes
     *          the minutes to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addMinutes(final int minutes);
    
    /**
     * Add a number of seconds to the date.
     *
     * @param seconds
     *            the seconds to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addSeconds(final int seconds);
    
    /**
     * Add a number of millis to the date.
     *
     * @param millis
     *          the millis to add
     * @throws IllegalArgumentException if the value is invalid
     */
    public void addMillis(final int millis);
}


