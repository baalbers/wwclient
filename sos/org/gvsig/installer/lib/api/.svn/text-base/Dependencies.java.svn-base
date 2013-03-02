package org.gvsig.installer.lib.api;

import java.util.List;

import org.gvsig.tools.lang.Cloneable;

/**
 * 
 * Este interface se mantiene aqui por compatibilidad con versiones anteriores.
 * 
 * @see #org.gvsig.tools.packageutils.Dependencies
 * @deprecated use #org.gvsig.tools.packageutils.Dependencies
 */
public interface Dependencies extends List, Cloneable  {
    
	public Dependencies parse(String dependenies);

	public boolean match(String type, String code, Version version);

    public Dependency find(String type, String code, Version version);
    public List findAll(String type, String code, Version version);
}
