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

import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.service.Service;
import org.gvsig.tools.service.ServiceException;

/**
 * Manages the registration of {@link ServiceFactory} objects and the creation
 * of Services.
 * 
 * @author 2009- César Ordiñana - gvSIG team
 */
public interface ServiceManager {

	/**
	 * Adds a new {@link ServiceFactory} to the registry.
	 * 
	 * @param serviceFactory
	 *            to add
	 */
	void addServiceFactory(ServiceFactory serviceFactory);

	/**
	 * Creates a new {@link Service}.
	 * 
	 * @param serviceParameters
	 *            for the {@link Service}
	 * @return the new {@link Service}
	 * @throws ServiceException
	 *             if the parameters are not valid or there is an error creating
	 *             the {@link Provider}
	 */
	Service createService(DynObject serviceParameters) throws ServiceException;

	/**
	 * Creates the parameters for the {@link Service} created by the factory
	 * with the given name.
	 * 
	 * @param serviceName
	 *            name of the factory to create the {@link Service}
	 * @return the service parameters
	 */
	DynObject createServiceParameters(String serviceName)
			throws ServiceException;
}