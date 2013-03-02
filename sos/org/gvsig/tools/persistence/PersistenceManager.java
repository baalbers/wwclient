package org.gvsig.tools.persistence;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.AddDefinitionException;
import org.gvsig.tools.persistence.exception.PersistenceClassNotRegistered;
import org.gvsig.tools.persistence.exception.PersistenceCreateException;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;

/**
 * <p>
 * This interface contains the necessary methods to get a persistent
 * representation of an object, suitable for storage or transmission, and to
 * create a an object from its persistent representation.
 * </p>
 * 
 * @author The gvSIG project <http://www.gvsig.org>
 * @author Cesar Martinez Izquierdo <cesar.martinez@iver.es>
 * @author IVER T.I. <http://www.iver.es>
 */
public interface PersistenceManager {

	public interface Factories extends List {

		/**
		 * Add a new factory to the list registering an alias.
		 * 
		 * If factory already registered anly add the alias.
		 * 
		 * @param factory
		 * @param classNameAlias
		 * @return true when ok.
		 */
		public boolean add(PersistenceFactory factory, String classNameAlias);

		/**
		 * Add a new class to the factory.
		 * 
		 * @param factory
		 * @return true when ok
		 */
		public boolean add(PersistenceFactory factory);

		/**
		 * Return factory associated to class passed as parameter.
		 * 
		 * @param class name
		 * 
		 * @return Persistence factory that manage the class
		 */
		public abstract PersistenceFactory get(Class theClass);

		/**
		 * Return factory associated to the object passed as parameter.
		 * 
		 * @param object
		 * 
		 * @return Persistence factory that manage object
		 */
		public PersistenceFactory get(Object object);

		/**
		 * Return factory associated to the object stored in the state.
		 * 
		 * @param state
		 * 
		 * @return Persistence factory that manage the state
		 */
		public PersistenceFactory get(PersistentState state);

	}

	/**
	 * The namespace used on the definition of DynClasses used by the
	 * persistence manager.
	 */
	public static final String PERSISTENCE_NAMESPACE = "Persistence";
	public static final String PERSISTENCE_DYNOBJECT_NAMESPACE = "PersistenceDynObject";
	public static final String DEFAULT_DOMAIN_URL = "http://www.gvsig.org";
	public static final String DEFAULT_DOMAIN_NAME = "gvsig";

	/**
	 * <p>
	 * Validation Mode -- MANDATORY: Validation is active, so
	 * {@link PersistenceManager#create(org.gvsig.tools.persistence.PersistentState)}
	 * and {@link PersistenceManager#getState(Object)} will throw validation
	 * exceptions if validation errors are found.
	 * </p>
	 * <p>
	 * If an undeclared attribute or class is found, this will be considered a
	 * validation error.
	 * </p>
	 */
	static public final int MANDATORY = 3;
	/**
	 * <p>
	 * Validation Mode -- MANDATORY_IF_DECLARED: Validation is active, but it
	 * will be only applied to Persistent objects which have been registered.
	 * {@link PersistenceManager#create(org.gvsig.tools.persistence.PersistentState)}
	 * and {@link PersistenceManager#getState(Object)} methods will throw
	 * validation exceptions if validation errors are found.
	 * </p>
	 */
	static public final int MANDATORY_IF_DECLARED = 2;
	/**
	 * <p>
	 * Validation Mode - DISABLED: No validation is performed at all. In this
	 * mode, {@link PersistenceManager#ge}
	 * </p>
	 */
	static public final int DISABLED = 0;

	/**
	 * <p>
	 * Creates a persistent state from an Persistent object.
	 * </p>
	 * 
	 * @param obj
	 *            The Persistent object to be persisted
	 * 
	 * @return A PersistentState object, which stores the state of the provided
	 *         Persistent Object.
	 * @throws PersistenceException
	 */
	public PersistentState getState(Object obj) throws PersistenceException;

