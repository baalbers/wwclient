package org.gvsig.sos.lib.impl.communication.request.getobservation;




import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.AbstractComparisonOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.ComparisonOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonBetweenOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonBinaryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonLikeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.comparison.DefaultComparisonNullOperator;

/**
 * Represent a comparison filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultComparisonFilter extends AbstractObservationRequest implements ComparisonFilter{
	
	COMPARISON_FILTER_TYPE mode = null;
	private AbstractComparisonOperator operator = null;
	private String propertyName = null;
	
	public DefaultComparisonFilter() {
		super(null, GETOBSERVATION_TYPES.COMPARISONFILTER);
	}
	/**
	 * Set type comparison filter
	 */
	public void setType(COMPARISON_FILTER_TYPE type)
	{
		mode = type;
		switch(mode)
		{
		case EQUALTO:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISEQUALTO;
			break;
		case GREATERTHAN:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISGREATERTHAN;
			break;
		case GREATERTHANOREQUALTO:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISGREATHEROREQUAL;
			break;
		case LESSTHAN:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISLESSTHAN;
			break;
		case LESSTHANOREQUALTO:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISLESSOREQUAL;
			break;
		case NOTEQUALTO:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISNOTEQUALTO;
			break;
		case BETWEEN:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISBETWEEN;
			break;
		case LIKE:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISLIKE;
			break;
		case NULL:
			this.tagName = GetObservationsTagNameConstants.COMPARISON_ISNULL;
			break;
		}
	}
	
	/**
	 * Get the type of the operator
	 */
	public COMPARISON_FILTER_TYPE getComparisonFilterType(){
		return mode;
	}
	
	
	/**
	 * Set the property name
	 * @param property
	 */
	public void setPropertyName(String property)
	{
		this.propertyName = property;
	}
	
	/**
	 * Get the property name
	 * @return
	 */
	public String getPropertyName()
	{
		return this.propertyName;
	}
	
	/**
	 * Adds Comparison operator
	 */
	public void setComparisonOperator(ComparisonOperator operation)
	{
		this.operator = (AbstractComparisonOperator)operation;
	}
	
	public ComparisonOperator getComparisonOperator()
	{
		return (ComparisonOperator) this.operator;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(mode == null || operator == null)
			throw new SOSInternalException("ComparisonFilter : Needs a mode");
		validate();
		String xml = "<" + this.tagName;
		if(operator.getTagName().equals(GetObservationsTagNameConstants.COMPARISON_ISLIKE))
		{
			DefaultComparisonLikeOperator op = (DefaultComparisonLikeOperator) operator;
			if(op.getWildCard() != ' ')
				xml += " " + GetObservationsTagNameConstants.OGC_WILCARD + "=\"" + op.getWildCard() + "\"";
			if(op.getSingleChar() != ' ')
				xml += " " + GetObservationsTagNameConstants.OGC_SINGLECHAR + "=\"" + op.getSingleChar()+ "\"";
			if(op.getEscapeChar() != ' ')
				xml += " " + GetObservationsTagNameConstants.OGC_ESCAPECHAR + "=\"" + op.getEscapeChar() + "\"";
		}
		xml+= ">\n";
		if(this.propertyName != null)
		{
			xml += "<" + GetObservationsTagNameConstants.PROPERTY_NAME + ">" + propertyName +"</" + GetObservationsTagNameConstants.PROPERTY_NAME + ">\n";
		}
		xml+= operator.toXML();
		xml += "</" + this.tagName + ">";
		return xml;
	}
	
	private void validate() throws SOSInternalException
	{
	    switch(mode)
        {
        case EQUALTO:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Equalto needs an Binary Comparison operator");
            break;
        case GREATERTHAN:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Greater than needs an Binary Comparison operator");
            break;
        case GREATERTHANOREQUALTO:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Greater than or equal to needs an Binary Comparison operator");
            break;
        case LESSTHAN:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Less than needs an Binary Comparison operator");
            break;
        case LESSTHANOREQUALTO:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Less than or equal to needs an Binary Comparison operator");
            break;
        case NOTEQUALTO:
            if (!(operator instanceof DefaultComparisonBinaryOperator))
                throw new SOSInternalException("ComparisonFilter: Not equal to needs an Binary Comparison operator");
            break;
        case BETWEEN:
            if (!(operator instanceof DefaultComparisonBetweenOperator))
                throw new SOSInternalException("ComparisonFilter: Between needs an Between Comparison operator");
            break;
        case LIKE:
            if (!(operator instanceof DefaultComparisonLikeOperator))
                throw new SOSInternalException("ComparisonFilter: Like needs an Like Comparison operator");
            break;
        case NULL:
            if (!(operator instanceof DefaultComparisonNullOperator))
                throw new SOSInternalException("ComparisonFilter: Null needs an Binary Comparison operator");
            break;
        }
	}
}
