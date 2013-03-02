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

import java.util.Date;

import org.gvsig.timesupport.animation.TimeAnimation;

/**
 * This class is responsible of the management of the library's business logic.
 * It is the library's main entry point.
 * 
 * @author gvSIG team
 * @version $Id$
 */
public interface TimeSupportManager {

    /**
     * Registers a new {@link AbsoluteInstantType} that can be used in the
     * creation of an {@link AbsoluteInstant}.
     * @param absoluteInstantType
     *          the AbsoluteInstantType to register
     */
    public void registerAbsoluteInstantType(AbsoluteInstantType absoluteInstantType);

    /**
     * Gets an {@link AbsoluteInstantType} by code.
     * @param type
     *          the code of the {@link AbsoluteInstantType} to retrieve.
     * @return
     *          an {@link AbsoluteInstantType} with a concrete code.
     * @throws AbsoluteInstantTypeNotRegisteredException
     *          if the {@link AbsoluteInstantType} doen's exist.
     */
    public AbsoluteInstantType getAbsoluteInstantType(int type) throws AbsoluteInstantTypeNotRegisteredException;

    /**
     * Registers a new {@link AbsoluteIntervalType} that can be used in the
     * creation of an {@link AbsoluteInterval}.
     * @param absoluteInstantType
     *          the AbsoluteIntervalType to register
     */
    public void registerAbsoluteIntervalType(AbsoluteIntervalType absoluteIntervalType);

    /**
     * Gets an {@link AbsoluteIntervalType} by code.
     * @param type
     *          the code of the {@link AbsoluteIntervalType} to retrieve.
     * @return
     *          an {@link AbsoluteIntervalType} with a concrete code.
     * @throws AbsoluteIntervalTypeNotRegisteredException
     *          if the {@link AbsoluteIntervalType} doen's exist.
     */
    public AbsoluteIntervalType getAbsoluteIntervalType(int type) throws AbsoluteIntervalTypeNotRegisteredException;

    /**
     * Registers a new {@link Chronology} that can be used in the
     * creation of any temporal object.
     * @param chronology
     *          the chronology to register
     */
    public void registerChronology(Chronology chronology);

    /**
     * Gets an {@link Chronology} by code.
     * @param type
     *          the code of the {@link Chronology} to retrieve.
     * @return
     *          an {@link Chronology} with a concrete code.
     */
    public Chronology getChronology(int typechronology);

    /**
     * Sets the default chronology. This chronology is used in all the
     * time object creation if the chronology is not fixed.
     * @param chronology
     *          the default chronology.
     */
    public void setDefaultChronology(int chronology);

