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

import org.gvsig.tools.dispose.Disposable;
import org.gvsig.tools.dispose.DisposableInfo;
import org.gvsig.tools.dispose.DisposableManager;

/**
 * Default {@link DisposableInfo} implementation.
 * 
 * @author 2009- <a href="cordinyana@gvsig.org">César Ordiñana</a> - gvSIG team
 */
public class DefaultDisposableInfo implements DisposableInfo {

	private final Disposable disposable;
	private final StackTraceElement[] stackTrace;
	private int referencesCount;

	/**
	 * Creates a new {@link DefaultDisposableInfo} with the {@link Disposable}
	 * and the stack trace of the moment when the disposable was bound to the
	 * {@link DisposableManager}.
	 * 
	 * @param disposable
	 *            to info about
	 * @param stackTrace
	 *            stack trace of the moment when the {@link Disposable} was
	 *            bound
	 */
	public DefaultDisposableInfo(Disposable disposable,
			StackTraceElement[] stackTrace) {
		this.disposable = disposable;
		this.stackTrace = stackTrace;
		this.referencesCount = 0;
	}

	public StackTraceElement[] getBindDisposableStackTrace() {
		return stackTrace;
	}

	public Disposable getDisposable() {
		return disposable;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Disposable:\n\t").append(getDisposable())
				.append("\nReferencesCount:\n\t").append(this.referencesCount)
				.append("\nStack trace:");

		StackTraceElement[] stackTrace = getBindDisposableStackTrace();
		for (int i = 1; i < stackTrace.length; i++) {
			buffer.append("\n\t").append(stackTrace[i]);
		}

		return buffer.toString();
	}

	public void incReferencesCount() {
		this.referencesCount++;
	}

	public void decReferencesCount() {
		this.referencesCount--;
	}

	public int getReferencesCount() {
		return this.referencesCount;
	}
}