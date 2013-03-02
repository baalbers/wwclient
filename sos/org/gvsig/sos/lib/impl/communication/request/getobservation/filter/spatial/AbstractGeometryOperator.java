package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial;


/**
 * Abstract class for geometry operator classes
 * @author Pablo Viciano Negre
 *
 */
public abstract class AbstractGeometryOperator extends AbstractSpatialFilterOperation implements GeometryOperator{
	protected String id = null;
	protected String srsName = null;
	
	protected AbstractGeometryOperator(String tagName) {
		super(tagName);
	}

	/**
	 * Set id attribute
	 * @param id
	 */
	public void setID(String id)
	{
		this.id = id;
	}
	
	/**
	 * Get id attribute
	 * @return
	 */
	public String getID()
	{
		return this.id;
	}
	
	/**
	 * Set srsName attribute
	 * @param srsName
	 */
	public void setSrsName(String srsName)
	{
		this.srsName = srsName;
	}
	
	/**
	 * Get srsName attribute
	 * @return
	 */
	public String getSrsName()
	{
		return this.srsName;
	}


}
