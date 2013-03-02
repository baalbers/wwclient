package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ExceptionReport;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ExceptionType;

public class InternalSWEException extends SOSInternalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7860206150186420706L;
	
//	String code;
//	String locator;
	
	public InternalSWEException(String message, String code, String locator) {
		super(code, locator, message);
	}
	
	public static InternalSWEException fromExceptionReport(Element_ExceptionReport exceptionReport) {
		ExceptionType ex = exceptionReport.getException().get(0);
		List<String> exText = ex.getExceptionText();
		String message = "";
		String sep = "";
		for (String text: exText) {
			message += text + sep;
			sep = "\n";
		}
		InternalSWEException sweException  = new InternalSWEException(message, ex.getExceptionCode(), ex.getLocator());
		return sweException;
	}
	

}
