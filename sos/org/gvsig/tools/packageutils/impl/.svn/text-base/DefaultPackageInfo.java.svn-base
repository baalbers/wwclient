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
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.exception.BaseException;
import org.gvsig.installer.lib.api.Dependencies;
import org.gvsig.tools.packageutils.PackageInfo;
import org.gvsig.tools.packageutils.PackageManager;
import org.gvsig.tools.packageutils.PackageManager.ARCH;
import org.gvsig.tools.packageutils.PackageManager.JVM;
import org.gvsig.tools.packageutils.PackageManager.OS;
import org.gvsig.tools.packageutils.PackageManager.STATE;
import org.gvsig.installer.lib.api.Version;
import org.gvsig.tools.task.SimpleTaskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:jpiera@gvsig.org">Jorge Piera Llodr&aacute;</a>
 */
public class DefaultPackageInfo implements PackageInfo {

    private static final Logger logger = LoggerFactory
        .getLogger(DefaultPackageInfo.class);

	public static interface PACKAGE_FILE_NAME_FIELDS {
		static final int GVSIG_VERSION = 0;
		static final int NAME = 1;
		static final int VERSION = 2;
		static final int BUILD = 3;
		static final int STATE = 4;
		static final int OS = 5;
		static final int ARCH = 6;
		static final int JVM = 7;
	}
	private static final String PACKAGE_NAME_FORMAT = "gvSIG-desktop-{0}-{1}-{2}-{4}-{5}-{6}-{7}.gvspkg";
	
	private static final String DEFAULT_MODEL_VERSION = "1.0.1";
	private static final String DEFAULT_TYPE = "unknow";
	
    private String code = null;
    private String name = null;
    private String description = null;
    private Version version = null;
    private boolean official;
    private String type = DEFAULT_TYPE;
    private boolean broken = false;

    private String state = STATE.DEVEL;
    private String operatingSystem = OS.ALL;
    private String architecture = ARCH.ALL;
    private String javaVM = JVM.J1_5;

    private String owner = "";
    private URL ownerURL = null;
    private URL sources = null;
    private Version applicationVersion = null;

    private String defaultDownloadURL = null;

    private String modelVersion = DEFAULT_MODEL_VERSION;
    private Dependencies dependencies = null;
    private List categories = null;

    private URL webURL = null;
    
    private String postInstallScript = null;
    
    private Map aditionalProperties = null;

    public DefaultPackageInfo() {
        super();
        PackageManager manager = ToolsLocator.getPackageManager();
        this.version = manager.createVersion().parse("0.0.1");
        this.applicationVersion = manager.createVersion().parse("0.0.1");
        this.dependencies = manager.createDependencies();
        this.categories = new ArrayList();
        this.aditionalProperties = new HashMap();
    }

    public String getCode() {
        return code;
    }

