package org.gvsig.tools.util.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.gvsig.tools.observer.impl.BaseWeakReferencingObservable;
import org.gvsig.tools.util.FolderSet;

public class DefaultFolderSet extends BaseWeakReferencingObservable implements
		FolderSet {

	public class DefaultFolderEntry implements FolderEntry {
		File folder;
		String label;

		DefaultFolderEntry(File folder, String label) {
			this.folder = folder;
			this.label = label;
		}

		public boolean equals(Object obj) {
			return this.folder.equals(((FolderEntry) obj).getFolder());
		}

		public int hashCode() {
			return this.folder.hashCode();
		}

		public File getFolder() {
			return this.folder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	private Set folders = null;
	private File defaultFolder = null;

	public DefaultFolderSet() {
		folders = new LinkedHashSet();
	}

	public void add(File folder) {
		this.add(folder, null);
	}

	public void add(File folder, String description) {
		if (folder == null) {
			return;
		}
		if (folder.exists() && !folder.isDirectory()) {
			throw new IllegalArgumentException("folder required");
		}
		this.folders.add(new DefaultFolderEntry(folder, description));
		if( this.defaultFolder == null ) {
			this.defaultFolder = folder;
		}
 		this.notifyObservers();
	}

	public void clear() {
		this.folders.clear();
		this.defaultFolder = null;
		this.notifyObservers();
	}

	public void remove(File folder) {
		if (folder != null) {
			this.folders.remove(new DefaultFolderEntry(folder, null));
			if (folder.equals(this.defaultFolder)) {
				this.defaultFolder = null;
			}
			this.notifyObservers();
		}
	}

	public void set(File folder) {
		this.beginComplexNotification();
		this.clear();
		this.setDefaultFolder(folder);
		this.endComplexNotification();
	}

	public File[] listFiles() {
		List entries = new ArrayList();
		Iterator it = this.folders.iterator();
		while (it.hasNext()) {
			FolderEntry folderEntry = (FolderEntry) it.next();
			File[] files = folderEntry.getFolder().listFiles();
			if (files != null) {
			    entries.addAll(Arrays.asList(files));
			}
		}
		return (File[]) entries.toArray(new File[entries.size()]);
	}

	public File[] listFiles(FileFilter filter) {
		List entries = new ArrayList();
		Iterator it = this.folders.iterator();
		while (it.hasNext()) {
			FolderEntry folderEntry = (FolderEntry) it.next();
			File[] files = folderEntry.getFolder().listFiles(filter);
			if (files != null) {
			    entries.addAll(Arrays.asList(files));
			}
			
		}
		return (File[]) entries.toArray(new File[entries.size()]);
	}

	public File[] listFiles(FilenameFilter filter) {
		List entries = new ArrayList();
		Iterator it = this.folders.iterator();
		while (it.hasNext()) {
			FolderEntry folderEntry = (FolderEntry) it.next();
			File[] files = folderEntry.getFolder().listFiles(filter);
			if (files != null) {
			    entries.addAll(Arrays.asList(files));
			}
		}
		return (File[]) entries.toArray(new File[entries.size()]);
	}

	public Iterator iterator() {
		return this.folders.iterator();
	}

	public void setDefaultFolder(File defaultFolder) {
		this.add(defaultFolder);
		this.defaultFolder = defaultFolder;
	}

	public File getDefaultFolder() {
		if( this.defaultFolder == null ) {
			Iterator it = this.folders.iterator();
			if( it.hasNext() ) {
				this.defaultFolder = (File) it.next();
			}
		}
		return this.defaultFolder;
	}
	
	public File asFile() {
		return getDefaultFolder();
	}
	
	public String[] list() {
		List entries = new ArrayList();
		Iterator it = this.folders.iterator();
		while (it.hasNext()) {
			FolderEntry folderEntry = (FolderEntry) it.next();
			String[] files = folderEntry.getFolder().list();
			if (files != null) {
			    entries.addAll(Arrays.asList(files));
			}
		}
		return (String[]) entries.toArray(new String[entries.size()]);
	}
	
	public String[] list(FilenameFilter filter) {
		List entries = new ArrayList();
		Iterator it = this.folders.iterator();
		while (it.hasNext()) {
			FolderEntry folderEntry = (FolderEntry) it.next();
			String[] files = folderEntry.getFolder().list(filter);
			if (files != null) {
			    entries.addAll(Arrays.asList(files));
			}
		}
		return (String[]) entries.toArray(new String[entries.size()]);
	}

	public boolean isDirectory() {
		return true;
	}

	public boolean isFile() {
		return false;
	}

	public String getName() {
		return this.getDefaultFolder().getName();
	}

	public String getParent() {
		return this.getDefaultFolder().getParent();
	}

	public File getParentFile() {
		return this.getDefaultFolder().getParentFile();
	}

	public String getPath() {
		return this.getDefaultFolder().getPath();
	}

	public File getCanonicalFile() throws IOException {
		return this.getDefaultFolder().getCanonicalFile();
	}

	public String getCanonicalPath() throws IOException {
		return this.getDefaultFolder().getCanonicalPath();
	}

	public boolean canRead() {
		return this.getDefaultFolder().canRead();
	}

	public boolean canWrite() {
		return this.getDefaultFolder().canWrite();
	}

	public boolean exists() {
		return this.getDefaultFolder().exists();
	}

	public File getAbsoluteFile() {
		return this.getDefaultFolder().getAbsoluteFile();
	}

	public String getAbsolutePath() {
		return this.getDefaultFolder().getAbsolutePath();
	}
}
