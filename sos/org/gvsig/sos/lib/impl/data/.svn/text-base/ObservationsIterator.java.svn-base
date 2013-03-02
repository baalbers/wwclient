package org.gvsig.sos.lib.impl.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.sos.lib.api.client.DeclaredObservedProperty;
import org.gvsig.sos.lib.api.client.FeatureOfInterest;
import org.gvsig.sos.lib.api.client.ObservationSet;
import org.gvsig.sos.lib.api.client.ObservationValue;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Offering;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.sos.lib.impl.objectmodel.DefaultObservationValue;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSClient;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSObservedProperty;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSOffering;
import org.gvsig.sos.lib.impl.objectmodel.MutableFeatureOfInterest;
import org.gvsig.sos.lib.impl.objectmodel.MutableSOSClient;
import org.gvsig.sos.lib.impl.objectmodel.Utils;
import org.gvsig.sos.lib.impl.parsers.AnyTypeRealization;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeatureCollectionType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationPropertyType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationType;
import org.gvsig.sos.lib.impl.parsers.om_1_0_0.ProcessPropertyType;
import org.gvsig.sos.lib.impl.parsers.sampling_1_0_0.SamplingPointType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.AnyScalarPropertyType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.BlockEncodingPropertyType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataRecordType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.SimpleDataRecordType;
import org.gvsig.timesupport.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is an iterator over the observations values collected from an OM document. In this class is extracted the 
 * ObservationValues from the object model backing up the OM standard in the org.gvsig.sos.lib.impl.parsers.om_1_0_0.ObservationCollectionType
 * package.  Here is implemented all the logic for extracting observations information from different 
 * encodings performed by different SOS services.
 * The iterator iterates over ObservationValues kept internally or delegated to a PluggableIteratorDelegate. 
 * A ObservationsIteratorDelegate is used for delegating the storage and further iteration over the actual 
 * observations value. If no delegate is supplied in during the construction of this ObservationIterator
 * the observations will be kept in memory. This mechanim is designed in order to be able to implement
 * a convenient iterator for your needs. 
 * 
 * @author lrodriguez
 *
 */
public class ObservationsIterator implements ObservationSet {
	
	private static Logger logger = LoggerFactory.getLogger(ObservationsIterator.class);
	
	/**
	 * Interface designed for delegating the storage and iteration to an external delegate.
	 * This interface adds the storage methods to the iteration functionality exising in 
	 * Iterator. 
	 * @author lrodriguez
	 *
	 */
	public interface ObservationsIteratorDelegate extends ObservationSet {
		
		/**
		 * Indicates the delegate that it should include a new observations with the data 
		 * specified by the other parameters.
		 * @param value the value observed.
		 * @param time the time of the observation.
		 * @param featureOfInterest the feature of interest.
		 * @param observedProperty the observed property.
		 * @param procedure the procedure.
		 */
		public void addObservationValue(Object value, Time time, FeatureOfInterest featureOfInterest,
				DeclaredObservedProperty observedProperty, Procedure procedure);
		
		/**
		 * Called for indicating that the process of adding observation values is finished.
		 */
		public void finishReadingValues();
	}
	
	
	private List<ObservationValue> observations;
	
	/**
	 * The offering associated to the observations.
	 */
	private Offering offering; 
	
	/**
	 * The plugable iterator, in cas it is supplied the observartions list variable wont 
	 * have any observations. 
	 */
	private ObservationsIteratorDelegate pluggableIterator = null;

	/**
	 * Creates an observations iterator object for the observations contained in the 
	 * observationsCollection object, the offering and uses a pluggable iterator.
	 * @param observationsCollection the collection of observations object as retrieved from the parser.
	 * @param offering the offering to which the observations belong to.
	 * @param pluggableIterator the pluggable iterator for delegating the storage and iteration.
	 */
	public ObservationsIterator(ObservationCollectionType observationsCollection, Offering offering, ObservationsIteratorDelegate pluggableIterator){
		this.offering = offering;
		registerPluggable(pluggableIterator);
		observations = processObservations(observationsCollection);
	}
	
	/**
	 * Creates an observations iterator object for the observations contained in the 
	 * observationsCollection object and the offering. In this case the observations will be kept in
	 * memory in an internal list. 
	 * @param observationsCollection the collection of observations object as retrieved from the parser.
	 * @param offering the offering to which the observations belong to.
	 */
	public ObservationsIterator(ObservationCollectionType observationsCollection, Offering offering){
		this(observationsCollection, offering, null);
	}

