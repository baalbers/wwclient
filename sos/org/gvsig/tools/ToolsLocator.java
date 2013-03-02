package org.gvsig.tools;

import org.gvsig.tools.dataTypes.DataTypesManager;
import org.gvsig.tools.dispose.DisposableManager;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.extensionpoint.ExtensionPointManager;
import org.gvsig.tools.extensionpoint.impl.DefaultExtensionPointManager;
import org.gvsig.tools.i18n.I18nManager;
import org.gvsig.tools.locator.AbstractLocator;
import org.gvsig.tools.locator.Locator;
import org.gvsig.tools.locator.LocatorException;
import org.gvsig.tools.operations.OperationManager;
import org.gvsig.tools.packageutils.PackageManager;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.task.TaskStatusManager;
import org.gvsig.tools.util.ServiceLoader;
import org.gvsig.tools.util.impl.DefaultServiceLoader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class ToolsLocator extends AbstractLocator {

	private static final String LOCATOR_NAME = "ToolsLocator";

	public static final String PERSISTENCE_MANAGER_NAME =
			"org.gvsig.tools.persistence.manager";

	private static final String PERSISTENCE_MANAGER_DESCRIPTION =
			"Persistence Manager of gvSIG";

	public static final String OPERATION_MANAGER_NAME =
			"org.gvsig.tools.operation.manager";

	private static final String OPERATION_MANAGER_DESCRIPTION =
			"Operation Manager of gvSIG";

	public static final String DYNOBJECT_MANAGER_NAME =
			"org.gvsig.tools.dynobject.manager";

	private static final String DYNOBJECT_MANAGER_DESCRIPTION =
			"DynObject Manager of gvSIG";

	public static final String DISPOSABLE_MANAGER_NAME =
			"org.gvsig.tools.dispose.manager";

	private static final String DISPOSABLE_MANAGER_DESCRIPTION =
		"Disposable Manager";

	public static final String DATATYPES_MANAGER_NAME =
		"org.gvsig.tools.datatypes.manager";

	private static final String DATATYPES_MANAGER_DESCRIPTION =
		"Datatypes Manager";

	public static final String SERVICE_LOADER_NAME =
			"org.gvsig.tools.service.loader";

	private static final String SERVICE_LOADER_DESCRIPTION =
			"Default Service Loader";
	
	public static final String I18N_MANAGER_NAME =
		"org.gvsig.tools.i18n.manager";

	private static final String I18N_MANAGER_DESCRIPTION =
		"Default I18n Manager";

	public static final String TASKSTATUS_MANAGER_NAME =
		"org.gvsig.tools.taststatus.manager";

	private static final String TASKSTATUS_MANAGER_DESCRIPTION =
		"Default Tast Status Manager";

	public static final String PACKAGE_MANAGER_NAME =
			"org.gvsig.tools.package.manager";

	private static final String PACKAGE_MANAGER_DESCRIPTION =
			"Default Package Manager";
	/**
	 * Unique instance.
	 */
	private static final ToolsLocator instance = new ToolsLocator();

	// Comma list of xml pull parser factories, parsers or serializers
	private String xmlPullParserFactoryClassNames = ""
			+ "org.xmlpull.mxp1.MXParserFactory," + // MXP1 (XPP3) factory
			"org.kxml2.io.KXmlParser," + // KXML2 parser
			"org.kxml2.io.KXmlSerializer"; // KXML2 serializer

	private ToolsLocator() {
		// Register default ServiceLoader
		registerDefault(SERVICE_LOADER_NAME, SERVICE_LOADER_DESCRIPTION,
				DefaultServiceLoader.class);
	}

	/**
	 * Return the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static ToolsLocator getInstance() {
		return instance;
	}

	public String getLocatorName() {
		return LOCATOR_NAME;
	}

	/**
	 * Return a reference to PersistenceManager.
	 * 
	 * @return a reference to PersistenceManager
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static PersistenceManager getPersistenceManager()
			throws LocatorException {
		return (PersistenceManager) getInstance().get(PERSISTENCE_MANAGER_NAME);
	}

	/**
	 * Registers the Class implementing the PersistenceManager interface.
	 * 
	 * @param clazz
	 *            implementing the PersistenceManager interface
	 */
	public static void registerPersistenceManager(Class clazz) {
		getInstance().register(PERSISTENCE_MANAGER_NAME,
				PERSISTENCE_MANAGER_DESCRIPTION, clazz);
	}

	public static void registerDefaultPersistenceManager(Class clazz) {
		getInstance().registerDefault(PERSISTENCE_MANAGER_NAME,
				PERSISTENCE_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to OperationManager.
	 * 
	 * @return a reference to OperationManager
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static OperationManager getOperationManager()
			throws LocatorException {
		return (OperationManager) getInstance().get(OPERATION_MANAGER_NAME);
	}

	/**
	 * Registers the Class implementing the OperationManager interface.
	 * 
	 * @param clazz
	 *            implementing the OperationManager interface
	 */
	public static void registerOperationManager(Class clazz) {
		getInstance().register(OPERATION_MANAGER_NAME,
				OPERATION_MANAGER_DESCRIPTION, clazz);
	}

	public static void registerDefaultOperationManager(Class clazz) {
		getInstance().registerDefault(OPERATION_MANAGER_NAME,
				OPERATION_MANAGER_DESCRIPTION, clazz);
	}

	public static ExtensionPointManager getExtensionPointManager() {
		return DefaultExtensionPointManager.getManager();
	}

	/**
	 * Return a reference to DynObjectManager.
	 * 
	 * @return a reference to DynObjectManager
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static DynObjectManager getDynObjectManager()
			throws LocatorException {
		return (DynObjectManager) getInstance().get(DYNOBJECT_MANAGER_NAME);
	}

	/**
	 * Registers the Class implementing the DynObjectManager interface.
	 * 
	 * @param clazz
	 *            implementing the {@link DynObjectManager} interface
	 */
	public static void registerDynObjectManager(Class clazz) {
		getInstance().register(DYNOBJECT_MANAGER_NAME,
				DYNOBJECT_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to DisposableManager.
	 * 
	 * @return a reference to {@link DisposableManager}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static DisposableManager getDisposableManager()
			throws LocatorException {
		return (DisposableManager) getInstance().get(DISPOSABLE_MANAGER_NAME);
	}

	/**
	 * Registers the Class implementing the DisposableManager interface.
	 * 
	 * @param clazz
	 *            implementing the {@link DisposableManager} interface
	 */
	public static void registerDisposableManager(Class clazz) {
		getInstance().register(DISPOSABLE_MANAGER_NAME,
				DISPOSABLE_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to {@link ServiceLoader}.
	 * 
	 * @return a reference to {@link ServiceLoader}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static ServiceLoader getServiceLoader() throws LocatorException {
		return (ServiceLoader) getInstance().get(SERVICE_LOADER_NAME);
	}

	/**
	 * Registers the Class implementing the {@link ServiceLoader} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link ServiceLoader} interface
	 */
	public static void registerServiceLoader(Class clazz) {
		getInstance().register(SERVICE_LOADER_NAME, SERVICE_LOADER_DESCRIPTION,
				clazz);
	}
	
	/**
	 * Return a reference to {@link I18nManager}.
	 * 
	 * @return a reference to {@link I18nManager}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static I18nManager getI18nManager() throws LocatorException {
		return (I18nManager) getInstance().get(I18N_MANAGER_NAME);
	}

	/**
	 * Registers the Class implementing the {@link I18nManager} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link I18nManager} interface
	 */
	public static void registerI18nManager(Class clazz) {
		getInstance().register(I18N_MANAGER_NAME, I18N_MANAGER_DESCRIPTION,
				clazz);
	}

	/**
	 * Registers the default Class implementing the {@link I18nManager}
	 * interface.
	 * 
	 * @param clazz
	 *            implementing the {@link I18nManager} interface
	 */
	public static void registerDefaultI18nManager(Class clazz) {
		getInstance().registerDefault(I18N_MANAGER_NAME,
				I18N_MANAGER_DESCRIPTION, clazz);
	}
	
	/**
	 * Registers the Class implementing the DataTypesManager interface.
	 * 
	 * @param clazz
	 *            implementing the {@link DataTypesManag} interface
	 */
	public static void registerDataTypesManager(Class clazz) {
		getInstance().register(DATATYPES_MANAGER_NAME,
				DATATYPES_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Registers the default Class implementing the DataTypesManager interface.
	 * 
	 * @param clazz
	 *            implementing the {@link DataTypesManager} interface
	 */
	public static void registerDefaultDataTypesManager(Class clazz) {
		getInstance().registerDefault(DATATYPES_MANAGER_NAME,
				DATATYPES_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to {@link DataTypesManager}.
	 * 
	 * @return a reference to {@link DataTypesManager}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static DataTypesManager getDataTypesManager()
			throws LocatorException {
		return (DataTypesManager) getInstance().get(DATATYPES_MANAGER_NAME);
	}

	/**
	 * Returns the comma separated list of XmlPullParserFactory, XmlPullParser
	 * or XmlSerializer implementations to be used.
	 * <p>
	 * This parameter must be passed to the {@link XmlPullParserFactory} class
	 * to get an instance of the factory with an available implementation. That
	 * class will use the list to try to instance the classes included, and will
	 * use the first one available in the list order.
	 * </p>
	 * <p>
	 * <strong>Example getting an {@link XmlPullParser}:</strong>
	 * 
	 * <pre>
	 * XmlPullParserFactory factory = XmlPullParserFactory.newInstance(ToolsLocator
	 * 		.getInstance().getXmlPullParserFactoryClassNames(), null);
	 * 
	 * XmlPullParser xpp = factory.newPullParser();
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * <strong>Example getting an {@link XmlSerializer}:</strong>
	 * 
	 * <pre>
	 * XmlPullParserFactory factory = XmlPullParserFactory.newInstance(ToolsLocator
	 * 		.getInstance().getXmlPullParserFactoryClassNames(), null);
	 * 
	 * XmlSerializer serializer = factory.newSerializer();
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @return the xmlPullParserFactoryClassNames
	 * @see XmlPullParserFactory#newInstance(String, Class).
	 */
	public String getXmlPullParserFactoryClassNames() {
		return xmlPullParserFactoryClassNames;
	}

	/**
	 * Sets a comma separated list of XmlPullParserFactory, XmlPullParser or
	 * XmlSerializer implementations to be used.
	 * 
	 * @param xmlPullParserFactoryClassNames
	 *            the comma separated list of XmlPullParserFactory class name
	 */
	public void setXmlPullParserFactoryClassNames(
			String xmlPullParserFactoryClassNames) {
		this.xmlPullParserFactoryClassNames = xmlPullParserFactoryClassNames;
	}

	/**
	 * Registers the Class implementing the {@link TaskStatusManager} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link TaskStatusManager} interface
	 */
	public static void registerTaskStatusManager(Class clazz) {
		getInstance().register(TASKSTATUS_MANAGER_NAME,
				TASKSTATUS_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Registers the default Class implementing the {@link TaskStatusManager} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link TaskStatusManager} interface
	 */
	public static void registerDefaultTaskStatusManager(Class clazz) {
		getInstance().registerDefault(TASKSTATUS_MANAGER_NAME,
				TASKSTATUS_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to {@link TaskStatusManager}.
	 * 
	 * @return a reference to {@link TaskStatusManager}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static TaskStatusManager getTaskStatusManager()
			throws LocatorException {
		return (TaskStatusManager) getInstance().get(TASKSTATUS_MANAGER_NAME);
	}



	/**
	 * Registers the Class implementing the {@link PackageManager} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link PackageManager} interface
	 */
	public static void registerPackageManager(Class clazz) {
		getInstance().register(PACKAGE_MANAGER_NAME,
				PACKAGE_MANAGER_DESCRIPTION, clazz);
	}
	/**
	 * Registers the default Class implementing the {@link PackageManager} interface.
	 * 
	 * @param clazz
	 *            implementing the {@link PackageManager} interface
	 */
	public static void registerDefaultPackageManager(Class clazz) {
		getInstance().registerDefault(PACKAGE_MANAGER_NAME,
				PACKAGE_MANAGER_DESCRIPTION, clazz);
	}

	/**
	 * Return a reference to {@link PackageManager}.
	 * 
	 * @return a reference to {@link PackageManager}
	 * @throws LocatorException
	 *             if there is no access to the class or the class cannot be
	 *             instantiated
	 * @see Locator#get(String)
	 */
	public static PackageManager getPackageManager()
			throws LocatorException {
		return (PackageManager) getInstance().get(PACKAGE_MANAGER_NAME);
	}

}