	/**
	 * Creates a persistent state from an Persistent object.
	 *
	 * When collectAllErrors is true, try to continue when an error
	 * is detected, and raise all errors when finish the process.
	 * 
	 * @param obj
	 * @param collectAllErrors
	 * @return
	 * @throws PersistenceException
	 */
	public PersistentState getState(Object obj, boolean collectAllErrors) throws PersistenceException;

	/**
	 * <p>
	 * Instantiates an object from a persistent state. The PersistentState
	 * object knows the class of the persisted object, and instantiates it by
	 * using introspection. The object must implement the Persistent interface
	 * so that it can understand the PersistentState.
	 * </p>
	 * 
	 * @param state
	 *            The state of the object to be instantiated
	 * @return A new object whose state is the same as the provided
	 *         <code>state</code> object.
	 * 
	 * @throws PersistenceException
	 * @throws PersistenceCreateException
	 */
	public Object create(PersistentState state) throws PersistenceException,
			PersistenceCreateException;

	/**
	 * <p>
	 * Associates an alias with a class. This is similar to a symbolic link,
	 * which allows to access the class by means of its alias.
	 * </p>
	 * 
	 * <p>
	 * When an alias is defined, it replaces any class whose qualified name is
	 * equal to the alias. Therefore, this class will never be instantiated, and
	 * instead the class pointed by the the alias will be instantiated.
	 * </p>
	 * 
	 * <p>
	 * For example, if the following alias is defined:
	 * </p>
	 * 
	 * <pre>
	 * Class aClass = org.gvsig.fmap.mapcontext.rendering.symbols.SimpleMarkerSymbol.class;
	 * manager.addAlias(
	 * 		&quot;org.gvsig.fmap.mapcontext.rendering.symbols.ArrowMarkerSymbol&quot;, aClass);
	 * </pre>
	 * <p>
	 * then, SimpleMarkerSymbol will be instantiated instead of
	 * ArrowMarkerSymbol from any PersistentState which references
	 * ArrowMarkerSymbol.
	 * </p>
	 * 
	 * <p>
	 * Aliases are useful to provided backward-compatibility paths (as old no
	 * existing classes may be aliased to substitution classes), but are also
	 * useful to avoid limitations on ClassLoaders. As a Class object is
	 * provided, it will be possible to instantiate it even if the current
	 * ClassLoader has no direct visibility of the class to instantiate.
	 * </p>
	 * 
	 * @param alias
	 *            The alias to reference a class
	 * @param aClass
	 *            The class to be referenced by the alias
	 * 
	 * @throws PersistenceClassNotRegistered
	 *             if <code>aClass</code> is not registered
	 */
	public void addAlias(String alias, Class theClass)
			throws PersistenceClassNotRegistered;

	/**
	 * Add a new definition to the class in the persistent manager.
	 * 
	 * The new definition is defined in the namespace by default for DynClasses
	 * used in persistence.
	 * 
	 * if domainName or domainURL are null, values by default arent supplied by
	 * the manager.
	 * 
	 * <b>Note:</b> A <code>domainName</code> can by in only one
	 * <code>domainURL</code>. If you try to register the same
	 * <code>domainName</code> with two URL an exception will be raised. </p>
	 * 
	 * @param persistentClass
	 * @param name
	 *            of the new definition
	 * @param description
	 *            of the new definition, can be null.
	 * @param domainName
	 *            , can be null.
	 * @param domainURL
	 *            , can be null.
	 * @return the new definition
	 */
	public DynStruct addDefinition(Class persistentClass, String name,
			String description, String domainName, String domainURL)
			throws AddDefinitionException;

	
	/**
	 * Add a new definition to the class in the persistent manager.
	 * 
	 * @param theClass
	 *            to be persistent
	 * @param name
	 *            of the class definition to associate to theClass
	 * @param definitions
	 *            input stream from load the definitions of classes
	 * @param loader
	 *            , loader to resolve references to classes
	 * @param domainName
	 *            (can be null)
	 * @param domainUrl
	 *            (can be null)
	 * @return
	 * 
	 * @see #addDefinition(Class, String, String, String, String)
	 */
	public DynStruct addDefinition(Class theClass, String name,
			InputStream definitions, ClassLoader loader, String domainName,
			String domainUrl) throws AddDefinitionException;

