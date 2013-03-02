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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.extensionpoint.ExtensionPoint;
import org.gvsig.tools.extensionpoint.ExtensionPointManager;
import org.gvsig.tools.service.Service;
import org.gvsig.tools.service.ServiceException;

/**
 * Base {@link ServiceManager} implementation which stores the registered
 * {@link ServiceFactory} objects into a {@link Map}, using the name as the key.
 * 
 * @author 2009- César Ordiñana - gvSIG team
 */
public abstract class AbstractServiceManager implements ServiceManager {

	public void addServiceFactory(ServiceFactory serviceFactory) {
		ExtensionPointManager epm = ToolsLocator.getExtensionPointManager();
		ExtensionPoint ep = epm.add(this.getRegistryKey(), this
				.getRegistryDescription());
		ep.append(serviceFactory.getName(), null, serviceFactory);
		serviceFactory.initialize();
	}

	protected abstract String getRegistryKey();

	protected abstract String getRegistryDescription();

	public Service createService(DynObject serviceParameters)
			throws ServiceException {
		String serviceName = serviceParameters.getDynClass().getName();
		ServiceFactory factory = getServiceFactory(serviceName);
		return factory == null ? null : factory.create(serviceParameters, this);
	}

	public DynObject createServiceParameters(String serviceName)
			throws ServiceException {
		return getServiceFactory(serviceName).createParameters();
	}

	private ServiceFactory getServiceFactory(String serviceName)
			throws ParametersException, NotRegisteredException {
		ExtensionPointManager epm = ToolsLocator.getExtensionPointManager();
		ExtensionPoint ep = epm.get(this.getRegistryKey());
		ServiceFactory factory = null;
		try {
			factory = ((ServiceFactory) ep.create(serviceName));
		} catch (InstantiationException e) {
			throw new ParametersException("Can't instance service factory", e);
		} catch (IllegalAccessException e) {
			throw new ParametersException("Can't access service factory", e);
		}

		if (factory == null) {
			throw new NotRegisteredException(serviceName);
		}
		return factory;
	}
	
	public List getServiceFactories() {
    	List factories = new ArrayList(); 
    	ExtensionPointManager epm = ToolsLocator.getExtensionPointManager();
		ExtensionPoint ep = epm.add(this.getRegistryKey(),this.getRegistryDescription());

		Iterator it = ep.iterator();
		while( it.hasNext() ) {
			ExtensionPoint.Extension extension = (ExtensionPoint.Extension) it.next();
			try {
				ServiceFactory factory = (ServiceFactory) extension.create();
				factories.add(factory);
			} catch (InstantiationException e) {
				// Ignore, ServiceFactory are ExtensionSingleton and can't throw this exception
			} catch (IllegalAccessException e) {
				// Ignore, ServiceFactory are ExtensionSingleton and can't throw this exception
			}
		}
		return factories;
    }
}