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
package org.gvsig.sos.lib.impl;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.api.SOSException;
import org.gvsig.sos.lib.api.SOSManager;
import org.gvsig.sos.lib.api.client.SOSClient;
import org.gvsig.sos.lib.impl.exceptions.CreationException;
import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.exception.DynFieldNotFoundException;
import org.gvsig.tools.extensionpoint.ExtensionPoint;
import org.gvsig.tools.extensionpoint.ExtensionPointManager;
import org.gvsig.tools.service.Service;
import org.gvsig.tools.service.ServiceException;


/**
 * Register and Instance all SOS RemoteClient classes
 * @author <a href="mailto:Pablo.Viciano@uji.es">Pablo Viciano Negre</a>
 * @author <a href="mailto:pupo@uji.es"> Luis E. Rodríguez </a>
 * @version $Id$
 *
 */
public class DefaultSOSManager implements SOSManager{
    private static final String SOS_MANAGER_EXTENSION_POINT = "SOS_ExtensionPoint";
    private static final String CLIENT_SOS_EXTENSION_POINT = "Client_SOS_ExtensionPoint";
	private static final String SERVICE_NAME = "SOSClient";
    
    private ExtensionPointManager extensionPoints = ToolsLocator.getExtensionPointManager();

    /**
     * Register SOSClient class
     * @param clazz
     */
    public void registerSOSClient(@SuppressWarnings("rawtypes") Class clazz) {
        if (!SOSClient.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(clazz.getName()
                    + " must implement the SOSClient class");
        }
        ExtensionPoint extensionPoint = extensionPoints.add(SOS_MANAGER_EXTENSION_POINT, "");
        extensionPoint.append(CLIENT_SOS_EXTENSION_POINT, "", clazz);    
        
    }
    
    /*
     * 
     * Create components
     */
    
    /**
     * Create a SOSClient instance with a host
     * @param host
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws IllegalArgumentException 
     * @throws SecurityException 
     */
    public SOSClient createSOSClient(URL host, File cacheFolder) throws SOSException{
        ExtensionPoint ep = extensionPoints.add(SOS_MANAGER_EXTENSION_POINT);
        SOSClient client;
		try {
			client = (SOSClient)ep.create(CLIENT_SOS_EXTENSION_POINT, new Object[] {host, cacheFolder});
		} catch (Exception e) {
			throw new CreationException(e);
		}
        return client;
    }
    
    
    public List getServiceNames() {
        List serviceNames = new ArrayList();
        serviceNames.add(SERVICE_NAME);
        return serviceNames;
      }

      public DynObject createServiceParameters(String serviceName)
          throws ServiceException {
        DynObjectManager manager = ToolsLocator.getDynObjectManager();
        DynClass definition = manager.get(SERVICE_NAME);
        if( definition == null ) {
          definition = manager.createDynClass(SERVICE_NAME, "Cliente SOS");
          definition.addDynFieldString("serviceName").setMandatory(true).setHidden(true);
          definition.addDynFieldURL("host").setMandatory(true);
          definition.addDynFieldFolder("cacheFolder").setMandatory(true);
          manager.add(definition);
        }
        return manager.createDynObject(definition);
      }

      public Service getService(DynObject parameters) throws ServiceException, DynFieldNotFoundException, SOSException {
        if( !SERVICE_NAME.equalsIgnoreCase(parameters.getDynClass().getName()) ) {
          throw new UnsupportedServiceException();
        }
        return this.createSOSClient((URL)parameters.getDynValue("host"), 
        		(File)(parameters.getDynValue("cacheFolder")));
      }

//      public SOSClient createSOSClient(URL host) throws SOSClientException {
//        SOSClient client = new DefaultSOSClient(host);
//        return client;
//      }

      public static class UnsupportedServiceException extends ServiceException {
        private static final long serialVersionUID = -8772686898071517290L;
        public UnsupportedServiceException() {
          super("Unsupported service", "_Unsupported_service", serialVersionUID);
        }
      }
    
}
