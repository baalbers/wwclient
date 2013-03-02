package org.gvsig.tools.task;

import org.gvsig.tools.ToolsLocator;

/**
 * 
 * @author jjdelcerro
 *
 * Abstract class for tasks, threads, that implements the interface MonitorableTask.  
 * This handle the status of the cancelationRequest flag and TaskStatus. 
 */
public class AbstractMonitorableTask extends AbstractCancellableTask  implements MonitorableTask{

	protected SimpleTaskStatus taskStatus = null;
	
	protected AbstractMonitorableTask(String taskName, boolean autoAddTaskStatus) {
		super();
		if( taskName != null ) {
			super.setName(taskName);
		}
		TaskStatusManager manager = ToolsLocator.getTaskStatusManager();
        this.taskStatus = manager.createDefaultSimpleTaskStatus(taskName);
        if( autoAddTaskStatus ) {
        	this.taskStatus.add();
        }
	}
	
	protected AbstractMonitorableTask(String taskName) {
		this(taskName, true);
	}
	
	protected AbstractMonitorableTask(boolean autoAddTaskStatus) {
		this(null, autoAddTaskStatus);
	}
	
	protected AbstractMonitorableTask() {
		this(null, true);
	}
	
	public void setTaskName(String name) {
		super.setName(name);
		this.taskStatus.setTitle(name);
	}
	
	public TaskStatus getTaskStatus() {
		return this.taskStatus;
	}
	
	public void cancelRequest() {
		super.cancelRequest();
		this.taskStatus.cancelRequest();
	}
	
	
}
