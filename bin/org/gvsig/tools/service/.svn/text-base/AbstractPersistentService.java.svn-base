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
package org.gvsig.tools.service;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.Persistent;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.service.spi.ProviderServices;

/**
 * Base {@link Service} implementation which is also {@link Persistent}.
 * <p>
 * The persistence is based on the service parameters, which are persisted by
 * this implementation. Child implementation services must persist their own
 * additional properties.
 * </p>
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public abstract class AbstractPersistentService extends AbstractService
		implements Persistent {

	private static final String SERVICE_DYNCLASS_NAME = "Service";

	private static final String FIELD_PARAMETERS = "parameters";

	private static final String FIELD_PROVIDER_SERVICES = "provider-services";

	/**
	 * Empty constructor to be used only for persistence purposes.
	 */
	public AbstractPersistentService() {
		registerServicePersistence();
	}

	/**
	 * @see AbstractService#AbstractService(DynObject).
	 */
	public AbstractPersistentService(DynObject serviceParameters)
			throws ServiceException {
		super(serviceParameters);
		registerServicePersistence();
	}

	public void loadFromState(PersistentState state)
			throws PersistenceException {
		DynObject serviceParameters = (DynObject) state.get(FIELD_PARAMETERS);
		ProviderServices providerServices =
				(ProviderServices) state.get(FIELD_PROVIDER_SERVICES);
		try {
			init(serviceParameters, providerServices);
		} catch (ServiceException e) {
			throw new PersistenceException(e);
		}
	}

	public void saveToState(PersistentState state) throws PersistenceException {
		state.set(FIELD_PARAMETERS, getServiceParameters());
		state.set(FIELD_PROVIDER_SERVICES, getProviderServices());
	}

	private void registerServicePersistence() {
		DynObjectManager dynObjectManager = ToolsLocator.getDynObjectManager();
		DynStruct dynClass = dynObjectManager.get(SERVICE_DYNCLASS_NAME);
		if (dynClass == null) {
			dynClass = createServiceDynClass(dynObjectManager);
		}

		// Extend the base definition with the one of the child class
		DynStruct childDynClass = getServiceChildDynClass();
		if (childDynClass == null) {
			childDynClass = dynClass;
		} else {
			childDynClass.extend(dynClass);
		}
		
	}

	private DynStruct createServiceDynClass(DynObjectManager dynObjectManager) {
		// Add the ProviderFactory base DynClass definition.

		PersistenceManager pmanager= ToolsLocator.getPersistenceManager();
		DynStruct definition = pmanager.addDefinition(getClass(), SERVICE_DYNCLASS_NAME, (String)null, null, null);

		// Service parameters field
		definition.addDynFieldObject(FIELD_PARAMETERS).setMandatory(true);
		// Provider services field
		definition.addDynFieldObject(FIELD_PROVIDER_SERVICES).setMandatory(true);

		return definition;
	}

	/**
	 * Return the {@link DynClass} of the persisted attributes of the child
	 * class.
	 * 
	 * @return the {@link DynClass} for persistence of the child service class
	 */
	protected abstract DynClass getServiceChildDynClass();

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