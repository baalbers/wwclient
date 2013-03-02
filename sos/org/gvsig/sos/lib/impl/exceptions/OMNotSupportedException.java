package org.gvsig.sos.lib.impl.exceptions;

import org.gvsig.sos.lib.api.SOSOperationException;

public class OMNotSupportedException extends SOSOperationException {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 8035128476735583824L;
	
	private static String MESSAGE = "O&M response format is not supported by this server.";  
	private static String KEY = "_OM_Not_supported_Exception";
	
	public OMNotSupportedException() {
		super( MESSAGE, null, KEY, serialVersionUID);
	}

}
