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
package org.gvsig.tools.dynobject.impl;

import org.gvsig.tools.dynobject.DynClassName;

/**
 * Default {@link DynClassName} implementation.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public class DefaultDynClassName implements DynClassName {
	private static final String SEPARATOR = ":";
	
	private String name;
	private String namespace;
	
	public DefaultDynClassName(String namespace, String name) {
		setNamespace(namespace);
		setName(name);
	}
	
	public DefaultDynClassName(String fullname) {
		int x=fullname.indexOf(SEPARATOR);
		int y=fullname.lastIndexOf(SEPARATOR);
		if( x>-1 ) {
			// Separator should only be present once
			if (x==y){
				setNamespace(fullname.substring(0, x));
				setName(fullname.substring(x+1));				
			}else{
				throw new IllegalArgumentException("Fullname '" + fullname + "' not allowed. Only one '" + SEPARATOR + "' is possible.");				
			}
		} else {
			this.namespace = null;
			setName(fullname);
		}
	}
	
	public DefaultDynClassName(String[] name) {
		setNamespace(name[0]);
		setName(name[1]);
	}
	
	public String getName() {
		return name;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public String getFullName() {
    	if( namespace == null ) {
    		return name;
    	}
    	return namespace + SEPARATOR + name;
	}

	public void setNamespace(String namespace) {
		if(namespace!=null){
            if (namespace.indexOf(SEPARATOR) <= -1) {
				this.namespace = namespace;
			}else{
				throw new IllegalArgumentException("Namespace '" + namespace + "' not allowed. Character " + SEPARATOR + " forbidden whithin a dynClass' namespace'");
			}
		}else{
			this.namespace = null;
		}
	}

	public void setName(String name) {
		if(name!=null){
            if (name.indexOf(SEPARATOR) <= -1) {
				this.name = name;
			}else{
				throw new IllegalArgumentException("Name '" + name + "' not allowed. Character '" + SEPARATOR + "' is not valid within a dynClass' name.");
			}
		}else{
			throw new IllegalArgumentException("Null value unsupported for a dynClass' name.");
		}
	}

	public int hashCode() {
		return getFullName().hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof DynClassName) {
			DynClassName obj2 = (DynClassName) obj;
			return getFullName().equalsIgnoreCase(obj2.getFullName());
		}
		return false;
	}
	
	public String toString() {
		return this.getFullName();
	}
}
