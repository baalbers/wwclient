package org.gvsig.sos.lib.impl.communication;

import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ComparisonFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.EventTime;
import org.gvsig.sos.lib.impl.communication.request.getobservation.FeatureOfInterest;
import org.gvsig.sos.lib.impl.communication.request.getobservation.GetObservation;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ObjectID;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ObservedProperty;
import org.gvsig.sos.lib.impl.communication.request.getobservation.Offering;
import org.gvsig.sos.lib.impl.communication.request.getobservation.Procedure;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ResponseFormat;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ResponseMode;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ResponseMode.RESPONSEMODETYPE;
import org.gvsig.sos.lib.impl.communication.request.getobservation.Result;
import org.gvsig.sos.lib.impl.communication.request.getobservation.ResultModel;
import org.gvsig.sos.lib.impl.communication.request.getobservation.SpatialFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.TemporalFilter;


/**
 * <p>Params for GetObservation request</p>
 * Response Format default is text/xml 
 * @author Pablo Viciano Negre
 */
public class GetObservationParams{
	private String srsName = null;//"urn:ogc:def:crs:EPSG:4326";
	private String offering = null;
	//eventTime (Temporal operators)
	private ArrayList<TemporalFilter> temporalFilters = null;
	
	private ArrayList<String> procedures = null;
	private ArrayList<String> observedProperties = null;
	

	//feature of interest (spatial operators)
	private SpatialFilter spatialFilter = null;
	private ArrayList<String> objectID = null;
	
	//SoS:result (comparison operators)
	private ComparisonFilter comparisonFilter = null;
	
	private String responseFormat = null;
	private String resultModel = null;
	private String responseMode = null;

	private static final String RESPONSEFORMAT_TEXT_XML = "text/xml;subtype=&quot;om/1.0.0&quot;";

	public GetObservationParams() {
		temporalFilters = new ArrayList<TemporalFilter>();
		procedures = new ArrayList<String>();
		observedProperties = new ArrayList<String>();
		objectID= new ArrayList<String>();
		responseFormat = RESPONSEFORMAT_TEXT_XML;
	}

	/**
	 * Set srsName to GetObservation Request
	 * @param srsName
	 */
	public void setSrsName(String srsName)
	{
		this.srsName = srsName;
	}
	
	/**
	 * Get srsName from GetObservation Request
	 * @return
	 */
	public String getSrsName()
	{
		return this.srsName;
	}
	
	/**
	 * Set Offering to GetObservation Request
	 * 
	 * @param offering
	 */
	public void setOffering(String offering) {
		this.offering = offering;
	}

	/**
	 * Get Offering from GetObservation Request
	 * 
	 * @return
	 */
	public String getOffering() {
		return this.offering;
	}
	
	/**
	 * Add a temporal filter to GetObservation Request
	 * @param temporalFilter
	 */
	public void addTemporalFilter(TemporalFilter temporalFilter)
	{
		if(!this.temporalFilters.contains(temporalFilter))
			this.temporalFilters.add(temporalFilter);
	}
	
	/**
	 * Get a list of temporal filters from GetObservation Request
	 * @return
	 */
	public ArrayList<TemporalFilter> getTemporalFilters()
	{
		return this.temporalFilters;
	}
	
	/**
	 * Add a list of temporal filters to GetObservation Request
	 * @param temporalFilters
	 */
	public void addTemporalFilters(List<TemporalFilter> temporalFilters)
	{
		for(int i = 0; i < temporalFilters.size(); i++)
		{
			if(!this.temporalFilters.contains(temporalFilters.get(i)))
				this.temporalFilters.add(temporalFilters.get(i));
		}
	}
	
	/**
	 * Add procedure to GetObservation Request
	 * @param procedure
	 */
	public void addProcedure(String procedure)
	{
		if(!this.procedures.contains(procedure))
			this.procedures.add(procedure);
	}
	
	/**
	 * Get the list of procedures
	 * @return
	 */
	public List<String> getProcedures()
	{
		return this.procedures;
	}
	
	/**
	 * Add a list of procedures to procedures 
	 * @param procedures
	 */
	public void addProcedures(List<String> procedures)
	{
		for(String procedure : procedures)
		{
			if(!this.procedures.contains(procedure))
				this.procedures.add(procedure);
		}
	}
	
	/**
	 * Add a new observedProperty
	 * 
	 * @param observedProperty
	 */
	public void addObservedProperty(String observedProperty) {
		// Filter for duplicated elements
		if (!this.observedProperties.contains(observedProperty))
			this.observedProperties.add(observedProperty);
	}

