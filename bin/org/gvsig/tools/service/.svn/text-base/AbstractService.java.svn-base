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
import org.gvsig.tools.service.spi.AbstractProviderServices;
import org.gvsig.tools.service.spi.Provider;
import org.gvsig.tools.service.spi.ProviderManager;
import org.gvsig.tools.service.spi.ProviderServices;

/**
 * {@link Service} base parent implementation, delegating in the child classes
 * the retrieval of the {@link ProviderManager}.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">C�sar Ordi�ana</a> - gvSIG team
 */
public abstract class AbstractService implements Service {

	private DynObject serviceParameters;
	private ProviderServices providerServices;
	private Provider provider;

	/**
	 * Empty constructor to be used only for persistence purposes.
	 */
	public AbstractService() {
		// Nothing to do
	}

	/**
	 * Creates a new {@link AbstractService}.
	 * 
	 * @param serviceParameters
	 *            the parameters of the current service
	 * @throws ServiceException
	 *             if there is an error with the parameters
	 */
	public AbstractService(DynObject serviceParameters) throws ServiceException {
		init(serviceParameters, createProviderServices());
	}

	/**
	 * Returns the service parameters this services was created with
	 * 
	 * @return the service parameters
	 */
	public DynObject getServiceParameters() {
		return serviceParameters;
	}

	/**
	 * Initialices the service.
	 * 
	 * @param serviceParameters
	 *            the service parameters
	 * @param providerServices
	 *            the provider services
	 * @throws ServiceException
	 *             thrown while creating the provider
	 */
	protected void init(DynObject serviceParameters,
			ProviderServices providerServices) throws ServiceException {
		setServiceParameters(serviceParameters);
		setProviderServices(providerServices);
		setProvider(createProvider(serviceParameters));
		((AbstractProviderServices)providerServices).setService(this);
	}

	/**
	 * Returns the provider related to this service.
	 * 
	 * @return the provider
	 */
	protected Provider getProvider() {
		return provider;
	}

	/**
	 * Returns the provider services to be used by the provider of this service.
	 * 
	 * @return the provider services
	 */
	protected ProviderServices getProviderServices() {
		return providerServices;
	}

	/**
	 * Returns the reference to the {@link ProviderManager}.
	 * 
	 * @return the ProviderManager
	 */
	protected abstract ProviderManager getProviderManager();

	private void setServiceParameters(DynObject serviceParameters) {
		this.serviceParameters = serviceParameters;
	}

	private void setProvider(Provider provider) {
		this.provider = provider;
	}

	private Provider createProvider(DynObject serviceParameters)
			throws ServiceException {
		return getProviderManager().createProvider(serviceParameters,
				providerServices);
	}

	private ProviderServices createProviderServices() {
		return getProviderManager().createProviderServices(this);
	}

	private void setProviderServices(ProviderServices providerServices) {
		this.providerServices = providerServices;
	}
}