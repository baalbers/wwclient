/**
 * 
 */
package org.gvsig.sos.lib.api.client;

import java.io.File;
import java.util.List;

import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.tools.service.Service;

/**
 * This interface provides access to the functionality of a SOS client. There are 
 * several methods for accessing the information of a SOS server.
 * @author lrodriguez
 *
 */
public interface SOSClient extends Service{

   /**
    * Allows to connect to a SOS server for retrieving the capabilities document.
    */
   public void connect() throws SOSException;
   
   
   /**
    * Indicates to the client which directory to use for placing temporal data.
    */
   public void setTemporalFolder(File temporalFolder);
   
   /**
    * Retrieves the abstract information as advertised in  the capabilities document.
    * @return The abstract's information.
    * @throws SOSException 
    */
   public String getAbstract() throws SOSException;
   
   /**
    * Retrieves the list of keywords advertised in the capabilities document.
    * @return the list of keywords.
    * @throws SOSException 
    */
   public List<String> getKeywords() throws SOSException;
   
   /**
    * Retrieves the version information as advertised in the capabilities document.
    * @return the version of the service. 
    * @throws SOSException 
    */
   public String getVersion() throws SOSException;
   
   /**
    * Retrieves the list of offerings present in the SOS server.
    * @return the offerings available in the server.
    * @throws SOSException 
    */
   public List<Offering> getOfferings() throws SOSException;
   
   /**
    * Retrieves the information of the service provider of the SOS server.  
    * @return the information of the service provider.
    * @throws SOSException 
    */
   public ServiceProvider getProvider() throws SOSException;

   /**
    * Retrieves the server name information
    * @return the server name
    * @throws SOSException 
    */
   public String getName() throws SOSException;
   
}
