package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Binary operator for comparison filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultComparisonBinaryOperator extends AbstractComparisonOperator implements ComparisonBinaryOperator{
	public String value = null;
	public DefaultComparisonBinaryOperator() {
		super("BinaryComparisonOperator");
	}

	/**
	 * Set value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
	
	/**
	 * Get Value
	 */
	public String getValue()
	{
		return this.value;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(value == null)
			throw new SOSInternalException(this.tagName + " :Needs a value");
		
		String xml = "";
		if(this.propertyName != null)
			xml += "<" + GetObservationsTagNameConstants.PROPERTY_NAME + ">" + propertyName +"</" + GetObservationsTagNameConstants.PROPERTY_NAME + ">\n";
		xml += "<"+ GetObservationsTagNameConstants.OGC_LITERAL +">";
		xml += this.value;
		xml += "</"+ GetObservationsTagNameConstants.OGC_LITERAL +">\n";
		return xml;
	}


}
