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
package org.gvsig.tools.paging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Default {@link PagingCalculator} implementation.
 * 
 * @author gvSIG team
 */
public class DefaultPagingCalculator implements PagingCalculator {

    private static final Logger LOG = LoggerFactory
        .getLogger(DefaultPagingCalculator.class);

    private int maxPageSize;
    private long currentPage;

    private final Sizeable sizeable;

    /**
     * Creates a new {@link DefaultPagingCalculator}, with the default page
     * size ({@link PagingCalculator#DEFAULT_PAGE_SIZE}), setting the current
     * page to the first one.
     */
    public DefaultPagingCalculator(Sizeable sizeable) {
        this(sizeable, DEFAULT_PAGE_SIZE);
    }

    /**
     * Creates a new {@link DefaultPagingCalculator}, setting the current page
     * to the first one.
     * 
     * @param maxPageSize
     *            the maximum page size
     */
    public DefaultPagingCalculator(Sizeable sizeable, int maxPageSize) {
        this(sizeable, maxPageSize, 0);
    }

    /**
     * Creates a new {@link DefaultPagingCalculator} .
     * 
     * @param maxPageSize
     *            the maximum page size
     * @param currentPage
     *            the current page
     */
    public DefaultPagingCalculator(Sizeable sizeable, int maxPageSize,
        long currentPage) {
        this.sizeable = sizeable;
        this.maxPageSize = maxPageSize;
        this.currentPage = currentPage;
    }

    public int getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize) {
        if (maxPageSize < 0) {
            throw new IndexOutOfBoundsException(
                "Error, unable to set the max page size to a "
                    + "negative value: " + maxPageSize);
        }
        this.maxPageSize = maxPageSize;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Setting current page to: {}", Long.toString(currentPage));
        }

        if (currentPage < 0) {
            throw new IndexOutOfBoundsException(
                "Error, unable to set current page to a " + "negative value: "
                    + currentPage);
        }
        if (currentPage >= getNumPages()) {
            throw new IndexOutOfBoundsException(
                "Error, unable to set current page to the page num. "
                    + currentPage + ", as we have only " + getNumPages()
                    + " pages of data");
        }

        this.currentPage = currentPage;
    }

    public long getInitialIndex() {
        return getCurrentPage() * getMaxPageSize();
    }

    protected long getLastIndex() {
        return getInitialIndex() + getCurrentPageSize() - 1;
    }

    public long getNumPages() {
        return ((long) Math.floor(getTotalSize() / (long) getMaxPageSize())) + 1;
    }

    public int getCurrentPageSize() {
        long currentPage = getCurrentPage();
        if (currentPage < (getNumPages() - 1)) {
            return getMaxPageSize();
        } else {
            return (int) (getTotalSize() - (currentPage * getMaxPageSize()));
        }
    }

    public long getTotalSize() {
        return sizeable.getSize();
    }

}
