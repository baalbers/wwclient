package org.gvsig.tools.observer;

import org.gvsig.tools.observer.impl.DefaultComplexNotification;

public interface ComplexObservable {

    /**
	 * Disable the notification of events to registered Observers.
	 */
	void disableNotifications();

	/**
	 * Enable (default) the notification of events to registered Observers.
	 */
	void enableNotifications();

	/**
	 * Sets the Observable in complex notification mode. All notifications must
	 * be stored, until the mode ends, and then notify all Observers with all
	 * the notifications.
	 */
	void beginComplexNotification();

	    /**
     * Ends the complex notification mode. All notifications stored while in
     * complex notification mode, will be notified to the registered Observers.
     * <p>
     * If a observer is a {@link ComplexObserver}, it will be notified with a
     * single {@link DefaultComplexNotification} instead of each of the notifications.
     * </p>
     * <p>
     * Some important notes to take into account when calling this method.
     * <ul>
     * <li>
     * Observers must not rely in the order used to perform the notifications.
     * The notifications order is maintained, but the notification to all the
     * observers might be performed for each notification to all observers, or
     * for each observer all notifications.</li>
     * <li>
     * The notification process works as an atomic action, so if while an
     * {@link Observer} is processing a notification another {@link Observer} is
     * registered to the source {@link Observable}, it won't get any of the
     * notifications currently being notified, but future ones.</li>
     * </ul>
     * </p>
     */
	void endComplexNotification();
}
