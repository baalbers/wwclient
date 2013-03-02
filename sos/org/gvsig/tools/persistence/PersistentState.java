package org.gvsig.tools.persistence;

import java.io.File;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.exception.PersistenceException;

public interface PersistentState {
	/**
	 * Gets the name of the java class corresponding to this persistent state
	 *
	 * @return The class name of the java class represented by this state
	 */
	public String getTheClassName();

	/**
	 * Returns the struct definition associated to this state
	 * 
	 * @return the DynStruct definition of the state.
	 */
	public DynStruct getDefinition();
	
	
	public PersistentContext getContext();
	
	/**
	 * Gets an <code>int</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>int</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public int getInt(String name) throws PersistenceException;

	/**
	 * Gets an <code>long</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>long</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public long getLong(String name) throws PersistenceException;

	/**
	 * Gets a <code>Date</code> property.
	 * 
	 * @param name
	 * @return The <code>Date</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public Date getDate(String name)
			throws PersistenceException;

	/**
	 * Gets a <code>double</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>double</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public double getDouble(String name)
			throws PersistenceException;

	/**
	 * Gets a <code>float</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>float</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public float getFloat(String name) throws PersistenceException;

	/**
	 * Gets a <code>boolean</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>boolean</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public boolean getBoolean(String name)
			throws PersistenceException;

	/**
	 * Gets a <code>String</code> property.
	 *
	 * @param name
	 *            The name of the property to get
	 *
	 * @return The <code>String</code> property associated to the provided name
	 * @throws PersistenceException
	 */
	public String getString(String name)
			throws PersistenceException;

	/**
	 * Gets a {@link List} property.
	 * 
	 * <strong>Don't use the returned List as it is, as it may not work as you
	 * expect. Instead, choose you own implementation and do something
	 * like:</strong> <code>
	 * List myAttribute = new ArrayList(state.getList("prop"))
	 * </code>
	 * 
	 * @param name
	 *            The name of the property to get
	 * 
	 * @return The {@link List} property value associated to the provided name
	 * 
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public List getList(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of the class given. This is useful to
	 * be able to cast the returned Object[] to the real class. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * <p>
	 * Ex: <code> 
	 * Color[] colors = (Color[])state.getArray("colors", Color.class);
	 * </code>
	 * </p>
	 * 
	 * @param name
	 *            The name of the property to get
	 * @param valueClass
	 *            the class of the array elements
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public Object[] getArray(String name, Class valueClass)
			throws PersistenceException;

	/**
	 * Returns an array whose elements are of boolean basic type. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to get
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public boolean[] getBooleanArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of int basic type. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to get
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public int[] getIntArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of long basic type. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to get
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public long[] getLongArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of float basic type. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to get
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public float[] getFloatArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of double basic type. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to get
	 * @return the array of elements
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public double[] getDoubleArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of Date type. 
	 * 
	 * To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 * @return
	 * @throws PersistenceException
	 */
	public Date[] getDateArray(String name) throws PersistenceException;

	/**
	 * Returns an array whose elements are of String type. 
	 * 
	 * To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 *  
	 * @param name
	 * @return
	 * @throws PersistenceException
	 */
	public String[] getStringArray(String name) throws PersistenceException;

	/**
	 * Gets a {@link Map} property. <strong>Don't use the returned Map as is, as
	 * it may not be a real usable Map implementation.</strong>
	 * 
	 * <strong>Don't use the returned Map as it is, as it may not work as you
	 * expect. Instead, choose you own implementation and do something
	 * like:</strong> <code>
	 * Map myAttribute = new HashMap(state.getSet("prop"))
	 * </code>
	 * 
	 * @param name
	 *            The name of the property to get
	 * 
	 * @return The {@link Map} property value associated to the provided name
	 * 
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public Map getMap(String name) throws PersistenceException;

	/**
	 * Gets a {@link Set} property.
	 * 
	 * <strong>Don't use the returned Set as it is, as it may not work as you
	 * expect. Instead, choose you own implementation and do something
	 * like:</strong> <code>
	 * Set myAttribute = new HashSet(state.getSet("prop"))
	 * </code>
	 * 
	 * @param name
	 *            The name of the property to get
	 * 
	 * @return The {@link Set} property value associated to the provided name
	 * 
	 * @throws PersistenceException
	 *             if there is an error getting the property value
	 */
	public Set getSet(String name) throws PersistenceException;

	public URL getURL(String name) throws PersistenceException;
	
	public URI getURI(String name) throws PersistenceException;
	
	public File getFile(String name) throws PersistenceException;

	/**
	 * Gets an <code>Object</code> property.
	 * 
	 * @param name
	 *            The name of the property to get
	 * 
	 * @return The <code>Object</code> property associated to the provided name
	 * 
	 * @throws PersistenceException
	 */
	public Object get(String name) throws PersistenceException;

