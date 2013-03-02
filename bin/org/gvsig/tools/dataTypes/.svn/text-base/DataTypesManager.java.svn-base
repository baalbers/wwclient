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
package org.gvsig.tools.dataTypes;

import java.util.Iterator;

/**
 * Manages data types.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public interface DataTypesManager {

    public interface Coercion {

        public Object coerce(Object value) throws CoercionException;
    }

    public DataType get(int type);

    public boolean isValidType(int type);

    public boolean isObject(int type);

    public boolean isContainer(int type);

    public String getTypeName(int type);

    public int getType(String name);

    public Class getDefaultClass(int type);

    /**
     * Returns a DataType whose default class is the one provided.
     * As there may be more than one {@link DataType} objects with the same
     * default class, it will return only one of them.
     * 
     * @param defaultClass
     *            the default class of the data type asked
     * @return the DataType whose default class is the one provided.
     */
    public DataType getDataType(Class defaultClass);

    public String getSubtype(int type);

    public int addtype(int type, String subtype, String name,
        Class defaultClass, Coercion coercion);

    public Coercion getCoercion(int type);

    public void setCoercion(int type, Coercion coercion);

    public void addCoercion(int type, Coercion coercion);

    public Object coerce(int type, Object value) throws CoercionException;

    public Iterator iterator();

}
