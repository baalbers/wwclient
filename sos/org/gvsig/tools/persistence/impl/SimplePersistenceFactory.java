package org.gvsig.tools.persistence.impl;

import java.util.Collections;
import java.util.List;

import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.Persistent;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceCreateException;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePersistenceFactory implements PersistenceFactory {

	private static final  Logger logger = LoggerFactory.getLogger(SimplePersistenceFactory.class);

	private String domainName;
	private String domainUrl;
	private DynStruct definition;
	private Class theClass;
	
	SimplePersistenceFactory(Class theClass, DynStruct definition,
			String domainName, String domainUrl){
		if( domainName == null ) {
			domainName = PersistenceManager.DEFAULT_DOMAIN_NAME;
		}
		if( domainUrl == null ) {
			domainUrl = PersistenceManager.DEFAULT_DOMAIN_URL;
		}
		this.definition = definition;
		this.theClass = theClass;
		this.domainUrl = domainUrl;
		this.domainName = domainName;
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
			logger.warn("SimplePersistenceFactory.getManagedClass({}) is not a java class.",name);
			return this.theClass;
		}
		if( this.definition.getFullName().equalsIgnoreCase(name)) {
			logger.warn("SimplePersistenceFactory.getManagedClass({}) is not a java class.",name);
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
		Persistent pobj = (Persistent) object;
		pobj.loadFromState(state);
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

	public void saveToState(PersistentState state, Object obj)
			throws PersistenceException {
		Persistent persistent = (Persistent) obj;
		try {
			persistent.saveToState(state);
		} catch(PersistenceException ex) {
			PersistentContextServices  context = (PersistentContextServices) state.getContext();
			if( !context.getCollectErrors() ) {
				throw ex;
			}
			context.addError(ex);
		} catch(Exception ex) {
			PersistentContextServices  context = (PersistentContextServices) state.getContext();
			if( !context.getCollectErrors() ) {
				throw new PersistenceException(ex);
			}
			context.addError(ex);
		}
	}

	public Object createFromState(PersistentState state)
			throws PersistenceException {
		Persistent obj;
		try {
			obj = (Persistent) this.theClass.newInstance();
		} catch (InstantiationException e) {
			throw new PersistenceCreateException(this.theClass, e);
		} catch (IllegalAccessException e) {
			throw new PersistenceCreateException(this.theClass, e);
		}
		return obj;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("SimplePersistenceFactory").append("[").append(
				this.hashCode()).append("]").append("( ")
				.append("definitions=").append(this.definition).append(", ")
				.append("domainName='").append(domainName).append("', ")
				.append("domainUrl='").append(domainUrl).append("', ").append(
						"theClass=").append(this.theClass).append(" )");
		return buffer.toString();
	}

}
