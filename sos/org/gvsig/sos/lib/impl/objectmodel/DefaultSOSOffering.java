package org.gvsig.sos.lib.impl.objectmodel;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.cresques.cts.IProjection;
//import org.gvsig.fmap.crs.CRSFactory;
//import org.gvsig.fmap.geom.Geometry;
//import org.gvsig.fmap.geom.GeometryLocator;
//import org.gvsig.fmap.geom.exception.CreateEnvelopeException;
//import org.gvsig.fmap.geom.primitive.Envelope;
import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.sos.lib.api.client.DeclaredObservedProperty;
import org.gvsig.sos.lib.api.client.FeatureOfInterest;
import org.gvsig.sos.lib.api.client.ObservationSet;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.sos.lib.impl.communication.GetObservationParams;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandler;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandlerExtended;
import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.communication.request.getobservation.SpatialFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.TemporalFilter;
import org.gvsig.sos.lib.impl.communication.request.getobservation.TemporalFilter.TEMPORAL_FILTER_TYPE;
import org.gvsig.sos.lib.impl.data.FiltersHelper;
import org.gvsig.sos.lib.impl.data.ObservationsCacheIterator;
import org.gvsig.sos.lib.impl.data.ObservationsIterator;
import org.gvsig.sos.lib.impl.data.ObservationsIterator.ObservationsIteratorDelegate;
import org.gvsig.sos.lib.impl.exceptions.GetObservationRequestCreationException;
import org.gvsig.sos.lib.impl.exceptions.OMNotSupportedException;
import org.gvsig.sos.lib.impl.exceptions.OMParserException;
import org.gvsig.sos.lib.impl.exceptions.ProtocolHandlerException;
import org.gvsig.sos.lib.impl.exceptions.ServerSWEException;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.gvsig.sos.lib.impl.parsers.SOSInternalParserException;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.EnvelopeType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePositionType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.gvsig.timesupport.RelativeInstant;
import org.gvsig.timesupport.RelativeInterval;
import org.gvsig.timesupport.Time;
import org.gvsig.timesupport.TimeSupportLocator;
import org.gvsig.tools.locator.LocatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;

