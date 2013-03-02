package org.gvsig.sos.lib.impl.communication.request.getobservation;


import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;



/**
 * Represent resultModel
 * 
 * @author Pablo Viciano Negre
 * 
 */
public class ResultModel extends AbstractObservationRequest {

	private String value = null;

	public ResultModel() {
		super(GetObservationsTagNameConstants.SOS_RESULTMODEL_REQUEST,
				GETOBSERVATION_TYPES.RESULTMODEL);
	}

	/**
	 * Get the resultModel
	 */
	public String getResultModel() {
		return value;
	}

	/**
	 * Set the resultModel
	 */
	public void setResultModel(String resultModel) {
		value = resultModel;
	}

	 
	public String toXML() throws SOSInternalException {
		if (value == null)
			throw new SOSInternalException(this.tagName + ": Needs a value");
		String xml = "\n<" + this.tagName + ">" + value + "</" + this.tagName
				+ ">";
		return xml;
	}

}
