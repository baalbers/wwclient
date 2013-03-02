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
 * It defines a partial time that does not support every datetime field,
 * and is thus a local time. It cannot be compared to a {@link RelativeInstant},
 * as it does not fully specify an instant in time. 
 * </p>
 * <p>
 * The time it does specify is a local time, and does not include a time zone. 
 * An AbsoluteInstant supports a subset of the fields on the chronology.
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
public interface AbsoluteInstant extends Instant, Cloneable{
   
    /**
     * Gets the number of fields in this absolute instant.     
     * @return 
     *          the field count
     */
    public int size();
   
    /**
     * Gets the field type at the specified index.
     * @param index 
     *          the index to retrieve
     * @return 
     *          the field at the specified index
     */
    public AbsoluteInstantType getFieldType(int index);
    
    /**
     * Gets the value of the field at the specifed index.
     * @param index 
     *          the index
     * @return the value
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
     * Gets the number of weeks of this absolute instant. 
     * @return
     *          the number of weeks
     */
    public int getWeeks();
    
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
     * Gets the duration of the instant. It returns a duration assuming a 365
     * days year, 12 months year, 30 days month, 7 day week, 24 hour day, 60 minute hour,
     * 60 second minute and 1000 millis second. 
     * @return
     *          a duration equivalent to this instant from the time 0
     */
    public Duration toStandardDuration();
    
    /**
     * Gets a copy of this instance with the specified period take away.
     * If the amount is zero or null, then <code>this</code> is returned.     *
     * @param period  
     *          the period to reduce this instant by
     * @return 
     *          a copy of this instance with the period taken away
     * @throws ArithmeticException if the new instant exceeds the capacity of a long
     */
    public AbsoluteInstant minus(AbsoluteInterval interval);

    /**
     * Gets a copy of this instance with the specified period added.
     * If the amount is zero or null, then <code>this</code> is returned.
     *
     * @param period
     *          the duration to add to this one, null means zero
     * @return
     *          a copy of this instance with the period added
     * @throws ArithmeticException if the new instant exceeds the capacity of a long
     */
    public AbsoluteInstant plus(AbsoluteInterval interval);     
}

