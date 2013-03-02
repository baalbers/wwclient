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
 * This object is in the top level of the time hierarchy. All the temporal 
 * objects have to inherit of this interface.
 * </p>
 * 
 * @see https://gvsig.org/web/projects/gvsig-desktop/docs/devel/org-gvsig-sensors/1-0.0/analysis-and-design/detailed-view/time-support/libraries/org-gvsig-timesupport-lib
 * 
 * @author gvSIG Team
 * @version $Id$
 *
 */
public interface Time {
    
    /**
     * Does this time intersects with the time passed.
     * @param time
     *          an instant to check against, null means now 
     * @return
     *          <code>true</code> if the time intersects with the time passed in
     */
    public boolean intersects(Time time);
    
    /**
     * Checks if the time is a relative temporal type, that is an object that has
     * a Chronology that establish how a time object can be converted into other
     * object with date time fields.
     * @return
     *          <code>true</code) if the time object is relative
     */
    public boolean isRelative();
    
    /**
     * Checks if the time is an absolute temporal type, that is an object that doesn't
     * has a time zone.
     * @return
     *          <code>true</code> if the time object is absolute
     */
    public boolean isAbsolute();
    
    /**
     * Checks if the time is an interval, that is an object that represents 
     * a period of time between two instants.
     * @return
     *          <code>true</code> if the time object is an interval
     */
    public boolean isInterval();
    
    /**
     * Checks if the time is an instant, that is an object that represents 
     * a position in a time scale. In practice, an instant is an interval 
     * whose duration is less than the resolution of the time scale.
     * @return
     *          <code>true</code> if the time object is an instant.
     */
    public boolean isInstant();
        
    /**
     * Gets the chronology of the instant. The Chronology provides conversion 
     * from the millisecond value to meaningful fields in a particular calendar system. 
     * @return
     *      the Chronology, never null
     */
    public Chronology getChronology();
}
