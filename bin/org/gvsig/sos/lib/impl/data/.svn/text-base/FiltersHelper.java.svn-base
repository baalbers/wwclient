package org.gvsig.sos.lib.impl.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.gvsig.sos.lib.impl.communication.request.getobservation.ComparisonFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ComparisonFilter.COMPARISON_FILTER_TYPE;
import org.gvsig.sos.lib.impl.communication.request.getobservation.DefaultComparisonFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.DefaultSpatialFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.DefaultTemporalFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.SpatialFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.SpatialFilter.SPATIAL_FILTER_TYPE;
import org.gvsig.sos.lib.impl.communication.request.getobservation.TemporalFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.TemporalFilter.TEMPORAL_FILTER_TYPE;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonBetweenOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonBinaryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonLikeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonNullOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonBetweenOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonBinaryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonLikeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonNullOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.DefaultSpatialDistanceOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.DefaultSpatialEnvelopeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.SpatialEnvelopeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.DefaultTemporalInstantOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.DefaultTemporalPeriodOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.DefaultTemporalTypePosition;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.TemporalInstantOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.TemporalPeriodOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.TemporalTypePosition;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Utility class for easing the creation of different types of filters supported. 
 * @author lrodriguez
 *
 */
public final class FiltersHelper {
	
	private static boolean debug = false;
	private static Logger logger = LoggerFactory.getLogger(FiltersHelper.class);
	public static DateConverter dateConverter = null;
	
	public static interface DateConverter {
		/**
		 * Rerturns a string representation from the date.
		 * @param date the date.
		 * @return a string with the date
		 */
		String getStringFromDate(Date date);
		
		String getName();
		
	}
	
	
   public static DateConverter defaultConverter = new DefaultDateConverter();
	
	public static class DefaultDateConverter implements DateConverter{
		
		public String getStringFromDate(Date date){
			String result = stringTimeFromDate1(date);
			String resultSemi = result.substring(0, result.length() - 2) + ":"
					+ result.substring(result.length() - 2);
			return resultSemi;
		}
		
		public String stringTimeFromDate1(Date dateTime){
		    	SimpleDateFormat sdf = new SimpleDateFormat(ISODatePattern);
		    	String strOutputDateTime = sdf.format(dateTime);
		    	return strOutputDateTime;
		}

		public String getName() {
			return "Date with Semicolon converter";
		}
		
		
	}
	
	
	/**
	 * Creates a temporal filter using a period of time.
	 * @param propertyName the time property name to which the filter must be applied. 
	 * @param filterType the type of the filter (i.e. TM_OVERLAPS, TM_OVERLAPPEDBY).
	 * @param beginTime the begin time of the period
	 * @param endTime the end time of the period
	 * @return a filter object with the specified features.
	 */
    public static TemporalFilter createTemporalPeriodFilter(String propertyName, TEMPORAL_FILTER_TYPE filterType, String beginTime, String endTime){
		// ///////
		// Temporal Filter

		if (debug) {
			doLog("Creating a Period filter for:");
			doLog("Property Name: " + propertyName);
			doLog("BeginDate: " + beginTime);
			doLog("EndDate: " + endTime);
			doLog("Operator: " + filterType.name());
		}
    	
		TemporalFilter filter = new DefaultTemporalFilter();
		filter.setPropertyName(propertyName);
		TemporalPeriodOperator operator = new DefaultTemporalPeriodOperator();
		//operator.setPropertyName(propertyName); // i had to erase it.
		TemporalTypePosition type = new DefaultTemporalTypePosition();
		type.setBegin(beginTime);  //"2011-08-13T12:46:00.000+02:00"
		type.setEnd(endTime);  //"2011-08-16T12:46:00.000+02:00"
		operator.setTypeTime(type);
		filter.setType(TEMPORAL_FILTER_TYPE.TM_DURING);
		filter.setTemporalFilterOperator(operator);
		
		return filter;

    }
    
