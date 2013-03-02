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
package org.gvsig.tools.observer;

import org.gvsig.tools.observer.impl.DefaultComplexNotification;

/**
 * A interface to be implemented by objects that want to be
 * informed of changes in {@link Observable} objects.
 * 
 * @see ComplexObserver
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public interface Observer {

    /**
     * Called whenever a {@link Observable} object is changed and this
     * {@link Observer} has registered on it to receive notifications.
     * <p>
     * Implementations of this method will be called for each simple
     * notification or, if a complex notification is created, for each of the
     * child notifications.
     * </p>
     * <p>
     * In the latter case, don't assume any ordering in the notification between
     * this {@link Observer} and other {@link Observer}s listening to the same
     * {@link Observable}.
     * </p>
     * <p>
     * In a complex notification scenario, if you want to receive only the
     * complex notification and not each of the child notifications, just
     * implement the {@link ComplexObserver} and prepare this method
     * implementation to handle receiving {@link DefaultComplexNotification} instances
     * as well as direct notification objects.
     * </p>
     * 
     * @param observable
     *            the observable object.
     * @param notification
     *            the notification data.
     */
	public void update(Observable observable, Object notification);

}
