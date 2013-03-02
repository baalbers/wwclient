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
package org.gvsig.tools.task;

import java.util.Map;

import org.gvsig.tools.observer.Observable;

/**
 * @author gvSIG Team
 * @version $Id$
 * 
 */
public interface TaskStatusManager extends Observable {

	/**
	 * Add the TaskStatus to the TaskStatusManager. If TaskStatus already in the
	 * manager this is updated.
	 * 
	 * @param taskStatus to add to the manager
	 */
	public void add(TaskStatus taskStatus);

	/**
	 * Retrieve a TaskStatus from the manager by code.
	 * 
	 * @param code of the TaskStatus to retrieve
	 * @return
	 */
	public TaskStatus get(String code);

	/**
	 * Remove the TaskStatus by the passed code from the manager
	 *
	 * @param code of the TaskStatus to remove
	 */
	public void remove(String code);

	/**
	 * Remove the TaskStatus from the mananger.
	 * 
	 * @param taskStatus
	 */
	public void remove(TaskStatus taskStatus);

	/**
	 * Get a unmodifiable Map with all the TaskStatus in the 
	 * manager. The keys of map are the code of TaskStatus.
	 * 
	 * @return Map of TaskStatus.
	 */
	public Map getAll();

	/**
	 * Return a new code to a TaskStatus.
	 * 
	 * @return
	 */
	public String getNewCode();

	/**
	 * Inform to the manager that this task status has changed.
	 * This method has used by the implementation of TaskStatus
	 * to inform to the manager of changes in a TaskStatus.
	 * 
	 * @param taskstatus
	 */
	public void update(TaskStatus taskstatus);

	    /**
     * Create a new instance of the default implementation of a
     * SimpleTaskStatus.
     * 
     * @param label
     *            used in the title of the new TaskStatus.
     * 
     * @deprecated @see
     *             {@link TaskStatusManager#createDefaultSimpleTaskStatus(String)}
     * 
     * @return the new SimpleTaskStatus.
     */
	public SimpleTaskStatus creteDefaultSimpleTaskStatus(String label);

    /**
     * Create a new instance of the default implementation of a
     * SimpleTaskStatus.
     * 
     * @param label
     *            used in the title of the new TaskStatus.
     * 
     * @return the new SimpleTaskStatus.
     */
    public SimpleTaskStatus createDefaultSimpleTaskStatus(String label);

	/**
	 * Return the running task status most recent.
	 *  
	 * @return
	 */
	public TaskStatus getRunningTaskStatusMostRecent();
}
