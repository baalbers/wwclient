package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Represents a null operator for comparison filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultComparisonNullOperator extends AbstractComparisonOperator implements ComparisonNullOperator {

	public DefaultComparisonNullOperator() {
		super(GetObservationsTagNameConstants.COMPARISON_ISNULL);
	}

	
	 
	public String toXML() throws SOSInternalException
	{
		if(propertyName == null)
			throw new SOSInternalException(this.tagName + " : Needs a propertyname");
		String xml = "<" + GetObservationsTagNameConstants.PROPERTY_NAME + ">" + propertyName +"</" + GetObservationsTagNameConstants.PROPERTY_NAME + ">\n";
		return xml;
	}

}