	private void registerPluggable(ObservationsIteratorDelegate iterator) {
		if (iterator!= null) {
			pluggableIterator = iterator;
		}
	}

    private boolean isPlugged(){
    	return pluggableIterator!= null;
    }
    
    private void notifyPluggedIterator(Object value, Time time, FeatureOfInterest featureOfInterest,
			DeclaredObservedProperty observedProperty, Procedure procedure){
    	if (isPlugged()){
    		pluggableIterator.addObservationValue(value, time, featureOfInterest, observedProperty, procedure);
    	}
    }
	
	/**
	 * Process the information for obtaining the observations contained in the observation collection.
	 * @param observationsCollection the collection of observations to be parsed.
	 * @return a list of observable values.
	 */
    public List<ObservationValue> processObservations(ObservationCollectionType observationsCollection) {
    	List<ObservationValue> result = new ArrayList<ObservationValue>();
    	
    	try{
	    	for (ObservationPropertyType observationMember: observationsCollection.getMemberList()) {
	            //iterates through the members of the observation.
	    		ObservationType observationType = observationMember.getObservation();
	    		//process the observation
	    		List<ObservationValue> values = processType(observationType);
	    		//aggregate the values.
	    		if (values!= null)
	    			result.addAll(values);
	    	}
    	}
    	finally {
    	  //notify to release all the resources. 	
          notifyObservationsReadFinish();
    	}
    	return result;
    }
    
    private void notifyObservationsReadFinish(){
    	if (isPlugged()) {
    		pluggableIterator.finishReadingValues();
    	}
    }

	private enum FieldType {
		FT_QUANTITY, FT_TIME, FT_POSITION, FT_UNKNOWN, FT_TEXT
	};

	private enum QuantityType {
		QT_POSITION_LAT, QT_POSITION_LON, QT_VALUE
	}
	
	private static class Member {
		private List<FeatureOfInterest> featuresOfInterest;
		private List<ObservedProperty> observedProperties;
		private List<Procedure> procedures;
		private List<Field> fields;
		private List<ObservationValue> values;
		
		public Member() {
			featuresOfInterest = new ArrayList<FeatureOfInterest>();
			observedProperties = new ArrayList<ObservedProperty>();
			fields = new ArrayList<ObservationsIterator.Field>();
			values = new ArrayList<ObservationValue>();
			procedures = new ArrayList<Procedure>();
		}
		
		public void reset(){
			featuresOfInterest.clear();
			observedProperties.clear();
			fields.clear();
			values.clear();
			procedures = new ArrayList<Procedure>();
		}

		public void setFeaturesOfInterest(
				List<FeatureOfInterest> featuresOfInterest) {
			this.featuresOfInterest = featuresOfInterest;
		}

		public List<FeatureOfInterest> getFeaturesOfInterest() {
			return featuresOfInterest;
		}

		public void addFeatureOfInterest(FeatureOfInterest feature) {
			featuresOfInterest.add(feature);
		}

		public void setObservedProperties(
				List<ObservedProperty> observedProperties) {
			this.observedProperties = observedProperties;
		}

		public List<ObservedProperty> getObservedProperties() {
			return observedProperties;
		}

		public void addObservedProperty(ObservedProperty observedProperty) {
			observedProperties.add(observedProperty);
		}

		public void setProcedures(List<Procedure> procedures) {
			this.procedures = procedures;
		}

		public List<Procedure> getProcedures() {
			return procedures;
		}

		public void addProcedure(Procedure proc) {
			procedures.add(proc);
		}

		public void setFields(List<Field> fields) {
			this.fields = fields;
		}

		public List<Field> getFields() {
			return fields;
		}

		public void addField(Field field) {
			fields.add(field);
		}

		public void setValues(List<ObservationValue> values) {
			this.values = values;
		}

		public List<ObservationValue> getValues() {
			return values;
		}

		public void addValue(ObservationValue value) {
			values.add(value);
		}
	}
	
	private static class Field {
		
		private FieldType type;
        private QuantityType quantityType;
		private String definition;
		private String code;
		private String name;
		private String value;

		public Field(String definition, String code, String name, FieldType type, String value) {
			this.setType(type);
			this.setDefinition(definition);
			this.setCode(code);
			this.setName(name);
			this.setValue(value);
			assesQuantityType();
		}
		
