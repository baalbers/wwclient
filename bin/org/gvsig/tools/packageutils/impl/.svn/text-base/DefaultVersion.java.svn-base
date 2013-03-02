package org.gvsig.tools.packageutils.impl;

import java.security.InvalidParameterException;
import java.text.MessageFormat;

import org.gvsig.tools.packageutils.Version;

public class DefaultVersion implements Version {

	private int major = 0;
	private int minor = 0;
	private int rev = 0;
	private String classifier = null;
	private int build = 0;

	public DefaultVersion() {
		super();
	}

	protected DefaultVersion(int mayor, int minor, int rev, String classifier,
			int build) {
		this();
		this.major = mayor;
		this.minor = minor;
		this.rev = rev;
		this.classifier = classifier;
		this.build = build;
	}

	public org.gvsig.installer.lib.api.Version parse(String version) {
		if( version == null || version.length()==0 ) {
			this.major = 0;
			this.minor = 0;
			this.rev = 0;
			this.classifier = null;
			this.build = 0;
			return this;
		}
		// Formato: mayor.minor.rev-classifier-build

		String[] x = version.split("[.]");
		int lx = x.length;
		if (lx == 1) {
			this.major = parseIntClassifierAndBuild(x[0], version);
			this.minor = 0;
			this.rev = 0;
			this.classifier = null;
			this.build = 0;
		} else if (lx == 2) {
			this.major = Integer.parseInt(x[0]);
			this.minor = parseIntClassifierAndBuild(x[1], version);
			this.rev = 0;
			this.classifier = null;
			this.build = 0;
		} else if (lx == 3) {
			this.major = Integer.parseInt(x[0]);
			this.minor = Integer.parseInt(x[1]);
			this.rev = parseIntClassifierAndBuild(x[2], version);
		} else {
			throw new InvalidParameterException(version);
		}
		return this;
	}

	private int parseIntClassifierAndBuild(String s, String fullversion) {
		int value;

		String[] y = s.split("[-]");
		int ly = y.length;
		if (ly == 1) {
			value = Integer.parseInt(y[0]);
			this.classifier = null;
			this.build = 0;
		} else if (ly == 2) {
			value = Integer.parseInt(y[0]);
			try {
				this.build = Integer.parseInt(y[1]);
				this.classifier = null;
			} catch (NumberFormatException e) {
				this.build = 0;
				this.classifier = y[1];
			}
		} else if (ly == 3) {
			value = Integer.parseInt(y[0]);
			this.classifier = y[1];
			this.build = Integer.parseInt(y[2]);
		} else {
			throw new InvalidParameterException(fullversion);
		}
		return value;
	}

	public int getMajor() {
		return this.major;
	}
	

    public int getMayor() {
        return getMajor();
    }

	public int getMinor() {
		return this.minor;
	}

	public int getRevision() {
		return this.rev;
	}

	public String getClassifier() {
		return this.classifier;
	}

	public int getBuild() {
		return this.build;
	}

	public boolean check(String op, org.gvsig.installer.lib.api.Version other) {
		if ("=".equals(op) || "==".equals(op) || "-eq".equals(op)) {
			return this.fullFormat().compareTo(other.fullFormat()) == 0;
		}
		if (">".equals(op) || "-gt".equals(op)) {
			return this.fullFormat().compareTo(other.fullFormat()) > 0;
		}
		if (">=".equals(op) || "-ge".equals(op)) {
			return this.fullFormat().compareTo(other.fullFormat()) >= 0;
		}
		if ("<".equals(op) || "-lt".equals(op)) {
			return this.fullFormat().compareTo(other.fullFormat()) < 0;
		}
		if ("<=".equals(op) || "-le".equals(op)) {
			return this.fullFormat().compareTo(other.fullFormat()) <= 0;
		}
		return false;
	}

	public String toString() {
		if (this.classifier == null) {
			return MessageFormat.format("{0}.{1}.{2}-{3,number,####}", 
				new Object[] {
					new Integer(this.major), 
					new Integer(this.minor), 
					new Integer(this.rev),
					new Integer(this.build)
				}
			);
		} else {
			return MessageFormat.format("{0}.{1}.{2}-{3}-{4,number,####}",
				new Object[] {
					new Integer(this.major), 
					new Integer(this.minor), 
					new Integer(this.rev),
					this.classifier,
					new Integer(this.build)
				}
			);
		}
	}

	public String fullFormat() {
		if (this.classifier == null) {
			// classifier AAAA allows compare correctly tow versions
			return MessageFormat.format(
				"{0,number,0000}.{1,number,0000}.{2,number,0000}-AAAA-{3,number,0000}",
				new Object[] {
						new Integer(this.major), 
						new Integer(this.minor), 
						new Integer(this.rev),
						new Integer(this.build)
					}
				);
		} else {
			return MessageFormat.format(
				"{0,number,0000}.{1,number,0000}.{2,number,0000}-{3}-{4,number,0000}",
				new Object[] {
						new Integer(this.major), 
						new Integer(this.minor), 
						new Integer(this.rev),
						this.classifier,
						new Integer(this.build)
					}
				);
		}
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Object obj) {
		Version other = (Version) obj;
		if (this.major != other.getMajor()) {
			return false;
		}
		if (this.minor != other.getMinor()) {
			return false;
		}
		if (this.rev != other.getRevision()) {
			return false;
		}
		if (this.build != other.getBuild()) {
			return false;
		}
		if (this.classifier == null) {
			if (other.getClassifier() == null) {
				return true;
			} else {
				return false;
			}
		}
		if (!this.classifier.equalsIgnoreCase(other.getClassifier())) {
			return false;
		}
		return true;
	}
	
	public int hashCode() {
	    return (classifier == null ? 0 : classifier.hashCode()) +
	        (major<<13) + (minor<<19) + (rev<<25) + build;
	}

	public org.gvsig.installer.lib.api.Version setBuild(int build) {
		this.build = build;
		return this;
	}
}
