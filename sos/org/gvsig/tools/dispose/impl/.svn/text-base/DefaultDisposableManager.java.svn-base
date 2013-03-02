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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.dispose.Disposable;
import org.gvsig.tools.dispose.DisposableManager;
import org.gvsig.tools.exception.BaseException;

/**
 * Default implementation for the {@link DisposableManager}.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">C�sar Ordi�ana</a> - gvSIG team
 */
public class DefaultDisposableManager implements DisposableManager {

	private Map boundDisposables;

	/**
	 * Creates a new {@link DefaultDisposableManager}.
	 */
	public DefaultDisposableManager() {
		boundDisposables = new LinkedHashMap();
	}

	public synchronized boolean bind(Disposable disposable) {
		DefaultDisposableInfo di = (DefaultDisposableInfo) boundDisposables.get(disposable);
		if (di != null){
			di.incReferencesCount();
			return false;
		}
		di = new DefaultDisposableInfo(disposable, new Throwable().getStackTrace());
		di.incReferencesCount();
		return boundDisposables.put(disposable, di) == null;
	}

	public synchronized boolean release(Disposable disposable) {
		DefaultDisposableInfo di = (DefaultDisposableInfo) boundDisposables.get(disposable);
		if (di!=null){
			di.decReferencesCount();
			if (di.getReferencesCount()>0){
				return false;
			}
			boundDisposables.remove(disposable);
			return true;
		}
		return false;
	}

	public synchronized void releaseAll() throws BaseException {
		Iterator iterator = boundDisposables.keySet().iterator();
		boundDisposables = new LinkedHashMap();
		while (iterator.hasNext()) {
			Disposable disposable = (Disposable) iterator.next();
			iterator.remove();
			disposable.dispose();
		}
	}

	public synchronized int getBoundDisposableCount() {
		return boundDisposables.size();
	}

	public synchronized Set getBoundDisposables() {
		Set disposableInfos = new LinkedHashSet(boundDisposables.values());
		return disposableInfos;
	}
}