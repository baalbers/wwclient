
package org.gvsig.installer.lib.api;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.lang.Cloneable;
import org.gvsig.tools.task.SimpleTaskStatus;

import org.gvsig.tools.packageutils.PackageManager.ARCH;
import org.gvsig.tools.packageutils.PackageManager.JVM;
import org.gvsig.tools.packageutils.PackageManager.OS;
import org.gvsig.tools.packageutils.PackageManager.STATE;

/**
 * @deprecated use instead #org.gvsig.tools.packageutils.PackageInfo
 */
public interface PackageInfo extends Cloneable{


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
	 * @param version
	 * @deprecated Use {@link #setVersion(Version)}
	 */
	public void setVersion(String version);

	
	/**
	 * @return Gets the build number of the package.
	 * @deprecated use {@link #getVersion()}.getBuild()
	 */
	public int getBuild();

	/**
	 * @deprecated use {@link #getVersion()}
	 */
	public void setBuild(int build);

	/**
	 * Returns the supported gvSIG version.
	 * 
	 * @return the supported gvSIG version
	 * @deprecated use {@link #getApplicationVersion()}
	 */
	public String getGvSIGVersion();

	/**
	 * Sets the supported gvSIG version.
	 * 
	 * @param gvSIGVersion the supported gvSIG version
	 * @deprecated use {@link #setApplicationVersion(org.gvsig.tools.packageutils.Version)}
	 */
	public void setGvSIGVersion(String gvSIGVersion);


	 /**
	 * Returns the package bundle download {@link URL}.
	 *
	 * May be null if there is no remote URL to download the bundle.
	 *
	 * @return the package bundle download {@link URL}
	 * @deprecated use InstallManager
	 *
	 */
	public URL getDownloadURL(URL baseURL);

	/**
	 * Gets the ant script that has to be executed in the installation process.
	 * 
	 * @return the script.
	 * @deprecated use {@link #getPostInstallScript()} 
	 */
	public String getAntScript();

	/**
	 * Sets the ant script that can be executed in the installation process.
	 * 
	 * @param antScript The ant script to copy.
	 * @deprecated use {@link #setPostInstallScript(String)}
	 */
	public void setAntScript(String antScript);

	/**
	 * @deprecated use InstallManager
	 */
	public File downloadFile() throws BaseException;

	/**
	 * @deprecated use InstallManager
	 */
	public File downloadFile(SimpleTaskStatus taskStatus) throws BaseException;

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public void addFileToCopy(File file);

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public File getFileToCopy(int i);

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public void removeFileToCopy(File file);

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public void clearFilesToCopy();

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public List getFilesToCopy();

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public boolean removeInstallFolder(File folder);

	/**
	 * @deprecated use InstallManager.getPackageInfoFiles
	 */
	public boolean removeFilesFolder(File folder);

	/**
	 * @deprecated always return true
	 */
	public boolean isSigned();

	/**
	 * @deprecated do nothing
	 */
	public void checkSignature(byte[] pkgdata);

}
