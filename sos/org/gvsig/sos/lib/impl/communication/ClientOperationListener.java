package org.gvsig.sos.lib.impl.communication;


/**
 * This interface allows hooking to different actions done by the SOSClient, the actions supported are GetCapabilites
 * and describeSensor. Also is included support for notifying when the host of the client have been changed. 
 * @author lrodriguez
 *
 */
public interface ClientOperationListener {
	/**
	 * Invoked when the Capabilities document have been retrieved from the server.
	 * @param client the SOSClient object used.
 	 * @param parameters the parameters used for requesting the capabilities.
	 * @param result the result document returned by the server. 
	 */
   void getCapabilitesResultDone(SOSCommunicationHandler client, GetCapabilitiesParameters parameters, Object result);

	/**
	 * Invoked when the SensorML document have been retrieved from the server.
	 * @param client the SOSClient object used.
	 * @param parameters the parameters used for requesting the SensorML document.
	 * @param result the result document returned by the server. 
	 */

   void describeSensorResultDone(SOSCommunicationHandler client, DescribeSensorParams parameters, Object result);
   
	/**
	 * Invoked when the host is changed in the client object. 
	 * @param client the client object where the host has been changed.
	 * @param result the new host established.
	 */
   void hostChangedDone(SOSCommunicationHandler client, Object result);
   
   /**
    * Invoked when the GetObservation operation have been successfully executed.
    * @param client the client used for invoking the operation.
    * @param parameters the parameters used in the operation request.
    * @param result the document returned by the server. 
    */
   void getObservationResultDone(SOSCommunicationHandler client, GetObservationParams parameters, Object result);   
}
