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
 * 2009 {DiSiD Technologies}  {{Task}}
 */
package org.gvsig.tools.library;

import java.util.List;

import org.gvsig.tools.exception.BaseRuntimeException;
import org.gvsig.tools.exception.ListBaseException;

/**
 * Exception for errors in the initialization of a Library.
 * 
 * @author <a href="mailto:cordinyana@gvsig.org">Cèsar Ordiñana</a>
 */
public class LibraryException extends BaseRuntimeException {

	private static final long serialVersionUID = 4041519920390133009L;

	private static final String KEY = "library_exception";

	private static final String MESSAGE = "Error in the initialization of the Library: %(library)";

	private static class ListExceptions extends ListBaseException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1621810010494819633L;
		
		public ListExceptions(List causes) {
			super(MESSAGE, KEY, serialVersionUID);
			this.addAll(causes);
		}

	}
	
	/**
	 * Creates a new exception from a cause exception.
	 * 
	 * @param cause
	 *            the original cause exception
	 */
	public LibraryException(String library, Throwable cause) {
		super(MESSAGE, cause, KEY, serialVersionUID);
		setValue("library", library);
	}

	/**
	 * Creates a new exception from a cause exception.
	 * 
	 * @param cause
	 *            the original cause exception
	 */
	public LibraryException(Class libraryClass, Throwable cause) {
		this(libraryClass.getName(), cause);
	}

	public LibraryException(Class libraryClass, ListBaseException causes) {
		this(libraryClass.getName(), causes);
	}

	public LibraryException(Class libraryClass, List causes) {
		this(libraryClass.getName(), new ListExceptions(causes));
	}
}