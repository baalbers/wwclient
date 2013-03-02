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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Library implementation, checking that a Library is initialized and
 * postInitialized only once.
 * 
 * Also adds initialization logging.
 * 
 * @author <a href="mailto:cordin@disid.com">Cèsar Ordiñana</a>
 * @author jjdelcerro
 */
public abstract class AbstractLibrary implements Library {

    private static Set initialized = new HashSet();
    private static Set postInitialized = new HashSet();

    private static final int DEFAULT_PRIORITY = 0;

    private Set requireds = null;
    private Class library;
    private String type;
    private int priority = DEFAULT_PRIORITY;

    /**
     * Association between a library class and its type.
     * 
     * @author gvSIG team
     */
    public static class Required {

        Class library;
        String type;
        private boolean added = false;

        Required(Class library, String type) {
            this.library = library;
            this.type = type;
        }

        public Class getLibrary() {
            return this.library;
        }

        public String getType() {
            return this.type;
        }

        public String toString() {
            return this.library.toString() + ":"
                + (this.type == null ? "UNDEFINED" : this.type.toUpperCase());
        }

        /**
         * @return the added
         */
        public boolean isAdded() {
            return added;
        }

        /**
         * @param added
         *            the added to set
         */
        public void setAdded(boolean added) {
            this.added = added;
        }
    }

    /**
     * Empty constructor.
     */
    protected AbstractLibrary() {
        // Nothing to do
    }

    /**
     * Creates a new library registering with type of library it is: API or
     * implementation of a library.
     * <p>
     * When it is an API library, the class will be itself.
     * </p>
     * 
     * @param library
     *            the library class we relate to
     * @param type
     *            the library type. See {@link TYPE}.
     * @deprecated to be removed in the 4.x version. Use the
     *             {@link #AbstractLibrary()} empty constructor and override the
     *             {@link #doRegistration()} method instead.
     * @see #AbstractLibrary()
     */
    protected AbstractLibrary(Class library, String type) {
        registerAs(library, type);
    }

    /**
     * Creates a new library registering it as an implementation.
     * A priority is also provided just in case there is another
     * implementation available, so the one with the highest priority
     * will be the one used.
     * 
     * @param library
     *            the library class we relate to
     * @param priority
     *            the priority of the library against other implementations
     *            of the same library
     * @deprecated to be removed in the 4.x version. Use the
     *             {@link #AbstractLibrary()} empty constructor and override the
     *             {@link #doRegistration()} method instead.
     * @see #AbstractLibrary()
     */
    protected AbstractLibrary(Class library, int priority) {
        registerAsImplementationOf(library, priority);
    }

    public Set getRequireds() {
        return this.requireds;
    }

    /**
     * Returns the name of the current Library
     */
    public Class getLibrary() {
        return this.library;
    }

    public String getType() {
        return this.type;
    }

    public int getPriority() {
        return this.priority;
    }

    /**
     * Adds a required library, so it is initialized before the current one.
     * 
     * @param library
     *            the required library
     * @param type
     *            the type of the required library
     * @deprecated use the {@link #require(Class)} method instead, as you may
     *             have problems if the type specified is not correct. Moreover,
     *             this is not needed.
     */
    public synchronized final void require(Class library, String type) {
        doRequire(library, type);
    }

    /**
     * Adds a required library, so it is initialized before the current one.
     * 
     * @param library
     *            the required library
     */
    public synchronized final void require(Class library) {
        doRequire(library, null);
    }

    private void doRequire(Class library, String type) {
        if (requireds == null) {
            this.requireds = new HashSet();
        }
        this.requireds.add(new Required(library, type));
    }

