package org.gvsig.tools.dataTypes;

public class CoercionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4367810513187193469L;
	
	public CoercionException() {
		super();
	}
	
	public CoercionException(String msg) {
		super(msg);
	}
	
	public CoercionException(Throwable cause) {
		super(cause);
	}
	
	public CoercionException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