	/**
	 * Add a list of observed properties
	 * 
	 * @param observedProperties
	 */
	public void addObservedProperties(List<String> observedProperties) {
		for (int i = 0; i < observedProperties.size(); i++) {
			if (!this.observedProperties.contains(observedProperties.get(i)))
				this.observedProperties.add(observedProperties.get(i));
		}
	}

	/**
	 * Gets a list with all observed properties
	 * 
	 * @return
	 */
	public List<String> getObservedProperties() {
		return this.observedProperties;
	}
	
	/**
	 * Set a spatial filter to GetObservationRequest
	 * @param spatialFilter
	 */
	public void setSpatialFilter(SpatialFilter spatialFilter)
	{
		this.spatialFilter = spatialFilter;
	}
	
	/**
	 * Get a spatial filter from GetObservationRequest
	 * @return
	 */
	public SpatialFilter getSpatialFilter()
	{
		return this.spatialFilter;
	}
	
	/**
	 * Add ObjectID to feature of interest
	 * @param objectID
	 */
	public void addObjectID(String objectID)
	{
		if(!this.objectID.contains(objectID))
			this.objectID.add(objectID);
	}
	
	/**
	 * Get a list of ObjectsID from feature of interest
	 * @return
	 */
	public List<String> getObjectsID()
	{
		return this.objectID;
	}
	
	/**
	 * Add a list of ObjectsID to feature of interest
	 * @param objectsID
	 */
	public void addObjectsID(List<String> objectsID)
	{
		for(int i = 0; i < objectsID.size(); i++)
		{
			if(!this.objectID.contains(objectsID.get(i)))
				this.objectID.add(objectsID.get(i));
		}
	}
	
	/**
	 * Set comparison filter to GetObservation Request
	 * @param comparisonFilter
	 */
	public void setComparisonFilter(ComparisonFilter comparisonFilter)
	{
		this.comparisonFilter = comparisonFilter;
	}
	
	/**
	 * Get comparison filter from GetObservation Request
	 * @return
	 */
	public ComparisonFilter getComparisonFilter()
	{
		return this.comparisonFilter;
	}
	
	
	/**
	 * Set Response Format to GetObservation Request
	 * @param responseFormat
	 */
	public void setResponseFormat(String responseFormat) {
		this.responseFormat = responseFormat;
	}

	/**
	 * Get Response Format from GetObservation Request
	 * 
	 * @return
	 */
	public String getResponseFormat() {
		return this.responseFormat;
	}
	
	/**
	 * Set ResultModel to GetObservation Request
	 * @param resultModel
	 */
	public void setResultModel(String resultModel)
	{
		this.resultModel = resultModel;
	}
	
	/**
	 * Get ResultModel from GetObservation Request
	 * @return
	 */
	public String getResultModel()
	{
		return this.resultModel;
	}
	
	/**
	 * Set Response Mode to GetObservation Request
	 * @param responseMode
	 */
	public void setResponseMode(String responseMode)
	{
		this.responseMode = responseMode;
	}
	/**
	 * Get Response Mode from GetObservation Request
	 * @return a string the response mode
	 */
	public String getResponseMode()
	{
		return this.responseMode;
	}
	
	protected String getHttpPostRequest() throws SOSInternalException {
		
		GetObservation getObservation = new GetObservation();
		String strResponseFormat = getResponseFormat();
		if(!strResponseFormat.contains("&quot;"))
		{
			String [] responFormat = strResponseFormat.split("subtype=\"");
			if(responFormat.length > 1)
			{
				responFormat[1] = responFormat[1].replaceFirst("\"", "&quot;");
				strResponseFormat = responFormat[0] + "subtype=&quot;" + responFormat[1];
				setResponseFormat(strResponseFormat);
			}
		}
		createGetObservationRequest(getObservation);
		String xml = getObservation.toXML();
		return xml;
	}
	
	/**
	 * create the complete request
	 * @throws SOSInternalException 
	 */
	private void createGetObservationRequest(GetObservation request) 
	throws SOSInternalException
	{
		//request = new GetObservation();
		if(getSrsName()!= null)
			request.setSRSName(getSrsName());
		request.addAttribute(createOffering());
		request.addAttribute(createEventTime());
		request.addAttribute(createProcedures());
		request.addAttribute(createObservedProperties());
		request.addAttribute(createFeatureOfInterest());
		request.addAttribute(createSosResult());
		request.addAttribute(createResponseFormat());
		request.addAttribute(createResultModel());
		request.addAttribute(createResponseMode());
	}
	
