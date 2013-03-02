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

import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.service.spi.ServiceManager;

/**
 * Base {@link Manager} implementation for managers which depend on the
 * registration of multiple service implementations.
 * 
 * @author 2009- César Ordiñana - gvSIG team
 */
public abstract class AbstractMultiServiceImplManager implements Manager {

	private final ServiceManager serviceManager;

	public AbstractMultiServiceImplManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public DynObject createServiceParameters(String serviceName)
			throws ServiceException {
		return getServiceManager().createServiceParameters(serviceName);
	}

	/**
	 * Returns the service Manager
	 * 
	 * @return the {@link ServiceManager}
	 */
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

}