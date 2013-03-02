package org.gvsig.tools.persistence.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dynobject.DynClassName;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.impl.DefaultDynClassName;
import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynObjectPersistenceFactory implements PersistenceFactory {
	static Logger LOG = LoggerFactory.getLogger(DynObjectPersistenceFactory.class);
    
    Map definitions = new HashMap();

    private void addDefinition(DynStruct definition){
        definitions.put(definition.getFullName(), definition);
    }
    
    public Object createFromState(PersistentState state) throws PersistenceException {
        return ToolsLocator.getDynObjectManager().createDynObject(state.getDefinition());
    }

    public void loadFromState(PersistentState state, Object object) throws PersistenceException {
    	DynStruct definition = ((DynObject)object).getDynClass();
    	addDefinition(definition);
    	DynField[] fields = definition.getDynFields();
    	for(int i=0; i<fields.length; i++){
    		DynField field = fields[i];
    		if (field.getDataType().isContainer()){
    			if (field.getDataType().getType() == DataTypes.MAP){
    				Map persistedMap = (Map) state.get(field.getName());
    				Map auxMap = new HashMap();
    				if (persistedMap != null) {
    					auxMap.putAll(persistedMap);
    				}
    				((DynObject)object).setDynValue(field.getName(), auxMap);
    				continue;
    			} else if (field.getDataType().getType() == DataTypes.LIST){
    				List persistedList = (List) state.get(field.getName());
    				List auxList = new ArrayList();
    				if (persistedList != null) {
    					auxList.addAll(persistedList);
    				}
    				((DynObject)object).setDynValue(field.getName(), auxList);
    				continue;
    			} else if (field.getDataType().getType() == DataTypes.SET){
    				Set persistedSet = (Set) state.get(field.getName());
    				Set auxSet = new HashSet();
    				if (persistedSet != null) {
    					auxSet.addAll(persistedSet);
    				}
    				((DynObject)object).setDynValue(field.getName(), auxSet);
    				continue;
    			}
    		}
    		((DynObject)object).setDynValue(field.getName(), state.get(field.getName()));
    	}
    }

    public void saveToState(PersistentState state, Object obj) throws PersistenceException {
        DynStruct definition = ((DynObject)obj).getDynClass();
        addDefinition(definition);
        DynField[] fields = definition.getDynFields();
        for(int i=0; i<fields.length; i++){
            state.set(fields[i].getName(), ((DynObject)obj).getDynValue(fields[i].getName()));
        }
    }

    public boolean manages(Object object) {
        if (object instanceof DynObject){
            return true;
        }
        return false;
    }

    public boolean manages(Class theClass) {
        if (DynObject.class.isAssignableFrom(theClass)){
            return true;
        }
        return false;
    }

    public boolean manages(PersistentState state) {
    	String className = state.getTheClassName();
    	DynClassName dynClassName = new DefaultDynClassName(className);
    	if ( dynClassName.getNamespace().equals(PersistenceManager.PERSISTENCE_DYNOBJECT_NAMESPACE)){
            return true;
        }
        return false;
    }

    public List getDefinitions() {
        List defs = new ArrayList();
        defs.addAll(definitions.values());
        return defs;
    }

    public DynStruct getDefinition(String className) {
    	DynStruct struct;
		DynObjectManager dynMan = ToolsLocator.getDynObjectManager();
		struct = dynMan.get(PersistenceManager.PERSISTENCE_DYNOBJECT_NAMESPACE,className);
		return struct;
    }

    public String getDomainName() {
        return PersistenceManager.DEFAULT_DOMAIN_NAME;
    }

    public String getDomainURL() {
        return PersistenceManager.DEFAULT_DOMAIN_URL;
    }

    public List getManagedClasses() {
        return Collections.singletonList(DynObject.class);
    }

    public Class getManagedClass(Object object) {
        if( DynObject.class.isInstance(object) ) {
            return DynObject.class;
        }
        return null;
    }

    public String getManagedClassName(Object object) {
        if( DynObject.class.isInstance(object) ) {
            return ((DynObject)object).getDynClass().getFullName();
        }
        return null;
    }

    public Class getManagedClass(PersistentState state) {
    	String className = state.getTheClassName();
    	DynClassName dynClassName = new DefaultDynClassName(className);
    	if ( !dynClassName.getNamespace().equals(PersistenceManager.PERSISTENCE_DYNOBJECT_NAMESPACE)){
    		return null;
    	}
    	return DynObject.class;
    }

    public Class getManagedClass(String name) {
    	DynClassName dynClassName = new DefaultDynClassName(name);
    	if ( dynClassName.getNamespace().equals(PersistenceManager.PERSISTENCE_DYNOBJECT_NAMESPACE)){
            return DynObject.class;
        }
        return null;
    }

}