		private String defLatitude = "urn:ogc:phenomenon:latitude:wgs84";
		private String defLongitude = "urn:ogc:phenomenon:longitude:wgs84";		

		private void assesQuantityType() {
			if (type==FieldType.FT_QUANTITY) {
				if (definition.equalsIgnoreCase(defLatitude)){
					setQuantityType(QuantityType.QT_POSITION_LAT);
				} else
				if (definition.equalsIgnoreCase(defLongitude)) {
					setQuantityType(QuantityType.QT_POSITION_LON);
				}
				else {
					setQuantityType(QuantityType.QT_VALUE);
				}
				if (getQuantityType() != QuantityType.QT_VALUE) {
					type = FieldType.FT_POSITION;
				}
			}
		}
		
		public void setType(FieldType type) {
			this.type = type;
		}

		public FieldType getType() {
			return type;
		}

		public void setDefinition(String definition) {
			this.definition = definition;
		}

		public String getDefinition() {
			return definition;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public boolean isTimeField(){
			return type == FieldType.FT_TIME;
		}

		public boolean isPositionField(){
			return type == FieldType.FT_POSITION;
		}

		public boolean isTextField(){
			return type == FieldType.FT_TEXT;
		}

		public boolean isQuantityField(){
			return type == FieldType.FT_QUANTITY;
		}

		private void setQuantityType(QuantityType quantityType) {
			this.quantityType = quantityType;
		}

		private QuantityType getQuantityType() {
			return quantityType;
		}
	}	
	
	
	private final Member currentMember = new Member();
	
	/**
	 * This function process an observation
	 * @param observationType
	 * @return
	 */
	private List<ObservationValue> processType(ObservationType observationType) {
		
		ObservationType observation = observationType;
		List<ObservationValue> result = null;
		
		if (observation != null) {
			result = new ArrayList<ObservationValue>();
			AnyTypeRealization typeRealization = observation.getResult();
			DataArrayType data = null;
			if (typeRealization.getValue() instanceof DataArrayType) {
				data = (DataArrayType) typeRealization.getValue(); // getDataArray();

				// explore the fields and gather them for further matching with the 
				// observed properties
				List<Object> fieldList = getFieldsElements(data);

				//get the features of interest. 
				List<FeatureOfInterest> featuresOfInterest = processFeatureOfInterest(observation.getFeatureOfInterest());
				currentMember.setFeaturesOfInterest(featuresOfInterest);
				currentMember.setProcedures(processProcedures(observation.getProcedure()));

				

				for (Object field : fieldList) {
					Field fieldToAdd = processField(field);
					currentMember.addField(fieldToAdd);
				}

				// get observedProperty, it has to be done in order to be able to proprerly fill 
				// the unit of measurement.
				currentMember.setObservedProperties(getObservedProperties(observation.getObservedProperty(), currentMember.getFields()));

				processData(currentMember, data, result);
				currentMember.reset();
			}
		}
		
		return result;
	}

	private List<Object>  getFieldsElements(DataArrayType data) {
		List<Object> fieldList = new ArrayList<Object>();
		
		if ((data.getElementType().getAbstractDataRecord()) instanceof DataRecordType) {
	
			fieldList.addAll(((DataRecordType) data
					.getElementType().getAbstractDataRecord())
					.getFieldList());
		}
		else if ((data.getElementType().getAbstractDataRecord()) instanceof SimpleDataRecordType){
			List<AnyScalarPropertyType> ptList = ((SimpleDataRecordType) data
					.getElementType().getAbstractDataRecord())
					.getFieldList();
			fieldList.addAll(ptList);
		}
		return fieldList;
	}

	
	private ObservedProperty getObservedPropertyDef(String name, String units, PhenomenonPropertyType observedProperty) {
		 MutableSOSClient parent = null;
		 if (offering instanceof DefaultSOSOffering) {
			parent = (MutableSOSClient)((DefaultSOSOffering)offering).getParent();
			return ((DefaultSOSClient)parent).getProperty(observedProperty, name, units);
		 }
		 return null;
	}

