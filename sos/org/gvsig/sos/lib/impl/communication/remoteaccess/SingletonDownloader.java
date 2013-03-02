package org.gvsig.sos.lib.impl.communication.remoteaccess;

public class SingletonDownloader extends Downloader{

	private static SingletonDownloader instance;
	
	private SingletonDownloader() {

	}
	
	public static SingletonDownloader getInstance(){
		if (instance == null)
			instance = new SingletonDownloader();
		
		return instance;
	}
	

}
