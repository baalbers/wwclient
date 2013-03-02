package org.gvsig.tools.packageutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.gvsig.tools.exception.BaseException;

public interface PackageManager {
	
	public static final String PACKAGE_EXTENSION = ".gvspkg";
	
	/**
	 * Package state default values.
	 */
	public static interface STATE {

		static final String DEVEL = "devel";
		static final String TESTING = "testing";
		static final String PILOT = "pilot";
		static final String PROTOTYPE = "prototype";
		static final String ALPHA = "alpha";
		static final String BETA = "beta";
		static final String RC = "RC";
		static final String FINAL = "final";
	}

	/**
	 * Supported operating system default values.
	 */
	public static interface OS {

		static final String ALL = "all";
		static final String LINUX = "lin";
		static final String WINDOWS = "win";
		static final String OSX_10_4 = "osx_10_4";
		static final String OSX_10_5 = "osx_10_5";
		static final String OSX_10_6 = "osx_10_6";
		static final String OSX_10_7 = "osx_10_7";
		static final String OSX_10_8 = "osx_10_8";
		static final String OSX_10_9 = "osx_10_9";
	}

	/**
	 * Supported architecture default values.
	 */
	public static interface ARCH {

		static final String ALL = "all";
		static final String X86 = "x86";
		static final String X86_64 = "x86_64";
		static final String PowerPC = "PowerPC";
	}

	/**
	 * Supported Java virtual machine version default values.
	 */
	public static interface JVM {

		static final String J1_5 = "j1_5";
		static final String J1_6 = "j1_6";
		static final String J1_7 = "j1_7";
		static final String J1_8 = "j1_8";
	}

	/**
	 * Create a empty Version instance
	 * 
	 * @return the version
	 */
	public Version createVersion();

	/**
	 * Create a empty PackageInfo instance
	 * 
	 * @return the package info
	 */
	public PackageInfo createPackageInfo();
	
	/**
	 * Create a PackageInfo and load contents from the specified InputStream using the
	 * default reader.
	 * 
	 * @param packegeinfo as URL
	 * @return the created packageInfo
	 * @throws BaseException 
	 */
	public PackageInfo createPackageInfo(InputStream packegeinfo) throws BaseException;

	public PackageInfo createPackageInfo(File packegeinfo) throws BaseException;

	/**
	 * Create a empty dependency object.
	 * 
	 * @return the dependency
	 */
	public Dependency createDependency();

	/**
	 * Create a dependency instance with the data of the package.
	 * 
	 * @param packageInfo
	 * @return a dependency of the package
	 */
	public Dependency createDependency(PackageInfo packageInfo);
	
	public Dependencies createDependencies();

	/**
	 * Return the OS code of the system
	 * 
	 * @return os code of the system
	 */
	public String getOperatingSystem();

	/**
	 * Returns the Architecture code of the system
	 * 
	 * @return architecture code of the system
	 */
	public String getArchitecture();
	

	public void writePacakgeInfo(PackageInfo packageInfo, File file) throws IOException ;

	public void writePacakgeInfo(PackageInfo pkg, OutputStream os) throws IOException ;
	
	public void readPacakgeInfo(PackageInfo packageInfo, File file) throws IOException ;

	public void readPacakgeInfo(PackageInfo pkg, InputStream os) throws IOException ;
}
