package org.gvsig.tools.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;

import org.gvsig.tools.observer.Observable;

public interface FolderSet extends Observable {
	
	public interface FolderEntry {
		public File getFolder();
		public String getLabel() ;
	}
	public void setDefaultFolder(File defaultFolder);
	
	public File getDefaultFolder();
	
	public File asFile();
	
	public void add(File folder);
	
	public void add(File folder, String description);
	
	public void clear();
	
	public void remove(File folder);
	
	public void set(File folder);
	
	public Iterator iterator(); // over FolderEntry
	
	public File[] listFiles();
	
	public File[] listFiles(FileFilter filter);

	public File[] listFiles(FilenameFilter filter);
	
	public String[] list();
	
	public String[] list(FilenameFilter filter);
	
	public boolean isDirectory();
	
	public boolean isFile();
	
	public String getName();
	
	public String getParent();
	
	public File getParentFile();
	
	public String getPath();
	
	public File getCanonicalFile() throws IOException ;
	
	public String getCanonicalPath() throws IOException ;
	
	public boolean canRead();
	
	public boolean canWrite();
	
	public boolean exists() ;
	
	public File getAbsoluteFile();
	
	public String getAbsolutePath();
}
