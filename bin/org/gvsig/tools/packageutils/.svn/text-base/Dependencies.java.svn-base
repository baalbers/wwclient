package org.gvsig.tools.packageutils;

import java.util.List;
import org.gvsig.tools.lang.Cloneable;

public interface Dependencies extends List, Cloneable, org.gvsig.installer.lib.api.Dependencies {
	public org.gvsig.installer.lib.api.Dependencies parse(String dependenies);

	public boolean match(String type, String code, org.gvsig.installer.lib.api.Version version);

	public org.gvsig.installer.lib.api.Dependency find(String type, String code, org.gvsig.installer.lib.api.Version version);
    public List findAll(String type, String code, org.gvsig.installer.lib.api.Version version);
	
}
