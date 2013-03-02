package org.gvsig.sos.lib.impl.objectmodel;


public class DefaultSOSBasic {
	
	private String name, value;
	private Object parent;
	
	public DefaultSOSBasic(String n) {
		this.name = n;
		this.value = "";
	}
	
	public DefaultSOSBasic(String n, String v) {
		this.name = n;
		this.value = v;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setParent(Object parent) {
		this.parent = parent;
	}
	public Object getParent() {
		return parent;
	}
	
	public String toString() {
		if (this.getValue().equals(""))
			return this.getName();
		else
			return this.getName() + ": " + this.getValue();
	}
	
}
