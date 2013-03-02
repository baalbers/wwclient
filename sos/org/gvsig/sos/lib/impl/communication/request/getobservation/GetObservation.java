
package org.gvsig.sos.lib.impl.communication.request.getobservation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;





/**
 * Represent a GetObservation request
 * @author Pablo Viciano Negre
 *
 */
public class GetObservation extends AbstractObservationRequest{

	private List<AbstractObservationRequest> request;
	private String srsName = null;//"urn:ogc:def:crs:EPSG:4326";
	public GetObservation() {
		super(GetObservationsTagNameConstants.SOS_GETOBSERVATION_REQUEST
				,GETOBSERVATION_TYPES.GETOBSERVATION);
		request = new ArrayList<AbstractObservationRequest>();
	}
	/**
	 * Set the srsName 
	 * @param name
	 */
	public void setSRSName(String name)
	{
		srsName = name;
	}
	
	/**
	 * Set the ArrayList of attributes (all request complete)
	 * @param request
	 */
	public void setRequest(List<AbstractObservationRequest> request)
	{
		this.request = request;
	}
	/**
	 * Get the ArrayList of attributes (all request)
	 * @return
	 */
	public List<AbstractObservationRequest> getRequest()
	{
		return this.request;
	}
	/**
	 * Add an attribute to request
	 * @param attribute
	 */
	public void addAttribute(AbstractObservationRequest attribute)
	{
		if(attribute != null)
			request.add(attribute);
	}

	 
	public String toXML() throws SOSInternalException	{
		
		if(!validate())
			throw new SOSInternalException("The request has not the minimums params");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		xml += "<" +  this.tagName + " " 
		+ GetObservationsTagNameConstants.XSINAME+"=\""+GetObservationsTagNameConstants.XSI_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.GMLNAME + "=\""+GetObservationsTagNameConstants.GML_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.OGCNAME + "=\"" + GetObservationsTagNameConstants.OGC_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.SOSNAME + "=\"" + GetObservationsTagNameConstants.SOS_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.OMNAME + "=\""+ GetObservationsTagNameConstants.OM_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.OWSNAME + "=\"" + GetObservationsTagNameConstants.OWS_NAMESPACE + "\""
		+ "\n " + GetObservationsTagNameConstants.SCHEMALOCATIONNAME + "=\"" +GetObservationsTagNameConstants.SCHEMA_LOCATION_NAMESPACE + "\""
		+ "\n service=\"SOS\" " +GetObservationsTagNameConstants.VERSION +"=\"1.0.0\"";
		if(srsName != null)
			xml += " " + GetObservationsTagNameConstants.SRS_NAME + "=\"" + srsName + "\""; 
		xml += ">\n";
		Iterator<AbstractObservationRequest> it = request.iterator();
		while(it.hasNext())
		{
			xml += it.next().toXML()+"\n";
		}
		xml += "</"+ this.tagName + ">";
		return xml;
		
	}

	/**
	 * Validate the request format
	 * @return
	 */
	private boolean validate()
	{
		return existsOffering() && existsObservedProperty() && existsResponseFormat();
	}
	
	private boolean existsOffering()
	{
		Iterator<AbstractObservationRequest> it = request.iterator();
		while(it.hasNext())
		{
			if(it.next().getType() == GETOBSERVATION_TYPES.OFFERING)
				return true;
		}
		return false;
	}
	
	private boolean existsObservedProperty()
	{
		Iterator<AbstractObservationRequest> it = request.iterator();
		while(it.hasNext())
		{
			if(it.next().getType() == GETOBSERVATION_TYPES.OBSERVEDPROPERTY)
				return true;
		}
		return false;
	}
	
	private boolean existsResponseFormat(){
		Iterator<AbstractObservationRequest> it = request.iterator();
		while(it.hasNext())
		{
			if(it.next().getType() == GETOBSERVATION_TYPES.RESPONSEFORMAT)
				return true;
		}
		return false;
	}
}
