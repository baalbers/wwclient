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
package org.gvsig.tools.dynobject.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.gvsig.tools.dispose.DisposableIterator;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectSet;
import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.observer.Observer;
import org.gvsig.tools.visitor.Visitor;

/**
 * Façade for a list of {@link DynObjectSet}s as if they were an only contiguous
 * set of {@link DynObject}s.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public class MultiDynObjectSet implements DynObjectSet {

    private static final Logger LOG = LoggerFactory
        .getLogger(MultiDynObjectSet.class);

    private final DynObjectSet[] innerSets;

    /**
     * Creates a new {@link MultiDynObjectSet} with the list of
     * {@link DynObjectSet}s to façade.
     */
    public MultiDynObjectSet(DynObjectSet[] innerSets) {
        this.innerSets = innerSets == null ? new DynObjectSet[0] : innerSets;
    }

    public void dispose() {
        for (int i = 0; i < innerSets.length; i++) {
            innerSets[i].dispose();
        }
    }

    public void accept(Visitor visitor, long firstValueIndex)
        throws BaseException {

        // Find the set where the global index points to
        int currentSet = 0;
        long currentIndex = 0;
        while (currentIndex + innerSets[currentSet].getSize() <= firstValueIndex) {
            currentIndex += innerSets[currentSet].getSize();
            currentSet++;
        }
        // Get the relative index into the current set
        long firstIndexFromCurrentSet = firstValueIndex - currentIndex;

        // Visit the current set beginning from the relative index
        innerSets[currentSet].accept(visitor, firstIndexFromCurrentSet);

        // Finally, visit the remaining sets fully.
        for (int i = currentSet; i < innerSets.length; i++) {
            innerSets[i].accept(visitor);
        }
    }

    public void accept(Visitor visitor) throws BaseException {
        accept(visitor, 0);
    }

    public long getSize() throws BaseException {
        long size = 0;
        for (int i = 0; i < innerSets.length; i++) {
            size += innerSets[i].getSize();
        }
        return size;
    }

    public DisposableIterator iterator(long index) throws BaseException {
        return new MultiDynObjectSetDisposableIterator(innerSets);
    }

    public DisposableIterator iterator() throws BaseException {
        return iterator(0);
    }

    public boolean isEmpty() throws BaseException {
        for (int i = 0; i < innerSets.length; i++) {
            if (!innerSets[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author gvSIG Team
     * @version $Id$
     * 
     */
    public static class MultiDynObjectSetDisposableIterator implements
        DisposableIterator {

        private DisposableIterator currentIterator = null;
        private int currentSet = 0;
        private final DynObjectSet[] innerSets;

        public MultiDynObjectSetDisposableIterator(DynObjectSet[] innerSets)
            throws BaseException {
            this.innerSets = innerSets;
            if ((currentIterator == null) && (currentSet < innerSets.length)) {
                currentIterator = innerSets[currentSet].iterator();
            }
        }

        public void dispose() {
            if (currentIterator != null) {
                currentIterator.dispose();
            }
        }

        private DisposableIterator getCurrentIterator() {
            while (!currentIterator.hasNext()
                && (currentSet < innerSets.length - 1)) {
                currentSet++;
                try {
                    currentIterator = innerSets[currentSet].iterator();
                } catch (BaseException e) {
                    LOG.error(
                        "Could no get the iterator of the internal DynObjectSet num. "
                            + currentSet + ": " + innerSets[currentSet], e);
                }
            }
            return currentIterator;
        }

        public boolean hasNext() {
            DisposableIterator currentIterator = getCurrentIterator();
            return currentIterator == null ? false : currentIterator.hasNext();
        }

        public Object next() {
            DisposableIterator currentIterator = getCurrentIterator();
            return currentIterator == null ? null : currentIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException(
                "Unable to remove on composed DynObjectSet iterator");
        }
    }

    public void addObserver(Observer o) {
        throw new UnsupportedOperationException("This DynObjectSet "
            + "implementation does not support edition, so it doesn't "
            + "provide notifications");
    }

    public void deleteObserver(Observer o) {
        throw new UnsupportedOperationException("This DynObjectSet "
            + "implementation does not support edition, so it doesn't "
            + "provide notifications");
    }

    public void deleteObservers() {
        throw new UnsupportedOperationException("This DynObjectSet "
            + "implementation does not support edition, so it doesn't "
            + "provide notifications");
    }

    public boolean isDeleteEnabled() {
        return false;
    }

    public void delete(DynObject dynObject) throws BaseException {
        throw new UnsupportedOperationException("This DynObjectSet "
            + "implementation does not support DynObject deletion");
    }

    public boolean isUpdateEnabled() {
        return false;
    }

    public void update(DynObject dynObject) throws BaseException {
        throw new UnsupportedOperationException("This DynObjectSet "
            + "implementation does not support DynObject update");
    }

}
