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
package org.gvsig.tools.library.impl;

import java.util.Set;

import org.gvsig.tools.library.AbstractLibrariesInitializer;
import org.gvsig.tools.library.Library;
import org.gvsig.tools.util.ServiceLoader;
import org.gvsig.tools.util.impl.DefaultServiceLoader;

/**
 * Loads the {@link Library} implementation object instances through a
 * {@link DefaultServiceLoader} or a provided {@link ServiceLoader}.
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public class DefaultLibrariesInitializer extends AbstractLibrariesInitializer {

	private final ServiceLoader serviceLoader;

	public DefaultLibrariesInitializer() {
		this(new DefaultServiceLoader());
	}

    public DefaultLibrariesInitializer(ClassLoader classLoader) {
        this(classLoader, new DefaultServiceLoader());
    }

    public DefaultLibrariesInitializer(ClassLoader[] classLoaders) {
        this(classLoaders, new DefaultServiceLoader());
    }

	public DefaultLibrariesInitializer(ServiceLoader serviceLoader) {
		super();
		this.serviceLoader = serviceLoader;
	}

    public DefaultLibrariesInitializer(ClassLoader classLoader,
        ServiceLoader serviceLoader) {
        super(classLoader);
        this.serviceLoader = serviceLoader;
    }

    public DefaultLibrariesInitializer(ClassLoader[] classLoaders,
        ServiceLoader serviceLoader) {
        super(classLoaders);
        this.serviceLoader = serviceLoader;
    }

	protected Set findLibraries(Class libraryClass, ClassLoader classLoader) {
		return serviceLoader.load(libraryClass, classLoader);
	}
}