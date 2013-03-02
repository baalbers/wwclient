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
package org.gvsig.tools.task.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.gvsig.tools.observer.ObservableHelper;
import org.gvsig.tools.observer.Observer;
import org.gvsig.tools.task.SimpleTaskStatus;
import org.gvsig.tools.task.TaskStatus;
import org.gvsig.tools.task.TaskStatusManager;

/**
 * @author gvSIG Team
 * @version $Id$
 * 
 */
public class DefaultTaskStatusManager implements TaskStatusManager {

	private static final int MAXTASKS_TO_AUTOREMOVE = 15;

	private static long codeCounter = 1;

	private Map tasksStatus = null;
	private ObservableHelper observers = null;

	public DefaultTaskStatusManager() {
		this.tasksStatus = new LinkedHashMap();
		this.observers = new ObservableHelper();
	}

	synchronized public void add(TaskStatus taskStatus) {
		this.tasksStatus.put(taskStatus.getCode(), taskStatus);
		this.update(taskStatus);
	}

	synchronized public TaskStatus get(String code) {
		return (TaskStatus) (this.tasksStatus.get(code));
	}

	synchronized public void remove(String code) {
		this.update((TaskStatus) this.tasksStatus.get(code));
		this.tasksStatus.remove(code);
	}

	synchronized public void remove(TaskStatus taskStatus) {
		this.update(null);
		this.tasksStatus.remove(taskStatus.getCode());
	}

	public String getNewCode() {
		return Long.toBinaryString(codeCounter++);
	}

	synchronized public Map getAll() {
		return Collections.unmodifiableMap(this.tasksStatus);
	}

	synchronized public void addObserver(Observer o) {
		this.observers.addObserver(o);
	}

	synchronized public void deleteObserver(Observer o) {
		this.observers.deleteObserver(o);
	}

	synchronized public void deleteObservers() {
		this.observers.deleteObservers();
	}

	synchronized public void update(TaskStatus taskstatus) {
		if (taskstatus != null
				&& this.tasksStatus.get(taskstatus.getCode()) == null) {
			// This TaskStatus not is registered in this manager.
			return;
		}
		this.observers.notifyObservers(this, taskstatus);
		if (taskstatus != null) {
			if (!taskstatus.isRunning()) {
				if (taskstatus instanceof SimpleTaskStatus) {
					if (((SimpleTaskStatus) taskstatus).getAutoRemove()) {
						if (this.tasksStatus.size() > MAXTASKS_TO_AUTOREMOVE) {
							((SimpleTaskStatus) taskstatus).remove();
						}
					}
				}
			}
		}
	}

	public SimpleTaskStatus creteDefaultSimpleTaskStatus(String tittle) {
        return createDefaultSimpleTaskStatus(tittle);
    }

    public SimpleTaskStatus createDefaultSimpleTaskStatus(String title) {
        return new BaseTaskStatus(title);
	}

	synchronized public TaskStatus getRunningTaskStatusMostRecent() {
		TaskStatus mostRecent = null;
		Iterator taskStatusIterator = this.tasksStatus.values().iterator();
		while( taskStatusIterator.hasNext() ) {
			TaskStatus current = (TaskStatus) taskStatusIterator.next();
			if ( current.isRunning() ) {
				if( mostRecent==null || current.getLastModification().compareTo(mostRecent.getLastModification())>0 ) {
					mostRecent = current;
				}
			}
		}
		return mostRecent;
	}

}
