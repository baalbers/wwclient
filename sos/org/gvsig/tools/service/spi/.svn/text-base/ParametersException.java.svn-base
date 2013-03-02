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

import org.gvsig.tools.service.ServiceException;

/**
 * Exception thrown when a service is needed but the provider or service
 * implementation is not registered.
 * 
 * @author 2009- <a href="badia_jos@gvsig.org">José Badía</a> - gvSIG team
 */
public class ParametersException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7302330967991851480L;
	private final static String MESSAGE_KEY = "_ParametersException";
	private final static String MESSAGE_FORMAT = "Can't create parameters for '%(name)'";

	/**
	 * Creates a new {@link ParametersException}.
	 * 
	 * @param name
	 *            the name of the provider which is not registered
	 */
	public ParametersException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("name", name);
	}

	public ParametersException(String name, Throwable e) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		this.initCause(e);
		setValue("name", name);
	}

}