	/**
	 * <p>
	 * Gets an <code>Iterator</code> over properties of types {@link List},
	 * {@link Set} or {@link Map}.
	 * </p>
	 * 
	 * @param name
	 *            The name of the property to get
	 * 
	 * @return The <code>Iterator</code> associated to the property value of
	 *         provided name
	 * @throws PersistenceException
	 */
	public Iterator getIterator(String name) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type String.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The String object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, String value) throws PersistenceException;

	public void set(String name, File value) throws PersistenceException;
	
	public void set(String name, URL value) throws PersistenceException;

	public void set(String name, URI value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type int.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The int value to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, int value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type long.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The long value to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, long value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type double.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The double value to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, double value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type float.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The float value to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, float value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type boolean.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The boolean value to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, boolean value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type Persistent.
	 * </p>
	 * 
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param obj
	 *            The Persistent object to be stored in the state.
	 * 
	 * @throws PersistenceException
	 */
	public void set(String name, Persistent obj)
			throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link List}.
	 * </p>
	 * <p>
	 * The items of the list must be persistence supported types instance.
	 * </p>
	 * <p>
	 * <i>{@link #get(String)} return an read only {@link List} instance after
	 * {@link #load(Reader)}</i>
	 * </p>
	 * 
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param value
	 *            The {@link List} object to be stored in the state.
	 * 
	 * @throws PersistenceException
	 */
	public void set(String name, List value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array. To be able to store
	 * and load a property as an array, the type of the property defined in the
	 * {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, Object[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of int. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, int[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of long. To be able to
	 * store and load a property as an array, the type of the property defined
	 * in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, long[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of float. To be able
	 * to store and load a property as an array, the type of the property
	 * defined in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, float[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of double. To be able
	 * to store and load a property as an array, the type of the property
	 * defined in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, double[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of Date. 
	 * 
	 * To be able
	 * to store and load a property as an array, the type of the property
	 * defined in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 * @param value the Date array to set.
	 * @throws PersistenceException
	 */
	public void set(String name, Date[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of String. 
	 * 
	 * To be able
	 * to store and load a property as an array, the type of the property
	 * defined in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 * @param value
	 * @throws PersistenceException
	 */
	public void set(String name, String[] value) throws PersistenceException;

	/**
	 * Sets a property of type {@link List} with an array of boolean. To be able
	 * to store and load a property as an array, the type of the property
	 * defined in the {@link DynStruct} must be List.
	 * 
	 * @param name
	 *            The name of the property to set
	 * @param value
	 *            the value to set
	 * @throws PersistenceException
	 *             if there is an error setting the property value
	 */
	public void set(String name, boolean[] value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Set}.
	 * </p>
	 * <p>
	 * The items of the set must be persistence supported type instances.
	 * </p>
	 * <p>
	 * <i>{@link #get(String)} return an read only {@link Set} instance after
	 * {@link #load(Reader)}</i>
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Set} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Set value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Map}.
	 * </p>
	 * <p>
	 * The values and keys of the map must be persistence supported type
	 * instances.
	 * </p>
	 * <i>{@link #get(String)} return an read only {@link Map} instance after
	 * {@link #load(Reader)}</i> </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Map} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Map value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Boolean}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Boolean} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Boolean value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Date}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Date} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Date value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Integer}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Integer} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Integer value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Long}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Long} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Long value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Float}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Float} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Float value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link Double}.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Double} object to be stored in the state.
	 *
	 * @throws PersistenceException
	 */
	public void set(String name, Double value) throws PersistenceException;

	/**
	 * <p>
	 * Sets a property of type {@link List} (<i>like do
	 * {@link #set(String, List)} </i>) filled with the values provided by a
	 * {@link Iterator}
	 * </p>
	 * <p>
	 * The items of the iteration must be persistence supported types instance.
	 * </p>
	 *
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The iterator to get values to store in the list property.
	 *
	 * @throws PersistenceException
	 * @see {@link #set(String, List)}
	 */
	public void set(String name, Iterator it)
			throws PersistenceException;


	/**
	 * <p>
	 * Sets a property.
	 * </p>
	 * <p>
	 * <code>value</value> must be a supported type or manager must have
	 *  a {@link PersistenceFactory} that know how persist it.
	 * </p>
	 * 
	 * @param name
	 *            The name of the property to store <i>(must be a valid Java
	 *            identifier)</i>
	 * @param it
	 *            The {@link Float} object to be stored in the state.
	 * 
	 * @throws PersistenceException
	 */
	public void set(String name, Object value) throws PersistenceException;

	public void setNull(String name) throws PersistenceException;
	
	/**
	 * <p>Gets an iterator over the names of the properties contained
	 * in this PersistentState.</p>
	 *
	 * @return An iterator which provides the name of all the
	 * properties contained in this state.
	 */
	public Iterator getNames();


	/**
	 * Informs that a property is set or not.
	 *
	 * @param name
	 * @return
	 */
	public boolean hasValue(String name);
}