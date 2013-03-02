package org.gvsig.sos.lib.impl.communication;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


/**
 * <p> This class represents the SOS client end-point, encapsulating the logic 
 *      for connection and requesting operations to the SOS server  </p>
 *     
 *             
 * @author Alain Tamayo Fong (alain.tamayo@gmail.com)
 *
 */
public class SOSCommunicationHandler{
//	protected static final Log logger = LogFactory.getLog("ConnectionUtilities");	

	// Delegate in charge of handling requests to server 
	private SOSProtocolHandler handler;
	// Host Name
	URL host = null;
		
	/**
     * <p> Class constructor. It negotiates the protocol version with the SOS server
     *      and creates the appropriate protocol handler </p>
     *      
     * @param host: Contains the URL of the SOS Server
	 * @throws MalformedURLException 
     * @throws ConnectException: If the connection with the server could not be established
     * @throws IOException: If there is a IO error handling the server information
     */
    public SOSCommunicationHandler(String host) throws MalformedURLException{
    	this.host = new URL(cleanHostName(host));
    }  

    
    public SOSCommunicationHandler(URL host){
    	this.host = host;
    }  
    
    /**
	 * Prepares the client for executing requests to SOS servers. 
     * @throws SOSInternalException if a problem occurs while creating the objects used for
     * the communication with the SOS servers.
     *  NOTE: I considered this method not really necessary since its logic is duplicated in the class
     *        constructor. It was kept in the implementation this way just to follow a similar style 
     *        with other Web Services extensions in gvSIG
     */
	public void connect() throws SOSInternalException{
		try {
			if (host.toString().length() > 0)                   
				handler = new SOSProtocolHandler(); //SOSProtocolHandlerFactory.negotiate(host);
			    handler.setHost(host.toString());
		}
		catch(Exception e) {
		    throw new SOSInternalException(e);
		}

	}
    /**
     * Gets the capabilities document from the SOS server 
     * @param params: Contains the parameters for any SOS request to the server (Not used in this operation)
     * @throws SOSInternalException
     */
    public InputStream getCapabilities(GetCapabilitiesParameters  params) throws SOSInternalException{        
    	return handler.getCapabilitiesStream();
    } 
    /**
     * Get document with description for a given sensor or system of sensors. 
     * @param params Contains the parameters for any SOS request to the server (i.e. sensorId)
     * @return a stream containing the response document sent by the server as result of the operation. 
     * @throws SOSInternalException
     */
    public InputStream describeSensor(DescribeSensorParams params)throws SOSInternalException {
    	return handler.getSensorDescriptionStream(params.getProcedure()); //handler.getDescribeSensor(params);		
	}
    /**
     * Invokes a GetObservation operation on a SOS server, retrieving a O&M document containing the observations.
     * @param params: Contains the parameters for the request to the server( i.e. offering, observed properties, filters, etc.)
     * @return a stream containing the response document sent by the server as result of the operation. 
     * @throws IOException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * @throws SOSInternalException
     */
    public InputStream getObservation(GetObservationParams params) throws KeyManagementException, NoSuchAlgorithmException, IOException, SOSInternalException{
    	return handler.getObservationStream(params);		
	} 
    /**
     * Gives the current host set. This property contains the address of the SOS 
     * server configured.
     * @return the host address.
     */
    public URL getHost() {
		return host;
	}
    /**
     * 
     * @param host
     * @throws MalformedURLException 
     */
	public void setHost(URL host){
		this.host = host;
	}
	
	private String cleanHostName(String hostname) {
		hostname = hostname.trim();
    	if (hostname.endsWith("?"))
    		hostname += hostname.substring(0, hostname.length()-1);
		return hostname;
	}

}
