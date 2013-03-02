package org.gvsig.sos.lib.impl.objectmodel;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Offering;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.sos.lib.api.client.ServiceProvider;
import org.gvsig.sos.lib.impl.communication.GetCapabilitiesParameters;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandler;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandlerExtended;
import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.exceptions.CapabilitiesParserException;
import org.gvsig.sos.lib.impl.exceptions.CapabilitiesRequestCreationException;
import org.gvsig.sos.lib.impl.parsers.SOSInternalParserException;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.DomainType;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_AllowedValues;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_Operation;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.ValueType;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType;
import org.gvsig.tools.service.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * High level class containing the information related with a SOS server (i.e
 * its related Capabilities information, Offerings etc.).
 * 
 * @author lrodriguez
 * 
 */
public class DefaultSOSClient implements MutableSOSClient {

	private static final Logger logger = LoggerFactory.getLogger(DefaultSOSClient.class);
	
	private Element_Capabilities capDoc;
	private List<Offering> offerings = null;
	private URL serverAddress;
	private SOSCommunicationHandler client;
	private ServiceProvider provider;
	private Map<String, Procedure> proceduresMap = new HashMap<String, Procedure>();
	private Map<String, ObservedProperty> propertiesMap = new HashMap<String, ObservedProperty>();
	private File cacheFolder;
	private Manager manager; 

	private static String CAPABILITIES_SRS_PARAM_NAME = "srsName";
	private static String CAPABILITIES_DEFAULT_SRS_NAME = "4326";
		
