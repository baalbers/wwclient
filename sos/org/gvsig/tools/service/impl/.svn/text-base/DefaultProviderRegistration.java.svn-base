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
package org.gvsig.tools.service.impl;

import java.util.Set;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.service.spi.AbstractProviderRegistration;
import org.gvsig.tools.service.spi.ProviderFactory;
import org.gvsig.tools.service.spi.ProviderRegistration;
import org.gvsig.tools.util.ServiceLoader;

/**
 * {@link ProviderRegistration} implementation which finds
 * {@link ProviderFactory} objects automatically using the {@link ServiceLoader}
 * .
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public class DefaultProviderRegistration extends AbstractProviderRegistration {

	private final ServiceLoader serviceLoader;

	public DefaultProviderRegistration() {
		this(ToolsLocator.getServiceLoader());
	}

	public DefaultProviderRegistration(ServiceLoader serviceLoader) {
		this.serviceLoader = serviceLoader;
	}

	private ServiceLoader getServiceLoader() {
		return serviceLoader;
	}

	protected Set findProviderFactories(Class providerInterface) {
		return getServiceLoader().load(providerInterface);
	}

	protected Set findProviderFactories(Class providerInterface,
			ClassLoader classLoader) {
		return getServiceLoader().load(providerInterface, classLoader);
	}
}