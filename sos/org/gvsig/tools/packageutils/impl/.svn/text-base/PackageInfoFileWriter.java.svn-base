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

package org.gvsig.tools.packageutils.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.gvsig.tools.packageutils.PackageInfo;

/**
 * @author <a href="mailto:jpiera@gvsig.org">Jorge Piera Llodr&aacute;</a>
 */
public class PackageInfoFileWriter {

	public void write(PackageInfo packageInfo, String fileName)
			throws IOException {
		write(packageInfo, new File(fileName));
	}

	public void write(PackageInfo packageInfo, File file)
			throws IOException {
		write(packageInfo, new FileOutputStream(file));
	}

	public void write(PackageInfo pkg, OutputStream os) throws IOException {
		Properties props = new Properties();

		props.setProperty(PackageInfoTags.CODE, pkg.getCode());
		props.setProperty(PackageInfoTags.NAME, pkg.getName());
		props.setProperty(PackageInfoTags.DESCRIPTION, pkg.getDescription());
		props.setProperty(PackageInfoTags.VERSION, pkg.getVersion().toString());
		props.setProperty(PackageInfoTags.STATE, pkg.getState());
		props.setProperty(PackageInfoTags.OFFICIAL,
				Boolean.toString(pkg.isOfficial()));
		props.setProperty(PackageInfoTags.TYPE, pkg.getType());
		props.setProperty(PackageInfoTags.OS, pkg.getOperatingSystem());
		props.setProperty(PackageInfoTags.ARCHITECTURE, pkg.getArchitecture());
		props.setProperty(PackageInfoTags.JVM, pkg.getJavaVM());
		props.setProperty(PackageInfoTags.APPLICATION_VERSION, toStr(pkg.getApplicationVersion()));
		props.setProperty(PackageInfoTags.OWNER, toStr(pkg.getOwner()));
		props.setProperty(PackageInfoTags.CATEGORIES, toStr(pkg.getCategoriesAsString()));
		props.setProperty(PackageInfoTags.DEPENDENCIES, toStr(pkg.getDependencies()));
		props.setProperty(PackageInfoTags.SOURCES_URL, toStr(pkg.getSourcesURL()));
		props.setProperty(PackageInfoTags.WEB_URL, toStr(pkg.getWebURL()));
		props.setProperty(PackageInfoTags.DOWNLOAD_URL, toStr(pkg.getDownloadURLAsString()));
		props.setProperty(PackageInfoTags.OWNER_URL, toStr(pkg.getOwnerURL()));
		props.setProperty(PackageInfoTags.MODEL_VERSION, pkg.getModelVersion());
		props.store(os, "");
		os.close();
	}

	private String toStr(Object s) {
		return s == null ? "" : s.toString();
	}

}
