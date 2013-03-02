package org.gvsig.tools.observer;

import java.util.ArrayList;
import java.util.List;


public class ObservableHelper {

	private List observers = new ArrayList();
	
	public synchronized void addObserver(Observer o) {
		if( this.observers.contains(o) ) {
			return;
		}
		this.observers.add(o);
	}

	public synchronized void deleteObserver(Observer o) {
		this.observers.remove(o);
	}

	public synchronized void deleteObservers() {
		this.observers = new ArrayList();
	}

	public synchronized void notifyObservers(Observable observable, Object data) {
		for(int i =0; i<this.observers.size(); i++ ) {
			Observer o = (Observer) this.observers.get(i);
			o.update(observable, data);
		}

	}
}
