package wwclient.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.GetObservationParams;
import org.gvsig.sos.lib.impl.communication.SOSProtocolHandler;
import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.parsers.AnyTypeRealization;
import org.gvsig.sos.lib.impl.parsers.CapabilitiesParser;
import org.gvsig.sos.lib.impl.parsers.GetObservationParser;
import org.gvsig.sos.lib.impl.parsers.SOSInternalParserException;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataValuePropertyType;



public class SOSParser {
	
	private static SOSProtocolHandler handler = new SOSProtocolHandler();
	
	public static Element_Capabilities parseGetCapabilities(String SOSURL) {
		handler.setHost(SOSURL);
		try {
			System.out.println("Get CapabilitiesStream");
			InputStream is = handler.getCapabilitiesStream();
			System.out.println("Parse Capabilities");
			Element_Capabilities capDoc = CapabilitiesParser.parse(is);
			return capDoc;
		} catch (SOSInternalException e) {
			e.printStackTrace();
		} catch (SOSInternalParserException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void test(String server) {
		System.out.println("Setting up the host");
		handler.setHost(server);
		Element_Capabilities capDoc = null;

		InputStream is;
		try {
			System.out.println("Get CapabilitiesStream");
			is = handler.getCapabilitiesStream();
			System.out.println("Parse Capabilities");
			capDoc = CapabilitiesParser.parse(is);
		} catch (SOSInternalException e) {
			e.printStackTrace();
		} catch (SOSInternalParserException e) {
			e.printStackTrace();
		}
		if (capDoc != null) {
			checkInfoInOfferings(server, capDoc);
		} else {
			System.out.println("capDoc is null!");
		}
	}
	
	private void checkInfoInOfferings(String server, Element_Capabilities capDoc){
		System.out.println("Number of Offerings: " + capDoc.getContents().getObservationOfferingList().getObservationOfferingList().size());
		
		ObservationOfferingType offering = capDoc.getContents().getObservationOfferingList().getObservationOfferingList().get(0);
		GetObservationParams params = new GetObservationParams();
		
		
//		String test = oo.getObservedPropertyList().get(0).getPhenomenon().toString();
//		System.out.println(test);
		params.addObservedProperty("urn:ubimet:def:property:AUS_BOM:T_DB");
		System.out.println("ResponseFormat: "+offering.getResponseFormatList().get(0));
		System.out.println("Offering ID: "+offering.getId());
		System.out.println("Offering Name: "+offering.getNameList().get(0).getValue());
		params.setResponseFormat(offering.getResponseFormatList().get(0));
		
		params.setOffering(offering.getId());
		InputStream in = null;
		try {
			in = handler.getObservationStream(params);
			ObservationCollectionType ocollection = GetObservationParser.parse(in);
			
			List<ObservationPropertyType> list = ocollection.getMemberList();
			
			ObservationPropertyType observation = list.get(0);
			ObservationType type = observation.getObservation();
			AnyTypeRealization any = type.getResult();
			
			DataArrayType data = (DataArrayType) any.getValue();
			DataValuePropertyType test = data.getValues();
			System.out.println("Test: "+test.getValue());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SOSInternalException e) {
			e.printStackTrace();
		} catch (SOSInternalParserException e) {
			e.printStackTrace();
		}

		
//		for(ObservationOfferingType oo: capDoc.getContents().getObservationOfferingList().getObservationOfferingList()){
//			System.out.println("Processing Offering: " + oo.getId());		
//			getObservationsFromOffering(server, oo);
//		}
			    
	}
	
//	private void getObservationsFromOffering(String server, ObservationOfferingType oo) {
//		
//	}

}