    /**
     * Registers the library with type of library it is: API or
     * implementation of a library.
     * <p>
     * When it is an API library, the class will be itself.
     * </p>
     * 
     * @param library
     *            the library class we relate to
     * @param type
     *            the library type. See {@link TYPE}.
     */
    protected synchronized final void registerAs(Class library, String type) {
        this.library = library;
        this.type = type;
        if (this.library != null) {
            if (!Library.class.isAssignableFrom(library)) {
                throw new IllegalArgumentException(
                    "Given class is not a Library: " + library);
            }
            // Add default dependencies between services, implementation and API
            if (!Library.TYPE.API.equals(type)) {
                doRequire(this.library, Library.TYPE.API);
                if (Library.TYPE.SERVICE.equals(type)) {
                    doRequire(this.library, Library.TYPE.IMPL);
                }
            }
        }
    }

    /**
     * Registers the library as an API one.
     * 
     * @param library
     *            the library class we relate to
     */
    protected synchronized final void registerAsAPI(Class library) {
        registerAs(library, TYPE.API);
    }

    /**
     * Registers the library as an implementation of an API library, with the
     * default priority.
     * 
     * @param library
     *            the library class we relate to
     */
    protected synchronized final void registerAsImplementationOf(Class library) {
        registerAsImplementationOf(library, DEFAULT_PRIORITY);
    }

    /**
     * Registers the library as an implementation of an API library.
     * A priority is also provided just in case there is another
     * implementation available, so the one with the highest priority
     * will be the one used.
     * 
     * @param library
     *            the library class we relate to
     * @param priority
     *            the priority of the library against other implementations
     *            of the same library
     */
    protected synchronized final void registerAsImplementationOf(Class library,
        int priority) {

        registerAs(library, Library.TYPE.IMPL);
        this.priority = priority;
    }

    /**
     * Registers the library as a service or provider of an API library.
     * 
     * @param library
     *            the library class we relate to
     */
    protected synchronized final void registerAsServiceOf(Class library) {
        registerAs(library, TYPE.SERVICE);
    }

    public synchronized final void initialize() throws LibraryException {
        Logger logger = null;

        // Check if we have been already initialized
        String name = getClass().getName();
        if (initialized.contains(name)) {
            return;
        }

        logger = LoggerFactory.getLogger(this.getClass());
        logger
            .info("Initializing library '" + this.getClass().getName() + "'.");

        // Set the current Library as initialized
        initialized.add(name);

        doInitialize();
    }

    public synchronized final void postInitialize() throws LibraryException {
        Logger logger = null;

        // Check if we have been already postInitialized
        String name = getClass().getName();
        if (postInitialized.contains(name)) {
            return;
        }

        logger = LoggerFactory.getLogger(this.getClass());
        logger.info("PostInitializing library '" + this.getClass().getName()
            + "'.");
        doPostInitialize();

        // Set the current Library as postInitialized
        postInitialized.add(name);
    }

    public void doRegistration() {
        // Empty implementation so child classes may still use the registration
        // in its constructor
    }

    public boolean equals(Object obj) {
        return obj != null
            && getClass().getName().equals(obj.getClass().getName());
    }

    public int hashCode() {
        return getClass().getName().hashCode();
    }

    public String toString() {
        if (getType() == null) {
            return getClass().getName();
        }
        String relatedLibName =
            library == null ? getClass().getName() : library.getName();
        return getClass().getName() + " (" + getType().toUpperCase() + " of "
            + relatedLibName + ")";
    }

    public boolean isRequired(Library lib) {
        return isRequired(lib.getClass());
    }

    public boolean isRequired(Class libClass) {
        if (requireds != null) {
            for (Iterator iterator = requireds.iterator(); iterator.hasNext();) {
                Required req = (Required) iterator.next();
                if (libClass.equals(req.getLibrary())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Performs all the initializations of the library, only related to himself:
     * register implementation classes through the Locator, start services, etc.
     * 
     * @throws LibraryException
     *             if there is an error while performing the initialization of
     *             the library
     */
    protected abstract void doInitialize() throws LibraryException;

    /**
     * Performs all the initializations or validations related to the library
     * dependencies, as getting references to objects through other libraries
     * Locators.
     * 
     * @throws LibraryException
     *             if there is an error while loading an implementation of the
     *             library
     */
    protected abstract void doPostInitialize() throws LibraryException;

}
