package org.gvsig.sos.lib.impl.communication.request.getobservation;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractSpatialFilterOperation;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.DefaultSpatialDistanceOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.DefaultSpatialEnvelopeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.SpatialFilterOperation;



/**
 * Represents a spatial filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultSpatialFilter extends AbstractFeatureOfInterestComponents implements SpatialFilter{
	
	
	String propertyName = null;
		
	SPATIAL_FILTER_TYPE mode = null;
	AbstractSpatialFilterOperation operation = null;
	public DefaultSpatialFilter() {
		super(null, GETOBSERVATION_TYPES.SPATIALFILTER);
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
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * Set the type of spatial filter
	 */
	public void setType(SPATIAL_FILTER_TYPE type)
	{
		mode = type;
		switch(mode)
		{
		case BBOX:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_BBOX;
			break;
		case CONTAINS:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_CONTAINS; 
			break;
		case CROSSES:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_CROSSES;
			break;
		case DISJOINT:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_DISJOINT;
			break;
		case EQUALS:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_EQUALS;
			break;
		case INTERSECTS:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_INTERSECTS;
			break;
		case OVERLAPS:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_OVERLAPS;
			break;
		case TOUCHES:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_TOUCHES;
			break;
		case WITHIN:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_WITHIN;
			break;
		case BEYOND:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_BEYOND;
			break;
		case DWITHIN:
			this.tagName = GetObservationsTagNameConstants.SPATIAL_FILTER_WITHIN;
			break;
		}
	}
	
	/**
	 * Set spatial operator needs
	 */
	public void setSpatialFilterOperator(SpatialFilterOperation operation)
	{
		this.operation = (AbstractSpatialFilterOperation)operation;
	}
	/**
	 * Get spatial operator
	 */
	public SpatialFilterOperation getSpatialFilterOperator()
	{
		return this.operation;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(mode == null || this.operation == null)
			throw new SOSInternalException("SpatialFilter : Needs type and filter operator");
		validate();
		String xml = "<" + this.tagName + ">\n";
		if(propertyName != null)
		{
			xml += "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+ propertyName
				+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		}
		xml += operation.toXML();
		xml += "</" + this.tagName + ">";
		return xml;
	}
	
	private void validate() throws SOSInternalException
	{
	    switch(mode)
        {
        case BBOX:
            if (!(operation instanceof DefaultSpatialEnvelopeOperator))
                throw new SOSInternalException("SpatialFilter: BBOX needs an Envelope");
            break;
        case CONTAINS:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Contains needs an Envelope or Geometry");
            break;
        case CROSSES:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Crosses needs an Envelope or Geometry");
            break;
        case DISJOINT:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Disjoint needs an Envelope or Geometry");
            break;
        case EQUALS:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Equals needs an Envelope or Geometry");
            break;
        case INTERSECTS:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Intersects needs an Envelope or Geometry");
            break;
        case OVERLAPS:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Overlap needs an Envelope or Geometry");
            break;
        case TOUCHES:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("TSpatialFilter: ouches needs an Envelope or Geometry");
            break;
        case WITHIN:
            if(!(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Within needs an Envelope or Geometry");
            break;
        case BEYOND:
            if(!(operation instanceof DefaultSpatialDistanceOperator) && !(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Beyond needs an Envelope or Geometry");
            break;
        case DWITHIN:
            if(!(operation instanceof DefaultSpatialDistanceOperator) && !(operation instanceof AbstractGeometryOperator)) 
                throw new SOSInternalException("SpatialFilter: Dwithin needs an Envelope or Geometry");
            break;
        }
	}

	public SPATIAL_FILTER_TYPE getSpatialFilterType() {
		return mode;
	}
}
