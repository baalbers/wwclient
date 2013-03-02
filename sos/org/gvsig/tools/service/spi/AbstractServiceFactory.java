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
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.exception.DynObjectValidateException;
import org.gvsig.tools.service.Service;
import org.gvsig.tools.service.ServiceException;

/**
 * Base {@link ServiceFactory} implementation.
 * 
 * @author 2009- César Ordiñana - gvSIG team
 */
public abstract class AbstractServiceFactory implements ServiceFactory {

	private DynClass parametersDynClass;

	/**
	 * Creates a new {@link AbstractServiceFactory}.
	 */
	public AbstractServiceFactory() {
		setParametersDynClass(createParametersDynClass());
	}

	public String getName() {
		return getParametersDynClass().getName();
	}

	public DynObject createParameters() {
		return ToolsLocator.getDynObjectManager().createDynObject(
				parametersDynClass);
	}

	public final Service create(DynObject parameters,
			ServiceManager serviceManager)
			throws ServiceException {
		try {
			ToolsLocator.getDynObjectManager().validate(parameters);
		} catch (DynObjectValidateException e) {
			throw new ServiceParametersValidationException(e);
		}
		Service service = doCreate(parameters, serviceManager);
		return service;
	}

	/**
	 * Returns the {@link DynClass} of the parameters for this factory
	 * {@link Service}s.
	 * 
	 * @return the parameters {@link DynClass}
	 */
	private DynClass getParametersDynClass() {
		return parametersDynClass;
	}

	/**
	 * Sets the {@link DynClass} of the parameters for this factory
	 * {@link Service}s.
	 * 
	 * @param parametersDynClass
	 *            the parameters {@link DynClass}
	 */
	protected void setParametersDynClass(DynClass parametersDynClass) {
		this.parametersDynClass = parametersDynClass;
	}

	/**
	 * Creates a new {@link Service} with the given parameters and
	 * {@link ServiceManager}.
	 * 
	 * @param parameters
	 *            to create the {@link Service}
	 * @param serviceManager
	 *            to be used by the {@link Service}
	 * @return the created service
	 * @throws ServiceException
	 *             if the parameters are not valid or there is an error creating
	 *             the {@link Service}
	 */
	protected abstract Service doCreate(DynObject parameters,
			ServiceManager serviceManager) throws ServiceException;

	/**
	 * Creates the {@link DynClass} of the parameters for this factory
	 * {@link Service}s.
	 * 
	 * @return the {@link DynClass} of the parameters for this factory
	 *         {@link Service}s.
	 */
	protected abstract DynClass createParametersDynClass();
}