package org.gvsig.sos.lib.impl.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ExceptionReport;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;



/**
 * Class for parsing O&M documents, filling a ObservationCollectionType instance with the information 
 * contained in the O&M Xml document specified.
 * @author lrodriguez
 *
 */

public class GetObservationParser {
	private static String encoding = "UTF-8";

	/**
	 * Parses a O&M document filling a ObservationCollectionType instance with the information contained 
	 * in the O&M documents specified.
	 * @param f the File object containing the O&M document 
	 * @return an instance of ObservationCollectionType containing the information of the O&M document. 
	 * @throws SOSInternalParserException if the document does not complies with the O&M specification 
	 * @throws InternalSWEException 
	 * @throws IllegalConvertionException
	 */
	public static ObservationCollectionType parse(File f) throws SOSInternalParserException, InternalSWEException{
		/*ObservationCollectionType serviceDescriptor;
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
			
			if (tagName.equals(Constants.OM_OBSERVATIONCOLLECTION)){
				// Read service descriptor form XML file	
				serviceDescriptor = new ObservationCollectionType(Constants.OM_OBSERVATIONCOLLECTION);
				serviceDescriptor.fromXML(parser);
			} else {
				throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing O&M file");
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
			throw new SOSInternalParserException(ice);
		} finally {
			if (cleanNamespaceList)
				NameResolver.cleanLastNamespaceList();
		}
		return serviceDescriptor;*/
		
		ObservationCollectionType result;
		try {
			result = parse(new FileInputStream(f));
			return result;
		} catch (FileNotFoundException e) {
			throw new SOSInternalParserException(e);
		} 
	}

	/**
	 * Parses a O&M document filling a ObservationCollectionType instance with the information contained 
	 * in the O&M documents specified.
	 * @param is the stream object containing the O&M document 
	 * @return an instance of ObservationCollectionType containing the information of the O&M document. 
	 * @throws SOSInternalParserException if the document does not complies with the O&M specification 
	 * @throws InternalSWEException 
	 */
	public static ObservationCollectionType parse(InputStream is) throws SOSInternalParserException, InternalSWEException{
		ObservationCollectionType serviceDescriptor = null;
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
			
			if (tagName.equals(Constants.OM_OBSERVATIONCOLLECTION)){
				// Read service descriptor form XML file	
				serviceDescriptor = new ObservationCollectionType(Constants.OM_OBSERVATIONCOLLECTION);
				serviceDescriptor.fromXML(parser);
			} else {
				if (tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)|| tagName.equals(Constants.OWS_EXCEPTIONREPORT)) {
					Element_ExceptionReport exceptionReport = new Element_ExceptionReport(tagName.equals(Constants.OWS_EXCEPTIONREPORT_11)?
																	Constants.OWS_EXCEPTIONREPORT_11:Constants.OWS_EXCEPTIONREPORT);
					exceptionReport.fromXML(parser);
					throw InternalSWEException.fromExceptionReport(exceptionReport);
				}
				else 
				  throw new SOSInternalParserException(SOSInternalParserException.INVALID_TAG_FOUND, tagName, "Invalid tag found while parsing O&M file");
			}
			
			//NameResolver.cleanLastNamespaceList();
		}
		catch(XmlPullParserException parser_ex){
			throw new SOSInternalParserException(parser_ex);
		}
		catch (IOException ioe) {           
			throw  new SOSInternalParserException(ioe);
		} catch (IllegalConvertionException ice) {
			throw new SOSInternalParserException(ice);
		} finally {
			if (cleanNamespaceList)
				NameResolver.cleanLastNamespaceList();
		}
		return serviceDescriptor;
	}
}
