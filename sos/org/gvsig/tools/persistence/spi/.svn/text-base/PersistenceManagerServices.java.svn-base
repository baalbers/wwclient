package org.gvsig.tools.persistence.spi;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.persistence.PersistenceManager;
import org.gvsig.tools.persistence.exception.PersistenceException;

public interface PersistenceManagerServices extends PersistenceManager {

	public PersistentStateServices createState(Object theOriginal, PersistentContextServices context) throws PersistenceException;

	public PersistentContextServices getNewContext();
	
	public List getWrappedList(List list, PersistentContextServices context);

	public Map getWrappedMap(Map map, PersistentContextServices context);

	public Set getWrappedSet(Set set, PersistentContextServices context);
	
	public PersistentStateServices createPersistentState(	PersistentContextServices context);

	public PersistentStateServices createPersistentState(	PersistentContextServices context, PersistentIdentifier id);
	
	public Map getDomains();
	
	public List getDomainDefinitions(String domainName);

	
}
