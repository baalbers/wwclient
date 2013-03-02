package org.gvsig.sos.lib.impl.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ExceptionReport;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_SensorML;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * Class for parsing SensorML documents filling a Element_SensorML instance with the information 
 * contained in the SensorML Xml document.
 * @author lrodriguez
 *
 */
public class DescribeSensorParser {
	private static String encoding = "UTF-8";

	/**
	 * Parses the SensorML xml document specified by the file f.
	 * @param f the file object
	 * @return An instance of the Element_SensorML class containing the information of the document.
	 * @throws SOSInternalParserException
	 * @throws IllegalConvertionException
	 */
	public static Element_SensorML parse(File f) throws SOSInternalParserException {
		Element_SensorML serviceDescriptor;
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
			
			if (tagName.equals(Constants.SML_SENSORML)){
				// Read service descriptor form XML file	
				serviceDescriptor = new Element_SensorML(Constants.SML_SENSORML);
				serviceDescriptor.fromXML(parser);
			} else {
				throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing SensorML file");
			}
			
			//print(serviceDescriptor);
			

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
	
	/**
	 * Parses the SensorML xml document specified by the stream is.
	 * @param is
	 * @return An instance of the Element_SensorML class containing the information of the document.
	 * @throws SOSInternalParserException
	 * @throws InternalSWEException 
	 * @throws IllegalConvertionException
	 */
	public static Element_SensorML parse(InputStream is) throws SOSInternalParserException, InternalSWEException{
		Element_SensorML serviceDescriptor;
		XmlPullParser parser = new KXmlParser();
		boolean cleanNamespaceList = false;
		
		try
		{
			//parser.setInput(new BufferedReader(new InputStreamReader(is)));	
			parser.setInput(is,encoding);	
			// Get first tag
			parser.nextTag();
			
			String tagName = NameResolver.getParserNextTag(parser);
			cleanNamespaceList = true;
			
			if (tagName.equals(Constants.SML_SENSORML)){
				// Read service descriptor form XML file	
				serviceDescriptor = new Element_SensorML(Constants.SML_SENSORML);
				serviceDescriptor.fromXML(parser);
			}
			else { 
				if (tagName.equals(Constants.OWS_EXCEPTIONREPORT_11) || tagName.equals(Constants.OWS_EXCEPTIONREPORT)) {
						Element_ExceptionReport exceptionReport = new Element_ExceptionReport(tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)?Constants.OWS_EXCEPTIONREPORT_11:
																  Constants.OWS_EXCEPTIONREPORT);
						exceptionReport.fromXML(parser);
						throw InternalSWEException.fromExceptionReport(exceptionReport);
					}
				 else {
					throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing SensorML file");
				}
			}
			
			//NameResolver.cleanLastNamespaceList();
		}
		catch(XmlPullParserException parser_ex){
			parser_ex.printStackTrace();
			throw new SOSInternalParserException(parser_ex);
			//return null;
		}
		catch (IOException ioe) {           
			ioe.printStackTrace();
			throw new SOSInternalParserException(ioe);
			//return null;
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