    /**
	 * Creates a temporal filter using a period of time.
	 * @param propertyName the time property name to which the filter must be applied. 
	 * @param filterType the type of the filter (i.e. TM_OVERLAPS, TM_OVERLAPPEDBY).
	 * @param beginTime the begin time of the period
	 * @param endTime the end time of the period
	 * @return a filter object with the specified features.
     */
    public static TemporalFilter createTemporalPeriodFilter(String propertyName, TEMPORAL_FILTER_TYPE filterType, Date beginTime, Date endTime){
    	return createTemporalPeriodFilter(propertyName, filterType,  stringTimeFromDate(beginTime), stringTimeFromDate(endTime));
    }

//TODO: Check this to eliminate the dependency     
//    /** 
//	 * Creates a temporal filter using a period of time.
//	 * @param propertyName the time property name to which the filter must be applied. 
//	 * @param filterType the type of the filter (i.e. TM_OVERLAPS, TM_OVERLAPPEDBY).
//	 * @param beginTime the begin time of the period
//	 * @param endTime the end time of the period
//	 * @return a filter object with the specified features.
//     */
//    
//    public static TemporalFilter createTemporalPeriodFilter(String propertyName, TEMPORAL_FILTER_TYPE filterType, DateTime beginTime, DateTime endTime){
//    	return createTemporalPeriodFilter(propertyName, filterType,  stringTimeFromDate(beginTime), stringTimeFromDate(endTime));
//    }

    /**
	 * Creates a temporal filter using a time instant.
	 * @param propertyName the time property name to which the filter must be applied. 
	 * @param filterType the type of the filter (i.e. TM_AFTER, TM_BEFORE).
     * @param instant the instant of time. 
     * @return the temporal filter with the specified features.
     */
    public static TemporalFilter createTemporalInstantFilter(String propertyName, TEMPORAL_FILTER_TYPE filterType, String instant){
      
    	if (debug){
	    	doLog("Creating a Instant filter for:");
	    	doLog("Property Name: " + propertyName);
	    	doLog("Instant: " + instant);
	    	doLog("Operator: " + filterType.name());
    	}
    	// ///////
		// Temporal Filter
		
    	TemporalFilter filter = new DefaultTemporalFilter();
		filter.setPropertyName(propertyName); //"om:samplingTime"
		TemporalInstantOperator operator = new DefaultTemporalInstantOperator();
		operator.setTimeInstant(instant);
		//operator.setPropertyName(propertyName);
		filter.setType(filterType);
		filter.setTemporalFilterOperator(operator);
		
        return filter;
    }

    
    /**
	 * Creates a temporal filter using a time instant.
	 * @param propertyName the time property name to which the filter must be applied. 
	 * @param filterType the type of the filter (i.e. TM_AFTER, TM_BEFORE).
     * @param instant the instant of time. 
     * @return the temporal filter with the specified features.
     */

    public static TemporalFilter createTemporalInstantFilter(String propertyName, TEMPORAL_FILTER_TYPE filterType, Date instant){ 
       return createTemporalInstantFilter(propertyName, filterType, stringTimeFromDate(instant));
    }

    /*
	 * @param filterType the type of the filter (i.e. TM_AFTER, TM_BEFORE).
     * @param instant the instant of time. 
     * @return the temporal filter with the specified features.
     */

    /**
	 * Creates a comparison (like) filter.
     * @param value  the value to be used by the like operator
     * @param wildCard the wildcard used in the value specified.
     * @param escapeChar the scape char used in the value specified.
     * @param singleChar the single char character used in value specified.
	 * @param propertyName the property name to which the filter must be applied. 
     * @return a comparison filter with the features specified.
     * @see COMPARISON_FILTER_TYPE.LIKE
     */
    public static ComparisonFilter createComparisonLikeFilter(String value, char wildCard, 
    		char escapeChar, char singleChar, String propertyName) {
    	// Comparison Filter
		ComparisonFilter comparison = new DefaultComparisonFilter();
		comparison.setType(COMPARISON_FILTER_TYPE.LIKE);
		ComparisonOperator operator = getOperatorByType(COMPARISON_FILTER_TYPE.LIKE);
		ComparisonLikeOperator likeOperator = (ComparisonLikeOperator) operator;
		likeOperator.setValue(value);
		likeOperator.setWildCard(wildCard);
		likeOperator.setEscapeChar(escapeChar);
		likeOperator.setSingleChar(singleChar);
		likeOperator.setPropertyName(propertyName);
		comparison.setPropertyName(propertyName);
		comparison.setComparisonOperator(likeOperator);
    	return comparison;
    }

