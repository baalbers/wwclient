package org.gvsig.installer.lib.api;

import org.gvsig.tools.lang.Cloneable;


/**
 * 
 * Este interface se mantiene aqui por compatibilidad con versiones anteriores.
 * 
 * @see #org.gvsig.tools.packageutils.Dependency
 * @deprecated use #org.gvsig.tools.packageutils.Dependency
 */
public interface Dependency extends Cloneable  {

	public final String REQUIRED = "required";
	public final String CONFLICT = "conflict";
	public final String RECOMMENDED = "recommended";

	public Dependency parse(String dependency);

	public String getType();

	public String getCode();

	public String getOp();

	public Version getVersion();

	public boolean match(String type, String code, Version version);
}
