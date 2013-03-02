package org.gvsig.sos.lib.impl.exceptions;

import org.gvsig.sos.lib.api.SOSOperationException;

public class GetObservationRequestCreationException extends
		SOSOperationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4751732026722015719L;
	private static String MESSAGE = "Exception occcurred while preparing the GetObservationRequest.";
    private static String KEY = "_GetObservationRequestException";
    
	public GetObservationRequestCreationException(Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
	}

}
