package org.gvsig.sos.lib.api.client;

/**
 * This interface exposes the functionality for accessing the data of the service provider 
 * of the SOS server.
 * @author lrodriguez
 *
 */
public interface ServiceProvider {
	/**
	 * Gives the name of the service provider.
	 * @return the name of the provider.
	 */
   public String getName();
   /**
    * Gives the name of the position of the service provider.
    * @return the position name of the provider.
    */
   public String getPositionName();
   
   /**
    * Gives the phone number of the service provider.
    * @return a string with the phone of the provider
    */
   public String getPhone();
   
   /**
    * Gives the address of the service provider.
    * @return the contact address of the service provider
    */
   public String getAddress();
   
   /**
    * Gives the contact email of the service provider.
    * @return the contact email of the service provider.
    */
   public String getEmail();
}
