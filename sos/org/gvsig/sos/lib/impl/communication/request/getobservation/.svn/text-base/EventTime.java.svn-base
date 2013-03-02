package org.gvsig.sos.lib.impl.communication.request.getobservation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservationsTagNameConstants.GETOBSERVATION_TYPES;



/**
 * Represent a event time
 * @author Pablo Viciano Negre
 *
 */
public class EventTime extends AbstractObservationRequest{
	
	List<TemporalFilter> filters = null;
	
	public EventTime() {
		super(GetObservationsTagNameConstants.SOS_EVENTTIME_REQUEST
				,GETOBSERVATION_TYPES.EVENTTIME);
		
		filters = new ArrayList<TemporalFilter>();
	}
	
	/**
	 * Add a temporal filter
	 */
	public void addTemporalFilter(TemporalFilter filter)
	{
		if(!this.filters.contains(filter))
			this.filters.add(filter);
	}
	
	/**
	 * Add a list of temporal filters
	 * @param filters
	 */
	public void setTemporalFilters(List<TemporalFilter> filters)
	{
		for(int i = 0; i < filters.size(); i++)
		{
			if(!this.filters.contains(filters.get(i)))
				this.filters.add(filters.get(i));
		}
	}
	
	/**
	 * Gets all temporal filters
	 */
	public List<TemporalFilter> getTemporalFilter()
	{
		return filters;
	}
	
	 
	public String toXML() throws SOSInternalException
	{
		if(this.filters.size() == 0)
			throw new SOSInternalException(this.tagName + ": Needs a temporal filter");
		
		String xml = "";
		Iterator<TemporalFilter> it = this.filters.iterator();
		
		while(it.hasNext())
		{	
			xml+="<" + this.tagName + ">\n";
			xml += ((DefaultTemporalFilter)it.next()).toXML();
			xml += "\n</" + this.tagName + ">";
		}
		return xml;
	}
}
