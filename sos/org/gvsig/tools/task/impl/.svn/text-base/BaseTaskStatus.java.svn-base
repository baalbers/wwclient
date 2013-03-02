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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.observer.ObservableHelper;
import org.gvsig.tools.observer.Observer;
import org.gvsig.tools.task.SimpleTaskStatus;
import org.gvsig.tools.task.TaskStatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author gvSIG Team
 * @version $Id$
 *
 */
public class BaseTaskStatus implements SimpleTaskStatus {

    private static final Logger LOG = LoggerFactory
        .getLogger(BaseTaskStatus.class);

    protected class SubtaskValues {
		long minValue = 0;
        long maxValue = 0;
        long curValue = 0;
        String message = null;
        
        public Object clone() {
        	SubtaskValues other = new SubtaskValues();
        	other.curValue = this.curValue;
        	other.maxValue = this.maxValue;
        	other.minValue = this.minValue;
        	other.message = this.message;
        	return other;
        }
    }
    
    protected Date lastModification = null;

    protected SubtaskValues values;
    protected List subtaskStack = null ;
    
    protected String title = null;
    protected String code = null;
    
    protected boolean isCancelled = false;
    protected boolean isAbortedByError = false;
    protected boolean isRunning = true;
    
    protected TaskStatusManager manager = null;

	protected boolean isCancellable;

	protected boolean isCancellationRequested;

	protected ObservableHelper observers = null;

	protected boolean autoremove;

    private long startMillis;
    
    public BaseTaskStatus(String title) {
    	this.manager =  ToolsLocator.getTaskStatusManager();
    	this.autoremove = true;
        this.title = title;
        this.values = new SubtaskValues();
        this.isCancelled = false;
        this.isAbortedByError = false;
        this.isRunning = true;
        this.isCancellable = false;
        this.isCancellationRequested = false;
        this.code = this.manager.getNewCode();
        this.observers = new ObservableHelper();
        this.touch();
    }
    
    public BaseTaskStatus(String tittle, long minValue, long maxValue) {
    	this(tittle);
        this.values.minValue = minValue;
        this.values.maxValue = maxValue;
    }
    
    public void setRangeOfValues(long min, long max) {
        this.values.minValue = min;
        this.values.maxValue = max;
    }
    
    protected void touch() {
    	Date now = new Date(); 
    	if( this.lastModification!=null && (now.getTime() - this.lastModification.getTime()) > 2000 ) {
    		this.values.message = null;
    	}
        this.lastModification = now;
        this.manager.update(this);
        this.observers.notifyObservers(this, null);
    }
    
    public Date getLastModification() {
    	return this.lastModification;
    }
    
    public void message(String message) {
    	this.values.message = message;
    	this.touch();
    }
    
    public String getTitle() {
        return this.title;
    }

    public String getCode() {
        return this.code;
    }

    public void setCurValue(long value) {
        this.values.curValue = value;
        this.touch();
    }
    
    public int getCompleted() {
        if( !this.isRunning ) {
            return 100;
        }
        if( this.values.maxValue == this.values.minValue ) {
        	// No se puede calcular ya que no se ha indicado el numero de elementos
        	// sobre los que se esta trabajando, asi que devoobemos el 100%.
        	return 100;
        }
        try {
            return (int) (((this.values.curValue-this.values.minValue)*100)/(this.values.maxValue-this.values.minValue));
        } catch( Exception e) {
            return 100;
        }
    }

    public String getLabel() {
    	String progress;
    	
        if( this.values.maxValue == this.values.minValue ) {
        	// No se puede calcular ya que no se ha indicado el numero de elementos
        	// sobre los que se esta trabajando.
        	if( this.values.curValue > 0 ) {
        		progress = " (" + this.values.curValue + ")";
        	} else {
        		progress = "";
        	}
        } else {
            progress = " (" + (this.values.curValue-this.values.minValue) + " / " + (this.values.maxValue-this.values.minValue) + ")" ;
        }
    	if( this.values.message == null ) {
            return progress;
    	} else {
            return this.values.message + progress;
    	}
    }

    public void terminate() {
    	if( !isRunning ) {
    		return;
    	}
        this.isRunning = false;
        if (LOG.isDebugEnabled()) {
            long endMillis = System.currentTimeMillis();
            LOG.debug("Terminated status {} execution in {} ms", getTitle(),
                new Long(endMillis - startMillis));
        }
        this.touch();
    }
    
    public void cancel() {
    	if( !isRunning ) {
    		return;
    	}
        this.isCancelled = true;
        this.isRunning = false;
        this.touch();
    }

    public void abort() {
    	if( !isRunning ) {
    		return;
    	}
        this.isAbortedByError = true;
        this.isRunning = false;
        this.touch();
    }
    
    public boolean isCancelled() {
        return this.isCancelled;
    }

    public boolean isAborted() {
        return this.isAbortedByError;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

	public TaskStatusManager getManager() {
		return this.manager;
	}

	public boolean isIndeterminate() {
		return this.values.minValue == this.values.maxValue;
	}

	public void add() {
		this.manager.add(this);
        if (LOG.isDebugEnabled()) {
            startMillis = System.currentTimeMillis();
        }
	}

	public void remove() {
		this.manager.remove(this);
	}

	public boolean isCancellable() {
		return this.isCancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.isCancellable = cancellable;
	}

	synchronized public boolean isCancellationRequested() {
		return this.isCancellationRequested;
	}

	synchronized public void cancelRequest() {
		this.isCancellationRequested = true;
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

	public void setTittle(String tittle) {
        setTitle(tittle);
    }

    public void setTitle(String title) {
        if (this.title != null) {
            return;
        }
        this.title = title;
    }

	public void setAutoremove(boolean autoremove) {
		this.autoremove = autoremove;
	}

	public boolean getAutoRemove() {
		return this.autoremove;
	}

	public void push() {
		if( this.subtaskStack == null ) {
			this.subtaskStack = new ArrayList();
		}
		this.subtaskStack.add(0, this.values);
		this.values = (SubtaskValues) this.values.clone();
	}

	public void pop() {
		if( this.subtaskStack == null && this.subtaskStack.isEmpty() ) {
			return;
		}
		this.values = (SubtaskValues) this.subtaskStack.get(0);
		this.subtaskStack.remove(0);
		touch();
	}

	public void setIndeterminate() {
		this.values.maxValue = 0;
		this.values.minValue = 0;
		this.values.curValue = 0;
	}

}