	List<Procedure> getProcedures(List<ReferenceType> proceduresReference) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		for(ReferenceType r: proceduresReference){
			if (!proceduresMap.containsKey(r.getHref())) {
				MutableProcedure sp = new DefaultSOSProcedure(r.getHref(), client, this);
				procedures.add(sp);
			}
			else {
				procedures.add(proceduresMap.get(r.getHref()));
			}
		}
		return procedures;
	}

	public Procedure getProcedureByName(String procedureName) {
		if (proceduresMap.containsKey(procedureName)) {
		    return proceduresMap.get(procedureName);
		}
		else {
		  return null;
		}
	}

	
	List<ObservedProperty> getObservedProperties(List<PhenomenonPropertyType> propertiesReference) {
		List<ObservedProperty> properties = new ArrayList<ObservedProperty>();
		for(PhenomenonPropertyType property: propertiesReference){
			String name = DefaultSOSObservedProperty.getNameFromPhenomenonPropertyType(property); 
			if (!propertiesMap.containsKey(name)) {
				ObservedProperty sp = new DefaultSOSObservedProperty(property, "", "", this);
				properties.add(sp);
			}
			else {
				properties.add(propertiesMap.get(name));
			}
		}
		return properties;
	}

	/**
	 * Registers the procedure with the client so that it can be retrieved later
	 * by its name.
	 * @param proc the procedure to be registered
	 * @param name the name to use for registering. 
	 * @return the procedure registered.
	 */
	public Procedure registerProcedure(Procedure proc, String name){
		return proceduresMap.put(name, proc);
	}

	/**
	 * Allows to obtain a previously registered property by its name. 
	 * @param name the name of the property.
	 * @param units the units it was registered with
	 * @return the property found with such features (name, units)
	 */
	public ObservedProperty getProperty(String name, String units){
		return getProperty(null, name, units);
	}
	
	/**
	 * Registers or retrieve an observed properties and registers it with the client. 
	 * @param observedProperty the observed property parser object.
	 * @param name the name of the property.
	 * @param units the units 
	 * @return the observed property retrieved.
	 */
	public ObservedProperty getProperty(PhenomenonPropertyType observedProperty, String name, String units){
		ObservedProperty property = null;
		if (propertiesMap.containsKey(name)){
			 property = propertiesMap.get(name);
			 ((MutableObservedProperty)property).setMeasurementUnit(units);
			 return property;
		} 
		else {
		  property = new DefaultSOSObservedProperty(observedProperty, name, units, this);
		  propertiesMap.put(name, property);
		  return property;
		}
	}
	
	/**
	 * Retrieves a property from the registered properties by its name.
	 * @param name the name of the property. 
	 * @return the property with the name specified or null if the property is not found.
	 */
	public ObservedProperty getPropertyByName(String name){
		ObservedProperty property = null;
		if (propertiesMap.containsKey(name)){
			 property = propertiesMap.get(name);
			 return property;
		} 
		return null;
	}
	
	private void fillOfferings() {
		List<ObservationOfferingType> offeringsType = capDoc.getContents()
				.getObservationOfferingList().getObservationOfferingList();
		for (ObservationOfferingType offeringType : offeringsType) {
			Offering offering = new DefaultSOSOffering(offeringType, client, this);
			offerings.add(offering);
		}
	}
	
	/**
	 * Creates a new instance of SOSClient with the specified server address.
	 * @param serverAddress the URL with address of the SOS service.
	 */
	public DefaultSOSClient(URL serverAddress) {
		this.serverAddress = serverAddress;
		this.client = new SOSCommunicationHandlerExtended(serverAddress);
		this.offerings = new ArrayList<Offering>();
	}
	
	/**
	 * Creates a new instance of SOSClient with the specified server address and the specified 
	 * cacheFolder. 
	 * @param host the URL of the host containing the SOS service.
	 * @param cacheFolder the folder used for the observations' cache. 
	 */
	public DefaultSOSClient(URL host, File cacheFolder) {
		this(host);
		if (!cacheFolder.isDirectory()){
			throw new RuntimeException("The file (cacheFolder) specified must be a directory");
		}
		this.cacheFolder = cacheFolder;
	}

	//TODO: Check how to connect this version with the manager interface and implementation.
	public DefaultSOSClient(Manager manager, URL host, File cacheFolder) {
		this(host, cacheFolder);
		this.manager = manager;
	}

	/**
	 * Gets the cache folder configured or by default the current directory of the application.   
	 * @return
	 */
	public File getCacheFolder(){
		if (cacheFolder == null){
			//this is used in case it is not specified
			cacheFolder = new File("."/*System.getProperty("user.dir")*/);
		}
		return cacheFolder;
	}

	/**
	 * Gives the address of the SOS server.
	 * 
	 * @return the SOS server address.
	 */
	public URL getServerAddress() {
		return serverAddress;
	}

	/**
	 * Gives the name of the server as exposed in the capabilities document.
	 * 
	 * @return the name of the service.
	 * @throws SOSException 
	 */
	public String getName() throws SOSException {
		checkConnect();
		return capDoc.getServiceIdentification().getTitleList().get(0)
				.getValue();
	}

	/**
	 * Sets the client object used to retrieve the server information.
	 * 
	 * @param sosClient
	 *            the client object.
	 */
	public void setClient(SOSCommunicationHandler sosClient) {
		this.client = sosClient;
	}

	/**
	 * Gives the client object used to retrieve the server information.
	 * 
	 * @return
	 */
	public SOSCommunicationHandler getClient() {
		return client;
	}

	/**
	 * Allow accessing the offerings of the server by its name.
	 * 
	 * @param name
	 * @return the offering having the name specified
	 * @throws SOSException 
	 */
	public Offering getOfferingByName(String name) throws SOSException {
		for (Offering o : this.getOfferings())
			if (o.getName().equals(name))
				return o;
		return null;
	}

	public String toString() {
		try {
			return getName();
		} catch (SOSException e) {
			logger.info("Error while accessing the name of the service client", e);
		}
		return  super.toString();
	}

	/**
	 * Gives the capabilities document object.
	 * 
	 * @return the capabilities retrieved (an instance of Element_Capabilities)  
	 */
	public Element_Capabilities getCapabilitiesInfo() {
		return capDoc;
	}

	private void doInitialization() {
		fillOfferings();
		provider = new DefaultServiceProvider(capDoc);
	}

	/**
	 * Connects and retrieves the capabilities existing in the specified SOS server.
	 */
	public void connect() throws SOSException{
		GetCapabilitiesParameters gcParams = new GetCapabilitiesParameters();
		client.setHost(serverAddress);
		try {
			client.connect();
			capDoc = ((SOSCommunicationHandlerExtended) client)
					.getCapabilitiesExtended(gcParams);
		} catch (SOSInternalException e) {
            throw new CapabilitiesRequestCreationException(e);
		} catch (SOSInternalParserException e) {
			throw new CapabilitiesParserException(e);
		}
		doInitialization();
	}

	public void setTemporalFolder(File temporalFolder) {
		this.cacheFolder = temporalFolder;
	}

	public String getAbstract() throws SOSException {
		checkConnect();
		String result = "";
		String sep = "";
		if (capDoc.getServiceIdentification() != null) {
			for (LanguageStringType ls : capDoc.getServiceIdentification()
					.getAbstractList()) {
				result += sep + ls.getValue();
				sep = ", ";
			}
		}
		return result;
	}

	public List<String> getKeywords() throws SOSException {
		checkConnect();
		List<String> result = new ArrayList<String>();
		if (capDoc.getServiceIdentification() != null) {
			for (LanguageStringType ls : capDoc.getServiceIdentification()
					.getKeywordsList().getKeywordList()) {
				result.add(ls.getValue());
			}
		}
		return result;
	}

	public String getVersion() throws SOSException {
		checkConnect();
		String result = "";
		String sep = "";
		if (capDoc.getServiceIdentification() != null) {
			for (String ls : capDoc.getServiceIdentification()
					.getServiceTypeVersionList()) {
				result += result + sep + ls;
				sep = ", ";
			}
		}
		return result;
	}

	public List<Offering> getOfferings() throws SOSException {
		checkConnect();
		return offerings;
	}

	public ServiceProvider getProvider() throws SOSException {
		checkConnect();
		return provider;
	}

	public File getTemporalFolder() {
		return getCacheFolder();
	}

	public void setAbstract(String abstractTxt) {

	}

	public void setKeywords(List<String> keywords) {

	}

	public void setVersion(String version) {

	}

	public void setOfferings(List<Offering> offerings) {
		this.offerings = offerings;
	}

	public void setProvider(ServiceProvider provider) {
		this.provider = provider;
	}

	public String getAllowedSRS(){
		Element_AllowedValues  values = null;
		for (Element_Operation operation : capDoc.getOperationsMetadata().getOperationList()){
			for (DomainType domain : operation.getParameterList()){
				if (domain.getName().equals(CAPABILITIES_SRS_PARAM_NAME)){
				   values = domain.getAllowedValues();
				}
			}
		}
		
		//if was not found a value
		String defaultValue = null;
		if (values != null && values.getValueList()!= null){
			defaultValue = null;
			for (ValueType value: values.getValueList()){
				defaultValue = value.getValue();
				if (value.getValue().contains(CAPABILITIES_DEFAULT_SRS_NAME)){
					return value.getValue();
				}
			}
		}
        //if is not listed EPSG:4326 then the last one is shown  
		return defaultValue;
	}
	
	
	public Manager getManager() {
		return manager;
	}
	
	private void checkConnect() throws SOSException {
		if (capDoc== null){
			connect();
		}
	}
	
	
}