    /**
     * Creates a {@link RelativeInstant} using the number of milliseconds from
     * 1970-01-01T00:00Z. It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param instant
     *          the milliseconds from 1970-01-01T00:00:00Z
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(long instant);
    
    /**
     * Creates a {@link RelativeInstant} using the number of milliseconds from
     * 1970-01-01T00:00Z and using a chronology.
     * @param instant
     *          the milliseconds from 1970-01-01T00:00:00Z.
     * @param chronology
     *          the chronology.
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(long instant, Chronology chronology);

    /**
     * Creates a {@link RelativeInstant} using a {@link Date}.
     * It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param date
     *          the java.util.Date
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(Date date);
    
    /**
     * Creates a {@link RelativeInstant} using a {@link Date} 
     * and using a chronology.    
     * @param date
     *          the java.util.Date
     * @param chronology
     *          the chronology.
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(Date date, Chronology chronology);
            
    /**
     * Creates a {@link RelativeInstant} using the current system time 
     * and using a chronology.   
     * @param date
     *          the java.util.Date
     * @param chronology
     *          the chronology.
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(Chronology chronology);

    /**
     * Creates a {@link RelativeInstant} using the datetime field values.
     * It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param year
     *          the year
     * @param monthOfYear
     *          the month of the year
     * @param dayOfMonth
     *          the day of the month
     * @param hourOfDay
     *          the hour of the day
     * @param minuteOfHour
     *          the minute of the hour
     * @param secondOfMinute
     *          the second of the minute
     * @param millisOfSecond
     *          the millisecond of the second  
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(int year, int monthOfYear, int dayOfMonth, int hourOfDay,
        int minuteOfHour, int secondOfMinute, int millisOfSecond);

    /**
     * Creates a {@link RelativeInstant} using the datetime field values 
     * and using a chronology.   
     * @param year
     *          the year
     * @param monthOfYear
     *          the month of the year
     * @param dayOfMonth
     *          the day of the month
     * @param hourOfDay
     *          the hour of the day
     * @param minuteOfHour
     *          the minute of the hour
     * @param secondOfMinute
     *          the second of the minute
     * @param millisOfSecond
     *          the millisecond of the second  
     * @param chronology
     *          the chronology.
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(int year, int monthOfYear, int dayOfMonth, int hourOfDay,
        int minuteOfHour, int secondOfMinute, int millisOfSecond, Chronology chronology);

    /**
     * Creates a {@link RelativeInstant} using the datetime field values 
     * and using a chronology code.
     * @param year
     *          the year
     * @param monthOfYear
     *          the month of the year
     * @param dayOfMonth
     *          the day of the month
     * @param hourOfDay
     *          the hour of the day
     * @param minuteOfHour
     *          the minute of the hour
     * @param secondOfMinute
     *          the second of the minute
     * @param millisOfSecond
     *          the millisecond of the second  
     * @param chronology
     *          the chronology code.
     * @return
     *          a relative instant
     */
    public RelativeInstant createRelativeInstant(int year, int monthOfYear, int dayOfMonth, int hourOfDay,
        int minuteOfHour, int secondOfMinute, int millisOfSecond, int chronology);

    /**
     * Creates an {@link AbsoluteInstant} without any value.
     * It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @return
     *          an absolute instant
     */
    public AbsoluteInstant createAbsoluteInstant();   
    
    /**
     * Creates an {@link AbsoluteInstant} without any value and
     * using a chronology.
     * @param chronology
     *          the chronology.
     * @return
     *          an absolute instant
     */
    public AbsoluteInstant createAbsoluteInstant(Chronology chronology);  

    /**
     * Creates an {@link AbsoluteInstant} with a type and a value.
     * It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param type
     *          the single type to create the instant. It has to be
     *          one of the values specified in {@link AbsoluteInstantType}.
     * @param value
     *          the value of the field.
     * @return
     *          an absolute instant.
     * @throws AbsoluteInstantTypeNotRegisteredException
     *          if there is not an {@link AbsoluteInstantType} with
     *          this code.
     */
    public AbsoluteInstant createAbsoluteInstant(int type, int value) throws AbsoluteInstantTypeNotRegisteredException;

    /**
     * Creates an {@link AbsoluteInstant} with a type and a value and
     * using a chronology.
     * @param type
     *          the single type to create the instant. It has to be
     *          one of the values specified in {@link AbsoluteInstantType}.
     * @param value
     *          the value of the field.
     * @param chronology
     *          the chronology.
     * @return
     *          an absolute instant.
     * @throws AbsoluteInstantTypeNotRegisteredException
     *          if there is not an {@link AbsoluteInstantType} with
     *          this code.
     */
    public AbsoluteInstant createAbsoluteInstant(int type, int value, Chronology chronology) throws AbsoluteInstantTypeNotRegisteredException;
    
    /**
     * Creates an {@link AbsoluteInstant} with a set of types and an array of
     * values. The length of both arrays has to be the same.
     * It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param types
     *          the types to create the instant. All of them have to be
     *          one of the values specified in {@link AbsoluteInstantType}.
     * @param values
     *          the values of every field.
     * @return
     *          an absolute instant.
     * @throws AbsoluteInstantTypeNotRegisteredException
     *          if there is not an {@link AbsoluteInstantType} with
     *          the codes.
     */
    public AbsoluteInstant createAbsoluteInstant(int[] types, int[] values) throws AbsoluteInstantTypeNotRegisteredException;
   
