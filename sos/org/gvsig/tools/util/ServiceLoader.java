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
 * 2009 {DiSiD Technologies}  {{Task}}
 */
package org.gvsig.tools.util;

import java.util.Set;

/**
 * Loads a set of instances of classes which implement or extend an interface or
 * class.
 * <p>
 * Has the same purpose as the java.util.ServiceLoader class available since JDK
 * 1.6.
 * </p>
 * 
 * @see <a
 *      href="http://java.sun.com/javase/6/docs/api/java/util/ServiceLoader.html">java.util.ServiceLoader</a>
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public interface ServiceLoader {

	/**
	 * Loads a {@link Set} of a object instances which implement or extended a
	 * common service interface or class. The services will be loaded using the
	 * current {@link ClassLoader} and the list of {@link ClassLoader}s provided
	 * with the {@link #addClassLoader(ClassLoader)} method, if any.
	 * 
	 * @param serviceClass
	 *            the interface or class which the loaded objects must implement
	 *            or extend
	 * @return the {@link Set} of loaded object instances
	 */
	Set load(Class serviceClass);

	/**
	 * Loads a {@link Set} of a object instances which implement or extended a
	 * common service interface or class. The classes are loaded through the
	 * provided {@link ClassLoader}
	 * 
	 * @param serviceClass
	 *            the interface or class which the loaded objects must implement
	 *            or extend
	 * @param classLoader
	 *            the {@link ClassLoader} to load the classes from
	 * @return the {@link Set} of loaded object instances
	 */
	Set load(Class serviceClass, ClassLoader classLoader);

	/**
	 * Adds a {@link ClassLoader} to use to find services, in the case we don't
	 * provide one.
	 * 
	 * @param classLoader
	 */
	void addClassLoader(ClassLoader classLoader);
}