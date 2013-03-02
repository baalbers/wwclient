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

import java.util.Iterator;
import java.util.Set;

/**
 * Base {@link ProviderRegistration} implementation which delegates on child
 * classed the search of {@link ProviderFactory} objects.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public abstract class AbstractProviderRegistration implements
		ProviderRegistration {

	public void registerProviderFactories(ProviderManager providerManager,
			Class providerInterface) {
		registerProviders(providerManager,
				findProviderFactories(providerInterface));
	}

	public void registerProviderFactories(ProviderManager providerManager,
			Class providerInterface, ClassLoader classLoader) {
		registerProviders(providerManager, findProviderFactories(
				providerInterface, classLoader));
	}

	/**
	 * Returns the list of {@link ProviderFactory} objects which implement or
	 * extend the given interface or class.
	 * 
	 * @param providerInterface
	 *            of the returned {@link ProviderFactory} objects
	 * @return the found {@link ProviderFactory} objects
	 */
	protected abstract Set findProviderFactories(Class providerInterface);

	/**
	 * Returns the list of {@link ProviderFactory} objects which implement or
	 * extend the given interface or class.
	 * 
	 * @param providerInterface
	 *            of the returned {@link ProviderFactory} objects
	 * @param classLoader
	 *            to use to load or find the {@link ProviderFactory} objects
	 * @return the found {@link ProviderFactory} objects
	 */
	protected abstract Set findProviderFactories(Class providerInterface,
			ClassLoader classLoader);

	private void registerProviders(ProviderManager providerManager,
			Set providers) {
		if (providers != null) {
			for (Iterator iterator = providers.iterator(); iterator.hasNext();) {
				ProviderFactory providerFactory =
						(ProviderFactory) iterator.next();
				providerManager.addProviderFactory(providerFactory);
			}
		}
	}
}