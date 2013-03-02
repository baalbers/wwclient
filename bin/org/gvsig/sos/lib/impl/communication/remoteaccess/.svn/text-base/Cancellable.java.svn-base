package org.gvsig.sos.lib.impl.communication.remoteaccess;

/**
 * <p>When a task is accessing to remote data, takes an indeterminate time, and occasionally gets locked. That's
 * the reason a task should support to be cancelable.</p>
 * <p><code>ICancellable</code> interface is designed for getting information about the cancellation of a
 * task of downloading remote information.</p>
 */
public interface Cancellable {
	/**
	 * <p>Returns <code>true</code> if a download task has been canceled.</p>
	 * 
	 * @return <code>true</code> if a download task has been canceled, otherwise <code>false</code>
	 */
	public boolean isCanceled();
}
