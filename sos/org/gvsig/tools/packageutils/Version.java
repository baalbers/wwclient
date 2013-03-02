package org.gvsig.tools.packageutils;

import org.gvsig.tools.lang.Cloneable;

public interface Version extends Cloneable, org.gvsig.installer.lib.api.Version {

	public org.gvsig.installer.lib.api.Version parse(String version);

	public int getMajor();

	public int getMinor();

	public int getRevision();

	public String getClassifier();

	public int getBuild();

	public boolean check(String op, org.gvsig.installer.lib.api.Version other);

	public String fullFormat();
}
