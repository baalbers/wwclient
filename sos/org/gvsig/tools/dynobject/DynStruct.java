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

import org.gvsig.tools.dynobject.exception.DynObjectValidateException;


/**
 * @author <a href="mailto:jjdelcerro@gvsig.org">Joaquín José del Cerro</a>
 * @author <a href="mailto:cordin@disid.com">Cèsar Ordiñana</a>
 */
public interface DynStruct {

    String getName();

	String getNamespace();

	String getFullName();

    String getDescription();
    
	void setNamespace(String namespace);

	void setDescription(String description);

    /*************/
    /* DynFields */
    /*************/

    DynField getDynField(String name);

    DynField getDeclaredDynField(String name);

    DynField[] getDynFields();

    DynField[] getDeclaredDynFields();

    DynField addDynField(String name);

	// /**
	// * Adds a new field to the struct
	// * @param name
	// * @return
	// */
	// DynField addDynFieldSingle(String name);

	DynField addDynFieldBoolean(String name);

    DynField addDynFieldInt(String name);

	DynField addDynFieldLong(String name);

	DynField addDynFieldFloat(String name);

    DynField addDynFieldDouble(String name);

	DynField addDynFieldString(String name);

	DynField addDynFieldDate(String name);

	DynField addDynFieldList(String name);

	DynField addDynFieldArray(String name);

	DynField addDynFieldMap(String name);

	DynField addDynFieldSet(String name);

	DynField addDynFieldObject(String name);

	DynField addDynFieldFile(String name);

	DynField addDynFieldFolder(String name);

	DynField addDynFieldURL(String name);

	DynField addDynFieldURI(String name);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldString(String)
	 */
    DynField addDynFieldSingle(String name, int type, Object defaultValue,
	    boolean mandatory, boolean persistent);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldString(String)
	 */
    DynField addDynFieldSingle(String name, int type, Object defaultValue);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldRange(String)
	 */
    DynField addDynFieldRange(String name, int type, Object defaultValue,
	    Object min, Object max, boolean mandatory, boolean persistent);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldRange(String)
	 */
    DynField addDynFieldRange(String name, int type, Object defaultValue,
	    Object min, Object max);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldChoice(String)
	 */
    DynField addDynFieldChoice(String name, int type, Object defaultValue,
	    DynObjectValueItem[] values, boolean mandatory, boolean persistent);

	/**
	 * @deprecated to be removed in gvSIG 2.1.0
	 * @see #addDynFieldChoice(String)
	 */
    DynField addDynFieldChoice(String name, int type, Object defaultValue,
	    DynObjectValueItem[] values);

    void removeDynField(String name);

    void validate(DynObject object) throws DynObjectValidateException;
    
    DynObject newInstance();

    /***************************/
    /* Parent DynClass objects */
    /***************************/

    void extend(DynStruct struct);

    void extend(String namespace, String structName);

    void extend(String structName);

    /**
     * 
     * Removes a given dynStruct from the current superDynClasses of this dynClass. If it is not contained, does nothing.
     *  
     * @param dynStruct the dynStruct to be removed.
     */
    void remove(DynStruct superDynStruct);


    DynStruct[] getSuperDynStructs();

    boolean isInstance(DynObject dynObject);

    boolean isExtendable(DynStruct dynStruct);
}