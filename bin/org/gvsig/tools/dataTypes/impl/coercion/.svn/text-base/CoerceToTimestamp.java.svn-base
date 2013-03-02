/* gvSIG. Desktop Geographic Information System.
 *
 * Copyright © 2007-2013 gvSIG Association
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
 * For any additional information, do not hesitate to contact us
 * at info AT gvsig.com, or visit our website www.gvsig.com.
 */
package org.gvsig.tools.dataTypes.impl.coercion;

import java.sql.Timestamp;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypesManager.Coercion;


/**
 * Utility class to force instantiation of Timestamp objects.
 * If a plugin provides a datasource with a timestamp type which
 * is not java.sql.Timestamp, then the plugin will have
 * to perform a conversion or coercion between
 * its Timestamp type and java.sql.Timestamp if it's not automatic.
 * 
 * Postgresql JDBC uses java.sql.Timestamp, so no problem
 * 
 * Oracle uses oracle.sql.TIMESTAMP which is automatically
 * converted, so this coercion is enough
 * 
 * @author jldominguez
 *
 */
public class CoerceToTimestamp extends CoerceToTime {

    public static final String NOW_STRING = "now";
    
    public Object coerce(Object value) throws CoercionException {
        if (value instanceof Timestamp) {
            return value;
        } else {
            String str = value.toString();
            Timestamp resp = null;
            
            // ----------- (1) Try normal parsing
            try {
                resp = Timestamp.valueOf(str); 
            } catch (Exception ex) {
                resp = null;
            }
            if (resp != null) {
                return resp;
            }
            // ----------- (2) Try parsing milliseconds
            try {
                long ms = Long.parseLong(str.trim());
                resp = new Timestamp(ms); 
            } catch (Exception ex) {
                resp = null;
            }
            if (resp != null) {
                return resp;
            }
            // ----------- (3) Accept "now"
            if (NOW_STRING.compareToIgnoreCase(str.trim()) == 0) {
                
                resp = new Timestamp(System.currentTimeMillis());
            }
            
            if (resp != null) {
                return resp;
            }

            /*
             * Finally try as time
             */
            return super.coerce(value);
        }
    }

}