   /**
    * This function adds the procedure to the object representing and holding the data related with the server.	
    * @param procedure the procedure object as obtained from the low level API.
    * @return the list of procedures (in case many of them are kept as a system) or a procedure.
    */
	private List<Procedure> processProcedures(ProcessPropertyType procedure) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		Procedure proc = getProcedure(procedure.getHref());//new DefaultSOSProcedure(procedure.getHref(), null, null);
		procedures.add(proc);
		return procedures;
	}

	private Procedure getProcedure(String procedureId){
		Procedure procedure = null;
		DefaultSOSOffering sosOffering = (offering!=null && offering instanceof DefaultSOSOffering)?
				         (DefaultSOSOffering)offering : null;
		if (!procedureId.equals("") && sosOffering!= null) {
			procedure =  sosOffering.getProcedureById(procedureId);
		} 
		return procedure;
	}
	
	/**
	 * Function in charge of processing the data held in the data array encoded string.
	 * @param member the member internal class object having the information related to this data.
	 *        (procedures, features of interest etc.)  
	 * @param data the data element containing the encoded data. 
	 * @param observations a list where to put the observations found.
	 */
	private void processData(Member member, DataArrayType data, List<ObservationValue> observations) {
		Date t1 = new Date();
		long t3 = 0L;
		
		
		BlockEncodingPropertyType encodings = data.getEncoding();
		String blockSeparator = encodings.getTextBlock()
				.getBlockSeparator();
		String tokenSeparator = encodings.getTextBlock()
				.getTokenSeparator();
		String decimalSeparator = encodings.getTextBlock()
				.getDecimalSeparator();
		
		// data encoded in the data array.
		String values = data.getValues().getValue().toString();
		String[] rows = values.split(blockSeparator);
		
		int row = 0;
		int col = 0;
		
		Field timeField = null;
		Time timeValue = null;
		Coordinates featurePosition = null;
		String currentFeatureOIName = "";
		Field foiField = null;
		
		for (String rowStr : rows) {
			String[] fieldsStr = rowStr.split(tokenSeparator);
			col = 0;
			for (String fieldValue : fieldsStr) {
                Field currentField = member.getFields().get(col);
				if (currentField.isTimeField()) {
					//Sampling time.
					timeField = currentField;
					timeValue = processTime(timeField, fieldValue);
				}
				else if (currentField.isPositionField()){
				   //Position of the feature of interest.
				   featurePosition = processPosition(decimalSeparator,
						featurePosition, fieldValue, currentField);
				}
				else if (currentField.isTextField()) {
					//possibly prepare the feature of interest
					currentFeatureOIName = fieldValue;
					foiField = currentField;
				}
				else if (currentField.isQuantityField()) {

					//get if exist the observed property associated to the field.
					ObservedProperty observedProperty = getObservedProperty(currentField, member.getObservedProperties());

					//if it is not possible to link this field with an observed property then
					//it shouldn't be considered (update: should raise an exception). 
					if (observedProperty != null) {
						//search for the feature of interest, in this case this can be defined
						//in two different ways, in the data by including the position and 
						//or previously in the header of the observation (i.e by putting a SamplingPoint).
						FeatureOfInterest feature = getFeatureOfInterest(currentFeatureOIName, currentField,
													featurePosition, foiField, member.getFeaturesOfInterest());
	
						Procedure procedure = getProcedure(currentField,  member.getProcedures(), fieldValue);
	
						//add the the value with such field to the list of fields
						//calculate the values of the fields.
						
						if (timeValue!= null && 
								feature!= null && observedProperty!= null && procedure != null) {
							//decode the value, or try to decode it as a Double if not possible 
							//keep it as string.
							Object decodedvalue = decodeFieldValue(fieldValue, currentField, decimalSeparator);

							
							if (!isPlugged()) {
								//create the observation value.
								DefaultObservationValue value = new DefaultObservationValue(decodedvalue, timeValue, 
									feature, observedProperty, procedure);
								
								//add the created observation value to the observations list. 
								observations.add(value);
							}
							else {
								Date tIt = new Date();
								notifyPluggedIterator(decodedvalue, timeValue, 
										feature, observedProperty, procedure);
								t3+= new Date().getTime() - tIt.getTime();
							}
						}
                    }
					else {
						throw new RuntimeException("Property not found for a field Value. This shouldnt happen.");
					}
				}
				col++;
			}
			row++;
		}
		
		Date t2 = new Date();
		logger.info("Values Extracted: " +  (row-1)  +  " TotalTimeDiff: " + (t2.getTime()-t1.getTime()) +  " SavingTime:"  + t3);
		
	}

