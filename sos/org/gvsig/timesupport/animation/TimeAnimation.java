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

/**
 * Time animation main interface. That is the main interface to control an
 * animation by time.
 * 
 * @author <a href="mailto:nachobrodin@gmail.com">Nacho Brodin</a>
 * 
 */
public interface TimeAnimation {
	public static final int          YEAR         = 0;
	public static final int          MONTH        = 1;
	public static final int          WEEK         = 2;
	public static final int          DAY          = 3;
	public static final int          HOUR         = 4;
	public static final int          MINUTE       = 5;
	public static final int          SECOND       = 6;
	public static final int          MILLISECOND  = 7;
	
	public static final int          NO_LOOP      = 0;
	public static final int          LOOP         = 1;
	public static final int          LOOP_N       = 2;
	
	/**
	 * Gets the data model for time animation. Data model contains 
	 * the time window, the step, the speed of progress and other
	 * information about an animation
	 * @return {@link TimeAnimationDataModel}
	 */
	public TimeAnimationDataModel getDataModel();
	
	/**
	 * Sets the client which receives events from the animation
	 * @param client
	 *        Interface with the functions to call when the animation increase a step, ends
	 *        or an iteration ends
	 */
	public void setAnimateClient(AnimateClient client);
	
	/**
	 * Stops the animation
	 */
	public void stopAnimation();
	
	/**
	 * Pauses the animation
	 */
	public void pauseAnimation();
	
	/**
	 * Starts the animation
	 */
	public void startAnimation();
	
	/**
	 * Tests if this thread is alive. A thread is alive if it has been started and has not yet died. 
	 */
	public boolean isAlive();
}
