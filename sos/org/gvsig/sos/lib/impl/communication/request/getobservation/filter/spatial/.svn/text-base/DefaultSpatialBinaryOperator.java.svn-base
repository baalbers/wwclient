package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Binary operator for spatial filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultSpatialBinaryOperator extends AbstractSpatialFilterOperation implements SpatialBinaryOperator{
	private AbstractGeometryOperator operator = null;
	public DefaultSpatialBinaryOperator() {
		super(GetObservationsTagNameConstants.SPATIAL_BINARYTYPE);
	}
	
	/**
	 * Set the Geometry operator
	 */
	public void setUpperCorner(GeometryOperator geometryOperator)
	{
		this.operator = (AbstractGeometryOperator)geometryOperator;
	}
	/**
	 * Get the geometry operator
	 */
	public GeometryOperator getGeometryOperator()
	{
		return this.operator;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(propertyName == null || operator == null)
			throw new SOSInternalException(this.tagName + ":Needs property name, lowerCorner and upperCorner");
		
		String xml = "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
		+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		xml += operator.toXML();
		return xml;
	}

}
