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

import org.gvsig.sos.lib.api.SOSLocator;
import org.gvsig.sos.lib.api.SOSManager;
import org.gvsig.sos.lib.impl.objectmodel.DefaultSOSClient;
import org.gvsig.tools.library.AbstractLibrary;
import org.gvsig.tools.library.LibraryException;
//import org.gvsig.sos.lib.impl.client.DefaultSOSClient;
//import org.gvsig.sos.lib.impl.client.DefaultSOSStatus;
//import org.gvsig.sos.lib.impl.request.getobservation.DefaultComparisonFilter;
//import org.gvsig.sos.lib.impl.request.getobservation.DefaultSpatialFilter;
//import org.gvsig.sos.lib.impl.request.getobservation.DefaultTemporalFilter;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.comparison.DefaultComparisonBetweenOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.comparison.DefaultComparisonBinaryOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.comparison.DefaultComparisonLikeOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.comparison.DefaultComparisonNullOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.DefaultSpatialBinaryOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.DefaultSpatialDistanceBufferOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.DefaultSpatialDistanceOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.DefaultSpatialEnvelopeOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryInnerBoundaryPolygon;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryLineStringOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryLinearRingOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryOuterBoundaryPolygon;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryPointOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.spatial.geometry.DefaultGeometryPolygonOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalDurationOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalInstantOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalIntervalOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalPeriodOperator;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalTypeInstant;
//import org.gvsig.sos.lib.impl.request.getobservation.filters.temporal.DefaultTemporalTypePosition;


/**
 * 
 * @author <a href="mailto:Pablo.Viciano@uji.es">Pablo Viciano Negre</a>
 * @version $Id$
 *
 */
public class SOSLibrary extends AbstractLibrary {

    @SuppressWarnings("static-access")
     
    protected void doInitialize() throws LibraryException {
        SOSLocator.getInstance().registerSOSManager(DefaultSOSManager.class);  
    }

    @SuppressWarnings("static-access")
     
    protected void doPostInitialize() throws LibraryException {

    	SOSManager manager = SOSLocator.getInstance().getSOSManager();
        manager.registerSOSClient(DefaultSOSClient.class);
//        manager.registerSOSStatus(DefaultSOSStatus.class);
//        /*
//         * Register Filters
//         */
//        //Temporal
//        manager.registerTemporalFilter(DefaultTemporalFilter.class);
//        manager.registerTemporalOperatorInstant(DefaultTemporalInstantOperator.class);
//        manager.registerTemporalOperatorInterval(DefaultTemporalIntervalOperator.class);
//        manager.registerTemporalOperatorPeriod(DefaultTemporalPeriodOperator.class);
//        manager.registerTemporalOperatorDuration(DefaultTemporalDurationOperator.class);
//        manager.registerTemporalTypeInstantOperator(DefaultTemporalTypeInstant.class);
//        manager.registerTemporalTypePositionOperator(DefaultTemporalTypePosition.class);
//        
//        //Spatial
//        manager.registerSpatialFilter(DefaultSpatialFilter.class);
//        manager.registerSpatialOperatorBinary(DefaultSpatialBinaryOperator.class);
//        manager.registerSpatialOperatorDistance(DefaultSpatialDistanceOperator.class);
//        manager.registerSpatialOperatorEnvelope(DefaultSpatialEnvelopeOperator.class);
//        manager.registerSpatialOperatorDistanceBufferOperator(DefaultSpatialDistanceBufferOperator.class);
//        
//        manager.registerGeometryInnerBoundaryPolygon(DefaultGeometryInnerBoundaryPolygon.class);
//        manager.registerGeometryLinearRingOperator(DefaultGeometryLinearRingOperator.class);
//        manager.registerGeometryLineStringOperator(DefaultGeometryLineStringOperator.class);
//        manager.registerGeometryOuterBoundaryPolygon(DefaultGeometryOuterBoundaryPolygon.class);
//        manager.registerGeometryPointOperator(DefaultGeometryPointOperator.class);
//        manager.registerGeometryPolygonOperator(DefaultGeometryPolygonOperator.class);
//        
//        //Comparison
//        manager.registerComparisonFilter(DefaultComparisonFilter.class);
//        manager.registerComparisonBetweenOperator(DefaultComparisonBetweenOperator.class);
//        manager.registerComparisonBinaryOperator(DefaultComparisonBinaryOperator.class);
//        manager.registerComparisonComparisonNullOperator(DefaultComparisonNullOperator.class);
//        manager.registerComparisonLikeOperator(DefaultComparisonLikeOperator.class);
    }

}
