package org.gvsig.tools.persistence.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.exception.DynFieldNotFoundException;
import org.gvsig.tools.dynobject.exception.DynMethodException;
import org.gvsig.tools.dynobject.exception.DynObjectValidateException;
import org.gvsig.tools.dynobject.impl.DefaultDynClassName;
import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.AddDefinitionException;
import org.gvsig.tools.persistence.exception.DuplicatePersistentDefinitionException;
import org.gvsig.tools.persistence.exception.FieldNotDeclaredException;
import org.gvsig.tools.persistence.exception.PersistenceClassNotRegistered;
import org.gvsig.tools.persistence.exception.PersistenceCreateException;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceTypeNotSupportedException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;
import org.gvsig.tools.persistence.exception.PersistenceWriteExeption;
import org.gvsig.tools.persistence.impl.exception.CantFindDefinitionInStreamException;
import org.gvsig.tools.persistence.impl.exception.PersistenceDomainNotRegisterdException;
import org.gvsig.tools.persistence.impl.exception.PersistenceIllegalStateTheClassNameNotSetException;
import org.gvsig.tools.persistence.impl.exception.PersistenceInvalidValidateModeException;
import org.gvsig.tools.persistence.impl.exception.PersistenceValidateMissingDefinitionException;
import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices.ObjectReference;
import org.gvsig.tools.persistence.spi.PersistentStateServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParserException;