    public String getID() {
        String id =
            this.getCode() + "#" + this.getVersion() 
                + "#" + this.getOperatingSystem() + "#"
                + this.getArchitecture();
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Version getVersion() {
        return version;
    }
    
    public String getState() {
        return state;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVersion(Version version) {
        try {
            this.version = (Version) version.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setState(String state) {
    	if( isEmptyString(state) ) {
    		this.state = STATE.DEVEL;
    	} else {
    		this.state = state;
    	}
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
    	if( isEmptyString(operatingSystem) ) {
    		this.operatingSystem = OS.ALL;
    	} else {
    		this.operatingSystem = operatingSystem;
    	}
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
    	if( isEmptyString(architecture) ) {
    		this.architecture = ARCH.ALL;
    	} else {
    		this.architecture = architecture;
    	}
    }

    public String getJavaVM() {
        return javaVM;
    }

    public void setJavaVM(String javaVM) {
    	if( isEmptyString(javaVM) ) {
    		this.javaVM = JVM.J1_5;
    	} else {
    		this.javaVM = javaVM;
    	}
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
    	if( isEmptyString(type) ) {
    		this.type = DEFAULT_TYPE;
    	} else {
    		this.type = type;
    	}
    }

    public Version getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(Version applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public URL getDownloadURL() {
    	if( this.defaultDownloadURL == null ) {
    		return null;
    	}
    	try {
            return new URL(this.defaultDownloadURL);
        } catch (MalformedURLException e) {
        	return null;
//            throw new RuntimeException(
//                "Error converting to URL the package download url "+ this.defaultDownloadURL,
//                e);
        }
    }

    public String getDownloadURLAsString() {
        return this.defaultDownloadURL;
    }

    public void setDownloadURL(URL defaultDownloadURL) {
        this.defaultDownloadURL = defaultDownloadURL.toString();
    }

    public void setDownloadURL(String defaultDownloadURL) {
        this.defaultDownloadURL = defaultDownloadURL;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
    	if( isEmptyString(modelVersion) ) {
    		this.modelVersion = DEFAULT_MODEL_VERSION;
    	} else {
    		this.modelVersion = modelVersion;
    	}
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public URL getOwnerURL() {
        return ownerURL;
    }

    public void setOwnerURL(URL sources) {
        this.ownerURL = sources;
    }

    public URL getSourcesURL() {
        return sources;
    }

    public void setSourcesURL(URL sources) {
        this.sources = sources;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer(super.toString()).append(" (");

        append(buffer, PackageInfoTags.CODE, getCode());
        append(buffer, PackageInfoTags.NAME, getName());
        append(buffer, PackageInfoTags.DESCRIPTION, getDescription());
        append(buffer, PackageInfoTags.APPLICATION_VERSION, getApplicationVersion());
        append(buffer, PackageInfoTags.VERSION, getVersion());
        append(buffer, PackageInfoTags.OS, getOperatingSystem());
        append(buffer, PackageInfoTags.ARCHITECTURE, getArchitecture());
        append(buffer, PackageInfoTags.JVM, getJavaVM());
        append(buffer, PackageInfoTags.DOWNLOAD_URL, getDownloadURL());
        append(buffer, PackageInfoTags.STATE, getState());
        append(buffer, PackageInfoTags.OFFICIAL, Boolean.valueOf(isOfficial()));
        append(buffer, PackageInfoTags.TYPE, getType());
        append(buffer, PackageInfoTags.MODEL_VERSION, getModelVersion());
        append(buffer, PackageInfoTags.OWNER, getOwner());
        append(buffer, PackageInfoTags.OWNER_URL, getOwnerURL());
        append(buffer, PackageInfoTags.SOURCES_URL, getSourcesURL());
        append(buffer, PackageInfoTags.DEPENDENCIES, getDependencies());
        append(buffer, PackageInfoTags.WEB_URL, getWebURL());
        append(buffer, PackageInfoTags.CATEGORIES, getCategories());

        return buffer.append(')').toString();
    }

//    public String toStringCompact() {
//        // type code version state os arch jvm dep
//        return String.format(
//                "%1$-8.4s %2$-40s %3$-20.20s %4$-5.5s %5$-5.5s %6$-6.6s %7$-5.5s %8$s",
//                new Object[] {
//	                this.type, 
//	                this.code, 
//	                this.version, 
//	                this.state,
//	                this.operatingSystem, 
//	                this.architecture, 
//	                this.javaVM,
//	                this.dependencies
//                }
//        	);
//    }

    public String toStringCompact() {
        // type code version state os arch jvm dep
    	return 	strformat(this.type,-8,-4) + " " + 
			strformat(this.code,-40,0) + " " + 
			strformat(this.version,-20,-20) + " " + 
			strformat(this.state,-5,-5) + " " +
			strformat(this.operatingSystem,-5,-5) + " " + 
			strformat(this.architecture,-6,-6) + " " +
			strformat(this.javaVM,-5,-5) + " " +
			strformat(this.dependencies,-8,0);
    }

    private static final String SPACES256 = "                                                                                                                                                                                                                                                               ";
    
    private String strformat(Object o, int min, int max) {
    	String s;
    	boolean alignright = true;
    	if( o == null ) {
    		s = "null";
    	} else {
    		s = o.toString();
    	}
    	if( min < 0 ) {
    		min = - min;
    		alignright = false;
    	}
    	if( max == 0 ) {
    	    if( s.length() < min ) {
        		if( alignright ) {
        			s = SPACES256+s;
        			s = s.substring(s.length()-min);
        		} else {
        			s = (s + SPACES256).substring(0, min);
        		}
	    	}
    	} else {
    		if( max > 225) {
    			max = 256;
    		} else if( max < 0 ) {
    			max = -max;
        		alignright = false;
    		}
    		if( alignright ) {
    			if( s.length() > max ) {
		    		s = s.substring(0, max);
		    	}
	    	    if( s.length() < min ) {
	    			s = SPACES256.substring(0,min-s.length())+s;
		    	}
    		} else {
		    	if( s.length() > max ) {
		    		s = s.substring(0, max);
		    	}
		    	if( s.length() < min ) {
		    		s = s + SPACES256.substring(0,min-s.length());
		    	}
    		}
    	}
    	return s;
    }
	
    private DefaultPackageInfo append(StringBuffer buffer, String key,
        Object value) {
        buffer.append("\n\t").append(key).append(": ")
            .append(value == null ? "" : value);
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        DefaultPackageInfo other = (DefaultPackageInfo) super.clone();
        
        /*
         * If setDependencies is called with "" then
         * dependencies is set to null, so we must check this:
         */
        if (this.dependencies == null) {
            other.dependencies = null;
        } else {
            other.dependencies = (Dependencies) this.dependencies.clone();
        }

        other.version = (Version) this.version.clone();
        other.applicationVersion = (Version) this.applicationVersion.clone();
        other.categories = new ArrayList();
        other.categories.addAll(this.categories);
        other.aditionalProperties = new HashMap(this.aditionalProperties);
        return other;
    }


    public boolean matchID(String string) {
        String id = this.getID();
        String[] stringParts = string.split("#");

        switch (stringParts.length) {
        case 1:
            if (stringParts[0].equals(this.getCode())) {
                return true;
            } else {
                return false;
            }
        case 2:
            if (!stringParts[0].equals(this.getCode())) {
                return false;
            }
            Version version = new DefaultVersion();
            try {
                version.parse(stringParts[1]);
            } catch (InvalidParameterException ex) {
                return false;
            }

            if (version.equals(this.getVersion())) {
                return true;
            }
            return false;
        default:
            return string.equals(id);

        }

    }

    public Dependencies getDependencies() {
        return this.dependencies;
    }

    public void setDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public void setDependencies(String dependencies) {
        if ( isEmptyString(dependencies)) {
            this.dependencies = null;
        } else {
            this.dependencies = new DefaultDependencies().parse(dependencies);
        }
    }

    public boolean equals(Object obj) {
        PackageInfo other;
        try {
            other = (PackageInfo) obj;
        } catch (Exception e) {
            return false;
        }
        if (!code.equalsIgnoreCase(other.getCode())) {
            return false;
        }
        if (!version.check("=", other.getVersion())) {
            return false;
        }
        if (!operatingSystem.equalsIgnoreCase(other.getOperatingSystem())) {
            return false;
        }
        if (!applicationVersion.equals(other.getApplicationVersion())) {
            return false;
        }
        if (!state.equalsIgnoreCase(other.getState())) {
            return false;
        }
        if (!architecture.equalsIgnoreCase(other.getArchitecture())) {
            return false;
        }
        if (!javaVM.equalsIgnoreCase(other.getJavaVM())) {
            return false;
        }
        if (!type.equalsIgnoreCase(other.getType())) {
            return false;
        }
        if (official != other.isOfficial()) {
            return false;
        }
        return true;
    }

    public URL getWebURL() {
        return webURL;
    }

    public void setWebURL(URL webURL) {
        this.webURL = webURL;
    }

    public List getCategories() {
        return this.categories;
    }

    public void setCategories(List categoriesList) {
        for (int i = 0; i < categoriesList.size(); i++) {
            if (!this.categories.contains(categoriesList.get(i))) {
                this.categories.add(categoriesList.get(i));
            }
        }
    }

    public String getCategoriesAsString() {
        String categoriesString = "";
        for (int i = 0; i < this.categories.size(); i++) {
            if (i + 1 < this.categories.size()) {
                categoriesString += this.categories.get(i) + ", ";
            } else {
                categoriesString += this.categories.get(i);
            }
        }
        return categoriesString;
    }

    public void addCategoriesAsString(String categoriesString) {
        if (categoriesString == null) {
            return;
        }
        categoriesString.trim();
        String[] cadena = categoriesString.split(",");

        for (int i = 0; i < cadena.length; i++) {
            String trimCadena = cadena[i].trim();
            if ((!this.categories.contains(trimCadena)) && (trimCadena != "")) {
                this.categories.add(trimCadena);
            }
        }

    }

    public boolean isBroken() {
        if (this.broken) {
            return true;
        }
        // if( this.isOfficial() && !this.isSigned() ) {
        // return true;
        // }
        return false;
    }

	private boolean isEmptyString(String s) {
		if( s == null ) {
			return true;
		}
		return s.length()==0;
	}

	public String getPostInstallScript() {
		return this.postInstallScript;
	}

	public void setPostInstallScript(String script) {
		this.postInstallScript = script;
	}
	
	protected void setBroken(boolean broken) {
		this.broken = broken;
	}

	public void setValue(String name, Object value) {
		this.aditionalProperties.put(name, value);
	}

	public Object getValue(String name) {
		return this.aditionalProperties.get(name);
	}

	private Object[] getPackageNameFormatParameters() {
		Object[] parameters = new Object[8];
		parameters[PACKAGE_FILE_NAME_FIELDS.GVSIG_VERSION] = this.getApplicationVersion().toString();
		parameters[PACKAGE_FILE_NAME_FIELDS.NAME] = this.getCode();
		parameters[PACKAGE_FILE_NAME_FIELDS.VERSION] = this.getVersion();
		parameters[PACKAGE_FILE_NAME_FIELDS.BUILD] = new Integer(this.getVersion().getBuild());
		parameters[PACKAGE_FILE_NAME_FIELDS.STATE] = this.getState();
		parameters[PACKAGE_FILE_NAME_FIELDS.OS] = this.getOperatingSystem();
		parameters[PACKAGE_FILE_NAME_FIELDS.ARCH] = this.getArchitecture();
		parameters[PACKAGE_FILE_NAME_FIELDS.JVM] = this.getJavaVM();
		return parameters;
	}
	
	public String getPreferedPackageFileName() {
		Object[] parameters = getPackageNameFormatParameters();
		return MessageFormat.format(PACKAGE_NAME_FORMAT, parameters);
	}

	
	// 
	// =========================================================
	// 
	// Deprecated methods
	//
	
	
	public int getBuild() {
		return this.getVersion().getBuild();
	}

	public void setBuild(int build) {
		this.getVersion().setBuild(build);
	}

	public String getGvSIGVersion() {
		// return this.getApplicationVersion().toString();
	    Version v = this.getApplicationVersion();
	    return v.getMajor() + "." + v.getMinor() + "." + v.getRevision();
	}

	public void setGvSIGVersion(String gvSIGVersion) {
		this.getApplicationVersion().parse(gvSIGVersion);
	}

	public URL getDownloadURL(URL baseURL) {
		logger.info("Deprecated methos, ignore parameter baseURL.");
		return this.getOwnerURL();
	}

	public String getAntScript() {
		return this.getPostInstallScript(); 
	}

	public void setAntScript(String antScript) {
		this.setPostInstallScript(antScript);
	}

	public File downloadFile() throws BaseException {
		throw new UnsupportedOperationException();
	}

	public File downloadFile(SimpleTaskStatus taskStatus) throws BaseException {
		throw new UnsupportedOperationException();
	}

	public void addFileToCopy(File file) {
		throw new UnsupportedOperationException();
	}

	public File getFileToCopy(int i) {
		throw new UnsupportedOperationException();
	}

	public void removeFileToCopy(File file) {
		throw new UnsupportedOperationException();
	}

	public void clearFilesToCopy() {
		throw new UnsupportedOperationException();
	}

	public List getFilesToCopy() {
		throw new UnsupportedOperationException();
	}

	public boolean removeInstallFolder(File folder) {
		throw new UnsupportedOperationException();
	}

	public boolean removeFilesFolder(File folder) {
		throw new UnsupportedOperationException();
	}

	public boolean isSigned() {
		return true;
	}

	public void checkSignature(byte[] pkgdata) {
		// Do nothing
	}

    /* (non-Javadoc)
     * @see org.gvsig.installer.lib.api.PackageInfo#setVersion(java.lang.String)
     */
    public void setVersion(String version) {
        this.version.parse(version);
    }
}
