package org.gvsig.tools.persistence.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.PersistenceManager.Factories;
import org.gvsig.tools.persistence.impl.exception.PersistenceInvalidDomainNameException;

public class DefaultFactories extends ArrayList implements Factories {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3790704153805598236L;

	private static final Pattern VALID_DOMAIN_NAME_PATTERN = Pattern.compile("[\\w][\\d\\w_]*");

	private Map classToFactoryCache;

	public DefaultFactories() {
		this.classToFactoryCache = new HashMap();
		this.add(new DynObjectPersistenceFactory());
	}

	public boolean add(PersistenceFactory factory, String classNameAlias) {
		if( !super.contains(factory) ) {
			this.add(factory);
		}
		this.classToFactoryCache.put(classNameAlias, factory);
		return true;
	}
	
	public boolean add(PersistenceFactory factory) {
		if( factory.getDomainName() == null ) {
			throw new PersistenceInvalidDomainNameException();
		}
		
		if (!VALID_DOMAIN_NAME_PATTERN.matcher(factory.getDomainName()).matches()) {
			throw new PersistenceInvalidDomainNameException(factory.getDomainName());
		}

		List factoryManagedClasses = factory.getManagedClasses();
		Iterator it = factoryManagedClasses.iterator();
		while( it.hasNext() ) {
			Class theClass = (Class) it.next();
			classToFactoryCache.put(theClass.getName(), factory);
		}
		if(this.size()<1) {
			super.add(factory);
		} else {
			super.add(this.size()-1, factory);
		}
		return true;
	}

	/**
	 * Return the associated persistence factory to the java class name passed as parameter
	 * @param className
	 * @return
	 */
	public PersistenceFactory get(String className) {
		PersistenceFactory factory = (PersistenceFactory) classToFactoryCache.get(className);
		if (factory != null) {
			return factory;
		} 
		Iterator factoriesIterator = super.iterator();
		while( factoriesIterator.hasNext() ) {
			factory = (PersistenceFactory) factoriesIterator.next();
			if( factory.getDefinition(className)!=null ) {
				classToFactoryCache.put(className, factory);
				return factory;
			}
		}
		return null;
	}
	
	public PersistenceFactory get(Class theClass) {
		String className = theClass.getName();
		PersistenceFactory factory = (PersistenceFactory) classToFactoryCache.get(className);
		if (factory != null) {
			return factory;
		} 
		Iterator factoriesIterator = super.iterator();
		while( factoriesIterator.hasNext() ) {
			factory = (PersistenceFactory) factoriesIterator.next();
			if( factory.manages(theClass)) {
				classToFactoryCache.put(className, factory);
				return factory;
			}
		}
		return null;
	}

	public PersistenceFactory get(Object object) {
		if( object instanceof String) {
			return this.get((String)object);
		}
		return this.get(object.getClass());
	}

	public PersistenceFactory get(PersistentState state) {
		return get(state.getTheClassName());
	}

}
