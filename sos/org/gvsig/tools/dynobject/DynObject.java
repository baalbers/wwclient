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
 * 2008 {DiSiD Technologies}  {Create DynObjects implementation}
 */
package org.gvsig.tools.dynobject;

import org.gvsig.tools.dynobject.exception.DynFieldNotFoundException;
import org.gvsig.tools.dynobject.exception.DynMethodException;

/**
 * @author <a href="mailto:jjdelcerro@gvsig.org">Joaqu�n Jos� del Cerro</a>
 * @author <a href="mailto:cordin@disid.com">C�sar Ordi�ana</a>
 */
public interface DynObject {

	DynClass getDynClass();

    void implement(DynClass dynClass);

    void delegate(DynObject dynObject);

	Object getDynValue(String name)  throws DynFieldNotFoundException ;

	void setDynValue(String name, Object value)  throws DynFieldNotFoundException ;

	boolean hasDynValue(String name);

	Object invokeDynMethod(String name, DynObject context) throws DynMethodException;

	Object invokeDynMethod(int code, DynObject context) throws DynMethodException;

	void clear();
}
