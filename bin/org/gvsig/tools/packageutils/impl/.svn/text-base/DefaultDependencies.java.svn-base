package org.gvsig.tools.packageutils.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.packageutils.Dependencies;
import org.gvsig.installer.lib.api.Dependency;
import org.gvsig.tools.packageutils.PackageManager;
import org.gvsig.installer.lib.api.Version;

public class DefaultDependencies extends ArrayList implements
		Dependencies {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6743931124069465522L;

	private Dependency createDependency() {
		PackageManager manager = ToolsLocator.getPackageManager();
		return manager.createDependency();
	}
	
	public Object clone() {
		PackageManager manager = ToolsLocator.getPackageManager();
		Dependencies other = manager.createDependencies();
		Iterator it = this.iterator();
		while( it.hasNext() ) {
			Dependency dependency = (Dependency) it.next();
			try {
				other.add(dependency.clone());
			} catch (CloneNotSupportedException e) {
				// This exception can by done
			}
		}
		return other;
	}
	

	public org.gvsig.installer.lib.api.Dependencies parse(String dependecies) {
		if (dependecies == null) {
			this.clear();
			return this;
		}
		dependecies = dependecies.trim();
		if (dependecies.equals("")) {
			this.clear();
			return this;
		}

		String[] x = dependecies.split(",");
		for (int i = 0; i < x.length; i++) {
			this.add(createDependency().parse(x[i]));
		}
		return this;
	}

	public String toString() {
		StringBuffer s = null;
		Iterator it = this.iterator();
		while (it.hasNext()) {
			if (s == null) {
				s = new StringBuffer();
			} else {
				s.append(", ");
			}
			s.append(it.next().toString());
		}
		if (s == null) {
			return "";
		}
		return s.toString();
	}

	public boolean contains(Object o) {
		if (!(o instanceof Dependency)) {
			return false;
		}
		Iterator it = this.iterator();
		while (it.hasNext()) {
			Dependency dep = (Dependency) it.next();
			if (dep.equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean match(String type, String code, Version version) {
		Iterator it = this.iterator();
		while (it.hasNext()) {
			Dependency dependency = (Dependency) it.next();
			if (dependency.match(type, code, version)) {
				return true;
			}
		}
		return false;
	}

	public Dependency find(String type, String code, Version version) {
		Iterator it = this.iterator();
		while (it.hasNext()) {
			Dependency dependency = (Dependency) it.next();
			if (dependency.match(type, code, version)) {
				return dependency;
			}
		}
		return null;
	}
	
    public List findAll(String type, String code, Version version) {
        
        List resp = null;
         Iterator it = this.iterator();
         while (it.hasNext()) {
             Dependency dependency = (Dependency) it.next();
             if (dependency.match(type, code, version)) {
                 if (resp == null) {
                     resp = new ArrayList();
                 }
                 resp.add(dependency);
             }
         }
         return resp;
     }


}
