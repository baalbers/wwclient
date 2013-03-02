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
 * 2008 {DiSiD Technologies}   {Create a base Locator implementation}
 */
package org.gvsig.tools.library;

import java.util.Set;

/**
 * Library initialization and registration.
 * 
 * @author <a href="mailto:cordin@disid.com">Cèsar Ordiñana</a>
 */
public interface Library {

	/**
	 * Constant definitions for library types.
	 * @author gvSIG team
	 */
	public static interface TYPE {
		public static final String API = "api";
		public static final String IMPL = "impl";
		public static final String SERVICE = "service";
	}
	
    /**
     * Performs all the initializations of the library, only related to himself:
     * register implementation classes through the Locator, start services, etc.
     * 
     * @throws LibraryException
     *             if there is an error while performing the initialization of
     *             the library
     */
    void initialize() throws LibraryException;

    /**
     * Performs all the initializations or validations related to the library
     * dependencies, as getting references to objects through other libraries
     * Locators.
     * 
     * @throws LibraryException
     *             if there is an error while loading an implementation of the
     *             library
     */
    void postInitialize() throws LibraryException;

	/**
	 * Returns the {@link Library} class this library is related to.
	 * @return the {@link Library} class this library is related to
	 */
	public Class getLibrary();
	
	/**
	 * Returns the type of the Library.
	 * @see TYPE.
	 * @return
	 */
	public String getType();
	
	/**
	 * Returns a Set of required libraries and their types.
	 * @return a Set of required libraries
	 */
	public Set getRequireds();
    
    /**
     * Returns if a given library is required.
     * 
     * @param lib
     *            the library to check if it is required
     * @return if is required
     */
    public boolean isRequired(Library lib);

    /**
     * Returns if a given library class is required.
     * 
     * @param libClass
     *            the library Class to check if it is required
     * @return if is required
     */
    public boolean isRequired(Class libClass);

    /**
     * Returns a priority number to range this implementation
     * in case multiple ones are within the libraries initialization.
     * 
     * @return a priority number, 0 by default.
     */
    public int getPriority();
    
    public void doRegistration();

}