package org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.geometry;



import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.ows.getobservations.exceptions.OperatorNotPermitedException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.AbstractGeometryOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.DefaultSpatialEnvelopeOperator;
import org.gvsig.sos.lib.impl.communication.request.getobservation.filter.spatial.GeometryOperator;


/**
 * This class represents a innerBoundaryIS
 * @author Pablo Viciano Negre
 *
 */
public class DefaultGeometryInnerBoundaryPolygon extends AbstractGeometryOperator implements GeometryInnerBoundaryPolygon {

	private AbstractGeometryOperator operator = null;
	
	public DefaultGeometryInnerBoundaryPolygon() {
		super(GetObservationsTagNameConstants.GML_INNER_BOUNDARY_IS);
	}

	/**
	 * Set geometry operator to outerBoundary (GeometryEnvelopeOperator, GeometryPointOperator or GeometryLineStringOperator)
	 * @param operator
	 * @throws OperatorNotPermitedException 
	 */
	public void setGeometryOperator(GeometryOperator operator) throws OperatorNotPermitedException 
	{
		if(operator instanceof DefaultSpatialEnvelopeOperator || operator instanceof DefaultGeometryPointOperator || operator instanceof DefaultGeometryLineStringOperator)
			this.operator = (AbstractGeometryOperator)operator;
		else
			throw new OperatorNotPermitedException("Operators permited are GeometryEnvelopeOperator, GeometryPointOperator or GeometryLineStringOperator");
		
	}
	
	/**
	 * Get operator from outerBoundary
	 * @return
	 */
	public GeometryOperator getGeometryOperator()
	{
		return this.operator;
	}
	
	  
	public String toXML() throws SOSInternalException
	{
		if(operator == null)
			throw new SOSInternalException(this.tagName + ": Needs a geometry operator");
		
		String xml = "<"+this.tagName + ">\n";
		xml += operator.toXML();
		xml += "</"+this.tagName + ">\n";
		return xml;
	}
	
}
