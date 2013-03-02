package org.gvsig.sos.lib.impl.objectmodel;

import java.util.ArrayList;
import java.util.List;
//
//import org.gvsig.fmap.geom.Geometry;
//import org.gvsig.fmap.geom.GeometryLocator;
//import org.gvsig.fmap.geom.exception.CreateGeometryException;
import org.gvsig.sos.lib.api.client.ObservedProperty;
import org.gvsig.sos.lib.api.client.Procedure;
import org.gvsig.sos.lib.impl.communication.DescribeSensorParams;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandler;
import org.gvsig.sos.lib.impl.communication.SOSCommunicationHandlerExtended;
import org.gvsig.sos.lib.impl.communication.exceptions.SOSInternalException;
import org.gvsig.sos.lib.impl.parsers.Coordinates;
import org.gvsig.sos.lib.impl.parsers.SOSInternalParserException;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.CoordinatesType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.DirectPositionType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.PointType;
import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.ReferenceType;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_SensorML;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_classification;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_identification;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Element_location;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_identifier;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_member;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.IoComponentPropertyType;
import org.gvsig.sos.lib.impl.parsers.sml_1_0_1.SystemType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PositionType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.VectorType;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.InternalSWEException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities;
import org.gvsig.tools.locator.LocatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

/**
 * High level class containing the information of a procedure as described in a SensorML document. 
 * @author lrodriguez
 */
public class DefaultSOSProcedure implements MutableProcedure {

	private static final Logger logger = LoggerFactory.getLogger(DefaultSOSProcedure.class);

	private final String name;
	private Coordinates position = null;
	private boolean included = false;
	private Element_SensorML sensorDescription;
	private SOSCommunicationHandler client;
	private MutableSOSClient parent;
	private List<String> outputs = null;
	private List<String> inputs = null;
	private List<ObservedProperty> properties = null; 
	
	public Element_SensorML getSensorDescription() throws SOSInternalException, SOSInternalParserException, InternalSWEException{
		if (sensorDescription == null) {
			DescribeSensorParams dsParams = new DescribeSensorParams();
			dsParams.getOutputFormat();
			String id = this.getName();
			dsParams.setProcedure(id);
			if (getClient() instanceof SOSCommunicationHandlerExtended) {
			    sensorDescription = ((SOSCommunicationHandlerExtended) getClient()).describeSensorExtended(dsParams); 
			}
		}
		return sensorDescription;
	}
	
	public DefaultSOSProcedure(String n, SOSCommunicationHandler client, MutableSOSClient parent) {
		this.name = n;
		this.client = client;
		this.parent = parent;
		if (parent!= null && parent instanceof DefaultSOSClient) {
			((DefaultSOSClient) parent).registerProcedure(this, name);
		}
	}

	public String getName() {
		return name;
	}
	 
	public String toString() {
		return this.getName();
	}
	
	public boolean isIncluded() {
		return included;
	}
	
	
	public void setIncluded(boolean v) {
		this.included = v;
	}
	
	/**
	 * Gets the coordinates where the procedure is placed.
	 * @return
	 */
	public Coordinates getProcedurePosition() {
		if (position == null) {
			Coordinates coord = this.getSensorCoordinates();
			position = coord;
		}
		return position;
	}
	
	private boolean checkAndGetSensorDescription(){
	    try {
			return getSensorDescription()!= null;
		
	    } 
	    catch (InternalSWEException e) {
			logError("SWE Error ocurred while gettting sensor description.", e);
		} 
	    catch (SOSInternalException e) {
			logError("Error ocurred while gettting sensor description.", e);
		} catch (SOSInternalParserException e) {
			logError("Parse error ocurred while gettting sensor description.", e);
		} 
		return false;
	}
	
	private void logError(String message, Throwable th){
	   logger.info(message, th);
	}
	
