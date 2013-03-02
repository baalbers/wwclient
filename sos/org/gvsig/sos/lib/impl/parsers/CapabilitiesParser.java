package org.gvsig.sos.lib.impl.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ExceptionReport;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.kxml2.io.KXmlParser;
//import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * Class for parsing Capabilities documents filling a Element_Capabilities instance with the information 
 * contained in the Capabilities Xml document.
 * @author lrodriguez
 */

public class CapabilitiesParser{
	
	public static String encoding = "UTF-8";

	/**
	 * 
	 * Parses the Capabilities xml document specified by the file f.
	 * @param f the file object
	 * @return An instance of the Element_Capabilities class containing the information of the document.
	 * @throws SOSInternalParserException if the document specified does not complies with the SOS specification 
	 * for capabilities documents.
	 * @throws InternalSWEException 
	 * @throws SOSInternalException 
	 */

	public static Element_Capabilities parse(File f) throws SOSInternalParserException, SOSInternalException {
		/*Element_Capabilities serviceDescriptor;
		XmlPullParser parser = new KXmlParser();
		boolean cleanNamespaceList = false;
		
		try
		{
			//Assign file to parser
			//FileReader r = new FileReader(f);
			parser.setInput(new FileInputStream(f), encoding);
			// Get first tag
			parser.nextTag();
			
			String tagName = NameResolver.getParserNextTag(parser);
			cleanNamespaceList = true;
			
			//tagName = XMLInstanceTag.RectifiedWPSTags(tagName);
			
			if (tagName.equals(Constants.SOS_CAPABILITIES)){
				// Read service descriptor form XML file	
				serviceDescriptor = new Element_Capabilities(Constants.SOS_CAPABILITIES);
				serviceDescriptor.fromXML(parser);
			}else {
				if (tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)|| tagName.equals(Constants.OWS_EXCEPTIONREPORT)) {
					Element_ExceptionReport exceptionReport = new Element_ExceptionReport(tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)?
																	Constants.OWS_EXCEPTIONREPORT_11:Constants.OWS_EXCEPTIONREPORT);
					exceptionReport.fromXML(parser);
					throw InternalSWEException.fromExceptionReport(exceptionReport);
				}
				else 
				  throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing Capabilities");
			} 
			//print(serviceDescriptor);
		}
		catch(XmlPullParserException parser_ex){
			throw new SOSInternalParserException(parser_ex);
		}
		catch (IOException ioe) {           
			throw new SOSInternalParserException(ioe);
		} catch (IllegalConvertionException e) {
			throw new SOSInternalParserException(e);
		} finally {
			if (cleanNamespaceList)
				NameResolver.cleanLastNamespaceList();
		}
		return serviceDescriptor;*/
		try {
			Element_Capabilities caps = parse(new FileInputStream(f));
			return caps;
		} catch (FileNotFoundException e) {
			throw new SOSInternalException(e);
		}
		
	}
	
	
	/**
	 * Parses the Capabilities xml document specified by the stream object.
	 * @param is the stream containing the capabilities document.
	 * @return An instance of the Element_Capabilities class containing the information of the document.
	 * @throws SOSInternalParserException if the document specified does not complies with the SOS specification 
	 * for capabilities documents.
	 * @throws InternalSWEException 
	 */
	
	public static Element_Capabilities parse(InputStream is) throws SOSInternalParserException, InternalSWEException{
		Element_Capabilities serviceDescriptor;
		XmlPullParser parser = new KXmlParser();
		boolean cleanNamespaceList = false;
		
		try
		{
			//Assign file to parser
			//FileReader r = new FileReader(f);
			parser.setInput(is, encoding);
			// Get first tag
			parser.nextTag();
			
			String tagName = NameResolver.getParserNextTag(parser);
			cleanNamespaceList = true;
			
			//tagName = XMLInstanceTag.RectifiedWPSTags(tagName);
			
			if (tagName.equals(Constants.SOS_CAPABILITIES)){
				// Read service descriptor form XML file	
				serviceDescriptor = new Element_Capabilities(Constants.SOS_CAPABILITIES);
				serviceDescriptor.fromXML(parser);
			}  
			else 
			if (tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)|| tagName.equals(Constants.OWS_EXCEPTIONREPORT)) {
					Element_ExceptionReport exceptionReport = new Element_ExceptionReport(tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)?
																	Constants.OWS_EXCEPTIONREPORT_11:Constants.OWS_EXCEPTIONREPORT);
					exceptionReport.fromXML(parser);
					throw InternalSWEException.fromExceptionReport(exceptionReport);
				}
				else 
				  throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing Capabilities");
		}
		catch(XmlPullParserException parser_ex){
			//parser_ex.printStackTrace();
			throw new SOSInternalParserException(parser_ex);
		}
		catch (IOException ioe) {           
			//ioe.printStackTrace();
			throw new SOSInternalParserException(ioe);
		} catch (IllegalConvertionException ice) {
			ice.printStackTrace();
			throw new SOSInternalParserException(ice);
		} finally {
			if (cleanNamespaceList)
				NameResolver.cleanLastNamespaceList();
		}
		return serviceDescriptor;
	}
}
