package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Time Interval Operator for temporal filters
 * @author Pablo Viciano Negre
 *
 */
public class DefaultTemporalIntervalOperator extends AbstractTemporalFilterOperation implements TemporalIntervalOperator{

	private String unit = null;
	private String radix = null;
	private String factor = null;
	private String value = null;
	
	public DefaultTemporalIntervalOperator() {
		super(GetObservationsTagNameConstants.TEMPORAL_TIMEINTERVAL);
	}
	
	/**
	 * Set unit 
	 */
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	/**
	 * Get unit
	 */
	public String getUnit()
	{
		return this.unit;
	}
	/**
	 * Set radix
	 */
	public void setRadix(String radix)
	{
		this.radix = radix;
	}
	/**
	 * Get radix
	 */
	public String getRadix()
	{
		return radix;
	}
	/**
	 * Set factor
	 */
	public void setFactor(String factor)
	{
		this.factor = factor;
	}
	/**
	 * Get factor
	 */
	public String getFactor()
	{
		return this.factor;
	}

	/**
	 * Set a value time
	 */
	public void setTime(String time)
	{
		value = time;		
	}
	
	/**
	 * Get a value time
	 */
	public String getTime()
	{
		return value;
	}
	 
	public String toXML() throws SOSInternalException
	{
		if(unit == null)
			throw new SOSInternalException(this.tagName + " : Needs a units");
		String xml = "<" + this.tagName + " " 
		+GetObservationsTagNameConstants.TEMPORAL_UNIT + "=\"" + unit + "\" ";
		if(radix != null)
		{
			xml += GetObservationsTagNameConstants.TEMPORAL_RADIX + "=\"" + radix +"\" ";
		}
		if(factor != null)
		{
			xml += GetObservationsTagNameConstants.TEMPORAL_FACTOR + "=\"" + factor +"\"";
		}	
		xml += ">";
		if (value != null)
			xml += value;
		xml += "<" + this.tagName + ">\n";
		return xml;
	}
	

}
