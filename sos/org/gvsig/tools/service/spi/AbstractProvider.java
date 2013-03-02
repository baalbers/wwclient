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

/**
 * Base {@link Provider} implementation.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">C�sar Ordi�ana</a> - gvSIG team
 */
public abstract class AbstractProvider implements Provider {

	private ProviderServices providerServices;

	/**
	 * Creates a new {@link Provider} with the provider services to use.
	 * 
	 * @param providerServices
	 *            to use
	 */
	public AbstractProvider(ProviderServices providerServices) {
		this.providerServices = providerServices;
	}

	public void setProviderServices(ProviderServices services) {
		this.providerServices = services;
	}

	/**
	 * Returns the {@link ProviderServices} to be used by this {@link Provider}.
	 * 
	 * @return the providerServices to use
	 */
	protected ProviderServices getProviderServices() {
		return providerServices;
	}
}