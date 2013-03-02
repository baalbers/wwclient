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
package org.gvsig.tools.dispose.impl;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dispose.Disposable;
import org.gvsig.tools.dispose.DisposeUtils;
import org.gvsig.tools.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base implementation for {@link Disposable} classes.
 * <p>
 * When an instance of this class is created, it is registered as in use, and it
 * is removed in the dispose method.
 * </p>
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public abstract class AbstractDisposable implements Disposable {

	private static final Logger LOG =
			LoggerFactory.getLogger(AbstractDisposable.class);

	private final Object lock = new Object();

	private boolean disposed = false;

	public AbstractDisposable() {
		if(ToolsLocator.getDisposableManager() != null) {
			ToolsLocator.getDisposableManager().bind(this);
		} else {
			LOG.warn("Can't retrieve the disposable manager,");
		}
	}

	public final void dispose() {
		synchronized (lock) {
			// Check if we have already been disposed, and don't do it again
			if (!disposed) {
				if ( ToolsLocator.getDisposableManager().release(this) ) {
					try {
						doDispose();
					} catch (BaseException ex) {
						LOG.error("Error performing dispose", ex);
					}
					disposed = true;
				}
			}
		}
	}

	/**
	 * Utility method to dispose a {@link Disposable}, checking if it is null.
	 * 
	 * @param disposable
	 *            to dispose
	 */
	protected void dispose(Disposable disposable) {
		DisposeUtils.dispose(disposable);
	}

	/**
	 * Internal implementation for the {@link #dispose()} method, to be
	 * implemented by child classes.
	 * 
	 * @see #dispose()
	 */
	protected abstract void doDispose() throws BaseException;
}