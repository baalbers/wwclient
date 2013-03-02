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


/**
 * @author gvSIG Team
 * @version $Id$
 * 
 * Abstract class for tasks, threads, that implements the interface CancellableTask.  
 * This handle the status of the cancelationRequest flag. 
 */

public abstract class AbstractCancellableTask extends Thread implements CancellableTask {

    protected boolean cancellationRequested;

    protected AbstractCancellableTask() {
    	this.cancellationRequested = false;
    }

    protected AbstractCancellableTask(String threadName) {
        super(threadName);
        this.cancellationRequested = false;
    }
    
    public void cancelRequest() {
        this.cancellationRequested = true;
    }

    public boolean isCancellationRequested() {
        return this.cancellationRequested;
    }
}
