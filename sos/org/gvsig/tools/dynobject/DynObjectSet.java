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
 * 2010 {}  {{Task}}
 */
package org.gvsig.tools.dynobject;

import org.gvsig.tools.dispose.Disposable;
import org.gvsig.tools.dispose.DisposableIterator;
import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.observer.Observable;
import org.gvsig.tools.visitor.IndexedVisitable;

/**
 * A set of iterable DynObject objects.
 * 
 * @author 2010- César Ordiñana - gvSIG team
 */
public interface DynObjectSet extends Disposable, IndexedVisitable, Observable {

    public static interface Notification {

        static final String EDITION_STATUS_CHANGE =
            "edition_status_change_DynObjectSet";

        static final String DATA_CHANGED = "data_changed_DynObjectSet";

        String getType();
    }

    /**
     * Returns the number of {@link DynObject}(s) contained in this
     * DynObjectSet.
     * 
     * @return number of {@link DynObject}(s) contained in this DynObjectSet.
     * 
     * @throws BaseException
     */
    long getSize() throws BaseException;

    /**
     * Returns an iterator over the elements in this collection, in the order
     * (if any) defined when the collection was obtained.
     * 
     * The iterator starts at the specified position in this collection. The
     * specified index indicates the first element that would be returned by an
     * initial call to the <tt>next</tt> method. An initial call to the
     * <tt>previous</tt> method would return the element with the specified
     * index minus one.
     * 
     * <p>
     * <em>
     * <strong>NOTE:</strong> if you use this method to get the iterator, you
     * must get sure the iterator is disposed (@see
     * {@link DisposableIterator#dispose()}) in any case, even if an error occurs
     * while getting the data. It is recommended to use the <code>accept</code>
     * methods instead, which handle everything for you. 
     * Take into account the accept methods may use a fast iterator to 
     * get the DynObjects.
     * </em>
     * </p>
     * 
     * @see #accept(org.gvsig.tools.visitor.Visitor)
     * @see #accept(org.gvsig.tools.visitor.Visitor, long)
     * 
     * @param index
     *            index of first element to be returned from the iterator (by a
     *            call to the <tt>next</tt> method).
     * @return an iterator of the elements in this collection (in proper
     *         sequence), starting at the specified position in the collection.
     * @throws BaseException
     *             if the index is out of range (index &lt; 0 || index &gt;
     *             size()).
     */
    DisposableIterator iterator(long index) throws BaseException;

    /**
     * Returns an iterator over the elements in this collection, in the order
     * (if any) defined when the collection was obtained.
     * 
     * <p>
     * <em>
     * <strong>NOTE:</strong> if you use this method to get the iterator, you
     * must get sure the iterator is disposed (@see
     * {@link DisposableIterator#dispose()}) in any case, even if an error occurs
     * while getting the data. It is recommended to use the <code>accept</code>
     * methods instead, which handle everything for you. 
     * Take into account the accept methods may use a fast iterator to 
     * get the DynObjects.
     * </em>
     * </p>
     * 
     * @see #accept(org.gvsig.tools.visitor.Visitor)
     * @see #accept(org.gvsig.tools.visitor.Visitor, long)
     * 
     * @return an iterator of the elements in this collection (in proper
     *         sequence).
     * 
     * @throws BaseException
     */
    DisposableIterator iterator() throws BaseException;

    /**
     * Indicates whether this DynObjectSet contains zero DynObjects.
     * 
     * @return true if this DynObjectSet is empty, false otherwise.
     * 
     * @throws BaseException
     */
    boolean isEmpty() throws BaseException;

    /**
     * Tells if DynObject deletion is enabled into this set.
     * 
     * @return if DynObject deletion is enabled into this set
     */
    boolean isDeleteEnabled();

    /**
     * Deletes a DynObject from this set. Depending on the inner set
     * implementation that may mean also the data will be removed from a
     * persistent state.
     * 
     * @param dynObject
     *            to remove
     * @throws BaseException
     *             if there is an error removing the DynObject
     */
    void delete(DynObject dynObject) throws BaseException;

    /**
     * Tells if DynObject updates are enabled into this set.
     * 
     * @return if DynObject updates are enabled into this set
     */
    boolean isUpdateEnabled();

    /**
     * Updates a DynObject from this set. Depending on the inner set
     * implementation that may mean also the data will be updated in a
     * persistent state.
     * 
     * @param dynObject
     *            to update
     * @throws BaseException
     *             if there is an error updating the DynObject
     */
    void update(DynObject dynObject) throws BaseException;
}