    /**
     * Creates a comparison filter for comparing with the null value.
     * @param propertyName the property for which the filter should be applied.
     * @return a filter object able to filter by the null values of the specified property.  
     * @see COMPARISON_FILTER_TYPE.NULL
     */
    public static  ComparisonFilter createNullComparisonfilter(String propertyName){
    	ComparisonFilter filter  = new DefaultComparisonFilter();
    	filter.setType(COMPARISON_FILTER_TYPE.NULL);
    	filter.setPropertyName(propertyName);
    	ComparisonNullOperator operator = new DefaultComparisonNullOperator();
    	operator.setPropertyName(propertyName);
    	filter.setComparisonOperator(operator);
    	return filter;
    }

    /**
     * Creates a comparison filter.
     * @param value the value to be use to compare with the property specified by propertyName parameter.
     * @param type the type of the filter (i.e. GREATERTHAN,GREATERTHANOREQUALTO,LESSTHAN,LESSTHANOREQUALTO,NOTEQUALTO)
     * @param propertyName the name property to which the filter will be applied.
     * @return the filter object.
     * @see COMPARISON_FILTER_TYPE
     */
    public static ComparisonFilter createComparisonFilter(String value, COMPARISON_FILTER_TYPE type, String propertyName) {
    	if (type == COMPARISON_FILTER_TYPE.LIKE)
    		throw new IllegalArgumentException("This type is not supported by this function. Use the function createComparisonLikeFilter instead.");
    	
    	if (debug){
    		doLog("Filters Helper: ____________________________________");
	    	doLog("Creating a Comparison Filter for:");
	    	doLog("Property Name: " + propertyName);
	    	doLog("Value: " + value);
	    	doLog("Operator: " + type.name());
	    	doLog("____________________________________________________");
    	}
    	
    	// Comparison Filter
		ComparisonFilter comparison = new DefaultComparisonFilter();
		comparison.setType(type);
		ComparisonOperator operator = getOperatorByType(type);
		ComparisonBinaryOperator binaryOperator = (ComparisonBinaryOperator) operator;
		binaryOperator.setValue(value); 		
		operator.setPropertyName(propertyName);
		comparison.setPropertyName(propertyName);
		comparison.setComparisonOperator(operator);
    	return comparison;
    }
    
    /**
     * Creates a filter used to do a range check (i.e. operator BETWEEN).
     * @param lowerValue the lower value of the range
     * @param upperValue the upper value of the range
     * @param propertyName the name of the property for which the range 
     * check is performed.
     * @return a filter object with the specified features.
     * @see COMPARISON_FILTER_TYPE.BETWEEN
     */
    public static ComparisonFilter createComparisonBetweenFilter(String lowerValue, String upperValue, String propertyName) {
    	

    	if (debug){
    		doLog("Filters Helper: ____________________________________");
	    	doLog("Creating a Comparison (Between) Filter for:");
	    	doLog("Property Name: " + propertyName);
	    	doLog("Lower Value: " + lowerValue);
	    	doLog("Upper Value: " + upperValue);
	    	doLog("Operator: " + COMPARISON_FILTER_TYPE.BETWEEN.name());
	    	doLog("____________________________________________________");
    	}
    	// Comparison Filter
    	ComparisonFilter comparison = new DefaultComparisonFilter();
		comparison.setType(COMPARISON_FILTER_TYPE.BETWEEN);
		ComparisonOperator operator = getOperatorByType(COMPARISON_FILTER_TYPE.BETWEEN);
		ComparisonBetweenOperator binaryOperator = (ComparisonBetweenOperator) operator;
		binaryOperator.setLowerBoundary(lowerValue); //"2011-08-16T12:46:00.000+02:00"
		binaryOperator.setUpperBoundary(upperValue); //"2011-08-16T12:46:00.000+02:00"
		operator.setPropertyName(propertyName);
		comparison.setPropertyName(propertyName);
		comparison.setComparisonOperator(operator);
    	return comparison;
    }
    
	private static ComparisonOperator getOperatorByType(
			COMPARISON_FILTER_TYPE type) {
		ComparisonOperator result = null;
		switch (type) {
		case EQUALTO: 
      	case GREATERTHAN:
		case GREATERTHANOREQUALTO: 
		case LESSTHAN: 
		case LESSTHANOREQUALTO: 
		case NOTEQUALTO: {
	         result = new DefaultComparisonBinaryOperator();
	         return result;
		
		}
		case BETWEEN: {
            result = new DefaultComparisonBetweenOperator();
            return result;
		}
		case LIKE: {
		   result = new DefaultComparisonLikeOperator();
           return result;
		}
		case NULL: {
           result = new DefaultComparisonNullOperator();
		}
		}
		return result;
    }
   
