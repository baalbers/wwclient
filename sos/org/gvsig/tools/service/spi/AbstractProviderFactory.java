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
import org.gvsig.tools.service.ServiceException;

/**
 * Base {@link ProviderFactory} implementation.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public abstract class AbstractProviderFactory implements ProviderFactory {

	private DynClass parametersDynClass;

	/**
	 * Creates a new {@link AbstractProviderFactory}.
	 */
	public AbstractProviderFactory() {
		setParametersDynClass(createParametersDynClass());
	}

	public String getName() {
		return getParametersDynClass().getName();
	}

	public DynObject createParameters() {
		return ToolsLocator.getDynObjectManager().createDynObject(
				parametersDynClass);
	}

	public final Provider create(DynObject parameters, ProviderServices services)
			throws ServiceException {
		try {
			ToolsLocator.getDynObjectManager().validate(parameters);
		} catch (DynObjectValidateException e) {
			throw new ServiceParametersValidationException(e);
		}
		Provider provider = doCreate(parameters, services);
		provider.setProviderServices(services);
		return provider;
	}

	/**
	 * Returns the {@link DynClass} of the parameters for this factory
	 * {@link Provider}s.
	 * 
	 * @return the parameters {@link DynClass}
	 */
	private DynClass getParametersDynClass() {
		return parametersDynClass;
	}

	/**
	 * Sets the {@link DynClass} of the parameters for this factory
	 * {@link Provider}s.
	 * 
	 * @param parametersDynClass
	 *            the parameters {@link DynClass}
	 */
	protected void setParametersDynClass(DynClass parametersDynClass) {
		this.parametersDynClass = parametersDynClass;
	}

	/**
	 * Creates a new {@link Provider} with the given parameters and
	 * {@link ProviderServices}.
	 * 
	 * @param parameters
	 *            to create the {@link Provider}
	 * @param services
	 *            to be used by the {@link Provider}
	 * @return the created provider
	 */
	protected abstract Provider doCreate(DynObject parameters,
			ProviderServices services);

	/**
	 * Creates the {@link DynClass} of the parameters for this factory
	 * {@link Provider}s.
	 * 
	 * @return the {@link DynClass} of the parameters for this factory
	 *         {@link Provider}s.
	 */
	protected abstract DynClass createParametersDynClass();
}