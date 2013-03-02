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
 * A time interval represents a period of time between two instants.
 * Intervals are inclusive of the start instant and exclusive of the end.
 * The end instant is always greater than or equal to the start instant.
 * </p>
 * <p> 
 * Intervals have a fixed millisecond duration. This is the difference between 
 * the start and end instants. As a result, intervals are not comparable. 
 * To compare the length of two intervals, you should compare their durations.
 * </p> * 
 * <p>A huge part of the documentation of this class has been retrieved
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
public interface Interval extends Time{
    
    /**
     * Does this time interval contain the specified time instant.      
     * @param instant
     *          the time instant to compare to, null means now 
     * @return
     *          <code>true</code> if this time interval contains the time instant
     */
    public boolean contains(Instant instant);
        
    /**
     * Gets the start of this time interval, which is inclusive, as an Instant. 
     * @return
     *          the start of the time interval
     */
    public Instant getStart();
    
    /**
     * Gets the end of this time interval, which is exclusive, as an Instant. 
     * @return
     *          the end of the time interval
     */
    public Instant getEnd();
    
    /**
     * Gets the duration of the interval. If the interval is relative, it returns the
     * exact duration. It the interval is relative, it returns a duration assuming a 365
     * days year, 12 months year, 30 days month, 7 day week, 24 hour day, 60 minute hour,
     * 60 second minute and 1000 millis second. 
     * @return
     *          a duration equivalent to this interval
     */
    public Duration toStandardDuration();
}
