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
 * Identifies a field, such as year or minuteOfHour, in a chronology-neutral way.
 * </p>
 * <p>
 * Instances of this class are singletons and they can be compared using the
 * {@link AbsoluteInstantType}{@link #getType()} method and the <code>==</code>
 * operator.
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
public interface AbsoluteInstantType {
	 public static final int ERA = 1;
	 public static final int YEAR_OF_ERA = 2;
	 public static final int CENTURY_OF_ERA = 3;
	 public static final int YEAR_OF_CENTURY = 4;
	 public static final int YEAR = 5;
	 public static final int DAY_OF_YEAR = 6;
	 public static final int MONTH_OF_YEAR = 7;
	 public static final int DAY_OF_MONTH = 8;
	 public static final int WEEKYEAR_OF_CENTURY = 9;
	 public static final int WEEKYEAR = 10;
	 public static final int WEEK_OF_WEEKYEAR = 11;
	 public static final int DAY_OF_WEEK = 12;
	 public static final int HALFDAY_OF_DAY = 13;
	 public static final int HOUR_OF_HALFDAY = 14;
	 public static final int CLOCKHOUR_OF_HALFDAY = 15;
	 public static final int CLOCKHOUR_OF_DAY = 16;
	 public static final int HOUR_OF_DAY = 17;
	 public static final int MINUTE_OF_DAY = 18;
	 public static final int MINUTE_OF_HOUR = 19;
	 public static final int SECOND_OF_DAY = 20;
	 public static final int SECOND_OF_MINUTE = 21;
	 public static final int MILLIS_OF_DAY = 22;
	 public static final int MILLIS_OF_SECOND = 23;
	
	 /**
	  * Gets the code of the type, that is one of the constants defined
	  * in the {@link AbsoluteInstantType} class.
	  * @return
	  *            the type code
	  */
	 public int getType();
	 
	 /**
	  * Gets a description of the {@link AbsoluteInstantType}.
	  * @return
	  *            the name of the type
	  */
	 public String getName();
}