public class DefaultSOSOffering extends DefaultSOSBasic implements MutableOffering {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultSOSOffering.class);
	private final ObservationOfferingType offering;
	private List<Procedure> procedures;
	private List<ObservedProperty> observedProperties;
	private Time time;
	private Envelope location;
	private SOSCommunicationHandler client;
	private Map<String, FeatureOfInterest> featuresMap = new HashMap<String, FeatureOfInterest>();
	private boolean getObservationExecuted = false;
	private static String EPSG_CONST = "EPSG"; 
	
	public DefaultSOSOffering(ObservationOfferingType offering2, SOSCommunicationHandler commClient, 
			MutableSOSClient parent) {
		super(offering2.getId());
		this.offering = offering2;
		super.setParent(parent);
		this.client = commClient;
		fillData();
	}
	
	/**
	 * Retrieves a registered feature of interest for this vales (identifier) 
	 * and setting its position. If the feature already exists the position value 
	 * might be updated given that sometimes after retrieving the observations the 
	 * feature could incorporate information about the location.
	 * @param position the position of the feature.
	 * @param identifier the identifier of the feature.
	 * @return the updated or created feature of interest with the data set.
	 */
	public FeatureOfInterest getFeatureOfInterest(PointType position, String identifier){
		FeatureOfInterest feature = null;
		if (featuresMap.containsKey(identifier)){
			 feature = featuresMap.get(identifier);
			 if (position!= null) {
			   ((DefaultFeatureOfInterest)feature).setPointLocation(position);
			 }
			 return feature;
		} 
		else {
		  feature = new DefaultFeatureOfInterest(position, identifier);
		  featuresMap.put(identifier, feature);
		  return feature;
		}
	}

	public FeatureOfInterest findFeatureOfInterest(String identifier){
		FeatureOfInterest feature;
		if (featuresMap.containsKey(identifier)){
			 feature = featuresMap.get(identifier);
			 return feature;
		} 
		else return null;
	}

	public FeatureOfInterest getFeatureOfInterest(String identifier){
		return getFeatureOfInterest(null, identifier);
	}

	public String getName() {
		if (offering.getNameList()!= null && offering.getNameList().size()>0){
			return offering.getNameList().get(0).getValue();	
		}
		else
		return getIdentifier();
	}
	
	private void fillData(){
		if(offering.getDescription() != null) {
           //TODO: Check what to do with the description
		}
		EnvelopeType envelope = offering.getBoundedBy().getEnvelope();
		
        location = toEnvelope(envelope);

		time = toTime(offering.getTime());

		//TODO: probably check the response format in order to 
		//asses if it is possible to process the responses of this server
		//DefaultSOSResponseFormat rf = new DefaultSOSResponseFormat(offering.getResponseFormatList(), this);
	}
	
	private Time toTime(TimeGeometricPrimitivePropertyType timeType) {
		if (timeType==null) {
			return null;
		} 
		else {
			boolean isPeriod = (timeType.getTimePeriod()!=null);
			Time gvsigTime = null;
			RelativeInstant startInstant = null; 
			RelativeInstant endInstant = null;
			//begin time 
			if((timeType.getTimePeriod() != null)) 
				startInstant =  toRelativeInstant(timeType.getTimePeriod().getBeginPosition());
			else if (timeType.getTimeInstant()!=null) {
				startInstant =  toRelativeInstant(timeType.getTimeInstant().getTimePosition());
			}
			
			//end time 
			if (isPeriod && (timeType!= null) && (timeType.getTimePeriod().getEndPosition()!= null))
				endInstant = toRelativeInstant(timeType.getTimePeriod().getEndPosition());
			
			if (isPeriod) {
			  gvsigTime = TimeSupportLocator.getManager().createRelativeInterval(startInstant, endInstant);
	        }
			else {
				gvsigTime = startInstant;
			}
			return gvsigTime;
		}
	}
	
	private RelativeInstant toRelativeInstant(TimePositionType timePosition){
	    String valueStr = timePosition.getValue();
	    if (valueStr.equals("") && timePosition.getAttribute().equalsIgnoreCase("now")){
	    	valueStr = timePosition.getAttribute();
	    }
	    return Utils.parseDateTimeStringToInstant(valueStr);
	}
	
	private Envelope toEnvelope(EnvelopeType envelope) {
		
		Double lowerCornerX = 0.0;
		Double lowerCornerY = 0.0;
		Double upperCornerX = 0.0;
		Double upperCornerY = 0.0;
		int envelopeDefined = 0;
		
		if (envelope.getLowerCorner()!= null && envelope.getLowerCorner().getValueList().size()>=2) {
			lowerCornerX = envelope.getLowerCorner().getValueList().get(0);
			lowerCornerY = envelope.getLowerCorner().getValueList().get(1);
			envelopeDefined ++;
		}
		else {
			logger.info("Problems Offering BBOX, component lower corner is not defined: " +
					"envelope.getLowerCorner()!= null -> " + (envelope.getLowerCorner()!= null) + " "+ 
					"envelope.getLowerCorner().getValueList().size()>=2 -> " + (envelope.getLowerCorner().getValueList().size()>=2));
		}
		if (envelope.getUpperCorner()!=null && envelope.getUpperCorner().getValueList().size() >= 2) {
			upperCornerX = envelope.getUpperCorner().getValueList().get(0);
			upperCornerY = envelope.getUpperCorner().getValueList().get(1);
			envelopeDefined++;
		}
		else {
			logger.info("Problems Offering BBOX, component upper corner is not defined: " +
					"envelope.getUpperCorner()!=null  ->" + (envelope.getUpperCorner()!=null) + " " +
					"envelope.getUpperCorner().getValueList().size() >= 2 ->" + " " + (envelope.getUpperCorner().getValueList().size() >= 2));
		}
		
		Envelope resultEnv = null;

		if (envelopeDefined == 2) {
			try {
				Double minX = Math.min(lowerCornerX, upperCornerX);
				Double minY = Math.min(lowerCornerY, upperCornerY);
				Double maxX = Math.max(lowerCornerX, upperCornerX);
				Double maxY = Math.max(lowerCornerY, upperCornerY);
                
				//create envelope
				Coordinate p1 = new Coordinate(minY, minX);
				Coordinate p2 = new Coordinate(maxY, maxX);
				resultEnv = new Envelope(p1, p2);
//				resultEnv = GeometryLocator.getGeometryManager()
//						.createEnvelope(minY, minX, maxY, maxX,
//								Geometry.SUBTYPES.GEOM2D);

			} catch (LocatorException e) {
				logger.info("Error creating envelope, accessing geometry API", e);
//			} catch (CreateEnvelopeException e) {
			} catch (Exception e) {
				logger.info("Error creating envelope, , accessing geometry API", e);
			}
		}
        return resultEnv; 
	}
	
	public String toString() {
		return getName();
	}
	
	public ObservationOfferingType getOffering() {
		return offering;
	}
	
	public List<Procedure> getProcedures() {
		if(procedures == null) {
			//DefaultSOSProcedure.fromReferenceList(offering.getProcedureList(), client);
			//get the cached procedures
			procedures = ((DefaultSOSClient)getParent()).getProcedures(offering.getProcedureList());
		}
		return procedures;
	}
	
	public List<ObservedProperty> getObservedProperties() {
		return getObservedPropertiesInternal(true);
	}

	private List<ObservedProperty> getObservedPropertiesInternal(boolean complainOnNotGetObservation) {
		if (complainOnNotGetObservation && !getObservationExecuted ){
			return null;
		}
		if(observedProperties == null)
			observedProperties = ((DefaultSOSClient)getParent()).getObservedProperties(offering.getObservedPropertyList());
		//DefaultSOSObservedProperty.fromPhenomenonPropertyType(offering.getObservedPropertyList());
		return observedProperties;
	}

	
	
	public Procedure getProcedureById(String procedureId){
		for (Procedure procedure : getProcedures()) {
			if (((DefaultSOSProcedure)procedure).getName().equalsIgnoreCase(procedureId)) {
				return procedure;
			}
		}
		return null;
	}

	public String getIdentifier() {
		return offering.getId();
	}


	public Envelope getLocation() {
		return location;
	}

	public Time getTime() {
		return time;
	}
	
	public static String OM_SAMPLING_TIME = "om:samplingTime";

	public ObservationSet getObservations(List<DeclaredObservedProperty> observedProperties,
								List<Procedure> procedures, Time timeForFiltering,
								Envelope spatialFilter) throws SOSException{

		//Add the temporal filters if specified.
		TemporalFilter temporalFilter = null;
		if (timeForFiltering!= null) {
			
			boolean periodFilter = timeForFiltering instanceof RelativeInterval;
			
			
	        RelativeInstant startInstant = null; 
	        RelativeInstant endInstant = null;
          
			if (periodFilter) {
	           startInstant = ((RelativeInterval)timeForFiltering).getStart();
	           endInstant = ((RelativeInterval)timeForFiltering).getEnd();
			}
			else {
			    startInstant = ((RelativeInstant)timeForFiltering);    	
			}
			
			String timeProperty = OM_SAMPLING_TIME;

			if (!periodFilter) {
			   temporalFilter = FiltersHelper.createTemporalInstantFilter(timeProperty, 
					   			TEMPORAL_FILTER_TYPE.TM_EQUALS, startInstant.toString(FiltersHelper.ISODatePattern));
			}
			else {
			   temporalFilter = FiltersHelper.createTemporalPeriodFilter(timeProperty, 
					            TEMPORAL_FILTER_TYPE.TM_DURING, startInstant.toString(FiltersHelper.ISODatePattern), endInstant.toString(FiltersHelper.ISODatePattern));	
			}
		}
		
		//Add the spatial filter 
		SpatialFilter spatial = null;
		if (spatialFilter!= null) {

			Coordinates upperCorner = new Coordinates();
			double x = spatialFilter.getMaxX();
			double y = spatialFilter.getMaxY();
//			double x = spatialFilter.getUpperCorner().getX();
//			double y = spatialFilter.getUpperCorner().getY();
            
			//upper corner.. x and y in this case are twisted.
			upperCorner.setX(y);
            upperCorner.setY(x);

			x = spatialFilter.getMinX();
			y = spatialFilter.getMinY();
//			x = spatialFilter.getLowerCorner().getX();
//			y = spatialFilter.getLowerCorner().getY();

			Coordinates lowerCorner = new Coordinates();
            //lower corner ..			
			lowerCorner.setX(y);
            lowerCorner.setY(x);
            
            String spatialProperty = "urn:ogc:data:location";
            String srsName = inferSrsName(); //schema:urn:ogc:def:crs:EPSG::number
            
            //"46.611644 7.6103", "51.9412 13.883498"
			spatial = FiltersHelper.createEnvelopeSpatialFilter(spatialProperty,
					lowerCorner, upperCorner, srsName);
		}
		
		ObservationSet result = getObservationsInternal(observedProperties, procedures, temporalFilter, spatial);
		getObservationExecuted = true;
		return result;
	}
	
	
	public ObservationSet getObservationsInternal(
			List<DeclaredObservedProperty> observedProperties,
			List<Procedure> procedures, TemporalFilter temporalFilter,
			SpatialFilter spatialFilter) throws SOSException {

		GetObservationParams params = new GetObservationParams();
		params.setOffering(this.getIdentifier());

		// Add the observed properties necessary
		for (DeclaredObservedProperty observedProperty : observedProperties) {
			String observedPropertyName = observedProperty.getIdentifier();
			params.addObservedProperty(observedPropertyName);
		}

		// Add the procedures if specified
		if (procedures != null) {
			for (Procedure procedure : procedures) {
				// TODO: check this!, it might need to include a new method in
				// the
				// API for getting the identifier of the procedure.
				params.addProcedure(procedure.getIdentifiers().get(0));
			}
		}

		// Add the temporal filters if specified.
		if (temporalFilter != null) {
			params.addTemporalFilter(temporalFilter);
		}

		// Add the spatial filter
		if (spatialFilter != null) {
			params.setSpatialFilter(spatialFilter);
		}

		// Setup the response format
		String queryResponseFormat = "";

		for (String responseFormat : offering.getResponseFormatList()) {
			if (responseFormat.contains("om/")) {
				queryResponseFormat = responseFormat;
				break;
			}
		}

		if (queryResponseFormat.equals("")) {
			throw new OMNotSupportedException();
		}

		params.setResponseFormat(queryResponseFormat);
		params.setResultModel("om:Observation");
		params.setResponseMode("inline");

		// retrieve the observations and get the datasets
		try {
			SOSCommunicationHandlerExtended clientExtended = ((SOSCommunicationHandlerExtended) client);
			// clientExtended.setDebug(true);
			ObservationCollectionType collection = (clientExtended)
					.getObservationExtended(params);

			// get the cache path
			String tempCacheFilePath = getCachePath();

			// create the iterator
			ObservationsIteratorDelegate it = new ObservationsCacheIterator(
					tempCacheFilePath, getParentSOSClient());
			return new ObservationsIterator(collection, this, it);

		} catch (SOSInternalParserException pe) {
			throw new OMParserException(pe);
		} catch (KeyManagementException e) {
			throw new ProtocolHandlerException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new ProtocolHandlerException(e);
		} catch (IOException e) {
			throw new ProtocolHandlerException(e);
		} catch (InternalSWEException e) {
			throw new ServerSWEException(e);
		} catch (SOSInternalException e) {
			throw new GetObservationRequestCreationException(e);
		}
	}	
	
	
	private String cachePath = "";
	private String getCachePath(){
		if (cachePath.equals("")) {
			Object parent = getParent();
			if (parent instanceof DefaultSOSClient) {
				cachePath = ((DefaultSOSClient)parent).getCacheFolder().getAbsolutePath();
			}
		}
		return cachePath;
	}
	
	private String inferSrsName()
	{
		//default
		String srsName = "urn:ogc:def:crs:EPSG::4326"; //schema:urn:ogc:def:crs:EPSG::number

		//setting up the srsName to the declared in the capabilities
		EnvelopeType envelope = (offering.getBoundedBy()!=null)?offering.getBoundedBy().getEnvelope(): null;
		
		if (envelope!= null){
		  srsName = ((envelope.getSrsName()!= null) && !(envelope.getSrsName().equals("")))?envelope.getSrsName(): srsName;
		}
        return srsName;
	}	
	
	private String toShortDefinition(String srsName){
		String [] parts = srsName.split(":");
		return EPSG_CONST + ":" + parts[parts.length-1];
	}
	
	private DefaultSOSClient getParentSOSClient() {
	  return (DefaultSOSClient) getParent();	
	}

	public ObservationSet getObservations(
			List<DeclaredObservedProperty> observedProperties, Time timeForFiltering,
			Envelope spatialFilter) throws SOSException {
		return getObservations(observedProperties, null, timeForFiltering, spatialFilter);
	}


	public ObservationSet getObservations(
			List<DeclaredObservedProperty> observedProperties, Envelope spatialFilter) throws SOSException{
		return getObservations(observedProperties, null, spatialFilter);
	}

	public ObservationSet getObservations(
			List<DeclaredObservedProperty> observedProperties, Time timeForFiltering) throws SOSException{
		return getObservations(observedProperties, null, timeForFiltering, null);
	}

	public ObservationSet getObservations(
			List<DeclaredObservedProperty> observedProperties) throws SOSException {
		return getObservationsInternal(observedProperties, null, null, null);
	}


	/* Other methods that probably wont be necessary
	 * */
	public void setName(String name) {
		
	}


	public void setIdentifier(String identifier) {
		
	}


	public void setLocation(Envelope location) {
		
	}


	public void setTime(Time time) {
		
	}


	public List<FeatureOfInterest> getFeaturesOfInterest() {
		return new ArrayList<FeatureOfInterest>(featuresMap.values());
	}

//	public IProjection getSRS() {
//		String epsgCode = toShortDefinition(inferSrsName());
//		IProjection projection = CRSFactory.getCRS(/*"EPSG:4326"*/epsgCode);
//		return projection;
//	}

	public List<DeclaredObservedProperty> getDeclaredObservedProperties() {
		List<ObservedProperty> props = getObservedPropertiesInternal(false);
		List<DeclaredObservedProperty> result = new ArrayList<DeclaredObservedProperty>();
		result.addAll(props);
		return result;
	}

	@Override
	public void setProcedures(List<Procedure> procedures) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setObservedProperties(List<ObservedProperty> observedProperties) {
		// TODO Auto-generated method stub
		
	}
}
