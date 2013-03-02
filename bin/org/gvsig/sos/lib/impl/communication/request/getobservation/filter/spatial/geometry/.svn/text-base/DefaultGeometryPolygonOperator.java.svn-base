package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.geometry;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;


/**
 * This class represent a gml:Polygon operator
 * @author Pablo Viciano Negre
 *
 */
public class DefaultGeometryPolygonOperator extends AbstractGeometryOperator implements GeometryPolygonOperator{
	
	private DefaultGeometryOuterBoundaryPolygon outerBoundary = null;
	private DefaultGeometryInnerBoundaryPolygon innerBoundary = null;
	
	public DefaultGeometryPolygonOperator() {
		super(GetObservationsTagNameConstants.GML_POLYGON);
	}
	
	/**
	 * Set outerBoundary to Polygon operator
	 * @param outerBoundary
	 */
	public void setOuterBoundary(GeometryOuterBoundaryPolygon outerBoundary)
	{
		this.outerBoundary = (DefaultGeometryOuterBoundaryPolygon)outerBoundary;
	}
	
	/**
	 * Get outerBoundary from Polygon operator
	 * @return
	 */
	public GeometryOuterBoundaryPolygon getOuterBoundary()
	{
		return this.outerBoundary;
	}
	
	/**
	 * Set innerBoundary to Polygon operator
	 * @param innerBoundary
	 */
	public void setInnerBoundary(GeometryInnerBoundaryPolygon innerBoundary)
	{
		this.innerBoundary = (DefaultGeometryInnerBoundaryPolygon)innerBoundary;
	}
	
	/**
	 * Get innerBoundary from Polygon operator
	 * @return
	 */
	public GeometryInnerBoundaryPolygon getInnerBoundary()
	{
		return this.innerBoundary;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(this.innerBoundary == null && this.outerBoundary == null)
			throw new SOSInternalException(this.tagName + ": Needs a innerBoundaryIS or outerBoundaryIS");
		
		String xml = "<" + this.tagName;
		if(this.id != null)
			xml += " " + GetObservationsTagNameConstants.GML_ID + "=\"" + this.id + "\" ";
		if(this.srsName != null)
			xml += " " + GetObservationsTagNameConstants.GML_SRS_NAME_PROPERTY + "=\"" + this.srsName + "\" ";
		
		xml += ">\n";
		
		if(this.innerBoundary != null)
			xml += this.innerBoundary.toXML();
		
		if(this.outerBoundary != null)
			xml += this.outerBoundary.toXML();
		
		xml += "</" + this.tagName + ">\n";
		return xml;
	}

}
