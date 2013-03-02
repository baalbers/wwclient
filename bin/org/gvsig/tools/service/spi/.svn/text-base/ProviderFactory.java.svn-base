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
import org.gvsig.tools.extensionpoint.ExtensionSingleton;
import org.gvsig.tools.service.ServiceException;

/**
 * Creates new {@link Provider}s and its parameters.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public interface ProviderFactory extends ExtensionSingleton {

	/**
	 * Returns the name of the providers created by this factory.
	 * 
	 * @return the provider name
	 */
	String getName();

	/**
	 * Creates a new {@link Provider}.
	 * 
	 * @param parameters
	 *            for the {@link Provider}
	 * @param services
	 *            to be used by the {@link Provider}
	 * @return the new {@link Provider}
	 * @throws ServiceException
	 *             if the parameters are not valid or there is an error creating
	 *             the {@link Provider}
	 */
	Provider create(DynObject parameters, ProviderServices services)
			throws ServiceException;

	/**
	 * Creates the parameters for the {@link Provider} created by this factory.
	 * 
	 * @return the provider parameters
	 */
	DynObject createParameters();

	/**
	 * Initialices the factory.
	 */
	void initialize();
}