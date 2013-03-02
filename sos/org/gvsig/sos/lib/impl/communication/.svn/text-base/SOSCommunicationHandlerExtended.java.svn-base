package org.gvsig.sos.lib.impl.communication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.parsers.CapabilitiesParser;
import org.gvsig.sos.lib.impl.parsers.DescribeSensorParser;
import org.gvsig.sos.lib.impl.parsers.GetObservationParser;
import org.gvsig.sos.lib.impl.parsers.SOSInternalParserException;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_SensorML;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This class extends the basic SOSClient so that is able to deliver the results of the main
 * operation such as (GetCapabilities, GetObservation and DescribeSensor) in objects instead of 
 * delivering the stream containing the XML responses.
 * @author lrodriguez
 */

public class SOSCommunicationHandlerExtended extends SOSCommunicationHandler {

	
	private static final Logger logger = LoggerFactory.getLogger(SOSCommunicationHandlerExtended.class);
	
	List<ClientOperationListener> listeners = new ArrayList<ClientOperationListener>();
	
	public SOSCommunicationHandlerExtended(String host) throws MalformedURLException {
		super(host);
		setDebug(false);
	}

	public SOSCommunicationHandlerExtended(URL host){
		super(host);
		//XXX: Change this here to see the caps documents, etc.
		setDebug(false);
	}

	
	protected Element_SensorML getDescribeSensor(InputStream stream) throws SOSInternalParserException, InternalSWEException{
		Element_SensorML describeSensor = null;
		describeSensor =  DescribeSensorParser.parse(stream);
		return describeSensor;
	}
	
	/**
	 * Executes a getCapabilites operation and parses the response for returning an object containing the 
	 * capabilities information. 
	 * @param params Parameter object to the GetCapabilities operarion
	 * @return An object representing the capabilities.
	 * @throws SOSInternalException Exception related with the communication issues.  
	 * @throws SOSInternalParserException Exception related issues that could arise during parsing of the server response.
	 * @see {@link CapabilitiesParser}
	 */
	public Element_Capabilities getCapabilitiesExtended(GetCapabilitiesParameters params) throws SOSInternalException, SOSInternalParserException{
		InputStream stream = getCapabilities(params);
		Element_Capabilities capabilities = null; 
		capabilities = getElementCapabilities(stream); 
		//notifyGetCapabilitiesOperation(params, capabilities);
		return capabilities;
	}

	/**
	 * Allows to register a listener that is going to be notified when events such as 
	 * the completion of operations and change of host.
	 * @param listener
	 */
	public void addClientOperationListener(ClientOperationListener listener){
		if (!isOperationListenerRegistered(listener))
		  listeners.add(listener);
	}	
	/**
	 * Allows to remove the listener to the operations.
	 * @param listener
	 */
	public void removeClientOperationListener(ClientOperationListener listener){
		if (isOperationListenerRegistered(listener)) 
		  listeners.remove(listener);
	} 
	/**
	 * Allows to check if the listener passed as parameter is already registered.
	 * @param listener the listener.
	 * @return
	 */
	public boolean isOperationListenerRegistered(ClientOperationListener listener){
		return listeners.contains(listener);
	}
	
	private void notifyDescribeSensorOperation(DescribeSensorParams parameters, Object result ){
		for (ClientOperationListener listener: listeners){
			listener.describeSensorResultDone(this, parameters, result);
		}
	}
	
	private void notifyGetCapabilitiesOperation(GetCapabilitiesParameters parameters, Object result){
		for (ClientOperationListener listener: listeners){
			listener.getCapabilitesResultDone(this, parameters, result);
		}
	}

	private void notifyGetObservationOperation(GetObservationParams parameters, Object result){
		for (ClientOperationListener listener: listeners){
			listener.getObservationResultDone(this, parameters, result);
		}
	}

	protected  Element_Capabilities getElementCapabilities(InputStream is) throws SOSInternalException, SOSInternalParserException{		
		Element_Capabilities capabilities = null;
	    capabilities = CapabilitiesParser.parse(is);
		return capabilities;
	}
	
