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
 * Data model for animation. This is useful to configure the animation
 * parameters. When the animation runs read the values of this object.
 * 
 * @author <a href="mailto:nachobrodin@gmail.com">Nacho Brodin</a>
 * 
 */
public interface TimeAnimationDataModel {
	public static final int          PLAY    = 0;
	public static final int          STOP    = 1;
	public static final int          PAUSE   = 2;
	public static final int          CLOSE   = 3;
	
	public static final int          ACCEPT  = 0;
	public static final int          CANCEL  = 1;
	
	//*************************
	
	/**
	 * Assigns the window time. The scale is the selected with the
	 * method setWindowScale.
	 * @param windowTime
	 *        Window of time of each step
	 */
	public void setWindowTime(int windowTime);
	
	/**
	 * Gets the window time. The scale is the selected with the
	 * method setWindowScale.
	 */
	public int getWindowTime();
	
	/**
	 * Gets the initial speed in milliseconds
	 * @param speed
	 */
	public int getTimeStep();
	
	/**
	 * Sets the animation speed 
	 * @param speed
	 *        Speed in milliseconds
	 */
	public void setTimeStep(int timeStep);
	
	/**
	 * Returns a constant defined in TimeAnimation. This constant represents the
	 * scale of time of the window (year, month, day, ...)
	 * @return
	 */
	public int getWindowTimeScale();
	
	/**
	 * Assigns a constant defined in TimeAnimation. This constant represents the
	 * scale of time of the window (year, month, day, ...)
	 * @return
	 */
	public void setWindowTimeScale(int windowTimeScale);
	
	/**
	 * Returns a constant defined in TimeAnimation. This constant represents the
	 * scale of time of the time step (year, month, day, ...)
	 * @return
	 */
	public int getTimeStepScale();
	
	/**
	 * Assigns a constant defined in TimeAnimation. This constant represents the
	 * scale of time of the time step (year, month, day, ...)
	 * @return
	 */
	public void setTimeStepScale(int timeStepScale);
	
	//*************************
	
	/**
	 * Gets the time step initial value in the text field
	 * @param timeStep
	 */
	public int getSpeed();
	
	/**
	 * Sets the speed of progress
	 * @param speed
	 */
	public void setSpeed(int speed);
	
	/**
	 * Gets the number of iterations
	 * @return
	 */
	public int getIterations();
	
	/**
	 * Sets the number of iterations
	 * @param iterations
	 */
	public void setIterations(int iterations);
	
	/**
	 * Gets the number of loops
	 * @return
	 */
	public int getLoop();
	
	/**
	 * Sets the number of loops
	 * @return
	 */
	public void setLoop(int loop);
	
	//***************************
	
	/**
	 * Sets the time window to visualize in each time instant. The time window is the
	 * amount of data to show in each step. At the beginning this window goes from the
	 * initial data time. When the animation has been started this window is moving along
	 * the time line. 
	 * @param start
	 *        Instant in which the animation starts
	 * @param end
	 *        Instant in which the animation ends
	 */
	public void setTimeWindow(RelativeInstant start, RelativeInstant end);
	
	/**
	 * Gets the end of the time window to visualize in each time instant. The time window is the
	 * amount of data to show in each step. At the beginning this window goes from the
	 * initial data time. When the animation has been started this window is moving along
	 * the time line. 
	 * @return {@link RelativeInstant}
	 */
	public RelativeInstant getEndTimeWindow();

	/**
	 * Gets the begin of the time window to visualize in each time instant. The time window is the
	 * amount of data to show in each step. At the beginning this window goes from the
	 * initial data time. When the animation has been started this window is moving along
	 * the time line. 
	 * @return {@link RelativeInstant}
	 */
	public RelativeInstant getInitTimeWindow();
	
	//***************************
	
	/**
	 * Sets the time interval. The time interval contains two date. The start date is the moment
	 * in which the animation starts and in the end date the animation ends. 
	 * @param timeWindowValue
	 */
	public void setTimeInterval(RelativeInstant start, RelativeInstant end);
	
	/**
	 * Gets the initial date of the time window to visualize in each time instant. 
	 * The time window is the amount of data to show in each step.
	 * @return {@link RelativeInstant}
	 */
	public RelativeInstant getInitTime();
	
	/**
	 * Gets the end date of the time window to visualize in each time instant. 
	 * The time window is the amount of data to show in each step.
	 * @return {@link RelativeInstant}
	 */
	public RelativeInstant getEndTime();
	
	//***************************
	
	/**
	 * Gets an array of seven values. Each element of this 
	 * array represents the number of years, months, days, hours, 
	 * minutes, seconds and milliseconds of a window time.
	 */
	public int[] getWindowTimeByPartOfData();
	
	/**
	 * Gets an array of seven values. Each element of this 
	 * array represents the number of years, months, days, hours, 
	 * minutes, seconds and milliseconds of a step.
	 */
	public int[] getStepByPartOfData();
	
	/**
	 * Gets the slider position. This position is specified in real time. 
	 * @return {@link RelativeInstant} 
	 */
	public RelativeInstant getSliderPosition();
	
	/**
	 * Assigns the slider position. This position is specified in real time. 
	 * @param position
	 */
	public void setSliderPosition(RelativeInstant position);
}