	private Time processTime(Field timeField, String fieldValue) {
		//Note: definition sometimes says how the time is defined.
		return Utils.parseDateTimeStringToInstant(fieldValue.toString());
	}

	private Coordinates processPosition(String decimalSeparator,
			Coordinates featurePosition, String fieldValue, Field currentField) {
		// position
		if (featurePosition == null) {
			featurePosition = new Coordinates();
		}

		switch (currentField.getQuantityType()) {
		case QT_POSITION_LAT: {
			featurePosition.setX((Double) decodeFieldValue(fieldValue,
					currentField, decimalSeparator));
			break;
		}
		case QT_POSITION_LON: {
			featurePosition.setY((Double) decodeFieldValue(fieldValue,
					currentField, decimalSeparator));
			break;
		}
		case QT_VALUE:
			break;
		default:
			break;
		}
		return featurePosition;
	}
	
	private Procedure getProcedure(Field currentField, List<Procedure> procedures, String fieldValue) {
        if (procedures.size()==1) {
        	return procedures.get(0);
        }
		return null;
	}

	/**
	 * Tries to find the observed property linked to a field.
	 * @param currentField the field 
	 * @param observedProperties the list of the existing observed properties.
	 * @return the observed property linked to the field.
	 */
	private ObservedProperty getObservedProperty(Field currentField,
			List<ObservedProperty> observedProperties) {
		for (ObservedProperty property : observedProperties) {
			if (currentField.getDefinition().equalsIgnoreCase(
					property.getIdentifier())) {
				return property;
			}
		}
		return null;
	}

	/**
	 * Function for finding out the feature of interest linked to a given field and value.
	 * @param fieldValue value found in the data array.
	 * @param currentField the field containing the value  information (definition, name, etc)
	 * @param featurePosition the position found previously in the data. In some cases, as with the 
	 *                        Osthetys server happens that the position is encoded with the data.
	 * @param foiField the field where was found information containing the feature of interest.
	 * @param featuresOfInterest list of the features of interest with (possibly partial) information) 
	 * 							that might be completed here.
	 * @return the fully filled with information feature of interest.
	 */
	private FeatureOfInterest getFeatureOfInterest(String fieldValue,
			Field currentField, Coordinates featurePosition, Field foiField,
			List<FeatureOfInterest> featuresOfInterest) {
		if (featuresOfInterest.size() == 1) {
			FeatureOfInterest featureOfInterest = featuresOfInterest.get(0);
			if (featureOfInterest instanceof MutableFeatureOfInterest) {
				if (featurePosition != null) {
					//this case is typical from Osthetys.
					((MutableFeatureOfInterest) featureOfInterest)
							.setCoordinates(featurePosition);
				/*} else {
					if (!featureOfInterest.getIdentifier().equalsIgnoreCase(
							fieldValue)) {
						throw new RuntimeException("This should not happen!!");
					}*/
				}
				return featureOfInterest;
			}
		} else {
			//case is typical of 52 North
			for (FeatureOfInterest foi : featuresOfInterest) {
				if ((fieldValue != null) && !fieldValue.equals("")
						&& foi.getIdentifier().equalsIgnoreCase(fieldValue)) {
					return foi;
				}
			}
		}
		return null;
	}

	/**
	 * Decodes the value of a given field.
	 * @param value
	 * @param fieldDef
	 * @param decimalSeparator
	 * @return
	 */
	private Object decodeFieldValue(String value, Field fieldDef, String decimalSeparator) {
		Object result = value;
		
		if (fieldDef.isQuantityField() || fieldDef.isPositionField()) {
			if (value.equalsIgnoreCase("?") || value.equals("")) {
				result = Double.NaN;
			}
			else {
				try {
					value = value.replace(decimalSeparator, ".");
				    result = Double.parseDouble(value);
				}
				catch(Exception e){
					//if the value is not parse-able then keep it as a text
					result = value;
				}
			}
		}
		else if (fieldDef.isTimeField()) {
			result = value;
		}
		return result;
	}

	
	/**
	 * Process a field keeping the most important information for 
	 * linking later this information with the observed properties.
	 * @param field the field element mapped by the low level binding API.
	 * @return the field object.
	 */
	
