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
package org.gvsig.tools.library;

/**
 * Initializes the libraries of the application by finding the available
 * {@link Library} implementations to instance and call them.
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public interface LibrariesInitializer {

    /**
     * Initializes all available {@link Library} objects. The initialization
     * process will stop if any exception is thrown by any of the libraries.
     */
    void initialize();

    /**
     * Initializes all available {@link Library} objects. The initialization
     * process will stop or not if any exception is thrown by any of the
     * libraries depending on the ignoreerrors parameter.
     * 
     * @param ignoreerrors
     *            if library initialization errors will stop de process
     */
    void initialize(boolean ignoreerrors);

    /**
     * Post-initializes all available {@link Library} objects. The
     * initialization
     * process will stop if any exception is thrown by any of the libraries.
     */
    void postInitialize();

    /**
     * Post-initializes all available {@link Library} objects. The
     * initialization
     * process will stop or not if any exception is thrown by any of the
     * libraries depending on the ignoreerrors parameter.
     * 
     * @param ignoreerrors
     *            if library initialization errors will stop de process
     */
    void postInitialize(boolean ignoreerrors);

    /**
     * Initializes and post-initializes all available {@link Library} objects.
     * The initialization
     * process will stop if any exception is thrown by any of the libraries.
     */
    void fullInitialize();

    /**
     * Initializes and post-initializes all available {@link Library} objects.
     * The initialization
     * process will stop or not if any exception is thrown by any of the
     * libraries depending on the ignoreerrors parameter.
     * 
     * @param ignoreerrors
     *            if library initialization errors will stop de process
     */
    void fullInitialize(boolean ignoreerrors);
}
