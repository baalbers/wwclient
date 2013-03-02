package org.gvsig.sos.lib.impl.communication.request.getobservation;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;

/**
 * Represents a result
 * @author Pablo Viciano Negre
 *
 */
public class Result extends AbstractObservationRequest{

	private DefaultComparisonFilter operator = null;
	public Result() {
		super(GetObservationsTagNameConstants.SOS_RESULT_REQUEST
				,GETOBSERVATION_TYPES.RESULT);
	}
	
	/**
	 * Adds operator
	 */
	public void setOperator(ComparisonFilter operator)
	{
		this.operator = (DefaultComparisonFilter)operator;
	}
	
	/**
	 * Gets the operator
	 */
	public ComparisonFilter getOperator()
	{
		return this.operator;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(operator == null)
			throw new SOSInternalException(this.tagName + " : Needs a filter");
		String xml = "<" + this.tagName + ">\n";
		xml += operator.toXML();
		xml += "</" + this.tagName + ">\n";
		return xml;
	}


}
