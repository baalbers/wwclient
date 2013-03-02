package org.gvsig.sos.lib.impl.communication.request.getobservation;




import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.AbstractTemporalFilterOperation;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.temporal.TemporalFilterOperation;


/**
 * Generic class for temporal filters
 * 
 * @author Pablo Viciano Negre
 * 
 */
public class DefaultTemporalFilter extends AbstractObservationRequest implements TemporalFilter {
	
	private TEMPORAL_FILTER_TYPE mode = null;
	private String propertyName = null;
	private AbstractTemporalFilterOperation operation = null;
	public DefaultTemporalFilter() {
		super(null, GETOBSERVATION_TYPES.TEMPORALFILTER);
	}

	/**
	 * Set the type's filter
	 */
	public void setType(TEMPORAL_FILTER_TYPE type){
		mode = type;
		switch (mode) {
		case TM_AFTER:
			this.tagName = GetObservationsTagNameConstants.OGC_TM_AFTER;
			break;
		case TM_BEFORE:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_BEFORE;
			break;
		case TM_BEGINS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_BEGINS;
			break;
		case TM_BEGUNBY:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_BEGUNBY;
			break;
		case TM_CONTAINS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_CONTAINS;
			break;
		case TM_DURING:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_DURING;
			break;
		case TM_ENDEDBY:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_ENDEDBY;
			break;
		case TM_ENDS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_ENDS;
			break;
		case TM_EQUALS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_EQUAS;
			break;
		case TM_MEETS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_MEETS;
			break;
		case TM_METBY:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_METBY;
			break;
		case TM_OVERLAPS:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_OVERLAPS;
			break;
		case TM_OVERLAPPEDBY:
			this.tagName  = GetObservationsTagNameConstants.OGC_TM_OVERLAPPEDBY;
			break;
		}
	}
	
	public TEMPORAL_FILTER_TYPE getTemporalFilterType(){
		return mode;
	}

	/**
	 * Set the temporal filter operator
	 */
	public void setTemporalFilterOperator(TemporalFilterOperation operation)
	{
		this.operation = (AbstractTemporalFilterOperation)operation;	
	}
	
	/**
	 * Get the temporal filter
	 */
	public TemporalFilterOperation getTemporalFilterOperator()
	{
		return this.operation;
	}
	
	/**
	 * Set the property name
	 * @param propertyName
	 */	
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}

	 
	public String toXML() throws SOSInternalException {
		if (mode == null)
			throw new SOSInternalException(
					"TemporalFilter: Needs a temporal filter");
		if (operation == null)
		    throw new SOSInternalException("TemporalFilter: Needs a temporal operator");

		String xml = "<" + 	this.tagName  + ">\n";
		if(this.propertyName != null)
			xml += "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
			+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		xml+= operation.toXML();
		xml += "</" + this.tagName  + ">";
		return xml;
	}

	
	public String getPropertyName() {
		return propertyName;
	}

}
