package org.gvsig.sos.lib.impl.objectmodel;

import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.PhenomenonPropertyType;

public class DefaultSOSObservedProperty implements MutableObservedProperty {
	
	private PhenomenonPropertyType property;
	private String name;
	private String measurementUnits;
	private Object parent;

	public DefaultSOSObservedProperty(PhenomenonPropertyType property, String name, String measurementUnits, MutableSOSClient parent) {
		this.property = property;
		this.name = name; //property.getPhenomenon().getComponentList().get(1).getHref();
		if (this.name.equals("")) {
			this.name= getNameFromPhenomenonPropertyType(property);
		}
		this.measurementUnits = measurementUnits;
		this.parent = parent;
	}

	public DefaultSOSObservedProperty(String name, String measurementUnits) {
		this.name = name; //property.getPhenomenon().getComponentList().get(1).getHref();
		this.measurementUnits = measurementUnits;
		//this.parent = parent;
		property = null;
		parent = null;
	}

	
	public static String getNameFromPhenomenonPropertyType(PhenomenonPropertyType property){
        String name= property.getHref();
		if (property.getPhenomenon()!=null && property.getPhenomenon().getComponentList()!= null ) {
			if (property.getPhenomenon().getComponentList().size()>1)
		      name = property.getPhenomenon().getComponentList().get(1).getHref();
			else if (property.getPhenomenon().getComponentList().size()==1){
				name = property.getPhenomenon().getComponentList().get(0).getHref();
			}
	    }
		return name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return this.getName();
	}
	
	/*public static List<ObservedProperty> fromPhenomenonPropertyType(List<PhenomenonPropertyType> list){
		ArrayList<ObservedProperty> properties = new ArrayList<ObservedProperty>();
		ObservedProperty sb;
		for(PhenomenonPropertyType p: list){
			sb = new DefaultSOSObservedProperty(p, "", "");
		    properties.add(sb);
		}
	   return properties;
	}*/

	public String getIdentifier() {
		return name;
	}

	public String getMeasurementUnit() {
		return measurementUnits;
	}
	
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnits = measurementUnit;
	}

	public void setIdentifier(String identifier) {
		name = identifier;
	}
 }
