/* gvSIG. Geographic Information System of the Valencian Government
 *
 * Copyright (C) 2007-2008 Infrastructures and Transports Department
 * of the Valencian Government (CIT)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 */

/*
 * AUTHORS (In addition to CIT):
 * 2009 IVER T.I   {{Task}}
 */

package org.gvsig.tools.persistence.impl;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.Persistent;
import org.gvsig.tools.persistence.PersistentContext;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceTypeNotSupportedException;
import org.gvsig.tools.persistence.impl.exception.PersistenceIllegalStateTheClassNameNotSetException;
import org.gvsig.tools.persistence.impl.exception.PersistenceInvalidPropertyNameException;
import org.gvsig.tools.persistence.impl.exception.PersistenceInvalidTypeForPropertyException;
import org.gvsig.tools.persistence.impl.exception.PersistenceUnsuportedMapKeyTypeException;
import org.gvsig.tools.persistence.impl.exception.PersistenceValueNotFoundException;
import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices.ObjectReference;
import org.gvsig.tools.persistence.spi.PersistentIdentifier;
import org.gvsig.tools.persistence.spi.PersistentStateServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPersistentState implements
		PersistentStateServices {

	private static final Logger logger = LoggerFactory
			.getLogger(PersistentState.class);

	private static final Pattern VALID_NAME_PATTERN = Pattern
			.compile("[\\w][\\d\\w_]*");

	private static final List validStdTypeClasses = Collections
			.unmodifiableList(Arrays.asList(new Class[] { // All need to be
															// immutable
					Integer.class, Long.class, Float.class, Double.class,
							Boolean.class, String.class, Date.class,
							File.class, URL.class, URI.class }));

	private Map values = new LinkedHashMap();
	private PersistentContextServices context;
	private PersistentIdentifier id;
	private PersistenceManagerServices manager;
	private String theClassName = null;
	private PersistenceFactory factory;

	public AbstractPersistentState(PersistenceManagerServices manager,
			PersistentContextServices context, PersistentIdentifier id) {
		this.manager = manager;
		this.context = context;
		this.id = id;
		values = new HashMap();
	}

	public void setFactory(PersistenceFactory factory) {
		this.factory = factory;
	}
	
	public DynStruct getDefinition() {
		DynStruct definition = this.factory.getDefinition(this.theClassName);
		return definition;
	}

	private DynStruct getDefinitionCheckNull() {
		DynStruct definition = getDefinition();
		if (definition == null) {
			throw new NullPointerException(
					"Can't locate definition for the class '"
							+ this.theClassName + "' in the factory '"
							+ this.factory.getClass().getName()
							+ "', managed classes are '"
							+ this.factory.getManagedClasses().toString()
							+ "'.");
		}
		return definition;
	}

	public Object get(String name) throws PersistenceException {
		Object ret = values.get(name);
		if (ret == null) {
			// We are asked for an attribute not defined in the dynstruct
			if (!values.containsKey(name) && !definitionHasField(name)) {
				throw new PersistenceValueNotFoundException(name);
			}
			return null;
		}
		return get(ret);
	}

	public List getList(String name) throws PersistenceException {
		return (List) get(name);
	}

	public Map getMap(String name) throws PersistenceException {
		return (Map) get(name);
	}

	public Set getSet(String name) throws PersistenceException {
		return (Set) get(name);
	}

	private Object get(Object obj) throws PersistenceException {
		if (obj instanceof ObjectReference) {
			ObjectReference ref = (ObjectReference) obj;
			return ref.getObject();
		}
		if (obj instanceof List) {
			List result = new ArrayList(((List) obj).size());
			getValues(result, (((List) obj).iterator()));
			return result;
		}
		return obj;
	}

	private void getValues(List result, Iterator iterator)
			throws PersistenceException {
		while (iterator.hasNext()) {
			result.add(get(iterator.next()));
		}
	}

	public boolean getBoolean(String name) throws PersistenceException {
		return ((Boolean) get(name)).booleanValue();
	}

	public double getDouble(String name) throws PersistenceException {
		return ((Double) get(name)).doubleValue();
	}

	public File getFile(String name) throws PersistenceException {
		return (File) get(name);
	}

	public URL getURL(String name) throws PersistenceException {
		return (URL) get(name);
	}

	public URI getURI(String name) throws PersistenceException {
		return (URI) get(name);
	}

	public Date getDate(String name) throws PersistenceException {
		return (Date) get(name);
	}

	public float getFloat(String name) throws PersistenceException {
		return ((Float) get(name)).floatValue();
	}

	public int getInt(String name) throws PersistenceException {
		return ((Integer) get(name)).intValue();
	}

	public Iterator getIterator(String name) throws PersistenceException {
		return ((Collection) get(name)).iterator();
	}

	public long getLong(String name) throws PersistenceException {
		return ((Long) get(name)).longValue();
	}

	public Object[] getArray(String name, Class valueClass)
			throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		Object array = Array.newInstance(valueClass, valueList.size());
		return valueList.toArray((Object[]) array);
	}

	public boolean[] getBooleanArray(String name) throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		boolean[] values = new boolean[valueList.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = ((Boolean) valueList.get(i)).booleanValue();
		}
		return values;
	}

	public int[] getIntArray(String name) throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		int[] values = new int[valueList.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = ((Number) valueList.get(i)).intValue();
		}
		return values;
	}

	public long[] getLongArray(String name) throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		long[] values = new long[valueList.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = ((Number) valueList.get(i)).longValue();
		}
		return values;
	}

	public float[] getFloatArray(String name) throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		float[] values = new float[valueList.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = ((Number) valueList.get(i)).floatValue();
		}
		return values;
	}

	public double[] getDoubleArray(String name) throws PersistenceException {
		List valueList = getList(name);
		if (valueList == null) {
			return null;
		}
		double[] values = new double[valueList.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = ((Number) valueList.get(i)).doubleValue();
		}
		return values;
	}

	public Date[] getDateArray(String name) throws PersistenceException {
		return (Date[]) this.getArray(name, Date.class);
	}

	public String[] getStringArray(String name) throws PersistenceException {
		return (String[]) this.getArray(name, String.class);
	}

	public Iterator getNames() {
		return values.keySet().iterator();
	}

	public String getString(String name) throws PersistenceException {
		return ((String) get(name));
	}

	public void setNull(String name) throws PersistenceException {
		setValue(name, null);
	}

	public void set(String name, String value) throws PersistenceException {
		setValue(name, value);
	}

	public void set(String name, File value) throws PersistenceException {
		setValue(name, value);
	}

	public void set(String name, URL value) throws PersistenceException {
		setValue(name, value);
	}

	public void set(String name, URI value) throws PersistenceException {
		setValue(name, value);
	}

	public void set(String name, int value) throws PersistenceException {
		setValue(name, new Integer(value));
	}

	public void set(String name, long value) throws PersistenceException {
		setValue(name, new Long(value));
	}

	public void set(String name, double value) throws PersistenceException {
		setValue(name, new Double(value));

	}

	public void set(String name, float value) throws PersistenceException {
		setValue(name, new Float(value));

	}

	public void set(String name, boolean value) throws PersistenceException {
		setValue(name, new Boolean(value));
	}

	public void set(String name, Persistent obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Object obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Map obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, List obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Iterator obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Object[] values) throws PersistenceException {
		set(name, values == null ? null : Arrays.asList(values));
	}

	public void set(String name, Date[] values) throws PersistenceException {
		set(name, values == null ? null : Arrays.asList(values));
	}

	public void set(String name, String[] values) throws PersistenceException {
		set(name, values == null ? null : Arrays.asList(values));
	}

	public void set(String name, boolean[] value) throws PersistenceException {
		if (value == null) {
			setValue(name, null);
		} else {
			List valueList = new ArrayList(value.length);
			for (int i = 0; i < value.length; i++) {
				valueList.add(value[i] ? Boolean.TRUE : Boolean.FALSE);
			}
			set(name, valueList);
		}
	}

	public void set(String name, int[] value) throws PersistenceException {
		if (value == null) {
			setValue(name, null);
		} else {
			List valueList = new ArrayList(value.length);
			for (int i = 0; i < value.length; i++) {
				valueList.add(new Integer(value[i]));
			}
			set(name, valueList);
		}
	}

	public void set(String name, long[] value) throws PersistenceException {
		if (value == null) {
			setValue(name, null);
		} else {
			List valueList = new ArrayList(value.length);
			for (int i = 0; i < value.length; i++) {
				valueList.add(new Long(value[i]));
			}
			set(name, valueList);
		}
	}

	public void set(String name, float[] value) throws PersistenceException {
		if (value == null) {
			setValue(name, null);
		} else {
			List valueList = new ArrayList(value.length);
			for (int i = 0; i < value.length; i++) {
				valueList.add(new Float(value[i]));
			}
			set(name, valueList);
		}
	}

	public void set(String name, double[] value) throws PersistenceException {
		if (value == null) {
			setValue(name, null);
		} else {
			List valueList = new ArrayList(value.length);
			for (int i = 0; i < value.length; i++) {
				valueList.add(new Double(value[i]));
			}
			set(name, valueList);
		}
	}

	public void set(String name, Set obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Boolean obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Integer obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Long obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Float obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Double obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	public void set(String name, Date obj) throws PersistenceException {
		setValue(name, getObjectToPersist(obj, name));
	}

	protected Object getObjectToPersist(Object theOriginal)
			throws PersistenceException {
		return getObjectToPersist(theOriginal, null);
	}

	/**
	 * Checks class of <code>theOriginal</code> and transforms it if is
	 * necessary.<br>
	 * 
	 * @param theOriginal
	 * @return
	 * @throws PersistenceException
	 */
	private Object getObjectToPersist(Object theOriginal, String propName)
			throws PersistenceException {
		DynStruct definition = null;
		DynField field = null;
		try {
			if (theOriginal == null) {
				return null;
			} else if (validStdTypeClasses.contains(theOriginal.getClass())) {
				// FIXME: No esta comprobando que el tipo sea el correcto
				return theOriginal;
			}
			if (theOriginal instanceof File) {
				// File no es una clase final, asi que convertimos
				// a File para curarnos en salud.
				// FIXME: No esta comprobando que el tipo sea el correcto
				return new File(((File) theOriginal).toURI());
			}
			definition = this.getDefinitionCheckNull();
			if (propName != null) {
				field = definition.getDynField(propName);
			}
			if (theOriginal instanceof Persistent) {
				if (field != null) {
					Class classOfValue = field.getClassOfValue();
					if (classOfValue == null) {
						throw new NullPointerException(
								"Class of value for field '"
										+ definition.getFullName() + "' of '"
										+ field.getName() + "' can't be null.");
					}
					if (!classOfValue.isAssignableFrom(theOriginal.getClass())) {
						throw new PersistenceInvalidTypeForPropertyException(
								propName, definition, field, theOriginal);
					}
				}
				ObjectReference ref = context.get(theOriginal);
				if (ref == null) {
					PersistentStateServices state = manager.createState(
							theOriginal, context);
					ref = context.get(state);
				}
				return ref;

			} else if ((manager.getFactories().get(theOriginal)) != null) {
				if (field != null) {
					Class classOfValue = field.getClassOfValue();
					if (classOfValue == null) {
						throw new NullPointerException(
								"Class of value for field '"
										+ definition.getFullName() + "' of '"
										+ field.getName() + "' can't be null.");
					}
					if (!classOfValue.isAssignableFrom(theOriginal.getClass())) {
						throw new PersistenceInvalidTypeForPropertyException(
								propName, definition, field, theOriginal);
					}
				}
				ObjectReference ref = context.get(theOriginal);
				if (ref == null) {
					PersistentStateServices state = manager.createState(
							theOriginal, context);
					ref = context.get(state);
				}
				return ref;

			} else if (theOriginal instanceof Map) {
				if (field != null && field.getType() != DataTypes.MAP) {
					throw new PersistenceInvalidTypeForPropertyException(
							propName, definition, field, theOriginal);
				}
				Map result = new LinkedHashMap(((Map) theOriginal).size());
				storeValues(result, (Map) theOriginal);
				return result;

			} else if (theOriginal instanceof Set) {
				if (field != null && field.getType() != DataTypes.SET) {
					throw new PersistenceInvalidTypeForPropertyException(
							propName, definition, field, theOriginal);
				}
				Set result = new LinkedHashSet(((Set) theOriginal).size());
				storeValues(result, ((Set) theOriginal).iterator());
				return result;

			} else if (theOriginal instanceof List) {
				if (field != null
						&& !(field.getType() == DataTypes.LIST || field
								.getType() == DataTypes.ARRAY)) {
					throw new PersistenceInvalidTypeForPropertyException(
							propName, definition, field, theOriginal);
				}
				List result = new ArrayList(((List) theOriginal).size());
				storeValues(result, (((List) theOriginal).iterator()));
				return result;

			} else if (theOriginal instanceof Iterator) {
				if (field != null
						&& !(field.getType() == DataTypes.LIST || field
								.getType() == DataTypes.ARRAY)) {
					throw new PersistenceInvalidTypeForPropertyException(
							propName, definition, field, theOriginal);
				}
				List result = new ArrayList();

				storeValues(result, (Iterator) theOriginal);
				return result;

			} else {
				if (this.manager.getAutoValidation() == PersistenceManager.MANDATORY) {
					throw new PersistenceTypeNotSupportedException(
							theOriginal.getClass(), propName);
				} else {
					logger.error("Persistence type '"
							+ theOriginal.getClass().getName()
							+ "' not supported.");
					return null;
				}
			}
		} catch (PersistenceException ex) {
			PersistentContextServices context = (PersistentContextServices) this
					.getContext();
			if (!context.getCollectErrors()) {
				throw ex;
			}
			context.addError(ex);
			return null;
		} catch (Exception ex) {
			PersistentContextServices context = (PersistentContextServices) this
					.getContext();
			if (!context.getCollectErrors()) {
				throw new PersistenceException(ex);
			}
			context.addError(ex);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gvsig.tools.persistence.impl.ImplementationPersistentState#getId()
	 */
	public PersistentIdentifier getId() {
		return id;
	}

	public void setValue(String name, Object value) throws PersistenceException {
		try {
			if (this.theClassName == null) {
				throw new PersistenceIllegalStateTheClassNameNotSetException();
			}
			if (!VALID_NAME_PATTERN.matcher(name).matches()) {
				throw new PersistenceInvalidPropertyNameException(name);
			}
			this.values.put(name, value);

		} catch (PersistenceException ex) {
			PersistentContextServices context = (PersistentContextServices) this
					.getContext();
			if (!context.getCollectErrors()) {
				throw ex;
			}
			context.addError(ex);
		} catch (Exception ex) {
			PersistentContextServices context = (PersistentContextServices) this
					.getContext();
			if (!context.getCollectErrors()) {
				throw new PersistenceException(ex);
			}
			context.addError(ex);
		}
	}

	public String getTheClassName() {
		return theClassName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gvsig.tools.persistence.impl.ImplementationPersistentState#
	 * setTheClassName(java.lang.String)
	 */
	public void setTheClassName(String className) {
		theClassName = className;
	}
	
	private void storeValues(Collection storage, Iterator iter)
			throws PersistenceException {
		while (iter.hasNext()) {
			storage.add(getObjectToPersist(iter.next()));
		}

	}

	private void storeValues(Map storage, Map originalStorage)
			throws PersistenceException {
		Iterator iter = originalStorage.entrySet().iterator();
		Entry orgEntry;
		Object key;
		Object value;

		while (iter.hasNext()) {
			orgEntry = (Entry) iter.next();
			key = orgEntry.getKey();

			if (key == null) {
				// Nothing to do
			} else if (key instanceof String) {
				// Nothing to do
			} else if (key instanceof Number) {
				// Nothing to do
			} else if (key instanceof Boolean) {
				// Nothing to do
			} else if (key instanceof Persistent) {
				key = getObjectToPersist(key);
			} else {
				throw new PersistenceUnsuportedMapKeyTypeException(orgEntry
						.getKey().getClass());
			}

			value = getObjectToPersist(orgEntry.getValue());

			storage.put(key, value);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gvsig.tools.persistence.impl.ImplementationPersistentState#getContext
	 * ()
	 */
	public PersistentContext getContext() {
		return context;
	}

	// private int size() {
	// return this.values.size();
	// }
	//
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gvsig.tools.persistence.impl.ImplementationPersistentState#hasValue
	 * (java.lang.String)
	 */
	public boolean hasValue(String name) {
		return this.values.containsKey(name);
	}

	public Object getValue(String name) {
		return values.get(name);
	}

	//
	// private ObjectReference createReference(Integer id) {
	// return new DefaultObjectReference(id);
	// }

	/**
	 * Returns if the definition related to this state has a defined field
	 */
	private boolean definitionHasField(String name) {
		DynStruct definition = manager.getDefinition(getTheClassName());
		return definition != null && definition.getDynField(name) != null;
	}
}