	/**
	 * Create the offering from params
	 * @param getObservationParams
	 * @return
	 */
	private Offering createOffering()
	{
		Offering offering = new Offering();
		String strOffering = getOffering();
		if(strOffering != null)
		{
			offering.setValue(strOffering);
			return offering;
		}
		return null;
	}
	
	/**
	 * Create EventTime (Temporal filters) from params 
	 * @param getObservationParams
	 * @return
	 */
	private EventTime createEventTime()
	{
		EventTime eventTime = new EventTime();
		List<TemporalFilter> temporalFilters = getTemporalFilters();
		if(temporalFilters.size() > 0)
		{
			eventTime.setTemporalFilters(temporalFilters);
			return eventTime;
		}
		return null;
		
	}
	
	/**
	 * Create the Procedures from params
	 * @param getObservationParams
	 * @return
	 */
	private Procedure createProcedures()
	{
		Procedure procedure = new Procedure();
		List<String> arrProcedures = getProcedures();
		if(arrProcedures.size()> 0)
		{
			procedure.addProcedures(arrProcedures);
			return procedure;
		}
		return null;
	}
	
	/**
	 * Create the ObservedProperties from params
	 * @param getObservationParams
	 * @return
	 */
	private ObservedProperty createObservedProperties()
	{
		ObservedProperty observedProperties = new ObservedProperty();
		List<String> arrObservedProperties = getObservedProperties();
		if(arrObservedProperties.size() > 0)
		{
			observedProperties.addObservedProperties(arrObservedProperties);
			return observedProperties;
		}
		return null;
	}
	
	/**
	 * Create Feature of Interest from params
	 * @param getObservationParams
	 * @return
	 */
	private FeatureOfInterest createFeatureOfInterest()
	{
		FeatureOfInterest featureOfInterest = new FeatureOfInterest();
		SpatialFilter spatialFilter = getSpatialFilter();
		if(spatialFilter != null)
		{
			featureOfInterest.setComponent(spatialFilter);
			return featureOfInterest;
		}
		List<String> arrObjectsID = getObjectsID();
		if(arrObjectsID.size() > 0)
		{
			ObjectID objectID = new ObjectID();
			for(int i = 0; i < arrObjectsID.size(); i++)
			{
				objectID.addURI(arrObjectsID.get(i));
			}
			featureOfInterest.setComponent(objectID);
			return featureOfInterest;
		}
		return null;
		
	}
	
	private Result createSosResult()
	{
		Result result = new Result();
		ComparisonFilter comparisonFilter = getComparisonFilter();
		if(comparisonFilter != null)
		{
			result.setOperator(comparisonFilter);
			return result;
		}
		return null;
	}
	
	/**
	 * Create Response Format from params
	 * @param getObservationParams
	 * @return
	 */
	private ResponseFormat createResponseFormat()
	{
		ResponseFormat responseFormat = new ResponseFormat();
		String strResponseFormat = getResponseFormat();
		if(strResponseFormat != null)
		{
			responseFormat.setResponseFormat(strResponseFormat);
			return responseFormat;
		}
		return null;
	}
	
	/**
	 * Create Result Model from params
	 * @param getObservationParams
	 * @return
	 */
	private ResultModel createResultModel()
	{
		ResultModel resultModel = new ResultModel();
		String strResultModel = getResultModel();
		if(strResultModel != null)
		{
			resultModel.setResultModel(strResultModel);
			return resultModel;
		}
		return null;
		
	}
	
	/**
	 * Create Response Mode from params
	 * @param getObservationParams
	 * @return
	 */
	private ResponseMode createResponseMode() throws SOSInternalException
	{
		ResponseMode responseMode = new ResponseMode();
		String strResponseMode = getResponseMode();
		if(strResponseMode != null)
		{
			if(strResponseMode.equalsIgnoreCase("inline"))
			{
				responseMode.setResponseMode(RESPONSEMODETYPE.INLINE);
			}
			else if(strResponseMode.equalsIgnoreCase("out-of-band"))
			{
				responseMode.setResponseMode(RESPONSEMODETYPE.OUTOFBAND);
			}
			else if(strResponseMode.equalsIgnoreCase("attached"))
			{
				responseMode.setResponseMode(RESPONSEMODETYPE.ATTACHED);
			}
			else if(strResponseMode.equalsIgnoreCase("resultTemplate"))
			{
				responseMode.setResponseMode(RESPONSEMODETYPE.RESULTTEMPLATE);
			}
			else
			{
				throw new SOSInternalException("",SOSInternalException.GETOBSERVATION_REQUEST_CREATE_FAILED, "Response format must be inline|out-of-band|attached|resultTemplate");
			}	
			return responseMode;
		}
		return null;
	}
}