	private Field processField(Object scalarOrDataComponentPropertyType){
        if 	(scalarOrDataComponentPropertyType instanceof AnyScalarPropertyType) {
        	return processField((AnyScalarPropertyType)scalarOrDataComponentPropertyType);
        }
        else if (scalarOrDataComponentPropertyType instanceof DataComponentPropertyType){
        	return processField((DataComponentPropertyType)scalarOrDataComponentPropertyType);
        }
        else {
        	throw new IllegalArgumentException("Invalid element type:" + scalarOrDataComponentPropertyType.getClass().getCanonicalName());
        }
	}
	
	private Field processField(DataComponentPropertyType field) {
		String name = field.getName();
		String definition = "";
		FieldType type = FieldType.FT_UNKNOWN;
		String code = "";
		//time field (used mainly for putting the sampling time)
		if (field.getTime() != null) {
			type = FieldType.FT_TIME;
			definition = field.getTime().getDefinition();
			code = (field.getTime().getUom() != null) ? field.getTime()
					.getUom().getCode() : "";
		} else 
		//quantity field (used for putting the values of the observations)
		if (field.getQuantity() != null) {
			type = FieldType.FT_QUANTITY;
			definition = field.getQuantity().getDefinition();
			code = (field.getQuantity().getUom() != null) ? field.getQuantity()
					.getUom().getCode() : "";
		} else 
		//text field used for putting the id if the feature of interest in 52North
		if (field.getText() != null) {
			type = FieldType.FT_TEXT;
			definition = field.getText().getDefinition();
			code = "";
		}
		return new Field(definition, code, name, type, "");
	}

	private Field processField(AnyScalarPropertyType field) {
		String name = field.getName();
		String definition = "";
		FieldType type = FieldType.FT_UNKNOWN;
		String code = "";
		//time field (used mainly for putting the sampling time)
		if (field.getTime() != null) {
			type = FieldType.FT_TIME;
			definition = field.getTime().getDefinition();
			code = (field.getTime().getUom() != null) ? field.getTime()
					.getUom().getCode() : "";
		} else 
		//quantity field (used for putting the values of the observations)
		if (field.getQuantity() != null) {
			type = FieldType.FT_QUANTITY;
			definition = field.getQuantity().getDefinition();
			code = (field.getQuantity().getUom() != null) ? field.getQuantity()
					.getUom().getCode() : "";
		} else 
		//text field used for putting the id if the feature of interest in 52North
		if (field.getText() != null) {
			type = FieldType.FT_TEXT;
			definition = field.getText().getDefinition();
			code = "";
		}
		return new Field(definition, code, name, type, "");
	}

	
	/**
	 * Tries to extract the observed properties from the observation element, 
	 * using also the info in the fields for completing the information.
	 * @param observedProperty the Phenomenon (possible a compound one).
	 * @param fields the field info gathered before.
	 * @return
	 */
	
	private List<ObservedProperty> getObservedProperties(
			PhenomenonPropertyType observedProperty, List<Field> fields) {
		List<ObservedProperty> properties = new ArrayList<ObservedProperty>();
		if (observedProperty.getPhenomenon() != null) {
			CompositePhenomenonType phenomenon = observedProperty
					.getPhenomenon();
			List<PhenomenonPropertyType> components = phenomenon
					.getComponentList();
			for (PhenomenonPropertyType component : components) {
				String propertyName = DefaultSOSObservedProperty
						.getNameFromPhenomenonPropertyType(component);
				Field assocField = fieldForProperty(fields, propertyName);
				String unitOfMeasurement = "";
				if (assocField != null) {
					unitOfMeasurement = assocField.code;
				}
				ObservedProperty prop = getObservedPropertyDef(propertyName, unitOfMeasurement, observedProperty);
				properties.add(prop);
			}
		}
		else {
			String propertyName = DefaultSOSObservedProperty
					.getNameFromPhenomenonPropertyType(observedProperty);
			Field assocField = fieldForProperty(fields, propertyName);
			String unitOfMeasurement = "";
			if (assocField != null) {
				unitOfMeasurement = assocField.code;
			}
			ObservedProperty prop = getObservedPropertyDef(propertyName, unitOfMeasurement, observedProperty);
			properties.add(prop);
		}
		return properties;
	}

	/**
	 * Checks if can deduce the field linked to the property.
	 * @param fields the fields information.
	 * @param propertyName the property name.
	 * @return
	 */
	private Field fieldForProperty(List<Field> fields, String propertyName) {
		for(Field field: fields) {
			if (field.getDefinition().equalsIgnoreCase(propertyName)
					|| field.getName().equalsIgnoreCase(propertyName)){
				return field;
			}
		}
		return null;
	}
	
