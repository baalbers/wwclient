package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.geometry;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;


/**
 * This class represent a gml:Point 
 * 
 * @author Pablo Viciano Negre
 *
 */
public class DefaultGeometryPointOperator extends AbstractGeometryOperator implements GeometryPointOperator{

	private String pos = null;
	private String dimension = null;
	private String coordinates = null;
	public DefaultGeometryPointOperator()
	{
		super(GetObservationsTagNameConstants.GML_POINT);
	}
	
	/**
	 * Set pos to point operator
	 * @param pos
	 */
	public void setPos(String pos)
	{
		this.pos = pos;
	}
	/**
	 * Get pos from point operator
	 * @return
	 */
	public String getPos()
	{
		return pos;
	}
	
	/**
	 * Set pos dimension attribute to point operator
	 * @param dimension
	 */
	public void setPosDimension(String dimension)
	{
		this.dimension = dimension;
	}
	
	/**
	 * Get pos dimension attribute from point operator
	 * @return
	 */
	public String getPosDimension()
	{
		return this.dimension;
	}
	
	/**
	 * Set coordinates parameter to point operator
	 * @param coordinates
	 */
	public void setCoordinates(String coordinates)
	{
		this.coordinates = coordinates;
	}
	
	/**
	 * Get coordinates parameter from point operator
	 * @return
	 */
	public String getCoordinates()
	{
		return this.coordinates;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(this.pos == null && this.coordinates == null)
			throw new SOSInternalException("Needs a value for pos or coordinates");
		String xml = "<" + this.tagName;
		if(this.id != null)
			xml += " " + GetObservationsTagNameConstants.GML_ID + "=\"" + this.id + "\" ";
		if(this.srsName != null)
			xml += " " + GetObservationsTagNameConstants.GML_SRS_NAME_PROPERTY + "=\"" + this.srsName + "\" ";
		xml += ">\n";
		if(pos != null)
		{	
			xml += "<"+ GetObservationsTagNameConstants.GML_POS;
			if (this.dimension != null)
				xml += " dimension=\"" + dimension + "\"";
			xml +=">";
			xml += pos;
			xml += "</"+ GetObservationsTagNameConstants.GML_POS + ">\n";
		}
		else
		{
			xml += "<"+ GetObservationsTagNameConstants.GML_COORDINATES + ">";
			xml += this.coordinates;
			xml += "</"+ GetObservationsTagNameConstants.GML_COORDINATES + ">\n";		
		}
		xml += "</" + this.tagName + ">\n";
		return xml;
	}

}
