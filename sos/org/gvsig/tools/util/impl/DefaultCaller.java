package org.gvsig.tools.util.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.tools.util.Callable;
import org.gvsig.tools.util.Caller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCaller implements Caller {
	
	private static Logger LOG = LoggerFactory.getLogger(DefaultCaller.class);
	
	private boolean collectExceptions;
	private List callables;
	private List exceptions;
	
	public DefaultCaller() {
		this.collectExceptions = true;
		this.callables = new ArrayList();
		this.exceptions = null;
	}

	public boolean call() {
        List exceptions = new ArrayList();
        Iterator it = this.callables.iterator();
        while( it.hasNext() ) {
        	Callable callable = (Callable)(it.next());
        	try {
				callable.call();
			} catch (Exception e) {
				LOG.error("Exception in Callable",e);
				exceptions.add(new CallableException(callable,e));
			}
        }
        if( exceptions.size()>0 ) {
        	this.exceptions = exceptions;
        	return false;
        }
        return true;
	}

	public boolean getCollectExceptions() {
		return this.collectExceptions;
	}

	public void setCollectExceptions(boolean collectExceptions) {
		this.collectExceptions = collectExceptions;
	}

	public void add(Callable callable) {
		this.callables.add(callable);
	}

	public List getExceptions() {
		return this.exceptions;
	}

}
