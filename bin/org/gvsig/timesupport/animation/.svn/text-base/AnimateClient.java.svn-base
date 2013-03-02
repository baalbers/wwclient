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
package org.gvsig.timesupport.animation;

import org.gvsig.timesupport.RelativeInstant;

/**
 * This interface should be implemented by clients of this module. The
 * library calls update function each time that an increment happen. 
 * 
 * @author <a href="mailto:nachobrodin@gmail.com">Nacho Brodin</a>
 * 
 */
public interface AnimateClient {
	/**
	 * Updates the animation client
	 * @param startDateTime
	 * 			Date when the step starts
	 * @param endDateTime
	 *          Date when the step ends
	 */
	public void update(RelativeInstant startDateTime, RelativeInstant endDateTime);
	
	/**
	 * This event is thrown when an iteration finishes. An iteration is a complete
	 * cycle from the start date to the finish date.
	 * @param endDateTime
	 * 			Date when the iteration ends
	 */
	public void endIteration(RelativeInstant endDateTime);
	
	/**
	 * This event is thrown when the animation finishes
	 */
	public void end();
}