	private Coordinates getSensorCoordinates() {
		if (getClient() != null) {
		  try {	
   		    Coordinates coordinates = getFirstSensorSystemCoordinates(getSensorDescription());
  		    return coordinates;
		  }
		  catch (Exception e){
			  logError("Error occurred while gettting the sensor coordinates.", e);
		  }
		}
		return null;
	}
	
	/**
	 * Gets the client used to retrieve the information about procedure.
	 * @return
	 */
	private SOSCommunicationHandler getClient() {
		return client;
	}


	private static Coordinates getFirstSensorSystemCoordinates(Element_SensorML sensorDescrption){
		Coordinates result = null;

		if (sensorDescrption.getMemberList().size() > 0){
			SystemType system = sensorDescrption.getMemberList().get(0).get_Process();
			if (system != null && system.getLocation() != null){
				result = getCoordinatesFromLocation(system.getLocation());
			}	else if (system != null && system.getPosition() != null){
				result = getCoordinatesFromPosition(system.getPosition().getPosition());
			}
		}

		return result;
	}


	private static Coordinates getCoordinatesFromLocation(Element_location location) {
		Coordinates result = new Coordinates();

		List<Double> list = Utilities.convertToDoubleList(location.getPoint().getCoordinates().getValue());

		if(list.size() > 0)
			result.setX(list.get(0));

		if(list.size() > 1)
			result.setY(list.get(1));

		if(list.size() > 2)
			result.setZ(list.get(2));

		return result;
	}


	public static Coordinates getCoordinatesFromPosition(PositionType position) {
		Coordinates result = new Coordinates();

		VectorType vector = null;

		if (position != null &&  position.getLocation()!= null){
			vector = position.getLocation().getVector();
		}

		if (vector != null){
			for (Inner_Element_coordinate coord: vector.getCoordinateList()){
				String name = coord.getName();
				try {
					Double value = (coord.getQuantity().getValue()!= null)? coord.getQuantity().getValue(): coord.getValue();
					if (name.toLowerCase().equals("x") || name.toLowerCase().equals("easting") || name.toLowerCase().equals("longitude")){
						result.setX(value);
					} else if (name.toLowerCase().equals("y") || name.toLowerCase().equals("northing")|| name.toLowerCase().equals("latitude")){
						result.setY(value);
					} else if (name.toLowerCase().equals("z") || name.toLowerCase().equals("altitude")){
						result.setZ(value);
					} 
				}
				catch (Exception e){
				   logger.info("Cant obtain sensor position", e);
				   return null;
				}
			}
		}
      
		return result;
	}

	public static Coordinates getCoordinatesFromPosition(PointType position) {
		Coordinates result = new Coordinates();
        double x = 0.0D;
        double y = 0.0D; 

		if (position.getCoordinates() != null) {
			CoordinatesType coord = position.getCoordinates();
			//38.4 -0.5
			String [] coords = coord.getValue().split(" ");
			x = Double.parseDouble(coords[0]);
			y = Double.parseDouble(coords[1]);
		}
		else if (position.getPos()!= null) {
			DirectPositionType pos = position.getPos();
			x = pos.getValueList().get(0);
			y = pos.getValueList().get(1);
		}
        result.setX(x);
        result.setY(y);
		return result;
	}
	
