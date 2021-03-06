package org.gvsig.sos.lib.impl.data;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import org.gvsig.fmap.geom.primitive.Point;
import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.sos.lib.api.client.DeclaredObservedProperty;
import org.gvsig.sos.lib.api.client.FeatureOfInterest;
import org.gvsig.sos.lib.api.client.ObservationValue;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Offering;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.sos.lib.impl.data.ObservationsIterator.ObservationsIteratorDelegate;
import org.gvsig.sos.lib.impl.exceptions.CacheException;
import org.gvsig.sos.lib.impl.objectmodel.DefaultObservationValue;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSClient;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSOffering;
import org.gvsig.sos.lib.impl.objectmodel.Utils;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.gvsig.timesupport.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Point;


/**
 * Class representing an iterator that can iterate over stored observations. 
 * The storage is performed using an ObservationsOutputStream and iteration is done 
 * by using an ObervationsInputStream. This class persist the observations included through 
 * the addObservations value method and afterwards perform the iteration over the observations
 * persisted in the cache. In the iteration process the iterator attaches the information
 * (i.e FeatureOfInterest and Procedures) that is initially detached from the observations values.   
 * @author lrodriguez
 *
 */
public class ObservationsCacheIterator implements ObservationsIteratorDelegate {

	private static Logger logger = LoggerFactory.getLogger(ObservationsCacheIterator.class);
	private DefaultSOSClient client;
	private ObservationsOutputStream writer;
	private ObservationsInputStream reader;
	private String fileCacheId;
	private String cacheFileName;
	private CacheIndex cacheIndex;
    String fileMode = "rw";
	
    /**
     * Creates a cache iterator in a certain path. Uses the client specified for attaching the feature of interest 
     * and other information while iterating over the persisted observations values. 
     * @param cachePath the path where the cache should be kept.
     * @param client the client from where the information can be obtained.
     * @throws SOSException
     */
	public ObservationsCacheIterator(String cachePath, DefaultSOSClient client) throws SOSException{
	    this.client = client;
	    fileCacheId = Long.toString(Calendar.getInstance().getTimeInMillis());
	    this.cacheFileName = includeBackSlash(cachePath)+ fileCacheId + ".obsc";
	    this.cacheIndex = new CacheIndex();
        createWriter();	    
	}
	
	private void createWriter() throws SOSException{
	    try {
			writer = new ObservationsOutputStream(new RandomAccessFile(cacheFileName, fileMode), cacheIndex);
			/*new ObjectOutputStream(new FileOutputStream(cacheFileName));*/
		} 
	    catch (IOException e) {
			throw new CacheException(e);
		}    
	}
	
	private void closeWriter(){
		try {
			writer.close();
		} catch (IOException e) {
			//nothing to do, the writes
			logger.info("Error closing the writer in Observations cache iterator", e);
		}
	}
	
	private void createReaderIfNull() throws SOSException {
		if (reader== null) {
			try {
				reader = new ObservationsInputStream(new RandomAccessFile(cacheFileName, fileMode), cacheIndex, cacheFileName); 
			} catch (IOException e) {
				throw new CacheException(e);
			}    
        }
	}
	
	private String includeBackSlash(String path) {
		if (!path.endsWith(File.separator)){
			return path + File.separator;
		}
		return path;
	}
	
//	public boolean hasNext() {
//		boolean result = countIterated < cacheIndex.getCount();
//		if (!result) {
//			if (reader!= null) {
//			  reader.close();
//			}
//			//erase the local map
//			clearFeaturesMap();
//		}
//		return result;
//	}

//	public ObservationValue next() {
//		if (hasNext()) {
//			WriteableObservation rawObs;
//			try {
//				rawObs = readObservationAt(countIterated++);
//				return getObservationValue(rawObs);//by now
//			} catch (SOSException e) {
//			}
//		}
//		return null;
//	}
	
	public Iterator <ObservationValue> iterator(){
		return new MyIterator(this);
	}
	
	public Iterator<ObservationValue> iterator(long index){
		return new MyIterator(this, index);
	}
	
