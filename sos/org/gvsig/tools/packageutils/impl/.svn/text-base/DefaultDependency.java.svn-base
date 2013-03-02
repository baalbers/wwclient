package org.gvsig.tools.packageutils.impl;

import java.text.MessageFormat;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.exception.BaseRuntimeException;
import org.gvsig.tools.packageutils.Dependency;
import org.gvsig.tools.packageutils.PackageInfo;
import org.gvsig.installer.lib.api.Version;

public class DefaultDependency implements Dependency {

	protected String type;
	protected String code;
	protected String op;
	protected Version version;

	public DefaultDependency() {
		super();
		clear();
	}

	public DefaultDependency(org.gvsig.installer.lib.api.PackageInfo packageInfo) {
		this();
		this.fromPackageInfo(packageInfo);
	}
	
	public void fromPackageInfo(org.gvsig.installer.lib.api.PackageInfo packageInfo) {
		this.clear();
		this.code = packageInfo.getCode();
		this.type = "required";
		this.op = ">=";
		this.version = packageInfo.getVersion();
	}

	public void clear() {
		this.type = "required";
		this.code = "unknow";
		this.op = "=";
		this.version = ToolsLocator.getPackageManager().createVersion();
	}

	public org.gvsig.installer.lib.api.Dependency parse(String dependency) {
		// Parse a string with the dependency specification
		// (required|suggested|recommended|conflict)[:] code (=|>|<|>=|<=)
		// version
		if (dependency == null) {
			this.clear();
			return this;
		}
		dependency = dependency.trim();
		if (dependency.equals("")) {
			this.clear();
			return this;
		}
		
		String s = dependency;
		/*
		 * Remove special characters, so
		 * dependency description in pom.xml is not
		 * so fragile
		 */
        s = s.replace('\n', ' ');
        s = s.replace('\t', ' ');
        s = s.replace('\r', ' ');
        s = s.replace(':', ' ');
		
        /*
         * Added loop because replaceAll is not
         * exhaustive in this case
         */
        while (s.indexOf("  ") != -1) {
            s = s.replaceAll("  ", " ");
        }
		
		String[] x = s.split(" ");
		if (x.length != 4) {
			throw new InvalidDependencyFormatException(dependency);
		}
		
		this.type = x[0];
		this.code = x[1];
		this.op = x[2];
		this.version.parse(x[3]);
		return this;
	}

	private class InvalidDependencyFormatException extends BaseRuntimeException {

		private static final long serialVersionUID = 2856837862117653856L;

		private static final String message = "Error parsing dependecy '%(dependency)s'";

		private static final String KEY = "_Error_parsing_dependecy_XdependecyX";

		public InvalidDependencyFormatException(String dependency) {
			super(message, null, KEY, serialVersionUID);
			setValue("dependency", dependency);
		}
	}

	public String getType() {
		return this.type;
	}

	public String getCode() {
		return this.code;
	}

	public String getOp() {
		return this.op;
	}

	public Version getVersion() {
		return this.version;
	}

	public boolean match(String type, String code, Version version) {
		if (!this.type.equalsIgnoreCase(type)) {
			return false;
		}
		if (!this.code.equalsIgnoreCase(code)) {
			return false;
		}
		return version.check(this.op, this.version);
	}

	public String toString() {
		return MessageFormat.format("{0}: {1} {2} {3}",
			new Object[] {
				this.type, 
				this.code,
				this.op, 
				this.version.toString()
		}
		);
	}

	public Object clone() throws CloneNotSupportedException {
		DefaultDependency x = (DefaultDependency) super.clone();
		x.version = (Version) this.version.clone();
		return x;
	}

	public boolean equals(Object obj) {
		Dependency other;
		try {
			other = (Dependency) obj;
		} catch (Exception ex) {
			return false;
		}
		if (!this.code.equalsIgnoreCase(other.getCode())) {
			return false;
		}
		if (!this.type.equalsIgnoreCase(other.getType())) {
			return false;
		}
		if (!this.op.equalsIgnoreCase(other.getOp())) {
			return false;
		}
		if (!this.version.equals(other.getVersion())) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
	    return version.hashCode() + code.hashCode()
	        + type.hashCode() + op.hashCode();
	}
}
