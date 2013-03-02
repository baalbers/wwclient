package org.gvsig.sos.lib.impl.objectmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the response formats supported by an offering.
 * @author lrodriguez
 *
 */
public class DefaultSOSResponseFormat {
	
	private List<String> list;
	private DefaultSOSOffering parent;
	
	public DefaultSOSResponseFormat(List<String> list) {
		super();
		this.list = list;
		this.parent = null;
	}
	
	/**
	 * Constructor.
	 * @param list lists of response formats.
	 * @param parent the associated offering.
	 */
	public DefaultSOSResponseFormat(List<String> list, DefaultSOSOffering parent) {
		super();
		this.list = list;
		this.parent = parent;
	}
	
	public String getName() {
		return "Response Formats";
	}

	/**
	 * Gets the reponse formats.
	 * @return
	 */
	public DefaultSOSBasic [] getChildren() {
		ArrayList<Object> children = new ArrayList<Object>();
		DefaultSOSBasic sb;
		
		for(String s: list){
			sb = new DefaultSOSBasic(s);
			sb.setParent(this);
			children.add(sb);
		}
		
		return children.toArray(new DefaultSOSBasic[children.size()]);
	}
	
	public boolean hasChildren() {
		return true;
	}
	
	/**
	 * Sets the associated offerig.
	 * @param parent
	 */
	public void setParent(DefaultSOSOffering parent) {
		this.parent = parent;
	}
	/**
	 * Gives the associated offering.
	 * @return
	 */
	public DefaultSOSOffering getParent() {
		return parent;
	}
	
	public String toString() {
		return getName();
	}
	
}