    public long getCount(){
    	return cacheIndex.getCount();
    }
	
	private class MyIterator implements Iterator<ObservationValue> {
		private ObservationsCacheIterator observations;
		private int countIterated;
		
		public MyIterator (ObservationsCacheIterator observations) {
			this.observations = observations;
			countIterated = 0;
		}

		public MyIterator(ObservationsCacheIterator observations,
				long index) {
			this(observations);
			countIterated = (int) index;
		}
		
		/**
		 * Gives true if there is a next element to iterate to.
		 * @return true if there is a next element otherwise returns false.
		 */

		public boolean hasNext() {
			boolean result = countIterated < observations.cacheIndex.getCount();
			return result;
		}
		
		/**
		 * Iterated to the next observation value.
		 * @return an observation value if there is a next element, otherwise null is returned.
		 */

		public ObservationValue next() {
			if (hasNext()) {
				WriteableObservation rawObs;
				try {
					rawObs = readObservationAt(countIterated);
					DefaultObservationValue value = (DefaultObservationValue)getObservationValue(rawObs);
					value.setOid(countIterated);
					countIterated++;
					return value; 
				} catch (SOSException e) {
					throw new RuntimeException(e);
				}
			}
			return null;
		}

		public void remove() {
			throw new UnimplementedFeatureException("Remove method is not implemented in the ObservationsCacheIterator class.");
		}
	}

	/**
	 * Gets an observation object from an persisted observation. This process include the re-attachment 
	 * of the information related to the feature of interest, position, procedure and observed property.  
	 * @param rawObs the persisted observation object.
	 * @return the observation value.
	 * @throws SOSException
	 */
	private ObservationValue getObservationValue(WriteableObservation rawObs) throws SOSException{
		//here is where the client comes to play
		ObservationValue result = null;
		if (rawObs!= null) {
			//find the feature of interest given the position
			FeatureOfInterest feature = getFeatureOfInterest(rawObs.fOIIdentifier);
			
			//apparently there is not reason for creating a new one, so lets check it
			assert testTheSame(feature.getLocation(), rawObs.fOILocation);
			/*new DefaultFeatureOfInterest(rawObs.fOILocation, rawObs.fOIIdentifier);*/
	
			Procedure procedure = client.getProcedureByName(rawObs.procedureIdentifier);
	
	        ObservedProperty observedProperty = client.getPropertyByName(rawObs.observedPropertyIdentifier);
			
	        Object obsValue = rawObs.value;
	        
	        Time time = Utils.parseDateTimeStringToInstant(rawObs.samplingTime);
	   
	        //create the observation value.
			result = new DefaultObservationValue(obsValue, time, 
					feature, observedProperty, procedure);
		}
		return result;
	}
	
	private static class UnimplementedFeatureException extends RuntimeException{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7137405408164090442L;

		public UnimplementedFeatureException(String message){
			super(message);
		}
	} 
	
	private Map<String, FeatureOfInterest> localFeatures = new HashMap<String, FeatureOfInterest>(); 
	
	private void clearFeaturesMap(){
		if (localFeatures!= null) {
		    localFeatures.clear();
		}
	}
	
	public void dispose(){
		if (reader!= null) {
			reader.close();
		}
		//erase the local map
		clearFeaturesMap();
	}
	
	private FeatureOfInterest getFeatureOfInterest(String identifier) throws SOSException{
		
		   if (localFeatures.containsKey(identifier)) {
			   return localFeatures.get(identifier);
		   }
		  
		   for(Offering offering :  client.getOfferings()){
			   FeatureOfInterest feature = ((DefaultSOSOffering)offering).findFeatureOfInterest(identifier);
			   if (feature!= null) {
				   //add it to the local map
				   localFeatures.put(identifier, feature);
				   return feature;
			   }
		   }
		   throw new RuntimeException ("Can not find feature, this should not happen");
	}
	
