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
 * Exception thrown when a service through a Provider or a Service
 * implementation is needed but the provider is not registered.
 * 
 * @author 2009- César Ordiñana - gvSIG team
 */
public class NotRegisteredException extends ServiceException {

	private static final long serialVersionUID = 7440696464556384843L;

	private final static String MESSAGE_KEY = "_NotRegisteredException";
	private final static String MESSAGE_FORMAT = "No provider or service "
			+ "implementation has been registered with the name '%(name)'";

	/**
	 * Creates a new {@link NotRegisteredException}.
	 * 
	 * @param name
	 *            the name of the provider or service implementation which is
	 *            not registered
	 */
	public NotRegisteredException(String name) {
		super(MESSAGE_FORMAT, MESSAGE_KEY, serialVersionUID);
		setValue("name", name);
	}
}