public abstract  class AbstractPersistenceManager implements
		PersistenceManagerServices {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractPersistenceManager.class);
	
	private DefaultFactories factories;
	private Domains domainsURL;
	private int autoValidationMode = PersistenceManager.DISABLED;

	

	protected AbstractPersistenceManager() {
		domainsURL = new Domains();
		factories = new DefaultFactories();
	}

	public void addAlias(String name, Class aClass)
			throws PersistenceClassNotRegistered {
		PersistenceFactory factory = this.factories.get(aClass.getName());
		this.factories.add(factory, aClass.getName());
	}

	public Factories getFactories() {
		return this.factories;
	}

	public PersistentContextServices getNewContext() {
		return new DefaultPersistentContext(this);
	}
	
	public Object create(PersistentState state) throws PersistenceException {
		String className = state.getTheClassName();
		if (className == null) {
			throw new PersistenceIllegalStateTheClassNameNotSetException() ;
		}
		PersistentContextServices context = getContext(state);
		ObjectReference ref = context.get(state);
		return ref.getObject();
	}

	public Object getObject(InputStream is) {
		Object obj = null;
		PersistentState state = null;
		String theClassName = null;
		try {
			state = this.loadState(is);
			theClassName = state.getTheClassName();
			obj = this.create(state);
		} catch (PersistenceException e) {
			throw new PersistenceCreateException(theClassName,e);
		}
		return obj;
	}
	
	public void putObject(OutputStream os, Object obj) {
		PersistentState state;
		try {
			state = this.getState(obj);
			this.saveState(state, os);
		} catch (PersistenceException e) {
			throw new PersistenceWriteExeption(e);
		}
	}
	
	public DynStruct getDefinition(Class persistentClass) {
		return getDefinition(persistentClass.getName());
	}

	public DynStruct getDefinition(String className) {
		PersistenceFactory factory = this.factories.get(className);
		if( factory== null ) {
			return null;
		}
		return factory.getDefinition(className);
	}
	
	public DynStruct getDynObjectDefinition(String className) {
		DefaultDynClassName dynClassName = new DefaultDynClassName(PERSISTENCE_DYNOBJECT_NAMESPACE, className);
		PersistenceFactory factory = this.factories.get(dynClassName.getFullName());
		if( factory== null ) {
			return null;
		}
		return factory.getDefinition(dynClassName.getFullName());
	}

	private PersistentContextServices getContext(PersistentState state) {
		return (PersistentContextServices) state.getContext();
	}

	public void validate(PersistentState state, int mode)
			throws PersistenceValidateExceptions {

		if (mode == PersistenceManager.DISABLED){
			return;
		}

		List exceptions = new ArrayList();
		DynStruct definition = state.getDefinition();
		if( definition == null ) {
			if( mode == PersistenceManager.MANDATORY ) {
				exceptions.add(new PersistenceValidateMissingDefinitionException(state.getTheClassName()));
				throw  new PersistenceValidateExceptions(state.getTheClassName(), exceptions);
			} else {
				return;
			}
		}

		PersistentStateServices state2 = (PersistentStateServices) state;
		Iterator it = state2.getNames();
		while( it.hasNext() ) {
			String name = (String) it.next();
			DynField field = definition.getDynField(name);
			if(  field == null ) {
				exceptions.add( new FieldNotDeclaredException(name,state.getTheClassName()));
			} 
		}
		DynObjectToPersistentStateAdapter dynAdapter = new DynObjectToPersistentStateAdapter(state, definition);			
		try {
			definition.validate(dynAdapter);
		} catch (DynObjectValidateException e) {
			exceptions.add(e);
		}
		if (exceptions.size() > 0) {
			throw  new PersistenceValidateExceptions(state.getTheClassName(), exceptions);
		}
	}

	public void validateAll(PersistentState state, int mode)
			throws PersistenceValidateExceptions {

		if (mode == PersistenceManager.DISABLED){
			return;
		}
		PersistentContextServices context =  getContext(state);
		context.validate(this.autoValidationMode);
	}

	private class DynObjectToPersistentStateAdapter implements DynObject {
		private PersistentState state;
		private DynStruct struct;

//		DynObjectToPersistentStateAdapter() {
//			this.state = null;
//			this.struct = null;
//		}
		DynObjectToPersistentStateAdapter(PersistentState state, DynStruct struct) {
			this.state = state;
			this.struct = struct;
		}

//		public void setData(PersistentState state, DynStruct struct) {
//			this.state = state;
//			this.struct = struct;
//		}

		public void delegate(DynObject dynObject) {
			// Nothing to do

		}

		public DynClass getDynClass() {
			// Nothing to do
			return null;
		}

		public Object getDynValue(String name) throws DynFieldNotFoundException {
			try {
				return state.get(name);
			} catch (PersistenceException e) {
				throw new DynFieldNotFoundException(name, struct.getName());
			}
		}

		public boolean hasDynValue(String name) {
			return state.hasValue(name);
		}

		public void implement(DynClass dynClass) {
			// Nothing to do
		}

		public Object invokeDynMethod(String name, DynObject context)
				throws DynMethodException {
			// Nothing to do
			return null;
		}

		public Object invokeDynMethod(int code, DynObject context)
				throws DynMethodException {
			// Nothing to do
			return null;
		}

		public void setDynValue(String name, Object value)
				throws DynFieldNotFoundException {
			// Nothing to do
		}
		public void clear() {
			// Nothing to do
		}

	}

	public int getAutoValidation() {
		return autoValidationMode;
	}

	public void setAutoValidation(int validationMode) throws PersistenceException {
		switch (validationMode) {
		case DISABLED:
		case MANDATORY:
		case MANDATORY_IF_DECLARED:
			autoValidationMode = validationMode;
			break;
		default:
			throw new PersistenceInvalidValidateModeException(validationMode);
		}
	}

	public PersistentState getState(Object obj)
			throws PersistenceException, PersistenceValidateExceptions, PersistenceTypeNotSupportedException {
		return this.getState(obj, false);
	}

	public PersistentState getState(Object obj, boolean collectAllErrors)
			throws PersistenceException {
		PersistentStateServices state = null;
		if( collectAllErrors ) {
			PersistentContextServices context = this.getNewContext();
			context.setCollectErrors(true);
			try {
				state = createState(obj, context);
				context.setRootId(state.getId());
				if (this.autoValidationMode != PersistenceManager.DISABLED){
					context.validate(this.autoValidationMode);
				}
			} catch(PersistenceException ex) {
				context.addError(ex);
			}
		} else {
			PersistentContextServices context = this.getNewContext();
			state = createState(obj, context);
			context.setRootId(state.getId());
			this.validateAll(state, this.autoValidationMode);
		}
		return state;
	}
	
	public PersistentStateServices createState(Object object, PersistentContextServices context) throws PersistenceException {

		PersistentStateServices state = createPersistentState(context);
		state.setTheClassName(object.getClass().getName());
		
		context.add(state, object);
		
		PersistenceFactory factory = this.factories.get(object);
		if (factory == null) {
			throw new PersistenceTypeNotSupportedException(object
					.getClass());
		}
		state.setFactory(factory);
		state.setTheClassName(factory.getManagedClassName(object));
		factory.saveToState(state, object);
		return state;
	}

	public List getWrappedList(List list, PersistentContextServices context) {
		return new DelegatedList(list, this, context);
	}

	public Map getWrappedMap(Map map, PersistentContextServices context) {
		return new DelegatedMap(map, this, context);
	}

	public Set getWrappedSet(Set set, PersistentContextServices context) {
		return new DelegatedSet(set, this, context);
	}


	public Map getDomains() {
		return Collections.unmodifiableMap(domainsURL);
	}

	public List getDomainDefinitions(String domainName) {
		if (!domainsURL.containsKey(domainName)) {
			throw new PersistenceDomainNotRegisterdException(domainName);
		}
		List definitions = new ArrayList();
		Iterator it = this.factories.iterator();
		while( it.hasNext() ) {
			PersistenceFactory factory = (PersistenceFactory) it.next();
			if( factory.getDomainName().equals(domainName)) {
				List factDefinitions = factory.getDefinitions();
				if(factDefinitions != null){
					definitions.addAll(factDefinitions);
				}
			}
		}
		return definitions;
	}

			
	public DynStruct addDefinition(Class theClass, String name, String description,
			String domainName, String domainUrl) {
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();

		DynClass definition = dynman.createDynClass(PERSISTENCE_NAMESPACE, name, description);
		return addDefinition(theClass, definition, domainName, domainUrl);
	}

	public DynStruct addDefinition(Class theClass, String name, InputStream definitions, ClassLoader loader,
			String domainName, String domainUrl) {
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();
		Map x;
		try {
			x = dynman.importDynClassDefinitions(definitions, loader, PersistenceManager.PERSISTENCE_NAMESPACE);
		} catch (XmlPullParserException e) {
			throw new AddDefinitionException(e);
		} catch (IOException e) {
			throw new AddDefinitionException(e);
		}
		DynClass definition = (DynClass) x.get(name);
		if( definition == null ) {
			throw new CantFindDefinitionInStreamException(name, getKeys(x));
		}
		return addDefinition(theClass, definition, domainName, domainUrl);
	}

	private String getKeys(Map theMap) {
		List l = new ArrayList(theMap.keySet());
		return l.toString();
	}
	

	public DynStruct addDefinition(Class theClass, String name, Map definitions,
			String domainName, String domainUrl) {
		DynClass definition = (DynClass) definitions.get(name);
		return addDefinition(theClass, definition, domainName, domainUrl);
		
	}

	protected  DynStruct addDefinition(Class theClass, DynClass definition,
		String domainName, String domainUrl) {
		if(theClass == DynObject.class){
			return this.addDefinition(definition, domainName, domainUrl);
		}
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();
		
		if(theClass.equals(DynObject.class)){
			definition.setNamespace(PERSISTENCE_DYNOBJECT_NAMESPACE);
		} else {
			definition.setNamespace(PERSISTENCE_NAMESPACE);
		}
		if( dynman.get(definition.getNamespace(),definition.getName())!=null ) {
			throw new DuplicatePersistentDefinitionException(definition.getName());
		}
		dynman.add(definition);
		
		PersistenceFactory factory = new SimplePersistenceFactory(
				theClass, 
				definition,
				domainName, 
				domainUrl
			);
		this.factories.add(factory);
		this.domainsURL.add(factory.getDomainName(), factory.getDomainURL());
		LOG.trace("Add persistence definition {}.", new Object[] { definition.getFullName() });
		return definition;
	}
	
	public DynStruct addDefinition(DynStruct definition, String domainName,
			String domainUrl) throws AddDefinitionException {
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();
		
		definition.setNamespace(PERSISTENCE_DYNOBJECT_NAMESPACE);
		if( dynman.get(definition.getNamespace(),definition.getName())!=null ) {
			throw new DuplicatePersistentDefinitionException(definition.getFullName());
		}
		dynman.add((DynClass) definition);
		
		PersistenceFactory factory = this.factories.get(definition.getFullName());
		this.domainsURL.add(factory.getDomainName(), factory.getDomainURL());
		LOG.trace("Add persistence definition {}.", new Object[] { definition.getFullName() });
		return definition;
	}
	
	public void registerFactory(PersistenceFactory factory) {
		this.factories.add(factory);
		this.domainsURL.add(factory.getDomainName(), factory.getDomainURL());
		LOG.trace("Add persistence factory {}.", new Object[] { factory.getClass().getName() });
	}

	public void unregisterClass(Class theClass) {
		PersistenceFactory factory = this.factories.get(theClass.getName());
		if( factory == null ) {
			return ;
		}
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();
		DynStruct definition = factory.getDefinition(theClass.getName());

		dynman.remove(definition);
		this.factories.remove( factory);
		this.domainsURL.remove(factory.getDomainName());
	}

	public void unregisterClass(String name) {
		PersistenceFactory factory = this.factories.get(name);
		if( factory == null ) {
			return ;
		}
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();

		this.factories.remove( factory);
		this.domainsURL.remove(factory.getDomainName());

		DynStruct definition = factory.getDefinition(name);
		dynman.remove(definition);
	}

	public void unregisterFactory(PersistenceFactory factory) {
		DynObjectManager dynman = ToolsLocator.getDynObjectManager();

		this.factories.remove(factory);
		this.domainsURL.remove(factory.getDomainName());

		List definitions = factory.getDefinitions();
		if (definitions != null){
			Iterator it = definitions.iterator();
			while( it.hasNext() ) {
				DynStruct definition = (DynStruct) it.next();
				dynman.remove(definition);
			}
		}
	}
	
	public PersistentStateServices createPersistentState(	PersistentContextServices context) {
		return this.createPersistentState(context, context.getNewIdentifier());
	}

}