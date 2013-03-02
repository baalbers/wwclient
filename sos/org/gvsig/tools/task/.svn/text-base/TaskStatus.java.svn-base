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

import java.util.Date;

import org.gvsig.tools.observer.Observable;


/**
 * @author gvSIG Team
 * @version $Id$
 *
 */
public interface TaskStatus extends CancellableTask, Observable {

    /**
     * Get the title associated to the task of this TaskStatus
     * 
     * @return the task title
     */
    public String getTitle();
    
    /**
     * Gte the code of this TaskStatus.
     * 
     * @return code of task
     */
    public String getCode();

    /**
     * Retorna el porcentaje de completitud de la tarea asociada 
     * a este TaskStatus. 
     * 
     * @return el porcentaje de completitud.
     */
    public int getCompleted();
    
    /**
     * Get a label that represent the status of the task
     * 
     * @return
     */
    public String getLabel();
    
    /**
     * Return true if the task has cancelled by the
     * user or another task.
     * 
     * @return
     */
    public boolean isCancelled();
    
    /**
     * Return true if the task has terminated with errors.
     * 
     * @return
     */
    public boolean isAborted();
    
    /**
     * Return true if the task is running.
     * 
     * @return
     */
    public boolean isRunning();
    
    /**
     * Returns date of last modificaction of status.
     *  
     * @return
     */
    public Date getLastModification();
    
    /**
     * Return the TaskStatusManager associated to this TaskStatus.
     * 
     * @return the TaskStatusManager
     */
    public TaskStatusManager getManager();
    
    /**
     * Return true if the completion of this task
     * can't calculate.
     * 
     * @return 
     */
    public boolean isIndeterminate();
    
    /**
     * Return true if the task associated to this
     * TaskStatus can be canceled.
     * @return
     */
    public boolean isCancellable();
    
}