	/**
	 * Add a new definition to the class in the persistent manager.
	 * 
	 * @param theClass
	 *            to be persistent
	 * @param name
	 *            of the class definition to associate to theClass
	 * @param definitions
	 *            , map from get the definition of the class
	 * @param domainName
	 *            (can be null)
	 * @param domainUrl
	 *            (can be null)
	 * @return
	 * 
	 * @see #addDefinition(Class, String, String, String, String)
	 */
	public DynStruct addDefinition(Class theClass, String name,
			Map definitions, String domainName, String domainUrl)
			throws AddDefinitionException;

	/**
	 * Add a new definition to the class in the persistent manager.
	 * 
	 * @param definition
	 *            , TODO
	 * @param domainName
	 *            (can be null)
	 * @param domainUrl
	 *            (can be null)
	 * @return
	 * 
	 * @see #addDefinition(Class, String, String, String, String)
	 */
	public DynStruct addDefinition(DynStruct definition, String domainName,
			String domainUrl)
			throws AddDefinitionException;

	/**
	 * <p>
	 * Register an instance of {@link PersistenceFactory} that can manage some
	 * objects that requires an especial construction or persistence. This
	 * factory will use the default domain name and URL.
	 * </p>
	 * 
	 * 
	 * @param factory
	 */
	public void registerFactory(PersistenceFactory factory);

	public void unregisterFactory(PersistenceFactory factory);

	/**
	 * <p>
	 * Unregister a registered class from the manager.
	 * </p>
	 * 
	 * @param persistentClass
	 * 
	 * @see #registerClass(Class, DynStruct, String)
	 * 
	 * @throws PersistenceClassNotRegistered
	 *             if <code>persistentClass</code> is not registered
	 */
	public void unregisterClass(Class theClass)
			throws PersistenceClassNotRegistered;

	/**
	 * <p>
	 * Unregister a registered java class from the manager.
	 * </p>
	 * 
	 * @param className the java class name to unregister
	 * 
	 * @see #registerClass(Class)
	 * 
	 * @throws PersistenceClassNotRegistered
	 *             if <code>className</code> is not registered
	 */
	public void unregisterClass(String className)
			throws PersistenceClassNotRegistered;

	/**
	 * <p>
	 * Validates persistent state by using the corresponding registered
	 * attribute definition. <code>mode</code> specifies what to do when a
	 * definition of a state class is not registered.
	 * </p>
	 * 
	 * @param state
	 * @param mode
	 * @throws PersistenceValidateExceptions
	 * 
	 */
	public void validate(PersistentState state, int mode)
			throws PersistenceValidateExceptions;

	/**
	 * <p>
	 * Validates all persistent state related to the <code>state</code> by using
	 * the corresponding registered attribute definition. <code>mode</code>
	 * specifies what to do when a definition of a state class is not
	 * registered.
	 * </p>
	 * 
	 * @param state
	 * @param mode
	 * 
	 * @throws PersistenceValidateExceptions
	 * 
	 * @see {@link #setAutoValidation(int)}
	 * 
	 */
	public void validateAll(PersistentState state, int mode)
			throws PersistenceValidateExceptions;

	/**
	 * <p>
	 * If the provided persistent class has registered an attribute definition
	 * in this manager, then this method returns that definition. Otherwise, it
	 * returns null.
	 * </p>
	 * 
	 * @param persistentClass
	 *            The class whose corresponding attribute definition is to be
	 *            retrieved.
	 * 
	 * @return The attribute definition corresponding to the provided persistent
	 *         class, or null otherwise.
	 */
	public DynStruct getDefinition(Class persistentClass);

	/**
	 * <p>
	 * Return the associated definition to the java class name passed as parameter.
	 * </p>
	 * 
	 * @param name of the java class to retrieve definition
	 * 
	 * @return The attribute definition corresponding to the provided java
	 *         class, or null otherwise.
	 */
	public DynStruct getDefinition(String name);

