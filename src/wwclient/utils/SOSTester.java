package wwclient.utils;

public class SOSTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sosURL ="http://ispacesrv002.researchstudio.at/sensors/ubimet_avg/sos";
		SOSParser sosparser = new SOSParser();
		sosparser.test(sosURL);
	}

	
//	
//	<ows:Exception exceptionCode="MissingParameterValue" locator="version">
//	<ows:Exception exceptionCode="MissingParameterValue" locator="offering">
//	<ows:Exception exceptionCode="MissingParameterValue" locator="responseFormat">
//	<ows:Exception exceptionCode="MissingParameterValue" locator="observedProperty">
}