	public static  List<Procedure> fromReferenceList(List<ReferenceType> list, SOSCommunicationHandler client, Object parent) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		for(ReferenceType r: list){
			MutableProcedure sp = new DefaultSOSProcedure(r.getHref(), client, (MutableSOSClient)parent);
			procedures.add(sp); 
		}
		return procedures;
	}

	public List<String> getIdentifiers() {
		List<String> result = new ArrayList<String>();
		if (sensorDescription.getIdentificationList()!= null) {
			for(Element_identification identifier : sensorDescription.getIdentificationList()){
				if (identifier.getIdentifierList()!= null) {
					for (Inner_Element_identifier id: identifier.getIdentifierList().getIdentifierList()){
						result.add(id.getName());
					}
				}
			}
			return result;
		}
		return result;
	}

	public List<String> getClassifiers() {
		List<String> result = new ArrayList<String>();
		if (checkAndGetSensorDescription() && sensorDescription.getClassificationList()!= null) {
			for(Element_classification classifier : sensorDescription.getClassificationList()){
				if (classifier.getClassifierList()!= null) {
					for (Inner_Element_classifier cl: classifier.getClassifierList().getClassifierList()){
						result.add(cl.getName());
					}
				}
			}
			return result;
		}
		return result;
	}

	public List<String> getOutputs() {
		//List<String> outputs = new ArrayList<String>();
		if (outputs == null){
			if (checkAndGetSensorDescription() && (sensorDescription.getMemberList()!= null)) {
				for(Inner_Element_member member : sensorDescription.getMemberList()){
					if (member.get_Process()!= null) {
						//Inner_Element_OutputList 
						for (IoComponentPropertyType elementOut: member.get_Process().getOutputs().getOutputList().getOutputList()){
							outputs.add(elementOut.getName());
							if (elementOut.getQuantity()!= null) {
								Element_Quantity quantity = elementOut.getQuantity();   
								//fill the properties as they are already setup
								updateObservedProperty(quantity);
							}
						}
					}
				}
			}
		}
		return outputs;
	}

	private void updateObservedProperty(Element_Quantity quantity) {
		if (parent!= null) {
			String propertyName = quantity.getDefinition();
			String units = (quantity.getUom()!= null)? quantity.getUom().getCode(): "";
		    ObservedProperty property =((DefaultSOSClient)parent).getProperty(propertyName, units);	
		    properties.add(property);
		}
	}

	public List<ObservedProperty> getObservedProperties(){
		if (properties==null) {
			getOutputs();
		}
		return properties;
	}
	
	public List<String> getInputs() {
		if (inputs == null) {
			if (checkAndGetSensorDescription() && (sensorDescription != null)
					&& sensorDescription.getMemberList() != null) {
				for (Inner_Element_member member : sensorDescription
						.getMemberList()) {
					if (member.get_Process() != null) {
						// Inner_Element_OutputList
						for (IoComponentPropertyType elementIn : member
								.get_Process().getInputs().getInputList()
								.getInputList()) {
							inputs.add(elementIn.getName());
						}
					}
				}
			}
		}
		return inputs;
	}

	public Geometry getPosition() {
		if (checkAndGetSensorDescription()) {
		    Coordinates c = getFirstSensorSystemCoordinates(sensorDescription);
			try {
				GeometryFactory gf = new GeometryFactory();
				Coordinate coordinate = new Coordinate(c.getX(), c.getY());
				Geometry geom = gf.createPoint(coordinate);
//				Geometry geom =	GeometryLocator.getGeometryManager().createPoint(c.getX(), c.getY(), Geometry.SUBTYPES.GEOM2D);
				return geom;
//			} catch (CreateGeometryException e) {
			} catch (LocatorException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

	public List<Procedure> getComponents() {
		List<Procedure> result = new ArrayList<Procedure>();
		if (checkAndGetSensorDescription() && sensorDescription!= null && sensorDescription.getMemberList()!= null) {
			for(Inner_Element_member member : sensorDescription.getMemberList()){
				if (member.get_Process()!= null) {
					//Inner_Element_OutputList 
					for (Inner_Element_component elementComponent: member.get_Process().getComponents().getComponentList().getComponentList()){
						DefaultSOSProcedure proc = new DefaultSOSProcedure(elementComponent.getName(), getClient(), parent);
						result.add(proc);
					}
				}
			}
			return result;
		}
		return result;
	}

	public void setIdentifiers(List<String> identifiers) {
		//nothing to do
	}

	public void setClassifiers(List<String> classifiers) {
		//nothing to do
	}

	public void setOutputs(List<String> outputs) {
		//nothing to do
	}

	public void setInputs(List<String> inputs) {
		//nothing to do
	}

	public void setPosition(Geometry position) {
		//nothing to do
	}

	public void setComponents(List<Procedure> components) {
		//nothing to do
	}

	public String getId() {
		return name;
	}
}
