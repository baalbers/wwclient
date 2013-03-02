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

package org.gvsig.tools.lang;

/**
 * {@link java.lang.Cloneable} extension to define the
 * {@link java.lang.Cloneable#clone()} as a public method.
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public interface Cloneable extends java.lang.Cloneable {

	/**
	 * Creates a copy of the object.
	 * 
	 * @see {@link Object#clone()}.
	 * 
	 * @return a copy of the object
	 * @throws CloneNotSupportedException if the instance of the object cannot
	 * be cloned. As this is extending {@link java.lang.Cloneable} so
	 * its sure it implements it, so this exception may be used for problems
	 * on specific object instances.
	 */
	Object clone() throws CloneNotSupportedException;

}