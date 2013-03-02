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
 * 2008 IVER T.I. S.A.   {{Task}}
 */
package org.gvsig.tools.observer.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.lang.Cloneable;
import org.gvsig.tools.observer.ComplexNotification;
import org.gvsig.tools.visitor.Visitor;

public class DefaultComplexNotification implements Cloneable,
    ComplexNotification {
	private static Logger log = 
	    LoggerFactory.getLogger(DefaultComplexNotification.class);
	private List list = new ArrayList();

	public synchronized void addNotification(Object arg) {
		list.add(arg);
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public synchronized void accept(Visitor visitor) throws BaseException {
		for (int i = 0; i < this.list.size(); i++) {
			try {
				Object notification = this.list.get(i);
				visitor.visit(notification);
			} catch (Throwable t) {
				log.warn("Error sending notification.", t);
			}
		}
	}
}
