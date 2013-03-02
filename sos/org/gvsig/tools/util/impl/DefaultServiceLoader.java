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
package org.gvsig.tools.util.impl;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.gvsig.tools.util.ServiceLoader;

/**
 * Implementation which uses reflection to try to use first the standard JDK
 * utilities to load service implementation classes, which are available since
 * JDK 1.6. If it fails or the JDK used is < 1.6, the old mechanism based on the
 * usage of internal sun classes is used.
 * <p>
 * To register your implementations classes eLfor a service, use the mechanism
 * explained in the Java JAR file specification for the JDK version you are
 * using:
 * <ul>
 * <li><a href=
 * "http://java.sun.com/j2se/1.4.2/docs/guide/jar/jar.html#Service%20Provider"
 * >JDK 1.4</a></li>
 * <li><a href=
 * "http://java.sun.com/j2se/1.5.0/docs/guide/jar/jar.html#Service%20Provider"
 * >JDK 1.5</a></li>
 * <li><a href=
 * "http://java.sun.com/javase/6/docs/technotes/guides/jar/jar.html#Service%20Provider"
 * >JDK 1.6</a></li>
 * </ul>
 * </p>
 * 
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public class DefaultServiceLoader implements ServiceLoader {

    private static final Logger LOG = LoggerFactory
        .getLogger(DefaultServiceLoader.class);

    private Set classLoaders = new LinkedHashSet();

    /**
     * Constructor.
     */
    public DefaultServiceLoader() {
        try {
            Class.forName("java.util.ServiceLoader");
            LOG.info("Will use java.util.ServiceLoader to load services");
        } catch (ClassNotFoundException e) {
            LOG.info("Will use sun.misc.Service to load services");
        }
    }

    public void addClassLoader(ClassLoader classLoader) {
        classLoaders.add(classLoader);
    }

    public Set load(Class serviceClass) {
        Set services = load(serviceClass, null);

        for (Iterator iterator = classLoaders.iterator(); iterator.hasNext();) {
            ClassLoader classLoader = (ClassLoader) iterator.next();
            services.addAll(load(serviceClass, classLoader));
        }

        return services;
    }

    public Set load(Class serviceClass, ClassLoader classLoader) {
        try {
            return postJDK16Load(serviceClass, classLoader);
        } catch (Exception e) {
            LOG.debug("Could not use the JDK >= 1.6 utility classes "
                + "to load the {} implementation classes, "
                + "we may be running on a JDK < 1.6, so I will try "
                + "to use the JDK < 1.6 sun.misc.Service class", serviceClass);
            LOG.trace("The exception thrown is: ", e);
        }

        try {
            return preJDK16Load(serviceClass, classLoader);
        } catch (Exception e) {
            LOG.error("Error finding available " + serviceClass + " objects", e);
        }
        return null;
    }

    /**
     * Load the classes using the pre JDK 1.6 sun utilities.
     */
    private Set preJDK16Load(Class serviceClass, ClassLoader classLoader)
        throws Exception {
        LOG.debug("Using the sun.misc.Service class to load " + "the {} {}",
            serviceClass, serviceClass.isInterface() ? "implementations"
                : "extensions");

        // Use reflection to call the internal Sun JDK class and avoid
        // compiler errors in eclipse
        Class serviceClazz = Class.forName("sun.misc.Service");

        if (serviceClazz == null) {
            LOG.error("Could not load Class sun.misc.Service "
                + "using reflection");
            return null;
        }

        Method providersMethod = null;

        if (classLoader == null) {
            providersMethod =
                serviceClazz
                    .getMethod("providers", new Class[] { Class.class });
        } else {
            providersMethod =
                serviceClazz.getMethod("providers", new Class[] { Class.class,
                    ClassLoader.class });
        }

        Iterator iterator = null;
        if (classLoader == null) {
            iterator =
                (Iterator) providersMethod.invoke(null,
                    new Object[] { serviceClass });
        } else {
            iterator =
                (Iterator) providersMethod.invoke(null, new Object[] {
                    serviceClass, classLoader });
        }
        if (iterator == null) {
            LOG.debug("Empty {} objects iterator returned by the "
                + "sun.misc.Service.providers method", serviceClass);
            return null;
        }

        Set services = new LinkedHashSet();
        while (iterator.hasNext()) {
            services.add(iterator.next());
        }
        return services;
    }

    /**
     * Load the classes using the JDK 1.6 standard utilities.
     */
    private Set postJDK16Load(Class serviceClass, ClassLoader classLoader)
        throws Exception {
        LOG.debug("Using the java.util.ServiceLoader class to load "
            + "the {} {}", serviceClass, serviceClass.isInterface()
            ? "implementations" : "extensions");

        // Use reflection to call the JDK >= 1.6 utility classes and being
        // able to compile with JDK 1.4 or 1.5
        Class serviceLoaderClazz = Class.forName("java.util.ServiceLoader");
        Method loadMethod = null;
        if (classLoader == null) {
            loadMethod =
                serviceLoaderClazz.getMethod("load",
                    new Class[] { Class.class });
        } else {
            loadMethod =
                serviceLoaderClazz.getMethod("load", new Class[] { Class.class,
                    ClassLoader.class });
        }

        Object serviceLoader = null;

        if (classLoader == null) {
            serviceLoader =
                loadMethod.invoke(null, new Object[] { serviceClass });
        } else {
            serviceLoader =
                loadMethod.invoke(null, new Object[] { serviceClass,
                    classLoader });
        }
        if (serviceLoader == null) {
            LOG.error("Could not load a ServiceLoader to load {} objects",
                serviceClass);
            return null;
        }

        Method iteratorMethod = serviceLoaderClazz.getMethod("iterator", null);
        Iterator iterator =
            (Iterator) iteratorMethod.invoke(serviceLoader, null);
        if (iterator == null) {
            LOG.debug(
                "java.util.ServiceLoader of {} returned an empty iterator",
                serviceClass);
            return null;
        }

        Set services = new LinkedHashSet();
        while (iterator.hasNext()) {
            services.add(iterator.next());
        }
        return services;
    }

}