    /**
     * Creates an {@link AbsoluteInstant} with a set of types and an array of
     * values. It uses a chronology. and the length of both arrays has to be the same.
     * @param types
     *          the types to create the instant. All of them have to be
     *          one of the values specified in {@link AbsoluteInstantType}.
     * @param values
     *          the values of every field.
     * @param chronology
     *          the chronology.
     * @return
     *          an absolute instant.
     * @throws AbsoluteInstantTypeNotRegisteredException
     *          if there is not an {@link AbsoluteInstantType} with
     *          the codes.
     */
    public AbsoluteInstant createAbsoluteInstant(int[] typess, int[] values, Chronology chronology) throws AbsoluteInstantTypeNotRegisteredException;

    /**
     * Creates a {@link RelativeInterval} from a start and an end 
     * instants. It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param startInstant
     *           start of this interval, as milliseconds from 1970-01-01T00:00:00Z.
     * @param endInstant
     *           end of this interval, as milliseconds from 1970-01-01T00:00:00Z.
     * @return
     *          a relative interval
     * @throws IllegalArgumentException if the end is before the start
     */
    public RelativeInterval createRelativeInterval(long startInstant, long endInstant);
    
    /**
     * Creates a {@link RelativeInterval} from a start and an end 
     * instants, and using a chonology.
     * @param startInstant
     *           start of this interval, as milliseconds from 1970-01-01T00:00:00Z.
     * @param endInstant
     *           end of this interval, as milliseconds from 1970-01-01T00:00:00Z.
     * @param chronology
     *          the chronology.
     * @return
     *          a relative interval
     * @throws IllegalArgumentException if the end is before the start
     */
    public RelativeInterval createRelativeInterval(long startInstant, long endInstant, Chronology chronology); 

    /**
     * Creates a {@link RelativeInterval} from a start and an end 
     * instants. It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param startInstant
     *           start of this interval, null means now
     * @param endInstant
     *           end of this interval, null means now
     * @return
     *          a relative interval
     * @throws IllegalArgumentException if the end is before the start
     */
    public RelativeInterval createRelativeInterval(RelativeInstant startDateTime, RelativeInstant endDateTime);  

    /**
     * Creates an {@link AbsoluteInterval} from a start and an end 
     * instants. It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param startInstant
     *           start of this interval, null means now
     * @param endInstant
     *           end of this interval, null means now
     * @return
     *          an absolute interval
     * @throws IllegalArgumentException if the end is before the start
     * @throws AbsoluteIntervalTypeNotRegisteredException
     */
    public AbsoluteInterval createAbsoluteInterval(AbsoluteInstant startInstant, AbsoluteInstant endInstant) throws AbsoluteIntervalTypeNotRegisteredException;
    
    /**
     * Creates an {@link AbsoluteInterval} from a start and an end 
     * instants and a chronology.
     * @param startInstant
     *           start of this interval
     * @param endInstant
     *           end of this interval
     * @param chronology
     *          the chronology.
     * @return
     *          an absolute interval
     * @throws IllegalArgumentException if the end is before the start
     * @throws AbsoluteIntervalTypeNotRegisteredException  if there is not
     *          the necessary {@link AbsoluteIntervalType}.
     */
    public AbsoluteInterval createAbsoluteInterval(AbsoluteInstant startInstant, AbsoluteInstant endInstant, Chronology chronology) throws AbsoluteIntervalTypeNotRegisteredException;

    /**
     * Creates an {@link AbsoluteInterval} from a start instant and an increment
     * of the time fields. It uses the chronology defined by the
     * {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param startAbsoluteInstant
     *           start of this interval
     * @param years
     *          the years to increment the instant.
     * @param months
     *          the months to increment the instant.       
     * @param weeks
     *          the weeks to increment the instant.
     * @param days
     *          the days to increment the instant.
     * @param hours
     *          the hours to increment the instant.
     * @param minutes
     *          the minutes to increment the instant.
     * @param seconds
     *          the seconds to increment the instant.
     * @param millis
     *          the milliseconds to increment the instant.
     * @return
     *          an absolute instant
     * @throws IllegalArgumentException if the end is before the start
     * @throws AbsoluteIntervalTypeNotRegisteredException  if there is not
     *          the necessary {@link AbsoluteIntervalType}.
     */
    public AbsoluteInterval createAbsoluteInterval(AbsoluteInstant startAbsoluteInstant, int years, int months, int weeks, int days,
        int hours, int minutes, int seconds, int millis) throws AbsoluteIntervalTypeNotRegisteredException;

