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

package org.gvsig.tools.library;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.gvsig.tools.exception.BaseRuntimeException;
import org.gvsig.tools.library.AbstractLibrary.Required;

/**
 * Base implementation of an {@link LibrariesInitializer} with the
 * initialization of Libraries already implemented, delegating on child classes
 * the finding of available {@link Library} objects.
 * <p>
 * This class is NOT thread safe.
 * </p>
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public abstract class AbstractLibrariesInitializer implements
    LibrariesInitializer, Library.TYPE {

    private static final Logger LOG = LoggerFactory
        .getLogger(AbstractLibrariesInitializer.class);

    private Collection libs;

    private boolean libsLoaded = false;

    private final ClassLoader[] classLoaders;

    public AbstractLibrariesInitializer() {
        classLoaders = null;
    }

    public AbstractLibrariesInitializer(ClassLoader classLoader) {
        this(new ClassLoader[] { classLoader });
    }

    public AbstractLibrariesInitializer(ClassLoader[] classLoaders) {
        this.classLoaders = classLoaders;
    }

    public void initialize() {
        this.initialize(false);
    }

    public void initialize(boolean ignoreerrors) {
        if (!libsLoaded) {
            loadLibraries(classLoaders, ignoreerrors);
            libsLoaded = true;
        }
        if (libs != null && libs.size() > 0) {
            // Call all initialize()
            initializeLibraries(libs, false, ignoreerrors);
        }
    }

    public void postInitialize() {
        this.postInitialize(false);
    }

    public void postInitialize(boolean ignoreerrors) {
        if (!libsLoaded) {
            loadLibraries(classLoaders, ignoreerrors);
            libsLoaded = true;
        }
        if (libs != null && libs.size() > 0) {
            // Call all postInitialize()
            initializeLibraries(libs, true, ignoreerrors);
        }
    }

    public void fullInitialize() {
        initialize();
        postInitialize();
    }

    public void fullInitialize(boolean ignoreerrors) {
        initialize(ignoreerrors);
        postInitialize(ignoreerrors);
    }

    public List getLibraries() {
        if (!libsLoaded) {
            loadLibraries(classLoaders, false);
            libsLoaded = true;
        }

        return new ArrayList(this.libs);
    }

    private void loadLibraries(ClassLoader[] classLoaders, boolean ignoreerrors) {
        // Find the available Library instances
        Set libs = new HashSet();
        LOG.info("Loading libraries of classloaders:");
        if (classLoaders == null) {
            addLibrariesOfClassLoader(libs, null, ignoreerrors);
        } else {
            for (int i = 0; i < classLoaders.length; i++) {
                addLibrariesOfClassLoader(libs, classLoaders[i], ignoreerrors);
            }
        }

        int fullSize = libs.size();
        this.libs = new OrderedLibs(libs);

        if (LOG.isInfoEnabled()) {
            logLibraries(this.libs, fullSize);
        }
    }

    private void addLibrariesOfClassLoader(Set previousFoundLibs,
        ClassLoader classLoader, boolean ignoreerrors) {
        StringBuffer logBuf = new StringBuffer();
        try {
            Set foundLibs = findLibraries(Library.class, classLoader);
            foundLibs.removeAll(previousFoundLibs);
            logBuf
                .append(new Integer(foundLibs.size()))
                .append(" new libraries found in the classloader ")
                .append(
                    classLoader == null ? "DEFAULT" : classLoader.toString())
                .append(":");

            for (Iterator iterator = foundLibs.iterator(); iterator.hasNext();) {
                Library library = (Library) iterator.next();
                try {
                    library.doRegistration();
                } catch (Throwable e) {
                    manageLibraryException(ignoreerrors, "doRegistration",
                        library, e);
                }
                previousFoundLibs.add(library);
                logBuf.append("\n- ").append(library);
            }
            LOG.info(logBuf.toString());
        } catch (Exception e) {
            String msg =
                MessageFormat.format(
                    "Error finding libraries of classloader {0}",
                    new String[] { classLoader.toString() });
            manageLibraryException(ignoreerrors, msg, e);
        }
    }

    protected abstract Set findLibraries(Class libraryClass,
        ClassLoader classLoader);

    private void initializeLibraries(Collection libs, boolean post,
        boolean ignoreerrors) {
        String label;
        if (post) {
            label = "postInitialize";
        } else {
            label = "initialize";
        }

        for (Iterator iterator = libs.iterator(); iterator.hasNext();) {
            Library lib = (Library) iterator.next();
            try {
                if (post) {
                    LOG.trace("Calling {}.postInitialize()", lib.getClass()
                        .getName());
                    lib.postInitialize();
                } else {
                    LOG.trace("Calling {}.initialize()", lib.getClass()
                        .getName());
                    lib.initialize();
                }
            } catch (Throwable e) {
                manageLibraryException(ignoreerrors, label, lib, e);
            }
        }
    }

    private void manageLibraryException(boolean ignoreerrors, String label,
        Library lib, Throwable e) {
        String msg;
        if (e instanceof BaseRuntimeException) {
            msg = ((BaseRuntimeException) e).getLocalizedMessageStack();
        } else {
            msg = e.getLocalizedMessage();
        }
        String formattedMsg =
            MessageFormat.format("Error in {0} of library {1}. {2}",
                new String[] { label, lib.getClass().getName(), msg });
        manageLibraryException(ignoreerrors, formattedMsg, e);
    }

    private void manageLibraryException(boolean ignoreerrors, String message,
        Throwable e) {
        if (ignoreerrors) {
            LOG.error(message, e);
        } else {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else if (e instanceof Error) {
                throw (Error) e;
            }
        }
    }

    private void logLibraries(Collection libs, int fullSize) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Total libraries to initialize (")
            .append(libs == null ? 0 : libs.size()).append(" of ")
            .append(fullSize).append("):");
        if (libs != null) {
            for (Iterator iterator = libs.iterator(); iterator.hasNext();) {
                buffer.append("\n- ").append(iterator.next());
            }
        }
        LOG.info(buffer.toString());
    }

    private static class OrderedLibs extends ArrayList {

        private static final long serialVersionUID = -8546268624773345053L;

        // By default order alphabetically
        private Map apis;

        public OrderedLibs(Set libs) {
            apis = new TreeMap(new Comparator() {

                public int compare(Object o1, Object o2) {
                    Class class1 = (Class) o1;
                    Class class2 = (Class) o2;
                    return class1.getName().compareTo(class2.getName());
                }
            });
            orderLibs(libs);
        }

        private void orderLibs(Set libs) {
            // First create the groups of libraries, internally ordered:
            // 1: api, 2: impl, 3: serv1, 4: serv2, ...
            // (servs ordered by dependency)
            for (Iterator iterator = libs.iterator(); iterator.hasNext();) {
                Library library = (Library) iterator.next();
                Class API = library.getLibrary();
                if (API == null) {
                    API = library.getClass();
                }
                List libraryGroup = (List) apis.get(API);
                if (libraryGroup == null) {
                    libraryGroup = new LinkedList();
                    apis.put(API, libraryGroup);
                }
                addLibraryToGroup(libraryGroup, library);
            }

            Set alreadyAddedGroups = new HashSet();
            for (Iterator iterator = apis.keySet().iterator(); iterator
                .hasNext();) {
                Class APIRequired = (Class) iterator.next();
                addFromLibraryGroup(APIRequired, alreadyAddedGroups);
            }
        }

        private void addLibraryToGroup(List libraryGroup, Library library) {
            String type = library.getType();

            // If first, don't look anything else and add it
            if (libraryGroup.size() == 0) {
                libraryGroup.add(library);
                return;
            }

            if (API.equals(type)) {
                // API library must go first
                libraryGroup.add(0, library);
            } else if (IMPL.equals(type)) {
                // Look for other implementation an replace it if priority
                // is higher, or discard
                for (int i = 0; i < libraryGroup.size(); i++) {
                    Library current = (Library) libraryGroup.get(i);
                    if (IMPL.equals(current.getType())) {
                        if (current.getPriority() < library.getPriority()) {
                            libraryGroup.set(i, library);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                // If it is the first implementation, insert it after the API
                // and before the services, if any.
                Library first = (Library) libraryGroup.get(0);
                if (API.equals(first.getType())) {
                    if (libraryGroup.size() == 1) {
                        libraryGroup.add(library);
                    } else {
                        libraryGroup.add(1, library);
                    }
                    return;
                } else {
                    libraryGroup.add(0, library);
                    return;
                }
            } else { // It is a service type

                // Look for other services and insert by dependency order
                for (int i = 0; i < libraryGroup.size(); i++) {
                    Library current = (Library) libraryGroup.get(i);
                    if (SERVICE.equals(current.getType())) {
                        if (current.isRequired(library)) {
                            libraryGroup.add(i, library);
                            return;
                        }
                    }
                }
                // Otherwise add the last
                libraryGroup.add(library);
            }
        }

        private void addFromLibraryGroup(Class APIRequired,
            Set alreadyAddedGroups) {
            Collection libraryGroup = (Collection) apis.get(APIRequired);
            if (libraryGroup != null
                && !alreadyAddedGroups.contains(APIRequired)) {
                alreadyAddedGroups.add(APIRequired);

                // Add all group libraries, taking into account dependencies
                // with other library groups
                for (Iterator iterator = libraryGroup.iterator(); iterator
                    .hasNext();) {
                    Library library = (Library) iterator.next();
                    Set requireds = library.getRequireds();
                    if (requireds != null) {
                        for (Iterator requiredsIter = requireds.iterator(); requiredsIter
                            .hasNext();) {
                            Required required = (Required) requiredsIter.next();
                            addFromLibraryGroup(required.getLibrary(),
                                alreadyAddedGroups);
                        }
                    }
                    add(library);
                }
            }
        }

    }

}
