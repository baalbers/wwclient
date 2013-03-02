package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;

/**
 * Represents a between operator of a comparison filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultComparisonBetweenOperator extends AbstractComparisonOperator implements ComparisonBetweenOperator{

	private String upperBoundary = null;
	private String lowerBoundary = null;
	public DefaultComparisonBetweenOperator() {
		super(GetObservationsTagNameConstants.COMPARISON_ISBETWEEN);
	}
	/**
	 * Set UpperBoundary
	 */
	public void setUpperBoundary(String boundary)
	{
		upperBoundary = boundary;
	}
	
	/**
	 * Get UpperBoundary
	 */
	public String getUpperBoundary()
	{
		return upperBoundary;
	}
	
	/**
	 * SetLowerBoundary
	 */
	public void setLowerBoundary(String boundary)
	{
		lowerBoundary = boundary;
	}
	/**
	 * Get LowerBoundary
	 */
	public String getLowerBoundary()
	{
		return this.lowerBoundary;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(upperBoundary == null || lowerBoundary == null)
			throw new SOSInternalException("FilterOperation : Needs data");
		
		String xml = "";
		if(this.propertyName != null)
			xml += "<" + GetObservationsTagNameConstants.PROPERTY_NAME + ">" + propertyName +"</" + GetObservationsTagNameConstants.PROPERTY_NAME + ">\n";
		xml += "<"+ GetObservationsTagNameConstants.COMPARISON_LOWERBOUNDARY + ">\n";
		xml += "<"+ GetObservationsTagNameConstants.OGC_LITERAL +">";
		xml += upperBoundary;
		xml += "</"+ GetObservationsTagNameConstants.OGC_LITERAL +">\n";
		xml += "</"+ GetObservationsTagNameConstants.COMPARISON_LOWERBOUNDARY + ">\n";
		
		xml += "<"+ GetObservationsTagNameConstants.COMPARISON_UPPERBOUNDARY + ">\n";
		xml += "<"+ GetObservationsTagNameConstants.OGC_LITERAL +">";
		xml += lowerBoundary;
		xml += "</"+ GetObservationsTagNameConstants.OGC_LITERAL +">\n";
		xml += "</"+ GetObservationsTagNameConstants.COMPARISON_UPPERBOUNDARY + ">\n";
		return xml;
	}

}
