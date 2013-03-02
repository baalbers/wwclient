package org.gvsig.sos.lib.impl.communication.request.getobservation;




import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;

/**
 * Represent a feature of interest
 * @author Pablo Viciano Negre
 *
 */
public class FeatureOfInterest extends AbstractObservationRequest{

	private  AbstractFeatureOfInterestComponents component = null;
	public FeatureOfInterest() {
		super(GetObservationsTagNameConstants.SOS_FEATUREOFINTEREST_REQUEST
				,GETOBSERVATION_TYPES.FEATUREOFINTEREST);
	}
	
	/**
	 * Set the component 
	 */
	public void setComponent(FeatureOfInterestComponents component)
	{
		this.component = (AbstractFeatureOfInterestComponents)component;
	}
	
	/**
	 * Get the component
	 */
	
	public AbstractFeatureOfInterestComponents getComponent()
	{
		return this.component;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(this.component == null)
			throw new SOSInternalException(this.tagName + ": Needs a component");
		String xml ="<" +this.tagName+">\n";
		xml += this.component.toXML();
		xml +="\n</" +this.tagName+">";
		return xml;
	}
}

