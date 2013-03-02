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
 * 2009 IVER T.I   {{Task}}
 */

/**
 *
 */
package org.gvsig.tools.persistence.exception;

import java.util.List;

/**
 * @author jmvivo
 * 
 */
public class PersistenceValidateExceptions extends PersistenceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 3418942854055550877L;

	public PersistenceValidateExceptions(String name) {
		super("Errors found validating '%(name)'.",
				"_errors_found_validating_XnameX", serialVersionUID);
		this.setValue("name", name);
	}

	public PersistenceValidateExceptions(String name, List exceptions) {
		this(name);
		this.addAll(exceptions);
	}

	public PersistenceValidateExceptions(List exceptions) {
		super("Errors found validating persistent state.",
				"_errors_found_validating_persistent_state", serialVersionUID);
		this.addAll(exceptions);
	}
}
