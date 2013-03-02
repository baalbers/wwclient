package org.gvsig.sos.lib.impl.objectmodel;

import java.util.List;


import org.gvsig.sos.lib.api.client.ServiceProvider;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.AddressType;
import org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_ServiceProvider;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;

public class DefaultServiceProvider implements ServiceProvider {

	 Element_ServiceProvider provider;
	
	public DefaultServiceProvider(Element_Capabilities capDoc){
	  provider = (capDoc != null)? capDoc.getServiceProvider(): null;
	}
	
	public String getName() {
        if (provider!=null) {
        	return provider.getProviderName();
        }
        return "";
	}

	public String getPositionName() {
        if (provider!=null) {
        	return (provider.getServiceContact()!= null)? 
        			provider.getServiceContact().getPositionName(): "";
        }
        return "";
	}

	public String getPhone() {
        if (provider!=null) {
        	return (provider.getServiceContact()!= null
        			&& provider.getServiceContact().getContactInfo()!= null
        			&& provider.getServiceContact().getContactInfo().getPhone() != null
        			&& provider.getServiceContact().getContactInfo().getPhone().getFacsimileList()!= null)? 
        			provider.getServiceContact().getContactInfo().getPhone().getFacsimileList().toString(): "";
        }
        return "";
	}

	public String getAddress() {
        if (provider!=null) {
        	String sep = ", ";
        	AddressType address = (provider.getServiceContact()!= null
        			&& provider.getServiceContact().getContactInfo()!= null
        			&& provider.getServiceContact().getContactInfo().getAddress() != null)? 
        		    provider.getServiceContact().getContactInfo().getAddress(): null;
            String addressStr = "" + ((address.getDeliveryPointList()!=null)? address.getDeliveryPointList().toString(): "") 
            					+ sep 
                                + address.getAdministrativeArea() + sep
                                + address.getPostalCode() + sep 
                                + address.getCity() + sep
                                + address.getCountry();
            return addressStr;
        }
        return "";
	}

	public String getEmail() {
        if (provider!=null) {
        	String sep = ", ";
        	AddressType address = (provider.getServiceContact()!= null
        			&& provider.getServiceContact().getContactInfo()!= null
        			&& provider.getServiceContact().getContactInfo().getAddress() != null)? 
        		    provider.getServiceContact().getContactInfo().getAddress(): null;
            String addressStr = "" + ((address.getElectronicMailAddressList()!=null)?
            		delimitedStringFromList(address.getDeliveryPointList(), sep): "");
            return addressStr;
        }
        return "";
	}
	
	public String delimitedStringFromList(List<String> list, String delimiter) {
	     String result = "";
	     String sep = "";
	     for(String str: list){
	    	 result = result + sep + str;
	    	 sep = delimiter;
	     }
	     return result;
	}

}