    /**
     * Creates an {@link AbsoluteInterval} from a start instant and an increment
     * of the time fields and a chronology. The seconds instant is defined by
     * all the individual fields. 
     * @param startAbsoluteInstant
     *           start of this interval
     * @param years
     *          the years to increment the instant.
     * @param months
     *          the months to increment the instant.       
     * @param weeks
     *          the weeks to increment the instant.
     * @param days
     *          the days to increment the instant.
     * @param hours
     *          the hours to increment the instant.
     * @param minutes
     *          the minutes to increment the instant.
     * @param seconds
     *          the seconds to increment the instant.
     * @param millis
     *          the milliseconds to increment the instant.
     * @param chronology
     *          the chronology
     * @return
     *          an absolute instant
     * @throws IllegalArgumentException if the end is before the start
     * @throws AbsoluteIntervalTypeNotRegisteredException  if there is not
     *          the necessary {@link AbsoluteIntervalType}.
     */
    public AbsoluteInterval createAbsoluteInterval(AbsoluteInstant startAbsoluteInstant, int years, int months, int weeks, int days,
        int hours, int minutes, int seconds, int millis, Chronology chronology) throws AbsoluteIntervalTypeNotRegisteredException;
    
    /**
     * Creates an {@link AbsoluteInterval} from individual
     * fields. The start interval is the time 0.
     * It uses the chronology defined by the
     *  {@link TimeSupportManager#setDefaultChronology(int)} method.
     * @param years
     *          the years of the end instant.
     * @param months
     *          the months of the end instant.         
     * @param weeks
     *          the weeks of the end instant.
     * @param days
     *          the days of the end instant.
     * @param hours
     *          the hours of the end instant.
     * @param minutes
     *          the minutes of the end instant.
     * @param seconds
     *          the seconds of the end instant.
     * @param millis
     *          the milliseconds of the end instant.
     * @return
     *          an absolute instant
     * @throws AbsoluteIntervalTypeNotRegisteredException  if there is not
     *          the necessary {@link AbsoluteIntervalType}.
     */
    public AbsoluteInterval createAbsoluteInterval(int years, int months, int weeks, int days,
        int hours, int minutes, int seconds, int millis) throws AbsoluteIntervalTypeNotRegisteredException;
     
    /**
     * Creates an {@link AbsoluteInterval} from individual
     * fields and a chronology. The start interval is the time 0.   
     * @param years
     *          the years of the end instant.
     * @param months
     *          the months of the end instant.         
     * @param weeks
     *          the weeks of the end instant.
     * @param days
     *          the days of the end instant.
     * @param hours
     *          the hours of the end instant.
     * @param minutes
     *          the minutes of the end instant.
     * @param seconds
     *          the seconds of the end instant.
     * @param millis
     *          the milliseconds of the end instant.
     * @param chronology
     *          the chronology
     * @return
     *          an absolute instant
     * @throws AbsoluteIntervalTypeNotRegisteredException  if there is not
     *          the necessary {@link AbsoluteIntervalType}.
     */
    public AbsoluteInterval createAbsoluteInterval(int years, int months, int weeks, int days,
        int hours, int minutes, int seconds, int millis, Chronology chronology) throws AbsoluteIntervalTypeNotRegisteredException;
    
    /**
     * Add a time pattern that is used to parse a relative instant
     * @param relativeInstantPattern
     *          the pattern tor parse the instant
     */
    public void addRelativeInstantPattern(String relativeInstantPattern);
    
    /**
     * Creates a relative instant from a string. It tries to parse the
     * string using the patterns added with the {@link TimeSupportManager#addRelativeInstantPattern(String)}
     * method.
     * @param relativeInstantString
     *          the relative instant like a string
     * @return
     *          the relative instant or <code>null</code>.
     */
    public RelativeInstant parseRelativeInstant(String relativeInstantString);
    
    /**
     * Creates a time animation object.
     * @return
     */
    public TimeAnimation createTimeAnimation();
}
