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

import org.gvsig.tools.dispose.impl.AbstractDisposable;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectPagingHelper;
import org.gvsig.tools.dynobject.DynObjectSet;
import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.paging.DefaultPagingCalculator;
import org.gvsig.tools.paging.PagingCalculator;
import org.gvsig.tools.visitor.VisitCanceledException;
import org.gvsig.tools.visitor.Visitor;

/**
 * Default {@link DynObjectPagingHelper} implementation.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public class DefaultDynObjectPagingHelper extends AbstractDisposable implements
    DynObjectPagingHelper {

    private static final Logger LOG = LoggerFactory
        .getLogger(DefaultDynObjectPagingHelper.class);

    private DynObjectSet set;
    private DynObject[] values;
    private PagingCalculator calculator;

    public DefaultDynObjectPagingHelper() {
        // Nothing to do
    }

    public DefaultDynObjectPagingHelper(DynObjectSet set) throws BaseException {
        this(set, DEFAULT_PAGE_SIZE);
    }

    public DefaultDynObjectPagingHelper(DynObjectSet set, int pageSize)
        throws BaseException {
        setDynObjectSet(set, pageSize);
    }

    protected void setDynObjectSet(final DynObjectSet set, int pageSize)
        throws BaseException {
        this.set = set;
        setDefaultCalculator(new Sizeable() {

            public long getSize() {
                try {
                    return set.getSize();
                } catch (BaseException e) {
                    LOG.error("Error getting the size of the DynObjectSet: "
                        + set, e);
                    return 0l;
                }
            }
        }, pageSize);
    }

    public DynObject getDynObjectAt(long index) throws BaseException {
        // Check if we have currently loaded the viewed page data,
        // or we need to load a new one
        long pageForIndex = (long) Math.floor(index / getMaxPageSize());

        if (pageForIndex != getCurrentPage()) {
            setCurrentPage(pageForIndex);
        }

        long positionForIndex = index - (getCurrentPage() * getMaxPageSize());

        return values[(int) positionForIndex];
    }

    public DynObject[] getCurrentPageDynObjects() {
        return values;
    }

    public DynObjectSet getDynObjectSet() {
        return set;
    }

    public void reloadCurrentPage() throws BaseException {
        if (getCurrentPage() > -1) {
            loadCurrentPageData();
        }
    }

    protected void loadCurrentPageData() throws BaseException {
        final int currentPageSize = getCurrentPageSize();
        final DynObject[] values = new DynObject[currentPageSize];

        long t1 = 0;
        if (LOG.isTraceEnabled()) {
            t1 = System.currentTimeMillis();
        }

        long initialIndex = getInitialIndex();
        final int pageSize = getCurrentPageSize();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Loading {} DynObjects starting at position {}",
                new Integer(pageSize), new Long(initialIndex));
        }

        set.accept(new Visitor() {

            private int i = 0;

            public void visit(Object obj) throws VisitCanceledException,
                BaseException {
                if (i >= pageSize) {
                    throw new VisitCanceledException();
                }
                values[i] = (DynObject) obj;
                i++;
            }
        }, initialIndex);

        if (LOG.isTraceEnabled()) {
            long t2 = System.currentTimeMillis();
            LOG.trace("Time to load {} DynObjects: {} ms", new Integer(
                currentPageSize), new Long(t2 - t1));
        }

        this.values = values;
    }

    public void reload() throws BaseException {
        reloadCurrentPage();
    }

    protected void doDispose() throws BaseException {
        set.dispose();
    }

    protected PagingCalculator getCalculator() {
        return calculator;
    }

    protected void setCalculator(PagingCalculator calculator)
        throws BaseException {
        this.calculator = calculator;
        loadCurrentPageData();
    }

    protected void setDefaultCalculator(Sizeable sizeable, int pageSize)
        throws BaseException {
        setCalculator(new DefaultPagingCalculator(sizeable, pageSize));
    }

    public int getMaxPageSize() {
        return calculator == null ? DEFAULT_PAGE_SIZE : calculator
            .getMaxPageSize();
    }

    public void setMaxPageSize(int pageSize) throws BaseException {
        calculator.setMaxPageSize(pageSize);
        reloadCurrentPage();
    }

    public long getCurrentPage() {
        return calculator.getCurrentPage();
    }

    public void setCurrentPage(long page) throws BaseException {
        calculator.setCurrentPage(page);
        loadCurrentPageData();
    }

    public long getInitialIndex() {
        return calculator.getInitialIndex();
    }

    public long getNumPages() {
        return calculator.getNumPages();
    }

    public long getTotalSize() {
        return calculator.getTotalSize();
    }

    public int getCurrentPageSize() {
        return calculator.getCurrentPageSize();
    }

}