	/**
	 * Creates a spatial filter for filtering by an envelop (i.e. BBOX)
	 * @param propertyName the name of the (spatial) property to check.
	 * @param lowerCorner the lower corner of the BBOX
	 * @param upperCorner the upper corner of the BBOX
	 * @param srsName the reference system code of the specified coordinates lowerCorner and upperCorner
	 * @return the filter with the specified features.
	 */
    public static SpatialFilter createEnvelopeSpatialFilter (String propertyName, String lowerCorner, String upperCorner, String srsName) {
    	
		if (debug) {
			doLog("Filters Helper: ____________________________________");
			doLog("Creating a Spatial(Envelope) Filter for:");
			doLog("Property Name: " + propertyName);
			doLog("Lower Corner: " + lowerCorner);
			doLog("Upper Corner: " + upperCorner);
			doLog("SrsName : " + srsName);
			doLog("Operator: " + SPATIAL_FILTER_TYPE.BBOX.name());
			doLog("___________________________________________________");
		}
    	
    	SpatialFilter spatial = new DefaultSpatialFilter();
		spatial.setType(SPATIAL_FILTER_TYPE.BBOX);
		spatial.setPropertyName(propertyName); //"urn:ogc:data:location"
		SpatialEnvelopeOperator envelope = new DefaultSpatialEnvelopeOperator();
		envelope.setLowerCorner(lowerCorner); //"46.611644 7.6103"
		envelope.setUpperCorner(upperCorner); //"51.9412 13.883498"
		envelope.setSrsName(srsName); //"urn:ogc:def:crs:EPSG:4326"
		spatial.setSpatialFilterOperator(envelope);
		return spatial;
    }
    
	/**
	 * Creates a spatial filter for filtering by an envelop (i.e. BBOX)
	 * @param propertyName the name of the (spatial) property to check.
	 * @param lowerCorner coordinates of the lower corner of the BBOX
	 * @param upperCorner coordinates of the upper corner of the BBOX
	 * @param srsName the reference system code of the specified coordinates lowerCorner and upperCorner
	 * @return the filter with the specified features.
	 */
    public static SpatialFilter createEnvelopeSpatialFilter (String propertyName, Coordinates lowerCorner, Coordinates upperCorner, String srsName) {
		if (debug) {
			doLog("Filters Helper: ____________________________________");
			doLog("Creating a Spatial(Envelope) Filter for:");
			doLog("Property Name: " + propertyName);
			doLog("Lower Corner: " + lowerCorner);
			doLog("Upper Corner: " + upperCorner);
			doLog("SrsName : " + srsName);
			doLog("Operator: " + SPATIAL_FILTER_TYPE.BBOX.name());
			doLog("_____________________________________________________");
		}
    	String lowCorner = lowerCorner.getY() + " " + lowerCorner.getX();
    	String uppCorner = upperCorner.getY() + " " + upperCorner.getX();
		return createEnvelopeSpatialFilter(propertyName, lowCorner, uppCorner, srsName);
    }
    
    /**
     * Creates a spatial filter. 
     * @param propertyName the property name to which the filter will be applied to.
     * @param operand the operand.
     * @return the filter with the specified features.
     * @throws InvalidParameterFilterHelperException if the specified operand is not 
     * an instance of abstract geometry operator.
     * @see SPATIAL_FILTER_TYPE
     */
    public static SpatialFilter createSpatialFilter (String propertyName, AbstractGeometryOperator operand) throws InvalidParameterFilterHelperException {
    	
    	if (!(operand instanceof SpatialEnvelopeOperator)) {
    		throw new InvalidParameterFilterHelperException("Operand in used with the operator " + SPATIAL_FILTER_TYPE.BBOX + "" +
    				"should be an instance of " + SpatialEnvelopeOperator.class.getName());
    	}

		if (debug) {
			doLog("Filters Helper: ____________________________________");
			doLog("Creating a Spatial Filter for:");
			doLog("Property Name: " + propertyName);
			doLog("Operand: " + operand.toString());
			doLog("Operator: " + SPATIAL_FILTER_TYPE.BBOX.name());
			doLog("_____________________________________________________");
		}
		
    	SpatialFilter spatial = new DefaultSpatialFilter();
		spatial.setType(SPATIAL_FILTER_TYPE.BBOX);
		spatial.setPropertyName(propertyName); //"urn:ogc:data:location"
		spatial.setSpatialFilterOperator(operand);
		return spatial;
    }
    
