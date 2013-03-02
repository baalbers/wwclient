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

import org.gvsig.tools.exception.BaseException;


/**
 * Calculates all the values needed to perform pagination over a set of data.
 * 
 * @author gvSIG team
 */
public interface PagingCalculator {

    static final int DEFAULT_PAGE_SIZE = 100;

    /**
     * Returns the current maximum number of values per page.
     * 
     * @return the current maximum page size
     */
    int getMaxPageSize();

    /**
     * Sets the current maximum number of elements per page. As the page size
     * changes, the current page of data is reloaded.
     * 
     * All pages, but maybe the last one, will have this number of elements.
     * 
     * @param pageSize
     *            the maximum number of values per page
     * @throws BaseException
     *             if there is an error reloading the current page
     */
    void setMaxPageSize(int pageSize) throws BaseException;

    /**
     * Returns the number of the currently loaded page of data (zero
     * based).
     * 
     * @return the current page number
     */
    long getCurrentPage();

    /**
     * Sets the current page number (zero based), and loads the elements for
     * that page.
     * 
     * @param page
     *            the page to load
     * @throws BaseException
     *             if there is an error setting the current page
     */
    void setCurrentPage(long page) throws BaseException;

    /**
     * Returns the index of the initial element of the current page into all the
     * elements.
     * 
     * @return the index of the initial element
     */
    long getInitialIndex();

    /**
     * Returns the number of pages available, calculated with the total number
     * of elements and the maximum number of elements per page.
     * 
     * @return the number of pages available
     */
    long getNumPages();

    /**
     * Returns the number of elements of the entire set of data.
     * 
     * @return the number of elements
     */
    long getTotalSize();

    /**
     * Returns the number of elements of the current page. All the pages, but
     * maybe the last one, will have the maximum number of elements per page.
     * 
     * @return the current page size
     */
    int getCurrentPageSize();

    /**
     * Interface for objects that have a size.
     * 
     * @author gvSIG team
     */
    public static interface Sizeable {

        /**
         * Returns the number of elements.
         * 
         * @return the number of elements
         */
        long getSize();
    }

}
