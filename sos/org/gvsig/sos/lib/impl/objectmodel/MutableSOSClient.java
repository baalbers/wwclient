package org.gvsig.sos.lib.impl.objectmodel;

import java.io.File;
import java.util.List;

import org.gvsig.sos.lib.api.client.Offering;
import org.gvsig.sos.lib.api.client.SOSClient;
import org.gvsig.sos.lib.api.client.ServiceProvider;

public interface MutableSOSClient extends SOSClient {

	   public File getTemporalFolder();
	   
	   /**
	    * Sets the abstract information as advertised in  the capabilities document.
	    */
	   public void setAbstract(String abstractTxt);
	   
	   /**
	    * Sets the list of keywords advertised in the capabilities document.
	    */
	   public void setKeywords(List<String> keywords);
	   
	   /**
	    * Sets the version information as advertised in the capabilities document.
	    */
	   public void setVersion(String version);
	   
	   /**
	    * Sets the list of offerings present in the SOS server.
	    */
	   public void setOfferings(List<Offering> offerings);
	   
	   /**
	    * Sets the information of the service provider of the SOS server.  
	    */
	   public void setProvider(ServiceProvider provider);

}
