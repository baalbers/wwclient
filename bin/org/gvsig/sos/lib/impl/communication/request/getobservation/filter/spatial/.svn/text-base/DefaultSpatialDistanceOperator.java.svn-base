package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;


/**
 * Represents a distance operator of a spatial filter
 * @author pviciano
 *
 */
public class DefaultSpatialDistanceOperator extends AbstractSpatialFilterOperation implements SpatialDistanceOperator{
	private String units = null;
	public DefaultSpatialDistanceOperator() {
		super(GetObservationsTagNameConstants.SPATIAL_DISTANCETYPE);
	}
	/**
	 * Set units
	 */
	public void setUnits(String units){
		this.units = units;
	}
	/**
	 * Get units
	 */
	public String getUnits()
	{
		return this.units;
	}
	
	
	//Este es un ejemplo de como seria finalmente. Parece que esto no es lo que se hace.
	//<Distance unit="http://www.uomdict.com/uom.html#meters">10</Distance>
	 
	public String toXML()throws SOSInternalException
	{
		if(this.units == null)
			throw new SOSInternalException(this.tagName + ": Needs units");
		String xml = "<" + this.tagName +">\n";
		xml += "<" + GetObservationsTagNameConstants.XSD_UNITS + ">";
		xml += units;
		xml += "</" + GetObservationsTagNameConstants.XSD_UNITS + ">\n" ;
		xml += "</" + this.tagName +">\n";
		return xml;
		
	}

}
