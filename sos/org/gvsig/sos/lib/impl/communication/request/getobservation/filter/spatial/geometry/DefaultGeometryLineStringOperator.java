package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.geometry;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;


/**
 * This class represents a gml:LineString
 * 
 * @author Pablo Viciano Negre
 *
 */
public class DefaultGeometryLineStringOperator extends AbstractGeometryOperator implements GeometryLineStringOperator{

	private String coordinates = null;
	private String posList = null;
	private String dimension = null;
	public DefaultGeometryLineStringOperator() {
		super(GetObservationsTagNameConstants.GML_LINESTRING);
	}
	
	/**
	 * Set coordinates to LineString operator	
	 * @param coordinates
	 */
	public void setCoordinates (String coordinates)
	{
		this.coordinates = coordinates;
	}
	
	/**
	 * Get coordinates from LineString operator
	 * @return
	 */
	public String getCoordinates()
	{
		return this.coordinates;
	}
	
	/**
	 * Set posList to LineString operator
	 * @param posList
	 */
	public void setPosList (String posList)
	{
		this.posList = posList;
	}

	/**
	 * Get posList from LineString operator
	 * @return
	 */
	public String getPosList()
	{
		return this.posList;
	}
	
	/**
	 * set dimension to LineString operator
	 * @param dimension
	 */
	public void setPosDimension(String dimension)
	{
		this.dimension = dimension;
	}
	
	/**
	 * get dimension from LineString operator
	 * @return
	 */
	public String getPosDimension()
	{
		return this.dimension;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(this.posList == null && this.coordinates == null)
			throw new SOSInternalException("Needs a value for poslist or coordinates");
		
		String xml = "<" + this.tagName;
		if(this.id != null)
			xml += " " + GetObservationsTagNameConstants.GML_ID + "=\"" + this.id + "\" ";
		if(this.srsName != null)
			xml += " " + GetObservationsTagNameConstants.GML_SRS_NAME_PROPERTY + "=\"" + this.srsName + "\" ";
		xml += ">\n";
		
		if(this.posList != null)
		{	
			xml += "<"+ GetObservationsTagNameConstants.GML_POSLIST;
			if (this.dimension != null)
				xml += " dimension=\"" + dimension + "\"";
			xml +=">";
			xml += this.posList;
			xml += "</"+ GetObservationsTagNameConstants.GML_POSLIST + ">\n";
		}
		if(this.coordinates != null)
		{
			xml += "<"+ GetObservationsTagNameConstants.GML_COORDINATES + ">";
			xml += this.coordinates;
			xml += "</"+ GetObservationsTagNameConstants.GML_COORDINATES + ">\n";
			
		}
		xml += "</" + this.tagName + ">\n";
		return xml;
	}

}
