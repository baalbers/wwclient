/* gvSIG. Geographic Information System of the Valencian Government
 *
 * Copyright (C) 2007-2008 Infrastructures and Transports Department
 * of the Valencian Government (CIT)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 */

/*
 * AUTHORS (In addition to CIT):
 * 2010 {Prodevelop}   {Task}
 */

package org.gvsig.tools.packageutils;

import java.net.URL;
import java.util.List;

import org.gvsig.installer.lib.api.Version;
import org.gvsig.installer.lib.api.Dependencies;


public interface PackageInfo extends org.gvsig.installer.lib.api.PackageInfo {


	/**
	 * @return Gets the code of the package.
	 */
	public String getCode();

	public void setCode(String code);

	public String getID();

	/**
	 * @return Gets the name of the package.
	 */
	public String getName();

	public void setName(String name);

	/**
	 * @return Gets the description of the package.
	 */
	public String getDescription();

	public void setDescription(String description);

	/**
	 * @return Gets the version of the package.
	 */
	public Version getVersion();

	public void setVersion(Version version);

	/**
	 * @return Gets the state of the package.
	 * @see STATE
	 */
	public String getState();

	/**
	 * Sets the state of the package
	 * 
	 * @param state
	 * @see STATE
	 */
	public void setState(String state);

	/**
	 * @return Gets if the package is official.
	 */
	public boolean isOfficial();

	public void setOfficial(boolean official);

	/**
	 * @return Gets the type of the package.
	 */
	public String getType();

	public void setType(String type);

	/**
	 * Returns the supported operating system.
	 * 
	 * @return the supported operating system
	 * @see OS
	 */
	public String getOperatingSystem();

	/**
	 * Sets the supported operating system.
	 * 
	 * @param operatingSystem
	 *            the supported operating system
	 * @see OS
	 */
	public void setOperatingSystem(String operatingSystem);

	/**
	 * Returns the supported hardware architecture.
	 * 
	 * @return the supported hardware architecture
	 * @see ARCH
	 */
	public String getArchitecture();

	/**
	 * Sets the supported hardware architecture.
	 * 
	 * @param architecture
	 *            the supported hardware architecture
	 * @see ARCH
	 */
	public void setArchitecture(String architecture);

	/**
	 * Returns the supported java vm version.
	 * 
	 * @return the supported java vm version
	 * @see JVM
	 */
	public String getJavaVM();

	/**
	 * Sets the supported java vm version.
	 * 
	 * @param javaVM
	 *            the supported java vm version
	 * @see JVM
	 */
	public void setJavaVM(String javaVM);

	/**
	 * Returns the supported application version.
	 * 
	 * @return the supported application version
	 */
	public Version getApplicationVersion();

	/**
	 * Sets the supported application version.
	 * 
	 * @param verion
	 *            the supported application version
	 */
	public void setApplicationVersion(Version version);

	/**
	 * Returns the package bundle download {@link URL}.
	 *  
	 * May be null if there is no remote URL to download the bundle.
	 * 
	 * @return the package bundle download {@link URL}
	 */
	public URL getDownloadURL();

	public String getDownloadURLAsString();

	/**
	 * Sets the package bundle download {@link URL}. Optional.
	 * 
	 * @param defaultURL
	 *            the package bundle download {@link URL}
	 */
	public void setDownloadURL(URL defaultURL);

	public void setDownloadURL(String defaultDownloadURL);

	/**
	 * Returns the package info model version.
	 * 
	 * @return the package info model version
	 */
	public String getModelVersion();

	/**
	 * Sets the package info model version.
	 * 
	 * @param modelVersion
	 *            the package info model version
	 */
	public void setModelVersion(String modelVersion);

	public String getOwner();

	/**
	 * Sets the package owner.
	 * 
	 * @param owner
	 *            the package owner
	 */
	public void setOwner(String owner);

	/**
	 * Returns the owner's url {@link URL}.
	 * 
	 * @return the owner's url {@link URL}
	 */
	public URL getOwnerURL();

	/**
	 * Sets the package owner's url.
	 * 
	 * @param sources
	 *            the package owner's url
	 */
	public void setOwnerURL(URL sources);

	/**
	 * Returns the package source files url {@link URL}.
	 * 
	 * @return the package source files url {@link URL}
	 */
	public URL getSourcesURL();

	/**
	 * Sets the package sources.
	 * 
	 * @param sources
	 *            the package sources
	 */
	public void setSourcesURL(URL sources);

	/**
	 * Returns the package web url {@link URL}.
	 * 
	 * @return the package web url {@link URL}
	 */
	public URL getWebURL();

	/**
	 * Sets the package web url {@link URL}.
	 * 
	 * @param webURL
	 *            the package web url {@link URL}
	 */
	public void setWebURL(URL webURL);

	/**
	 * @param string
	 * @return
	 */
	public boolean matchID(String string);

	public Dependencies getDependencies();

	public void setDependencies(String dependencies);

	public void setDependencies(Dependencies dependencies);

	public String toStringCompact();

	public List getCategories();

	public void setCategories(List categoriesList);

	public String getCategoriesAsString();

	public void addCategoriesAsString(String categoriesString);

	public boolean isBroken();

	/**
	 * 
	 * @return
	 */
	public String getPostInstallScript();
	
	/**
	 * 
	 * @param script
	 * @return
	 */
	public void setPostInstallScript(String script);
	
	public void setValue(String name, Object value);
	
	public Object getValue(String name);
	
	public String getPreferedPackageFileName(); 
	

}
