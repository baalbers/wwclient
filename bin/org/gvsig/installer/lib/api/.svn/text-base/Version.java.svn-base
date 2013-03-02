package org.gvsig.installer.lib.api;

import org.gvsig.tools.lang.Cloneable;


/**
 * 
 * Este interface se mantiene aqui por compatibilidad con versiones anteriores.
 * 
 * @see #org.gvsig.tools.packageutils.Version
 * @deprecated use #org.gvsig.tools.packageutils.Version
 * 
 */
public interface Version  extends Cloneable {

	public Version parse(String version);

	public int getMajor();
	
	/**
	 * @deprecated Use {@link #getMajor()}
	 */
    public int getMayor();

	public int getMinor();

	public int getRevision();

	public String getClassifier();

	public int getBuild();

	public boolean check(String op, Version other);

	public String fullFormat();

	/**
	 * @deprecated don't use, set only in parse 
	 */
	public Version setBuild(int build);

}
