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
 * An Instant represents a position in a time scale. In practice, 
 * an instant is an interval whose duration is less than the resolution
 * of the time scale.
 * </p>
 * <p>All the Instant subclasses have to be immutable and have to 
 * provide a Chronology as well. All standard Chronology classes are
 * also immutable.
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
public interface Instant extends Time{
   
    /**
     * Is this instant equal to the instant passed in comparing solely by millisecond. 
     * @param instant
     *          an instant to check against, null means now 
     * @return
     *          <code>true</code> if the instant is equal to the instant passed in
     */
    public boolean isEqual(Instant instant);
    
    /**
     * Is this instant after the instant passed in comparing solely by millisecond. 
     * @param instant
     *          an instant to check against, null means now 
     * @return
     *          <code>true</code> if the instant is after the instant passed in
     */
    public boolean isAfter(Instant instant);
    
    /**
     * Is this instant before the instant passed in comparing solely by millisecond. 
     * @param instant
     *          an instant to check against, null means now 
     * @return
     *          <code>true</code> if the instant is before the instant passed in
     */
    public boolean isBefore(Instant instant);
}
