package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Distance Buffer Operator for spatial filter
 * @author Pablo Viciano Negre
 *
 */
public class DefaultSpatialDistanceBufferOperator extends AbstractSpatialFilterOperation implements SpatialDistanceBufferOperator{

	private DefaultSpatialDistanceOperator distance = null;
	public DefaultSpatialDistanceBufferOperator() {
		super(GetObservationsTagNameConstants.SPATIAL_BINARYTYPE);
	}
	/**
	 * Set units
	 */
	public void setUnits(String units)
	{
		if(distance == null)
			distance = new DefaultSpatialDistanceOperator();
		distance.setUnits(units);
	}
	/**
	 * Get units
	 */
	public String getUnit()
	{
		if(distance != null)
			return distance.getUnits();
		return null;
	}
	
	 
	public String toXML()throws SOSInternalException
	{
		if(propertyName == null || distance == null)
			throw new SOSInternalException(this.tagName + ": Needs a property name and a distance units");
		String xml = "<"+GetObservationsTagNameConstants.PROPERTY_NAME+">"+propertyName
		+ "</"+GetObservationsTagNameConstants.PROPERTY_NAME+ ">\n";
		xml+= distance.toXML();	
		return xml;
	}

}
