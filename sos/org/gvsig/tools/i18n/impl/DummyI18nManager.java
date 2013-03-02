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
* 2010 {}  {{Task}}
*/
package org.gvsig.tools.i18n.impl;

import org.gvsig.tools.i18n.I18nManager;

/**
 * Dummy {@link I18nManager} implementation to be used when there has not been
 * registered an implementation.
 * 
 * Returns as value the same message to get the translation for.
 * 
 * @author 2010- César Ordiñana - gvSIG team
 */
public class DummyI18nManager implements I18nManager {

	public String getTranslation(String message) {
		return message;
	}
}