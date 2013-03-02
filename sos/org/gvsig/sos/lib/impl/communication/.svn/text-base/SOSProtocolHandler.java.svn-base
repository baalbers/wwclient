package org.gvsig.sos.lib.impl.communication;


import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.remoteaccess.SingletonDownloader;


/**
 * <p> This class is in charge of sending all the request from a SOS client to
 *     the corresponding server. Only the core profile is supported so far.</p> 
 *   
 * <p> It is an abstract class that must be specialized for every version of the
 *     SOS specification </p>  
 *       
 * @author Alain Tamayo Fong (alain.tamayo@gmail.com)
 */
public class SOSProtocolHandler {
	/************************************************************************************************\
	 * 										COMMON CODE SECTION
	\************************************************************************************************/
	//SOS server name
	private String host;
	//SOS server version
	protected String version;

	/**
	 * Get SOS server name
	 * @return
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set SOS server name
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * Get SOS server version
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set SOS Server version
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

		
	
	/************************************************************************************************\
	 * 								FILE DOWNLOADER CODE SECTION
	\************************************************************************************************/

	
	
	private final String SIMPLE_GETCAPABILITIES_REQUEST =  "request=GetCapabilities&service=SOS&AcceptVersions=1.0.0";

	private final String SIMPLE_DESCRIBESENSOR_REQUEST =  "?service=SOS&version=1.0.0&request=DescribeSensor&procedure=%s&outputFormat=%s";
	private final String DESCRIBESENSOR_POST_REQUEST =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
															"<DescribeSensor version=\"1.0.0\" service=\"SOS\" " +
															"xmlns=\"http://www.opengis.net/sos/1.0\" " +
															"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
															"xsi:schemaLocation=\"http://www.opengis.net/sos/1.0 http://schemas.opengis.net/sos/1.0.0/sosDescribeSensor.xsd\" " +
															"outputFormat=\"%s\">" + 
															" <procedure>%s</procedure> " +
														" </DescribeSensor>";
	
	/**
	 * Send a GetCapabilities request to the server 
	 * @param params: Contains the parameters for the request
	 * @return 
	 * 		A File object containing the request response
     * @throws SOSInternalException
	 */
	public InputStream getCapabilitiesStream() throws SOSInternalException {
		try {
			String request = host + buildCapabilitiesRequest();
			// Get capabilities document from server 
			InputStream f = SingletonDownloader.getInstance().getRemoteInputStream(request);				
			// Check response for server-side exceptions
			//checkForServerException(f);
			
			return f;
		} // Catch and rethrow any server-side exception
		//catch (SOSException e){
			//throw e;
		//} // Catch any other exception and rethrow it as a SOS exception
		catch (Exception e){
			throw new SOSInternalException(e);
		}
	}

	private String buildCapabilitiesRequest() {
		String result = null;
		
		if (host.contains("?")){
			result = "&" + SIMPLE_GETCAPABILITIES_REQUEST;
		} else {
			result = "?" + SIMPLE_GETCAPABILITIES_REQUEST;
		}
			
		return result;
	}

	/**
	 * Send a DescribeSensor request to the server
	 * @param params: Contains the request parameters
 	 * @return 
	 * 		A File object containing the request response
     * @throws SOSInternalException
	 */
	public InputStream getSensorDescriptionStream(String procedure) throws SOSInternalException {		
		try {	
			
			String request = String.format(DESCRIBESENSOR_POST_REQUEST, "text/xml;subtype=&quot;sensorML/1.0.1&quot;",procedure);
			// Get capabilities document from server 
			InputStream f = SingletonDownloader.getInstance().getRemoteInputStream(host, request);		
			// Check response for server-side exceptions
			//checkForServerException(f);

			return f;
		} // Catch and rethrow any server-side exception
		/*catch (SOSException e){
			throw e;
		} */// Catch any other exception and rethrow it as a SOS exception
		catch (Exception e){
			throw new SOSInternalException(e);
		}
	}	
	
	/**
	 * Send a DescribeSensor request to the server
	 * @param params: Contains the request parameters
 	 * @return 
	 * 		A File object containing the request response
     * @throws SOSInternalException
	 */
	public InputStream getSensorDescriptionStreamGet(String procedure) throws SOSInternalException {		
		try {	
			
			String request = host + String.format(SIMPLE_DESCRIBESENSOR_REQUEST, procedure ,"text/xml;subtype=\"sensorML/1.0.1\"");
			// Get capabilities document from server 
			InputStream f = SingletonDownloader.getInstance().getRemoteInputStream(request);		
			// Check response for server-side exceptions
			//checkForServerException(f);

			return f;
		} // Catch and rethrow any server-side exception
		/*catch (SOSException e){
			throw e;
		} */// Catch any other exception and rethrow it as a SOS exception
		catch (Exception e){
			throw new SOSInternalException(e);
		}
	}	
	
	/**
	 * Send a Observation request to server
	 * @param observationRequest: Contains the request parameters
	 * @return
	 * 		A File object containing the request response
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws SOSInternalException
	 */
	public InputStream getObservationStream(GetObservationParams params) throws KeyManagementException, NoSuchAlgorithmException, IOException, SOSInternalException {
		// observationRequest = observationRequest.replaceAll("\\n", "");
		InputStream f = SingletonDownloader.getInstance().getRemoteInputStream(
				host, params.getHttpPostRequest());
		return f;
	}
	
}
