package org.gvsig.tools.packageutils.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.gvsig.tools.exception.BaseException;
import org.gvsig.tools.packageutils.Dependencies;
import org.gvsig.tools.packageutils.Dependency;
import org.gvsig.tools.packageutils.PackageInfo;
import org.gvsig.tools.packageutils.PackageManager;
import org.gvsig.tools.packageutils.Version;

public class DefaultPackageManager implements PackageManager {

	public Version createVersion() {
		return new DefaultVersion();
	}

	public PackageInfo createPackageInfo() {
		return new DefaultPackageInfo();
	}

	public PackageInfo createPackageInfo(InputStream packegeinfo)
			throws BaseException {
		PackageInfo pkg = createPackageInfo();
		try {
			this.readPacakgeInfo(pkg, packegeinfo);
		} catch (IOException e) {
			throw new BaseIOException(e);
		}
		return pkg;
	}

	public PackageInfo createPackageInfo(File packegeinfo) throws BaseException {
		PackageInfo pkg = createPackageInfo();
		try {
			this.readPacakgeInfo(pkg, packegeinfo);
		} catch (IOException e) {
			throw new BaseIOException(packegeinfo, e);
		}
		return pkg;
	}

	public Dependency createDependency() {
		return new DefaultDependency();
	}

	public Dependency createDependency(PackageInfo packageInfo) {
		DefaultDependency dependency = (DefaultDependency) this.createDependency();
		dependency.fromPackageInfo(packageInfo);
		return dependency;
	}

	public Dependencies createDependencies() {
		return new DefaultDependencies();
	}
	
	public String getOperatingSystem() {
		String osname = System.getProperty("os.name");
		if (osname.toLowerCase().startsWith("linux")) {
			return OS.LINUX;
		}
		if (osname.toLowerCase().startsWith("window")) {
			return OS.WINDOWS;
		}
		return osname;
	}

	public String getArchitecture() {
		String osarch = System.getProperty("os.arch");
		if (osarch.toLowerCase().startsWith("i386")) {
			return ARCH.X86;
		}
		if (osarch.toLowerCase().startsWith("x86")) {
			return ARCH.X86;
		}
		if (osarch.toLowerCase().startsWith("amd64")) {
			return ARCH.X86_64;
		}
		return osarch;	}

	public void writePacakgeInfo(PackageInfo packageInfo, File file)
			throws IOException {
		PackageInfoFileWriter writer = new PackageInfoFileWriter();
		writer.write(packageInfo, file);
	}

	public void writePacakgeInfo(PackageInfo pkg, OutputStream os)
			throws IOException {
		PackageInfoFileWriter writer = new PackageInfoFileWriter();
		writer.write(pkg, os);
	}

	public void readPacakgeInfo(PackageInfo packageInfo, File file)
			throws IOException {
		PackageInfoFileReader reader = new PackageInfoFileReader();
		reader.read(packageInfo, file);
	}

	public void readPacakgeInfo(PackageInfo pkg, InputStream is)
			throws IOException {
		PackageInfoFileReader reader = new PackageInfoFileReader();
		reader.read(pkg, is);
	}

	public class BaseIOException extends BaseException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3154855738763990310L;
		
		public BaseIOException(Throwable cause) {
			super("Can't load package info","_Cant_load_package_info", serialVersionUID);
		}
		
		public BaseIOException(File file, Throwable cause) {
			super("Can't load package info %(file)","_Cant_load_package_info_XfileX", serialVersionUID);
			setValue("file",file);
		}
	}
	
}
