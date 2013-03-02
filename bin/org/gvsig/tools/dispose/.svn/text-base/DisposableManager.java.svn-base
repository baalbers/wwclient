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
* 2009 {}  {{Task}}
*/
package org.gvsig.tools.dispose;

import java.util.Set;

import org.gvsig.tools.exception.BaseException;

/**
 * Manages the use and dispose of {@link Disposable} objects.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public interface DisposableManager {

	/**
	 * Registers a disposable as being in use.
	 * 
	 * @param disposable
	 *            to bind
	 * @return true if the disposable was not already bound
	 */
	boolean bind(Disposable disposable);

	/**
	 * Marks a disposable as not being used anymore.
	 * 
	 * @param disposable
	 *            to release
	 * @return true if the disposable has been finally released
	 */
	boolean release(Disposable disposable);

	/**
	 * Releases all bound {@link Disposable}s.
	 * 
	 * @throws BaseException
	 *             if there is an error disposing any of the bound disposables
	 */
	void releaseAll() throws BaseException;

	/**
	 * Returns the number of Disposable objects pending to be released.
	 * 
	 * @return the number of Disposable objects pending to be released
	 */
	int getBoundDisposableCount();

	/**
	 * Returns a {@link Set} of {@link Disposable} objects currently bound.
	 * 
	 * @return
	 */
	Set getBoundDisposables();
}