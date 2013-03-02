package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.geometry;

import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.GeometryOperator;

/**
 * This class represents a gml:LineString
 * 
 * @author Pablo Viciano Negre
 *
 */
public interface GeometryLineStringOperator extends GeometryOperator{

	/**
	 * Set coordinates to LineString operator	
	 * @param coordinates
	 */
	public void setCoordinates (String coordinates);
	
	
	/**
	 * Get coordinates from LineString operator
	 * @return
	 */
	public String getCoordinates();
	
	/**
	 * Set posList to LineString operator
	 * @param posList
	 */
	public void setPosList (String posList);

	/**
	 * Get posList from LineString operator
	 * @return
	 */
	public String getPosList();
	
	/**
	 * set dimension to LineString operator
	 * @param dimension
	 */
	public void setPosDimension(String dimension);
	
	/**
	 * get dimension from LineString operator
	 * @return
	 */
	public String getPosDimension();
}
