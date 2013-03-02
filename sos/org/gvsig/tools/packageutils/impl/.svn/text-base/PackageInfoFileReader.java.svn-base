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

package org.gvsig.tools.packageutils.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.gvsig.tools.packageutils.PackageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageInfoFileReader {

	private static final Logger logger = LoggerFactory
			.getLogger(PackageInfoFileReader.class);

	public void read(PackageInfo packageInfo, String fileName) throws IOException, FileNotFoundException {
		this.read(packageInfo, new File(fileName));
	}

	public void read(PackageInfo packageInfo, File file) throws IOException, FileNotFoundException {
		this.read(packageInfo, new FileInputStream(file));
	}

	public void read(PackageInfo packageInfo, InputStream is) throws IOException {
		Properties properties = new Properties();
		properties.load(is);
		is.close();
		read(packageInfo, properties);
	}
	
	public void read(PackageInfo packageInfo, Properties properties ) {

		packageInfo.setCode(properties.getProperty(PackageInfoTags.CODE));
		packageInfo.setName(properties.getProperty(PackageInfoTags.NAME));
		
		String pkgName = packageInfo.getName();
		
		packageInfo.setDescription(properties.getProperty(PackageInfoTags.DESCRIPTION));
		packageInfo.getVersion().parse(properties.getProperty(PackageInfoTags.VERSION));
		packageInfo.setType(properties.getProperty(PackageInfoTags.TYPE));
		packageInfo.setState(properties.getProperty(PackageInfoTags.STATE));
		packageInfo.setOfficial(Boolean.valueOf(properties.getProperty(PackageInfoTags.OFFICIAL)).booleanValue());
		packageInfo.setOperatingSystem(properties.getProperty(PackageInfoTags.OS));
		packageInfo.setArchitecture(properties.getProperty(PackageInfoTags.ARCHITECTURE));
		packageInfo.setJavaVM(properties.getProperty(PackageInfoTags.JVM));
		String value = properties.getProperty(PackageInfoTags.APPLICATION_VERSION);
		if( value == null ) {
			value = properties.getProperty(PackageInfoTags.GVSIG_VERSION);
		}
		packageInfo.getApplicationVersion().parse(value);
		packageInfo.setDownloadURL(properties.getProperty(PackageInfoTags.DOWNLOAD_URL));
		packageInfo.setModelVersion(properties.getProperty(PackageInfoTags.MODEL_VERSION));
		packageInfo.setOwner(properties.getProperty(PackageInfoTags.OWNER));
		packageInfo.setDependencies(properties.getProperty(PackageInfoTags.DEPENDENCIES));
		packageInfo.setSourcesURL(getUrl(properties, PackageInfoTags.SOURCES_URL, pkgName));
		packageInfo.setWebURL(getUrl(properties, PackageInfoTags.WEB_URL, pkgName));
		packageInfo.setOwnerURL(getUrl(properties, PackageInfoTags.OWNER_URL, pkgName));
		packageInfo.addCategoriesAsString(properties.getProperty(PackageInfoTags.CATEGORIES));
	}
	
	private URL getUrl(Properties properties, String name, String pkgName) {
		String s = properties.getProperty(name);
		if (s != null && s.length()==0 ) {
			URL url;
			try {
				url = new URL(s);
			} catch (MalformedURLException e) {
				logger.info("Malformed url for '"+name+"' in package '"+pkgName+"', url='"+s+"'.");
				return null;
			}
			return url;
		} else {
			return null;
		}
	}


}
