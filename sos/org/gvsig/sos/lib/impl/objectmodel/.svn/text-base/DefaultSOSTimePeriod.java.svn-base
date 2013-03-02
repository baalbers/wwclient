package org.gvsig.sos.lib.impl.objectmodel;

import java.util.ArrayList;

import org.gvsig.sos.lib.impl.parsers.gml_3_1_1.TimePeriodType;
import org.gvsig.sos.lib.impl.parsers.swe_1_0_1.TimeGeometricPrimitivePropertyType;





public class DefaultSOSTimePeriod {
	
	private final TimeGeometricPrimitivePropertyType tp;
	
	private DefaultSOSOffering parent;
	
	public DefaultSOSTimePeriod(TimeGeometricPrimitivePropertyType tp) {
		super();
		this.tp = tp;
		this.parent = null;
	}
	
	public DefaultSOSTimePeriod(TimeGeometricPrimitivePropertyType tp, DefaultSOSOffering parent) {
		super();
		this.tp = tp;
		this.parent = parent;
	}
	
	public String getName() {
		return "Time Period";
	}
	
	public String getBeginTime() {
		if((tp!=null)  && (tp.getTimePeriod() != null)) 
			return tp.getTimePeriod().getBeginPosition().getValue();
		else if ((tp!=null)  && tp.getTimeInstant()!=null) {
			return tp.getTimeInstant().getTimePosition().getValue();
		}
		return "";
	}
	
	public String getEndTime() {
		if ((tp!= null) && (tp.getTimePeriod().getEndPosition()!= null))
			return tp.getTimePeriod().getEndPosition().getValue();
		return "";
	}
	
	public DefaultSOSBasic [] getChildren() {
		ArrayList<Object> children = new ArrayList<Object>();
		DefaultSOSBasic sb;
		
		sb = new DefaultSOSBasic("Begin", getBeginTime());
		sb.setParent(this);
		children.add(sb);
		
		sb = new DefaultSOSBasic("End", getEndTime());
		sb.setParent(this);
		children.add(sb);
		
		return children.toArray(new DefaultSOSBasic[children.size()]);
	}
	
	public boolean hasChildren() {
		return true;
	}
	
	public void setParent(DefaultSOSOffering parent) {
		this.parent = parent;
	}
	public DefaultSOSOffering getParent() {
		return parent;
	}
	 
	public String toString() {
		return getName();
	}
	
}