    /**
     * Creates a spatial (distance) filter.
     * @param type the type of the filter (should be either SPATIAL_FILTER_TYPE.DWITHIN 
     * or SPATIAL_FILTER_TYPE.BEYOND)
     * @param propertyName the property to which the filter should be applied to.
     * @param distance the distance.
     * @param units the units of the distance.
     * @return the filter with the specified features.
     * @throws InvalidParameterFilterHelperException if the type is not SPATIAL_FILTER_TYPE.DWITHIN or SPATIAL_FILTER_TYPE.BEYOND
     */
    public static SpatialFilter createDistanceSpatialFilter (SPATIAL_FILTER_TYPE type, String propertyName, /*AbstractGeometryOperator operand,*/ String distance, String units) throws InvalidParameterFilterHelperException {
    	
    	if (!(type== SPATIAL_FILTER_TYPE.DWITHIN || type== SPATIAL_FILTER_TYPE.BEYOND)) {
    		throw new InvalidParameterFilterHelperException("Distance filters can only be of type:" + SPATIAL_FILTER_TYPE.DWITHIN + "or" + SPATIAL_FILTER_TYPE.BEYOND);
    	}
    	boolean disabled= false;
    	if (disabled)
    	 throw new InvalidParameterFilterHelperException("Distance filters are currently disabled");
    	
		if (debug) {
			doLog("Filters Helper: ____________________________________");
			doLog("Creating a Spatial(Distance) Filter for:");
			doLog("Property Name: " + propertyName);
			// doLog("Operand: " + operand.toString());
			doLog("Distance: " + distance);
			doLog("Units: " + units);
			doLog("Operator: " + type.name());
			doLog(" ___________________________________________________");
		}
    	
    	//TODO: Ask how to do this kind of filters with the object model provided.
    	SpatialFilter spatial = new DefaultSpatialFilter();
    	spatial.setType(type);
		spatial.setPropertyName(propertyName);
		DefaultSpatialDistanceOperator operation = new DefaultSpatialDistanceOperator();
		operation.setPropertyName(propertyName);
		operation.setUnits(units);
		//TODO: where is this functionality.
		//operation.setDistance(distance); ????
		spatial.setSpatialFilterOperator(operation);
		return spatial;
    }
    
    public static String ISODatePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";

    public static String stringTimeFromDate1(Date dateTime){
    	SimpleDateFormat sdf = new SimpleDateFormat(ISODatePattern);
    	String strOutputDateTime = sdf.format(dateTime);
    	return strOutputDateTime;
    }
    
	public static String stringTimeFromDate(Date dateTime) {
		if (dateConverter == null){
			String result = stringTimeFromDate1(dateTime);
			String resultSemi = result.substring(0, result.length() - 2) + ":"
					+ result.substring(result.length() - 2);
			return resultSemi;
		}
		else {
			return dateConverter.getStringFromDate(dateTime);
		}
	}

	
	public static void setDateConverter(DateConverter converter){
		FiltersHelper.dateConverter = converter;
	}
	
	public static void setDebug(boolean debug){
		FiltersHelper.debug = debug;
	}
	
    public static Date dateTimeFromString(String strDate) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat(ISODatePattern);
    	boolean hasSemicolons = (strDate.lastIndexOf(":") == strDate.length()-3) && (strDate.contains(".")); 
    	if (hasSemicolons){
    		//eliminate the last occurrence
    		strDate = strDate.substring(0, strDate.lastIndexOf(":")) + strDate.substring(strDate.lastIndexOf(":")+1);
    	}
    		
    	Date strOutputDateTime = sdf.parse(strDate);
    	return strOutputDateTime;
    }
	
    
    public static void doLog(String message, Throwable th){
    	logger.debug(message, th);
    }
    
    public static void doLog(String message){
    	logger.debug(message);
    }

}
