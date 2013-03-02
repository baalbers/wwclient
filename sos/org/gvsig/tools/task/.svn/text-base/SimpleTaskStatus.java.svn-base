package org.gvsig.tools.task;

public interface SimpleTaskStatus extends TaskStatus {

    /**
     * Used by the task to set the title associated to the task.
     * It can't be changed.
     * 
     * @param tittle
     * 
     * @deprecated @see {@link SimpleTaskStatus#setTitle(String)}
     */
    public void setTittle(String tittle);

    /**
     * Used by the task to set the title associated to the task.
     * It can't be changed.
     * 
     * @param title
     */
    public void setTitle(String title);

	/**
	 * Used by the task to set a message associated to the current action of the task
	 *  
	 * @param message
	 */
	public void message(String message);
	
	/**
	 * Used by the task to set the value for min and max steps of the task.
	 * These are used with the "curvalue" to calculate the
	 * percentage of completion.
	 * 
	 * @param min
	 * @param max
	 */
    public void setRangeOfValues(long min, long max);

    /**
	 * Used by the task to set the current step of the task. 
	 * 
	 * @param value
	 * @see setRangeOfValues
	 * 
	 */
	public void setCurValue(long value);

	/**
	 * Used by the task to inform that it has terminated without errors.
	 */
	public void terminate();

	/**
	 * Used by the task to inform that it has terminated cancelled by the user
	 * or another task.
	 */
	public void cancel();

	/**
	 * Used by the task to inform that it has terminated with errors.
	 */
	public void abort();

	/**
	 * Remove this TaskStatus from the TaskStatusManager
	 */
	public void remove();
	
	/**
	 * Add this TaskStatus to the TaskStatusManager.
	 * If TaskStatus already in the manager this is updated.
	 */
	public void add();

	/**
	 * Used by the task to inform that this task es cacellable.
	 * 
	 * @param cancellable
	 */
	public void setCancellable(boolean cancellable);

	/**
	 * Used by the task to inform that this TaskStatus is removed
	 * from the manager automatically when the task is terminated and the manager
	 * need.
	 * 
	 * @param autoremove
	 */
	public void setAutoremove(boolean autoremove);
	
	/**
	 * Return the autoremove value of this TaskStatus.
	 * 
	 * @return
	 */
	public boolean getAutoRemove();
	
	
	/**
	 * Set the estatus of task to inteterminate.
	 * Reset values of range and current value.
	 * 
	 * @param Indeterminate
	 */
	public void setIndeterminate();
	 
	/**
	 * Este metodo guarda los valores de progreso y el mensaje de la tarea
     * para ser restaurados posteriormente invocando al metodo {@link #pop()}.
     * 
     * Los metodos {@link #push()} y {@link #pop()} estan pensado para gestionar 
     * subtareas dentro de un tareas, de forma que las subtareas puedan tener su 
     * propio progreso y mensaje mientras se estan ejecutando.
     * 
     * @see {@link #pop()}
	 */
	public void push();
	
	/**
	 * Este metodo esta pensado para restaurar los ultimos valores de progreso y
	 * mensaje que se guardaron invocando al metodo {@link #push()}.
	 * 
	 * @see {@link #push()}
	 */
	public void pop();
	
}