	private InputStream cloneInputStream(InputStream is) throws SOSInternalException{
        ByteArrayOutputStream ou = new ByteArrayOutputStream();		
		
        if (is==null) {
		   throw new IllegalArgumentException("The input stream to be cloned can not be null.");	
		}
        
		byte[] buffer = new byte[1024];
	    int len;
	    try {
			while ((len = is.read(buffer)) > 0 ) {
			    ou.write(buffer, 0, len);
			}
		
	         ou.flush();
	    } catch (IOException e) {
			throw new SOSInternalException(e);
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(ou.toByteArray());  
	    return bais;	
	}
	
	/**
	 * Allows to execute a GetObservation operation and parse the response. The response is 
	 * represented by the object of type ObservationCollectionType.
	 * @param params
	 * @return the observation collection retrieved.
	 * @throws SOSInternalException Thrown when there is a problem related with the communication with the SOS server.
	 * @throws SOSInternalParserException Thrown when there is a problem while parsing the retrieved xml document containing the observation collection. 
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws InternalSWEException 
	 * @see {@link GetObservationParser}
	 */
    public ObservationCollectionType getObservationExtended(GetObservationParams params) throws 
    SOSInternalParserException, KeyManagementException, NoSuchAlgorithmException, IOException, InternalSWEException, SOSInternalException{
    	InputStream is= getObservation(params);
    	ObservationCollectionType result = null;
	    result = GetObservationParser.parse(is);
    	return result;
    }
	
    /**
	 * @throws IOException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * @throws SOSInternalException 
     * @see SOSCommunicationHandler
	 */
	 
	public InputStream getObservation(GetObservationParams params) throws KeyManagementException, NoSuchAlgorithmException, IOException, SOSInternalException{
		InputStream is = super.getObservation(params);	
		
		InputStream cloneStream = cloneInputStream(is);
		try{
			cloneStream.mark(cloneStream.available() +1);
	    	notifyGetObservationOperation(params, cloneStream);
			cloneStream.reset();
		} catch (IOException e) {
			logger.debug("Error while notifying GetObservation operation listeners.", e);
		}
		return cloneStream;
	} 
	
	  
	public InputStream getCapabilities(GetCapabilitiesParameters params) throws SOSInternalException {
		InputStream is = super.getCapabilities(params);		
		InputStream cloneStream = cloneInputStream(is);
		try {
			cloneStream.mark(cloneStream.available());
    		notifyGetCapabilitiesOperation(params, cloneStream);		
			cloneStream.reset();
		} catch (IOException e) {
			//Do nothing if an error occurs while notifying
			logger.info("Error notifying about capabilites to subscribed listerners", e);
		}
		return cloneStream;
	} 

	  
	public InputStream describeSensor(DescribeSensorParams params) throws SOSInternalException {
		InputStream is = super.describeSensor(params);		
		InputStream cloneStream = cloneInputStream(is);
		try {
			cloneStream.mark(cloneStream.available());
    		notifyDescribeSensorOperation(params, cloneStream);		
			cloneStream.reset();
		} catch (IOException e) {
			//Do nothing if an error occurs while notifying
			logger.info("Error notifying about describeSensor to subscribed listerners", e);
		}
		return cloneStream;
	} 
	
	/**
	 * Allows to execute a DescribeSensor operation and parse the result for returning an object
	 * containing the information about the sensor specified by the parameter. 
	 * @param params The parameter specifying the procedure of the sensor to be described in the 
	 * operartion. 
	 * @return An object of type Element_SensorML.
	 * @throws SOSInternalException Thrown when communication  problems arise.
	 * @throws SOSInternalParserException Thrown when a problem occurs while parsing the response.
	 * @throws InternalSWEException 
	 * @see {@link DescribeSensorParser}
	 */
	public Element_SensorML describeSensorExtended(DescribeSensorParams params) throws SOSInternalException, SOSInternalParserException, InternalSWEException{
	    InputStream is = this.describeSensor(params);	
        Element_SensorML sensorDescription = DescribeSensorParser.parse(is);
        return sensorDescription;
	}
	
	public static boolean debug;
	private ClientOperationListener listener;
	
	public static String getTextInStream(InputStream is) throws IOException {
		final char[] buffer = new char[0x10000];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(is, "UTF-8");
		int read;
		do {

			read = in.read(buffer, 0, buffer.length);
			if (read > 0) {
				out.append(buffer, 0, read);
			}
		} while (read >= 0);
		return out.toString();
	}


	public void setDebug(boolean debug) {
		if (this.debug != debug) {
			this.debug = debug;
			if (debug) {
				listener = new ClientOperationListener() {

					public void hostChangedDone(SOSCommunicationHandler client, Object result) {

					}

					public void getObservationResultDone(SOSCommunicationHandler client,
							GetObservationParams parameters, Object result) {
						if (result instanceof InputStream) {
							String text = "";
							try {
								text = SOSCommunicationHandlerExtended
										.getTextInStream((InputStream) result);
							} catch (IOException e) {
								logger.info("Error in  getObservationResultDone in debug mode", e);
							}
						}

					}

					public void getCapabilitesResultDone(SOSCommunicationHandler client,
							GetCapabilitiesParameters parameters, Object result) {
						if (result instanceof InputStream) {
							String text = "";
							try {
								text = SOSCommunicationHandlerExtended
										.getTextInStream((InputStream) result);
							} catch (IOException e) {
								logger.info("Error in  getCapabilitesResultDone in debug mode", e);
							}
						}
					}

					public void describeSensorResultDone(SOSCommunicationHandler client,
							DescribeSensorParams parameters, Object result) {
						if (result instanceof InputStream) {
							String text = "";
							try {
								text = SOSCommunicationHandlerExtended
										.getTextInStream((InputStream) result);
							} catch (IOException e) {
								//Do nothing if an error occurs while notifying
								logger.info("Error in  describeSensorResultDone in debug mode", e);
							}
						}

					}
				};

				this.addClientOperationListener(listener);
				
			} else {
				this.removeClientOperationListener(listener);
			}
		}
	}
	
	public boolean getDebug(){
		return debug;
	}
}


