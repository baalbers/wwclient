package org.gvsig.tools.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceException;

public abstract class AbstractMultiPersistenceFactory implements PersistenceFactory  {

	protected List classes;
	protected List definitions;
	protected Map nameToDefinition;
	protected Map nameToClass;

	protected AbstractMultiPersistenceFactory() {
		this.definitions = new ArrayList();
		this.classes = new ArrayList();
		this.nameToDefinition = new HashMap();
		this.nameToClass = new HashMap();
		this.makeDefinitions();
	}

	protected DynStruct addDefinition(Class managedClass, String name, String description) {
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();

		DynClass definition = dynman.createDynClass(PersistenceManager.PERSISTENCE_NAMESPACE, name, description);
		dynman.add(definition);
		
		this.definitions.add(definition);
		this.nameToDefinition.put(managedClass.getName(), definition);
		this.nameToDefinition.put(definition.getFullName(), definition);
		if( definition.getNamespace().equals(PersistenceManager.PERSISTENCE_NAMESPACE) ) {
			this.nameToDefinition.put(definition.getName(), definition);
		}
		
		this.classes.add(managedClass);
		this.nameToClass.put(managedClass.getName(), managedClass);
		this.nameToClass.put(definition.getFullName(), managedClass);
		if( definition.getNamespace().equals(PersistenceManager.PERSISTENCE_NAMESPACE) ) {
			this.nameToClass.put(definition.getName(), managedClass);
		}
		
		return definition;
	}
    
	public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	
    	buffer.append(this.getClass().getName()).append("[").append(this.hashCode()).append("]").append("( ")
    		.append("managedClasses='").append(this.classes.toString()).append("', ")
    		.append("structs='").append(this.definitions.toString())
    		.append(" )");
    	return buffer.toString();
    }
    
	public void loadFromState(PersistentState state, Object object)
			throws PersistenceException {
				// By default nothing to do here, the object hasn't any more
				// properties to set.
			}

	public String getDomainName() {
		return PersistenceManager.DEFAULT_DOMAIN_NAME;
	}

	public String getDomainURL() {
		return PersistenceManager.DEFAULT_DOMAIN_URL;
	}

	public List getDefinitions() {
		return definitions;
	}

	public List getManagedClasses() {
		return   this.classes ;
	}
	
	public DynStruct getDefinition(String className) {
		return (DynStruct) this.nameToDefinition.get(className);
	}
	
	public boolean manages(Object object) {
		return this.manages(object.getClass());
	}

	public boolean manages(Class theClass) {
		Iterator it =  this.getManagedClasses().iterator();
		while( it.hasNext() ) {
			Class theInterface = (Class) it.next();
			if(  theInterface.isAssignableFrom(theClass) ) {
				return true;
			}
		}
		return false;
	}

	public boolean manages(PersistentState state) {
		return this.nameToClass.get( state.getTheClassName()) != null ;
	}

	public Class getManagedClass(PersistentState state) {
		return (Class) this.nameToClass.get( state.getTheClassName()) ;
	}
	
	public Class getManagedClass(String name) {
		return (Class) this.nameToClass.get(name) ;
	}
	
	public Class getManagedClass(Object object) {
		Iterator it =  this.getManagedClasses().iterator();
		while( it.hasNext() ) {
			Class theInterface = (Class) it.next();
			if(  theInterface.isInstance(object) ) {
				return theInterface;
			}
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

	/**
	 * Create DynStruct definition and call to {@link #addDefinition(Class, DynStruct)}
	 * to add to the factory.
	 */
	abstract protected void makeDefinitions();
}