	/**
	 * This method adds observations to the cache including information related with it 
	 * (i.e. the feature of interest and its location, the observed property related to 
	 * the observation and the procedure).
	 * This information is detached from the object for persisting and re-attached while 
	 * iterating and restoring the object to memory. 
	 * @param value the value of the observation
	 * @param time  the time of the observation.
	 * @param featureOfInterest the feature of interest object related to the observation.
	 * @param observedProperty the observed property object related to the observation.
     * @param procedure the procedure object related to the observation.
	 */
	public void addObservationValue(Object value, Time time,
			FeatureOfInterest featureOfInterest,
			DeclaredObservedProperty observedProperty, Procedure procedure) {
	
		 //get the location
		Coordinates fOILocation = locationToCoordinates(featureOfInterest.getLocation());
		 
		 //get feature of interest identifier
		 String fOIIdentifier = featureOfInterest.getIdentifier();
		 
		 //get the observed property identifier
		 String observedPropertyIdentifier = observedProperty.getIdentifier();
		 
		 //get the procedure identifier
		 String procedureIdentifier = procedure.getId();
		 
		 // get the sampling time 
		 String samplingTime = time.toString();
		 
		 //create the persistent object containing all the values need to restore it later
		 WriteableObservation obs = new WriteableObservation(samplingTime, value, fOILocation, 
				 fOIIdentifier, observedPropertyIdentifier, procedureIdentifier);
		 
		 try {
			//write the object. 
			writer.writeObject(obs);
			//TODO: Do this
//			writer.writeObject(samplingTime, value, fOILocation, 
//					 fOIIdentifier, observedPropertyIdentifier, procedureIdentifier);
		 } catch (IOException e) {
			//e.printStackTrace();
			//the interface does not includes any interface
			throw new RuntimeException(e);
		 }
	}
	
	private Coordinates locationToCoordinates(Object location){
		 Point point = (Point)location;
		 Coordinates fOILocation = new Coordinates();
		 fOILocation.setX(point.getX());
		 fOILocation.setY(point.getY()); 
		 fOILocation.setZ(0.0);
		 return fOILocation;
	}

//  Not used..	
//	private Coordinates coordinatesFromString(String coordinatesStr){
//		String cleanCoords = coordinatesStr.replace("(", "").
//				replace(")", "").replace(" ", "");
//		String [] splitCoords = cleanCoords.split(",");
//		double x = Double.parseDouble(splitCoords[0]);
//		double y = Double.parseDouble(splitCoords[1]);
//		double z = Double.parseDouble(splitCoords[2]);
//		Coordinates result = new Coordinates();
//		result.setX(x);
//		result.setY(y);
//		result.setZ(z);
//		return result;
//	}
	
	private boolean equalsCoordinates(Coordinates c1, Coordinates c2){
		return c1.getX() == c2.getX() && c1.getY() == c2.getY() && c1.getZ() == c2.getZ();
	}
	
	/**
	 * Reads the observation from the storage at the specified index.
	 * @param index the index to be read.
	 * @return the observation data stored for that index.
	 * @throws SOSException
	 */
	public WriteableObservation readObservationAt(int index) throws SOSException {
		Object readObject = null;
		try {
	        createReaderIfNull();
			readObject = reader.readObject(index);
			return (WriteableObservation)readObject;
		} catch (IOException e) {
			throw new CacheException(e);
		}
	}

	private boolean testTheSame(Object fatureLocation, Coordinates savedCoordinates){
		Coordinates fCoordinates = locationToCoordinates(fatureLocation);
		//Coordinates savedCoords = coordinatesFromString(savedCoordinates);
		return equalsCoordinates(fCoordinates, savedCoordinates);
	}
	
	/**
	 * Ends the reading process and resources can be freed. 
	 */
	public void finishReadingValues() {
		closeWriter();
	}

	public ObservationValue getObservationValueById(Object oid) throws SOSException {
		int index = ((Long)oid).intValue();
		WriteableObservation rawObs;
		rawObs = readObservationAt(index);
		DefaultObservationValue value = (DefaultObservationValue)getObservationValue(rawObs);
		value.setOid((Long)oid);
		return value;
	}

	
	public List<Object> getResources() {
		List<Object> resources = new ArrayList<Object>();
		resources.add(new File(this.cacheFileName));
		return resources;
	} 

}
