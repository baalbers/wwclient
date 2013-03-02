package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utilities {

	public static double convertToDouble(String auxX) {
		return Double.parseDouble(auxX);
	}

	public static List<Double> convertToDoubleList(String auxStringValue) {
		List<Double> result = new ArrayList<Double>();
		
		String[] list = auxStringValue.split(" ");
		
		for(String value: list){
			result.add(Double.parseDouble(value));
		}

		return result;
	}


	public static Calendar convertToJava_util_Calendar(
			String value) {
		// TODO Check this nothing has been done with this function
		return null ;
	}

	public static boolean convertToBoolean(String auxValue) {
		return auxValue.toLowerCase().equals("true");
	}

	public static XMLGregorianCalendar convertToXMLGregorianCalendar(
			String auxDuration) {
		
		DatatypeFactory factory;
		try {
			factory = DatatypeFactory.newInstance();
			XMLGregorianCalendar time = factory.newXMLGregorianCalendar(auxDuration);
			return time;
		} catch (DatatypeConfigurationException e) {
			//e.printStackTrace();
			return null;
		}	
	}
	
	public static String getResolvedAttrName(String attrName){
		String result = attrName;
		
		if (attrName.startsWith("A:")){
			String parts[] = attrName.split(":") ;
			result = parts[parts.length-1];		
		}
		
		return result;
		
	}

	public static Integer convertToInteger(String auxStringValue) {
		return Integer.parseInt(auxStringValue);
	}
	
	public static Integer convertToInt(String auxStringValue) {
		return Integer.parseInt(auxStringValue);
	}

	public static List<String> convertToStringList(String auxStringValue) {
		List<String> result = new ArrayList<String>();
		String parts[] = auxStringValue.split(" ");
		
		for(String part: parts){
			result.add(part);
		}
		
		return null;
	}

}
