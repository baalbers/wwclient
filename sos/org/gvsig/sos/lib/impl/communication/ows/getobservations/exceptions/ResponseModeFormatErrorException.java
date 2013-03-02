package org.gvsig.sos.lib.impl.communication.ows.getobservations.exceptions;
/**
 * Response mode format incorrect
 * @author Pablo Viciano Negre
 *
 */
public class ResponseModeFormatErrorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912537025590640194L;
	
	public ResponseModeFormatErrorException()
	{
		super();
	}
	
	public ResponseModeFormatErrorException(String message)
	{
		super(message);
	}
	
	public ResponseModeFormatErrorException(Throwable throwable)
	{
		super(throwable);
	}
	
	public ResponseModeFormatErrorException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
}
