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
 * A RelativeInterval is defined like an interval between two {@link RelativeInstant}s.
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
public interface RelativeInterval extends Interval, Cloneable{
    
    /**
     * Does this time interval contain the specified instant.     * 
     * @param instant
     *          the instant, null means now
     * @return 
     *          <code>true</code> if this time interval contains the instant
     */
    public boolean contains(RelativeInstant instant);
    
    /**
     * Does this time interval contain the specified interval.     * 
     * @param instant
     *          the time interval to compare to, null means a zero 
     *          duration interval now
     * @return 
     *          <code>true</code> if this time interval contains the interval
     */
    public boolean contains(RelativeInterval interval);
    
    /**
     * Does this time interval overlap the specified time interval.
     * @param interval
     *          the time interval to compare to, null means a zero 
     *          length interval now
     * @return
     *          <code>true</code> if the time intervals overlap
     */
    public boolean overlaps(RelativeInterval interval);
    
    /**
     * Is this time interval after the specified instant. Intervals are inclusive
     * of the start instant and exclusive of the end.
     * @param instant
     *          the instant to compare to, null means now
     * @return
     *          <code>true</code> if this time interval is after the instant
     */
    public boolean isAfter(RelativeInstant instant);

    /**
     * Is this time interval entirely after the specified interval.
     * Intervals are inclusive of the start instant and exclusive of the end.
     * Only the end time of the specified interval is used in the comparison.
     * @param interval
     *          the interval to compare to, null means now
     * @return 
     *          <code>true</code> if this time interval is after the interval specified
     */
    public boolean isAfter(RelativeInterval interval);

    /**
     * Is this time interval before the specified instant. Intervals are inclusive
     * of the start instant and exclusive of the end.
     * @param instant
     *          the instant to compare to, null means now
     * @return
     *          <code>true</code> if this time interval is before the instant
     */
    public boolean isBefore(RelativeInstant instant);

    /**
     * Is this time interval entirely before the specified interval.
     * Intervals are inclusive of the start instant and exclusive of the end.
     * Only the end time of the specified interval is used in the comparison.
     * @param interval
     *          the interval to compare to, null means now
     * @return 
     *          <code>true</code> if this time interval is before the interval specified
     */
    public boolean isBefore(RelativeInterval interval);
    
    /**
     * Gets the duration of this time interval.
     * @return
     *          the duration of the time interval
     */
    public Duration toDuration();
        
    /**
     * Gets the duration of this time interval in milliseconds. 
     * The duration is equal to the end millis minus the start millis.     
     * @return
     *          the duration of the time interval in milliseconds
     */
    public long toDurationMillis();
      
    /**
     * Gets the start of this time interval, which is inclusive, as an Instant. 
     * @return
     *          the start of the time interval
     */
    public RelativeInstant getStart();

    /**
     * Gets the end of this time interval, which is exclusive, as an Instant. 
     * @return
     *          the end of the time interval
     */
    public RelativeInstant getEnd();
}

