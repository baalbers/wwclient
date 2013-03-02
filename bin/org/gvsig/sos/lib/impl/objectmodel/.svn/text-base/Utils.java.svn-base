package org.gvsig.sos.lib.impl.objectmodel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gvsig.timesupport.RelativeInstant;
import org.gvsig.timesupport.TimeSupportLocator;

public class Utils {

	public static String timePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	public static Date parseDateTimeString(String valueStr) {
		init();
		Date result = null;
	    if (valueStr!=null) {
	    	//sampleDate = "2010-01-01T23:33:22.112+0100";
	    	//other sample 2008-10-01T00:00:00Z
	    	//other example "now"
	    	if (valueStr.equalsIgnoreCase("")) {
	    	   result= new Date();
	    	}
	    	else {
		        String finalDate = prepareDateString(valueStr);
	    		result = parseUsingSimple(finalDate);	
	              return result;
	    	}
	    }
        throw new RuntimeException("Unable to parse the date" + "'"+ valueStr +"'");	    	
	}

	private static String prepareDateString(String valueStr){
		
		if (valueStr.equals("")) {
			return "";
		}
		
		if (valueStr.equalsIgnoreCase("now")){
			//return the now with the current date and time.
			return printDate(new Date());
		}
		
    	int dotPos = valueStr.lastIndexOf(".");
    	boolean hasDot= dotPos!=-1;
    	String finalDate = valueStr;
    	if (!hasDot && valueStr.endsWith("Z")) {
    		//case for ending with Z and no milliseconds specified
	    	valueStr = valueStr.substring(0, valueStr.length()-1)+".000+00:00";
	    	dotPos = valueStr.lastIndexOf(".");
    	}
    	else if (hasDot && valueStr.endsWith("Z")){
    		//case for ending with Z and milliseconds specified
    		valueStr = valueStr.substring(0, valueStr.length()-1) + "+00:00";
    	}
    	else {
    		//1995-05-25T15:30:00+10:00
    		if (!hasDot) {
	    	    int signPos = (signPosition("+", valueStr)!=-1)? signPosition("+", valueStr): signPosition("-", valueStr) ;
	    		valueStr = valueStr.substring(0, signPos) + ".000"+ valueStr.substring(signPos);
	    		dotPos = valueStr.lastIndexOf(".");
    		}
    	}
    	if (dotPos!=-1){
	        String dateStr= valueStr.substring(0, dotPos);
	        String zoneStr = valueStr.substring(dotPos);
	        zoneStr = zoneStr.replaceFirst(":", "");
	        finalDate = dateStr + zoneStr;
    	}
        return finalDate;
	}
	
	
	public static RelativeInstant parseDateTimeStringToInstant(String valueStr) {
		String finalDate = prepareDateString(valueStr);
		return parseRelativeInstantGVSig(finalDate, true);
	}

	public static String printDate(Date value) {
		DateFormat df = new SimpleDateFormat(timePattern);
		String result = df.format(value);
		return result;
	}

	private static int signPosition(String sign, String valueStr) {
		return valueStr.lastIndexOf(sign);
	}

	static List<String> relativeInstantPatterns = new ArrayList<String>();

	private static boolean initilized = false;

	private static void init() {
		if (!initilized) {
			// No need to use such patterns.
			
			  addRelativeInstantPattern("yyyy:MM:dd HH:mm:ss");
			  addRelativeInstantPattern("yyyy:MM:dd");
			  addRelativeInstantPattern("yyyy/MM/dd HH:mm:ss");
			  addRelativeInstantPattern("yyyy/MM/dd");
			  addRelativeInstantPattern("yyyy-MM-dd HH:mm:ss");
			  addRelativeInstantPattern("yyyy-MM-dd");

			//register with the time support library
			TimeSupportLocator.getManager().addRelativeInstantPattern(
					timePattern);
             // Add to the local
			addRelativeInstantPattern(timePattern);
		}
	}

	public static void addRelativeInstantPattern(String relativeInstantPattern) {
		relativeInstantPatterns.add(relativeInstantPattern);
	}

	public static RelativeInstant parseRelativeInstantBroken(
			String relativeInstantString) {
		//call init for registering the pattern.
		init();
		/*
		 * for (int i=0 ; i<relativeInstantPatterns.size() ; i++){ String
		 * pattern =(String)relativeInstantPatterns.get(i); try {
		 * 
		 * Date date = new
		 * SimpleDateFormat(pattern).parse(relativeInstantString); if (date !=
		 * null){ return
		 * TimeSupportLocator.getManager().createRelativeInstant(date); } }
		 * catch (ParseException e) {
		 * print("Impossible to parse the date using the " +
		 * pattern + " pattern"); } }
		 */
		return TimeSupportLocator.getManager().parseRelativeInstant(
				relativeInstantString);
	}

	/**
	 * Do not use this function (thats why it is private). It expects the time to be in the exact format:
	 * timePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
	 * @param relativeInstantString string to parse
	 * @return
	 */
	private static RelativeInstant parseRelativeInstant(
			String relativeInstantString) {
		init();
		for (int i = 0; i < relativeInstantPatterns.size(); i++) {
			String pattern = relativeInstantPatterns.get(i);
			try {

				Date date = new SimpleDateFormat(pattern)
						.parse(relativeInstantString);
				if (date != null) {
					return TimeSupportLocator.getManager()
							.createRelativeInstant(date);
				}
			} catch (ParseException e) {
//				  System.out.println("Impossible to parse the date using the "
//						+ pattern + " pattern");
				throw new RuntimeException(e);
			}
		}
		return TimeSupportLocator.getManager().parseRelativeInstant(
				relativeInstantString);
	}

	private static Date parseUsingSimple(String date) {
		try {
			return new SimpleDateFormat(timePattern).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		}
	}

	
	public static RelativeInstant parseRelativeInstantGVSig(
			String relativeInstantString, boolean fullGVSig) {
		
		init();
		if (!fullGVSig) {
			for (int i = 0; i < relativeInstantPatterns.size(); i++) {
				String pattern = relativeInstantPatterns.get(i);
				ParsePosition position = new ParsePosition(0);
				Date date = new SimpleDateFormat(pattern).parse(
						relativeInstantString, position);

				if (date != null
						&& position.getIndex() == relativeInstantString
								.length()) {
					return TimeSupportLocator.getManager()
							.createRelativeInstant(date);
				}
			}
		}
		else {
		  return TimeSupportLocator.getManager().parseRelativeInstant(relativeInstantString);
		}
		return null;
	}
	
//	public static void brokenExample() {
//		String date = "1995-05-25T15:30:00+10:00";
//		String date1 = "1995-05-25T15:30:00.000+1000";
//		date = date1;
//
//		System.out.println("SimpleDateFormat:");
//
//		Date simpleDate = parseUsingSimple(date);
//		String simpleDateString = printDate(simpleDate);
//
//		System.out.println(date + "->" + simpleDateString);
//		System.out.println();
//
//		System.out.println("Joda Time:");
//		Date d = jodaParse(date);
//		String resultDate = printDate(d);
//		System.out.println(date + "->" + resultDate);
//
//		System.out.println("Time Support API:");
//		RelativeInstant ri = parseRelativeInstantBroken(date);
//		// String resultDate = printDate(d);
//		System.out.println(date + "->" + ri.toString(timePattern));
//
//	}
	
}
