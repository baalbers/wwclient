package org.gvsig.tools.persistence.impl;

import java.util.HashMap;

import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.impl.exception.PersistenceDuplicateDomainNameException;
import org.gvsig.tools.persistence.impl.exception.PersistenceInvalidDomainNameException;

public class Domains extends HashMap {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2234063626012628366L;

	public Domains() {
		super();
	}
	
	public void add(String name, String url) {
		this.put(name, url);
	}
	
	public String getUrl(String name) {
		return this.getUrl(name);
	}
	
	public Object put(String name, String url) {
		if (name == null) {
			throw new PersistenceInvalidDomainNameException();
		}
		String currentUrl = (String) super.get(name);
		// Error if the provided domain URL is not the same as the 
		// previously stored one for the same domain
		if ( currentUrl != null && !currentUrl.equals(url)) {
			throw new PersistenceDuplicateDomainNameException(name, currentUrl, url);
		}
		if( url == null ) {
			url = PersistenceManager.DEFAULT_DOMAIN_URL;
		}
		return super.put(name, url);
	}
	
}