	/**
	 * <p>
	 * Return the associated definition to the dynClass name passed as parameter.
	 * </p>
	 * 
	 * @param name of the dynClass to retrieve definition
	 * 
	 * @return The attribute definition corresponding to the provided dynClass, or null otherwise.
	 */
	public DynStruct getDynObjectDefinition(String className);

	/**
	 * <p>
	 * De-serializes an state from the data read from the provided
	 * <code>reader</code>. Depending on the implementation the serialized data
	 * may have different formats, such as XML or binary data.
	 * </p>
	 * 
	 * <p>
	 * Note that a particular implementation will only be able to de-serialize
	 * data which has been serialized by the same implementation.
	 * </p>
	 * 
	 * @param reader
	 * @return
	 */
	public PersistentState loadState(InputStream in)
			throws PersistenceException;

	/**
	 * <p>
	 * Serializes the {@link PersistentState} and writes the serialized data in
	 * the provided {@link OutputStream}. Depending on the implementation the
	 * serialized data may have different formats, such as XML or binary data.
	 * </p>
	 * 
	 * <p>
	 * Note that a particular implementation will only be able to de-serialize
	 * data which has been serialized by the same implementation.
	 * </p>
	 * 
	 * @param out
	 * @return
	 * @throws PersistenceValidateExceptions
	 */
	public void saveState(PersistentState state, OutputStream out)
			throws PersistenceException, PersistenceValidateExceptions;

	/**
	 * <p>
	 * De-serializes an state from the data read from the provided
	 * <code>is</code>. Depending on the implementation the serialized data
	 * may have different formats, such as XML or binary data.
	 * </p>
	 * 
	 * <p>
	 * Note that a particular implementation will only be able to de-serialize
	 * data which has been serialized by the same implementation.
	 * </p>
	 * 
	 * @param reader
	 * @return
	 * 
	 * @param is
	 * @return
	 */
	public Object getObject(InputStream is);
	
	/**
	 * <p>
	 * Serializes the object "obj" and writes the serialized data in
	 * the provided {@link OutputStream}. Depending on the implementation the
	 * serialized data may have different formats, such as XML or binary data.
	 * </p>
	 * 
	 * <p>
	 * Note that a particular implementation will only be able to de-serialize
	 * data which has been serialized by the same implementation.
	 * </p>
	 * 
	 * @param os
	 * @param obj
	 */
	public void putObject(OutputStream os, Object obj);
	
	/**
	 * <p>
	 * Sets the validation which will be applied in {@link #getState(Object)},
	 * {@link #create(PersistentState)} methods. Validation ensures that
	 * persisted or de-persisted objects match the declared definition (which
	 * must have been previously registered by using
	 * {@link #registerClass(Class, DynStruct)}).
	 * </p>
	 * 
	 * <p>
	 * When automatic validation is enabled (MANDATORY or
	 * MANDATORY_IF_DECLARED), a ValidationException will be thrown by
	 * {@link #getState(Object)}, {@link #create(PersistentState)} if a
	 * validation error is found.
	 * </p>
	 * 
	 * @param validationMode
	 *            On of the following values: {@link #DISABLED},
	 *            {@link #MANDATORY} or {@link #MANDATORY_IF_DECLARED}
	 * 
	 * @see #validateAll(PersistentState)
	 * @see #registerClass(Class, DynStruct)
	 * 
	 * @throws PersistenceException
	 *             If the mode is not supported by this manager
	 */
	public void setAutoValidation(int validationMode)
			throws PersistenceException;

	/**
	 * <p>
	 * Gets the validation which will be applied in {@link #getState(Object)},
	 * {@link #create(PersistentState)} methods.
	 * 
	 * @return The current mode for automatic validation: {@link #DISABLED},
	 *         {@link #MANDATORY} or {@link #MANDATORY_IF_DECLARED}
	 * 
	 * @see #validateAll(PersistentState)
	 * @see #registerClass(Class, DynStruct)
	 */
	public int getAutoValidation();

	public Factories getFactories();

}
