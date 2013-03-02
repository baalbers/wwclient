package org.gvsig.sos.lib.impl.communication.remoteaccess;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * Class used to interact with remote HTTP servers
 * @author Alain Tamayo Fong (alain.tamayo@gmail.com)
 */
public class Downloader {

	//Logger object to report events	
	/*************************************************************************\
	 * 							PUBLIC METHODS								 *
	\*************************************************************************/ 
	/**
	 * Get remote input stream for an URL string using HTTP POST or GET
	 * @param urlString - URL of the requested file
	 * @param data - POST request
	 *  @return 
	 * 		Input stream for the requesred URL
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 */
	public synchronized InputStream getRemoteInputStream(String urlString, String data) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		if (!urlString.startsWith("http://")) urlString = "http://" + urlString;

		DataInputStream is = null;
		URL url = new URL(urlString);
		if (urlString.endsWith("&") || urlString.endsWith("?"))
			urlString = urlString.substring(0, urlString.length()-1);

		HttpURLConnection connection = null;

		//Disable https validation if necessary
		if (url.getProtocol().equals("https"))
			disableHttpsValidation();
		
		connection = (HttpURLConnection)url.openConnection();

		if (data != null){
			// Send request data if using HTTP POST
			sendPostData(connection, data);	
			is = new DataInputStream(connection.getInputStream());
		}
		else is = new DataInputStream(url.openStream());
		
		return is;		
	}
	/**
	 * Get remote input stream for an URL string using HTTP GET
	 * @param urlString - URL of the requested file
	 * @return 
	 * 		Input stream for the requesred URL
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public synchronized InputStream getRemoteInputStream(String urlString) throws KeyManagementException, NoSuchAlgorithmException, IOException {
		return getRemoteInputStream(urlString, null);
	}
	
	/*************************************************************************\
	 * 							PRIVATE METHODS								 *
	\*************************************************************************/ 
	/*
	 * Disable HTTPS validation on the client
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	private static void disableHttpsValidation() throws KeyManagementException, NoSuchAlgorithmException{
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkClientTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
					public void checkServerTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
				}
		};

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	/*
	 * 
	 * @param connection
	 * @param data
	 * @throws IOException
	 */
	private void sendPostData(HttpURLConnection connection, String data) throws IOException {
		OutputStreamWriter os;
		//connection.setRequestProperty("SOAPAction","post");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
		os = new OutputStreamWriter(connection.getOutputStream());
		os.write(data);
		os.close();	
	}

}