	/**
	 * Tries to extract the information of the features of interest.
	 * @param featureOfInterest the binded feature of interest element. 
	 * @return
	 */
	private List<FeatureOfInterest> processFeatureOfInterest(
			FeaturePropertyType featureOfInterest) {

		List<FeatureOfInterest> results = new ArrayList<FeatureOfInterest>();
        //if it is a feature collection process it. 
		if (featureOfInterest.get_Feature() != null
				&& featureOfInterest.get_Feature() instanceof FeatureCollectionType) {
			FeatureCollectionType features = (FeatureCollectionType) featureOfInterest
					.get_Feature();
			for (FeaturePropertyType feature: features.getFeatureMemberList()) {
				results.addAll(processFeatureOfInterest(feature));
			}

		} else {
			if (featureOfInterest.get_Feature() != null
					&& featureOfInterest.get_Feature() instanceof SamplingPointType) {
				//if it is a sampling point then keep the feature as so
				SamplingPointType feature = (SamplingPointType)featureOfInterest.get_Feature();
				String name = feature.getName().getValue();
				if (feature.getGMLId()!=null){
					name = feature.getGMLId();
				}
			    results.add(getFeatureOfInterestDef(feature.getPosition(), name/*feature.getName().getValue()*/));	
				
			} else {
				//in this case, typical from Osthetys, the only information available is the id
				//of the feature of interest. The position will be fulfilled while parsing the data.
				results.add(getFeatureOfInterestDef(null, featureOfInterest
						.getHref()));
			}
		}
		return results;
	}

	
	/**
	 * This function updates the existing feature of interest in the parent (in this case an offering)
	 * @param position the position related to the feature
	 * @param href the id of the feature.
	 * @return
	 */
	private FeatureOfInterest getFeatureOfInterestDef(PointType position, String href) {
		 if (offering instanceof DefaultSOSOffering) {
			 return ((DefaultSOSOffering)offering).getFeatureOfInterest(position, href);
		 }
		 return null;
	}

	public long getCount() {
		if (!isPlugged()) {
			return observations.size();
		}
		else {
		  return pluggableIterator.getCount();	
		}
	}

	public Iterator<ObservationValue> iterator() {
		if (!isPlugged()) {
			return observations.iterator();
		}
		else {
		  return pluggableIterator.iterator();	
		}
	}

	public Iterator<ObservationValue> iterator(long index) {
		if (!isPlugged()) {
			return observations.iterator();
		}
		else {
		  return pluggableIterator.iterator(index);	
		}
	}

	public void dispose() {
		if (isPlugged()) {
			pluggableIterator.dispose();	
		}
		observations = null;
        offering = null;
		pluggableIterator = null;
	}

	public ObservationValue getObservationValueById(Object oid) throws SOSException {
		if (isPlugged()) {
			return pluggableIterator.getObservationValueById(oid);	
		}
		else { 
			for(ObservationValue value: observations) {
		 	  if (value.getOid().equals(oid)){
		 		  return value;
		 	  }
			}
		} 
		//TODO: FIXME raise an exception
		return null;
	}

	public List<Object> getResources() {
		if (isPlugged()) {
    		return pluggableIterator.getResources();
    	}
		else return null;
	}
	
	
//	/*
//	 * Iterator implementation zone.
//	 */
//	private int iteratorPosition = -1;
//
//	/**
//	 * Says if the iterator contains a next element.
//	 * @return true if there are more elements available, false otherwise.
//	 */
//	public boolean hasNext() {
//		if (!isPlugged()) {
//			return iteratorPosition < observations.size()-1;
//		}
//		else {
//		  return pluggableIterator.hasNext();	
//		}
//	}

//	/**
//	 * Returns the next observation value.
//	 * @return the observation value.
//	 */
//	public ObservationValue next() {
//		if (!isPlugged()){
//			if (hasNext()){
//				return observations.get(++iteratorPosition);
//			}
//		}
//		else {
//		  return pluggableIterator.next();
//		}
//		return null;
//	}

//	/**
//	 * This method is not supported by this implementation of iterator.
//	 */
//	public void remove() {
//	   //Nothing to do now.	
//	}
	
	
}