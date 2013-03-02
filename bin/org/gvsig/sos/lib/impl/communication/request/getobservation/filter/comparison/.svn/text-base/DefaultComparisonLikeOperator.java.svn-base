package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Represents a like operator of a comparison filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultComparisonLikeOperator extends AbstractComparisonOperator implements ComparisonLikeOperator{

	private String value = null;
	private char wildCard = ' ';
	private char singleChar = ' ';
	private char escapeChar = ' ';
	public DefaultComparisonLikeOperator() {
		super(GetObservationsTagNameConstants.COMPARISON_ISLIKE);
	}

	/**
	 * add wildcard
	 */
	public void setWildCard(char wildcard)
	{
		this.wildCard = wildcard;
	}
	/**
	 * Get wildcard
	 */
	public char getWildCard()
	{
		return this.wildCard;
	}
	/**
	 * Set singleChar
	 */
	public void setSingleChar(char singleChar)
	{
		this.singleChar = singleChar;
	}
	/**
	 * Get singleChar
	 */
	public char getSingleChar()
	{
		return this.singleChar;
	}
	/**
	 * Set scapeChar
	 * @param escapeChar
	 */
	public void setEscapeChar(char escapeChar)
	{
		this.escapeChar = escapeChar;
	}
	
	/**
	 * Get scapeChar
	 */
	public char getEscapeChar()
	{
		return this.escapeChar;
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
			throw new SOSInternalException(this.tagName + " : needs value");
		String xml = "";
		if(this.propertyName != null)
			xml += "<" + GetObservationsTagNameConstants.PROPERTY_NAME + ">" + propertyName +"</" + GetObservationsTagNameConstants.PROPERTY_NAME + ">\n";
		xml += "<"+ GetObservationsTagNameConstants.OGC_LITERAL +">";
		xml += this.value;
		xml += "</"+ GetObservationsTagNameConstants.OGC_LITERAL +">\n";
			
		return xml;
	}

}
