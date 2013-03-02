package org.gvsig.tools.packageutils;

import org.gvsig.tools.lang.Cloneable;
import org.gvsig.installer.lib.api.Version;

public interface Dependency extends Cloneable, org.gvsig.installer.lib.api.Dependency {
	public final String REQUIRED = "required";
	public final String CONFLICT = "conflict";
	public final String RECOMMENDED = "recommended";

	public org.gvsig.installer.lib.api.Dependency parse(String dependency);

	public String getType();

	public String getCode();

	public String getOp();

	public Version getVersion();

	public boolean match(String type, String code, Version version);
}
