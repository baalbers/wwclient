package org.gvsig.tools.persistence;

import java.util.Collections;
import java.util.List;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceException;

public abstract class AbstractSinglePersistenceFactory implements PersistenceFactory {

	private String domainName;
	private String domainUrl;
	private DynStruct definition;
	private Class theClass;
	
	protected AbstractSinglePersistenceFactory(Class theClass, String name, String description,
			String domainName, String domainUrl){
		if( domainName == null ) {
			domainName = PersistenceManager.DEFAULT_DOMAIN_NAME;
		}
		if( domainUrl == null ) {
			domainUrl = PersistenceManager.DEFAULT_DOMAIN_URL;
		}
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();
		DynClass definition = dynman.createDynClass(PersistenceManager.PERSISTENCE_NAMESPACE, name, description);
		dynman.add(definition);
		this.definition = definition;
		this.theClass = theClass;
		this.domainUrl = domainUrl;
		this.domainName = domainName;
	}

	protected DynStruct getDefinition() {
		return this.definition;
	}
	
	public DynStruct getDefinition(String name) {
		if( this.definition.getName().equalsIgnoreCase(name)) {
			return this.definition;
		}
		if( this.definition.getFullName().equalsIgnoreCase(name)) {
			return this.definition;
		}
		if( this.theClass.getName().equals(name) ) {
			return this.definition;
		}
		return null;
	}

	public List getDefinitions() {
		return Collections.singletonList( this.definition);
	}

	public String getDomainName() {
		return this.domainName;
	}

	public String getDomainURL() {
		return this.domainUrl;
	}

	public Class getManagedClass(Object object) {
		if( this.theClass.isInstance(object) ) {
			return this.theClass;
		}
		return null;
	}

	public String getManagedClassName(Object object) {
		Class clazz = this.getManagedClass(object);
		if (clazz != null){
			return clazz.getName();
		}
		return null;
	}

	public Class getManagedClass(PersistentState state) {
		return this.getManagedClass(state.getTheClassName());
	}
	
	public Class getManagedClass(String name) {
		if( this.definition.getName().equalsIgnoreCase(name)) {
			return this.theClass;
		}
		if( this.definition.getFullName().equalsIgnoreCase(name)) {
			return this.theClass;
		}
		if( this.theClass.getName().equals(name) ) {
			return this.theClass;
		}
		return null;
	}
	
	public List getManagedClasses() {
		return Collections.singletonList(this.theClass);
	}

	public void loadFromState(PersistentState state, Object object)
			throws PersistenceException {
		// By defaultdo nothing
	}

	public boolean manages(Object object) {
		return theClass.isInstance(object);
	}

	public boolean manages(Class theClass) {
		return this.theClass.isAssignableFrom(theClass);
	}

	public boolean manages(PersistentState state) {
		if( state == null ) {
			return false;
		}
		String name = state.getTheClassName();
		if( this.definition.getName().equalsIgnoreCase(name)) {
			return true;
		}
		if( this.definition.getFullName().equalsIgnoreCase(name)) {
			return true;
		}
		if( this.theClass.getName().equals(name) ) {
			return true;
		}
		return false;
	}


	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("SinglePersistenceFactory").append("[").append(
				this.hashCode()).append("]").append("( ")
				.append("definitions=").append(this.definition).append(", ")
				.append("domainName='").append(domainName).append("', ")
				.append("domainUrl='").append(domainUrl).append("', ").append(
						"theClass=").append(this.theClass).append(" )");
		return buffer.toString();
	}

}
