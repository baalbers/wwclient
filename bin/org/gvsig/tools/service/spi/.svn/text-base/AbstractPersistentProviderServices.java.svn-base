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
 * 2009 {}  {{Task}}
 */
package org.gvsig.tools.service.spi;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.Persistent;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.service.Service;

/**
 * Base Persistent {@link ProviderServices}.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">C�sar Ordi�ana</a> - gvSIG team
 */
public abstract class AbstractPersistentProviderServices extends
		AbstractProviderServices implements Persistent {

	private static final String PROVIDER_SERVICES_DYNCLASS_NAME =
			"ProviderServices";

	private static final String FIELD_SERVICE = "service";

	/**
	 * Empty constructor to be used only for persistence purposes.
	 */
	public AbstractPersistentProviderServices() {
		// Nothing to do
		registerProviderServicesPersistence();
	}

	public final void loadFromState(PersistentState state)
			throws PersistenceException {
		// Load own properties
		setService((Service) state.get(FIELD_SERVICE));

		// Load child class properties
		doLoadFromState(state);
	}

	public final void saveToState(PersistentState state)
			throws PersistenceException {
		// Persist own properties
		state.set(FIELD_SERVICE, getService());

		// Persist child class properties
		doSaveToState(state);
	}

	private void registerProviderServicesPersistence() {
		DynObjectManager dynObjectManager = ToolsLocator.getDynObjectManager();
		DynStruct dynClass =
				dynObjectManager.get(PROVIDER_SERVICES_DYNCLASS_NAME);
		if (dynClass == null) {
			dynClass = createProviderServicesDynClass(dynObjectManager);
		}

		// Extend the base definition with the one of the child class
		DynStruct childDynClass = getProviderServicesChildDynClass();
		if (childDynClass == null) {
			childDynClass = dynClass;
		} else {
			childDynClass.extend(dynClass);
		}
	}

	private DynStruct createProviderServicesDynClass(
			DynObjectManager dynObjectManager) {
		// Add the ProviderFactory base DynClass definition.
		PersistenceManager pmanager= ToolsLocator.getPersistenceManager();
		DynStruct definition = pmanager.addDefinition(getClass(), PROVIDER_SERVICES_DYNCLASS_NAME, (String)null, null, null);
		
		// Service parameter
		definition.addDynFieldObject(FIELD_SERVICE).setMandatory(true);

		return definition;
	}

	/**
	 * Return the {@link DynClass} of the persisted attributes of the child
	 * class.
	 * 
	 * @return the {@link DynClass} for persistence of the child service class
	 */
	protected abstract DynClass getProviderServicesChildDynClass();

	/**
	 * Set the state of the child class persistent attributes from the state
	 * passed as parameter.
	 * 
	 * @param state
	 *            to load the attribute values from
	 * @see Persistent#loadFromState(PersistentState)
	 */
	protected abstract void doLoadFromState(PersistentState state);

	/**
	 * Saves the internal state of the child class persistent attributes on the
	 * provided PersistentState object.
	 * 
	 * @param state
	 *            to save the attribute values to
	 */
	protected abstract void doSaveToState(PersistentState state);
}